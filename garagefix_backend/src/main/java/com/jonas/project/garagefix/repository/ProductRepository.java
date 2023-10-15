package com.jonas.project.garagefix.repository;

import com.jonas.project.garagefix.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
