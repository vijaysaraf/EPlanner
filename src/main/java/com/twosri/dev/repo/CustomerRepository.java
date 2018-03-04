package com.twosri.dev.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.twosri.dev.bean.Customer;

//@Repository
public interface CustomerRepository /*extends ElasticsearchRepository<Customer, String>*/ {

	public List<Customer> findByName(String name);

	public Customer findByEmail(String email);

}
