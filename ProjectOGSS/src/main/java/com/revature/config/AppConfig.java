package com.revature.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.util.SessionFactoryUtil;

@Configuration
@ComponentScan(basePackages = "com.revature")
public class AppConfig {

	private SessionFactoryUtil sessionFactoryUtil;

	@Autowired
	public void setSessionFactoryUtil(SessionFactoryUtil sessionFactoryUtil) {
		System.out.println("test1");
		this.sessionFactoryUtil = sessionFactoryUtil;
	}

	@Bean
	@Scope("singleton")
	public SessionFactory sessionFactory() {
		System.out.println("test2");
		return sessionFactoryUtil.getSessionFactory();
	}

}
