package com.onlinestore.product.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onlinestore.product.entity.Product;
import com.onlinestore.product.model.CreateProductRequest;
import com.onlinestore.product.service.ProductService;
import com.onlinestore.product.service.util.FileUploadHelper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@RestController
@CrossOrigin
@RequestMapping("product")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	FileUploadHelper fileUploadHelper;

	@Autowired
	ProductService productService;

	@PostMapping("/uploadImage")
	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file) {

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain a File");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg content is allowed");
			}
			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
				String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
						.path(file.getOriginalFilename()).toUriString();
//				return  ResponseEntity.ok("File is successfull upload");
				logger.info(url);
				return ResponseEntity.ok(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong try again");
	}

	@PostMapping()
	public ResponseEntity<Object> addProduct(@RequestBody CreateProductRequest createProductRequest) {
		return new ResponseEntity<>(productService.addProduct(createProductRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<Object> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable("productId") Integer id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@GetMapping("/type/{productType}")
	public ResponseEntity<Object> getProductByType(@PathVariable("productType") String type) {
		return new ResponseEntity<>(productService.getProductByType(type), HttpStatus.OK);
	}

	@GetMapping("/name/{productName}")
	public ResponseEntity<Object> getProductByName(@PathVariable("productName") String name) {
		return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.OK);
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<Object> getProductByCategory(@PathVariable("category") Integer category) {
		return new ResponseEntity<>(productService.getProductByCategoryId(category), HttpStatus.OK);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<Object> updateProduct(@RequestBody CreateProductRequest createProductRequest, @PathVariable("productId") Integer productId) {
		return new ResponseEntity<>(productService.updateProduct(createProductRequest,productId), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Integer id) {
		productService.deleteProductById(id);
		return new ResponseEntity<>(id + " was deleted successfully! ", HttpStatus.OK);
	}

}
