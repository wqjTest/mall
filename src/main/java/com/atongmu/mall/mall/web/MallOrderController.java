package com.atongmu.mall.mall.web;

import com.atongmu.mall.common.util.baseEntity.ResultResponse;
import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.common.util.payUtil.PayResult;
import com.atongmu.mall.common.util.payUtil.PayUtils;
import com.atongmu.mall.mall.entity.*;
import com.atongmu.mall.mall.service.MallCommodityCarService;
import com.atongmu.mall.mall.service.MallCommodityService;
import com.atongmu.mall.mall.service.MallUserAddressService;
import com.atongmu.mall.mall.util.OrderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: mall
 * @description: 商城订单服务
 * @author: Hus
 * @create: 2018-12-26 15:30
 */
@Controller
@RequestMapping(path = {"mallOrder"})
public class MallOrderController {

    @Resource
    private MallCommodityService mallCommodityService;

    @Resource
    private MallUserAddressService mallUserAddressService;

    @Resource
    private OrderUtil orderUtil;

    @Resource
    private MallCommodityCarService mallCommodityCarService;

    /**
     * 订单预览页面
     *
     * */
    @RequestMapping(path = {"previewOrder"}, method = RequestMethod.GET)
    public String previewOrder(ReqParam param, HttpServletRequest request, HttpServletResponse response,
                               Model model){
        if(param == null || StringUtil.isBlank(param.getCommodityId())){
            return "mall/firmOrder";
        }
        MallCommodity mallCommodity = mallCommodityService.getCommodity(param.getCommodityId());
        mallCommodity.setSaleNum(1);
        model.addAttribute("mallCommodity", mallCommodity);
        List<MallUserAddress> listAddress = mallUserAddressService.listUserAddress(param.getUserId());
        if(listAddress.size() > 0){
            model.addAttribute("address",
                    mallUserAddressService.listUserAddress(param.getUserId()).get(0));
        }
        return "mall/firmOrder";
    }

    /**
     * 订单预览页面
     * 多商品
     *
     * */
    @RequestMapping(path = {"previewOrderList"}, method = RequestMethod.GET)
    public String previewOrderList(ReqParam param, HttpServletRequest request, HttpServletResponse response,
                               Model model){
        // 获取商城商品列表，购物车的
        List<String> carIds = Arrays.asList(param.getCommodityCarId().split(","));
        List<MallCommodity> mallCommodityList = mallCommodityCarService.listCommodityByCarIds(carIds);
        model.addAttribute("mallCommodityList", mallCommodityList);
        List<MallUserAddress> listAddress = mallUserAddressService.listUserAddress(param.getUserId());
        if(listAddress.size() > 0){
            model.addAttribute("address",
                    mallUserAddressService.listUserAddress(param.getUserId()).get(0));
        }
        return "mall/firmOrderList";
    }

    /**
     * 创建订单
     *
     * */
    @RequestMapping(path = {"createOrder"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResultResponse createOrder(@RequestBody ReqParam param,
                                      HttpServletRequest request, HttpServletResponse response){
        MallCommodityOrder mallCommodityOrder
                = orderUtil.createOrderDetail(
                        param.getCommodityId(), param.getUserId(), param.getAddressId(), param.getLave());
        return new ResultResponse(mallCommodityOrder.getId(), "success");
    }

    /**
     * 创建订单
     *
     * */
    @RequestMapping(path = {"createOrderList"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResultResponse createOrderList(@RequestBody ReqParam param,
                                          HttpServletRequest request, HttpServletResponse response){
        MallCommodityOrder mallCommodityOrder
                = orderUtil.createOrderDetails(
                param.getCarParam(), param.getUserId(), param.getAddressId(), param.getLave());
        return new ResultResponse(mallCommodityOrder.getId(), "success");
    }

    /**
     * 支付订单页面
     *
     * */
    @RequestMapping(path = {"viewOrder/{orderId}"}, method = RequestMethod.GET)
    public String viewOrder(@PathVariable(value = "orderId", required = true)String orderId,
                            HttpServletRequest request, HttpServletResponse response, Model model){
        model.addAttribute("order", orderUtil.getOrder(orderId));
        return "mall/cost";
    }

    /**
     * 提交订单去支付
     *
     * */
    @RequestMapping(path = {"payMoney"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public PayResult payMoney(@RequestBody ReqParam param,
                              HttpServletRequest request, HttpServletResponse response){
        PayResult payResult = new PayResult();
        MallCommodityOrder order = orderUtil.getOrder(param.getOrderId());
        payResult = PayUtils.createPayOrder(param.getPayType(), order.getOrderCode(), order.getOrderAmount());
        // 更新订单的支付方式
        orderUtil.updatePayWay(order.getId(), param.getPayType());
        return payResult;
    }

    @RequestMapping(path = {"payResult"}, method = RequestMethod.GET)
    public String payResult(@RequestParam(value = "orderId") String orderId,
                            @RequestParam(value = "result") String result,
                            HttpServletRequest request, HttpServletResponse response, Model model){
        MallCommodityOrder order = orderUtil.getOrder(orderId);
        model.addAttribute("order", order);
        if("true".equals(result)){
            model.addAttribute("status", "true");
        }else{
            model.addAttribute("status", "false");
        }
        return "mall/paySuccess";
    }

}