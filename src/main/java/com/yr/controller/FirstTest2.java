package com.yr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration
public class FirstTest2 {

	@RequestMapping("/hello2")
	public String index() {
		return "Hello World2";
	}
	
//	public static void main(String[] args) {
//		SpringApplication.run(FirstTest2.class, args);
//	}
	
}
