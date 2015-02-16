package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import service.CustomerService;
import model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.CustomerDTO;
import dao.CustomerDAO;

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
	 * @see service.CustomerService#addCustomer(bean.CustomerBean)
	 */
	public void addCustomer(final CustomerDTO customerDTO) {
		// On transforme le bean en entité
		final Customer customer = customerDTO.dto2Entity();
		customerDAO.save(customer);
	}

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

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
}