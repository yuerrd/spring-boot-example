package com.example.oauth2.dto.aligenie;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangyong
 */
@Data
public class ReqPayload implements Serializable {
    private static final long serialVersionUID = -5055606416848514289L;
    private String accessToken;
    private String deviceId;
    private String deviceType;
    private String attribute;
    private String value;
}
