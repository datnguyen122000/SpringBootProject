package com.example.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Project.dao.AccountDao;

@Controller
public class TestDataController {
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@GetMapping("/test")
	public String getData() {
		System.out.println(accountDao.findByUsername("DatNQ30"));
		return "blank3";
	}
	
	@GetMapping("/test2")
	public String testCode() {
		System.out.println(bCryptPasswordEncoder.encode("123"));
		return "";
	}
}
