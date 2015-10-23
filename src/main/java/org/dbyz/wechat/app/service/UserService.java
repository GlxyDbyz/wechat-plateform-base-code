package org.dbyz.wechat.app.service;

import java.util.Map;

import javax.annotation.Resource;

import org.dbyz.wechat.app.dao.UserDao;
import org.dbyz.wechat.app.entity.PlateformUserInfo;
import org.dbyz.wechat.app.entity.User;
import org.dbyz.wechat.app.util.AppUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Resource
	private UserDao userDao;

	/**
	 * 通过openId查询用户
	 * 
	 * @Title: getByOpenId
	 * @param @param openId
	 * @param @return
	 * @return: User
	 * @since V1.0
	 */
	public User getByOpenId(String openId) {
		return userDao.getByOpenId(openId);
	}

	/**
	 * 用户绑定
	 * 
	 * @Title: bind
	 * @param @param param
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	public Integer bind(Map<String, String> param) {
		return userDao.bind(param);
	}

	/**
	 * 解除绑定
	 * 
	 * @Title: unBind
	 * @param @param openId
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	public Integer unBind(String openId) {
		return userDao.unBind(openId);
	}

	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	/**
	 * 获取用户信息并保存
	 * 
	 * @Title: addUserInfo
	 * @param @param fromUserName
	 * @return: void
	 * @since V1.0
	 */
	public void addUserInfo(String openId) {
		PlateformUserInfo  userInfo = AppUtil.getUserInfo(openId);
		userDao.saveUserInfo(userInfo);
	}

}
