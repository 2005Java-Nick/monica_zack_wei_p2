package com.revature.dao;

import com.revature.model.UserAccount;
import com.revature.struct.Token;

public interface DriverDAO {

	UserAccount getAvailableDriver();

	Integer countDriverOrders(UserAccount userAccount);

	Boolean onShiftToggle(Token token);

}