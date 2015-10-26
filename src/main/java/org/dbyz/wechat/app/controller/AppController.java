package org.dbyz.wechat.app.controller;

import static org.apache.commons.codec.digest.DigestUtils.shaHex;
import static org.dbyz.wechat.app.util.ConfigUtil.getString;
import static org.dbyz.wechat.app.util.JaxbUtil.bean2Xml;
import static org.dbyz.wechat.app.util.JaxbUtil.xml2Bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.dbyz.wechat.app.entity.RequestMsg;
import org.dbyz.wechat.app.entity.RequestMsg.EventType;
import org.dbyz.wechat.app.entity.ResponseMsg;
import org.dbyz.wechat.app.entity.User;
import org.dbyz.wechat.app.service.AppService;
import org.dbyz.wechat.app.service.UserService;
import org.dbyz.wechat.app.util.SimpleThreadPoolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微信入口类
 *
 * @ClassName: EntranceController
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
@Controller
public class AppController {
	private Logger log = LoggerFactory.getLogger(AppController.class);

	private static final String TOKEN = getString("weixinToken");

	@Resource
	private UserService userService;

	@Resource
	private AppService appService;

	/**
	 * 入口方法
	 * 
	 * @Title: entrance
	 * @Description:
	 * @param @param request
	 * @param @param response
	 * @param @param platformType 平台类型 微信 或者 易信 （用于扩展）
	 * @param @return
	 * @param @throws IOException
	 * @return String
	 */
	@RequestMapping(value = "/app")
	public void entrance(HttpServletRequest req, HttpServletResponse resp,
			@RequestParam(required = false) Integer platformType) {
		// 首次接入微信的验证方法（echostr：随即字符串特有的标志）
		if (req.getParameter("echostr") != null) {
			validate(req, resp);
			return;
		}

		// 读取微信发来的消息
		RequestMsg request = getRequestMsg(req);
		// 生成并发送回复消息
		responseText(resp, generateResponseXml(request));

	}

