package com.example.Project.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.BrandDao;
import com.example.Project.entities.Brand;
@Repository
@Transactional
public class BrandDaoImpl implements BrandDao  {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Brand> getAllBrands() {
		String jql="SELECT c FROM Brand c";
		return entityManager.createQuery(jql,Brand.class).getResultList();
	}

	@Override
	public void addBrand(Brand brand) {
		entityManager.persist(brand);
	}

	@Override
	public void deleteBrand(Brand brand) {
		entityManager.remove(brand);
	}

	@Override
	public Brand getBrand(int id) {
		return entityManager.find(Brand.class, id);
	}

	@Override
	public void updateBrand(Brand brand) {
		entityManager.merge(brand);
	}
	
}
