package com.revature.requestwrappers;

import com.revature.model.Product;
import com.revature.struct.Token;

public class TokenAndProduct {
	private Token token;
	private Product product;

	public TokenAndProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenAndProduct(Token token, Product product) {
		super();
		this.token = token;
		this.product = product;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
