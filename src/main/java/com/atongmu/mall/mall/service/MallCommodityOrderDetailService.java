package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallCommodityOrderDetailDao;
import com.atongmu.mall.mall.entity.MallCommodityOrderDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: mall
 * @description: 商城订单明细Service
 * @author: Hus
 * @create: 2018-12-26 20:43
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityOrderDetailService {

    @Resource
    private MallCommodityOrderDetailDao mallCommodityOrderDetailDao;

    @Transactional(readOnly = false)
    public void save(MallCommodityOrderDetail orderDetailItem) {
        mallCommodityOrderDetailDao.save(orderDetailItem);
    }
}