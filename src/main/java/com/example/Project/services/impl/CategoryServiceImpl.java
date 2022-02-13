package com.example.Project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.CategoryDao;
import com.example.Project.entities.Category;
import com.example.Project.entities.Product;
import com.example.Project.model.CategoryDTO;
import com.example.Project.model.ProductDTO;
import com.example.Project.services.BrandService;
import com.example.Project.services.CategoryService;
import com.example.Project.services.ImgService;

@Service
//bắt buộc phải có không thì sẽ không chạy đc
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ImgService imgService;

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = categoryDao.getAllCategory();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		for (Category c : categories) {
			CategoryDTO categoryDTO = new CategoryDTO(c.getId(), c.getName(), c.getStatus());

			// get list products cho từng category
			List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
			for (Product p : c.getProducts()) {
//				convert từ product thường sang productDTO
				ProductDTO productDTO = new ProductDTO();
				productDTO.setId(p.getId());
				productDTO.setName(p.getName());
				productDTO.setDescription(p.getDescription());
				productDTO.setDetail(p.getDetail());
				productDTO.setPrice(p.getPrice());
				productDTO.setBrand_id(p.getBrand().getId());
				productDTO.setStar_evalue(p.getStar_evalue());
				productDTO.setSize(p.getSize());
				productDTO.setColor(p.getColor());
				productDTO.setCategory_id(p.getCategory().getId());
				productDTO.setQuantity(p.getQuantity());
				productDTO.setMain_img(p.getImage().getId());
				productDTO.setStatus(p.getStatus());

				productDTO.setBrand(brandService.getBrand(p.getBrand().getId()));
				productDTO.setCategory(getCategory(p.getCategory().getId()));
				productDTO.setImg(imgService.getImage(p.getImage().getId()));
				
				productDTOs.add(productDTO);

			}
			categoryDTO.setProductDTOs(productDTOs);

			categoryDTOs.add(categoryDTO);
			
		}

		return categoryDTOs;
	}

	@Override
	public void deleteCategory(int id) {
		Category category = categoryDao.getCategory(id);
		categoryDao.deleteCategory(category);
//		if (category != null) {
//			category.setStatus(0);
//			categoryDao.updateCategory(category);
//		}

	}

	@Override
	public void updateCategory(CategoryDTO categoryDTO) {
		Category category = categoryDao.getCategory(categoryDTO.getId());
		if (category != null) {
			category.setName(categoryDTO.getName());
			category.setStatus(categoryDTO.getStatus());
			categoryDao.updateCategory(category);
		}

	}

	@Override
	public void addCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category.setStatus(1);
		categoryDao.addCategory(category);
	}

	@Override
	public List<CategoryDTO> getAllActiveCategories() {
		List<Category> categories = categoryDao.getAllActiveCategory();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		for (Category c : categories) {
			CategoryDTO categoryDTO = new CategoryDTO(c.getId(), c.getName(), c.getStatus());
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO getCategory(int id) {
		Category category = categoryDao.getCategory(id);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		categoryDTO.setStatus(category.getStatus());

		return categoryDTO;
	}

}
