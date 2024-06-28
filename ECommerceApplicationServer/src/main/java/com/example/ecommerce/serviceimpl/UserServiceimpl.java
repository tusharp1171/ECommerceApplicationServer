package com.example.ecommerce.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Dao.UserRepository;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
@Service
public class UserServiceimpl implements UserService{
	 @Autowired
	    private UserRepository userRepository;
	 
	 @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	 @Override
	 public User registerUser(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }
	 @Override

	    public User loginUser(String username, String password) {
	        User user = userRepository.findByUsername(username);
	        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
	            return user;
	        }
	        return null;
	    }
	 	@Override
	    public Optional<User> findById(Long id) {
	        return userRepository.findById(id);
	    }
}
