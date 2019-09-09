package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallCommodityType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mall
 * @description: 商城商品分类Dao
 * @author: Hus
 * @create: 2018-12-21 14:47
 */
@Mapper
public interface MallCommodityTypeDao {

    List<MallCommodityType> listCommodityType(MallCommodityType mallCommodityType);

    String getCommodityTypeName(String id);

}