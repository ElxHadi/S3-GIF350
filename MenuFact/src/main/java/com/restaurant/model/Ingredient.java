// Ingredient.java
package com.restaurant.model;

import com.restaurant.util.IngredientType;
import com.restaurant.util.IngredientUnit;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Ingredient {
    private int code;
    private String name;
    private IngredientType type; // Enum for solid/liquid
    private double pricePerUnit;
    private IngredientUnit unit; // Enum for kg, g, mg, L, ml

    public Ingredient() {
        this.code = 0; // Default code
        this.name = ""; // Default name
        this.type = IngredientType.SOLID; // Default type
        this.pricePerUnit = 0.0; // Default price
        this.unit = IngredientUnit.G; // Default unit
    }

    @Override
    public String toString() {
        return "Ingredient {" + "Code: " + code + ", Name: '" + name + '\'' + ", Type: " + type
                + ", Price Per Unit: " + pricePerUnit + ", Unit: " + unit + '}';
    }


}
