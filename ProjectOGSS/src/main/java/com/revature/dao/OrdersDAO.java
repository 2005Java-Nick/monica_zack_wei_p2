package com.revature.dao;

import java.util.List;

import com.revature.model.Invoice;
import com.revature.struct.Token;

public interface OrdersDAO {

	Invoice checkout(Invoice invoice);

	List<Invoice> getInvoices(Token token);

	List<Invoice> getDriverOrders(Token token);

	Invoice updateOrderDriver(Invoice invoice);

}