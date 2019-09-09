package com.atongmu.mall.mall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.atongmu.mall.common.util.baseEntity.BaseEntity;
import com.atongmu.mall.mall.dto.OrderDetailDto;

import lombok.Data;

/**
 * @program: mall
 * @description: 商城订单实体类
 * @author: Hus
 * @create: 2018-12-26 20:33
 */
@Data
public class MallCommodityOrder extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -7136495067198995929L;

    private String orderCode;		// 订单编码
    private String personId;		// 购买者ID
    private String personType;		// 关系
    private String personName;		// 购买者昵称
    private BigDecimal orderAmount;		// 订单总额
    private String payStatus;		// 订单状态
    private LocalDateTime payTime;		// 付款时间
    private String payType;		// 付款方式
    private String payFlag;		// 付款成功标记
    private String tradeNo;		// 付款方订单号
    private String courierNumber;		// 快递单号
    private String receivingAddress;  // 收货地址
    private String phoneNum; 	// 购买者手机号
    private String addrDesc;  // 收货地址

    private List<OrderDetailDto> details;
    private Integer invoiceStatus;   // 开票状态



}