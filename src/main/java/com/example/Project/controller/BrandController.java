package com.example.Project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Project.model.BrandDTO;
import com.example.Project.model.CategoryDTO;
import com.example.Project.services.BrandService;


@Controller
@RequestMapping("/brand-management")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@GetMapping("/brands")
	public String brandManagement(HttpServletRequest request) {
		List<BrandDTO> brandDTOs  = brandService.getAllBrands();
		request.setAttribute("brands", brandDTOs);
		request.setAttribute("brand", new BrandDTO());
		return "brand_management";
	}
	
	@PostMapping("/add-brand")
	public String addBrand(HttpServletRequest request, @ModelAttribute BrandDTO brandDTO) {
		brandService.addBrand(brandDTO);
		return "redirect:/brand-management/brands";
	}
	
	@PostMapping("/update-brand")
	public String updateBrand(HttpServletRequest request, 
			@ModelAttribute BrandDTO brandDTO) {
		brandService.updateBrand(brandDTO);
		return "redirect:/brand-management/brands";
	}
	
	@PostMapping("/delete-brand")
	public String deleteBrand(@RequestParam("id") int id) {
		brandService.deleteBrand(id);
		return "redirect:/brand-management/brands";
	}
}
