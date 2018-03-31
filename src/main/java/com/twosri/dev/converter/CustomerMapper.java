package com.twosri.dev.converter;

import org.springframework.stereotype.Component;

import com.twosri.dev.bean.Customer;

@Component
public class CustomerMapper extends Converter {

	@Override
	protected Object getInstance() {
		return new Customer();
	}

	// @Override

}
