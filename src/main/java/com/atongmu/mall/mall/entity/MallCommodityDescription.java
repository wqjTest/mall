package com.atongmu.mall.mall.entity;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 商城商品介绍实体类
 * @author: Hus
 * @create: 2018-12-20 13:06
 */
public class MallCommodityDescription implements Serializable{

    private static final long serialVersionUID = -6007672659481513506L;

    private String commodityId;		// 物品ID
    private String descriptionName;		// 说明名称
    private String descriptionType;		// 介绍类型
    private String descriptionContent;		// 介绍内容

    public MallCommodityDescription() {
    }

    public MallCommodityDescription(String descriptionType,String descriptionContent) {
        this.descriptionType = descriptionType;
        this.descriptionContent = descriptionContent;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public String getDescriptionType() {
        return descriptionType;
    }

    public void setDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
    }

    public String getDescriptionContent() {
        return descriptionContent;
    }

    public void setDescriptionContent(String descriptionContent) {
        this.descriptionContent = descriptionContent;
    }

}