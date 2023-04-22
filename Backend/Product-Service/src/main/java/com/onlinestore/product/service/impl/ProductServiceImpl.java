package com.onlinestore.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.product.entity.Category;
import com.onlinestore.product.entity.Product;
import com.onlinestore.product.mapper.ProductMapper;
import com.onlinestore.product.model.CreateProductRequest;
import com.onlinestore.product.model.GetAllProductsResponse;
import com.onlinestore.product.model.ProductResponse;
import com.onlinestore.product.repository.CategoryRepo;
import com.onlinestore.product.repository.ProductRepo;
import com.onlinestore.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final CategoryRepo categoryRepository;
	private final ProductRepo productRepository;
	private final ProductMapper productMapper;

	@Autowired
	ProductServiceImpl(ProductRepo productRepository, ProductMapper productMapper, CategoryRepo categoryRepository) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public GetAllProductsResponse getAllProducts() {
		return productMapper.buildGetAllProductResponse(productRepository.findAll());
	}

	@Override
	public ProductResponse getProductById(Integer productId) {

		Optional<Product> productOptional = productRepository.findById(productId);

		ProductResponse productRepsonse = null;
		if (!productOptional.isEmpty()) {
			productRepsonse = productMapper.buildProductResponse(productOptional.get());
		}

		return productRepsonse;
	}

	@Override
	public ProductResponse getProductByName(String productName) {

		Optional<Product> productOptional = productRepository.findByproductName(productName);

		ProductResponse productRepsonse = null;
		if (!productOptional.isEmpty()) {
			productRepsonse = productMapper.buildProductResponse(productOptional.get());
		}

		return productRepsonse;

	}

	@Override
	public List<Product> getProductByCategoryId(Integer categoryId) {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

		Category category = null;
		if (!optionalCategory.isEmpty()) {
			category = optionalCategory.get();
		}

		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> getProductByType(String productType) {
		return productRepository.findByproductType(productType);
	}

	@Override
	public ProductResponse addProduct(CreateProductRequest createProductRequest) {
		Optional<Category> optionalCategory = categoryRepository.findById(createProductRequest.getCategoryId());

		Category category = null;
		if (!optionalCategory.isEmpty()) {
			category = optionalCategory.get();
		}

		Product product = productRepository.save(productMapper.buildProduct(createProductRequest, category));

		return productMapper.buildProductResponse(product);
	}

	@Override
	public ProductResponse updateProduct(CreateProductRequest createProductRequest, Integer productId) {

		Optional<Product> optionalProduct = productRepository.findById(productId);
		Product updatedProduct = null;
		if (!optionalProduct.isEmpty()) {
			Product savedProduct = optionalProduct.get();

			Optional<Category> optionalCategory = categoryRepository.findById(createProductRequest.getCategoryId());
			Category category = null;
			if (!optionalCategory.isEmpty()) {
				category = optionalCategory.get();
			}

			updatedProduct = productRepository
					.save(productMapper.updateProduct(createProductRequest, category, savedProduct));
		}

		return productMapper.buildProductResponse(updatedProduct);
	}

	@Override
	public void deleteProductById(Integer productId) {
		productRepository.deleteById(productId);
	}

}
