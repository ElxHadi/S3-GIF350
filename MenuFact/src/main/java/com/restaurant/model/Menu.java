package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Menu {
    private String description;
    private List<IPlat> plats;

    public Menu() {
        this.description = "";
        this.plats = new ArrayList<>();
    }

    public Menu(String description, List<IPlat> plats) {
        this.description = description;
        this.plats = plats;
    }

    public void removePlat(IPlat plat) {
        if (plat != null && plats.contains(plat)) {
            plats.remove(plat);
        }
    }

    public void addPlat(IPlat plat) {
        if (plat == null) {
            return;
        }
        plats.add(plat);
    }

    public List<IPlat> getPlats() {
        return plats;
    }

    public IPlat getPlatByCode(int code) {
        for (IPlat plat : plats) {
            if (plat.getCode() == code) {
                return plat;
            }
        }
        return null;
    }
}
