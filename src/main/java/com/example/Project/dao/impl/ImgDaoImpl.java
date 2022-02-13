package com.example.Project.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.ImgDao;
import com.example.Project.entities.Category;
import com.example.Project.entities.Image;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;
@Repository
@Transactional
public class ImgDaoImpl implements ImgDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addImg(Image image) {
		entityManager.persist(image);
	}

	@Override
	public List<Image> getAllImgs() {
		String jql="SELECT i FROM Image i";
		return entityManager.createQuery(jql,Image.class).getResultList();
	}

	@Override
	public void updateImg(Image image) {
		entityManager.merge(image);
		
	}

	@Override
	public Image getImage(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Image.class, id);
	}

}
