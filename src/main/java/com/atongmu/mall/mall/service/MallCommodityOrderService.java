package com.atongmu.mall.mall.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atongmu.mall.mall.dao.MallCommodityOrderDao;
import com.atongmu.mall.mall.dao.MallCommodityOrderDetailDao;
import com.atongmu.mall.mall.dto.OrderDetailDto;
import com.atongmu.mall.mall.entity.MallCommodityOrder;

/**
 * @program: mall
 * @description: 商城订单service
 * @author: Hus
 * @create: 2018-12-26 20:30
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityOrderService {

    @Resource
    private MallCommodityOrderDao mallCommodityOrderDao;
    
    @Resource
    private MallCommodityOrderDetailDao mallCommodityOrderDetailDao;

    public MallCommodityOrder getOrder(String id) {
        return mallCommodityOrderDao.getOrder(id);
    }

    @Transactional(readOnly = false)
    public void save(MallCommodityOrder orderItem) {
        mallCommodityOrderDao.save(orderItem);
    }

    @Transactional(readOnly = false)
    public void updatePayWay(String id, String payType) {
        mallCommodityOrderDao.updatePayWay(id, payType);
    }

    public List<MallCommodityOrder> listOrder(String id, String status) {
        MallCommodityOrder filter = new MallCommodityOrder();
        filter.setPersonId(id);
        filter.setPayStatus(status);
        return mallCommodityOrderDao.listOrder(filter);
    }

    /**
        * 查询订单列表
        * 根据chanceNum排序
     * @param userId
     * @param status 0 代付款; 1 付款成功; 2 待发货; 3 待收货; 4 交易成功
     * @return
     */
	public List<OrderDetailDto> find(String userId, String status) {
		String[] params = StringUtils.split(status, ',');
		List<OrderDetailDto> entities  = this.mallCommodityOrderDao.findDetailListByUserId(userId, params);
		return entities;
	}
	
	/**
	 * 根据订单号查询订单详情
	 * @param orderId
	 * @return
	 */
	public List<OrderDetailDto> findByOrderId(String orderId) {
		List<OrderDetailDto> entities  = this.mallCommodityOrderDao.findByOrderId(orderId);
		return entities;
	}
	
	/**
	 * 删除订单
	 * @param userId
	 * @param orderId
	 */
	@Transactional(readOnly = false)
	public void delete(String userId, String orderId) {
	    this.mallCommodityOrderDao.delete(orderId);
	    this.mallCommodityOrderDetailDao.delete(orderId);
	}
	
	/**
	 * 确认接收订单
	 * @param userId
	 * @param orderId
	 */
	@Transactional(readOnly = false)
    public void confirm(String userId, String orderId) {
	   this.mallCommodityOrderDao.updateStatus(orderId, "3");
    }
}