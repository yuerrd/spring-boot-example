package com.example.oauth2.dto.aligenie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 控制设备的返回
 *
 * @author yangyong
 * @date 2019-12-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControlRspDTO implements Serializable {

    private static final long serialVersionUID = 5811027145092497246L;
    private String deviceId;

}
