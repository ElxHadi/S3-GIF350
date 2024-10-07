// MenuFactView.java
package com.restaurant.view;

import com.restaurant.model.Bill;
import com.restaurant.model.Menu;
import com.restaurant.model.IPlat;

public class MenuFactView {

    private final String wlcMessage = "Welcome to the MenuFact Application!";

    public void displayMenu(Menu menu) {
        System.out.println("=== Menu: ===");
        for (IPlat plat : menu.getPlats()) {
            System.out.println(plat);
        }
    }

    public void displayBill(Bill bill) {
        System.out.println("=== Bill: ===");
        System.out.println(bill);
    }

    public void showWelcomeMessage() {
        System.out.println(wlcMessage);
    }
}
