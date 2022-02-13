package com.example.Project.dao;

import java.util.List;

import com.example.Project.entities.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public List<Product> getAllProduct();
}
