package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonS3Config {

	final static String region = "us-east-2";
	public final static String bucket = "revature-ogss";

	@Bean
	public AmazonS3 getAmazonS3Client() {

		BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(System.getenv("AWS_S3_accessKeyID"),
				System.getenv("AWS_S3_secretAccessKey"));
		// Get AmazonS3 client and return the s3Client object.
		return AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).build();
	}

}
