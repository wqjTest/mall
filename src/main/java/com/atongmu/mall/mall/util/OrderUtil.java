package com.atongmu.mall.mall.util;

import com.atongmu.mall.common.util.general.Global;
import com.atongmu.mall.common.util.general.IdGen;
import com.atongmu.mall.common.util.general.MathUtil;
import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.common.util.payUtil.alipay.UtilDate;
import com.atongmu.mall.mall.entity.*;
import com.atongmu.mall.mall.service.*;
import com.atongmu.mall.student.entity.KigStudentRelation;
import com.atongmu.mall.student.service.KigStudentRelationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: mall
 * @description: 商城订单工具
 * @author: Hus
 * @create: 2018-12-26 20:27
 */
@Component
public class OrderUtil {

    @Resource
    private UserService userService;

    @Resource
    private KigStudentRelationService kigStudentRelationService;

    @Resource
    private MallCommodityCarService mallCommodityCarService;

    @Resource
    private MallCommodityService mallCommodityService;

    @Resource
    private MallCommodityOrderService mallCommodityOrderService;

    @Resource
    private MallCommodityOrderDetailService mallCommodityOrderDetailService;

    @Resource
    private MallOrderInvoiceService mallOrderInvoiceService;

    @Resource
    private MallOrderInvoiceDetailService mallOrderInvoiceDetailService;

    /**
     * 创建订单明细
     *
     * */
    public MallCommodityOrder createOrderDetail(String commodityId, String userId,
                                                String addressId, String lave){
        // 查询商品信息
        MallCommodity mallCommodity = getCommodity(commodityId);
        // 获取家长信息
        KigStudentRelation relation = getRelation(userId);
        // 获取user信息
        User user = getUser(userId);
        // 创建订单
        // 1、生成ID
        String orderId = IdGen.uuid();
        // 2、生成订单明细
        MallCommodityOrderDetail mallCommodityOrderDetail
                = createOrderDetail(user.getId(), orderId, 1, mallCommodity);
        // 3、生成总订单
        MallCommodityOrder mallCommodityOrder
                = createOrder(orderId, user.getId(), user.getSourceId(), relation.getRelation(),
                relation.getPersonName(), mallCommodityOrderDetail.getAmount(), addressId, lave);
        return mallCommodityOrder;
    }

    /**
     * 创建订单明细
     * 组合订单
     *
     * */
    public MallCommodityOrder createOrderDetails(List<String> carList, String userId,
                                                 String addressId, String lave){
        // 获取家长信息
        KigStudentRelation relation = getRelation(userId);
        // 获取user信息
        User user = getUser(userId);
        // 1、生成ID
        String orderId = IdGen.uuid();
        BigDecimal total = new BigDecimal("0.00");
        MallCommodity mallCommodity = null;
        MallCommodityOrderDetail mallCommodityOrderDetail = null;
        MallCommodityCar mallCommodityCar = null;
        for (String item : carList
             ) {
            mallCommodityCar = getCarCommodity(item);
            // 查询商品信息
            mallCommodity = getCommodity(mallCommodityCar.getCommodityId());
            // 创建订单
            // 2、生成订单明细
            mallCommodityOrderDetail
                    = createOrderDetail(user.getId(), orderId, mallCommodityCar.getNumber(), mallCommodity);
            total = MathUtil.priceAdd(mallCommodityOrderDetail.getAmount(), total);
            // 删除购物车的Item
            mallCommodityCarService.delete(item);
        }
        // 3、生成总订单
        MallCommodityOrder mallCommodityOrder
                = createOrder(orderId, user.getId(), user.getSourceId(), relation.getRelation(),
                relation.getPersonName(), total, addressId, lave);
        return mallCommodityOrder;
    }

    /**
     * 创建订单明细
     *
     * */
    private MallCommodityOrderDetail createOrderDetail(String userId, String orderId,
                                                       int commodityNum, MallCommodity mallCommodity){
        MallCommodityOrderDetail orderDetailItem = new MallCommodityOrderDetail();
        orderDetailItem.setId(IdGen.uuid());
        orderDetailItem.setCreateBy(userId);
        orderDetailItem.setCreateDate(LocalDateTime.now());
        orderDetailItem.setUpdateBy(userId);
        orderDetailItem.setUpdateDate(LocalDateTime.now());
        orderDetailItem.setDelFlag(0);
        orderDetailItem.setRemarks("");
        orderDetailItem.setOrderId(orderId);
        orderDetailItem.setCommodityId(mallCommodity.getId());
        orderDetailItem.setPrice(mallCommodity.getPrice());
        orderDetailItem.setCommodityNum(commodityNum);
        // 计算价格
        orderDetailItem.setAmount(MathUtil.priceTimesQuantity(mallCommodity.getPrice(), commodityNum));
        mallCommodityOrderDetailService.save(orderDetailItem);
        return orderDetailItem;
    }

