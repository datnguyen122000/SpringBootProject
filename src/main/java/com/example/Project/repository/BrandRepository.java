package com.example.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
