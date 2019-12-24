package com.example.oauth2.dto;

import com.example.oauth2.entity.AbstractResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangyong
 */
@Data
public class DiscoveryRspDTO extends AbstractResponse implements Serializable {

    private static final long serialVersionUID = 248246116593225499L;
    private List<DevicesDTO> devices;
}
