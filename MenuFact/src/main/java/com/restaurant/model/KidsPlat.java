// KidsPlat.java
package com.restaurant.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class KidsPlat extends Plat {
    private double proportion;

    public KidsPlat(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }
}
