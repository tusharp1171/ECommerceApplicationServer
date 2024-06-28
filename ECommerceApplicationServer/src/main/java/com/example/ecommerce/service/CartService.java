package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Cart;

public interface CartService {
	  Cart addProductToCart(Long userId, Long productId, int quantity);
	    List<Cart> getCartsByUserId(Long userId);
	    void clearCart(Long cartId);

}
