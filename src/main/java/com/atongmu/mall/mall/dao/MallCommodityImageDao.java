package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallCommodityImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mall
 * @description: 商城商品图片Dao
 * @author: Hus
 * @create: 2018-12-20 11:27
 */
@Mapper
public interface MallCommodityImageDao {

    List<MallCommodityImage> listCommodityImg(String commodityId);

}