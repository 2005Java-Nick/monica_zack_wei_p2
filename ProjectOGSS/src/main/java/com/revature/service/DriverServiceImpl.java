package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.DriverDAO;
import com.revature.dao.OrdersDAO;
import com.revature.model.Driver;
import com.revature.model.Invoice;
import com.revature.struct.Token;

@Service
public class DriverServiceImpl implements DriverService {
	private OrdersDAO ordersDAO;
	private DriverDAO driverDAO;

	@Autowired
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	@Autowired
	public void setDriverDAO(DriverDAO driverDAO) {
		this.driverDAO = driverDAO;
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

	@Override
	public Driver getDriverShiftStatus(Token token) {
		return driverDAO.getDriverShiftStatus(token);
	}

	@Override
	public Boolean onShiftToggle(Token token) {
		return driverDAO.onShiftToggle(token);
	}

}
