package com.restaurant.model;


public class BillContext {
    private BillState currentState;

    public BillContext(BillState initialState) {
        this.currentState = initialState;
    }

    public BillState getCurrentState() {
        return currentState;
    }
    public void setState(BillState newState) {
        this.currentState = newState;
    }

    public void request() {
        currentState.handle(this);
    }
}
