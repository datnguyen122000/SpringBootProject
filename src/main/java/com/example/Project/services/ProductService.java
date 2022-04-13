package com.example.Project.services;

import java.util.List;

import com.example.Project.entities.Product;
import com.example.Project.model.ProductDTO;

public interface ProductService { 
	public void addProduct(ProductDTO productDTO);
	public void updateProduct(ProductDTO productDTO);
	public List<ProductDTO> getAllProduct();
	public ProductDTO getById(int id);
	public List<ProductDTO> productSearch(String txtSearch);
	//offset là số page bắt đầu (tính từ 0)
	public List<ProductDTO> productByPaging(int offset, int pageSize);
}
