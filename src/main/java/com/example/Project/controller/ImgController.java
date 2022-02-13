package com.example.Project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Project.dao.ImgDao;
import com.example.Project.entities.Image;
import com.example.Project.model.ImageDTO;
import com.example.Project.services.ImgService;

@Controller
@RequestMapping("/img-management")
public class ImgController {
	@Autowired
	private ImgService imgService;

	@Autowired
	private ImgDao imgDao;

	@GetMapping("/imgs")
	public String getAllImgs(HttpServletRequest request) {
		List<ImageDTO> imgs = imgService.getAllImgs();
		request.setAttribute("imgs", imgs);
		return "image_management";
	}

	@PostMapping("/add-img")
	public String addImg(@RequestParam("img") MultipartFile img) {
		// lưu file vào một folder
		try {
			File newFile = new File("../Project/src/main/webapp/Image/" + img.getOriginalFilename());
			FileOutputStream fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(img.getBytes());
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add to db
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setName(img.getOriginalFilename());
		imgService.addImg(imageDTO);
		return "redirect:/img-management/imgs";
	}

	@PostMapping("/update-img")
	public String updateImg(@ModelAttribute ImageDTO imageDTO, @RequestParam("img") MultipartFile img) {
		// vì Model Attribute lấy về name null nên phải gán lại giá trị cho imageDTO
		imageDTO.setName(imgDao.getImage(imageDTO.getId()).getName());
		if (!img.isEmpty()) {
			// vì Model Attribute lấy về name null nên phải gán lại giá trị cho imageDTO
			imageDTO.setName(imgDao.getImage(imageDTO.getId()).getName());
			File file = new File("../Project/src/main/webapp/Image/" + imageDTO.getName());
			// xóa ảnh cũ
			if (file.exists())
				file.delete();

			// ghi ảnh mới chọn
			try {
				File newFile = new File("../Project/src/main/webapp/Image/" + img.getOriginalFilename());
				FileOutputStream fileOutputStream = new FileOutputStream(newFile);
				fileOutputStream.write(img.getBytes());
				fileOutputStream.close();

				imageDTO.setName(img.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		imgService.updateImg(imageDTO);

		return "redirect:/img-management/imgs";
	}
}
