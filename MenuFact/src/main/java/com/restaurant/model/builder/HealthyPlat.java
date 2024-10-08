// HealthyPlat.java
package com.restaurant.model.builder;

import java.util.HashMap;
import com.restaurant.model.factory.Ingredient;
import com.restaurant.model.state.BillingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthyPlat extends Plat {
    private double calories;
    private double cholesterol;
    private double fat;

    public HealthyPlat(int code, String description, HashMap<Ingredient, Double> ingredients,
            double calories, double cholesterol, double fat, BillingStrategy billingStrategy) {
        super(code, description, ingredients, billingStrategy);
        this.calories = calories;
        this.cholesterol = cholesterol;
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Plat {" + "Code: " + super.getCode() + ", Description: '" + super.getDescription()
                + '\'' + ", platPrice: " + getPlatPrice() + ", Ingredients: "
                + super.getIngredients() + ", Calories: " + calories + ", Cholesterol: "
                + cholesterol + ", Fat: " + fat + "}";
    }
}
