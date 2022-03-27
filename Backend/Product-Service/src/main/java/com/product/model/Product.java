package com.product.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "products")
public class Product {

	@Id
	private String productId;
	private String productName;
	private String productType;
	private String category;
	private Map<Integer, Double> rating;
	private Map<Integer, String> review;
	private String image;
	private Double price;
	private String description;
	private Map<String, String> specifications;
}
