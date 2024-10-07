package com.restaurant.model;

public class KidsPlat extends Plat {
    private double proportion;

    public KidsPlat(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "code=" + getCode() +
                ", description='" + getDescription() + '\'' +
                ", prix=" + getPrix() +
                ", proportion=" + proportion +
                '}';
    }
}
