package com.example.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.entities.Image;

public interface ImgRepository extends JpaRepository<Image, Integer> {

}
