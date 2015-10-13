package org.dbyz.wechat.app.util;

import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.CustomMsg.CustomMsgType;
import org.dbyz.wechat.app.entity.CustomMsg.article;
import org.dbyz.wechat.app.entity.CustomMsg.news;
import org.dbyz.wechat.app.entity.ErrCode;
import org.dbyz.wechat.app.entity.Menu;
import org.dbyz.wechat.app.entity.Menu.Button;
import org.dbyz.wechat.app.entity.Menu.MenuType;
import org.dbyz.wechat.app.entity.Menu.SubButton;
import org.junit.Test;

public class JsonUtilTest {
	@Test
	public void test1() {
		CustomMsg msg = new CustomMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				CustomMsgType.NEWS.getMsgtype());
		CustomMsg.article[] articles = {new article(
				"微信API开发",
				"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html",
				"http://mp.weixin.qq.com/wiki/home/index.html") };
		CustomMsg.news news = new news(articles);
		msg.setNews(news);
		System.out.println(JsonUtil.objectToJson(msg));

		ErrCode err = JsonUtil.jsonToObject("{\"errcode\":0,\"errmsg\":\"ok\"}", ErrCode.class);
		System.out.println(err.getErrcode() + " " + err.getErrmsg());
	}
	
	@Test
	public void test2() {
		Menu m = new Menu();
		
		Button b1 = new Button();
		b1.setName("考勤相关");
		SubButton b1s1 = new SubButton("员工信息绑定",MenuType.click, "user_bind", null, null);
		SubButton b1s2 = new SubButton("员工考勤",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/attendance/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		SubButton b1s3 = new SubButton("请假调休",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/leave/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		SubButton[] subButton1 = {b1s1,b1s2,b1s3};
		b1.setSub_button(subButton1);
		
		Button b2 = new Button();
		b2.setName("财务相关");
		SubButton b2s1 = new SubButton("物品申购",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/purchase/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		SubButton b2s2 = new SubButton("财务申请",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/financial/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		SubButton[] subButton2 = {b2s1,b2s2};
		b2.setSub_button(subButton2);
		
		Button b3 = new Button();
		b3.setName("公共管理");
		SubButton b3s1 = new SubButton("公司公告",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/notice/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		SubButton b3s2 = new SubButton("会议安排",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/meeting/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		SubButton[] subButton3 = {b3s1,b3s2};
		b3.setSub_button(subButton3);
		
		Button[] button = {b1,b2,b3};
		m.setButton(button);
		System.out.println(JsonUtil.objectToJson(m));
	}
	
}
