package com.example.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Project.dao.AccountDao;
import com.example.Project.repository.CategoryRepository;
import com.example.Project.repository.ProductRepository;

@Controller
public class TestDataController {
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@GetMapping("/test")
	public String getData() {
		System.out.println(accountDao.findByUsername("DatNQ30"));
		return "blank3";
	}
	
	@GetMapping("/test2")
	public String testCode() {
		// k test đc kiểu này
//		System.out.println(productRepository.findByName("Trẻ em 1"));
		System.out.println(categoryRepository.findAll().toString());
		System.out.println(bCryptPasswordEncoder.encode("123"));
		return "blank3";
	}
}
