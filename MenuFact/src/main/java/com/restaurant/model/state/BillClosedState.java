package com.restaurant.model.state;

public class BillClosedState implements BillState {
    @Override
    public void handle(BillContext context) {
        context.setState(new BillPaidState());
    }
    
    public void reopen(BillContext context) {
        context.setState(new BillOpenState());
    }
}