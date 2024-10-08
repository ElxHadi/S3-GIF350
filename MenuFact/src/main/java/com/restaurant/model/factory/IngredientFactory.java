// IngredientFactory.java
package com.restaurant.model.factory;

import com.restaurant.util.IngredientType;
import com.restaurant.util.IngredientUnit;

public class IngredientFactory {
    // Factory method to create an ingredient
    public static Ingredient createIngredient(int code, String name, IngredientType type, double pricePerUnit, IngredientUnit unit) {
        return new Ingredient(code, name, type, pricePerUnit, unit);
    }
}
