package manager;

import java.util.List;

import bean.CustomerBean;

public interface CustomerManager {

	void addCustomer(CustomerBean customer);

	List<CustomerBean> listCustomer();

}