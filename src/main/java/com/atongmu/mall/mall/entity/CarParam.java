package com.atongmu.mall.mall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 购物车实体类
 * @author: Hus
 * @create: 2018-12-28 17:39
 */
@Data
public class CarParam implements Serializable{

    private static final long serialVersionUID = 4379875947613054050L;

    private String carId;
    private String commodityId;
    private Integer number;

}