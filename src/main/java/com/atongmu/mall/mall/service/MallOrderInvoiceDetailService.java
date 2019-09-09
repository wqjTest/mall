/**
 * Project Name: mall
 * Date: 2019/1/11 12:58
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallOrderInvoiceDetailDao;
import com.atongmu.mall.mall.entity.MallOrderInvoiceDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: 订单发票明细服务
 * @Author: Hus
 * @Create: 2019-01-11 12:58
 */
@Service
@Transactional(readOnly = true)
public class MallOrderInvoiceDetailService {

    @Resource
    private MallOrderInvoiceDetailDao mallOrderInvoiceDetailDao;

    @Transactional(readOnly = false)
    public void save(MallOrderInvoiceDetail mallOrderInvoiceDetail) {
        mallOrderInvoiceDetailDao.save(mallOrderInvoiceDetail);
    }
}