package com.revature.security;

import org.jasypt.digest.PooledStringDigester;

public class Encryption {
	public static String encryptString(String userPassword) {

		int cores = Runtime.getRuntime().availableProcessors();

		PooledStringDigester digester = new PooledStringDigester();
		digester.setPoolSize(cores);
		digester.setAlgorithm("SHA-256");
		digester.setIterations(100000);

		String digest = digester.digest(userPassword);
		return digest;
	}

	public static boolean authenticate(String userPassword, String storedPassword) {

		int cores = Runtime.getRuntime().availableProcessors();

		PooledStringDigester digester = new PooledStringDigester();
		digester.setPoolSize(cores);
		digester.setAlgorithm("SHA-256");
		digester.setIterations(100000);

		if (digester.matches(userPassword, storedPassword)) {
			return true;
		} else {
			return false;
		}

	}
}
