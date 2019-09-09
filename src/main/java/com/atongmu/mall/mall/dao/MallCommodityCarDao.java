package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallCommodity;
import com.atongmu.mall.mall.entity.MallCommodityCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mall
 * @description: 商城商品购物车Dao
 * @author: Hus
 * @create: 2018-12-27 14:49
 */
@Mapper
public interface MallCommodityCarDao {

    List<MallCommodityCar> listMallCarByUserId(String userId);

    List<MallCommodityCar> listMallCarByCommodityAndUserId(MallCommodityCar mallCommodityCar);

    void updateMallCommodityCar(MallCommodityCar mallCommodityCar);

    void save(MallCommodityCar carItem);

    MallCommodityCar getCommodityCar(String id);

    void delete(String id);

    List<MallCommodity> listCommodityByCarIds(List<String> list);

}