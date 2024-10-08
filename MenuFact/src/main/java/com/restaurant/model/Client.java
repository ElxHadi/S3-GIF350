package com.restaurant.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Client {
    private int idClient;
    private String name;

    @Override
    public String toString() {
        return String.format("Client { idClient: '%s', name: '%s' }", getIdClient(), getName());
    }

}
