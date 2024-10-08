package com.restaurant.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import com.restaurant.util.BillState;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Bill {
    private LocalDateTime date;
    private BillState state;
    private Client client;
    private HashMap<Plat, Integer> plats;

    public Bill() {
        date = LocalDateTime.now();
        state = BillState.CLOSED;
        client = new Client(0, "");
        plats = new HashMap<>();
    }

    public Bill(Client client) {
        this.client = client;
        this.date = LocalDateTime.now();
        this.state = BillState.CLOSED;
        this.plats = new HashMap<>();
    }

    public void addPlat(Plat plat, int quantity) {
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
        for (HashMap.Entry<Plat, Integer> entry : plats.entrySet()) {
            if (entry.getKey().getCode() == code) {
                plats.put(entry.getKey(), newQuantity);
                return;
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (HashMap.Entry<Plat, Integer> entry : plats.entrySet()) {
            total += entry.getKey().getPlatPrice() * entry.getValue();
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("Bill { Date: %s, State: %s, Client: %s, Total: %.2f }",
                date.format(formatter), state, client.toString(), getTotal());
    }

}
