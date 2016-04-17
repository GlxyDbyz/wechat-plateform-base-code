package org.dbyz.wechat.app.controller;

import static org.apache.commons.codec.digest.DigestUtils.shaHex;
import static org.dbyz.wechat.app.util.ConfigUtil.getString;
import static org.dbyz.wechat.app.util.JaxbUtil.bean2Xml;
import static org.dbyz.wechat.app.util.JaxbUtil.xml2Bean;
import static org.dbyz.wechat.app.util.ScheduledThreadPoolUtil.execute;

import java.io.IOException;
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
import org.dbyz.wechat.app.entity.RequestMsg.RequestEventType;
import org.dbyz.wechat.app.entity.RequestMsg.RequestMsgType;
import org.dbyz.wechat.app.entity.ResponseMsg;
import org.dbyz.wechat.app.entity.User;
import org.dbyz.wechat.app.service.AppService;
import org.dbyz.wechat.app.service.UserService;
import org.dbyz.wechat.common.utils.AjaxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微信入口类
 *
 * @ClassName: EntranceController
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
@Controller
public class AppController {
	private Logger logger = LoggerFactory.getLogger(AppController.class);

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
	public void entrance(HttpServletRequest req,
			final HttpServletResponse resp,
			@RequestParam(required = false) Integer platformType) {
		// 首次接入微信的验证方法（echostr：随即字符串特有的标志）
		if (req.getParameter("echostr") != null) {
			validate(req, resp);
			return;
		}

		// 读取微信发来的消息
		final RequestMsg request = getRequestMsg(req);
		// 生成并发送回复消息
		AjaxUtil.sendText(resp, generateResponseXml(request));
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
		if (request == null){
			return null;
		}
		
		// 用 request 作为 response 基础数据
		ResponseMsg response = new ResponseMsg(request);
		
		// 回复消息（全部为文本消息）
		String replyText = "";
		String openId = request.getFromUserName();
		User user = userService.getByOpenId(openId);
		
		String msgType = request.getMsgType();
		
		if(RequestMsgType.TEXT.getName().equals(msgType)){
			replyText = textRequest(request,user);				
		}
		
		if(RequestMsgType.EVENT.getName().equals(msgType)){
			replyText = eventRequest(request, replyText, openId, user);
		}
		
		if(RequestMsgType.IMAGE.getName().equals(msgType)){
			replyText = "暂时不支持图片消息!";
		}
		
		if(RequestMsgType.LOCATION.getName().equals(msgType)){
			replyText = "地理位置已经确认:"+request.getLabel()+", 经度:"+request.getLocation_Y()+", 纬度:"+request.getLocation_X();
		}
		
		if(RequestMsgType.LINK.getName().equals(msgType)){
			replyText = "已收到标题为:'"+request.getTitle()+"'的链接消息";
		}
		
		if(RequestMsgType.VOICE.getName().equals(msgType)){
			replyText = "收到的消息为:"+request.getRecognition();
		}
		
		if(RequestMsgType.VIDEO.getName().equals(msgType)){
			replyText = "暂时不支持视频消息!";
		}
		
		if(RequestMsgType.SHORTVIDEO.getName().equals(msgType)){
			replyText = "暂时不支持短视频消息!";
		}
		
		if(StringUtils.isEmpty(replyText)){
			return null;
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

	private String eventRequest(final RequestMsg request, String replyText,String openId, User user) {
		// 第一次关注公众号
		if (RequestEventType.SUBSCRIBE.getEvent().equals(request.getEvent())) {
			replyText = "感谢您关注Dbyz的测试公众号^_^,详细功能请使用菜单！";
			execute(new Runnable() {
				public void run() {
					userService.saveOrUpdatePlateformUserInfo(request.getFromUserName());
				}
			});
		}

		// 取消关注公众号
		if (RequestEventType.UNSUBSCRIBE.getEvent().equals(request.getEvent())) {
			userService.unBind(openId);
			return null;
		}
		
		// 上报地理位置
		if (RequestEventType.LOCATION.getEvent().equals(request.getEvent())) {
			replyText = "地理位置已经上报!";
		}
		
		// 点击事件
		if (RequestEventType.CLICK.getEvent().equals(request.getEvent())) {
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
				execute(new Runnable() {
					public void run() {
						appService.sendTemplateMsgDemo(request);
					}
				},1L);
			}
	
			// 点击的是发送客服文本消息click("sent_custom_text")
			if ("sent_custom_text".equals(request.getEventKey())) {
				replyText = "客服（文本）消息正在发送，请稍候!";
				execute(new Runnable() {
					public void run() {
						appService.sendCustomeTextMsgDemo(request);
					}
				},1L);
			}
	
			// 点击的是发送客服图文消息click("sent_custom_article")
			if ("sent_custom_article".equals(request.getEventKey())) {
				replyText = "客服（图文）消息正在发送，请稍候!";
				execute(new Runnable() {
					public void run() {
						appService.sendCustomeArticleMsgDemo(request);
					}
				},1L);
			}
		}
		
		if (RequestEventType.SCAN.getEvent().equals(request.getEvent()) || RequestEventType.SCANCODE_PUSH.getEvent().equals(request.getEvent()) || RequestEventType.SCANCODE_WAITMSG.getEvent().equals(request.getEvent())) {
			ArrayList<String> scanCodeInfos = request.getScanCodeInfo();
			for (String string : scanCodeInfos) {
				replyText += string+"\r\n";
			}
			replyText = replyText.replace("qrcode", "二维码:").replace("barcode", "条形码:");
		}
		
		// 微信模版消息发送回调
		if (RequestEventType.TEMPLATESENDJOBFINISH.getEvent().equals(request.getEvent())) {
			if("success".equals(request.getStatus())){
				// 模版消息接收成功回调
				logger.debug(request.getFromUserName() + " 模版消息接收成功");
			}else
			if("failed:user block".equals(request.getStatus())){
				// 模版消息接收失败回调
				logger.debug(request.getFromUserName()+ " 用户屏蔽了消息");
			}else{
				logger.debug(request.getFromUserName() + " 模版消息接收失败");
			}
			return null;
		}
		
		return replyText;
	}

	private String textRequest(final RequestMsg request,User user) {
		if(user!=null){
			return "请使用菜单功能，无需回复消息。谢谢合作！";
		}
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
			logger.debug("weixin URL is validate");
			AjaxUtil.sendText(response, request.getParameter("echostr"));
		}
	}
}