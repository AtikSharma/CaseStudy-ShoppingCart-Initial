package com.onlinestore.product.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.onlinestore.product.entity.Category;
import com.onlinestore.product.entity.Product;
import com.onlinestore.product.model.CreateProductRequest;
import com.onlinestore.product.model.GetAllProductsResponse;
import com.onlinestore.product.model.ProductResponse;

@Component
public class ProductMapper {

	public GetAllProductsResponse buildGetAllProductResponse(List<Product> products) {
		return GetAllProductsResponse.builder()
				.products(products.stream().map(this::buildProductResponse).collect(Collectors.toList())).build();
	}

	public ProductResponse buildProductResponse(Product product) {
		return ProductResponse.builder().productId(product.getProductId())
				.category(product.getCategory().getCategoryName()).image(product.getImage()).price(product.getPrice())
				.productName(product.getProductName()).productType(product.getProductType())
				.productDescription(product.getDescription()).build();
	}

	public Product buildProduct(CreateProductRequest createProductRequest, Category category) {
		return Product.builder().category(category).productName(createProductRequest.getProductName())
				.description(createProductRequest.getDescription()).image(createProductRequest.getImage())
				.price(createProductRequest.getPrice()).productType(createProductRequest.getProductType()).build();
	}

	public Product updateProduct(CreateProductRequest createProductRequest, Category category, Product product) {
		return product.toBuilder().category(category).productName(createProductRequest.getProductName())
				.description(createProductRequest.getDescription()).image(createProductRequest.getImage())
				.price(createProductRequest.getPrice()).productType(createProductRequest.getProductType()).build();
	}
}
