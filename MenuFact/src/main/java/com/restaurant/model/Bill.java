package com.restaurant.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bill {
    private LocalDateTime date;
    private BillState state;
    private Client client;
    private HashMap<IPlat, Integer> plats;

    public Bill(Client client) {
        this.client = client;
        this.plats = new HashMap<>();
        this.date = LocalDateTime.now();
        this.state = BillState.OPEN;
    }

    public void addPlat(IPlat plat, int quantity) {
        if (plat == null) {
            return;
        }
        plats.put(plat, quantity);
    }

    public void removePlat(int code) {
        plats.entrySet().removeIf(entry -> entry.getKey().getCode() == code);
    }    

    public void modifyBill(int code, int newQuantity) {
        if (newQuantity <= 0) {
            return;
        }
        for (HashMap.Entry<IPlat, Integer> entry : plats.entrySet()) {
            if (entry.getKey().getCode() == code) {
                plats.put(entry.getKey(), newQuantity);
                return;
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (HashMap.Entry<IPlat, Integer> entry : plats.entrySet()) {
            total += entry.getKey().getPrix() * entry.getValue();
        }
        return total;
    }

    public void close() {
        state = BillState.CLOSED;
    }

    public void pay() {
        state = BillState.PAYED;
    }

    public void reopen() {
        if (state == BillState.CLOSED) {
            state = BillState.OPEN;
        }
    }
}
