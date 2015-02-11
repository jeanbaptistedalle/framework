package bean;

import java.io.Serializable;
import java.util.Date;

import model.Customer;

public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6876955142634710433L;

	private Long customerId;

	private String name;

	private String address;

	private Date createdDate;

	public CustomerBean() {
	}

	public CustomerBean(final String name, final String address, final Date createdDate) {
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}
	
	public CustomerBean(final Long customerId, final String name, final String address, final Date createdDate) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(final Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Customer bean2Entity(){
		return new Customer(this.customerId, this.name, this.address, this.createdDate);
	}
}
