package com.example.oauth2.service.impl;

import com.example.oauth2.common.NameEnum;
import com.example.oauth2.dto.aligenie.AliGenieDTO;
import com.example.oauth2.dto.aligenie.ControlRspDTO;
import com.example.oauth2.dto.aligenie.DevicesDTO;
import com.example.oauth2.dto.aligenie.DiscoveryRspDTO;
import com.example.oauth2.dto.aligenie.Header;
import com.example.oauth2.dto.aligenie.Property;
import com.example.oauth2.dto.aligenie.ReqPayload;
import com.example.oauth2.service.IDeviceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public AliGenieDTO<DiscoveryRspDTO> getDevices(AliGenieDTO<ReqPayload> aliGenieDTO) {

        AliGenieDTO<DiscoveryRspDTO> result = new AliGenieDTO<>();
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
        Header header = aliGenieDTO.getHeader();
        header.setName(NameEnum.DISCOVERY_DEVICES_RESPONSE.toValue());
        result.setHeader(header);


        return result;
    }

    @Override
    public AliGenieDTO<ControlRspDTO> controlDevices(AliGenieDTO<ReqPayload> aliGenieDTO) {
        AliGenieDTO<ControlRspDTO> result = new AliGenieDTO<>();

        Header header = aliGenieDTO.getHeader();
        String uri = "http://localhost:8888/push/";
        if (StringUtils.isNotBlank(header.getName())) {
            RestTemplate restTemplate = new RestTemplate();
            try {
                restTemplate.getForObject(uri + header.getName(), String.class);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        header.setName(header.getName() + "Response");
        result.setHeader(header);
        result.setPayload(new ControlRspDTO(aliGenieDTO.getPayload().getDeviceId()));

        return result;
    }
}
