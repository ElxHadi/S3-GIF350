package com.restaurant.model.strategy;

import com.restaurant.model.state.Bill;
import com.restaurant.model.state.BillingStrategy;

public class RegularBillingStrategy implements BillingStrategy {
    private static final double TPS_RATE = 0.05; // Example TPS rate BUT NOT IN QUEBEC
    private static final double TVQ_RATE = 0.09975;

    @Override
    public double calculateTotal(Bill bill) {
        double subtotal = bill.getTotalBeforeTaxes();
        double tps = subtotal * TPS_RATE;
        double tvq = subtotal * TVQ_RATE;
        return subtotal + tps + tvq;
    }
}
