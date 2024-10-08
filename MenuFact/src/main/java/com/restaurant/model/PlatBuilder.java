package com.restaurant.model;

import com.restaurant.util.PlatType;

import java.util.HashMap;

public class PlatBuilder {
    private PlatType type;
    private int code;
    private String description;
    private HashMap<Ingredient, Double> ingredients;
    private double[] extraParams;

    public PlatBuilder(PlatType type) {
        this.type = type;
        this.ingredients = new HashMap<>();
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
        this.ingredients.put(ingredient, quantity);
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
                    return new KidsPlat(code, description, ingredients, extraParams[0]);
                } else {
                    throw new IllegalArgumentException("Missing parameters for KidsPlat");
                }
            case HEALTHY:
                if (extraParams.length >= 3) {
                    return new HealthyPlat(code, description, ingredients, extraParams[0], extraParams[1], extraParams[2]);
                } else {
                    throw new IllegalArgumentException("Missing parameters for HealthyPlat");
                }
            default:
                return new Plat(code, description, ingredients);
        }
    }
}
