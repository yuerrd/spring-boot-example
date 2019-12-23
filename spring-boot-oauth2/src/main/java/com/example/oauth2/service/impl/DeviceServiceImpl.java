package com.example.oauth2.service.impl;

import com.example.oauth2.entity.DevicesEntity;
import com.example.oauth2.entity.Propertie;
import com.example.oauth2.entity.ResponseDiscoveryEntity;
import com.example.oauth2.service.IDeviceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangyong
 */
@Service
public class DeviceServiceImpl implements IDeviceService {
    @Override
    public ResponseDiscoveryEntity getDevices() {
        ResponseDiscoveryEntity responseDiscoveryEntity = new ResponseDiscoveryEntity();
        List<DevicesEntity> devicesEntityList = new ArrayList<>();
        DevicesEntity devicesEntity = new DevicesEntity();
        devicesEntity.setDeviceId("0001");
        devicesEntity.setDeviceName("灯");
        devicesEntity.setDeviceType("light");
        devicesEntity.setIcon("https://git.cn-hangzhou.oss-cdn.aliyun-inc.com/uploads/aicloud/aicloud-proxy-service/41baa00903a71c97e3533cf4e19a88bba88bb/image.png");

        List<Propertie> properties = new ArrayList<>();
        properties.add(new Propertie("powerstate", "off"));
        devicesEntity.setProperties(properties);

        Set<String> actions = new HashSet<>();
        actions.add("TurnOn");
        actions.add("TurnOff");
        devicesEntity.setActions(actions);

        responseDiscoveryEntity.setDevices(devicesEntityList);
        return responseDiscoveryEntity;
    }
}
