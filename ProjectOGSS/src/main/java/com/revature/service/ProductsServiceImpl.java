package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.revature.dao.ProductsDAO;
import com.revature.dao.UserAccountDAO;
import com.revature.fileSystem.FileSystem;
import com.revature.model.Product;
import com.revature.struct.Token;

@Service
public class ProductsServiceImpl implements ProductsService {

	private UserAccountDAO userAccountDAO;
	private ProductsDAO productsDAO;
	private FileSystem fileSystem;
	private AccountService accountService;

	@Autowired
	public void setProductsDAO(ProductsDAO productsDAO) {
		this.productsDAO = productsDAO;
	}

	@Autowired
	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	@Autowired
	public void setFileSystem(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public List<Product> getProducts() {
		return productsDAO.getProducts();
	}

	@Override
	public Product addProduct(Token token, Product product, MultipartFile multipartFile) {
		String url;
		if (accountService.hasPermission(token, "admin")) {
			url = fileSystem.uploadFile(multipartFile);
			product.setImageUrl(url);
			product.setImageName(multipartFile.getOriginalFilename());
			productsDAO.addProduct(product);
		}

		return product;
	}

	@Override
	public Product updateProduct(Token token, Product product, MultipartFile multipartFile) {
		String url;
		if (accountService.hasPermission(token, "admin")) {
			url = fileSystem.uploadFile(multipartFile);
			product.setImageUrl(url);
			product.setImageName(multipartFile.getOriginalFilename());
			productsDAO.updateProduct(product);
		}
		return product;
	}

	@Override
	public Boolean removeProduct(Token token, Product product) {
		return productsDAO.removeProduct(product);
	}

}
