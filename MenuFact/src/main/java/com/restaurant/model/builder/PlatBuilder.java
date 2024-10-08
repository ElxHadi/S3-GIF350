// PlatBuilder.java
package com.restaurant.model.builder;

import com.restaurant.model.factory.Ingredient;
import com.restaurant.model.singleton.Inventory;
import com.restaurant.model.state.BillingStrategy;
import com.restaurant.util.InsufficientStockException;
import com.restaurant.util.PlatType;
import java.util.HashMap;

public class PlatBuilder {
    private PlatType type;
    private int code;
    private String description;
    private HashMap<Ingredient, Double> ingredients = new HashMap<>();
    private double[] extraParams;
    private BillingStrategy billingStrategy;

    public PlatBuilder(PlatType type) {
        this.type = type;
        this.ingredients = new HashMap<>();
    }

    public PlatBuilder setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
        return this;
    }

    public PlatBuilder setCode(int code) {
        this.code = code;
        return this;
    }

    public PlatBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PlatBuilder addIngredient(Ingredient ingredient, double quantity) {
        Inventory inventory = Inventory.getInstance();

        // Check availability in inventory
        if (!inventory.checkAvailability(ingredient, quantity)) {
            throw new InsufficientStockException(
                    "Not enough stock for ingredient: " + ingredient.getName());
        }

        // Add the ingredient to the plat
        this.ingredients.put(ingredient, quantity);
        // Update the inventory by reducing the stock
        inventory.removeIngredient(ingredient, quantity);

        return this;
    }

    public PlatBuilder setExtraParams(double... extraParams) {
        this.extraParams = extraParams;
        return this;
    }

    public Plat build() {
        switch (type) {
            case KIDS:
                if (extraParams.length >= 1) {
                    return new KidsPlat(code, description, ingredients, extraParams[0],
                            billingStrategy);
                } else {
                    throw new IllegalArgumentException("Missing parameters for KidsPlat");
                }
            case HEALTHY:
                if (extraParams.length >= 3) {
                    return new HealthyPlat(code, description, ingredients, extraParams[0],
                            extraParams[1], extraParams[2], billingStrategy);
                } else {
                    throw new IllegalArgumentException("Missing parameters for HealthyPlat");
                }
            default:
                return new Plat(code, description, ingredients, billingStrategy);
        }
    }
}
