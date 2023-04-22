package com.onlinestore.product.model;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class CreateProductRequest {

	@NotBlank(message = "Product Name can't be null")
	private String productName;

	private String productType;

	@NotBlank(message = "Product must have a category")
	private Integer categoryId;

//	@NotBlank(message = "Image Can't be null")
	private String image;

	@Min(value = 500, message = "Minimum value must be 500")
	@Max(value = 150000, message = "Maximum value must be 150000")
	private Double price;

	private String description;
}
