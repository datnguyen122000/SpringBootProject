package com.example.Project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Project.dao.BrandDao;
import com.example.Project.dao.ImgDao;
import com.example.Project.model.CategoryDTO;
import com.example.Project.model.ProductDTO;
import com.example.Project.services.BrandService;
import com.example.Project.services.CategoryService;
import com.example.Project.services.ImgService;
import com.example.Project.services.ProductService;

@Controller
@RequestMapping("/product-management")
public class ProductController {
	@Autowired
	private ImgService imgService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public String getAllProduct(HttpServletRequest request) {

		List<ProductDTO> products = productService.getAllProduct();
		request.setAttribute("products", products);
		request.setAttribute("brands", brandService.getAllBrands());
		request.setAttribute("imgs", imgService.getAllImgs());
		request.setAttribute("categories", categoryService.getAllCategories());
		return "product_management";
	}

	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute ProductDTO productDTO) {
		productService.addProduct(productDTO);
		return "redirect:/product-management/products";
	}
	
	@PostMapping("/update-product")
	public String updateCategory(@ModelAttribute ProductDTO productDTO) {
		productService.updateProduct(productDTO);
		
		return "redirect:/product-management/products";
	}
	
}
