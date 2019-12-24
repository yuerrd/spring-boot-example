package com.example.oauth2.service.impl;

import com.example.oauth2.common.NameEnum;
import com.example.oauth2.dto.*;
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
    public BaseAliGenieDTO<DiscoveryRspDTO> getDevices(BaseAliGenieDTO<AliGenieReqPayload> aliGenieDTO) {

        BaseAliGenieDTO<DiscoveryRspDTO> result = new BaseAliGenieDTO<>();
        DiscoveryRspDTO discoveryRspDTO = new DiscoveryRspDTO();
        List<DevicesDTO> devicesEntityList = new ArrayList<>();
        DevicesDTO devicesEntity = new DevicesDTO();
        devicesEntity.setDeviceId("0001");
        devicesEntity.setDeviceName("灯");
        devicesEntity.setDeviceType("light");
        devicesEntity.setIcon("https://git.cn-hangzhou.oss-cdn.aliyun-inc" +
                ".com/uploads/aicloud/aicloud-proxy-service/41baa00903a71c97e3533cf4e19a88bba88bb/image.png");
        List<Property> properties = new ArrayList<>();
        properties.add(new Property("powerstate", "off"));
        devicesEntity.setProperties(properties);
        Set<String> actions = new HashSet<>();
        actions.add("TurnOn");
        actions.add("TurnOff");
        devicesEntity.setActions(actions);
        devicesEntityList.add(devicesEntity);
        discoveryRspDTO.setDevices(devicesEntityList);

        result.setPayload(discoveryRspDTO);
        AliGenieHeader header = aliGenieDTO.getHeader();
        header.setName(NameEnum.DISCOVERY_DEVICES_RESPONSE.toValue());
        result.setHeader(header);


        return result;
    }
}
