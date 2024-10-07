package com.restaurant.view;

import com.restaurant.model.*;

public class MenuFactView {

    private Menu menu;
    private Bill bill;
    private final String wlcMessage = "Welcome to the MenuFact Application!";

    public MenuFactView(Menu menu, Bill bill) {
        this.menu = menu;
        this.bill = bill;
    }

    public void displayMenu() {
        System.out.println("=== Menu: ===");
        for (IPlat plat : menu.getPlats()) {
            System.out.println(plat);
        }
    }

    public void displayBill() {
        System.out.println("Bill Details:");
        System.out.println(bill);
    }

    public void showWelcomeMessage() {
        System.out.println(wlcMessage);
    }
}
