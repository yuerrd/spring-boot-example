package com.example.common;

/**
 * @author yangyong
 */

public enum NamespaceEnum {
    DISCOVERY("AliGenie.Iot.Device.Discovery"),
    CONTROL("AliGenie.Iot.Device.Control"),
    QUERY("AliGenie.Iot.Device.Query");
    private String value;

    public String toValue() {
        return value;
    }

    NamespaceEnum(String value) {
        this.value = value;
    }
}
