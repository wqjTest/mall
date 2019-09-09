/**
 * Project Name: mall
 * Date: 2019/1/11 12:57
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.service;

import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.mall.dao.MallOrderInvoiceDao;
import com.atongmu.mall.mall.entity.MallOrderInvoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 订单发票服务
 * @Author: Hus
 * @Create: 2019-01-11 12:57
 */
@Service
@Transactional(readOnly = true)
public class MallOrderInvoiceService {

    @Resource
    private MallOrderInvoiceDao mallOrderInvoiceDao;

    @Transactional(readOnly = false)
    public void save(MallOrderInvoice mallOrderInvoice) {
        mallOrderInvoiceDao.save(mallOrderInvoice);
    }

    public MallOrderInvoice getOrderInvoice(String id) {
        return mallOrderInvoiceDao.getOrderInvoice(id);
    }

    public List<MallOrderInvoice> listOrderInvoice(MallOrderInvoice filter) {
        return mallOrderInvoiceDao.listOrderInvoice(filter);
    }

    @Transactional(readOnly = false)
    public void update(MallOrderInvoice mallOrderInvoice) {
        mallOrderInvoiceDao.update(mallOrderInvoice);
    }
}