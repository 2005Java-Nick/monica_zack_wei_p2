package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.UserAccount;
import com.revature.struct.UserData;

@Repository
public class UserAccountDAO {

	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public UserAccount getUserAccount(UserData data) {

		Session session = sf.openSession();
		String hql = "FROM user_account UA WHERE UA.username = :username AND UA.password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", data.getUsername());
		query.setParameter("password", data.getPassword());
		UserAccount listresults = (UserAccount) query.uniqueResult();
		session.close();
		return listresults;
	}

	public void setUserAccountSessionToken(UserAccount userAccount) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(userAccount);
		tx.commit();
		session.close();
	}

	public UserAccount createUserAccount(UserAccount userAccount) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(userAccount);
		session.flush();
		tx.commit();
		session.close();
		return userAccount;

	}

}
