// Ingredient.java
package com.restaurant.model;

import com.restaurant.util.IngredientType;
import com.restaurant.util.IngredientUnit;
import lombok.*;

// Lombok annotations can remain for other purposes, such as getters and setters.
@Getter
@Setter
public class Ingredient {
    private int code;
    private String name;
    private IngredientType type; // Enum for solid/liquid
    private double pricePerUnit;
    private IngredientUnit unit; // Enum for kg, g, mg, L, ml

    // Private constructor to restrict instantiation
    public Ingredient(int code, String name, IngredientType type, double pricePerUnit, IngredientUnit unit) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.pricePerUnit = pricePerUnit;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("Ingredient { Code: %d, Name: '%s', Price: %.2f, Unit: %s, Type: %s }", 
            code, name, pricePerUnit, unit, type);
    }
}
