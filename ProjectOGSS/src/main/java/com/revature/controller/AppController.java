package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.revature.model.Product;
import com.revature.model.UserAccount;
import com.revature.service.AccountService;
import com.revature.service.ProductsService;
import com.revature.struct.Token;
import com.revature.struct.UserData;

@Controller
public class AppController {

	private AccountService accountService;
	private ProductsService productsService;

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

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UserAccount getLogin(@RequestBody UserData data) {
		System.out.println("Login RAN");
		return accountService.login(data);
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

	@RequestMapping(path = "/products", method = RequestMethod.POST)
	@ResponseBody
	public Product addProduct(@RequestParam(value = "token") Token token,
			@RequestParam(value = "product") Product product,
			@RequestParam(value = "file") MultipartFile multipartFile) {
		System.out.println("Add Products RAN");

		return productsService.addProduct(token, product, multipartFile);
	}

	@RequestMapping(path = "/TEST", method = RequestMethod.POST)
	@ResponseBody
	public List<Product> TEST(@RequestParam(value = "file") MultipartFile multipartFile) {
		System.out.println("TEST RAN");

		List<Product> temp = productsService.getProducts();
		for (Product t : temp) {
			System.out.println(t.getProductName());
		}
		return temp;
	}

}
