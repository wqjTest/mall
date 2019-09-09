package com.atongmu.mall.mall.entity;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 商城商品分类表
 * @author: Hus
 * @create: 2018-12-21 14:46
 */
public class MallCommodityType implements Serializable{

    private static final long serialVersionUID = 5105072042588074313L;

    private String id;              //ID
    private String typeName;		//类型名称
    private Integer typeSort;		//类型排序

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(Integer typeSort) {
        this.typeSort = typeSort;
    }

}