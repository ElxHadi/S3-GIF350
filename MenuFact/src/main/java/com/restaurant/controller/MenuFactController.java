package com.restaurant.controller;

import com.restaurant.view.MenuFactView;

public class MenuFactController {
    private MenuFactView view;

    public MenuFactController(MenuFactView view) {
        this.view = view;
    }

    public void run() {
        view.showWelcomeMessage();
        view.displayMenu();
        view.displayBill();
    }
}
