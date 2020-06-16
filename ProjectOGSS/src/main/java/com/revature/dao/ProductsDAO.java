package com.revature.dao;

import java.util.List;

import com.revature.model.Product;

public interface ProductsDAO {

	List<Product> getProducts();

	Product addProduct(Product product);

	Product updateProduct(Product product);

	Boolean removeProduct(Product product);

}