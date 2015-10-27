package org.dbyz.wechat.app.service;

import static org.dbyz.wechat.app.util.AppUtil.getPlateformUserInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dbyz.wechat.app.dao.UserDao;
import org.dbyz.wechat.app.entity.PlateformUserInfo;
import org.dbyz.wechat.app.entity.User;
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
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("openId", openId);
		PlateformUserInfo userInfoDb = userDao.getPlateformUserInfoList(param)
				.get(0);

		userInfoDb.setSubscribe(0);
		userDao.updatePlateformUserInfo(userInfoDb);

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
	public void saveOrUpdatePlateformUserInfo(String openId) {
		PlateformUserInfo userInfo = getPlateformUserInfo(openId);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("openId", openId);
		List<PlateformUserInfo> list = userDao.getPlateformUserInfoList(param);
		if (list == null || list.size() == 0) {
			userInfo.setInfoGetTime(new Date());
			userDao.savePlateformUserInfo(userInfo);
		} else if (list != null && list.size() == 1) {
			userInfo.setInfoGetTime(new Date());
			userDao.updatePlateformUserInfo(userInfo);
		} else if (list.size() > 1) {
			userDao.deletePlateformUserInfo(param);
			userInfo.setInfoGetTime(new Date());
			userDao.savePlateformUserInfo(userInfo);
		}
	}

	/**
	 * 获取用户信息并保存
	 * 
	 * @Title: addUserInfo
	 * @param @param fromUserName
	 * @return: void
	 * @since V1.0
	 */
	public void updatePlateformUserInfo(String openId) {
		PlateformUserInfo userInfo = getPlateformUserInfo(openId);
		userDao.updatePlateformUserInfo(userInfo);
	}

}
