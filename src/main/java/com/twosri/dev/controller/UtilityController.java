package com.twosri.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UtilityController {

	@GetMapping(value = "/admin/utility/phase/list")
	public String getPhases() {
		StringBuilder returnStr = new StringBuilder("");
		returnStr.append("{").append("\"MCD0\":\"Mcachine0\"").append("\"MCD1\":\"Mcachine1\"")
				.append("\"MCD2\":\"Mcachine2\"").append("\"MCD3\":\"Mcachine3\"");
		log.info("return value as \n{}", returnStr.toString());
		return returnStr.toString();
	}
}
