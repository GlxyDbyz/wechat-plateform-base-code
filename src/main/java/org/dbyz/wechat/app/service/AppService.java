package org.dbyz.wechat.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.dbyz.wechat.app.dao.AppDao;
import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.RequestMsg;
import org.dbyz.wechat.app.entity.TemplateMsg;
import org.dbyz.wechat.app.entity.CustomMsg.CustomMsgType;
import org.dbyz.wechat.app.entity.CustomMsg.article;
import org.dbyz.wechat.app.entity.CustomMsg.news;
import org.dbyz.wechat.app.entity.CustomMsg.text;
import org.dbyz.wechat.app.entity.TemplateMsg.Data;
import org.dbyz.wechat.app.entity.TemplateMsg.ValueAndColor;
import org.dbyz.wechat.app.util.AppUtil;
import org.springframework.stereotype.Service;

@Service
public class AppService {

	@Resource
	private AppDao appDao;

	/**
	 * 保存微信发来的XML消息
	 * 
	 * @Title: saveAppRequestXml
	 * @param @param requestXml
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	public Integer saveRequestXml(String requestXml) {
		return appDao.saveRequestXml(requestXml);
	}

	/**
	 * 保存发给微信的XML消息
	 * 
	 * @Title: saveAppRequestXml
	 * @param @param requestXml
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	public Integer saveResponseXml(String responseXml) {
		return appDao.saveResponseXml(responseXml);
	}

	/**
	 * 发送模版消息演示
	 * 
	 * @Title: sentTemplateDemo
	 * @param
	 * @return: void
	 * @since V1.0
	 */
	public void sendTemplateMsgDemo(RequestMsg requestMsg) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		ValueAndColor first = TemplateMsg.createValueAndColor("这是一条演示模版消息", "#40F00F");
		ValueAndColor second = TemplateMsg.createValueAndColor( sf.format(new Date()), "#40F00F");
		ValueAndColor third = TemplateMsg.createValueAndColor("Dbyz", "#173177");
		Data data = TemplateMsg.createData();
		data.setFirst(first);
		data.setSecond(second);
		data.setThird(third);

		TemplateMsg t = new TemplateMsg(
				requestMsg.getFromUserName(),
				"ujoSpZTTSd_smfBt1Bv0TUw4znLFRDK6y2elsCrzCSI",
				"http://mp.weixin.qq.com/wiki/17/304c1885ea66dbedf7dc170d84999a9d.html", 
				data);
		AppUtil.sendTemplateMsg(t);
	}
	
	/**
	 * 发送客服文本消息
	 * 
	 * @Title: sendCustomeTextMsgDemo
	 * @param @param requestMsg    
	 * @return: void
	 * @since V1.0
	 */
	public void sendCustomeTextMsgDemo(RequestMsg requestMsg) {
		CustomMsg msg = new CustomMsg(requestMsg.getFromUserName(),
				CustomMsgType.TEXT.getMsgtype());
		msg.setText(new text("您好，欢迎关注我的微信公众平台测试号，这是一条客服消息!"));
		AppUtil.sendCustomerMsg(msg);
	}
	
	/**
	 * 发送客服图文消息
	 * 
	 * @Title: sendCustomeArticleMsgDemo
	 * @param @param requestMsg    
	 * @return: void
	 * @since V1.0
	 */
	public void sendCustomeArticleMsgDemo(RequestMsg requestMsg) {
		CustomMsg msg = new CustomMsg(requestMsg.getFromUserName(),
				CustomMsgType.NEWS.getMsgtype());
		CustomMsg.article[] articles = {
				new article(
						"您好，欢迎关注我的微信公众平台测试号",
						"http://mp.weixin.qq.com/wiki/static/assets/ac9be2eafdeb95d50b28fa7cd75bb499.png",
						"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html"),
				new article(
						"这是一条客服（图文）消息",
						"http://mp.weixin.qq.com/wiki/static/assets/ac9be2eafdeb95d50b28fa7cd75bb499.png", 
						"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html")
				};
		CustomMsg.news news = new news(articles);
		msg.setNews(news);
		AppUtil.sendCustomerMsg(msg);
	}

}
