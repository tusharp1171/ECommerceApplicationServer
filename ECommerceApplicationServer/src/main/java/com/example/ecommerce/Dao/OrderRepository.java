package com.example.ecommerce.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByUserId(Long userId);
}
