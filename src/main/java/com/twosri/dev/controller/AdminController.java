package com.twosri.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.twosri.dev.bean.Customer;
import com.twosri.dev.util.AppEnum;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdminController {

	@GetMapping("/admin/customer/list")
	public String list(Model model) {
		List<Customer> customers = new ArrayList<Customer>();
		Customer cust = new Customer();
		
		cust.setId("0001");
		cust.setName("XYZ");
		cust.setContact("9075332988");
		cust.setAddress("Chinchwad");
		
		customers.add(cust);
		
		Customer cust1 = new Customer();
		cust1.setId("0002");
		cust1.setName("ABC");
		cust1.setContact("9850254154");
		cust1.setAddress("Chinchwad");
		customers.add(cust1);
		
		model.addAttribute("customers", customers);
		
		return AppEnum._PATH_CUSTOMER_LIST.getValue();
	}

	@GetMapping("/admin/customer/modify/{id}")
	public String modify(@PathVariable(value = "id") String id) {
		return AppEnum._PATH_CUSTOMER_MODIFY.getValue();
	}

	@GetMapping("/admin/customer/delete/{id}")
	public String login() {
		return AppEnum._PATH_CUSTOMER_LIST.getValue();
	}

	@GetMapping("/admin/customer/save")
	public String save() {
		return AppEnum._PATH_CUSTOMER_LIST.getValue();
	}

}
