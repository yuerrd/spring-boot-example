package com.example.oauth2.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author yangyong
 */
@Data
public class DevicesDTO implements Serializable {
    private static final long serialVersionUID = -2189650883612430796L;
    /**
     * 设备Id
     */
    String deviceId;
    /**
     * 设备类型
     */
    String deviceType;
    /**
     * 名称
     */
    String deviceName;
    /**
     * 品牌
     */
    String brand;
    /**
     * 型号
     */
    String model;

    /**
     * 位置
     */
    String zone;
    /**
     * 产品icon
     */
    String icon;
    /**
     * 属性状态列表
     */
    List<Property> properties;
    /**
     * 产品支持的操作
     */
    Set<String> actions;
    /**
     * 产品扩展属性,
     */
    JSONObject extensions;


}
