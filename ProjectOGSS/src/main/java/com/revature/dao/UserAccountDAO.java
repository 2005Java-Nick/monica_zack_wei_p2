package com.revature.dao;

import java.util.List;

import com.revature.model.AccountType;
import com.revature.model.UserAccount;
import com.revature.struct.Token;
import com.revature.struct.UserData;

public interface UserAccountDAO {

	UserAccount getUserAccount(UserData data);

	UserAccount getUserAccount(Token token);

	void setUserAccountSessionToken(UserAccount userAccount);

	UserAccount createUserAccount(UserAccount userAccount);

	Boolean accountExist(UserAccount userAccount);

	List<AccountType> getAccountPermissions(Token token);

	UserAccount updateAccount(UserAccount userAccount);

}