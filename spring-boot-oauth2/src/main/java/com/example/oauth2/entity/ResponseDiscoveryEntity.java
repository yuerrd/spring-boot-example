package com.example.oauth2.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangyong
 */
@Data
public class ResponseDiscoveryEntity extends AbstractResponse implements Serializable {

    private static final long serialVersionUID = 248246116593225499L;
    private List<DevicesEntity> devices;
}
