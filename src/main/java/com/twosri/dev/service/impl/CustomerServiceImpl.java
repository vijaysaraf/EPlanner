/**
 * 
 */
package com.twosri.dev.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.twosri.dev.bean.Customer;
import com.twosri.dev.converter.CustomerMapper;
import com.twosri.dev.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VIJAY
 *
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${db.index}")
	String indexName;

	@Autowired
	Client client;

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

	@Autowired
	CustomerMapper mapper;

	public List<Object> list() {
		final SearchResponse response = client.prepareSearch(indexName).setTypes("customer")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(QueryBuilders.matchAllQuery()).get();

		try {
			List<Object> list = mapper.convertResponseList(response);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Customer load(String id) {
		return new Customer();
	}
}
