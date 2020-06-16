package com.revature.service;

import java.util.List;

import com.revature.model.Driver;
import com.revature.model.Invoice;
import com.revature.struct.Token;

public interface DriverService {

	List<Invoice> getInvoices(Token token);

	Invoice updateInvoice(Invoice invoice);

	Driver getDriverShiftStatus(Token token);

	Boolean onShiftToggle(Token token);

}