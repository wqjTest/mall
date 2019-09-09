package com.atongmu.mall.mall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 用户实体表
 * @author: Hus
 * @create: 2018-12-19 13:08
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4171017655038939468L;

    private String id;
    private String sourceId ;
    private String tokenId;

}