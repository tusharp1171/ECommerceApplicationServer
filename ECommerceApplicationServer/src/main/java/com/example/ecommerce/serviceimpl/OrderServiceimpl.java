package com.example.ecommerce.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Dao.OrderRepository;
import com.example.ecommerce.Dao.ProductRepository;
import com.example.ecommerce.Dao.UserRepository;
import com.example.ecommerce.exception.OrderPlacementException;
import com.example.ecommerce.exception.UserNotFoundException;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.OrderService;
@Service
public class OrderServiceimpl implements OrderService {
	 @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Override
	    public Order placeOrder(Long userId, List<OrderItem> orderItems) {
	        try {
	            Optional<User> userOpt = userRepository.findById(userId);
	            if (!userOpt.isPresent()) {
	                throw new UserNotFoundException("User not found with id: " + userId);
	            }

	            User user = userOpt.get();

	            Order order = new Order();
	            order.setUser(user);
	            order.setItems(orderItems);
	            order.calculateTotalPrice();
	            order.setOrderDate(new Date());
	            order.setStatus("PLACED");

	            // Adjust inventory or other business logic related to products if needed
	            // For example:
	            // updateProductInventory(orderItems);

	            return orderRepository.save(order);
	        } catch (UserNotFoundException ex) {
	            throw ex;  // Propagate the UserNotFoundException
	        } catch (Exception ex) {
	            throw new OrderPlacementException("Failed to place order: " + ex.getMessage());
	        }
	    }

	    @Override
	    public List<Order> getOrdersByUserId(Long userId) {
	        try {
	            return orderRepository.findByUserId(userId);
	        } catch (Exception ex) {
	            throw new OrderPlacementException("Failed to fetch orders: " + ex.getMessage());
	        }
	    }

	    @Override
	    public Optional<Order> findById(Long id) {
	        try {
	            return orderRepository.findById(id);
	        } catch (Exception ex) {
	            throw new OrderPlacementException("Failed to fetch order by id: " + ex.getMessage());
	        }
	    }
}