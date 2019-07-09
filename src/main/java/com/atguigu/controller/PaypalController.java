package com.atguigu.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.bean.MlfrontAddress;
import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.bean.ToPaypalInfo;
import com.atguigu.enumC.PaypalPaymentIntent;
import com.atguigu.enumC.PaypalPaymentMethod;
import com.atguigu.service.MlfrontOrderService;
import com.atguigu.service.MlfrontPayInfoService;
import com.atguigu.service.PaypalService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.URLUtils;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
@RequestMapping("/paypal")
public class PaypalController {
		
	public static final String PAYPAL_SUCCESS_URL = "paypal/success";
    public static final String PAYPAL_CANCEL_URL = "paypal/cancel";
    public static final String PAYPAL_SUCCESS_URLIn = "success";
    public static final String PAYPAL_CANCEL_URLIn = "cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;
    
    @Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
    
    @Autowired
	MlfrontOrderService mlfrontOrderService;

    /**1.0
     * 组装参数,发起真实的支付
     * paypal/pay
     * */
//    @RequestMapping(method = RequestMethod.POST, value = "pay")
    @RequestMapping(method = RequestMethod.GET, value = "pay")
    public String pay(HttpServletRequest request,HttpSession session){
    	//读取参数
    	ToPaypalInfo toPaypalInfo = getPayInfo(session);
    	BigDecimal money = toPaypalInfo.getMoneyNum();
    	String moneyStr = money.toString();
    	Double moneyDouble = Double.parseDouble(moneyStr);
    	String moneyTypeStr = toPaypalInfo.getMoneyType();
    	String payDes = toPaypalInfo.getPaymentDescription();
    	//封装paypal所需
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
        try {
            Payment payment = paypalService.createPayment(
            		moneyDouble,// 888.00, 
            		moneyTypeStr, //"USD", 
                    PaypalPaymentMethod.paypal, //paypal
                    PaypalPaymentIntent.sale,//paypal
                    payDes,//"payment description", 
                    cancelUrl, 
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                	System.out.println("links.getHref:"+links.getHref());
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }
    
    /**2.0
     * 返回成功页面
     * mfront/paySuccess
     * */
    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URLIn)
    public String successPay(HttpSession session,@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){

    	try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            
            toUpdatePayInfoSuccess(session,payerId,paymentId);
            
            System.out.println(payment.toJSON());
            if(payment.getState().equals("approved")){
                return "mfront/paySuccess";
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }
    
    private void toUpdatePayInfoSuccess(HttpSession session, String payerId, String paymentId) {
    	
    	Integer payinfoId = (Integer) session.getAttribute("payinfoId");
    	//修改支付单状态
    	MlfrontPayInfo mlfrontPayInfoNew = new MlfrontPayInfo();
		mlfrontPayInfoNew.setPayinfoId(payinfoId);
		mlfrontPayInfoNew.setPayinfoStatus(0);
		List<MlfrontPayInfo> MlfrontPayInfoList =mlfrontPayInfoService.selectMlfrontPayInfoById(mlfrontPayInfoNew);
		MlfrontPayInfo mlfrontPayInfoIOne = MlfrontPayInfoList.get(0);
		mlfrontPayInfoIOne.setPayinfoStatus(1);//付款成功
		System.out.println("paymentId:"+paymentId);
		System.out.println("payerId:"+payerId);
		mlfrontPayInfoIOne.setPayinfoPlatformserialcode(payerId);
		String nowTime = DateUtil.strTime14s();
		mlfrontPayInfoIOne.setPayinfoMotifytime(nowTime);
		mlfrontPayInfoService.updateByPrimaryKeySelective(mlfrontPayInfoIOne);
		
		//修改order单状态
		Integer orderId = mlfrontPayInfoIOne.getPayinfoOid();
		//封装req
		MlfrontOrder mlfrontOrderPayReq = new MlfrontOrder();
		mlfrontOrderPayReq.setOrderId(orderId);
		//查回结果
		List<MlfrontOrder> mlfrontOrderList =  mlfrontOrderService.selectMlfrontOrderById(mlfrontOrderPayReq);
		MlfrontOrder mlfrontOrderResOne = mlfrontOrderList.get(0);
		//准备更新数据
		mlfrontOrderResOne.setOrderStatus(1);
		mlfrontOrderResOne.setOrderMotifytime(nowTime);
		mlfrontOrderResOne.setOrderPaytime(nowTime);
		//执行更新
		mlfrontOrderService.updateByPrimaryKeySelective(mlfrontOrderResOne);
		
	}

	/**2.0
     * 返回失败页面
     * mfront/payFail
     * */
	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URLIn)
    public String cancelPay(HttpSession session){
		
		toUpdatePayInfoFail(session);
		
        return "mfront/payFail";
    }
    
    private void toUpdatePayInfoFail(HttpSession session) {
    	Integer payinfoId = (Integer) session.getAttribute("payinfoId");
    	//修改支付单状态
    	MlfrontPayInfo mlfrontPayInfoNew = new MlfrontPayInfo();
		mlfrontPayInfoNew.setPayinfoId(payinfoId);
		mlfrontPayInfoNew.setPayinfoStatus(0);
		List<MlfrontPayInfo> MlfrontPayInfoList =mlfrontPayInfoService.selectMlfrontPayInfoById(mlfrontPayInfoNew);
		MlfrontPayInfo mlfrontPayInfoIOne = MlfrontPayInfoList.get(0);
		mlfrontPayInfoIOne.setPayinfoStatus(2);//0未支付1已支付2,支付失败3,已发货;
		String nowTime = DateUtil.strTime14s();
		mlfrontPayInfoIOne.setPayinfoMotifytime(nowTime);
		mlfrontPayInfoService.updateByPrimaryKeySelective(mlfrontPayInfoIOne);
		
		//修改order单状态
		Integer orderId = mlfrontPayInfoIOne.getPayinfoOid();
		//封装req
		MlfrontOrder mlfrontOrderPayReq = new MlfrontOrder();
		mlfrontOrderPayReq.setOrderId(orderId);
		//查回结果
		List<MlfrontOrder> mlfrontOrderList =  mlfrontOrderService.selectMlfrontOrderById(mlfrontOrderPayReq);
		MlfrontOrder mlfrontOrderResOne = mlfrontOrderList.get(0);
		//准备更新数据
		mlfrontOrderResOne.setOrderStatus(2);//0未支付;1已支付;2支付失败;3已发货;
		mlfrontOrderResOne.setOrderMotifytime(nowTime);
		mlfrontOrderResOne.setOrderPaytime(nowTime);
		//执行更新
		mlfrontOrderService.updateByPrimaryKeySelective(mlfrontOrderResOne);
		
	}

	/**
     * 内部调用,获取发送信息
     * 
     * */
    private ToPaypalInfo getPayInfo(HttpSession session) {
    	//从session中获取对象
    	MlfrontAddress mlfrontAddressToPay = (MlfrontAddress) session.getAttribute("mlfrontAddressToPay");
    	BigDecimal totalprice = (BigDecimal) session.getAttribute("totalprice");
    	ToPaypalInfo toPaypalInfo = new ToPaypalInfo();
		//从对象中获取参数
		String toPayEmail = mlfrontAddressToPay.getAddressEmail();
		String toPayTelephone = mlfrontAddressToPay.getAddressTelephone();
		String toPayCountry = mlfrontAddressToPay.getAddressCountry();
		String toPayProvince = mlfrontAddressToPay.getAddressProvince();
		String toPayCity = mlfrontAddressToPay.getAddressCity();
		String toPayDetail = mlfrontAddressToPay.getAddressDetail();
		String toPayUserfirstname = mlfrontAddressToPay.getAddressUserfirstname();
		String toPayUserlastname = mlfrontAddressToPay.getAddressUserlastname();
		//拼接参数
		String toPayDesc = " ";
		toPayDesc=toPayDesc+toPayEmail+",";
		toPayDesc+=toPayTelephone+",";
		toPayDesc+=toPayCountry+",";
		toPayDesc+=toPayProvince+",";
		toPayDesc+=toPayCity+",";
		toPayDesc+=toPayDetail+",";
		toPayDesc+=toPayUserfirstname+",";
		toPayDesc+=toPayUserlastname;
		toPaypalInfo.setMoneyNum(totalprice);
		toPaypalInfo.setMoneyType("USD");
		toPaypalInfo.setPaymentDescription(toPayDesc);
		return toPaypalInfo;
	}
	
}
