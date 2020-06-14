package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Invoice;
import com.revature.model.ItemList;
import com.revature.model.Product;
import com.revature.model.UserAccount;

@Repository
public class OrdersDAO {
	private SessionFactory sf;
	UserAccountDAO userAccountDAO;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	@Autowired
	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	public Invoice checkout(Invoice invoice) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		// get the products objects
		UserAccount userAccount = userAccountDAO.getUserAccount(invoice.getToken());

		session.persist(userAccount);
		invoice.setCustomer(userAccount);
		session.save(invoice);
		for (ItemList p : invoice.getItemList()) {
			String getProductHQL = "FROM Product p WHERE p.id = :productID";
			Query query = session.createQuery(getProductHQL);
			query.setParameter("productID", p.getProduct().getId());
			Product productResult = (Product) query.uniqueResult();
			productResult.setInventoryQuantity(productResult.getInventoryQuantity() - p.getQuantity());
			session.persist(productResult);

			ItemList item = new ItemList();
			item.setOrder(invoice);
			item.setProduct(productResult);
			item.setQuantity(p.getQuantity());
			session.save(item);
		}

		tx.commit();
		session.close();
		return invoice;
	}

}
