package com.mocha.mocha.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo {

    private int responseCode;
    private String responseMsg;
    private Object data;

}