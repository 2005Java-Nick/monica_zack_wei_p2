package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.UserAccountDAO;
import com.revature.model.UserAccount;
import com.revature.model.UserData;

@Controller
public class AppController {

	private UserAccountDAO userAccountDAO;

	@Autowired
	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public List<UserAccount> getLogin(@RequestBody UserData data) {

		System.out.println("Test1");
		System.out.println(data.getUsername());
		System.out.println(data.getPassword());
		return userAccountDAO.getAllUserAccounts();
	}

}
