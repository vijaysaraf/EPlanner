package com.twosri.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.twosri.dev.util.AppEnum;

@Controller
public class AdminController {

	@GetMapping("/admin/users")
	public String users() {
		return AppEnum._PATH_USER.getValue();
	}

	@GetMapping("/admin/customers")
	public String customers() {
		return AppEnum._PATH_CUSTOMER.getValue();
	}
	@GetMapping("/admin/phases")
	public String phases() {
		return AppEnum._PATH_PHASE.getValue();
	}
	@GetMapping("/admin/references")
	public String references() {
		return AppEnum._PATH_REFERENCE.getValue();
	}

}
