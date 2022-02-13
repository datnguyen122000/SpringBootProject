package com.example.Project.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.ProductDao;
import com.example.Project.entities.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
	}

	@Override
	public List<Product> getAllProduct() {
		String jql="SELECT p FROM Product p";
		return entityManager.createQuery(jql,Product.class).getResultList();
	}
	
	

}
