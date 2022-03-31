package com.product.resource;

import com.product.model.Category;
import com.product.service.category.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoryResourceTest {

    @Mock
    CategoryServiceImpl service;

    @InjectMocks
    CategoryResource resource;

    @Test
    void allCategories() {
        List<Category> categoryList = new ArrayList<>();
        assertEquals(categoryList,resource.allCategories().getBody());
        when(service.getAllCategory()).thenReturn(categoryList);
    }

    @Test
    void updateCategory() {
        Category category = new Category("123","categoryNameNew");
        when(service.updateCategory(category)).thenReturn(category);
        assertEquals(category,resource.updateCategory(category).getBody());
    }

    @Test
    void deleteCategory() {
        String CategoryId = "123";
        resource.deleteCategory(CategoryId);
        verify(service,times(1)).deleteCategoryById(CategoryId);
    }

    @Test
    void addCategory() {
        Category category = new Category("123","categoryName");
        when(service.addCategory(category)).thenReturn(category);
        assertEquals(category,resource.addCategory(category).getBody());

    }
}