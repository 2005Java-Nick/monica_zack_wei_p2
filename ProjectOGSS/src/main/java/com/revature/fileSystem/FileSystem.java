package com.revature.fileSystem;

import org.springframework.web.multipart.MultipartFile;

import com.revature.model.Product;

public interface FileSystem {

	String uploadFile(MultipartFile multipartFile);

	void deleteFile(Product product);

}