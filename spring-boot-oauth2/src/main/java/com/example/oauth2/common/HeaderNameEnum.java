package com.example.oauth2.common;

public enum HeaderNameEnum {
    DISCOVERY_DEVICES("DiscoveryDevices"),
    DISCOVERY_DEVICES_RESPONSE("DiscoveryDevicesResponse"),
    TURN_ON("TurnOn"),
    TURN_OFF("TurnOff");
    private String value;

    public String toValue() {
        return value;
    }

    HeaderNameEnum(String value) {
        this.value = value;
    }
}
