package com.revature.service;

import com.revature.model.UserAccount;
import com.revature.struct.Token;
import com.revature.struct.UserData;

public interface AccountService {

	Boolean hasPermission(Token token, String permission);

	UserAccount login(UserData data);

	UserAccount signup(UserAccount userAccount);

	UserAccount updateAccount(UserAccount userAccount);

}