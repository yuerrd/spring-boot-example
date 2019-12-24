package com.example.oauth2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseAliGenieDTO<T> implements Serializable {

    private static final long serialVersionUID = 2814259978880630513L;

    public AliGenieHeader header;

    public T payload;
}
