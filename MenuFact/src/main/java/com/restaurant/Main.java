// Main.java
package com.restaurant;

import java.util.ArrayList;
import com.restaurant.controller.MenuFactController;
import com.restaurant.model.*;
import com.restaurant.view.MenuFactView;

public class Main {
    public static void main(String[] args) {
    Menu menu = new Menu("Restaurant Menu", new ArrayList<>());
    Bill bill = new Bill(new Client(1, "John Doe"));
    MenuFactView view = new MenuFactView(menu, bill);
    MenuFactController controller = new MenuFactController(view);
        
    controller.run(); // Start the application flow
}

}
