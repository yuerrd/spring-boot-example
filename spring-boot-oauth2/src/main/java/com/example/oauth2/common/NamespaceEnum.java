package com.example.oauth2.common;

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
