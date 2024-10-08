// PlatFactory.java
package com.restaurant.factory;

import com.restaurant.model.*;
import com.restaurant.util.PlatType;

import java.util.HashMap;

public class PlatFactory {

    public static Plat createPlat(PlatType type, int code, String description, HashMap<Ingredient, Double> ingredients, double... extraParams) {
        switch (type) {
            case KIDS:
                if (extraParams.length >= 1) {
                    return new KidsPlat(code, description, ingredients, extraParams[0]);
                } else {
                    throw new IllegalArgumentException("Missing parameters for KidsPlat");
                }
            case HEALTHY:
                if (extraParams.length >= 3) {
                    return new HealthyPlat(code, description, ingredients, extraParams[0], extraParams[1], extraParams[2]);
                } else {
                    throw new IllegalArgumentException("Missing parameters for HealthyPlat");
                }
            default:
                return new Plat(code, description, ingredients);
        }
    }
}
