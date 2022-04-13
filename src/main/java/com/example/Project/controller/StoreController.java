package com.example.Project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		int pageSize=9;// số lượng sản phẩm trong một trang
//		UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		request.setAttribute("username", userDetails.getUsername());
		int offset=0;
		//offset là số page bắt đầu (tính từ 0)
		if(request.getParameter("offset")!=null) {
			offset=Integer.parseInt(request.getParameter("offset"))-1;
		}
		System.out.println(offset);
		request.setAttribute("username", "dat");
		List<CategoryDTO> categoriesActice= categoryService.getAllActiveCategories();
		request.setAttribute("categoriesActice", categoriesActice);
		
		List<ProductDTO> productDTOAll=productService.getAllProduct();
		int numProduct=productDTOAll.size();
		int numPage=numProduct/pageSize;
		if(numProduct%pageSize!=0) {
			numPage++;
		}
		
		List<ProductDTO> productDTOs=productService.productByPaging(offset, pageSize);
		System.out.println(productDTOs);
		request.setAttribute("productDTOs", productDTOs);
		request.setAttribute("numPage", numPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("offset", offset);
		System.out.println(offset);
		return "store";
	}
	
	@PostMapping("/search")
	public String search(HttpServletRequest request,@RequestParam(name="txtSearch", required = false) String txtSearch) {
		List<ProductDTO> productDTOs=productService.productSearch(txtSearch);
		request.setAttribute("productDTOs", productDTOs);
		return "store";
	}
	
}
