package com.revature.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.revature.model.Product;
import com.revature.struct.Token;

public interface ProductsService {

	List<Product> getProducts();

	Product addProduct(Token token, Product product, MultipartFile multipartFile);

	Product updateProduct(Token token, Product product, MultipartFile multipartFile);

	Boolean removeProduct(Token token, Product product);

}