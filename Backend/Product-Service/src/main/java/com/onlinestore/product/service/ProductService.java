package com.onlinestore.product.service;

import java.util.List;

import com.onlinestore.product.entity.Product;
import com.onlinestore.product.model.CreateProductRequest;
import com.onlinestore.product.model.GetAllProductsResponse;
import com.onlinestore.product.model.ProductResponse;

public interface ProductService {

	ProductResponse addProduct(CreateProductRequest createProductRequest);

	GetAllProductsResponse getAllProducts();

	ProductResponse getProductById(Integer productId);

	ProductResponse getProductByName(String productName);

	List<Product> getProductByCategoryId(Integer categoryId);

	List<Product> getProductByType(String productType);

	ProductResponse updateProduct(CreateProductRequest createProductRequest, Integer productId);

	void deleteProductById(Integer productId);

}
