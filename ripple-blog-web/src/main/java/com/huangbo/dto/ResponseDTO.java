package com.huangbo.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private int code;

    private String msg;

    private Object data;
}
