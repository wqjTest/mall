package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.MallCommodityImageDao;
import com.atongmu.mall.mall.entity.MallCommodityImage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mall
 * @description: 商城商品图片Service
 * @author: Hus
 * @create: 2018-12-20 11:28
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityImageService {

    @Resource
    private MallCommodityImageDao mallCommodityImageDao;

    public List<MallCommodityImage> listCommodityImg(String commodityId) {
        return mallCommodityImageDao.listCommodityImg(commodityId);
    }
}