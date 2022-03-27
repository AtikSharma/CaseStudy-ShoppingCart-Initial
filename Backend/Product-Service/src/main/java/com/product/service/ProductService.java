package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
	
	void addProducts(Product product);
	List<Product> getAllProducts();
	Optional<Product> getProductById(String productId);
	Optional<Product> getProductByName(String productName);
	List<Product> getProductByCategory(String category);
	List<Product> getProductByType(String productType);
	
	Product updateProduct(Product product);
	
	void deleteProductById(String productId);
	

}
