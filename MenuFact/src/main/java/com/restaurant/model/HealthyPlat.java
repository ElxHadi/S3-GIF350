// HealthyPlat.java
package com.restaurant.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class HealthyPlat extends Plat {
    private double calories;
    private double cholesterol;
    private double fat;

    public HealthyPlat(int code, String description, double prix, double calories, double cholesterol, double fat) {
        super(code, description, prix);
        this.calories = calories;
        this.cholesterol = cholesterol;
        this.fat = fat;
    }
}
