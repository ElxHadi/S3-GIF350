// InsufficientStockException.java
package com.restaurant.util;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}