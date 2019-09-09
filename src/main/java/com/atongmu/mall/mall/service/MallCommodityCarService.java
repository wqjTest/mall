package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallCommodityCarDao;
import com.atongmu.mall.mall.entity.MallCommodity;
import com.atongmu.mall.mall.entity.MallCommodityCar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mall
 * @description: 商城商品购物车Service
 * @author: Hus
 * @create: 2018-12-27 14:48
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityCarService {

    @Resource
    private MallCommodityCarDao mallCommodityCarDao;

    public MallCommodityCar getCommodityCar(String id) {
        return mallCommodityCarDao.getCommodityCar(id);
    }

    public List<MallCommodityCar> listMallCarByUserId(String userId) {
        return mallCommodityCarDao.listMallCarByUserId(userId);
    }

    public List<MallCommodityCar> listMallCarByCommodityAndUserId(String commodityId, String userId) {
        MallCommodityCar mallCommodityCar = new MallCommodityCar();
        mallCommodityCar.setCommodityId(commodityId);
        mallCommodityCar.setUserId(userId);
        return mallCommodityCarDao.listMallCarByCommodityAndUserId(mallCommodityCar);
    }

    @Transactional(readOnly = false)
    public void updateMallCommodityCar(MallCommodityCar mallCommodityCar) {
        mallCommodityCarDao.updateMallCommodityCar(mallCommodityCar);
    }

    @Transactional(readOnly = false)
    public void save(MallCommodityCar carItem) {
        mallCommodityCarDao.save(carItem);
    }

    @Transactional(readOnly = false)
    public void delete(String id) {
        mallCommodityCarDao.delete(id);
    }

    public List<MallCommodity> listCommodityByCarIds(List<String> list) {
        return mallCommodityCarDao.listCommodityByCarIds(list);
    }

}