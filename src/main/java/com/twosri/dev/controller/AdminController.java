package com.twosri.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.twosri.dev.bean.Customer;
import com.twosri.dev.service.CustomerService;
import com.twosri.dev.util.AppEnum;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdminController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/admin/customer/list")
	public String list(Model model) {
		log.info("Customer from reporsitory...");

		List<Object> customers = customerService.list();
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
