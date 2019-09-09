package com.atongmu.mall.mall.util;

import com.atongmu.mall.common.util.general.IdGen;
import com.atongmu.mall.common.util.general.MathUtil;
import com.atongmu.mall.mall.entity.MallCommodity;
import com.atongmu.mall.mall.entity.MallCommodityCar;
import com.atongmu.mall.mall.entity.User;
import com.atongmu.mall.mall.service.MallCommodityCarService;
import com.atongmu.mall.mall.service.MallCommodityService;
import com.atongmu.mall.mall.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: mall
 * @description: 购物车工具
 * @author: Hus
 * @create: 2018-12-27 15:09
 */
@Component
public class CarUtil {

    @Resource
    private UserService userService;

    @Resource
    private MallCommodityService mallCommodityService;

    @Resource
    private MallCommodityCarService mallCommodityCarService;

    /**
     * 添加购物车
     *
     * */
    public void addCar(String commodityId, String userId, int num) {
        MallCommodity commodity = getCommodity(commodityId);
        List<MallCommodityCar> mallCommodityCars
                = mallCommodityCarService.listMallCarByCommodityAndUserId(commodityId, userId);
        if (mallCommodityCars.size() <= 0) {
            User user = getUser(userId);
            saveMallCar(userId, user.getSourceId(), commodity, num);
        } else {
            editMallCar(mallCommodityCars.get(0), commodity);
        }
    }

    /**
     * 添加购物车
     *
     * */
    public void editCarNumber(String commodityId, String commodityCarId, int num) {
        MallCommodity commodity = getCommodity(commodityId);
        MallCommodityCar mallCommodityCar = getCommodityCar(commodityCarId);
        mallCommodityCar.setNumber(num);
        editMallCarNumber(mallCommodityCar, commodity);
    }

    /**
     * 删除购物车
     *
     * */
    public void deleteCar(String id) {
        mallCommodityCarService.delete(id);
    }

    /**
     * 编辑购物车
     *
     * */
    private void editMallCar(MallCommodityCar mallCommodityCar, MallCommodity mallCommodity){
        mallCommodityCar.setUpdateDate(LocalDateTime.now());
        mallCommodityCar.setNumber(mallCommodityCar.getNumber() + 1);
        mallCommodityCar.setCommodityPrice(mallCommodity.getCommodityPrice());
        mallCommodityCar.setPrice(MathUtil.priceTimesQuantity(
                mallCommodity.getPrice(), mallCommodityCar.getNumber()));
        mallCommodityCarService.updateMallCommodityCar(mallCommodityCar);
    }

    /**
     * 编辑购物车数量
     *
     * */
    private void editMallCarNumber(MallCommodityCar mallCommodityCar, MallCommodity mallCommodity){
        mallCommodityCar.setUpdateDate(LocalDateTime.now());
        mallCommodityCar.setCommodityPrice(mallCommodity.getCommodityPrice());
        mallCommodityCar.setPrice(MathUtil.priceTimesQuantity(
                mallCommodity.getPrice(), mallCommodityCar.getNumber()));
        mallCommodityCarService.updateMallCommodityCar(mallCommodityCar);
    }

    /**
     * 新建购物车
     *
     * */
    private void saveMallCar(String userId, String relationId,
                             MallCommodity commodity, int num){
        MallCommodityCar carItem = new MallCommodityCar();
        carItem.setId(IdGen.uuid());
        carItem.setCreateDate(LocalDateTime.now());
        carItem.setCreateBy(userId);
        carItem.setUpdateBy(userId);
        carItem.setUpdateDate(LocalDateTime.now());
        carItem.setDelFlag(0);
        carItem.setRemarks("");
        carItem.setUserId(relationId);
        carItem.setCommodityId(commodity.getId());
        carItem.setCommodityImage(commodity.getCommodityImage());
        carItem.setCommodityName(commodity.getCommodityName());
        carItem.setCommodityPrice(commodity.getCommodityPrice());
        carItem.setPrice(MathUtil.priceTimesQuantity(commodity.getPrice(), num));
        carItem.setNumber(num);
        mallCommodityCarService.save(carItem);
    }

    /**
     * 新建购物车
     *
     * */
    private void deleteMallCar(String commodityCarId){
       mallCommodityCarService.delete(commodityCarId);
    }

    /**
     * 获取用户详细信息
     * */
    private MallCommodityCar getCommodityCar(String carId){
        return mallCommodityCarService.getCommodityCar(carId);
    }

    /**
     * 获取商品详情
     * */
    private MallCommodity getCommodity(String commodityId){
        return mallCommodityService.getCommodity(commodityId);
    }

    /**
     * 获取用户详细信息
     * */
    private User getUser(String userId){
        return userService.getUserById(userId);
    }

}