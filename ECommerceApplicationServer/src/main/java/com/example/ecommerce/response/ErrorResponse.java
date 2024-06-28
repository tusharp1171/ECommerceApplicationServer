package com.example.ecommerce.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	  private LocalDateTime timestamp;
	    private String message;
	    private int status;

}
