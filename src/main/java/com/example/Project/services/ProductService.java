package com.example.Project.services;

import java.util.List;

import com.example.Project.entities.Product;
import com.example.Project.model.ProductDTO;

public interface ProductService {
	public void addProduct(ProductDTO productDTO);
	public void updateProduct(ProductDTO productDTO);
	public List<ProductDTO> getAllProduct();
	public ProductDTO getById(int id);
}
