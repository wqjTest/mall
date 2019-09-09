package com.atongmu.mall.mall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: mall
 * @description: 请求参数封装
 * @author: Hus
 * @create: 2018-12-19 14:35
 */
@Data
public class ReqParam implements Serializable{

    private static final long serialVersionUID = -1594189581883854909L;

    private String tokenId;
    private String userId;
    private String commodityId;
    private String commodityType;
    private String lave;
    private String addressId;
    private String payType;
    private String orderId;
    private String commodityCarId;
    private Integer commodityCarNum;
    private List<String> carParam;
    private Integer commentType;
    private Integer anonymousFlag;

}