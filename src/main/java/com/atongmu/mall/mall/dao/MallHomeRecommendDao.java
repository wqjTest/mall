package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallHomeRecommend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mall
 * @description: 商城首页轮播图片
 * @author: Hus
 * @create: 2018-12-19 14:07
 */
@Mapper
public interface MallHomeRecommendDao {

    List<MallHomeRecommend> listRecommend(MallHomeRecommend mallHomeRecommend);

}