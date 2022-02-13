package com.example.Project.dao;

import java.util.List;

import com.example.Project.entities.Brand;

public interface BrandDao {
	public List<Brand> getAllBrands();
	public void addBrand(Brand brand);
	public void deleteBrand(Brand brand);
	public Brand getBrand(int id);
	public void updateBrand(Brand brand);
}
