
package com.restaurant.controller;

import com.restaurant.model.Client;
import com.restaurant.model.Menu;
import com.restaurant.model.state.Bill;
import com.restaurant.view.MenuFactView;

public class MenuFactController {
    private final MenuFactView view;
    private final Menu menu;
    private final Bill bill;

    public MenuFactController() {
        this.view = new MenuFactView();
        this.menu = new Menu();
        this.bill = new Bill(new Client());
    }

    public MenuFactController(Menu menu, Bill bill, MenuFactView view) {
        this.view = view;
        this.menu = menu;
        this.bill = bill;
    }

    public void displayWelcomeMessage() {
        view.showWelcomeMessage();
    }

    public void displayMenu() {
        view.displayMenu(menu);
    }

    public void displayBill() {
        view.displayBill(bill);
    }

    public void run() {
        displayWelcomeMessage();
        displayMenu();
        displayBill();
    }
}
