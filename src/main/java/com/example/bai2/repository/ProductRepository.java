package com.example.bai2.repository;

import com.example.bai2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByCreatedAtDesc();

    List<Product> findByCategoryIdOrderByCreatedAtDesc(Long categoryId);

    long countByActiveTrue();
}
