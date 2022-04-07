package com.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product_entity")
public class Product {

	@Id
	private String productId;
	@NotBlank(message = "Product Name can't be null")
	private String productName;
	private String productType;
	@NotBlank(message = "Product must have a category")
	private String category;
	@NotBlank(message = "Image Can't be null")
	private String image;
	@Min(value = 500,message = "Minimum value must be 500")
	@Max(value = 150000,message = "Maximum value must be 150000")
	private Double price;
	private String description;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}