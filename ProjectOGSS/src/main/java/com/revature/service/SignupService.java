package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserAccountDAO;
import com.revature.model.UserAccount;
import com.revature.security.Encryption;

@Service
public class SignupService {
	UserAccountDAO userAccountDAO;

	@Autowired
	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	public UserAccount signup(UserAccount userAccount) {

		UserAccount account = userAccountDAO.createUserAccount(userAccount);
		if (account != null) {
			account.setSessionToken(Encryption.encryptString(account.getUsername() + account.getPassword()));
			userAccountDAO.setUserAccountSessionToken(account);
		}
		return account;
	}
}
