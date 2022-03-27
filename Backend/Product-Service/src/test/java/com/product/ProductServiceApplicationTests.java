package com.product;

import com.product.model.Product;
import com.product.repository.ProductRepo;
import com.product.service.ProductServiceImpl;
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
class ProductServiceApplicationTests {

    static List<Product> products;
    @Mock
    ProductRepo repo;
    @InjectMocks
    ProductServiceImpl service;

    @BeforeAll
    static void init() {
        products = new ArrayList<Product>();
        products.add(new Product("1", "Product1", "Type1", "Category1", null, null, null, 1200.0, "TestProduct1", null));
        products.add(new Product("2", "Product2", "Type2", "Category2", null, null, null, 1900.0, "TestProduct2", null));
        products.add(new Product("3", "Product3", "Type1", "Category2", null, null, null, 300.0, "TestProduct3", null));
        products.add(new Product("4", "Product4", "Type3", "Category3", null, null, null, 300.0, "TestProduct4", null));
    }

    @Test
    @Order(1)
    @DisplayName("GetAllProducts")
    void testProductService() {
        when(repo.findAll()).thenReturn(products); //Mocking
        assertEquals(products.size(), service.getAllProducts().size());
    }

    @Test
    @Order(2)
    @DisplayName("getProductById")
    void productById() {
        String productId = "2";
        when(repo.findById(productId)).thenReturn(products.stream().filter(product -> product.getProductId() == productId).findFirst()); //Mocking
        assertEquals(productId, service.getProductById(productId).get().getProductId());
    }

    @Test
    @Order(3)
    @DisplayName("getProductByName")
    void productByName() {
        String name = "Product3";
        when(repo.findByproductName(name)).thenReturn(products.stream().filter(product -> product.getProductName() == name).findFirst()); //Mocking
        assertEquals(name, service.getProductByName(name).get().getProductName());
    }

    @Test
    @Order(4)
    @DisplayName("getProductByCategory")
    void productByCatgory() {
        String category = "Category2";
        when(repo.findBycategory(category)).thenReturn(products.stream().filter(product -> product.getCategory() == category).collect(Collectors.toList())); //Mocking
        assertEquals(2, service.getProductByCategory(category).size());
    }

    @Test
    @Order(5)
    @DisplayName("getProductByType")
    void productByType() {
        String type = "Type1";
        when(repo.findByproductType(type)).thenReturn(products.stream().filter(product -> product.getProductType() == type).collect(Collectors.toList())); //Mocking
        assertEquals(2, service.getProductByType(type).size());
    }

    @Test
    @Order(6)
    @DisplayName("UpdateProduct")
    void updateProduct() {
        Product updateProduct = new Product("4", "UpdatedProduct4", "Type3", "Category3", null, null, null, 300.0, "UpdateTestProduct4", null);
        when(repo.save(updateProduct)).thenReturn(updateProduct); //Mocking
        assertEquals(updateProduct, service.updateProduct(updateProduct));
    }

    @Test
    @Order(6)
    @DisplayName("AddProduct")
    void addProduct() {
        Product newProduct = new Product("5", "newProduct", "Type3", "Category3", null, null, null, 300.0, "newTestProduct5", null);
        service.addProducts(newProduct);
        verify(repo,times(1)).save(newProduct);
    }

    @Test
    @Order(7)
    @DisplayName("DeleteProduct")
    void deleteProduct() {
        String productId = "4";
        service.deleteProductById(productId);
        verify(repo,times(1)).deleteById(productId); //checking for the no of calls of repo method for the given input
    }


}
