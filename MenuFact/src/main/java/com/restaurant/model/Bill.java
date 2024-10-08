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
    private LocalDateTime date = LocalDateTime.now();
    private BillState state = BillState.CLOSED;
    private Client client = new Client(0, "");
    private HashMap<Plat, Integer> plats = new HashMap<>();

    public Bill() {
        this.date = LocalDateTime.now();
        this.state = BillState.CLOSED;
        this.client = new Client(); // Default Client
        this.plats = new HashMap<>(); // Initialize the HashMap
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        StringBuilder platsDescription = new StringBuilder();
        for (HashMap.Entry<Plat, Integer> entry : plats.entrySet()) {
            platsDescription.append("\t\t").append(entry.getKey().getDescription()).append(": ")
                    .append(entry.getValue()).append(" @ ").append(entry.getKey().getPlatPrice())
                    .append(" each\n");
        }

        return "Bill {\n" + "\tDate: " + date.format(formatter) + "\n" + "\tState: " + state + "\n"
                + "\tClient: " + client + "\n" + "\tPlats: \n" + platsDescription.toString()
                + "\tTotal: $" + getTotal() + "\n" + '}';
    }

}
