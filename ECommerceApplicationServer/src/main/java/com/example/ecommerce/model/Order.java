package com.example.ecommerce.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
@Data
public class Order {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    private User user;

	    @OneToMany(cascade = CascadeType.ALL)
	    private List<OrderItem> items;

	    @PastOrPresent(message = "Order date cannot be in the future")
	    private Date orderDate;

	    @DecimalMin(value = "0.0", message = "Total price must be zero or more")
	    private double totalPrice;

	    @NotBlank(message = "Status is mandatory")
	    private String status;

	    public void calculateTotalPrice() {
	        totalPrice = items.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
	    }
}
