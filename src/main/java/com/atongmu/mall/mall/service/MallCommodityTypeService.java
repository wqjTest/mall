package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallCommodityTypeDao;
import com.atongmu.mall.mall.entity.MallCommodityType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mall
 * @description: 商城商品分类Service
 * @author: Hus
 * @create: 2018-12-21 14:47
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityTypeService {

    @Resource
    private MallCommodityTypeDao mallCommodityTypeDao;

    public List<MallCommodityType> listCommodityType(MallCommodityType typeFilter) {
        return mallCommodityTypeDao.listCommodityType(typeFilter);
    }

    public String getCommodityTypeName(String id) {
        return mallCommodityTypeDao.getCommodityTypeName(id);
    }

}