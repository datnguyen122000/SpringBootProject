package com.example.Project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.SpringTemplateLoader;

import com.example.Project.model.MessageDTO;
import com.example.Project.services.EmailService;

public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	
	
	@Override
	public void sendEmail(MessageDTO messageDTO) {
		// TODO Auto-generated method stub
		
	}

}
