package com.restaurant.model.state;

public interface BillingStrategy {
    double calculateTotal(Bill bill);
}
