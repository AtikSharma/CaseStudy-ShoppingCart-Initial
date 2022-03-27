package com.order.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Items {
	private String productId;
	private String productName;
	private String image;
	private Double price;
	private int quantity;
}
