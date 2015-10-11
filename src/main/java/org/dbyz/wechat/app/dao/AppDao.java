package org.dbyz.wechat.app.dao;

public interface AppDao {

	/**
	 * 保存微信发来的XML消息
	 * 
	 * @Title: saveAppRequestXml
	 * @param @param requestXml
	 * @return: void
	 * @since V1.0
	 */
	Integer saveRequestXml(String requestXml);

	/**
	 * 保存发给微信的XML消息
	 * 
	 * @Title: saveResponseXml
	 * @param @param requestXml
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	Integer saveResponseXml(String responseXml);

}
