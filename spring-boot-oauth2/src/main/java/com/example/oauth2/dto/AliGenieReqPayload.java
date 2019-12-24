package com.example.oauth2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliGenieReqPayload implements Serializable {
    private static final long serialVersionUID = -5055606416848514289L;
    private String accessToken;
    private String deviceId;
    private String deviceType;
    private String attribute;
    private String value;
}
