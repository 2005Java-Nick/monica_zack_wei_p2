package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserAccountDAO;
import com.revature.model.AccountType;
import com.revature.model.UserAccount;
import com.revature.security.Encryption;
import com.revature.struct.Token;
import com.revature.struct.UserData;

@Service
public class AccountService {

	private UserAccountDAO userAccountDAO;

	@Autowired
	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	public Boolean hasPermission(Token token, String permission) {
		boolean hasPermission = false;
		List<AccountType> accountTypes = userAccountDAO.getAccountPermissions(token);
		for (AccountType a : accountTypes) {
			if (a.getType().equals(permission)) {
				hasPermission = true;
			}
		}

		return hasPermission;
	}

	public UserAccount login(UserData data) {

		UserAccount account = userAccountDAO.getUserAccount(data);
		if (account != null) {
			account.setSessionToken(Encryption.encryptString(account.getUsername() + account.getPassword()));
			userAccountDAO.setUserAccountSessionToken(account);
		}
		account.setPassword("HIDDEN");
		return account;
	}

	public UserAccount signup(UserAccount userAccount) {

		UserAccount account = userAccountDAO.createUserAccount(userAccount);
		if (account != null) {
			account.setSessionToken(Encryption.encryptString(account.getUsername() + account.getPassword()));
			userAccountDAO.setUserAccountSessionToken(account);
		}
		account.setPassword("HIDDEN");
		return account;
	}

	public UserAccount updateAccount(UserAccount userAccount) {
		return userAccountDAO.updateAccount(userAccount);
	}
}
