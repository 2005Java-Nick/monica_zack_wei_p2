package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.OrdersDAO;
import com.revature.model.Invoice;
import com.revature.struct.Token;

@Service
public class DriverServiceImpl implements DriverService {
	private OrdersDAO ordersDAO;

	@Autowired
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	@Override
	public List<Invoice> getInvoices(Token token) {
		List<Invoice> results = ordersDAO.getDriverOrders(token);
		for (Invoice res : results) {
			res.getDriver().setUsername("HIDDEN");
			res.getDriver().setPassword("HIDDEN");
			res.getCustomer().setUsername("HIDDEN");
			res.getCustomer().setPassword("HIDDEN");
		}
		return results;
	}

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		Invoice res = ordersDAO.updateOrderDriver(invoice);
		res.getDriver().setUsername("HIDDEN");
		res.getDriver().setPassword("HIDDEN");
		res.getCustomer().setUsername("HIDDEN");
		res.getCustomer().setPassword("HIDDEN");
		return res;
	}
}
