package org.dbyz.wechat.app.service;

import javax.annotation.Resource;

import org.dbyz.wechat.app.dao.AppDao;
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

}
