package org.dbyz.wechat.app.util;

import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.CustomMsg.CustomMsgType;
import org.dbyz.wechat.app.entity.CustomMsg.article;
import org.dbyz.wechat.app.entity.CustomMsg.news;
import org.dbyz.wechat.app.entity.ErrCode;
import org.dbyz.wechat.app.entity.Menu;
import org.dbyz.wechat.app.entity.Menu.Button;
import org.dbyz.wechat.app.entity.Menu.MenuType;
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
		Button b1s1 = new Button("员工信息绑定",MenuType.click, "user_bind", null, null);
		Button b1s2 = new Button("员工考勤",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/attendance/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button b1s3 = new Button("请假调休",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/leave/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button[] subButton1 = {b1s1,b1s2,b1s3};
		Button b1 = new Button("考勤相关",subButton1);

		Button b2s1 = new Button("物品申购",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/purchase/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button b2s2 = new Button("财务申请",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/financial/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button[] subButton2 = {b2s1,b2s2};
		Button b2 = new Button("财务相关",subButton2);

		Button b3s1 = new Button("公司公告",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/notice/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button b3s2 = new Button("会议安排",MenuType.view, null, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9244851e2a525760&redirect_uri=http://glxydbyz.sturgeon.mopaas.com/meeting/index&response_type=code&scope=snsapi_base&state=123#wechat_redirect", null);
		Button[] subButton3 = {b3s1,b3s2};
		Button b3 = new Button("公共管理",subButton3);
		
		Button[] button = {b1,b2,b3};
		Menu m = new Menu(button);
		
		System.out.println(JsonUtil.objectToJson(m));
	}
	
}
