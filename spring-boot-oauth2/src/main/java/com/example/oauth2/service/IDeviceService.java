package com.example.oauth2.service;

import com.example.oauth2.entity.ResponseDiscoveryEntity;

/**
 * @author yangyong
 */
public interface IDeviceService {

    /**
     * get devices
     *
     * @return
     */
    ResponseDiscoveryEntity getDevices();
}
