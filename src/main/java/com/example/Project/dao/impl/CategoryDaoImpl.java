package com.example.Project.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.CategoryDao;
import com.example.Project.entities.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Category> getAllCategory() {
		String jql="SELECT c FROM Category c";
		return entityManager.createQuery(jql,Category.class).getResultList();
	}
	
	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);	
	}

	@Override
	public void deleteCategory(Category category) {
		entityManager.remove(category);
	}
	

	@Override
	public void updateCategory(Category category) {
		entityManager.merge(category);
	}

	@Override
	public Category getCategory(int id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public List<Category> getAllActiveCategory() {
		String jql="SELECT c FROM Category c WHERE c.status=1";
		return entityManager.createQuery(jql,Category.class).getResultList();
	}


}
