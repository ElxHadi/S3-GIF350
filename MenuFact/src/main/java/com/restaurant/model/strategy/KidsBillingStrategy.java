package com.restaurant.model.strategy;

import com.restaurant.model.state.Bill;
import com.restaurant.model.state.BillingStrategy;

public class KidsBillingStrategy implements BillingStrategy {
    @Override
    public double calculateTotal(Bill bill) {
        // Kids plat is exempt from TPS and TVQ Lucky KIDS :(
        return bill.getTotalBeforeTaxes();
    }
}
