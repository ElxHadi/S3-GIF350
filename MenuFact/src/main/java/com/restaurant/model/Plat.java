package com.restaurant.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Plat implements IPlat {
    private int code ;
    private String description;
    private double prix ;
}
