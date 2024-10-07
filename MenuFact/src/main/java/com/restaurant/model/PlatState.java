package com.restaurant.model;

import com.restaurant.util.BillState;

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
