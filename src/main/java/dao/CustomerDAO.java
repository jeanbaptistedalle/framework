package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Customer;
 
@Repository("customerDao")
public interface CustomerDAO{
	
	void addCustomer(Customer customer);
	
	List<Customer> listCustomer();
	
}