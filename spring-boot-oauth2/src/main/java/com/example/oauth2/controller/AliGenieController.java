package com.example.oauth2.controller;

import com.alibaba.fastjson.JSON;
import com.example.oauth2.common.HeaderNameEnum;
import com.example.oauth2.common.NamespaceEnum;
import com.example.oauth2.entity.ResponseDiscoveryEntity;
import com.example.oauth2.service.IDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class AliGenieController {

    @Autowired
    IDeviceService deviceService;


    @PostMapping("api/aligenie")
    public ResponseDiscoveryEntity aligenie(@RequestParam Map<String, Object> params, HttpServletRequest request,
                                            HttpServletResponse response) {
        String namespace = request.getHeader("namespace");

        log.info("[ AliGenieController ] naesapce: {} ", namespace);

        log.info("[ AliGenieController ] headers: {} ", JSON.toJSONString(getHeadersInfo(request)));
        log.info("[ AliGenieController ] params: {}", JSON.toJSONString(params));


        if (StringUtils.equals(namespace, NamespaceEnum.DISCOVERY.toValue())) {
            response.setHeader("namespace", request.getHeader("namespace"));
            response.setHeader("name", HeaderNameEnum.DISCOVERY_DEVICES_RESPONSE.toValue());
            response.setHeader("messageId", request.getHeader("messageId"));
            response.setHeader("payLoadVersion", request.getHeader("payLoadVersion"));
            return deviceService.getDevices();
        }
        return null;
    }


    private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<>(16);

        Enumeration headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {

            String key = (String) headerNames.nextElement();

            String value = request.getHeader(key);

            map.put(key, value);

        }

        return map;
    }
}
