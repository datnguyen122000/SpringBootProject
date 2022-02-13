package com.example.Project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.ImgDao;
import com.example.Project.entities.Image;
import com.example.Project.model.ImageDTO;
import com.example.Project.services.ImgService;

@Service
//bắt buộc phải có không thì sẽ không chạy đc
@Transactional
public class ImgServiceImpl implements ImgService {
	@Autowired
	private ImgDao imgDao;

	@Override
	public void addImg(ImageDTO imageDTO) {
		Image img = new Image();
		img.setName(imageDTO.getName());
		img.setStatus(1);
		imgDao.addImg(img);
	}

	@Override
	public List<ImageDTO> getAllImgs() {
		List<Image> imgs = imgDao.getAllImgs();
		List<ImageDTO> imgDtos = new ArrayList<ImageDTO>();
		for (Image i : imgs) {
			ImageDTO imageDTO = new ImageDTO(i.getId(), i.getName(), i.getStatus());
			imgDtos.add(imageDTO);
		}
		return imgDtos;
	}

	@Override
	public void updateImg(ImageDTO imageDTO) {
		Image img = imgDao.getImage(imageDTO.getId());
		// update trong database
		if (img != null) {
			img.setName(imageDTO.getName());
			img.setStatus(imageDTO.getStatus());
			imgDao.updateImg(img);
		}

	}

	@Override
	public ImageDTO getImage(int id) {
		Image image=imgDao.getImage(id);
		ImageDTO imageDTO=new ImageDTO();
		imageDTO.setId(image.getId());
		imageDTO.setName(image.getName());
		imageDTO.setStatus(image.getStatus());
		return imageDTO;
	}

}
