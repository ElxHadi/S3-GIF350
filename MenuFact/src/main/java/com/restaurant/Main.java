package com.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import com.restaurant.controller.MenuFactController;
import com.restaurant.factory.PlatFactory;
import com.restaurant.model.Bill;
import com.restaurant.model.Ingredient;
import com.restaurant.model.Menu;
import com.restaurant.model.Plat;
import com.restaurant.util.IngredientType;
import com.restaurant.util.IngredientUnit;
import com.restaurant.util.PlatType;
import com.restaurant.view.MenuFactView;

public class Main {
    public static void main(String[] args) {
        // Define ingredients
        Ingredient salt = new Ingredient(1, "Salt", IngredientType.SOLID, 1.0, IngredientUnit.G);
        Ingredient water = new Ingredient(2, "Water", IngredientType.LIQUID, 1.0, IngredientUnit.L);
        Ingredient cheese =
                new Ingredient(4, "Cheese", IngredientType.SOLID, 4.0, IngredientUnit.G);

        // Create ingredients map for KidsPlat
        HashMap<Ingredient, Double> kidsPlatIngredients = new HashMap<>();
        kidsPlatIngredients.put(salt, 1.0);
        kidsPlatIngredients.put(water, 1.0);
        kidsPlatIngredients.put(cheese, 1.0);

        // Create KidsPlat
        Plat kidsPlat =
                PlatFactory.createPlat(PlatType.KIDS, 1, "Kids Pizza", kidsPlatIngredients,0.5);

        // // Create a menu and plats
        Menu menu = new Menu("Restaurant Menu", new ArrayList<>());

        // // Adding plats to the menu
        menu.addPlat(kidsPlat);
       
        Bill bill = new Bill();

        // // Adding plats to the bill
        bill.addPlat(kidsPlat, 1); // Add 2 Kids Pizza

        // // Modifying the bill
        // bill.modifyBill(1, 3); // Change quantity of Kids Pizza to 3

        // // Closing the bill
        // bill.close();

        // Initialize view and controller
        MenuFactView view = new MenuFactView();
        MenuFactController controller = new MenuFactController(menu, bill, view);
        controller.run();
    }
}
