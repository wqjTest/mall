package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallCommodityDescription;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: mall
 * @description: 商城商品介绍Dao
 * @author: Hus
 * @create: 2018-12-20 13:08
 */
@Mapper
public interface MallCommodityDescriptionDao {

    MallCommodityDescription getCommodityDescription(MallCommodityDescription filter);

}