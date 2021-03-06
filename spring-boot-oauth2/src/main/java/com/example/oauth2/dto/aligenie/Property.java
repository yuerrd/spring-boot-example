package com.example.oauth2.dto.aligenie;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangyong
 */
@Data
@NoArgsConstructor
public class Property {
    private String name;
    private String value;

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
