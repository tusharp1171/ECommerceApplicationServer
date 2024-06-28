package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderItem;

public interface OrderService {

	 Order  placeOrder(Long userId, List<OrderItem> orderItems);
	    List<Order> getOrdersByUserId(Long userId);
	    Optional<Order> findById(Long id);
}
