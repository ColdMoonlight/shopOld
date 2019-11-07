package com.atguigu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MlPaypalShipAddress;
import com.atguigu.bean.MlfrontAddress;
import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.Msg;
import com.atguigu.bean.ToPaypalInfo;
import com.atguigu.enumC.PaypalPaymentIntent;
import com.atguigu.enumC.PaypalPaymentMethod;
import com.atguigu.service.MlPaypalShipAddressService;
import com.atguigu.service.MlfrontAddressService;
import com.atguigu.service.MlfrontOrderItemService;
import com.atguigu.service.MlfrontOrderService;
import com.atguigu.service.MlfrontPayInfoService;
import com.atguigu.service.MlfrontUserService;
import com.atguigu.service.PaypalService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.EmailUtilshtml;
import com.atguigu.utils.EmailUtilshtmlCustomer;
import com.atguigu.utils.URLUtils;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
@RequestMapping("/paypal")
public class PaypalController {
	//wap端相关路径
	public static final String PAYPAL_SUCCESS_M_URL = "paypal/msuccess";
    public static final String PAYPAL_CANCEL_M_URL = "paypal/mcancel";
    public static final String PAYPAL_SUCCESS_M_URLIn = "msuccess";
    public static final String PAYPAL_CANCEL_M_URLIn = "mcancel";
    //pc端相关路径
    public static final String PAYPAL_SUCCESS_P_URL = "paypal/psuccess";
    public static final String PAYPAL_CANCEL_P_URL = "paypal/pcancel";
    public static final String PAYPAL_SUCCESS_P_URLIn = "psuccess";
    public static final String PAYPAL_CANCEL_P_URLIn = "pcancel";

    private Logger log = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private PaypalService paypalService;
    
    @Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
    
    @Autowired
	MlfrontOrderService mlfrontOrderService;
    
    @Autowired
    MlfrontOrderItemService mlfrontOrderItemService;
    
    @Autowired
    MlfrontAddressService mlfrontAddressService;
    
    @Autowired
    MlPaypalShipAddressService mlPaypalShipAddressService;
    
	@Autowired
	MlfrontUserService mlfrontUserService;

