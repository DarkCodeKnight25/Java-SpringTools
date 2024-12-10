package com.example.CrudSpring.repository;

import com.example.CrudSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
