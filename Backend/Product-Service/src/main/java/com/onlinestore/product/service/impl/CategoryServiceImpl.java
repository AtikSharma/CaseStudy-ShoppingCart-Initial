package com.onlinestore.product.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.product.entity.Category;
import com.onlinestore.product.repository.CategoryRepo;
import com.onlinestore.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo repo;

	@Override
	public Category addCategory(Category category) {
		return repo.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return repo.findAll();
	}

	@Override
	public Category updateCategory(Category category) {
		return repo.save(category);
	}

	@Override
	public void deleteCategoryById(Integer categoryId) {
		repo.deleteById(categoryId);
	}
}
