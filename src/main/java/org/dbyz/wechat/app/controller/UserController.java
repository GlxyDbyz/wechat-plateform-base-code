package org.dbyz.wechat.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dbyz.wechat.app.entity.User;
import org.dbyz.wechat.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户相关类
 *
 * @ClassName: UserController
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a> 
 * @version: V1.0
 */
@Controller
public class UserController {
	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/check")
	public void entrance(HttpServletRequest req, HttpServletResponse resp,
			@RequestParam(required = true) Long id) {
		User user = userService.getUser(id);
		log.debug(user.toString());
	}
}
