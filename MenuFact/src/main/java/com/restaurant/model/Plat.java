// Plat.java
package com.restaurant.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Plat implements IPlat {
    private int code;
    private String description;
    private double prix;

    public Plat(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
    }
}
