package com.product;

import com.product.model.Category;
import com.product.model.Product;
import com.product.repository.CategoryRepo;
import com.product.service.category.CategoryServiceImpl;
import org.antlr.stringtemplate.language.Cat;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class CategoryServiceTest {

    @Mock
    CategoryRepo repo;

    @InjectMocks
    CategoryServiceImpl service;

    static List<Category> catgories;
    @BeforeAll
    static void  init()
    {
        catgories = new ArrayList<Category>();
        catgories.add(new Category("1","Category1"));
        catgories.add(new Category("5","Category5"));
        catgories.add(new Category("4","Category4"));
        catgories.add(new Category("3","Category3"));
        catgories.add(new Category("2","Category2"));
    }

    @Test
    @Order(1)
    @DisplayName("getAllCategory")
    void allCategories() {
        when(repo.findAll()).thenReturn(catgories); //Mocking
        assertEquals(5, service.getAllCategory().size());
    }

    @Test
    @Order(2)
    @DisplayName("UpdateCategory")
    void updateCategory() {
        Category updateCategory = new Category("5","UpdatedCategory5");
        when(repo.save(updateCategory)).thenReturn(updateCategory); //Mocking
        assertEquals(updateCategory, service.updateCategory(updateCategory));
    }

    @Test
    @Order(3)
    @DisplayName("AddCategory")
    void addCategory() {
        Category newCategory = new Category("8","Category8");
        when(repo.save(newCategory)).thenReturn(newCategory); //Mocking
        assertEquals(newCategory, service.addCategory(newCategory));
    }

    @Test
    @Order(4)
    @DisplayName("deleteCategory")
    void deleteCategory() {
        String categoryId = "4";
        service.deleteCategoryById(categoryId);
        verify(repo,times(1)).deleteById(categoryId);
    }

}
