package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallCommodityDao;
import com.atongmu.mall.mall.entity.MallCommodity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mall
 * @description: 商城商品
 * @author: Hus
 * @create: 2018-12-19 14:19
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityService {

    @Resource
    private MallCommodityDao mallCommodityDao;

    public List<MallCommodity> listCommodityOfIndex(MallCommodity filter) {
        return mallCommodityDao.listCommodityOfIndex(filter);
    }

    public MallCommodity getCommodity(String id) {
        return mallCommodityDao.getCommodity(id);
    }

    public List<MallCommodity> listCommodityByType(String commodityType) {
        MallCommodity filter = new MallCommodity();
        filter.setCommodityType(commodityType);
        return mallCommodityDao.listCommodityByType(filter);
    }
}