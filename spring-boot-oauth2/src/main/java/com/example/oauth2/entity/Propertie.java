package com.example.oauth2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Propertie {
    private String name;
    private String value;

    public Propertie(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
