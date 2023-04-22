package com.onlinestore.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class ProductResponse {
	Integer productId;
	String productName;
	Double price;
	String category;
	String productType;
	String productDescription;
	String image;
}
