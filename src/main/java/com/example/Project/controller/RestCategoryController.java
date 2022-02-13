package com.example.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.model.CategoryDTO;
import com.example.Project.services.CategoryService;

@RestController
public class RestCategoryController {
	//CÓ @RestController thì nó tự các giá trị trả về thành dạng json hoặc xml r nên có thể bỏ @ResponseBody ở các hàm bên dưới
	
	@Autowired
	private CategoryService categoryService;
	
//	đổi thành dạng json hoặc xml
	//nhớ là phải cấu hình trong security (ProjectApplication.java) .antMatchers("/category-management/danh-sach-category").permitAll() để nó cho phép vào trang này k postman nó k trả ra kết quả nó lại trả ra một trang html là sai
	@GetMapping("/danh-sach-category")
	public  List<CategoryDTO> categoryManagement() {
		List<CategoryDTO> categoryDTOs=categoryService.getAllCategories();
		return categoryDTOs;
	}
	
	//api
	@PostMapping("/them-category")
	@ResponseStatus(code=HttpStatus.CREATED)// trả về mã code 201 chỗ này chưa rõ lắm
	public void addCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.addCategory(categoryDTO);
		
	}
}
