package com.example.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.Dao.OrderItemRepository;
import com.example.ecommerce.exception.OrderItemSaveException;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.service.OrderItemService;

public class OrderItemServiceImpl  implements OrderItemService{
	
	 @Autowired
	    private OrderItemRepository orderItemRepository;

	 @Override
	    public OrderItem saveOrderItem(OrderItem orderItem) {
	        try {
	            return orderItemRepository.save(orderItem);
	        } catch (Exception e) {
	            throw new OrderItemSaveException("Failed to save order item: " + e.getMessage());
	        }
	    }
}
