package com.example.Project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Project.model.CategoryDTO;
import com.example.Project.model.ProductDTO;
import com.example.Project.services.CategoryService;
import com.example.Project.services.ProductService;


@Controller
public class StoreController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/login")
//	phải có  required = false nghĩa là biến này có thể có hoặc k, nếu k thêm cái  required = false sẽ bị lỗi 400
	public String login(HttpServletRequest request,@RequestParam(name="e", required = false) String error) {
		if(error!=null) {
			request.setAttribute("e", error);
		}
		return "login";
	}
	
	@GetMapping("/store")
	public String storePage(HttpServletRequest request) {
//		UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		request.setAttribute("username", userDetails.getUsername());
		
		request.setAttribute("username", "dat");
		List<CategoryDTO> categoriesActice= categoryService.getAllActiveCategories();
		request.setAttribute("categoriesActice", categoriesActice);
		
		List<ProductDTO> productDTOs=productService.getAllProduct();
		request.setAttribute("productDTOs", productDTOs);
		
		return "store";
	}
}
