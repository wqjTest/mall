package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallHomeRecommendDao;
import com.atongmu.mall.mall.entity.MallHomeRecommend;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mall
 * @description: 商城首页轮播图
 * @author: Hus
 * @create: 2018-12-19 14:08
 */
@Service
@Transactional(readOnly = true)
public class MallHomeRecommendService {

    @Resource
    private MallHomeRecommendDao mallHomeRecommendDao;

    public List<MallHomeRecommend> listRecommend(MallHomeRecommend mallHomeRecommend){
        return mallHomeRecommendDao.listRecommend(mallHomeRecommend);
    }

}