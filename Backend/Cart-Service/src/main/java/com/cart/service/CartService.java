package com.cart.service;

import java.util.List;

import com.cart.model.Cart;
import com.cart.model.Items;

public interface CartService {
	
	void addCart(String userId);

	double cartTotal(Cart cart);
	
	List<Cart> getAllCarts();
	
	Cart getCartById(String cartId);
	
	//Cart addToCart(Cart cart,String userId);
	
	Cart addToCart(Items item,String userId);
	Cart updateCart(Cart cart);
	
}
