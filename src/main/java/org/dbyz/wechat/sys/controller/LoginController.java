package org.dbyz.wechat.sys.controller;

import static org.dbyz.wechat.common.ConstantUtil.SYS_SESSION_USER;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dbyz.wechat.sys.entity.SysUser;
import org.dbyz.wechat.sys.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统登录控制
 *
 * @ClassName: LoginController
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
@Controller
@RequestMapping("/sys/")
public class LoginController {
	@Resource
	private LoginService loginService;

	@RequestMapping("/login")
	public String login(HttpServletRequest req, SysUser user) {
		Boolean login = loginService.login(user);
		if (login) {
			HttpSession session = req.getSession(true);
			session.setAttribute(SYS_SESSION_USER, user);
			return "sys/SysIndex";
		} else {
			return "forward:/index.jsp";
		}
	}
}