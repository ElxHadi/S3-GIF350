package com.restaurant.model;

public class HealthyPlat extends Plat {
    private double calories;
    private double cholesterol;
    private double fat;

    public HealthyPlat(int code, String description, double prix, double calories, double cholesterol, double fat) {
        super(code, description, prix);
        this.calories = calories;
        this.cholesterol = cholesterol;
        this.fat = fat;
    }

    public double getCalories() {
        return calories;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public double getFat() {
        return fat;
    }

    @Override
    public String toString() {
        return "healthyPlat{" +
                "code=" + getCode() +
                ", description='" + getDescription() + '\'' +
                ", prix=" + getPrix() +
                ", calories=" + calories +
                ", cholesterol=" + cholesterol +
                ", fat=" + fat +
                '}';
    }
}
