// HealthyPlat.java
package com.restaurant.model;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthyPlat extends Plat {
    private double calories;
    private double cholesterol;
    private double fat;

    public HealthyPlat(int code, String description, HashMap<Ingredient, Double> ingredients,
            double calories, double cholesterol, double fat) {
        super(code, description, ingredients);
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
