package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Product;

public interface ProductService {
	Product saveProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    void deleteProduct(Long id);
    Product updateProduct(Product product); 

}
