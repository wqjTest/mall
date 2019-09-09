package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallCommodityComments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mall
 * @description: 商城商品Dao
 * @author: Hus
 * @create: 2018-12-20 14:06
 */
@Mapper
public interface MallCommodityCommentsDao {

    List<MallCommodityComments> listCommodityComments(String commodityId);

    void save(MallCommodityComments mallCommodityComments);

    void delete(String id);

}