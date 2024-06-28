package com.example.ecommerce.model;

import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class Product {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is mandatory")
	    private String name;

	    @NotBlank(message = "Description is mandatory")
	    private String description;

	    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
	    private double price;

	    @Min(value = 0, message = "Quantity must be zero or more")
	    private int quantity;

	    private String imageUrl;
	    private String category;

	    @OneToMany(mappedBy = "product")
	    private Set<CartItem> cartItems;

	    @OneToMany(mappedBy = "product")
	    private Set<OrderItem> orderItems;

}
