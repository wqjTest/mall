package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallCommodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mall
 * @description: 商城商品表
 * @author: Hus
 * @create: 2018-12-19 14:18
 */
@Mapper
public interface MallCommodityDao {

    List<MallCommodity> listCommodityOfIndex(MallCommodity filter);

    MallCommodity getCommodity(String id);

    List<MallCommodity> listCommodityByType(MallCommodity filter);

}