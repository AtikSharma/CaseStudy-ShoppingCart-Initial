package com.product.model;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryTest {

    static Category category = new Category();

    @Test
    @Order(1)
    void setCategoryName() {
        category.setCategoryName("Name");
    }

    @Test
    @Order(2)
    void setCategoryId() {
        category.setCategoryId("123");
    }

    @Test
    @Order(3)
    void getCategoryName() {
        assertEquals("Name",category.getCategoryName());
    }

    @Test
    @Order(4)
    void getCategoryId() {
        assertEquals("123",category.getCategoryId());
    }


    @Test
    void testToString() {
        category.toString();
    }
}