package com.atguigu.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.MlfrontAddress;
import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.enumC.PaypalPaymentIntent;
import com.atguigu.enumC.PaypalPaymentMethod;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;


@Service
public class PaypalService {
	
	
	@Autowired
	MlfrontOrderService mlfrontOrderService;
	
	
	@Autowired
	private APIContext apiContext;

	public Payment createPayment(
            Double total, 
            String currency, 
            MlfrontAddress mlfrontAddress,
            List<MlfrontOrderItem> mlfrontOrderItemList,
            PaypalPaymentMethod method, 
            PaypalPaymentIntent intent, 
            String description, 
            String cancelUrl, 
            String successUrl) throws PayPalRESTException{
		
//		*APIContext，RequestID是自动生成的，调用setMaskRequestID（true）
//		*将重写RequestID getter以返回空值
		apiContext.setMaskRequestId(true);
		
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.format("%.2f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);
        
        //增加支付详情的信息
        ItemList itemList = new ItemList();
        //准备地址信息
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setId(mlfrontAddress.getAddressId()+"");
        shippingAddress.setCountryCode(mlfrontAddress.getAddressCountry());
        shippingAddress.setLine1(mlfrontAddress.getAddressProvince());
        shippingAddress.setCity(mlfrontAddress.getAddressCity());
        shippingAddress.setLine2(mlfrontAddress.getAddressDetail());
        shippingAddress.setPostalCode(mlfrontAddress.getAddressPost());
        shippingAddress.setPhone(mlfrontAddress.getAddressTelephone());
        shippingAddress.setRecipientName(mlfrontAddress.getAddressUserfirstname()+" "+mlfrontAddress.getAddressUserlastname());
        itemList.setShippingAddress(shippingAddress);
        //准备订单详情详情信息
        List<Item> items = new ArrayList<>();
        
        //获取总价格
        String TotalPrice = String.format("%.2f", total);
        //封装传递给paypal的客户金额参数信息
        String noteStr = "Total："+"$"+TotalPrice;
        
        for(MlfrontOrderItem mlfrontOrderItem:mlfrontOrderItemList){
        	Item item = new Item();
            item.setSku(mlfrontOrderItem.getOrderitemPskuNamestr());
            item.setName(mlfrontOrderItem.getOrderitemPname());
            item.setPrice(mlfrontOrderItem.getOrderitemPskuReamoney());
            item.setQuantity(mlfrontOrderItem.getOrderitemPskuNumber()+"");
            item.setCurrency(currency);
            items.add(item);
        }
        itemList.setItems(items);
        
        //transaction.setItemList(itemList);//

        List<Transaction> transactions = new ArrayList<>();
        
        //这里加点东西
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());
        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setNoteToPayer(noteStr);
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }

}
