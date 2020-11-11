package com.zhs.demoannotation.model;

import lombok.Data;

/**
 * @author: zhs
 * @since: 2020/11/11 9:27
 */
@Data
public class BaseResponse {
    private Boolean success;
    private String responseMessage;
    private String responseCode;


}
