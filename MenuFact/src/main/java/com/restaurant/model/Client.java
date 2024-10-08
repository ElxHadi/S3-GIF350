package com.restaurant.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Client {
    private int idClient;
    private String name;

    public Client() {
        this.idClient = 0;
        this.name = "";
    }

    @Override
    public String toString() {
        return "Client {" + "ID: " + idClient + ", Name: '" + name + '\'' + '}';
    }

}
