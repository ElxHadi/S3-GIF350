package com.restaurant;

import java.util.ArrayList;
import javax.naming.InsufficientResourcesException;
import com.restaurant.controller.MenuFactController;
import com.restaurant.exception.InsufficientStockException;
import com.restaurant.model.IngredientFactory;
import com.restaurant.model.Inventory;
import com.restaurant.model.Bill;
import com.restaurant.model.Client;
import com.restaurant.model.Ingredient;
import com.restaurant.model.Menu;
import com.restaurant.model.Plat;
import com.restaurant.util.IngredientType;
import com.restaurant.util.IngredientUnit;
import com.restaurant.util.PlatType;
import com.restaurant.view.MenuFactView;
import com.restaurant.model.PlatBuilder;

// Main.java
public class Main {
        public static void main(String[] args) {
                // Create ingredients using IngredientFactory
                Ingredient salt = IngredientFactory.createIngredient(1, "Salt",
                                IngredientType.SOLID, 1.0, IngredientUnit.G);
                Ingredient water = IngredientFactory.createIngredient(2, "Water",
                                IngredientType.LIQUID, 1.0, IngredientUnit.L);
                Ingredient cheese = IngredientFactory.createIngredient(3, "Cheese",
                                IngredientType.SOLID, 4.0, IngredientUnit.G);

                // Initialize inventory and add ingredients
                Inventory inventory = Inventory.getInstance();
                inventory.addIngredient(salt, 5.0); // Add 5g of salt
                inventory.addIngredient(water, 2.0); // Add 2L of water
                inventory.addIngredient(cheese, 3.0); // Add 3g of cheese


                // Create KidsPlat using PlatBuilder
                try {
                        Plat kidsPlat = new PlatBuilder(PlatType.KIDS).setCode(1)
                                        .setDescription("Kids Pizza").addIngredient(salt, 1.0) // 1g
                                                                                               // of
                                                                                               // salt
                                        .addIngredient(water, 1.0) // 1L of water
                                        .addIngredient(cheese, 1.0) // 1g of cheese
                                        .setExtraParams(0.5).build();

                        Plat kidsPlat2 = new PlatBuilder(PlatType.KIDS).setCode(1)
                                        .setDescription("Kids dish").addIngredient(salt, 1.0) // 1g
                                                                                               // of
                                                                                               // salt
                                        .addIngredient(water, 1.0) // 1L of water
                                        .addIngredient(cheese, 1.0) // 1g of cheese
                                        .setExtraParams(0.5).build();
                        // Create a menu and add plat
                        Menu menu = new Menu("Restaurant Menu", new ArrayList<>());
                        menu.addPlat(kidsPlat);
                        menu.addPlat(kidsPlat2);

                        Client elhadi = new Client(1, "elhadi");
                        Bill bill = new Bill(elhadi);

                        bill.addPlat(kidsPlat, 1); // Add 1 Kids Pizza
                        bill.addPlat(kidsPlat2, 1); // Add 1 dish Pizza
                        // // Initialize view and controller
                        MenuFactView view = new MenuFactView();
                        MenuFactController controller = new MenuFactController(menu, bill, view);
                        controller.run();
                } catch (InsufficientStockException e) {
                        System.out.println("Error creating plat: " + e.getMessage());
                }
        }
}
