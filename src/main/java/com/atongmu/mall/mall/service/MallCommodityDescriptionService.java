package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallCommodityDescriptionDao;
import com.atongmu.mall.mall.entity.MallCommodityDescription;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: mall
 * @description: 商城商品介绍Service
 * @author: Hus
 * @create: 2018-12-20 13:08
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityDescriptionService {

    @Resource
    private MallCommodityDescriptionDao mallCommodityDescriptionDao;

    public MallCommodityDescription getCommodityDescription(String type, String commodityId) {
        MallCommodityDescription filter = new MallCommodityDescription();
        filter.setCommodityId(commodityId);
        filter.setDescriptionType(type);
        filter = mallCommodityDescriptionDao.getCommodityDescription(filter);
        return filter == null ? new MallCommodityDescription("","") : filter;
    }

}