package com.example.bean;

import lombok.Data;

@Data
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
