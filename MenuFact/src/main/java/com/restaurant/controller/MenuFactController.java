// MenuFactController.java
package com.restaurant.controller;

import com.restaurant.model.Bill;
import com.restaurant.model.IPlat;
import com.restaurant.model.Menu;
import com.restaurant.view.MenuFactView;

public class MenuFactController {
    private final MenuFactView view;
    private final Menu menu;
    private final Bill bill;

    public MenuFactController(Menu menu, Bill bill, MenuFactView view) {
        this.view = view;
        this.menu = menu;
        this.bill = bill;
    }

    public void displayWelcomeMessage() {
        view.showWelcomeMessage();
    }

    public void displayMenu() {
        view.displayMenu(menu);  // Pass the model to the view
    }

    public void displayBill() {
        view.displayBill(bill);  // Pass the model to the view
    }

    public void addPlatToBill(int code, int quantity) {
        IPlat plat = menu.getPlatByCode(code);
        if (plat != null) {
            bill.addPlat(plat, quantity);
        } else {
            System.out.println("Plat not found");
        }
    }

    public void run() {
        displayWelcomeMessage();
        displayMenu();
        displayBill();
    }
}