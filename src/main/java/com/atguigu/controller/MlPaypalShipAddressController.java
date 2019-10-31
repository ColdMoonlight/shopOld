package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MlPaypalShipAddress;
import com.atguigu.bean.MlfrontReview;
import com.atguigu.bean.Msg;
import com.atguigu.service.MlPaypalShipAddressService;
import com.atguigu.service.MlbackAdminService;

@Controller
@RequestMapping("/MlPaypalShipAddress")
public class MlPaypalShipAddressController {
		
	@Autowired
	MlPaypalShipAddressService mlPaypalShipAddressService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	useOn	0505
	 * 查看单条MlfrontReview的详情细节
	 * @param MlfrontReview
	 * @return 
	 */
	@RequestMapping(value="/getOneMlfrontReviewDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlPaypalShipAddressByPayinfoid(@RequestParam(value = "shippingaddressPayinfoid") String shippingaddressPayinfoid){
		//接受信息
		MlPaypalShipAddress mlPaypalShipAddressReq = new MlPaypalShipAddress();
		mlPaypalShipAddressReq.setShippingaddressPayinfoid(shippingaddressPayinfoid);
		MlPaypalShipAddress mlPaypalShipAddressRes =mlPaypalShipAddressService.selectMlPaypalShipAddressByPayinfoid(mlPaypalShipAddressReq);
		return Msg.success().add("resMsg", "查看单条优惠券的详情细节完毕")
					.add("mlPaypalShipAddressOne", mlPaypalShipAddressRes);
	}
	
}
