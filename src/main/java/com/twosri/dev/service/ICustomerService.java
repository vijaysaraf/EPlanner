package com.twosri.dev.service;

import java.util.List;

import com.twosri.dev.bean.Customer;

public interface ICustomerService {
	String postFix = "customer/";
	public List<Customer> findByName(String name);

	public Customer save(Customer customer);

	public Customer delete(Customer customer);

	public Customer delete(String id);

	public Customer load(String id);
	
	public List<Object> list();
}
