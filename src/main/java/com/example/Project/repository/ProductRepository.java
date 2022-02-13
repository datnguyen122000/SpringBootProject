package com.example.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
