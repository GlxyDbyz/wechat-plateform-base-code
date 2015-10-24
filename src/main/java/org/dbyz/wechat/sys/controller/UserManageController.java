package org.dbyz.wechat.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/user/")
public class UserManageController {
	
	@RequestMapping("/registeredList")
	public String registeredList(){
		return "sys/user/sys-user-registered-list";
	}
}
