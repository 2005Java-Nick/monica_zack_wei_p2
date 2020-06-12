package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.UserAccount;
import com.revature.service.LoginService;
import com.revature.struct.UserData;

@Controller
public class AppController {

	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UserAccount getLogin(@RequestBody UserData data) {
		return loginService.login(data);
	}

}
