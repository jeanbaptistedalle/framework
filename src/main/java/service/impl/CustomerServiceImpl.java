package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import service.CustomerService;
import model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDAO;
import dto.CustomerDTO;

/**
 * @author JBD
 *
 * @see service.CustomerService
 * 
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.CustomerService#listCustomer()
	 */
	public List<CustomerDTO> listCustomer() {
		final List<Customer> list = customerDAO.findAll();
		final List<CustomerDTO> listBean = new ArrayList<CustomerDTO>();
		for (Customer c : list) {
			listBean.add(c.entity2Bean());
		}
		return listBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.CustomerService#listCustomerByName(java.lang.String)
	 */
	public List<CustomerDTO> listCustomerByName(final String name) {
		final List<Customer> list = customerDAO.findByName(name);
		final List<CustomerDTO> listBean = new ArrayList<CustomerDTO>();
		for (Customer c : list) {
			listBean.add(c.entity2Bean());
		}
		return listBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.CustomerService#deleteCustomer(java.lang.Long)
	 */
	public void deleteCustomer(final Long customerId) {
		customerDAO.removeById(customerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.CustomerService#getCustomerById(java.lang.Long)
	 */
	public CustomerDTO getCustomerById(final Long customerId) {
		final Customer customer = customerDAO.find(customerId);
		if (customer != null) {
			return customer.entity2Bean();
		}
		return null;
	}

	public void saveCustomer(final CustomerDTO customer) {
		if (customer != null) {
			final Customer c = customer.dto2Entity();
			customerDAO.save(c);
		}
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(final CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
}