    /**
     * 创建总订单
     *
     * */
    private MallCommodityOrder createOrder(String orderId, String userId, String relationId,
                                           String relation, String relationName,
                                           BigDecimal price, String addressId, String lave){
        MallCommodityOrder orderItem = new MallCommodityOrder();
        orderItem.setId(orderId);
        orderItem.setCreateBy(userId);
        orderItem.setCreateDate(LocalDateTime.now());
        orderItem.setUpdateBy(userId);
        orderItem.setUpdateDate(LocalDateTime.now());
        orderItem.setDelFlag(0);
        orderItem.setRemarks(lave);
        orderItem.setPersonId(relationId);
        orderItem.setPersonName(relationName);
        orderItem.setPersonType(relation);
        orderItem.setOrderCode(UtilDate.getOrderNum() + UtilDate.getThree());
        orderItem.setOrderAmount(price);
        orderItem.setPayStatus("0");
        orderItem.setPayTime(null);
        orderItem.setPayType("");
        orderItem.setPayFlag("0");
        orderItem.setTradeNo("");
        orderItem.setCourierNumber("");
        if(StringUtil.isNotBlank(addressId)){
            orderItem.setReceivingAddress(addressId);
        }
        mallCommodityOrderService.save(orderItem);
        return orderItem;
    }

    /**
     * 获取购物车的信息
     * */
    public MallCommodityCar getCarCommodity(String carId){
        MallCommodityCar mallCommodityCar
                = mallCommodityCarService.getCommodityCar(carId);
        return mallCommodityCar;
    }

    /**
     * 获取订单详细信息
     * */
    public MallCommodityOrder getOrder(String orderId){
        MallCommodityOrder mallCommodityOrder
                = mallCommodityOrderService.getOrder(orderId);
        return mallCommodityOrder;
    }

    /**
     * 更新订单支付方式
     * */
    public void updatePayWay(String id, String payType) {
        if(Global.ALIPAY_NAME.equals(payType)){
            payType = "支付宝";
        }else{
            payType = "微信";
        }
        mallCommodityOrderService.updatePayWay(id, payType);
    }

    /**
     * 获取商品详情
     * */
    private MallCommodity getCommodity(String commodityId){
        return mallCommodityService.getCommodity(commodityId);
    }

    /**
     * 获取家长详细信息
     * */
    private KigStudentRelation getRelation(String userId){
        return kigStudentRelationService.getRelation(userId);
    }

    /**
     * 获取用户详细信息
     * */
    private User getUser(String userId){
        return userService.getUserById(userId);
    }

    /**
    * @Description: 创建订单发票记录
    * @Param: [carParam, userId]
    * @return: java.lang.String
    * @Author: Hus
    * @Date: 2019/1/11
    */
    public String createInvoice(List<String> orderIds, String userId) {
        User user = getUser(userId);
        MallOrderInvoice mallOrderInvoice = new MallOrderInvoice();
        mallOrderInvoice.setId(IdGen.uuid());
        mallOrderInvoice.setCreateDate(LocalDateTime.now());
        mallOrderInvoice.setCreateBy(user.getId());
        mallOrderInvoice.setUpdateDate(LocalDateTime.now());
        mallOrderInvoice.setUpdateBy(user.getId());
        mallOrderInvoice.setRemarks("");
        mallOrderInvoice.setDelFlag(1);
        mallOrderInvoice.setPersonId(userId);
        mallOrderInvoice.setInvoiceAmount(createInvoice(mallOrderInvoice.getId(), orderIds));
        mallOrderInvoice.setInvoiceFlag(0);
        mallOrderInvoiceService.save(mallOrderInvoice);
        return mallOrderInvoice.getId();
    }

    public String saveInvoice(MallOrderInvoice mallOrderInvoice) {
        MallOrderInvoice orderInvoice = mallOrderInvoiceService.getOrderInvoice(mallOrderInvoice.getId());
        orderInvoice.setDelFlag(0);
        orderInvoice.setRemarks(mallOrderInvoice.getRemarks());
        orderInvoice.setIdentificationNumber(mallOrderInvoice.getIdentificationNumber());
        if(Global.PERSON.equals(mallOrderInvoice.getInvoiceType())){
            orderInvoice.setInvoiceType("0");
        }else{
            orderInvoice.setInvoiceType("1");
        }
        if(Global.ELECTRONIC.equals(mallOrderInvoice.getInvoiceType())){
            orderInvoice.setInvoiceHead("0");
        }else{
            orderInvoice.setInvoiceHead("1");
        }
        orderInvoice.setInvoiceTitle(mallOrderInvoice.getInvoiceTitle());
        orderInvoice.setInvoiceContent(mallOrderInvoice.getInvoiceContent());
        orderInvoice.setInvoiceRecipient(mallOrderInvoice.getInvoiceRecipient());
        orderInvoice.setInvoiceAddress(mallOrderInvoice.getInvoiceAddress());
        orderInvoice.setInvoiceName(mallOrderInvoice.getInvoiceName());
        orderInvoice.setInvoicePhone(mallOrderInvoice.getInvoicePhone());
        orderInvoice.setInvoiceEmail(mallOrderInvoice.getInvoiceEmail());
        mallOrderInvoiceService.update(orderInvoice);
        return orderInvoice.getId();
    }

    public BigDecimal createInvoice(String id, List<String> orderIds){
        MallOrderInvoiceDetail mallOrderInvoiceDetail = null;
        BigDecimal total = new BigDecimal("0.00");
        for (String item : orderIds
             ) {
            MallCommodityOrder order = getOrder(item);
            total = MathUtil.priceAdd(order.getOrderAmount(), total);
            mallOrderInvoiceDetail = new MallOrderInvoiceDetail();
            mallOrderInvoiceDetail.setInvoiceId(id);
            mallOrderInvoiceDetail.setOrderId(item);
            mallOrderInvoiceDetailService.save(mallOrderInvoiceDetail);
        }
        return total;
    }

}