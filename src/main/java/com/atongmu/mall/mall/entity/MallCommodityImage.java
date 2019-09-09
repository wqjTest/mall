package com.atongmu.mall.mall.entity;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 商城商品图片实体类
 * @author: Hus
 * @create: 2018-12-20 11:25
 */
public class MallCommodityImage implements Serializable{
    private static final long serialVersionUID = 7855822759006701449L;

    private String commodityId;		// 商品ID
    private String imageUrl;		// 图片地址

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}