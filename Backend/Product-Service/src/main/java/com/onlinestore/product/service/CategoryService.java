package com.onlinestore.product.service;

import java.util.List;

import com.onlinestore.product.entity.Category;

public interface CategoryService {

	Category addCategory(Category category);

	List<Category> getAllCategory();

	Category updateCategory(Category category);

	void deleteCategoryById(Integer categoryId);

}
