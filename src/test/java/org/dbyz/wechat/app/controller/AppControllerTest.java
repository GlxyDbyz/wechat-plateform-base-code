package org.dbyz.wechat.app.controller;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;

public class AppControllerTest {
	@Test
	public void testWcMsg() {
		String urlStr = "http://localhost:8080/wechat-plateform-base-code/app";
		String xml = "<xml><ToUserName><![CDATA[gh_4d5718b0c8f6]]></ToUserName><FromUserName><![CDATA[oVucYt94aTif_E-2-uq6tAgUDpvc]]></FromUserName><CreateTime>1444492518</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[撒，点解啊岁的花季阿萨德]]></Content><MsgId>6204048124341425452</MsgId></xml>";
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(urlStr);
		try {
			RequestEntity requestEntity = new StringRequestEntity(xml,
					"application/xml", "utf-8");
			method.setRequestEntity(requestEntity);
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				
			}

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
	}
}
