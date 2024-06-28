package com.example.ecommerce.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
  List<Product> findByCategory(String category);
}
