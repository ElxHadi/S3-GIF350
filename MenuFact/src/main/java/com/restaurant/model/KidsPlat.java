// KidsPlat.java
package com.restaurant.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KidsPlat extends Plat {
    private double proportion;

    public KidsPlat(int code, String description, HashMap<Ingredient, Double> ingredients,
            double proportion) {
        super(code, description, ingredients);
        this.proportion = proportion;
    }

    @Override
    public double getPlatPrice() {
        return super.getPlatPrice() * proportion;
    }

    // Calculate total ingredient cost
    @Override
    public String toString() {

        return "Plat {" + "Code: " + super.getCode() + ", Description: '" + super.getDescription()
                + '\'' + ", platPrice: " + getPlatPrice() + ", Ingredients: "
                + super.getIngredients() + '}';
    }
}
