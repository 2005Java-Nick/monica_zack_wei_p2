package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Driver;
import com.revature.model.UserAccount;
import com.revature.struct.Token;

@Repository
public class DriverDAOImpl implements DriverDAO {
	private SessionFactory sf;
	private UserAccountDAO userAccountDAO;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	@Autowired
	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	@Override
	public UserAccount getAvailableDriver() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "SELECT dr FROM Driver driv INNER JOIN driv.driver dr INNER JOIN dr.accountType accType WHERE accType.type = :driverType AND driv.onShift = :status";
		Query query = session.createQuery(hql);
		query.setParameter("driverType", "driver");
		query.setParameter("status", true);
		List<UserAccount> listresults = (List<UserAccount>) query.list();

		int minIndex = 0;
		int minCount = Integer.MAX_VALUE;
		int indexCounter = 0;
		for (UserAccount acc : listresults) {
			int tempNum = countDriverOrders(acc);
			if (tempNum < minCount) {
				minCount = tempNum;
				minIndex = indexCounter;
			}
			indexCounter++;
		}

		session.flush();
		session.close();
		return listresults.get(minIndex);
	}

	@Override
	public Integer countDriverOrders(UserAccount userAccount) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		String getInvoiceHQL = "SELECT count(invoice) FROM Invoice invoice WHERE invoice.driver.id = :driverID";
		Query query = session.createQuery(getInvoiceHQL);
		query.setParameter("driverID", userAccount.getId());
		Long listresults = (Long) query.uniqueResult();
		tx.commit();
		session.close();

		return listresults.intValue();
	}

	@Override
	public Boolean onShiftToggle(Token token) {
		UserAccount userAccount = userAccountDAO.getUserAccount(token);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "SELECT driv FROM Driver driv INNER JOIN driv.driver dr WHERE dr.id = :accountID";
		Query query = session.createQuery(hql);
		query.setParameter("accountID", userAccount.getId());
		Driver listresults = (Driver) query.uniqueResult();
		listresults.setOnShift(!listresults.getOnShift());
		tx.commit();
		session.close();
		return listresults.getOnShift();
	}
}
