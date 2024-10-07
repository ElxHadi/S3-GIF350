package com.restaurant.model;

public class PlatState {
    private BillState state;

    public PlatState(BillState state) {
        this.state = state;
    }

    public BillState getState() {
        return state;
    }

    public void setState(BillState state) {
        this.state = state;
    }
}
