/**
 * 
 */
package com.twosri.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.twosri.dev.bean.Customer;

import com.twosri.dev.service.ICustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VIJAY
 *
 */
@Service
@Slf4j
public class CustomerService implements ICustomerService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${db.index}")
	String indexName;

	@Override
	public List<Customer> findByName(String name) {
		return null;
	}

	@Override
	public Customer save(Customer customer) {
		return customer;
	}

	@Override
	public Customer delete(Customer customer) {
		return load(customer.getId());
	}

	@Override
	public Customer delete(String id) {
		return load(id);
	}

	@Override
	public Customer load(String id) {
		return new Customer();
	}

	@Override
	public List<Object> list() {
		// TODO Auto-generated method stub
		return null;
	}
}
