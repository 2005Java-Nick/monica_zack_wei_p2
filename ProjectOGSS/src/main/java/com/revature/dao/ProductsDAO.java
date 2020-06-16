package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Product;

@Repository
public class ProductsDAO {
	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public List<Product> getProducts() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List<Product> listresults = (List<Product>) query.list();

		/*
		 * Invoice inv = new Invoice(); inv.setStatus("TESTING"); session.save(inv);
		 * ItemList item = new ItemList(); item.setQuantity(10); item.setOrder(inv);
		 * item.setProduct(listresults.get(0)); session.save(item);
		 * 
		 * String hql2 = "FROM orders"; Query query2 = session.createQuery(hql2);
		 * List<Invoice> listresults2 = (List<Invoice>) query2.list();
		 */
		tx.commit();
		session.close();
		// System.out.println(inv.getItemList().size());
		return listresults;
	}

	public Product addProduct(Product product) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(product);
		session.flush();
		tx.commit();
		session.close();
		return product;

	}

	public Product updateProduct(Product product) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(product);
		session.flush();
		tx.commit();
		session.close();
		return product;

	}

	public Boolean removeProduct(Product product) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(product);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}
}
