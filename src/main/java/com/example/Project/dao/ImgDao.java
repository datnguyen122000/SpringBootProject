package com.example.Project.dao;

import java.util.List;

import com.example.Project.entities.Image;

public interface ImgDao {
	public void addImg(Image image);
	public List<Image> getAllImgs();
	public void updateImg(Image image);
	public Image getImage(int id);
}
