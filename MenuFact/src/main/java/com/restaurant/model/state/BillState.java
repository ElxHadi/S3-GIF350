package com.restaurant.model.state;

public interface BillState {
    void handle(BillContext context);
}
