package com.atguigu.bean;

import java.math.BigDecimal;

public class MlfrontOrder {
    private Integer orderId;  //1

    private Integer orderUid;
    
	private String orderIp;//

    private String orderOrderitemidstr;//1
    
    private BigDecimal orderMoney;
    
    private Integer orderCouponId;
    
    private String orderCouponCode;//1
    
    private String orderProNumStr;//proNum
    
    private Integer orderPayPlate;//payPlate
    
    private String orderBuyMess;//buyMess
    
    private BigDecimal orderCouponPrice;

    private Integer addressinfoId;//1

    private Integer orderStatus;

    private String orderCreatetime;

    private String orderMotifytime;

    private String orderPaytime;

    private Integer orderLogisticsid;

    private String orderLogisticsname;

    private String orderLogisticsnumber;

    private String orderSendtime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(Integer orderUid) {
        this.orderUid = orderUid;
    }

    public String getOrderIp() {
        return orderIp;
    }

    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp == null ? null : orderIp.trim();
    }

    public String getOrderOrderitemidstr() {
        return orderOrderitemidstr;
    }

    public void setOrderOrderitemidstr(String orderOrderitemidstr) {
        this.orderOrderitemidstr = orderOrderitemidstr == null ? null : orderOrderitemidstr.trim();
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }
    
    public Integer getOrderCouponId() {
        return orderCouponId;
    }

    public void setOrderCouponId(Integer orderCouponId) {
        this.orderCouponId = orderCouponId;
    }
    
    public String getOrderCouponCode() {
        return orderCouponCode;
    }

    public void setOrderCouponCode(String orderCouponCode) {
        this.orderCouponCode = orderCouponCode == null ? null : orderCouponCode.trim();
    }
    
    public String getOrderProNumStr() {
		return orderProNumStr;
	}

	public void setOrderProNumStr(String orderProNumStr) {
		this.orderProNumStr = orderProNumStr == null ? null : orderProNumStr.trim();
	}

	public Integer getOrderPayPlate() {
		return orderPayPlate;
	}

	public void setOrderPayPlate(Integer orderPayPlate) {
		this.orderPayPlate = orderPayPlate;
	}

	public String getOrderBuyMess() {
		return orderBuyMess;
	}

	public void setOrderBuyMess(String orderBuyMess) {
		this.orderBuyMess = orderBuyMess == null ? null : orderBuyMess.trim();
	}

	public BigDecimal getOrderCouponPrice() {
        return orderCouponPrice;
    }

    public void setOrderCouponPrice(BigDecimal orderCouponPrice) {
        this.orderCouponPrice = orderCouponPrice;
    }

    public Integer getAddressinfoId() {
        return addressinfoId;
    }

    public void setAddressinfoId(Integer addressinfoId) {
        this.addressinfoId = addressinfoId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(String orderCreatetime) {
        this.orderCreatetime = orderCreatetime == null ? null : orderCreatetime.trim();
    }

    public String getOrderMotifytime() {
        return orderMotifytime;
    }

    public void setOrderMotifytime(String orderMotifytime) {
        this.orderMotifytime = orderMotifytime == null ? null : orderMotifytime.trim();
    }

    public String getOrderPaytime() {
        return orderPaytime;
    }

    public void setOrderPaytime(String orderPaytime) {
        this.orderPaytime = orderPaytime == null ? null : orderPaytime.trim();
    }

    public Integer getOrderLogisticsid() {
        return orderLogisticsid;
    }

    public void setOrderLogisticsid(Integer orderLogisticsid) {
        this.orderLogisticsid = orderLogisticsid;
    }

    public String getOrderLogisticsname() {
        return orderLogisticsname;
    }

    public void setOrderLogisticsname(String orderLogisticsname) {
        this.orderLogisticsname = orderLogisticsname == null ? null : orderLogisticsname.trim();
    }

    public String getOrderLogisticsnumber() {
        return orderLogisticsnumber;
    }

    public void setOrderLogisticsnumber(String orderLogisticsnumber) {
        this.orderLogisticsnumber = orderLogisticsnumber == null ? null : orderLogisticsnumber.trim();
    }

    public String getOrderSendtime() {
        return orderSendtime;
    }

    public void setOrderSendtime(String orderSendtime) {
        this.orderSendtime = orderSendtime == null ? null : orderSendtime.trim();
    }
}