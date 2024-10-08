package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Menu {
    private String description;
    private List<Plat> plats;

    public Menu() {
        this.description = "";
        this.plats = new ArrayList<>();
    }

    public Menu(String description, List<Plat> plats) {
        this.description = description;
        this.plats = plats;
    }

    public void removePlat(Plat plat) {
        if (plat != null && plats.contains(plat)) {
            plats.remove(plat);
        }
    }

    public void addPlat(Plat plat) {
        if (plat == null) {
            return;
        }
        plats.add(plat);
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public Plat getPlatByCode(int code) {
        for (Plat plat : plats) {
            if (plat.getCode() == code) {
                return plat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Menu {" + "Description: '" + description + '\'' + ", Plats: " + plats + '}';
    }

}
