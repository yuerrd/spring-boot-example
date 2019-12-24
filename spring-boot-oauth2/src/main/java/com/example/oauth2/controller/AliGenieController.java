package com.example.oauth2.controller;

import com.alibaba.fastjson.JSON;
import com.example.oauth2.common.NamespaceEnum;
import com.example.oauth2.dto.aligenie.AliGenieDTO;
import com.example.oauth2.dto.aligenie.ReqPayload;
import com.example.oauth2.service.IDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class AliGenieController {

    @Autowired
    IDeviceService deviceService;


    @PostMapping("api/aligenie")
    public AliGenieDTO aligenie(@RequestBody AliGenieDTO<ReqPayload> aliGenieDTO) {
        log.info("[ AliGenieController ] data : {} ", JSON.toJSONString(aliGenieDTO));
        if (aliGenieDTO.getHeader().getNamespace().equals(NamespaceEnum.DISCOVERY.toValue())) {
            return deviceService.getDevices(aliGenieDTO);
        } else if (aliGenieDTO.getHeader().getNamespace().equals(NamespaceEnum.CONTROL.toValue())) {
            return deviceService.controlDevices(aliGenieDTO);
        } else if (aliGenieDTO.getHeader().getNamespace().equals(NamespaceEnum.QUERY.toValue())) {

        }
        return null;
    }
}
