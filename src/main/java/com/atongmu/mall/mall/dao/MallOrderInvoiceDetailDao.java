/**
 * Project Name: mall
 * Date: 2019/1/11 13:00
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallOrderInvoiceDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 订单发票明细DAO
 * @Author: Hus
 * @Create: 2019/1/11 13:00
 */
@Mapper
public interface MallOrderInvoiceDetailDao {

    void save(MallOrderInvoiceDetail mallOrderInvoiceDetail);

}