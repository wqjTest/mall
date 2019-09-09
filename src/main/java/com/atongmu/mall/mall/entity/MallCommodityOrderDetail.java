package com.atongmu.mall.mall.entity;

import com.atongmu.mall.common.util.baseEntity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mall
 * @description: 商城订单明细记录
 * @author: Hus
 * @create: 2018-12-26 20:40
 */
@Data
public class MallCommodityOrderDetail extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 9078382574882040030L;

    private String orderId; // 总订单ID
    private String commodityId; // 商品ID
    private BigDecimal price; // 单价
    private Integer commodityNum; // 数量
    private BigDecimal amount; // 商品总价
    private String commodityImage; // 商品ID
    private String commodityName; // 商品ID

}