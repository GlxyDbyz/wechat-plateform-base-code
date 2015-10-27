package org.dbyz.wechat.app.dao;

import java.util.List;
import java.util.Map;

import org.dbyz.wechat.app.entity.PlateformUserInfo;
import org.dbyz.wechat.app.entity.User;

/**
 * 用户相关DAO
 *
 * @ClassName: UserDao
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
public interface UserDao {

	User getUser(Long id);

	User getByOpenId(String openId);

	/**
	 * 微信绑定
	 * 
	 * @Title: bind
	 * @param @param param
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	Integer bind(Map<String, String> param);

	/**
	 * 解除绑定
	 * 
	 * @Title: unBind
	 * @param @param openId
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	Integer unBind(String openId);

	/**
	 * 保存平台用户信息
	 * 
	 * @Title: saveUserInfo
	 * @param @param userInfo
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	Integer savePlateformUserInfo(PlateformUserInfo userInfo);

	/**
	 * 更新平台用户信息
	 * 
	 * @Title: updateUserInfo
	 * @param @param userInfo
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	Integer updatePlateformUserInfo(PlateformUserInfo userInfo);

	/**
	 * 获取userInfo
	 * 
	 * @Title: getPlatformUserInfoList
	 * @param @param param
	 * @param @return
	 * @return: List<PlateformUserInfo>
	 * @since V1.0
	 */
	List<PlateformUserInfo> getPlateformUserInfoList(Map<String, Object> param);

	/**
	 * 删除userInfo
	 * 
	 * @Title: deletePlateformUserInfo
	 * @param @param param
	 * @param @return
	 * @return: Integer
	 * @since V1.0
	 */
	Integer deletePlateformUserInfo(Map<String, Object> param);
}
