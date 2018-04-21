package com.twosri.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@GetMapping("/admin/users/load")
	public String home() {
		return "[{'id':'1asd','name':'vijay'},{'id':'2asd','name':'vijay2'},{'id':'3asd','name':'vijay3'}]";
	}
}
