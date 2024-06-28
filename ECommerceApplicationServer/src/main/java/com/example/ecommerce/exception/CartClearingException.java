package com.example.ecommerce.exception;

public class CartClearingException extends RuntimeException {
    public CartClearingException(String message) {
        super(message);
    }
}