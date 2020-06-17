package com.revature.fileSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.revature.config.AmazonS3Config;
import com.revature.model.Product;

@Service
public class FileSystemImpl implements FileSystem {

	private AmazonS3 amazonS3;

	@Autowired
	public void setAmazonS3(AmazonS3 amazonS3) {
		this.amazonS3 = amazonS3;
	}

	@Override
	public String uploadFile(MultipartFile multipartFile) {

		File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (final IOException ex) {
			ex.getStackTrace();
		}

		amazonS3.putObject(new PutObjectRequest(AmazonS3Config.bucket, file.getName(), file)
				.withCannedAcl(CannedAccessControlList.PublicRead));

		String locationUrl = amazonS3.getUrl(AmazonS3Config.bucket, file.getName()).toString();
		return locationUrl;
	}

	@Override
	public void deleteFile(Product product) {
		amazonS3.deleteObject(AmazonS3Config.bucket, product.getImageName());
	}
}
