package com.twosri.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DefaultController {
	
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}
	

}
