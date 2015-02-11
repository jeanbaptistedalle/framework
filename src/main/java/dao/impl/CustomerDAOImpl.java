package dao.impl;

import java.util.List;

import model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDAO;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// add the customer
	public void addCustomer(Customer customer) {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
	}

	public Customer getCustomer(final Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction transaction = session.beginTransaction();
		Customer customer = (Customer)session.get(Customer.class, id);
		transaction.commit();
		return customer;
	}

	// return all the customers in list
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomer() {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction transaction = session.beginTransaction();
		final List<Customer> list = sessionFactory.getCurrentSession().createQuery("from Customer").list();
		transaction.commit();
		return list;
	}
}