	/**
	 * 对消息进行判断产生对应的回复消息(text消息)
	 * 
	 * @Title: generateResponse
	 * @param @param request
	 * @param @return
	 * @return: Response
	 * @since V1.0
	 */
	private String generateResponseXml(final RequestMsg request) {
		if (request == null)
			return null;

		// 用 request 作为 response 基础数据
		ResponseMsg response = new ResponseMsg(request);
		// 回复消息（全部为文本消息）
		String replyText = "";
		String openId = request.getFromUserName();
		User user = userService.getByOpenId(openId);

		// 已经绑定
		if (user != null) {
			replyText = "请使用菜单功能，无需回复消息。谢谢合作！";
		}

		// 没有绑定
		if (user == null) {
			// 文本消息 进行处理
			if (request.getMsgType().equals("text")) {
				replyText = textRequest(request);
			}
		}

		// 第一次关注公众号
		if (EventType.SUBSCRIBE.getEvent().equals(request.getEvent())) {
			replyText = "感谢您关注Dbyz的测试公众号^_^,详细功能请使用菜单！";
			SimpleThreadPoolUtil.execute(new Runnable() {
				public void run() {
					userService.addPlateformUserInfo(request.getFromUserName());
				}
			});
		}

		// 取消关注公众号
		if (EventType.UNSUBSCRIBE.getEvent().equals(request.getEvent())) {
			userService.unBind(openId);
		}

		// 点击的是用户绑定click("user_bind")
		if ("user_bind".equals(request.getEventKey())) {
			replyText = "回复：姓名@手机号 ，进行员工绑定，如：方大同@18888888888";
			if (user != null) {
				replyText = "亲爱的" + user.getName()
						+ "，您的绑定状态正常，可以使用所有的菜单功能，如遇特殊情况，请与Dbyz联系，谢谢合作。";
			}
		}

		// 点击的是发送模版消息click("sent_template")
		if ("sent_template".equals(request.getEventKey())) {
			replyText = "模版消息正在发送，请稍候!";
			SimpleThreadPoolUtil.execute(new Runnable() {
				public void run() {
					appService.sentTemplateMsgDemo(request);
				}
			});

			new Thread().start();
		}

		// 点击的是发送模版消息click("sent_custom_text")
		if ("sent_custom_text".equals(request.getEventKey())) {
			replyText = "客服（文本）消息正在发送，请稍候!";
			SimpleThreadPoolUtil.execute(new Runnable() {
				public void run() {
					appService.sentCustomeTextMsgDemo(request);
				}
			});
		}

		// 点击的是发送模版消息click("sent_custom_article")
		if ("sent_custom_article".equals(request.getEventKey())) {
			replyText = "客服（图文）消息正在发送，请稍候!";
			SimpleThreadPoolUtil.execute(new Runnable() {
				public void run() {
					appService.sentCustomeArticleMsgDemo(request);
				}
			});
		}

		response.setMsgType("text");
		response.setContent(replyText);
		String responseXml = null;

		try {
			responseXml = bean2Xml(response, "UTF-8");
			appService.saveResponseXml(responseXml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return responseXml;
	}

	private String textRequest(RequestMsg request) {
		String replyText;
		String content = request.getContent();

		// 绑定的消息处理 ： 方大同@18888888888
		if (content.contains("@")) {
			String[] param = content.split("@");
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", param[0]);
			map.put("phone", param[1]);
			map.put("openId", request.getFromUserName());
			// 绑定成功
			if (userService.bind(map) == 1) {
				replyText = "亲爱的" + param[0] + "，您已经绑定成功，现在您可以使用所有的菜单功能了。";
				// 绑定失败
			} else {
				replyText = "请回复正确的绑定信息，如遇到无法绑定的情况，请与Dbyz联系。";
			}
			// 非绑定用户的消息
		} else {
			replyText = "请回复：姓名@手机号 ，进行绑定，如：方大同@18888888888";
		}
		return replyText;
	}

	/**
	 * 读取微信发来的消息
	 * 
	 * @Title: prossageMsg
	 * @Description:
	 * @param @param request
	 * @param @return
	 * @param @throws IOException
	 * @param @throws UnsupportedEncodingException
	 * @return Request
	 */
	private RequestMsg getRequestMsg(HttpServletRequest request) {
		RequestMsg requestMsg = null;

		// 1、设置0.5M的缓冲区域（普通的消息足够了,可适当放大如1M，考虑服务器的配置）
		byte[] buffer = new byte[1024 * 512];
		ServletInputStream is;
		try {

			is = request.getInputStream();

			if (is != null) {
				// 2、读取数据到缓冲区
				int length = is.read(buffer);
				if (length > 0) {
					// 3、得到微信发来的xml请求数据
					String requestXml = new String(buffer, 0, length, "UTF-8");
					appService.saveRequestXml(requestXml);
					// 4、封装xml到JavaBean
					requestMsg = xml2Bean(requestXml, RequestMsg.class);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return requestMsg;
	}

	/**
	 * 首次接入微信的验证URL有效性
	 * 
	 * @Title: valid
	 * @Description:
	 * @param @param request
	 * @param @param response
	 * @return void
	 */
	public void validate(HttpServletRequest request,
			HttpServletResponse response) {
		String encryptStr = "";
		List<String> list = new ArrayList<String>();
		list.add(TOKEN);
		list.add(request.getParameter("timestamp"));
		list.add(request.getParameter("nonce"));
		Collections.sort(list, new Comparator<String>() {
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});

		for (String s : list) {
			encryptStr += s;
		}
		String encrypt = shaHex(encryptStr);
		if (encrypt.equals(request.getParameter("signature"))) {
			log.debug("weixin URL is validate");
			responseText(response, request.getParameter("echostr"));
		}
	}

	/**
	 * 返回数据给微信以验证URL
	 * 
	 * @Title: response
	 * @Description:
	 * @param @param response
	 * @param @param respText
	 * @return void
	 */
	public void responseText(HttpServletResponse response, String respText) {
		PrintWriter out;
		response.setCharacterEncoding("utf-8");
		try {
			out = response.getWriter();
			out.print(respText);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}