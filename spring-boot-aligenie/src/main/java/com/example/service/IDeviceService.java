package com.example.service;


import com.example.dto.AliGenieDTO;
import com.example.dto.ControlRspDTO;
import com.example.dto.DiscoveryRspDTO;
import com.example.dto.ReqPayload;

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
