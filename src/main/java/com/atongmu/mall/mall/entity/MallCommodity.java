package com.atongmu.mall.mall.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mall
 * @description: 商城商品实体类
 * @author: Hus
 * @create: 2018-12-19 14:18
 */
@Data
public class MallCommodity implements Serializable{

    private static final long serialVersionUID = 7144071321499828777L;

    private String id;
    private String remarks;
    private String commodityName;		// 商品名称
    private BigDecimal commodityPrice;		// 商品价格
    private BigDecimal discount;		// 折扣
    private BigDecimal price;       // 折扣之后的价格
    private String commodityImage;		// 商品图片
    private String commodityType;		// 商品分类
    private String status;		// 商品状态
    private Integer saleNum;      // 销售数量
    private Integer watchNum;     // 浏览数量

    private String userId;   // 用户ID

}