    /**1.0
     * 组装参数,WAP端发起真实的支付
     * paypal/mpay
     * */
    @RequestMapping(method = RequestMethod.GET, value = "mpay")
    public String pay(HttpServletRequest request,HttpSession session){
    	System.out.println("into**********/paypal/mpay**********");
    	//读取参数
    	ToPaypalInfo toPaypalInfo = getPayInfo(session);
    	//从session中获取优惠券减去额度
    	String Shopdiscount = getCouponMoney(session);
    	//从session中获取地址运费
    	String addressMoney = getAddressMoney(session);
    	
    	MlfrontAddress mlfrontAddress = getMlfrontAddress(session);
    	
    	List<MlfrontOrderItem> mlfrontOrderItemList = getMlfrontOrderItemList(session);
    	
    	BigDecimal money = toPaypalInfo.getMoneyNum();
    	String moneyStr = money.toString();
    	Double moneyDouble = Double.parseDouble(moneyStr);
    	String moneyTypeStr = toPaypalInfo.getMoneyType();
    	String payDes = toPaypalInfo.getPaymentDescription();

    	//封装paypal所需
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_M_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_M_URL;
        
        //放置session信息
        Integer payFailTimes = 0;
        session.setAttribute("payFailTimes", payFailTimes);
        
        Payment payment = new Payment();
        PaypalService paypalService = new PaypalService();
        try {
            payment = paypalService.createPayment(
            		moneyDouble,// 888.00, 
            		moneyTypeStr, //"USD",  
            		mlfrontAddress,//mlfrontAddress
            		mlfrontOrderItemList,
                    PaypalPaymentMethod.paypal, //paypal
                    PaypalPaymentIntent.sale,//paypal
                    payDes,//"payment description", 
                    Shopdiscount,//"CouponMoney", 
                    addressMoney,//shopping
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
            System.out.println("----------/paypal/mpay/Exception----------");
            System.out.println("---------e.getMessage()-----begin------");
            System.out.println(e.getMessage());
            System.out.println("---------e.getMessage()------end-------");
            System.out.println("---------e.getDetails()-----begin------");
            System.out.println(e.getDetails());
            System.out.println("---------e.getDetails()------end------");
        }
        return "redirect:/MlbackCart/toCheakOut";
    }
    
    //从session中获取地址运费
    private String getAddressMoney(HttpSession session) {
    	String addressMoney = (String) session.getAttribute("addressMoney");
    	System.out.println("addressMoney:"+addressMoney);
		return addressMoney;
	}
    
    //从session中获取优惠券减去额度
	private String getCouponMoney(HttpSession session) {
    	String Shopdiscount = (String) session.getAttribute("CouponCodeMoney");
    	System.out.println("Shopdiscount:"+Shopdiscount);
		return Shopdiscount;
	}

	/**1.1
     * 组装参数,PC端发起真实的支付
     * paypal/ppay
     * */
    @RequestMapping(method = RequestMethod.GET, value = "ppay")
    public String ppay(HttpServletRequest request,HttpSession session){
    	System.out.println("into**********/paypal/ppay**********");
    	//读取参数
    	ToPaypalInfo toPaypalInfo = getPayInfo(session);
    	//从session中获取优惠券减去额度
    	String Shopdiscount = getCouponMoney(session);
    	//从session中获取地址运费
    	String addressMoney = getAddressMoney(session);
    	//从session中获取地址运费
    	MlfrontAddress mlfrontAddress = getMlfrontAddress(session);
    	//从session中获取地址运费
    	List<MlfrontOrderItem> mlfrontOrderItemList = getMlfrontOrderItemList(session);
    	
    	BigDecimal money = toPaypalInfo.getMoneyNum();
    	String moneyStr = money.toString();
    	Double moneyDouble = Double.parseDouble(moneyStr);
    	String moneyTypeStr = toPaypalInfo.getMoneyType();
    	String payDes = toPaypalInfo.getPaymentDescription();
    	//封装paypal所需
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_P_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_P_URL;
        
        //放置session信息
        Integer payFailTimes = 0;
        session.setAttribute("payFailTimes", payFailTimes);
        
        PaypalService paypalService = new PaypalService();
        try {
            Payment payment = paypalService.createPayment(
            		moneyDouble,// 888.00, 
            		moneyTypeStr, //"USD", 
            		mlfrontAddress,//mlfrontAddress
            		mlfrontOrderItemList, 
                    PaypalPaymentMethod.paypal, //paypal
                    PaypalPaymentIntent.sale,//paypal
                    payDes,//"payment description", 
                    Shopdiscount,//"CouponMoney", 
                    addressMoney,//shopping
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
            System.out.println("----------/paypal/ppay/Exception----------");
            System.out.println("---------e.getMessage()-----begin------");
            System.out.println(e.getMessage());
            System.out.println("---------e.getMessage()------end-------");
            System.out.println("---------e.getDetails()-----begin------");
            System.out.println(e.getDetails());
            System.out.println("---------e.getDetails()------end------");
        }
        return "redirect:/MlbackCart/toCheakOut";
    }
    
    /**2.0
     * wap端返回成功页面
     * mfront/paySuccess
     * */
    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_M_URLIn)
    public String successPay(HttpSession session,@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){

    	try {
    		PaypalService paypalService = new PaypalService();
            Payment payment = paypalService.executePayment(paymentId, payerId);
            
            session.setAttribute("successpaymentId", paymentId);
            session.setAttribute("successpayerId", payerId);
            session.setAttribute("successpayment", payment);
            //3.0.1wap+pc端处理toUpdatePayInfoStateSuccess
            //仅仅生成支付号+更改payinfo的状态
        	toUpdatePayInfoStateSuccess(session,payerId,paymentId);
            
            System.out.println(payment.toJSON());
            
            if(payment.getState().equals("approved")){
                return "mfront/paySuccess";
            }else{
            	return "mfront/payFail";
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
            System.out.println("----------/wap端返回成功/Exception----------");
            System.out.println("---------e.getMessage()-----begin------");
            System.out.println(e.getMessage());
            System.out.println("---------e.getMessage()-----end------");
        }
        return "redirect:/";
    }
    
    
    /**2.1
     * PC成功页面
     * front/paySuccess
     * */
    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_P_URLIn)
    public String pcsuccessPay(HttpSession session,@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){

    	try {
    		PaypalService paypalService = new PaypalService();
    		Payment payment = paypalService.executePayment(paymentId, payerId);
            
            session.setAttribute("successpaymentId", paymentId);
            session.setAttribute("successpayerId", payerId);
            session.setAttribute("successpayment", payment);
            
            //3.0.1wap+pc端处理toUpdatePayInfoStateSuccess//仅仅生成支付号
        	toUpdatePayInfoStateSuccess(session,payerId,paymentId);
            
            System.out.println(payment.toJSON());
            
            if(payment.getState().equals("approved")){
                return "front/paySuccess";
            }else{
            	return "front/payFail";
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
            System.out.println("----------/PC成功/Exception----------");
            System.out.println("---------e.getMessage()-----begin------");
            System.out.println(e.getMessage());
            System.out.println("---------e.getMessage()-----end------");
            //return "front/payFail";
        }
    	return "redirect:/";
    }
    
    //wap+pc端处理toUpdatePayInfoStateSuccess//仅仅生成支付号
    private void toUpdatePayInfoStateSuccess(HttpSession session, String payerId, String paymentId) {
    	Integer payinfoId = (Integer) session.getAttribute("payinfoId");
    	//修改支付单状态
    	MlfrontPayInfo mlfrontPayInfoNew = new MlfrontPayInfo();
		mlfrontPayInfoNew.setPayinfoId(payinfoId);
		List<MlfrontPayInfo> MlfrontPayInfoList =mlfrontPayInfoService.selectMlfrontPayInfoById(mlfrontPayInfoNew);
		MlfrontPayInfo mlfrontPayInfoIOne = MlfrontPayInfoList.get(0);
		mlfrontPayInfoIOne.setPayinfoStatus(1);//付款成功
		mlfrontPayInfoIOne.setPayinfoPlatformserialcode(payerId);
		String nowTime = DateUtil.strTime14s();
		mlfrontPayInfoIOne.setPayinfoMotifytime(nowTime);
		//增加生成字段信息
		String payinfoIdStr = payinfoId+"";
		Integer orderlen = payinfoIdStr.length();
		if(orderlen==6){
			payinfoIdStr = "0"+payinfoIdStr;
		}else if(orderlen==5){
			payinfoIdStr = "00"+payinfoIdStr;
		}else if(orderlen==4){
			payinfoIdStr = "000"+payinfoIdStr;
		}else if(orderlen==3){
			payinfoIdStr = "0000"+payinfoIdStr;
		}else if(orderlen==2){
			payinfoIdStr = "00000"+payinfoIdStr;
		}else if(orderlen==1){
			payinfoIdStr = "000000"+payinfoIdStr;
		}
		String payInfoTime = DateUtil.getDateTime();
		//  ML(megalook)	HS(huashuohair)
		String payinfoPlateNum = "ML"+payInfoTime+payinfoIdStr;
//		String payinfoPlateNum = "HSH"+payInfoTime+payinfoIdStr;
		mlfrontPayInfoIOne.setPayinfoPlateNum(payinfoPlateNum);
		mlfrontPayInfoService.updateByPrimaryKeySelective(mlfrontPayInfoIOne);
		session.setAttribute("mlfrontPayInfoIOne", mlfrontPayInfoIOne);
		session.setAttribute("payinfoIdStr", payinfoIdStr);
	}

	/**3.0
     * wap端页面处理toUpdatePayInfoSuccess
     * 
     * */
    @RequestMapping(value = "/tomUpdatePayInfoSuccess",method = RequestMethod.POST)
    @ResponseBody
    public Msg msuccessPage(HttpSession session,@RequestParam("pageStr") String pageStr){
    	
    	String paymentId = (String) session.getAttribute("successpaymentId");
    	String payerId = (String) session.getAttribute("successpayerId");
    	//
    	Payment payment = (Payment) session.getAttribute("successpayment"); 
    	//3.0.1wap+pc端处理toUpdatePayInfoSuccess
    	toUpdatePayInfoSuccess(session,payerId,paymentId);
    	
    	PayerInfo PayerInfo = payment.getPayer().getPayerInfo();
    	
    	Integer payinfoId = (Integer) session.getAttribute("payinfoId");
    	//3.0.2wap+pc端处理insertPaypalReturnAddress
    	insertPaypalReturnAddress(PayerInfo,payinfoId,paymentId);
    	
    	// 获取session中所有的键值  
    	Enumeration<String> attrs = session.getAttributeNames();  
    	// 遍历attrs中的
    	while(attrs.hasMoreElements()){
    	// 获取session键值
    	    String name = attrs.nextElement().toString();
    	    // 根据键值取session中的值  
    	    Object vakue = session.getAttribute(name);
    	    // 打印结果 
    	    //System.out.println("------" + name + ":" + vakue +"--------\n");
    	    }
    	
    	return Msg.success().add("resMsg", "UpdatePayInfoSuccess");
    }
    
    /**3.1
     * pc端页面处理toUpdatePayInfoSuccess
     * 
     * */
    @RequestMapping(value = "/topUpdatePayInfoSuccess",method = RequestMethod.POST)
    @ResponseBody
    public Msg psuccessPage(HttpSession session,@RequestParam("pageStr") String pageStr){
    	
    	String paymentId = (String) session.getAttribute("successpaymentId");
    	String payerId = (String) session.getAttribute("successpayerId");
    	//
    	Payment payment = (Payment) session.getAttribute("successpayment"); 
    	//3.0.1wap+pc端处理toUpdatePayInfoSuccess
    	toUpdatePayInfoSuccess(session,payerId,paymentId);
    	
    	PayerInfo PayerInfo = payment.getPayer().getPayerInfo();
    	
    	Integer payinfoId = (Integer) session.getAttribute("payinfoId");
    	//3.0.2wap+pc端处理insertPaypalReturnAddress
    	insertPaypalReturnAddress(PayerInfo,payinfoId,paymentId);
    	
    	// 获取session中所有的键值  
    	Enumeration<String> attrs = session.getAttributeNames();  
    	// 遍历attrs中的
    	while(attrs.hasMoreElements()){
    	// 获取session键值
    	    String name = attrs.nextElement().toString();
    	    // 根据键值取session中的值  
    	    Object vakue = session.getAttribute(name);
    	    // 打印结果 
    	   // System.out.println("------" + name + ":" + vakue +"--------\n");
    	    }
    	
    	return Msg.success().add("resMsg", "UpdatePayInfoSuccess");
    }
    
    
    /**
     * 3.0.2wap端处理
     * insertPaypalReturnAddress
     * */
    @SuppressWarnings("deprecation")
	private void insertPaypalReturnAddress(PayerInfo payerInfo, Integer payinfoId, String paymentId) {
    	
    	String email =  payerInfo.getEmail();
    	String RecipientName =  payerInfo.getShippingAddress().getRecipientName();
    	String Line1 =  payerInfo.getShippingAddress().getLine1();
    	String Line2 =  payerInfo.getShippingAddress().getLine2();
    	String City =  payerInfo.getShippingAddress().getCity();
    	String countryCode =  payerInfo.getShippingAddress().getCountryCode();
    	String PostalCode =  payerInfo.getShippingAddress().getPostalCode();
    	String State =  payerInfo.getShippingAddress().getState();
    	
    	String payinfoIdStr =  payinfoId+"";
    	MlPaypalShipAddress mlPaypalShipAddress = new MlPaypalShipAddress();
    	mlPaypalShipAddress.setShippingaddressPayinfoid(payinfoIdStr);
    	mlPaypalShipAddress.setShippingaddressPaymentid(paymentId);
    	mlPaypalShipAddress.setShippingaddressEmail(email);
    	mlPaypalShipAddress.setShippingaddressRecipientName(RecipientName);
    	mlPaypalShipAddress.setShippingaddressLine1(Line1);
    	mlPaypalShipAddress.setShippingaddressLine2(Line2);
    	mlPaypalShipAddress.setShippingaddressCity(City);
    	mlPaypalShipAddress.setShippingaddressCountryCode(countryCode);
    	mlPaypalShipAddress.setShippingaddressPostalCode(PostalCode);
    	mlPaypalShipAddress.setShippingaddressState(State);
    	
    	mlPaypalShipAddressService.insertSelective(mlPaypalShipAddress);
    	
	}
    
    /**
     * 
     * 3.0.1wap端处理toUpdatePayInfoSuccess
     * */
	private void toUpdatePayInfoSuccess(HttpSession session, String payerId, String paymentId) {
    	
    	Integer payinfoId = (Integer) session.getAttribute("payinfoId");
    	
    	MlfrontPayInfo mlfrontPayInfoIOne = (MlfrontPayInfo) session.getAttribute("mlfrontPayInfoIOne");
    	String nowTime = DateUtil.strTime14s();
		
		//修改order单状态
    	Integer orderId = (Integer) session.getAttribute("orderId");
		//Integer orderId = mlfrontPayInfoIOne.getPayinfoOid();
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
		//将付款成功的参数successPayinfoId,successOrderId放入session中
		session.setAttribute("successPayinfoId", payinfoId);
		session.setAttribute("successOrderId", orderId);
		
		String addressMoney = getAddressMoney(session);
		//3.0.1.1	wap+pc同时处理邮件
		sendResultEmail(session,mlfrontPayInfoIOne, mlfrontOrderResOne,addressMoney);
		
		//更新用户的vip等级+购买次数
		MlfrontUser mlfrontUser= (MlfrontUser) session.getAttribute("loginUser");
		if(mlfrontUser==null){
			System.out.println("次购买为非注册用户,不对mlfrontUser进行任何操作");
		}else{
			//获取session中的mlfrontUser信息，从中获取userEmail
			String userEmail = mlfrontUser.getUserEmail();
			//拿到userEmail,准备信息
			MlfrontUser mlfrontUserByEmail = new MlfrontUser();
			mlfrontUserByEmail.setUserEmail(userEmail);
			List<MlfrontUser> mlfrontUserByEmailListres =  mlfrontUserService.selectMlfrontUserWhenFirst(mlfrontUserByEmail);
			MlfrontUser mlfrontUserByEmailres = mlfrontUserByEmailListres.get(0);
			Integer uid = mlfrontUserByEmailres.getUserId();
			Integer userTimesOld = mlfrontUserByEmailres.getUserTimes();
			Integer userTimesafter =userTimesOld+1;
			Integer userVipLevelOld =mlfrontUserByEmailres.getUserVipLevel();
			Integer userVipLevelafter = userVipLevelOld+1;
			
			mlfrontUserByEmailres.setUserId(uid);
			mlfrontUserByEmailres.setUserTimes(userTimesafter);
			mlfrontUserByEmailres.setUserVipLevel(userVipLevelafter);
			mlfrontUserService.updateByPrimaryKeySelective(mlfrontUserByEmailres);
		}
	}

	
    /**
     * 3.0.1.1	wap+pc同时处理邮件
     * */
    private void sendResultEmail(HttpSession session,MlfrontPayInfo mlfrontPayInfoIOne, MlfrontOrder mlfrontOrderResOne, String addressMoney) {
    	try {
        	List<MlfrontOrderItem> mlfrontOrderItemList = getMlfrontOrderItemList(session);
    		Integer addressId = (Integer) session.getAttribute("sendAddressinfoId");
    				
    		MlfrontAddress mlfrontAddressReq = new MlfrontAddress();
    		MlfrontAddress mlfrontAddressRes = new MlfrontAddress();
    		mlfrontAddressReq.setAddressId(addressId);
    		
    		List<MlfrontAddress> mlfrontAddressResList = mlfrontAddressService.selectMlfrontAddressById(mlfrontAddressReq);
    		
    		mlfrontAddressRes = mlfrontAddressResList.get(0);
    		System.out.println(mlfrontAddressRes.toString());
    		String userEmail = mlfrontAddressRes.getAddressEmail();
    		
			//测试方法
			String getToEmail = userEmail;
			String Message = "pay Success</br>,已收到您的付款,会尽快给您安排发货,注意留意发货通知.祝您购物愉快";
			EmailUtilshtml.readyEmailPaySuccess(getToEmail, Message,mlfrontOrderItemList,mlfrontPayInfoIOne,mlfrontOrderResOne,addressMoney);
			EmailUtilshtmlCustomer.readyEmailPaySuccessCustomer(getToEmail, Message,mlfrontOrderItemList,mlfrontPayInfoIOne,mlfrontOrderResOne,addressMoney);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**4.0
     * 返回wap失败页面
     * mfront/payFail
     * */
	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_M_URLIn)
    public String cancelPay(HttpSession session){
		
		Integer payFailTimes = (Integer) session.getAttribute("payFailTimes");
		payFailTimes+=1;
        session.setAttribute("payFailTimes", payFailTimes);
		//4.0.1更新失败所需修改的表
		toUpdatePayInfoFail(session);
		
        return "mfront/payFail";
    }
	
	/**4.1
     * 返回PC失败页面
     * front/payFail
     * */
	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_P_URLIn)
    public String pcancelPay(HttpSession session){
		
		Integer payFailTimes = (Integer) session.getAttribute("payFailTimes");
		payFailTimes+=1;
        session.setAttribute("payFailTimes", payFailTimes);
        //4.0.1更新失败所需修改的表
		toUpdatePayInfoFail(session);
		
        return "front/payFail";
    }
    
	/**
	 * 
	 * 4.0.1更新失败所需修改的表
	 * */
    private void toUpdatePayInfoFail(HttpSession session) {
    	Integer payinfoId = (Integer) session.getAttribute("payinfoId");
    	//修改支付单状态
    	MlfrontPayInfo mlfrontPayInfoNew = new MlfrontPayInfo();
		mlfrontPayInfoNew.setPayinfoId(payinfoId);
		List<MlfrontPayInfo> MlfrontPayInfoList =mlfrontPayInfoService.selectMlfrontPayInfoById(mlfrontPayInfoNew);
		MlfrontPayInfo mlfrontPayInfoIOne = MlfrontPayInfoList.get(0);
		mlfrontPayInfoIOne.setPayinfoStatus(0);//0未支付;1已支付;2支付失败;3已审核;4已发货;
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
		mlfrontOrderResOne.setOrderStatus(0);//0未支付;1已支付;2支付失败;3已审核;4已发货;
		mlfrontOrderResOne.setOrderMotifytime(nowTime);
		mlfrontOrderResOne.setOrderPaytime(nowTime);
		//执行更新
		mlfrontOrderService.updateByPrimaryKeySelective(mlfrontOrderResOne);
		
	}

	/**
     * 内部调用,封装toPaypalInfo
     * */
    private ToPaypalInfo getPayInfo(HttpSession session) {
    	//从session中获取对象
    	MlfrontAddress mlfrontAddressToPay = (MlfrontAddress) session.getAttribute("mlfrontAddressToPay");
    	BigDecimal totalprice = (BigDecimal) session.getAttribute("totalprice");
    	ToPaypalInfo toPaypalInfo = new ToPaypalInfo();
		//从对象中获取参数
//		String toPayEmail = mlfrontAddressToPay.getAddressEmail();
		String toPayTelephone = mlfrontAddressToPay.getAddressTelephone();
		String toPayCountry = mlfrontAddressToPay.getAddressCountry();
		String toPayProvince = mlfrontAddressToPay.getAddressProvince();
		String toPayCity = mlfrontAddressToPay.getAddressCity();
		String toPayDetail = mlfrontAddressToPay.getAddressDetail();
		String toPayUserfirstname = mlfrontAddressToPay.getAddressUserfirstname();
		String toPayUserlastname = mlfrontAddressToPay.getAddressUserlastname();
		//拼接参数
		String toPayDesc = " ";
//		toPayDesc=toPayDesc+toPayEmail+",";
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
	
    /**
     * 内部调用,获取getMlfrontAddress
     * */
    private MlfrontAddress getMlfrontAddress(HttpSession session) {
    	MlfrontAddress mlfrontAddressToPay = (MlfrontAddress) session.getAttribute("mlfrontAddressToPay");
		return mlfrontAddressToPay;
	}
    
    /**
     * 内部调用,获取getMlfrontOrderItemList
     * */
    private List<MlfrontOrderItem> getMlfrontOrderItemList(HttpSession session) {
    	Integer orderId = (Integer) session.getAttribute("orderId");
    	
    	MlfrontOrder mlfrontOrderReq = new MlfrontOrder();
    	mlfrontOrderReq.setOrderId(orderId);
    	List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectMlfrontOrderById(mlfrontOrderReq);
    	MlfrontOrder mlfrontOrderRes = mlfrontOrderList.get(0);
    	String orderitemidstr = mlfrontOrderRes.getOrderOrderitemidstr();
    	String orderitemidArr[] = orderitemidstr.split(",");
    	
    	MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
    	MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
    	
    	List<MlfrontOrderItem> mlfrontOrderItemsList = new ArrayList<MlfrontOrderItem>();
    	for(int i=0;i<orderitemidArr.length;i++){
			Integer orderItemId = Integer.parseInt(orderitemidArr[i]);
			mlfrontOrderItemReq.setOrderitemId(orderItemId);
			List<MlfrontOrderItem> mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
			mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
			mlfrontOrderItemsList.add(mlfrontOrderItemRes);
		}
		return mlfrontOrderItemsList;
	}
    
}
