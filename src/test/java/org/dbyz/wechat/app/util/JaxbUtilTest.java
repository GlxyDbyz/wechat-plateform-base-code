package org.dbyz.wechat.app.util;

import javax.xml.bind.JAXBException;

import org.dbyz.wechat.app.entity.RequestMsg;
import org.junit.Test;

public class JaxbUtilTest {

	@Test
	public void test0() throws JAXBException {
		RequestMsg req = JaxbUtil.xml2Bean("<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>" + "</xml>",
				RequestMsg.class);
		System.out.println(req);
		// 为空的属性不生成XML
		System.out.println(JaxbUtil.bean2Xml(req, "utf-8"));
	}

	@Test
	public void test1() throws JAXBException {
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[gh_4d5718b0c8f6]]></ToUserName>"
				+ "<FromUserName><![CDATA[oVucYt94aTif_E-2-uq6tAgUDpvc]]></FromUserName>"
				+ "<CreateTime>1445094936</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[scancode_waitmsg]]></Event>"
				+ "<EventKey><![CDATA[scancode_waitmsg]]></EventKey>"
				+ "<ScanCodeInfo>"
				+ "<ScanType><![CDATA[qrcode]]></ScanType>"
				+ "<ScanResult><![CDATA[http://weixin.qq.com/r/gEw7I8LEdZ8KrYZA9xmS]]></ScanResult>"
				+ "</ScanCodeInfo>" + "</xml>";
		RequestMsg re = JaxbUtil.xml2Bean(xml, RequestMsg.class);
		System.out.println(re);
		System.out.println(re.getScanType());
		System.out.println(re.getScanResult());
	}
}
