package com.order.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	private String productId;
	private String productName;
	private String image;
	private Double price;
	private int quantity;

}
