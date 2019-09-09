package com.atongmu.mall.mall.web;

import com.atongmu.mall.common.util.baseEntity.ResultResponse;
import com.atongmu.mall.mall.entity.MallCommodityCar;
import com.atongmu.mall.mall.entity.ReqParam;
import com.atongmu.mall.mall.service.MallCommodityCarService;
import com.atongmu.mall.mall.util.CarUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: mall
 * @description: 商城商品购物车控制器
 * @author: Hus
 * @create: 2018-12-27 14:47
 */
@Controller
@RequestMapping(path = {"mallCar"})
public class MallCommodityCarController {

    @Resource
    private MallCommodityCarService mallCommodityCarService;

    @Resource
    private CarUtil carUtil;

    /**
     * 商品购物车页面
     *
     */
    @RequestMapping(path = {"viewMallCar/{userId}"}, method = RequestMethod.GET)
    public String viewMallCar(@PathVariable(value = "userId", required = true)String userId,
                              HttpServletRequest request, HttpServletResponse response, Model model){
        List<MallCommodityCar> carList = mallCommodityCarService.listMallCarByUserId(userId);
        model.addAttribute("carList", carList);
        return "mall/shopping";
    }

    /**
     * 添加商品到购物车
     *
     */
    @RequestMapping(path = {"addCommodityCar"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResultResponse addCommodityCar(@RequestBody ReqParam param, HttpServletRequest request,
                                       HttpServletResponse response){
        carUtil.addCar(param.getCommodityId(), param.getUserId(), 1);
        return new ResultResponse();
    }

    /**
     * 修改购物车数量
     *
     */
    @RequestMapping(path = {"editCommodityCarNumber"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResultResponse editCommodityCarNumber(@RequestBody ReqParam param, HttpServletRequest request,
                                          HttpServletResponse response){
        carUtil.editCarNumber(param.getCommodityId(), param.getCommodityCarId(), param.getCommodityCarNum());
        return new ResultResponse();
    }

    /**
     * 删除购物车商品
     *
     */
    @RequestMapping(path = {"deleteCommodityCar/{id}"}, method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse deleteCommodityCar(@PathVariable(value = "id", required = true)String id,
                                             HttpServletRequest request, HttpServletResponse response){
        carUtil.deleteCar(id);
        return new ResultResponse(0,"宝贝已清除");
    }

}