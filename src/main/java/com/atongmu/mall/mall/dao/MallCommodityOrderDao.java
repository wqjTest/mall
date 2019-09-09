package com.atongmu.mall.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.atongmu.mall.mall.dto.OrderDetailDto;
import com.atongmu.mall.mall.entity.MallCommodityOrder;

/**
 * @program: mall
 * @description: 商场订单Dao层
 * @author: Hus
 * @create: 2018-12-26 20:31
 */
@Mapper
public interface MallCommodityOrderDao {

    void save(MallCommodityOrder mallCommodityOrder);

    /** 
    * @Description: getOrder 
    * @Param: [id] 
    * @return: com.atongmu.mall.mall.entity.MallCommodityOrder 
    * @Author: Hus
    * @Date: 2019/1/11 
    */ 
    MallCommodityOrder getOrder(String id);

    /** 
    * @Description: updatePayWay 
    * @Param: [id, payType] 
    * @return: void 
    * @Author: Hus
    * @Date: 2019/1/11 
    */ 
    void updatePayWay(String id, String payType);
    
    /**
         * 查询订单列表
     * @param userId
     * @param chancenum
     * @return
     */
    List<MallCommodityOrder> findByUserId(String userId, String state);
    
    /**
         * 查询订单详情
     * @param userId
     * @param state
     * @return
     */
    List<OrderDetailDto> findDetailListByUserId(String userId, String[] status);
    
    /**
         * 根据订单号查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetailDto> findByOrderId(String orderId);

    /**
     * 软删除订单
     * @param orderId
     */
    public void delete(String orderId);

    /**
     * 更新订单状态
     * @param orderId
     */
    public void updateStatus(String orderId, String status);

    List<MallCommodityOrder> listOrder(MallCommodityOrder filter);

}