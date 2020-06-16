package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.revature.dao.DriverDAO;
import com.revature.model.Invoice;
import com.revature.model.Product;
import com.revature.model.UserAccount;
import com.revature.service.AccountService;
import com.revature.service.DriverService;
import com.revature.service.OrdersService;
import com.revature.service.ProductsService;
import com.revature.struct.Token;
import com.revature.struct.UserData;

@Controller
public class AppController {

	private AccountService accountService;
	private ProductsService productsService;
	private OrdersService ordersService;
	private DriverService driverService;
	private AmazonS3 amazonS3;

	@Autowired
	public void setAmazonS3(AmazonS3 amazonS3) {
		this.amazonS3 = amazonS3;
	}

	@Autowired
	public void setLoginService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	@Autowired
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@Autowired
	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UserAccount getLogin(@RequestBody UserData data) {
		System.out.println("Login RAN");
		return accountService.login(data);
	}

	@RequestMapping(path = "/login", method = RequestMethod.PUT)
	@ResponseBody
	public UserAccount updateAccount(@RequestBody UserAccount data) {
		System.out.println("Update RAN");
		return accountService.updateAccount(data);
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	@ResponseBody
	public UserAccount signUp(@RequestBody UserAccount data) {
		System.out.println("Signup RAN");
		return accountService.signup(data);
	}

	@RequestMapping(path = "/products", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getProducts() {
		System.out.println("Get Products RAN");
		return productsService.getProducts();
	}

	@RequestMapping(path = "/products", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public Product addProduct(@RequestPart(value = "token") Token token,
			@RequestPart(value = "product") Product product, @RequestPart(value = "file") MultipartFile multipartFile) {
		System.out.println("Add Products RAN");

		return productsService.addProduct(token, product, multipartFile);
	}

	@RequestMapping(path = "/products", method = RequestMethod.PUT, consumes = "multipart/form-data")
	@ResponseBody
	public Product updateProduct(@RequestPart(value = "token") Token token,
			@RequestPart(value = "product") Product product, @RequestPart(value = "file") MultipartFile multipartFile) {
		System.out.println("UPDATE Products RAN");

		return productsService.updateProduct(token, product, multipartFile);
	}

	@RequestMapping(path = "/products", method = RequestMethod.DELETE, consumes = "multipart/form-data")
	@ResponseBody
	public Boolean deleteProduct(@RequestPart(value = "token") Token token,
			@RequestPart(value = "product") Product product) {
		System.out.println("UPDATE Products RAN");

		return productsService.removeProduct(token, product);
	}

	@RequestMapping(path = "/invoices", method = RequestMethod.GET)
	@ResponseBody
	public List<Invoice> getInvoices(@RequestParam("Token") String token) {
		Token t = new Token();
		t.setToken(token);
		t.setToken(t.getToken().replace(' ', '+'));
		return ordersService.getInvoices(t);
	}

	@RequestMapping(path = "/invoices", method = RequestMethod.POST)
	@ResponseBody
	public Invoice setInvoice(@RequestBody Invoice data) {
		return ordersService.checkout(data);
	}

	@RequestMapping(path = "/driver", method = RequestMethod.GET)
	@ResponseBody
	public List<Invoice> getDriverOrders(@RequestParam("Token") String token) {
		Token t = new Token();
		t.setToken(token);
		t.setToken(t.getToken().replace(' ', '+'));
		System.out.println("Driver orders Ran");
		return driverService.getInvoices(t);
	}

	@RequestMapping(path = "/driver", method = RequestMethod.PUT)
	@ResponseBody
	public Invoice updateDriverOrder(@RequestBody Invoice data) {
		System.out.println("Order Update Ran");
		return driverService.updateInvoice(data);
	}

	@Autowired
	DriverDAO d;

	@RequestMapping(path = "/TEST", method = RequestMethod.POST)
	@ResponseBody
	public Object TEST() {
		return d.getAvailableDriver();
	}
}
