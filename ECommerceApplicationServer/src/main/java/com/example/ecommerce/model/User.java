package com.example.ecommerce.model;

import java.util.Set;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data	
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Username is mandatory")
	    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
	    private String username;

	    @NotBlank(message = "Password is mandatory")
	    @Size(min = 8, message = "Password must be at least 8 characters long")
	    private String password;

	    @NotBlank(message = "Role is mandatory")
	    private String role; // e.g., ADMIN, CUSTOMER

	    @Email(message = "Email should be valid")
	    private String email;

	    @NotBlank(message = "First name is mandatory")
	    private String firstName;

	    @NotBlank(message = "Last name is mandatory")
	    private String lastName;

	    private String address;
	    private String phoneNumber;

	    @OneToMany(mappedBy = "user")
	    private Set<Order> orders;

	    @OneToMany(mappedBy = "user")
	    private Set<Cart> carts;

}
