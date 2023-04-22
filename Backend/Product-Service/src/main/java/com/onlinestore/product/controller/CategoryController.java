package com.onlinestore.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.product.entity.Category;
import com.onlinestore.product.service.CategoryService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@RestController
@CrossOrigin
@RequestMapping("category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/allCategories")
	public ResponseEntity<Object> allCategories() {
		return ResponseEntity.ok(categoryService.getAllCategory());
	}

	@PutMapping("/updateCategory")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.updateCategory(category));
	}

	@DeleteMapping("/deleteCategory/{categoryId}")
	public void deleteCategory(@PathVariable Integer categoryId) {
		categoryService.deleteCategoryById(categoryId);
	}

	@PostMapping("/addCategory")
	public ResponseEntity<Object> addCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.addCategory(category));
	}

}
