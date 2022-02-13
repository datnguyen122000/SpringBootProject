package com.example.Project.services;

import java.util.List;

import com.example.Project.model.ImageDTO;

public interface ImgService {
	public void addImg(ImageDTO imageDTO);
	public List<ImageDTO> getAllImgs();
	public void updateImg(ImageDTO imageDTO);
	public ImageDTO getImage(int id);
}
