package com.atongmu.mall.mall.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7100968401177642739L;
	
	private String orderId;
	
	private String goodsName;
	
	private String goodsImg;
	
	private BigDecimal price;
	
	private Integer num;
	
	private Boolean payed;
	
	private Integer status;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Boolean getPayed() {
		return payed;
	}

	public void setPayed(Boolean payed) {
		this.payed = payed;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format(
				"OrderDetailDto [orderId=%s, goodsName=%s, goodsImg=%s, price=%s, num=%s, payed=%s, status=%s]",
				orderId, goodsName, goodsImg, price, num, payed, status);
	}
}
