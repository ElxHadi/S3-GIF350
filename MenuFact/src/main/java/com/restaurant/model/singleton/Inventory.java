// Inventory.java
package com.restaurant.model.singleton;

import java.util.HashMap;
import com.restaurant.model.factory.Ingredient;
import com.restaurant.util.InsufficientStockException;

public class Inventory {
    private static Inventory instance;
    private HashMap<Ingredient, Double> stock;

    private Inventory() {
        stock = new HashMap<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addIngredient(Ingredient ingredient, double quantity) {
        stock.put(ingredient, stock.getOrDefault(ingredient, 0.0) + quantity);
    }

    public void removeIngredient(Ingredient ingredient, double quantity) {
        if (!checkAvailability(ingredient, quantity)) {
            throw new InsufficientStockException("Not enough stock to remove ingredient: " + ingredient.getName());
        }
        stock.put(ingredient, stock.get(ingredient) - quantity);
        if (stock.get(ingredient) <= 0) {
            stock.remove(ingredient);
        }
    }

    public boolean checkAvailability(Ingredient ingredient, double quantity) {
        double availableQuantity = stock.getOrDefault(ingredient, 0.0);
    
        return availableQuantity >= quantity;
    }

    @Override
    public String toString() {
        StringBuilder inventoryStr = new StringBuilder("Inventory:\n");
        stock.forEach((ingredient, quantity) ->
            inventoryStr.append(String.format("- %s: %.2f %s%n", ingredient.getName(), quantity, ingredient.getUnit())));
        return inventoryStr.toString();
    }
}