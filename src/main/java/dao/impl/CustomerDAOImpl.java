package dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import model.Customer;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.CustomerDAO;

/**
 * @author JBD
 *
 * @see dao.CustomerDAO
 */
@Repository
@Transactional
public class CustomerDAOImpl extends GenericDAOImpl<Customer, Long> implements CustomerDAO {

	/*
	 * Ici, on injectera sessionFactory grâce à la méthode
	 * setSessionFactory(sessionFactory) (voir plus bas)
	 */
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.CustomerDAO#findByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findByName(final String name) {
		final Query query = sessionFactory.openSession().getNamedQuery("Customer.findByName");
		query.setParameter("name", name);
		return (List<Customer>) query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.CustomerDAO#findByAddress(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findByAddress(final String address) {
		final Query query = sessionFactory.openSession().getNamedQuery("Customer.findByAddress");
		query.setParameter("address", address);
		return (List<Customer>) query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.CustomerDAO#findByNameAndAddress(java.lang.String,
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findByNameAndAddress(final String name, final String address) {
		final Query query = sessionFactory.openSession().getNamedQuery(
				"Customer.findByNameAndAddress");
		query.setParameter("name", name);
		query.setParameter("address", address);
		return (List<Customer>) query.list();
	}

	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		/*
		 * Ce setter permet à la fois d'injecter la dépendance sessionFactory à
		 * notre DAO mais aussi de l'injecter à la super classe (GenericDAOImpl)
		 * qui utilise une instance private de celle-ci (et donc non visible par
		 * les classes filles.
		 */
		super.setSessionFactory(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}