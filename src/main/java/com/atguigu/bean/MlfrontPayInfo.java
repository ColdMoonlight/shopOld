package com.atguigu.bean;

import java.math.BigDecimal;

public class MlfrontPayInfo {
    private Integer payinfoId;

    private Integer payinfoUid;

    private String payinfoIp;

    private Integer payinfoOid;

    private String payinfoPlatform;

    private String payinfoPlatformserialcode;

    private BigDecimal payinfoMoney;

    private Integer payinfoStatus;

    private String payinfoReason;

    private String payinfoCreatetime;

    private String payinfoMotifytime;

    public Integer getPayinfoId() {
        return payinfoId;
    }

    public void setPayinfoId(Integer payinfoId) {
        this.payinfoId = payinfoId;
    }

    public Integer getPayinfoUid() {
        return payinfoUid;
    }

    public void setPayinfoUid(Integer payinfoUid) {
        this.payinfoUid = payinfoUid;
    }

    public String getPayinfoIp() {
        return payinfoIp;
    }

    public void setPayinfoIp(String payinfoIp) {
        this.payinfoIp = payinfoIp == null ? null : payinfoIp.trim();
    }

    public Integer getPayinfoOid() {
        return payinfoOid;
    }

    public void setPayinfoOid(Integer payinfoOid) {
        this.payinfoOid = payinfoOid;
    }

    public String getPayinfoPlatform() {
        return payinfoPlatform;
    }

    public void setPayinfoPlatform(String payinfoPlatform) {
        this.payinfoPlatform = payinfoPlatform == null ? null : payinfoPlatform.trim();
    }

    public String getPayinfoPlatformserialcode() {
        return payinfoPlatformserialcode;
    }

    public void setPayinfoPlatformserialcode(String payinfoPlatformserialcode) {
        this.payinfoPlatformserialcode = payinfoPlatformserialcode == null ? null : payinfoPlatformserialcode.trim();
    }

    public BigDecimal getPayinfoMoney() {
        return payinfoMoney;
    }

    public void setPayinfoMoney(BigDecimal payinfoMoney) {
        this.payinfoMoney = payinfoMoney;
    }

    public Integer getPayinfoStatus() {
        return payinfoStatus;
    }

    public void setPayinfoStatus(Integer payinfoStatus) {
        this.payinfoStatus = payinfoStatus;
    }

    public String getPayinfoReason() {
        return payinfoReason;
    }

    public void setPayinfoReason(String payinfoReason) {
        this.payinfoReason = payinfoReason == null ? null : payinfoReason.trim();
    }

    public String getPayinfoCreatetime() {
        return payinfoCreatetime;
    }

    public void setPayinfoCreatetime(String payinfoCreatetime) {
        this.payinfoCreatetime = payinfoCreatetime == null ? null : payinfoCreatetime.trim();
    }

    public String getPayinfoMotifytime() {
        return payinfoMotifytime;
    }

    public void setPayinfoMotifytime(String payinfoMotifytime) {
        this.payinfoMotifytime = payinfoMotifytime == null ? null : payinfoMotifytime.trim();
    }
}