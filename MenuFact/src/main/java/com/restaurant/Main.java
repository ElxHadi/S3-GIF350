package com.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import com.restaurant.controller.MenuFactController;
import com.restaurant.model.IngredientFactory;
import com.restaurant.model.Bill;
import com.restaurant.model.Ingredient;
import com.restaurant.model.Menu;
import com.restaurant.model.Plat;
import com.restaurant.util.IngredientType;
import com.restaurant.util.IngredientUnit;
import com.restaurant.util.PlatType;
import com.restaurant.view.MenuFactView;
import com.restaurant.model.PlatBuilder;

public class Main {
    public static void main(String[] args) {

        // Create ingredients using IngredientFactory
        Ingredient salt = IngredientFactory.createIngredient(1, "Salt", IngredientType.SOLID, 1.0,
                IngredientUnit.G);
        Ingredient water = IngredientFactory.createIngredient(2, "Water", IngredientType.LIQUID,
                1.0, IngredientUnit.L);
        Ingredient cheese = IngredientFactory.createIngredient(3, "Cheese", IngredientType.SOLID,
                4.0, IngredientUnit.G);

        // Create KidsPlat using PlatBuilder
        Plat kidsPlat = new PlatBuilder(PlatType.KIDS).setCode(1).setDescription("Kids Pizza")
                .addIngredient(salt, 1.0).addIngredient(water, 1.0).addIngredient(cheese, 1.0)
                .setExtraParams(0.5).build();


        // Create a menu and plats
        Menu menu = new Menu("Restaurant Menu", new ArrayList<>());
        menu.addPlat(kidsPlat);

        Bill bill = new Bill();
        bill.addPlat(kidsPlat, 1); // Add 1 Kids Pizza

        // Initialize view and controller
        MenuFactView view = new MenuFactView();
        MenuFactController controller = new MenuFactController(menu, bill, view);
        controller.run();
    }
}
