// Main.java
package com.restaurant;

import com.restaurant.controller.MenuFactController;
import com.restaurant.factory.PlatFactory;
import com.restaurant.model.*;
import com.restaurant.util.PlatType;
import com.restaurant.view.MenuFactView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("Restaurant Menu", new ArrayList<>());

        // Using PlatFactory to create different types of plats
        IPlat regularPlat = PlatFactory.createPlat(PlatType.REGULAR, 1, "Steak", 20.0);
        IPlat kidsPlat = PlatFactory.createPlat(PlatType.KIDS, 2, "Kids Pizza", 12.0, 0.5);
        IPlat healthyPlat = PlatFactory.createPlat(PlatType.HEALTHY, 3, "Salad", 15.0, 200.0, 30.0, 10.0);

        // Adding plats to the menu
        menu.addPlat(regularPlat);
        menu.addPlat(kidsPlat);
        menu.addPlat(healthyPlat);
        
        
        Bill bill = new Bill(new Client(1, "John Doe"));
        bill.addPlat(healthyPlat, 1);
        bill.addPlat(kidsPlat, 1);
        bill.addPlat(regularPlat, 1);

        // Initialize view and controller
        MenuFactView view = new MenuFactView();
        MenuFactController controller = new MenuFactController(menu, bill, view);
        
        // Use the controller to manipulate the view and model
        controller.run();
        // bill.removePlat(1);
        bill.modifyBill(1, 2);
        controller.run();
    }
}
