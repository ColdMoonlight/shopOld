package com.atguigu.bean;

import java.math.BigDecimal;

public class DownPayEcppDate {

//	SELECT tpay.payInfo_id, tpay.payInfo_createTime,tpay.payInfo_plateNum,taddress.address_userFirstName,taddress.address_userLastName,
//	taddress.address_email,taddress.address_detail,taddress.address_province,taddress.address_city,taddress.address_post, taddress.address_countryAll,taddress.address_country,taddress.address_telephone,
//	torderitem.orderItem_pSku_nameStr,tpro.product_seo,torderitem.orderItem_pSku_number,tpay.payInfo_money,torder.order_buy_mess
//	from tb_mlfront_payinfo as tpay,tb_mlfront_order as torder, tb_mlfront_orderitem as torderitem, tb_mlfront_address as taddress ,tb_mlback_product as tpro
//	WHERE tpay.payInfo_status=1 AND tpay.payInfo_createTime BETWEEN '2020-02-19 08:00:00' AND '2020-02-20 09:00:00' AND taddress.address_id = torder.addressinfo_id AND torder.order_id = tpay.payInfo_oid AND torder.order_id = torderitem.order_id AND torderitem.orderItem_pid = tpro.product_id
//	ORDER BY tpay.payInfo_createTime
		
	private Integer payinfoId;
	private String payinfoCreatetime;
	private String payinfoPlateNum;
	private MlfrontAddress mlfrontAddress;
	private MlfrontOrderItem mlfrontOrderItem;
	private MlbackProduct mlbackProduct;
	private BigDecimal payinfoMoney;
	private MlfrontOrder mlfrontOrder;
	private String payinfoMotifytime;
	private Integer payinfoStatus;
	
	public Integer getPayinfoId() {
		return payinfoId;
	}
	public void setPayinfoId(Integer payinfoId) {
		this.payinfoId = payinfoId;
	}
	public String getPayinfoCreatetime() {
		return payinfoCreatetime;
	}
	public void setPayinfoCreatetime(String payinfoCreatetime) {
		this.payinfoCreatetime = payinfoCreatetime;
	}
	public String getPayinfoPlateNum() {
		return payinfoPlateNum;
	}
	public void setPayinfoPlateNum(String payinfoPlateNum) {
		this.payinfoPlateNum = payinfoPlateNum;
	}
	public MlfrontAddress getMlfrontAddress() {
		return mlfrontAddress;
	}
	public void setMlfrontAddress(MlfrontAddress mlfrontAddress) {
		this.mlfrontAddress = mlfrontAddress;
	}
	public MlfrontOrderItem getMlfrontOrderItem() {
		return mlfrontOrderItem;
	}
	public void setMlfrontOrderItem(MlfrontOrderItem mlfrontOrderItem) {
		this.mlfrontOrderItem = mlfrontOrderItem;
	}
	public MlbackProduct getMlbackProduct() {
		return mlbackProduct;
	}
	public void setMlbackProduct(MlbackProduct mlbackProduct) {
		this.mlbackProduct = mlbackProduct;
	}
	public BigDecimal getPayinfoMoney() {
		return payinfoMoney;
	}
	public void setPayinfoMoney(BigDecimal payinfoMoney) {
		this.payinfoMoney = payinfoMoney;
	}
	public MlfrontOrder getMlfrontOrder() {
		return mlfrontOrder;
	}
	public void setMlfrontOrder(MlfrontOrder mlfrontOrder) {
		this.mlfrontOrder = mlfrontOrder;
	}
	public String getPayinfoMotifytime() {
		return payinfoMotifytime;
	}
	public void setPayinfoMotifytime(String payinfoMotifytime) {
		this.payinfoMotifytime = payinfoMotifytime;
	}
	public Integer getPayinfoStatus() {
		return payinfoStatus;
	}
	public void setPayinfoStatus(Integer payinfoStatus) {
		this.payinfoStatus = payinfoStatus;
	}
	public DownPayEcppDate() {
		super();
	}
	public DownPayEcppDate(Integer payinfoId, String payinfoCreatetime, String payinfoPlateNum,
			MlfrontAddress mlfrontAddress, MlfrontOrderItem mlfrontOrderItem, MlbackProduct mlbackProduct,
			BigDecimal payinfoMoney, MlfrontOrder mlfrontOrder, String payinfoMotifytime, Integer payinfoStatus) {
		super();
		this.payinfoId = payinfoId;
		this.payinfoCreatetime = payinfoCreatetime;
		this.payinfoPlateNum = payinfoPlateNum;
		this.mlfrontAddress = mlfrontAddress;
		this.mlfrontOrderItem = mlfrontOrderItem;
		this.mlbackProduct = mlbackProduct;
		this.payinfoMoney = payinfoMoney;
		this.mlfrontOrder = mlfrontOrder;
		this.payinfoMotifytime = payinfoMotifytime;
		this.payinfoStatus = payinfoStatus;
	}
	
	
	@Override
	public String toString() {
		return "DownPayEcppDate [payinfoId=" + payinfoId + ", payinfoCreatetime=" + payinfoCreatetime
				+ ", payinfoPlateNum=" + payinfoPlateNum + ", mlfrontAddress=" + mlfrontAddress + ", mlfrontOrderItem="
				+ mlfrontOrderItem + ", mlbackProduct=" + mlbackProduct + ", payinfoMoney=" + payinfoMoney
				+ ", mlfrontOrder=" + mlfrontOrder + ", payinfoMotifytime=" + payinfoMotifytime + ", payinfoStatus="
				+ payinfoStatus + "]";
	}
	
}
