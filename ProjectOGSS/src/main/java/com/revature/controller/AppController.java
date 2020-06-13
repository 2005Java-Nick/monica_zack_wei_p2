package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.UserAccount;
import com.revature.service.LoginService;
import com.revature.service.SignupService;
import com.revature.struct.UserData;

@Controller
public class AppController {

	private LoginService loginService;
	private SignupService signupService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Autowired
	public void setSignupService(SignupService signupService) {
		this.signupService = signupService;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UserAccount getLogin(@RequestBody UserData data) {
		return loginService.login(data);
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	@ResponseBody
	public UserAccount signUp(@RequestBody UserAccount data) {
		System.out.println("SIGN UP RAN");
		return signupService.signup(data);
	}

}
