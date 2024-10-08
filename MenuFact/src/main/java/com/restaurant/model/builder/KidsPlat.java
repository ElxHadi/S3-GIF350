// KidsPlat.java
package com.restaurant.model.builder;

import java.util.HashMap;
import com.restaurant.model.factory.Ingredient;
import com.restaurant.model.state.BillingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KidsPlat extends Plat {
    private double proportion;

    public KidsPlat(int code, String description, HashMap<Ingredient, Double> ingredients,
            double proportion, BillingStrategy billingStrategy) {
        super(code, description, ingredients, billingStrategy);
        this.proportion = proportion;
    }

    @Override
    public double getPlatPrice() {
        return super.getPlatPrice() * proportion;
    }

    // Calculate total ingredient cost
    @Override
    public String toString() {
        return String.format("KidsPlat { Code: %d, Description: '%s', Price: %.2f, Ingredients: %s }", 
            super.getCode(), super.getDescription(), getPlatPrice(), super.getIngredients());
    }
}
