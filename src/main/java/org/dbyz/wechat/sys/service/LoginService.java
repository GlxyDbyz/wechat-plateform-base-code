package org.dbyz.wechat.sys.service;

import static org.dbyz.wechat.sys.util.SysCoderUtil.encodePassword;

import java.util.HashMap;

import javax.annotation.Resource;

import org.dbyz.wechat.sys.dao.SysUserDao;
import org.dbyz.wechat.sys.entity.SysUser;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Resource
	private SysUserDao sysUserDao;

	public Boolean login(SysUser user) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("name", user.getName());
		param.put("password",
				encodePassword(user.getPassword(), user.getName()));
		SysUser userDb = sysUserDao.getByMap(param);
		return userDb != null;
	}

}
