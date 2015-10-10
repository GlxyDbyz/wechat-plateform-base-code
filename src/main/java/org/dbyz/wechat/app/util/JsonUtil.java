package org.dbyz.wechat.app.util;

import org.dbyz.wechat.app.entity.CustomMsg;
import org.dbyz.wechat.app.entity.ErrCode;
import org.dbyz.wechat.app.enum_.CustomMsgType;

import com.alibaba.fastjson.JSON;
/**
 * FastJson 简单封装
 *
 * @ClassName: FastJsonUtil
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a> 
 * @version: V1.0
 */
public class JsonUtil {
	/**
	 * 对象转换成JSON
	 * 
	 * @Title: objectToJson
	 * @param @param t
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static <T> String objectToJson(T t) {
		return JSON.toJSONString(t);
	}

	/**
	 * JSON转化成对象
	 * 
	 * @Title: jsonToObject
	 * @param @param json
	 * @param @param clazz
	 * @param @return
	 * @return: T
	 * @since V1.0
	 */
	public static <T> T jsonToObject(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

	public static void main(String[] args) {
		CustomMsg msg = new CustomMsg("oVucYt94aTif_E-2-uq6tAgUDpvc",
				CustomMsgType.NEWS.getMsgtype());
		CustomMsg.article[] articles = { msg.new article(
				"微信API开发",
				"http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html",
				"http://mp.weixin.qq.com/wiki/home/index.html") };
		CustomMsg.news news = msg.new news(articles);
		msg.setNews(news);
		System.out.println(objectToJson(msg));

		ErrCode err = jsonToObject("{\"errcode\":0,\"errmsg\":\"ok\"}", ErrCode.class);
		System.out.println(err.getErrcode() + " " + err.getErrmsg());
	}
}
