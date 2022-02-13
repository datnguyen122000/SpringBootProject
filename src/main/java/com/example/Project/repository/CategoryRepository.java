package com.example.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
