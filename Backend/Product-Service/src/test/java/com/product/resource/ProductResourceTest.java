package com.product.resource;

import com.product.model.Product;
import com.product.service.ProductServiceImpl;
import com.product.service.helper.FileUploadHelper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductResourceTest {

    @Mock
    ProductServiceImpl service;

    @Mock
    FileUploadHelper fileUploadHelper;

    @InjectMocks
    ProductResource resource;

    @Mock
    ServletUriComponentsBuilder builder;

    @Test
    void uploadFile() {
        MockMultipartFile file = new MockMultipartFile("image", "Image.jpeg", MediaType.IMAGE_JPEG_VALUE, new byte[1]);
        resource.uploadFile(file);
        when(fileUploadHelper.uploadFile(file)).thenReturn(true);

    }


    @Test
    void uploadFile4() {
        MockMultipartFile file = new MockMultipartFile("image", "Image.jpeg", MediaType.IMAGE_JPEG_VALUE, new byte[1]);

        when(fileUploadHelper.uploadFile(file)).thenReturn(true);

        when(builder.toUriString()).thenReturn("someurl");
        assertEquals("http://localhost/image/Image.jpeg", resource.uploadFile(file).getBody());

    }


    @Test
    void uploadFile2() {
        MockMultipartFile file = new MockMultipartFile("image", "Image.jpeg", MediaType.IMAGE_GIF_VALUE, new byte[1]);
        resource.uploadFile(file);
        assertEquals("Only Jpeg content is allowed", resource.uploadFile(file).getBody());

    }

    @Test
    void uploadFile3() {
        MockMultipartFile file = new MockMultipartFile("image", "Image.jpeg", MediaType.IMAGE_GIF_VALUE, new byte[0]);
        resource.uploadFile(file);
        assertEquals("Request Must Contain a File", resource.uploadFile(file).getBody());

    }

    @Test
    void addProduct() {
        Product product = new Product();
        resource.addProduct(product);
        verify(service, times(1)).addProducts(product);
    }

    @Test
    void getAllProducts() {
        List<Product> products = new ArrayList<>();
        assertEquals(products, resource.getAllProducts().getBody());
        when(service.getAllProducts()).thenReturn(products);
    }

    @Test
    void getProductById() {
        Product product = new Product();
        product.setProductId("1");
        when(service.getProductById("1")).thenReturn(Optional.of(product));
        assertEquals(product, resource.getProductById("1").getBody().get());
    }

    @Test
    void getProductByType() {
        List<Product> products = new ArrayList<>();

        when(service.getProductByType("Type1")).thenReturn(products);
        assertEquals(products, resource.getProductByType("Type1").getBody());
    }

    @Test
    void getProductByName() {
        Product product = new Product();
        product.setProductName("Name");
        when(service.getProductByName("Name")).thenReturn(Optional.of(product));
        assertEquals(product, resource.getProductByName("Name").getBody().get());
    }

    @Test
    void getProductByCategory() {
        List<Product> products = new ArrayList<>();
        when(service.getProductByCategory("Category")).thenReturn(products);
        assertEquals(products, resource.getProductByCategory("Category").getBody());
    }

    @Test
    void updateProduct() {
        Product product = new Product();

        when(service.updateProduct(product)).thenReturn(product);
        assertEquals(product, resource.updateProduct(product).getBody());
    }

    @Test
    void deleteProduct() {
        String productId = "123";
        resource.deleteProduct(productId);
        verify(service, times(1)).deleteProductById(productId);
    }
}