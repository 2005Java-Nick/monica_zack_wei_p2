package com.revature.fileSystem;

import org.springframework.web.multipart.MultipartFile;

public interface FileSystem {

	String uploadFile(MultipartFile multipartFile);

}