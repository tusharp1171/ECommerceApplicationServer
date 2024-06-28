package com.example.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Dao.CartRepository;
import com.example.ecommerce.Dao.ProductRepository;
import com.example.ecommerce.exception.CartClearingException;
import com.example.ecommerce.exception.CartNotFoundException;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CartService;
@Service
public class CartServiceimpl implements CartService {
	 @Autowired
	    private CartRepository cartRepository;

	    @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public Cart addProductToCart(Long userId, Long productId, int quantity) {
	        try {
	            // Fetch cart by userId or create new if not exists
	            List<Cart> carts = cartRepository.findByUserId(userId);
	            Cart cart = carts.isEmpty() ? new Cart() : carts.get(0);

	            Optional<Product> productOpt = productRepository.findById(productId);
	            if (!productOpt.isPresent()) {
	                throw new ProductNotFoundException("Product not found");
	            }

	            Product product = productOpt.get();
	            CartItem cartItem = new CartItem();
	            cartItem.setProduct(product);
	            cartItem.setQuantity(quantity);

	            cart.getItems().add(cartItem);
	            cart.calculateTotalPrice();

	            return cartRepository.save(cart);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to add product to cart: " + e.getMessage());
	        }
	    }

	    @Override
	    public List<Cart> getCartsByUserId(Long userId) {
	        try {
	            List<Cart> carts = cartRepository.findByUserId(userId);
	            if (carts.isEmpty()) {
	                throw new CartNotFoundException("Cart not found for user with id: " + userId);
	            }
	            return carts;
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to retrieve carts for user: " + e.getMessage());
	        }
	    }

	    @Override
	    public void clearCart(Long cartId) {
	        try {
	            cartRepository.deleteById(cartId);
	        } catch (Exception e) {
	            throw new CartClearingException("Failed to clear cart with id: " + cartId);
	        }
	    }

}
