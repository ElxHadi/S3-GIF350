package com.restaurant;

import com.restaurant.model.builder.Plat;
import com.restaurant.model.builder.PlatBuilder;
import com.restaurant.model.factory.Ingredient;
import com.restaurant.model.factory.IngredientFactory;
import com.restaurant.model.observer.Chef;
import com.restaurant.model.singleton.Inventory;
import com.restaurant.model.state.Bill;
import com.restaurant.model.strategy.HealthyBillingStrategy;
import com.restaurant.model.strategy.KidsBillingStrategy;
import com.restaurant.model.strategy.RegularBillingStrategy;
import com.restaurant.util.IngredientType;
import com.restaurant.util.IngredientUnit;
import com.restaurant.util.PlatType;
import com.restaurant.util.InsufficientStockException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("=== Singleton Pattern Test ===");
            Inventory inventory = Inventory.getInstance();

            // Add ingredients
            Ingredient tomato = IngredientFactory.createIngredient(1, "Tomato",
                    IngredientType.SOLID, 1.23, IngredientUnit.KG);
            Ingredient cheese = IngredientFactory.createIngredient(2, "Cheese",
                    IngredientType.SOLID, 7, IngredientUnit.G);
            inventory.addIngredient(tomato, 10);
            inventory.addIngredient(cheese, 5);
            System.out.println(inventory);

            System.out.println("=== Observer Pattern Test ===");
            Bill platSubject = new Bill();
            Chef chef1 = new Chef("Gordon");
            platSubject.registerObserver(chef1);

            // Create plat and notify observers (check for inventory)
            try {
                Plat kidsPlat = new PlatBuilder(PlatType.KIDS).setCode(1)
                        .setDescription("Kids Pizza")
                        .addIngredient(IngredientFactory.createIngredient(3, "Tomato",
                                IngredientType.SOLID, 1.23, IngredientUnit.KG), 0.5)
                        .addIngredient(IngredientFactory.createIngredient(4, "Cheese",
                                IngredientType.SOLID, 7, IngredientUnit.G), 0.3)
                        .setBillingStrategy(new KidsBillingStrategy()).setExtraParams(0.5).build();

                platSubject.notifyObservers(kidsPlat); // Notify chefs

            } catch (InsufficientStockException e) {
                System.err.println("Error in Observer Test: " + e.getMessage());
            }

            System.out.println("=== Builder Pattern Test ===");
            PlatBuilder anotherBuilder = new PlatBuilder(PlatType.REGULAR);
            Plat myRegularPlat = anotherBuilder.setCode(2).setDescription("Regular Pasta")
                    .addIngredient(IngredientFactory.createIngredient(5, "Tomato",
                            IngredientType.SOLID, 1.23, IngredientUnit.KG), 0.5)
                    .addIngredient(IngredientFactory.createIngredient(6, "Cheese",
                            IngredientType.SOLID, 7, IngredientUnit.G), 0.2)
                    .setBillingStrategy(new RegularBillingStrategy()).setExtraParams(0.5).build();
            System.out.println("Built Plat: " + myRegularPlat);

            System.out.println("=== Strategy Pattern Test ===");
            Bill bill = new Bill();
            bill.addPlat(myRegularPlat, 1);

            // Regular Billing
            RegularBillingStrategy regularStrategy = new RegularBillingStrategy();
            double regularTotal = regularStrategy.calculateTotal(bill);
            System.out.println("Regular Billing Total: " + regularTotal);

            // Kids Billing
            Plat kidsPlat = new PlatBuilder(PlatType.KIDS).setCode(3).setDescription("Kids Meal")
                    .addIngredient(tomato, 0.3).setBillingStrategy(new KidsBillingStrategy())
                    .build();
            bill.addPlat(kidsPlat, 1);
            KidsBillingStrategy kidsStrategy = new KidsBillingStrategy();
            double kidsTotal = kidsStrategy.calculateTotal(bill);
            System.out.println("Kids Billing Total: " + kidsTotal);

            // Healthy Billing
            Plat healthyPlat = new PlatBuilder(PlatType.HEALTHY).setCode(4)
                    .setDescription("Healthy Salad").addIngredient(tomato, 0.4)
                    .setBillingStrategy(new HealthyBillingStrategy()).build();
            bill.addPlat(healthyPlat, 1);
            HealthyBillingStrategy healthyStrategy = new HealthyBillingStrategy();
            double healthyTotal = healthyStrategy.calculateTotal(bill);
            System.out.println("Healthy Billing Total: " + healthyTotal);

            System.out.println("=== Complete Order Test ===");
            Bill completeOrderBill = new Bill();
            completeOrderBill.addPlat(kidsPlat, 2);
            System.out.println("Total with Regular Billing Strategy: "
                    + regularStrategy.calculateTotal(completeOrderBill));
            System.out.println("Total with Kids Billing Strategy: "
                    + kidsStrategy.calculateTotal(completeOrderBill));
            System.out.println("Total with Healthy Billing Strategy: "
                    + healthyStrategy.calculateTotal(completeOrderBill));

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
