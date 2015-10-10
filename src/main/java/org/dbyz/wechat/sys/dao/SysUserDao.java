package org.dbyz.wechat.sys.dao;

import java.util.HashMap;

import org.dbyz.wechat.sys.entity.SysUser;

public interface SysUserDao {

	/**
	 * 查找用户
	 * 
	 * @Title: getUserByMap
	 * @param @param param
	 * @param @return
	 * @return: SysUser
	 * @since V1.0
	 */
	SysUser getByMap(HashMap<String, String> param);

}
