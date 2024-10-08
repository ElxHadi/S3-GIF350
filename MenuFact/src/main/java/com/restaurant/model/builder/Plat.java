// Plat.java
package com.restaurant.model.builder;

import java.util.HashMap;
import java.util.Map;
import com.restaurant.model.factory.Ingredient;
import com.restaurant.model.state.Bill;
import com.restaurant.model.state.BillingStrategy;
import com.restaurant.model.strategy.RegularBillingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Plat {
    private int code;
    private String description;
    private HashMap<Ingredient, Double> ingredients;
    private BillingStrategy billingStrategy;
    
    public Plat() {
        this.code = 0;
        this.description = "";
        this.ingredients = new HashMap<>();
        billingStrategy = new RegularBillingStrategy();
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

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public double calculateTaxExemptedPrice(Bill bill) {
        return billingStrategy != null ? billingStrategy.calculateTotal(bill) : getPlatPrice();
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
        return "Plat {" + "Code: " + code + ", Description: '" + description + '\''
                + ", platPrice: " + getPlatPrice() + ", Ingredients: " + ingredients + '}';
    }

}
