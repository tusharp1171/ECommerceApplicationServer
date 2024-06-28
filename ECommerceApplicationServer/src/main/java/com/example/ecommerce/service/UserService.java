package com.example.ecommerce.service;

import java.util.Optional;

import com.example.ecommerce.model.User;

public interface UserService {
	 User registerUser(User user);
	    User loginUser(String username, String password);
	    Optional<User> findById(Long id);
}
