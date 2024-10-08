package com.restaurant.model.observer;

import com.restaurant.model.builder.Plat;
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
