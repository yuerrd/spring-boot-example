package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.NamespaceEnum;
import com.example.dto.AliGenieDTO;
import com.example.dto.ReqPayload;
import com.example.service.IDeviceService;
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
