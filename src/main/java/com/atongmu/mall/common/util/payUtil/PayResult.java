package com.atongmu.mall.common.util.payUtil;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 支付宝支付订单生成结果
 * @author: Hus
 * @create: 2018-12-27 10:57
 */
@Data
public class PayResult<T> implements Serializable{

    private static final long serialVersionUID = -2763160176202114566L;

    private String payType;
    private T wexData;
    private T aliData;
    private String status;
    private String message;

}