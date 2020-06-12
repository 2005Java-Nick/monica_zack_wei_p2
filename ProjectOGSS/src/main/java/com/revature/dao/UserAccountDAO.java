package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.model.UserAccount;

@Component
public class UserAccountDAO {

	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public List<UserAccount> getAllUserAccounts() {

		Session sess = sf.openSession();
		String hql = "FROM user_account name";
		Query query = sess.createQuery(hql);
		List<UserAccount> listresults = query.list();

		System.out.println("DAO RAN");
		for (UserAccount acc : listresults) {
			System.out.println(acc.getAddress());
		}
		sess.close();
		return listresults;
	}

}
