package com.atongmu.mall.common.util.payUtil;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 微信返回结果封装
 * @author: Hus
 * @create: 2018-12-27 11:13
 */
@Data
public class WeChatPayResult implements Serializable{

    private static final long serialVersionUID = -8565197090502712196L;

    private String appid;
    private String partnerid;
    private String packageDesc;
    private String noncestr;
    private long timestamp;
    private String prepayid;
    private String sign;

}