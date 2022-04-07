package com.cart.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cart.model.Cart;
import com.cart.model.Items;
import com.cart.model.ProductDetail;
import com.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Cart getCartById(String id) {
		return cartRepo.findBycartId(id);
	}

	@Override
	public List<Cart> getAllCarts() {
		return cartRepo.findAll();
	}

	@Override
	@KafkaListener(topics = "CartId" , groupId = "online-shopping-app" , containerFactory = "kafkaListenerContainerFactory")
	public void addCart(String userId) {
		cartRepo.save(new Cart(userId, 0, new ArrayList<>()));
	}

	@Override
	public Cart addToCart(Items item, String userId) {
		boolean isQuantityUpdated = false;
		Cart cartFromDb = cartRepo.findBycartId(userId); //finding cart by userId
		item = getPriceOfItem(item); //getting price of the items of the new cart
		
		for(Items dbCartItem: cartFromDb.getItems())
		{
			if(item.getProductId().equals(dbCartItem.getProductId())) //checking for same items
			{
				dbCartItem.setQuantity(item.getQuantity()+dbCartItem.getQuantity()); //updating quantity in db
				isQuantityUpdated = true;
				break;
			}
		}
		
		if(isQuantityUpdated == false) //if all items are new
		{
			cartFromDb.getItems().add(item); // adding them to previously added items
			cartFromDb.setItems(cartFromDb.getItems()); // saving in db
		}
		cartFromDb.setTotalPrice(cartTotal(cartFromDb)); // updating the cart total value
		return cartRepo.save(cartFromDb); //saving cart
	}
	
	@Override
	public Cart updateCart(Cart tempCart) {
		tempCart = getPriceOfItems(tempCart);
		tempCart.setTotalPrice( cartTotal(tempCart));
		return cartRepo.save(tempCart);
	}


	// helper Methods --------------------------------------------------------------------
	@Override
	public double cartTotal(Cart cart) {
	double totalCartValue = cart.getItems().stream().flatMapToDouble(i -> DoubleStream.of(i.getPrice()*i.getQuantity())).sum();
		return totalCartValue;
	}
	
	private Cart getPriceOfItems(Cart cart) {
		cart.getItems().stream().forEach(i -> {
			i.setPrice(getDeocodedUrl(i).getPrice());
			i.setProductId(getDeocodedUrl(i).getProductId());
		});
		cart.setTotalPrice( cartTotal(cart));
		return cart;
	}
	
	private Items getPriceOfItem(Items item) {
		item.setProductId(getDeocodedUrl(item).getProductId());
		item.setPrice(getDeocodedUrl(item).getPrice());
		item.setImage(getDeocodedUrl(item).getImage());
		return item;
	}
	
	private ProductDetail getDeocodedUrl(Items item) {
		String decodedUrl = "";
		try {
			decodedUrl = URLDecoder.decode("http://product-service/product/getProduct/name/" + item.getProductName(),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("URL DECODING FAILED");
			e.printStackTrace();
		}
		return this.restTemplate.getForObject(decodedUrl, ProductDetail.class);
	}


//	---------------------------------------------------------------------------------------------------
//	private Cart getTotalPriceOfCartItems(Cart cart) {
//	double totalPrice = 0;
//	List<Items> items = cart.getItems();
//	for (Items item : items) {
//		String decodedUrl = "";
//		try {
//			decodedUrl = URLDecoder
//					.decode("http://product-service/product/getProduct/name/" + item.getProductName(), "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		ProductDetail product = this.restTemplate.getForObject(decodedUrl, ProductDetail.class);
//		item.setPrice(product.getPrice());
//		totalPrice += item.getPrice() * item.getQuantity();
//	}
//	cart.setTotalPrice(totalPrice);
//	return cart;
//}

	
//	private Cart updateItemQuantity(Cart tempCart, String userId) {
//		Cart cartFromDb = getCartById(userId); 
//	
//		tempCart.getItems().stream()
//			.forEach(i -> {
//				Items items = getItemFromDb(i.getProductName(),userId);
//				
//			});
////		tempCart = getPriceOfItems(tempCart);
////
////		Cart cartDetailsFromDB = getCartById(tempCart.getCartId());
////
////		cartDetailsFromDB.setTotalPrice(cartDetailsFromDB.getTotalPrice() + tempCart.getTotalPrice());
////
////		tempCart.getItems().stream().sequential().collect(Collectors.toCollection(() -> cartDetailsFromDB.getItems()));
////
////		cartDetailsFromDB.setItems(cartDetailsFromDB.getItems());
////
//		return cartFromDb;
//	}
	
//	@Override
//	public Cart addToCart(Cart cart, String userId) {
//		Cart cartFromDb = cartRepo.findBycartId(userId);
//		cart = getPriceOfItems(cart);
//		cart.getItems().stream()
//				.sequential()
//				.collect(Collectors.toCollection(() -> cartFromDb.getItems()));
//		cartFromDb.setTotalPrice(cartFromDb.getTotalPrice() + cart.getTotalPrice());
//		return cartRepo.save(cartFromDb);
//	}
}
