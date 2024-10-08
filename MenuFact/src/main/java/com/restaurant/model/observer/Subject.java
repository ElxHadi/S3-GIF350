package com.restaurant.model.observer;

import com.restaurant.model.builder.Plat;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Plat plat);
}