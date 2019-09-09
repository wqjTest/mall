/**
 * Project Name: mall
 * Date: 2019/1/10 17:18
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.web;

import com.atongmu.mall.common.util.baseEntity.ResultResponse;
import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.mall.entity.MallCommodityOrder;
import com.atongmu.mall.mall.entity.MallOrderInvoice;
import com.atongmu.mall.mall.entity.ReqParam;
import com.atongmu.mall.mall.service.MallCommodityOrderService;
import com.atongmu.mall.mall.service.MallOrderInvoiceService;
import com.atongmu.mall.mall.util.OrderUtil;
import com.atongmu.mall.student.entity.KigStudent;
import com.atongmu.mall.student.entity.KigStudentRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: 开票控制器
 * @Author: Hus
 * @Create: 2019-01-10 17:18
 */
@Controller
@RequestMapping(path = {"invoice"})
public class MallInvoiceController {

    @Resource
    private MallCommodityOrderService mallCommodityOrderService;

    @Resource
    private MallOrderInvoiceService mallOrderInvoiceService;

    @Resource
    private OrderUtil orderUtil;

    private Logger logger = LoggerFactory.getLogger(MallInvoiceController.class);

    @RequestMapping(path = {"listOrder/{userId}"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultResponse<List<MallCommodityOrder>> listOrder(@PathVariable(value = "userId") String userId,
                                                              HttpServletRequest request, HttpServletResponse response) {
        ResultResponse result = new ResultResponse();
        result.setData(mallCommodityOrderService.find(userId, "2"));
        return result;
    }

    @RequestMapping(path = {"invoiceIndex"}, method = RequestMethod.GET)
    public String invoiceIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "mall/invoice";
    }

    @RequestMapping(path = {"listOrder/{userId}"}, method = RequestMethod.GET)
    public String listOrder(@PathVariable(value = "userId") String userId,
                            HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("listOrder", mallCommodityOrderService.listOrder(userId, "2"));
        return "mall/shoppingOpen";
    }

    @RequestMapping(path = {"createInvoice"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultResponse<String> createInvoice(@RequestBody ReqParam param){
        String id = orderUtil.createInvoice(param.getCarParam(), param.getUserId());
        ResultResponse<String> result = new ResultResponse<>();
        result.setData(id);
        return result;
    }

    @RequestMapping(path = {"editInvoice/{invoiceId}"}, method = RequestMethod.GET)
    public String editInvoice(@PathVariable(value = "invoiceId") String invoiceId,
                              HttpServletRequest request, HttpServletResponse response, Model model){
        MallOrderInvoice mallOrderInvoice = mallOrderInvoiceService.getOrderInvoice(invoiceId);
        model.addAttribute("mallOrderInvoice", mallOrderInvoice);
        return "mall/drawAbill";
    }

    @RequestMapping(path = {"saveInvoice"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultResponse saveInvoice(@RequestBody MallOrderInvoice param,
                              HttpServletRequest request, HttpServletResponse response){
        orderUtil.saveInvoice(param);
        return new ResultResponse();
    }

    @RequestMapping(path = {"listInvoice/{userId}"}, method = RequestMethod.GET)
    public String listInvoice(@PathVariable(value = "userId") String userId,
                              HttpServletRequest request, HttpServletResponse response, Model model){
        MallOrderInvoice invoiceFilter = new MallOrderInvoice();
        invoiceFilter.setPersonId(userId);
        List<MallOrderInvoice> listOrderInvoice = mallOrderInvoiceService.listOrderInvoice(invoiceFilter);
        model.addAttribute("listOrderInvoice", listOrderInvoice);
        return "mall/invoiceHistory";
    }

}