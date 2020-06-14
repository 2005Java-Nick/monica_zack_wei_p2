package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.revature.dao.ProductsDAO;
import com.revature.dao.UserAccountDAO;
import com.revature.fileSystem.FileSystem;
import com.revature.model.AccountType;
import com.revature.model.Product;
import com.revature.struct.Token;

@Service
public class ProductsService {

	UserAccountDAO userAccountDAO;
	ProductsDAO productsDAO;
	FileSystem fileSystem;

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

	public List<Product> getProducts() {
		return productsDAO.getProducts();
	}

	public Product addProduct(Token token, Product product, MultipartFile multipartFile) {
		boolean hasPermission = false;
		List<AccountType> accountTypes = userAccountDAO.getAccountPermissions(token);
		for (AccountType a : accountTypes) {
			if (a.getType().equals("admin")) {
				hasPermission = true;
			}
		}

		String url;
		if (hasPermission) {
			url = fileSystem.uploadFile(multipartFile);
			product.setImageUrl(url);
			product.setImageName(multipartFile.getName());
			productsDAO.addProduct(product);
		}

		return product;
	}

}
