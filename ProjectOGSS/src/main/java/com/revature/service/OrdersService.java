package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.OrdersDAO;
import com.revature.model.Invoice;

public class OrdersService {

	OrdersDAO ordersDAO;

	@Autowired
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	public Invoice checkout(Invoice invoice) {
		return ordersDAO.checkout(invoice);
	}

}
