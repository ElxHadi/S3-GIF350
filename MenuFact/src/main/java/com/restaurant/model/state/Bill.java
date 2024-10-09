package com.restaurant.model.state;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.restaurant.model.Client;
import com.restaurant.model.builder.Plat;
import com.restaurant.model.observer.Observer;
import com.restaurant.model.observer.Subject;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Bill implements Subject {
    private LocalDateTime date;
    private Client client;
    
    //
    private HashMap<Plat, Integer> plats;
    private BillContext context;
    private List<Observer> observers;


    public Bill() {
        date = LocalDateTime.now();
        this.context = new BillContext(new BillOpenState());
        client = new Client(0, "");
        plats = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    public Bill(Client client) {
        this.client = client;
        this.date = LocalDateTime.now();
        this.context = new BillContext(new BillOpenState());
        this.plats = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    public void addPlat(Plat plat, int quantity) {
        if (plat == null) {
            return;
        }
        plats.put(plat, quantity);
        notifyObservers(plat);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public synchronized void notifyObservers(Plat plat) {
        for (Observer observer : observers) {
            observer.update(plat);
        }
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
    public double getTotalBeforeTaxes() {
        double total = 0;
        for (HashMap.Entry<Plat, Integer> entry : plats.entrySet()) {
            total += entry.getKey().getPlatPrice() * entry.getValue();
        }
        return total;
    }

     public double getTotal() {
        double total = 0.0;
        for (Map.Entry<Plat, Integer> entry : plats.entrySet()) {
            Plat plat = entry.getKey();
            total += plat.calculateTaxExemptedPrice(this) * entry.getValue();
        }
        return total;
    }

    public void close() {
        context.request();
    }

    public void pay() {
        context.request();
    }

    public void reopen() {
        if (context.getCurrentState() instanceof BillClosedState) {
            ((BillClosedState) context.getCurrentState()).reopen(context);
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("Bill { Date: %s, State: %s, Client: %s, Total: %.2f }",
                date.format(formatter), context.getCurrentState().getClass().getSimpleName(),
                client.toString(), getTotal());
    }
}
