/**
 * Project Name: mall
 * Date: 2019/1/11 12:59
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallOrderInvoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 订单发票DAO
 * @Author: Hus
 * @Create: 2019/1/11 12:59
 */
@Mapper
public interface MallOrderInvoiceDao {

    void save(MallOrderInvoice mallOrderInvoice);

    MallOrderInvoice getOrderInvoice(String id);

    List<MallOrderInvoice> listOrderInvoice(MallOrderInvoice filter);

    void update(MallOrderInvoice mallOrderInvoice);

}