package manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import manager.CustomerManager;
import model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.CustomerBean;
import dao.CustomerDAO;

@Service
@Transactional
public class CustomerManagerImpl implements CustomerManager {

	@Autowired
	CustomerDAO customerDAO;

	// DI via Spring
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	// call DAO to save customer
	public void addCustomer(CustomerBean customer) {
		// On transforme le bean en entité
		customerDAO.addCustomer(customer.bean2Entity());

	}

	// call DAO to return customers
	public List<CustomerBean> listCustomer() {
		final List<Customer> list = customerDAO.listCustomer();
		final List<CustomerBean> listBean = new ArrayList<CustomerBean>();
		for (Customer c : list) {
			listBean.add(c.entity2Bean());
		}
		return listBean;

	}

}