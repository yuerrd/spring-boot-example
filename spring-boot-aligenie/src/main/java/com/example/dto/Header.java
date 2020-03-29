package com.example.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangyong
 */
@Data
public class Header implements Serializable {
    private static final long serialVersionUID = 8846082800155723320L;
    private String namespace;
    private String name;
    private int payLoadVersion;
    private String messageId;

}
