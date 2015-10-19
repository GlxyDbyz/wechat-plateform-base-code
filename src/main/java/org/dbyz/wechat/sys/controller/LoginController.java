package org.dbyz.wechat.sys.controller;

import static org.dbyz.wechat.common.ConstantUtil.SYS_SESSION_USER;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dbyz.wechat.sys.entity.SysUser;
import org.dbyz.wechat.sys.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest req, SysUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", "false");

		Boolean login = loginService.login(user);
		if (login) {
			HttpSession session = req.getSession(true);
			session.setAttribute(SYS_SESSION_USER, user);
			result.put("success", true);
		}
		return result;
	}

	@RequestMapping("/index")
	public String redirect(HttpServletRequest req, SysUser user) {
		HttpSession session = req.getSession(false);
		if (session.getAttribute(SYS_SESSION_USER) != null) {
			return "sys/sys-index";
		} else {
			return "redirect:/index.jsp";
		}
	}
}