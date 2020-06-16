package com.revature.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtil {

	private SessionFactory sf;

	private static String url;

	private static String username;

	private static String password;

	private static final String DB_NAME = "revature_weiwu_db";

	public SessionFactory getSessionFactory() {
		return this.sf;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	public SessionFactoryUtil() {
		System.out.println("test0");
		if (sf == null) {
			url = System.getenv("POSTGRES_URL");
			url = "jdbc:postgresql://" + url + ":5432/" + DB_NAME + "?";
			username = System.getenv("POSTGRES_USERNAME");
			password = System.getenv("POSTGRES_PASSWORD");
			Map<String, String> settings = new HashMap<String, String>();
			settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.connection.url", url);
			settings.put("hibernate.connection.username", username);
			settings.put("hibernate.connection.password", password);
			settings.put("hibernate.show_sql", "true");
			// settings.put("hibernate.hbm2dd1.auto", "update");
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings)
					.build();
			Metadata metadata = new MetadataSources(standardRegistry)
					.addAnnotatedClass(com.revature.model.AccountType.class)
					.addAnnotatedClass(com.revature.model.UserAccount.class)
					.addAnnotatedClass(com.revature.model.Invoice.class)
					.addAnnotatedClass(com.revature.model.ItemList.class)
					.addAnnotatedClass(com.revature.model.ItemListID.class)
					.addAnnotatedClass(com.revature.model.Driver.class)
					.addAnnotatedClass(com.revature.model.Product.class).getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
			sf = metadata.getSessionFactoryBuilder().build();
		}

	}

}