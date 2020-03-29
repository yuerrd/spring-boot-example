package com.example.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangyong
 */
@Data
public class AliGenieDTO<T> implements Serializable {

    private static final long serialVersionUID = 2814259978880630513L;

    public Header header;

    public T payload;
}
