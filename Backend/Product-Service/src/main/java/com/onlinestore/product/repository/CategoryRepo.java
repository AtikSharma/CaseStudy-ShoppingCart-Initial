package com.onlinestore.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.product.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
