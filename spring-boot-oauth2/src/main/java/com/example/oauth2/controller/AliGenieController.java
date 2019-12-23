package com.example.oauth2.controller;

import com.example.oauth2.common.HeaderNameEnum;
import com.example.oauth2.common.NamespaceEnum;
import com.example.oauth2.entity.ResponseDiscoveryEntity;
import com.example.oauth2.service.IDeviceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AliGenieController {

    @Autowired
    IDeviceService deviceService;


    @PostMapping("api/aligenie")
    public ResponseDiscoveryEntity aligenie(HttpServletRequest request, HttpServletResponse response) {
        String namespace = request.getHeader("namespace");
        if (StringUtils.equals(namespace, NamespaceEnum.DISCOVERY.toValue())) {
            response.setHeader("namespace", request.getHeader("namespace"));
            response.setHeader("name", HeaderNameEnum.DISCOVERY_DEVICES_RESPONSE.toValue());
            response.setHeader("messageId", request.getHeader("messageId"));
            response.setHeader("payLoadVersion", request.getHeader("payLoadVersion"));
            return deviceService.getDevices();
        }
        return null;
    }
}
