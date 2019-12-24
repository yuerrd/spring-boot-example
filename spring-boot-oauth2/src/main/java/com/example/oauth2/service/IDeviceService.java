package com.example.oauth2.service;

import com.example.oauth2.dto.AliGenieReqPayload;
import com.example.oauth2.dto.BaseAliGenieDTO;
import com.example.oauth2.dto.DiscoveryRspDTO;

/**
 * @author yangyong
 */
public interface IDeviceService {

    /**
     * get devices
     *
     * @return
     */
    BaseAliGenieDTO<DiscoveryRspDTO> getDevices(BaseAliGenieDTO<AliGenieReqPayload> aliGenieDTO);
}
