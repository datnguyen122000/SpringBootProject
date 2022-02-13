package com.example.Project.services;

import java.util.List;

import com.example.Project.model.BrandDTO;

public interface BrandService {
	public List<BrandDTO> getAllBrands();
	public void addBrand(BrandDTO brandDTO);
	public void deleteBrand(int id);
	public void updateBrand(BrandDTO brandDTO);
	public BrandDTO getBrand(int id);
}
