package org.dbyz.wechat.app.util;

import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.CustomMsg.CustomMsgType;
import org.dbyz.wechat.app.entity.CustomMsg.article;
import org.dbyz.wechat.app.entity.CustomMsg.news;
import org.dbyz.wechat.app.entity.CustomMsg.text;
import org.dbyz.wechat.app.entity.Menu;
import org.dbyz.wechat.app.entity.Menu.Button;
import org.dbyz.wechat.app.entity.Menu.MenuType;
import org.dbyz.wechat.app.entity.TemplateMsg;
import org.dbyz.wechat.app.entity.TemplateMsg.Data;
import org.dbyz.wechat.app.entity.TemplateMsg.ValueAndColor;
import org.junit.Test;

public class AppUtilTest {

	@Test
	public void testGetAccessToken() {
		System.out.println(AppUtil.getAccessToken());
	}

	@Test
	public void testCustomMsg1() {
		CustomMsg msg = new CustomMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				CustomMsgType.TEXT.getMsgtype());
		msg.setText(new text("您好!"));
		AppUtil.sendCustomerMsg(msg);
	}

	@Test
	public void testCustomMsg2() {
		CustomMsg msg = new CustomMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				CustomMsgType.NEWS.getMsgtype());
		CustomMsg.article[] articles = {
				new article(
						"微信开发客服消息测试",
						"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html",
						"http://avatar.csdn.net/2/3/5/1_qq1130141391.jpg"),
				new article(
						"你想知道的微信开发",
						"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html",
						"http://avatar.csdn.net/2/3/5/1_qq1130141391.jpg") };
		CustomMsg.news news = new news(articles);
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
		ValueAndColor first = TemplateMsg.createValueAndColor("你的一条请假申请通过了", "#173177");
		ValueAndColor second = TemplateMsg.createValueAndColor( "2015-10-09 08:12:21", "#173177");
		ValueAndColor third = TemplateMsg.createValueAndColor("王思贵总经理", "#173177");
		data.setFirst(first);
		data.setSecond(second);
		data.setThird(third);

		TemplateMsg t = new TemplateMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				"wSsqI_mTZGHqBHUDbFA5SSc0gTCHTXKTzUeRwnWpM38",
				"http://www.baidu.com", data);

		AppUtil.sendTemplateMsg(t);
	}
	
	@Test
	public void testCreateMenu() {
		
		/**
		 * 一级菜单1
		 */
		Button b1s1 = new Button("员工信息绑定",MenuType.click, "user_bind", null, null);
		Button b1s2 = new Button("员工考勤",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/attendance/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button b1s3 = new Button("请假调休",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/leave/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button[] subButton1 = {b1s1,b1s2,b1s3};
		Button b1 = new Button("考勤相关",subButton1);

		/**
		 * 一级菜单2
		 */
		Button b2s1 = new Button("物品申购",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/purchase/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button b2s2 = new Button("财务申请",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/financial/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button[] subButton2 = {b2s1,b2s2};
		Button b2 = new Button("财务相关",subButton2);

		/**
		 * 一级菜单3
		 */
		Button b3s1 = new Button("公司公告",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/notice/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button b3s2 = new Button("会议安排",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/meeting/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button[] subButton3 = {b3s1,b3s2};
		Button b3 = new Button("公共管理",subButton3);
		
		/**
		 * 一级菜单数组
		 */
		Button[] button = {b1,b2,b3};
		
		/**
		 * 整个menu
		 */
		Menu menu = new Menu(button);
		
		AppUtil.createMenu(menu);
	}
	
	@Test
	public void testgetMenu() {
		System.out.println(AppUtil.getMenu());
	}
}
