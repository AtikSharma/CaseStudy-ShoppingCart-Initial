package com.product.service.category;

import com.product.model.Category;
import com.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
	
	Category addCategory(Category category);
	List<Category> getAllCategory();
	Category updateCategory(Category category);
	void deleteCategoryById(String categoryId);
	

}
