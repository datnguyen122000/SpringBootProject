package com.example.Project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.BrandDao;
import com.example.Project.dao.CategoryDao;
import com.example.Project.entities.Brand;
import com.example.Project.entities.Category;
import com.example.Project.model.BrandDTO;
import com.example.Project.model.CategoryDTO;
import com.example.Project.services.BrandService;
@Service
//bắt buộc phải có không thì sẽ không chạy đc
@Transactional
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;

	@Override
	public List<BrandDTO> getAllBrands() {
		List<Brand> brands = brandDao.getAllBrands();
		List<BrandDTO> brandDTOs = new ArrayList<BrandDTO>();
		for (Brand b : brands) {
			BrandDTO brandDTO = new BrandDTO(b.getId(), b.getName(), b.getStatus());
			brandDTOs.add(brandDTO);
		}
		return brandDTOs;
	}

	@Override
	public void addBrand(BrandDTO brandDTO) {
		Brand brand=new Brand();
		brand.setName(brandDTO.getName());
		brand.setStatus(1);
		brandDao.addBrand(brand);
	}

	@Override
	public void deleteBrand(int id) {
		Brand brand=brandDao.getBrand(id);
		if(brand!=null) {
			brand.setStatus(0);
			brandDao.updateBrand(brand);
		}
	}

	@Override
	public void updateBrand(BrandDTO brandDTO) {
		Brand brand=brandDao.getBrand(brandDTO.getId());
		if(brand!=null) {
			brand.setName(brandDTO.getName());
			brand.setStatus(brandDTO.getStatus());
			brandDao.updateBrand(brand);
		}
		
	}

	@Override
	public BrandDTO getBrand(int id) {
		Brand brand=brandDao.getBrand(id);
		BrandDTO brandDTO=new BrandDTO();
		brandDTO.setId(brand.getId());
		brandDTO.setName(brand.getName());
		brandDTO.setStatus(brand.getStatus());
		return brandDTO;
	}

}
