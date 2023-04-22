package com.onlinestore.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.product.entity.Category;
import com.onlinestore.product.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	Optional<Product> findByproductName(String productName);

	List<Product> findByCategory(Category category);

	List<Product> findByproductType(String productType);
}
