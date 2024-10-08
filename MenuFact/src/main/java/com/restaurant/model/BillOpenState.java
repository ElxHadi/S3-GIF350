package com.restaurant.model;

public class BillOpenState implements BillState {
    @Override
    public void handle(BillContext context) {
        context.setState(new BillClosedState());
    }
}
