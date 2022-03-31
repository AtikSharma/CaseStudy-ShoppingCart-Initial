package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepo;
import com.product.resource.ProductResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo repo;



    @Override
    public void addProducts(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        repo.save(product);
    }


    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        return repo.findById(productId);
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return repo.findByproductName(productName);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return repo.findBycategory(category);
    }

    @Override
    public List<Product> getProductByType(String productType) {
        return repo.findByproductType(productType);
    }

    @Override
    public Product updateProduct(Product product) {

        return repo.save(product);
    }

    @Override
    public void deleteProductById(String productId) {
        repo.deleteById(productId);
    }

}
