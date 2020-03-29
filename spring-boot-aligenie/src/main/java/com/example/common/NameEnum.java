package com.example.common;

/**
 * @author yangyong
 */

public enum NameEnum {
    DISCOVERY_DEVICES("DiscoveryDevices"),
    DISCOVERY_DEVICES_RESPONSE("DiscoveryDevicesResponse"),
    TURN_ON("TurnOn"),
    TURN_OFF("TurnOff");
    private String value;

    public String toValue() {
        return value;
    }

    NameEnum(String value) {
        this.value = value;
    }
}
