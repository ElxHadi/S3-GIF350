// Plat.java
package com.restaurant.model;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
public class Plat {
    private int code;
    private String description;
    private HashMap<Ingredient, Double> ingredients = new HashMap<>();

    public Plat() {
        this.code = 0;
        this.description = "";
        this.ingredients = new HashMap<>();
    }

    public void addIngredient(Ingredient ingredient, double quantity) {
        ingredients.put(ingredient, quantity);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public void updateIngredientQuantity(Ingredient ingredient, double quantity) {
        if (ingredients.containsKey(ingredient)) {
            ingredients.put(ingredient, quantity);
        }
    }

    // Method to calculate total ingredient cost
    public double getPlatPrice() {
        double platPrice = 0.0;
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            platPrice += entry.getKey().getPricePerUnit() * entry.getValue();
        }
        return platPrice;
    }

    // Method to list all ingredients
    public void listIngredients() {
        System.out.println("Ingredients for " + description + ":");
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            System.out.println("- " + entry.getKey().getName() + ": " + entry.getValue() + " "
                    + entry.getKey().getUnit());
        }
    }

    @Override
    public String toString() {
        return "Plat {" + "Code: " + code + ", Description: '" + description + '\'' + ", platPrice: "
                + getPlatPrice() + ", Ingredients: " + ingredients + '}';
    }

}
