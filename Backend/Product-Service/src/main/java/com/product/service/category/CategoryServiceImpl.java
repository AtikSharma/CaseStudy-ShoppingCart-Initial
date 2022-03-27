package com.product.service.category;

import com.product.model.Category;
import com.product.model.Product;
import com.product.repository.CategoryRepo;
import com.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
	public void deleteCategoryById(String categoryId) {
		repo.deleteById(categoryId);
	}
}
