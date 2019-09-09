/**
 * Project Name: mall
 * Date: 2019/1/11 12:53
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.entity;

import com.atongmu.mall.common.util.baseEntity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 订单发票实体类
 * @Author: Hus
 * @Create: 2019-01-11 12:53
 */
@Data
public class MallOrderInvoice extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1062489882049413132L;

    private String personId;		// 发票所属用户
    private String invoiceType;		// 发票类型
    private String invoiceHead;     // 发票抬头
    private String invoiceTitle;		// 发票抬头
    private String invoiceName;		// 发票名称
    private String identificationNumber;		// 纳税人识别码
    private String invoiceContent;		// 发票内容
    private BigDecimal invoiceAmount;		// 发票总价格
    private String invoiceAddress;		// 发票地址
    private String invoiceRecipient;		// 发票收件人姓名
    private String invoicePhone;		// 发票收件人电话
    private String invoiceEmail;		// 发票收件人电子邮箱
    private Integer invoiceFlag;        // 当前开票状态

}