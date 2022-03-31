package com.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
	Optional<Product> findByproductName(String productName);
	List<Product> findBycategory(String category);
	List<Product> findByproductType(String productType);
}
