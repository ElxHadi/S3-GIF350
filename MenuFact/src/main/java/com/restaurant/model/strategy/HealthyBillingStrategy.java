package com.restaurant.model.strategy;

import com.restaurant.model.state.Bill;
import com.restaurant.model.state.BillingStrategy;

public class HealthyBillingStrategy implements BillingStrategy {
    private static final double HEALTHY_FOOD_DISCOUNT = 0.10; // 10% discount YEP !!

    @Override
    public double calculateTotal(Bill bill) {
        double subtotal = bill.getTotalBeforeTaxes();
        return subtotal - (subtotal * HEALTHY_FOOD_DISCOUNT);
    }
}
