package com.example.Project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.Project.entities.Category;
import com.example.Project.model.CategoryDTO;
import com.example.Project.services.CategoryService;

@Controller
@RequestMapping("/category-management")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//CHUYỂN TOÀN CÁI BÊN DƯỚI SANG CLASS REST CONTROLLER RIÊNG
////	đổi thành dạng json hoặc xml
//	//nhớ là phải cấu hình trong security (ProjectApplication.java) .antMatchers("/category-management/danh-sach-category").permitAll() để nó cho phép vào trang này k postman nó k trả ra kết quả nó lại trả ra một trang html là sai
//	@GetMapping("/danh-sach-category")
//	public @ResponseBody List<CategoryDTO> categoryManagement() {
//		List<CategoryDTO> categoryDTOs=categoryService.getAllCategories();
//		return categoryDTOs;
//	}
//	
//	//api
//	@PostMapping("/them-category")
//	@ResponseStatus(code=HttpStatus.CREATED)// trả về mã code 201 chỗ này chưa rõ lắm
//	public @ResponseBody void addCategory(@RequestBody CategoryDTO categoryDTO) {
//		categoryService.addCategory(categoryDTO);
//		
//	}
	
	
	@GetMapping("/categories")
	public String categoryManagement(HttpServletRequest request) {
		List<CategoryDTO> categoryDTOs=categoryService.getAllCategories();
		request.setAttribute("categories", categoryDTOs);
		request.setAttribute("Category",new CategoryDTO());
		return "category_management";
	}
	
	@PostMapping("/add-category")
	public String addCategory(HttpServletRequest request,@ModelAttribute("Category") CategoryDTO categoryDTO) {
		categoryService.addCategory(categoryDTO);
		return "redirect:/category-management/categories";
	}
	
	@PostMapping("/delete-category")
	public String deleteCategory(@RequestParam("id") int id) {
		categoryService.deleteCategory(id);
		return "redirect:/category-management/categories";
	}
	
	@PostMapping("/update-category")
	public String updateCategory(@ModelAttribute CategoryDTO categoryDTO) {
		categoryService.updateCategory(categoryDTO);
		return "redirect:/category-management/categories";
	}
}
