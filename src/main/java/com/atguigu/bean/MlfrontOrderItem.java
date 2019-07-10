package com.atguigu.bean;

import java.math.BigDecimal;

public class MlfrontOrderItem {
    private Integer orderitemId;

    private Integer orderId;

    private Integer orderUid;
    
    private Integer orderCartItemId;

    private Integer orderitemPid;

    private String orderitemPname;

    private BigDecimal orderitemProductOriginalprice;

    private String orderitemProductMainimgurl;

    private Integer orderitemProductAccoff;

    private String orderitemPskuIdstr;

    private String orderitemPskuIdnamestr;

    private String orderitemPskuNamestr;

    private String orderitemPskuMoneystr;

    private Integer orderitemPskuNumber;

    private String orderitemPskuReamoney;

    private String orderitemCreatetime;

    private String orderitemMotifytime;

    public Integer getOrderitemId() {
        return orderitemId;
    }

    public void setOrderitemId(Integer orderitemId) {
        this.orderitemId = orderitemId;
    }

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

    public Integer getOrderCartItemId() {
		return orderCartItemId;
	}

	public void setOrderCartItemId(Integer orderCartItemId) {
		this.orderCartItemId = orderCartItemId;
	}

    public Integer getOrderitemPid() {
        return orderitemPid;
    }

    public void setOrderitemPid(Integer orderitemPid) {
        this.orderitemPid = orderitemPid;
    }

    public String getOrderitemPname() {
        return orderitemPname;
    }

    public void setOrderitemPname(String orderitemPname) {
        this.orderitemPname = orderitemPname == null ? null : orderitemPname.trim();
    }

    public BigDecimal getOrderitemProductOriginalprice() {
        return orderitemProductOriginalprice;
    }

    public void setOrderitemProductOriginalprice(BigDecimal orderitemProductOriginalprice) {
        this.orderitemProductOriginalprice = orderitemProductOriginalprice;
    }

    public String getOrderitemProductMainimgurl() {
        return orderitemProductMainimgurl;
    }

    public void setOrderitemProductMainimgurl(String orderitemProductMainimgurl) {
        this.orderitemProductMainimgurl = orderitemProductMainimgurl == null ? null : orderitemProductMainimgurl.trim();
    }

    public Integer getOrderitemProductAccoff() {
        return orderitemProductAccoff;
    }

    public void setOrderitemProductAccoff(Integer orderitemProductAccoff) {
        this.orderitemProductAccoff = orderitemProductAccoff;
    }

    public String getOrderitemPskuIdstr() {
        return orderitemPskuIdstr;
    }

    public void setOrderitemPskuIdstr(String orderitemPskuIdstr) {
        this.orderitemPskuIdstr = orderitemPskuIdstr == null ? null : orderitemPskuIdstr.trim();
    }

    public String getOrderitemPskuIdnamestr() {
        return orderitemPskuIdnamestr;
    }

    public void setOrderitemPskuIdnamestr(String orderitemPskuIdnamestr) {
        this.orderitemPskuIdnamestr = orderitemPskuIdnamestr == null ? null : orderitemPskuIdnamestr.trim();
    }

    public String getOrderitemPskuNamestr() {
        return orderitemPskuNamestr;
    }

    public void setOrderitemPskuNamestr(String orderitemPskuNamestr) {
        this.orderitemPskuNamestr = orderitemPskuNamestr == null ? null : orderitemPskuNamestr.trim();
    }

    public String getOrderitemPskuMoneystr() {
        return orderitemPskuMoneystr;
    }

    public void setOrderitemPskuMoneystr(String orderitemPskuMoneystr) {
        this.orderitemPskuMoneystr = orderitemPskuMoneystr == null ? null : orderitemPskuMoneystr.trim();
    }

    public Integer getOrderitemPskuNumber() {
        return orderitemPskuNumber;
    }

    public void setOrderitemPskuNumber(Integer orderitemPskuNumber) {
        this.orderitemPskuNumber = orderitemPskuNumber;
    }

    public String getOrderitemPskuReamoney() {
        return orderitemPskuReamoney;
    }

    public void setOrderitemPskuReamoney(String orderitemPskuReamoney) {
        this.orderitemPskuReamoney = orderitemPskuReamoney;
    }

    public String getOrderitemCreatetime() {
        return orderitemCreatetime;
    }

    public void setOrderitemCreatetime(String orderitemCreatetime) {
        this.orderitemCreatetime = orderitemCreatetime == null ? null : orderitemCreatetime.trim();
    }

    public String getOrderitemMotifytime() {
        return orderitemMotifytime;
    }

    public void setOrderitemMotifytime(String orderitemMotifytime) {
        this.orderitemMotifytime = orderitemMotifytime == null ? null : orderitemMotifytime.trim();
    }
}