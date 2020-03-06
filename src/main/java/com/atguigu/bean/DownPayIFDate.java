package com.atguigu.bean;

import java.math.BigDecimal;

public class DownPayIFDate {
	
	private Integer payinfoId;
	private Integer payinfoOid;
	private BigDecimal payinfoMoney;
	private Integer payinfoStatus;
	private String payinfoCreatetime;
	private String payinfoMotifytime;
	private MlfrontOrder mlfrontOrder;
	private MlfrontAddress mlfrontAddress;
	
	public Integer getPayinfoId() {
		return payinfoId;
	}
	public void setPayinfoId(Integer payinfoId) {
		this.payinfoId = payinfoId;
	}
	public Integer getPayinfoOid() {
		return payinfoOid;
	}
	public void setPayinfoOid(Integer payinfoOid) {
		this.payinfoOid = payinfoOid;
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
	public String getPayinfoCreatetime() {
		return payinfoCreatetime;
	}
	public void setPayinfoCreatetime(String payinfoCreatetime) {
		this.payinfoCreatetime = payinfoCreatetime;
	}
	public String getPayinfoMotifytime() {
		return payinfoMotifytime;
	}
	public void setPayinfoMotifytime(String payinfoMotifytime) {
		this.payinfoMotifytime = payinfoMotifytime;
	}
	public MlfrontOrder getMlfrontOrder() {
		return mlfrontOrder;
	}
	public void setMlfrontOrder(MlfrontOrder mlfrontOrder) {
		this.mlfrontOrder = mlfrontOrder;
	}
	public MlfrontAddress getMlfrontAddress() {
		return mlfrontAddress;
	}
	public void setMlfrontAddress(MlfrontAddress mlfrontAddress) {
		this.mlfrontAddress = mlfrontAddress;
	}
	public DownPayIFDate() {
		super();
	}
	
	public DownPayIFDate(Integer payinfoId, Integer payinfoOid, BigDecimal payinfoMoney, Integer payinfoStatus,
			String payinfoCreatetime, String payinfoMotifytime, MlfrontOrder mlfrontOrder,
			MlfrontAddress mlfrontAddress) {
		super();
		this.payinfoId = payinfoId;
		this.payinfoOid = payinfoOid;
		this.payinfoMoney = payinfoMoney;
		this.payinfoStatus = payinfoStatus;
		this.payinfoCreatetime = payinfoCreatetime;
		this.payinfoMotifytime = payinfoMotifytime;
		this.mlfrontOrder = mlfrontOrder;
		this.mlfrontAddress = mlfrontAddress;
	}
	
	@Override
	public String toString() {
		return "DownPayIFDate [payinfoId=" + payinfoId + ", payinfoOid=" + payinfoOid + ", payinfoMoney=" + payinfoMoney
				+ ", payinfoStatus=" + payinfoStatus + ", payinfoCreatetime=" + payinfoCreatetime
				+ ", payinfoMotifytime=" + payinfoMotifytime + ", mlfrontOrder=" + mlfrontOrder + ", mlfrontAddress="
				+ mlfrontAddress + "]";
	}
	
}
