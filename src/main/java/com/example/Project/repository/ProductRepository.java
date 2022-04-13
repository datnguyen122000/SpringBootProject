package com.example.Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name like :txtSearch or p.detail like :txtSearch or p.description like :txtSearch ")
    List<Product> search(@Param("txtSearch") String txtSearch);
    
}
