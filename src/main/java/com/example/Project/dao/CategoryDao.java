package com.example.Project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Project.entities.Category;

public interface CategoryDao {
	public List<Category> getAllCategory();
	public void addCategory(Category category);
	public void deleteCategory(Category category);
	public void updateCategory(Category category);
	public Category getCategory(int id);
	public List<Category> getAllActiveCategory();
}
