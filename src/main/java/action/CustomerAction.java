package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manager.CustomerManager;

import org.springframework.beans.factory.annotation.Autowired;

import bean.CustomerBean;

public class CustomerAction{

	CustomerBean customer = new CustomerBean();
	List<CustomerBean> customerList = new ArrayList<CustomerBean>();

	@Autowired
	CustomerManager customerManager;

	public void init() throws Exception {
		customerList = customerManager.listCustomer();
	}
	
	public CustomerBean getModel() {
		return customer;
	}

	public List<CustomerBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerBean> customerList) {
		this.customerList = customerList;
	}

	public String addCustomer() throws Exception {

		// save it
		customer.setCreatedDate(new Date());
		customerManager.addCustomer(customer);

		// reload the customer list
		customerList = null;
		customerList = customerManager.listCustomer();

		return "success";

	}

	public String listCustomer() throws Exception {

		customerList = customerManager.listCustomer();

		return "success";

	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
}