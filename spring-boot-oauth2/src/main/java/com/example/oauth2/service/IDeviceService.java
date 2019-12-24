package com.example.oauth2.service;

import com.example.oauth2.dto.aligenie.AliGenieDTO;
import com.example.oauth2.dto.aligenie.ControlRspDTO;
import com.example.oauth2.dto.aligenie.DiscoveryRspDTO;
import com.example.oauth2.dto.aligenie.ReqPayload;

/**
 * @author yangyong
 */
public interface IDeviceService {

    /**
     * get devices
     *
     * @param aliGenieDTO
     * @return
     */
    AliGenieDTO<DiscoveryRspDTO> getDevices(AliGenieDTO<ReqPayload> aliGenieDTO);


    /**
     * ControlDevice
     *
     * @param aliGenieDTO
     * @return
     */
    AliGenieDTO<ControlRspDTO> controlDevices(AliGenieDTO<ReqPayload> aliGenieDTO);
}
