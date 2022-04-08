package com.example.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.model.CategoryDTO;
import com.example.Project.services.CategoryService;

@RestController
public class RestCategoryController {
	// CÓ @RestController thì nó tự các giá trị trả về thành dạng json hoặc xml r
	// nên có thể bỏ @ResponseBody ở các hàm bên dưới

	@Autowired
	private CategoryService categoryService;

//	đổi thành dạng json hoặc xml
	// nhớ là phải cấu hình trong security (ProjectApplication.java)
	// .antMatchers("/category-management/danh-sach-category").permitAll() để nó cho
	// phép vào trang này k postman nó k trả ra kết quả nó lại trả ra một trang html
	// là sai
	@GetMapping("/danh-sach-category")
	public List<CategoryDTO> categoryManagement() {
		List<CategoryDTO> categoryDTOs = categoryService.getAllCategories();
		return categoryDTOs;
	}

	// api
	@PostMapping("/them-category")
	@ResponseStatus(code = HttpStatus.CREATED) // trả về mã code 201 nếu thực hiện thành công và trả về 400 nếu có lỗi xảy ra (hiển thị 201 ở phần server response code trong swagger)
	public void addCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.addCategory(categoryDTO);
	}

	// api
	@PostMapping("/sua-category")
	@ResponseStatus(code = HttpStatus.OK) // trả về mã code 200 nếu thực hiện thành công và trả về 400 nếu có lỗi xảy ra (hiển thị 200 ở phần server response code trong swagger)
	public void updateCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.updateCategory(categoryDTO);
	}
	
	@DeleteMapping("/xoa-category/{id}")
	@ResponseStatus(code = HttpStatus.OK) // trả về mã code 200 nếu thực hiện thành công và trả về 500 nếu có lỗi xảy ra: ví dụ như nhập id không tồn tại hoặc nhập chữ vào id (hiển thị 200 ở phần server response code trong swagger)
	public void deleteCategory(@RequestParam("id") int id) {
		categoryService.deleteCategory(id);
	}
	
}
