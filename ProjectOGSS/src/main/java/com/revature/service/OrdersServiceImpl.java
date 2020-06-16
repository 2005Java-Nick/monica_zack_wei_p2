package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.OrdersDAO;
import com.revature.model.Invoice;
import com.revature.struct.Token;

@Service
public class OrdersServiceImpl implements OrdersService {

	private OrdersDAO ordersDAO;

	@Autowired
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	@Override
	public Invoice checkout(Invoice invoice) {
		return ordersDAO.checkout(invoice);
	}

	@Override
	public List<Invoice> getInvoices(Token token) {
		List<Invoice> results = ordersDAO.getInvoices(token);
		for (Invoice res : results) {
			res.getDriver().setUsername("HIDDEN");
			res.getDriver().setPassword("HIDDEN");
			res.getCustomer().setUsername("HIDDEN");
			res.getCustomer().setPassword("HIDDEN");
		}
		return results;
	}

}
