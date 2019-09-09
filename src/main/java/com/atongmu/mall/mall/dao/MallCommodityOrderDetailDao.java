package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallCommodityOrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: mall
 * @description: 商城订单明细Dao
 * @author: Hus
 * @create: 2018-12-26 20:44
 */
@Mapper
public interface MallCommodityOrderDetailDao {

    void save(MallCommodityOrderDetail orderDetailItem);
    
    /**
     * 软删除订单详情
     * 当删除订单的时候，一同删除订单详情
     * @param orderId
     * @return
     */
    public int delete(String orderId);
}