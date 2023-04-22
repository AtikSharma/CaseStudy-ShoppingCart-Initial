package com.onlinestore.product.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class GetAllProductsResponse {

	private List<ProductResponse> products;
}
