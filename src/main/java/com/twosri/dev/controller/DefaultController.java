package com.twosri.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.twosri.dev.database.repository.OrderRepository;
import com.twosri.dev.service.cache.CacheManager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DefaultController {
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	OrderRepository repo;

	@GetMapping("/")
	public String home() {
		repo.deleteAll();
		cacheManager.initCacheManager();
		
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
