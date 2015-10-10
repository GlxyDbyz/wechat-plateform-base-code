package org.dbyz.wechat.app.util;

import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.TemplateMsg;
import org.dbyz.wechat.app.entity.TemplateMsg.Data;
import org.dbyz.wechat.app.entity.TemplateMsg.ValueAndColor;
import org.dbyz.wechat.app.enum_.CustomMsgType;
import org.junit.Test;

public class AppUtilTest {

	@Test
	public void testGetTokenAndCallbackIp() {
		System.out.println(AppUtil.getAccessToken());
	}

	@Test
	public void testCustomMsg1() {
		CustomMsg msg = new CustomMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				CustomMsgType.TEXT.getMsgtype());
		msg.setText(msg.new text("您好!"));
		AppUtil.sendCustomerMsg(msg);
	}

	@Test
	public void testCustomMsg2() {
		CustomMsg msg = new CustomMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				CustomMsgType.NEWS.getMsgtype());
		CustomMsg.article[] articles = {
				msg.new article(
						"微信开发客服消息测试",
						"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html",
						"http://avatar.csdn.net/2/3/5/1_qq1130141391.jpg"),
				msg.new article(
						"你想知道的微信开发",
						"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html",
						"http://avatar.csdn.net/2/3/5/1_qq1130141391.jpg") };
		CustomMsg.news news = msg.new news(articles);
		msg.setNews(news);
		AppUtil.sendCustomerMsg(msg);
	}

	@Test
	public void testGetTemplateId() {
		AppUtil.setPlateformIndustryType(1, 4);
		System.out.println(AppUtil.getTemplateMsgId("TM00015"));
	}

	@Test
	public void testTemplateMsg() {
		Data data = TemplateMsg.createData();
		ValueAndColor first = TemplateMsg.createValueAndColor("你的一条请假申请通过了",
				"#173177");
		ValueAndColor second = TemplateMsg.createValueAndColor(
				"2015-10-09 08:12:21", "#173177");
		ValueAndColor third = TemplateMsg.createValueAndColor("王思贵总经理",
				"#173177");
		data.setFirst(first);
		data.setSecond(second);
		data.setThird(third);

		TemplateMsg t = new TemplateMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				"wSsqI_mTZGHqBHUDbFA5SSc0gTCHTXKTzUeRwnWpM38",
				"http://www.baidu.com", data);

		AppUtil.sendTemplateMsg(t);
	}

}
