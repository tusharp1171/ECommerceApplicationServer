package com.example.ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Dao.ProductRepository;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
@Service
public class ProductServiceimpl implements ProductService{
	 @Autowired
	    private ProductRepository productRepository;
	 	@Override
	    public Product saveProduct(Product product) {
	        return productRepository.save(product);
	    }
	 	@Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
	 	@Override
	    public List<Product> getProductsByCategory(String category) {
	        return productRepository.findByCategory(category);
	    }
	 	@Override
	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
	 	@Override
	    public Product updateProduct(Product product) {
	        return productRepository.save(product);
	    }

}
