package com.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Chef implements Observer {
    private String name;

    @Override
    public void update(Plat plat) {
        System.out.println(
                "Chef " + name + " notified: Preparing the plat - " + plat.getDescription());
    }

}
