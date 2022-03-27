package com.product.resource;

import com.product.model.Category;
import com.product.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("category")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/allCategories")
    public ResponseEntity<List<Category>> allCategories()
    {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

@PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category)
    {
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

@DeleteMapping("/deleteCategory/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId)
    {
        categoryService.deleteCategoryById(categoryId);
    }

@PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category category)
    {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

}
