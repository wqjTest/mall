package com.atongmu.mall.mall.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atongmu.mall.common.util.baseEntity.ResultResponse;
import com.atongmu.mall.mall.dto.OrderDetailDto;
import com.atongmu.mall.mall.entity.MallCommodityOrder;
import com.atongmu.mall.mall.service.MallCommodityOrderService;

@Controller
@RequestMapping("orders/{userId}")
public class OrderController {

	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private MallCommodityOrderService mallCommodityOrderService;

	@RequestMapping("/{status}")
	public String findOrders(@PathVariable(required = true) String userId, @RequestParam String chancenum,
			@PathVariable String status, HttpServletRequest request, HttpServletResponse response, Model model) {

		LOG.info("userId : %s; chancenum : %s; status= : %s", userId, chancenum, status);
		model.addAttribute("chancenum", chancenum);
		List<OrderDetailDto> entities = this.mallCommodityOrderService.find(userId, status);
		Integer num = entities.stream().map(OrderDetailDto::getNum).reduce(0, (x, y) -> x + y);
		BigDecimal total = entities.stream().map(OrderDetailDto::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		model.addAttribute("entities", entities);
		model.addAttribute("num", num);
		model.addAttribute("total", total);
		return "mall/myorders";
	}

	@RequestMapping("/all")
	public String findAllOrders(@PathVariable(required = true) String userId, @RequestParam String chancenum,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		LOG.info("userId : %s; chancenum : %s;", userId, chancenum);

		List<OrderDetailDto> entities = this.mallCommodityOrderService.find(userId, null);

		// 未付款
		List<OrderDetailDto> unpayedList = new ArrayList<OrderDetailDto>();

		// 已经付款
		List<OrderDetailDto> payedList = new ArrayList<OrderDetailDto>();

		// 待发货
		List<OrderDetailDto> waitDeliverList = new ArrayList<OrderDetailDto>();
		// 待收货
		List<OrderDetailDto> deliverList = new ArrayList<OrderDetailDto>();
		// 待评价
		List<OrderDetailDto> doneList = new ArrayList<OrderDetailDto>();

		// 分组 + 统计
		entities.stream().forEach(e -> {
			// 未付款
			if (e.getStatus() == 0) {
				unpayedList.add(e);
			} else {
				payedList.add(e);
			}
			// 代发货
			if (e.getStatus() == 1) {
				waitDeliverList.add(e);
			}
			// 待收货
			if (e.getStatus() == 2) {
				deliverList.add(e);
			}
			// 待评价
			if (e.getStatus() == 3) {
				doneList.add(e);
			}
		});

		// 未付款
		Integer unpayedNum = unpayedList.stream().map(OrderDetailDto::getNum).reduce(0, (x, y) -> x + y);
		BigDecimal unpayedTotal = unpayedList.stream().map(OrderDetailDto::getPrice).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		model.addAttribute("unpayedList", unpayedList);
		model.addAttribute("unpayedNum", unpayedNum);
		model.addAttribute("unpayedTotal", unpayedTotal);

		// 已经付款
		Integer payedNum = payedList.stream().map(OrderDetailDto::getNum).reduce(0, (x, y) -> x + y);
		BigDecimal payedTotal = payedList.stream().map(OrderDetailDto::getPrice).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		model.addAttribute("payedList", payedList);
		model.addAttribute("payedNum", payedNum);
		model.addAttribute("payedTotal", payedTotal);

		// 代发货
		Integer num2 = waitDeliverList.stream().map(OrderDetailDto::getNum).reduce(0, (x, y) -> x + y);
		BigDecimal total2 = waitDeliverList.stream().map(OrderDetailDto::getPrice).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		model.addAttribute("list2", waitDeliverList);
		model.addAttribute("num2", num2);
		model.addAttribute("total2", total2);

		// 待收货
		Integer num3 = deliverList.stream().map(OrderDetailDto::getNum).reduce(0, (x, y) -> x + y);
		BigDecimal total3 = deliverList.stream().map(OrderDetailDto::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		model.addAttribute("list3", deliverList);
		model.addAttribute("num3", num3);
		model.addAttribute("total3", total3);

		// 待评价
		Integer num4 = doneList.stream().map(OrderDetailDto::getNum).reduce(0, (x, y) -> x + y);
		BigDecimal total4 = doneList.stream().map(OrderDetailDto::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		model.addAttribute("list4", doneList);
		model.addAttribute("num4", num4);
		model.addAttribute("total4", total4);

		return "mall/myorders";
	}
	
	@RequestMapping(path = "delete/{orderId}")
	@ResponseBody
	public ResultResponse<Object> delete(@PathVariable String userId, @PathVariable String orderId) {
		LOG.info("userId : %s; orderId : %s;", userId, orderId);
		this.mallCommodityOrderService.delete(userId, orderId);
		ResultResponse<Object> result = new ResultResponse<Object>(null);
		return result;
	}
	
	
	@RequestMapping("find")
	@ResponseBody
    public ResultResponse<List<OrderDetailDto>> findOrders(@PathVariable(required = true) String userId, @RequestParam(required=false) String status) {
        LOG.info("userId : {}; status : {}", userId, status);
        
        List<OrderDetailDto> entities = this.mallCommodityOrderService.find(userId, status);
        ResultResponse<List<OrderDetailDto>> result = new ResultResponse<>();
        result.setData(entities);
        return result;
    }
	
	@RequestMapping(path = "/view/{orderId}")
	@ResponseBody
    public ResultResponse<MallCommodityOrder> getDetail(@PathVariable String userId, @PathVariable String orderId) {
        LOG.info("userId : %s; orderId : %s; ", userId, orderId);
        MallCommodityOrder order = this.mallCommodityOrderService.getOrder(orderId);
        List<OrderDetailDto> details = this.mallCommodityOrderService.findByOrderId(orderId);
        order.setDetails(details);
        ResultResponse<MallCommodityOrder> result = new ResultResponse<>();
        result.setData(order);
        return result;
    }
	
	@RequestMapping(path = "/confirm/{orderId}")
    @ResponseBody
    public ResultResponse<Object> confirm(@PathVariable String userId, @PathVariable String orderId) {
        LOG.info("userId : {}; orderId : {}; ", userId, orderId);
        this.mallCommodityOrderService.confirm(userId, orderId);
        ResultResponse<Object> result = new ResultResponse<>();
        result.setData(null);
        return result;
    }
}
