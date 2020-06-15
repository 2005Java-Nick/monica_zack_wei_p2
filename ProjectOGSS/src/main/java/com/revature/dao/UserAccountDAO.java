package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.AccountType;
import com.revature.model.UserAccount;
import com.revature.struct.Token;
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
		Transaction tx = session.beginTransaction();
		String hql = "FROM user_account UA WHERE UA.username = :username AND UA.password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", data.getUsername());
		query.setParameter("password", data.getPassword());
		UserAccount listresults = (UserAccount) query.uniqueResult();
		session.flush();
		session.close();
		return listresults;
	}

	public UserAccount getUserAccount(Token token) {

		Session session = sf.openSession();
		String hql = "FROM user_account UA WHERE UA.sessionToken = :sessionToken";
		Query query = session.createQuery(hql);
		query.setParameter("sessionToken", token.getToken());
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

	public List<AccountType> getAccountPermissions(Token token) {
		Session session = sf.openSession();
		String hql = "SELECT a FROM AccountType a INNER JOIN a.userAccount ua where ua.sessionToken = :sessionToken";
		Query query = session.createQuery(hql);
		query.setParameter("sessionToken", token.getToken());
		List<AccountType> listresults = (List<AccountType>) query.list();
		session.close();
		return listresults;
	}

}
