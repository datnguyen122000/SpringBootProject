package com.example.Project.services;

import java.util.List;
import com.example.Project.model.CategoryDTO;

//cac ham trong service su dung cac doi tuong la DTO
public interface CategoryService {
	public List<CategoryDTO> getAllCategories();
	public void deleteCategory(int id);
	public void updateCategory(CategoryDTO categoryDTO);
	public void addCategory(CategoryDTO categoryDTO);
	public List<CategoryDTO> getAllActiveCategories();
	public CategoryDTO getCategory(int id);
}
