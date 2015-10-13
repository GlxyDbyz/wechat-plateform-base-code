package org.dbyz.wechat.app.util;

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
}
