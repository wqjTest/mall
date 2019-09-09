/**
 * Project Name: mall
 * Date: 2019/1/11 12:55
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 订单发牌明细实体类
 * @Author: Hus
 * @Create: 2019-01-11 12:55
 */
@Data
public class MallOrderInvoiceDetail implements Serializable {

    private static final long serialVersionUID = -7326940371333358870L;

    private Integer id;
    private String orderId;
    private String invoiceId;

}