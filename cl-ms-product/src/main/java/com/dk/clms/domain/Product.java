package com.dk.clms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private String providerId;
    private Provider provider;

    public Product(String id, String name, String providerId) {
        this.id = id;
        this.name = name;
        this.providerId = providerId;
    }
}
