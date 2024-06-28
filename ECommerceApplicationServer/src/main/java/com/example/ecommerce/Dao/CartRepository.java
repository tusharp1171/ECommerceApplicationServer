package com.example.ecommerce.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findByUserId(Long userId);
}
