package com.product.model;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductTest {

    static Product product = new Product();

    @Test
    @Order(1)
    void setProductId() {
        product.setProductId("p1");
    }

    @Test
    @Order(2)
    void getProductId() {
        assertEquals("p1",product.getProductId());
    }



    @Test
    @Order(3)
    void setProductName() {
        product.setProductName("Product1");
    }
    @Test
    @Order(4)
    void getProductName() {
        assertEquals("Product1",product.getProductName());
    }



    @Test
    @Order(5)
    void setProductType() {
        product.setProductType("Type1");
    }
    @Test
    @Order(6)
    void getProductType() {
        assertEquals("Type1",product.getProductType());
    }



    @Test
    @Order(7)
    void setCategory() {
        product.setCategory("category1");
    }

    @Test
    @Order(8)
    void getCategory() {
        assertEquals("category1",product.getCategory());
    }



    @Test
    @Order(9)
    void setImage() {
        product.setImage("img");
    }
    @Test
    @Order(10)
    void getImage() {
        assertEquals("img",product.getImage());
    }



    @Test
    @Order(11)
    void setPrice() {
        product.setPrice(120.0);
    }
    @Test
    @Order(12)
    void getPrice() {
        assertEquals(120.0,product.getPrice());
    }


    @Test
    @Order(13)
    void setDescription() {
        product.setDescription("desc");
    }

    @Test
    @Order((14))
    void getDescription() {
        assertEquals("desc",product.getDescription());
    }



    @Test
    @Order(15)
    void testToString() {
        product.toString();
    }
}