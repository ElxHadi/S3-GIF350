package com.restaurant.model.observer;

import com.restaurant.model.builder.Plat;

public interface Observer {
    void update(Plat plat);
}
