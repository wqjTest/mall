package com.atongmu.mall.mall.entity;

import com.atongmu.mall.common.util.baseEntity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 商城商品评论数据
 * @author: Hus
 * @create: 2018-12-20 13:57
 */
@Data
public class MallCommodityComments extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -5769413860408326423L;

    private String orderId;  // 订单ID
    private String commodityId;  // 商城商品ID
    private String personName;  // 评论人的姓名
    private String personId;  // 评论人的ID
    private Integer commentType;  // 评价状态,1好评 0差评
    private Integer anonymousFlag;  // 是否匿名,1是匿名 0非匿名

}