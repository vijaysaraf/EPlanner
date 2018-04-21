package com.twosri.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.twosri.dev.bean.User;
import com.twosri.dev.service.ICustomerService;
import com.twosri.dev.service.IUserService;
import com.twosri.dev.util.AppEnum;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdminController {

	@Autowired
	ICustomerService customerService;

	@Autowired
	IUserService userservice;

	@GetMapping("/admin/customer/list")
	public String list(Model model) {
		log.info("Saving User...");
		try {
			
			User user = new User();
			user.setUserId("vijaysaraf" + System.currentTimeMillis());
			user.setPasscode("saraf");
			user.setActive(true);
			User saved = userservice.save(user);

			User x = userservice.findOne(saved.getId());
			log.info(x.toString());

			log.info("Saved...");
		} catch (Exception e) {
			log.debug("error occured...");
			e.printStackTrace();
		}

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
	@GetMapping("/admin/users")
	public String users() {
		return AppEnum._PATH_USER.getValue();
	}

}
