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
import com.paypal.api.payments.Details;
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
	
	String clientId = "AQyXf-N2nNr8QwJsFt7IudPRL-CMGYEXCCzgqOHIA037JLhSFOEchb2kGa_z_BqzKY4CmUPFiGqG_uNj";
	String clientSecret = "EO5N6EtaEiIQXF18UWWZJGGeB8VL4qMxC-jR4tvHoXJD0RBdZGzcCguUBuRgWNBR8Lk-ge8XRK379NCl";
	
	
	@Autowired
	MlfrontOrderService mlfrontOrderService;
	
	
//	@Autowired
//	private APIContext apiContext;
	APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");

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
		      
        
      //获取总价格
  		String kk = (String.format("%.2f", total));
  		System.out.println(kk);

  		

  		// ###Transaction
  		// A transaction defines the contract of a
  		// payment - what is the payment for and who
  		// is fulfilling it. Transaction is created with
  		// a `Payee` and `Amount` types
  		Transaction transaction = new Transaction();
  		transaction
  				.setDescription("This is the payment transaction description.");
  		

  		
  		String subMoney = "";
  		
  		ItemList itemList = new ItemList();
  		if(mlfrontOrderItemList.size()>1){
  			itemList = getItemList(mlfrontOrderItemList);
  			subMoney = getItemListsMoney(mlfrontOrderItemList);
  		}else{
  			MlfrontOrderItem mlfrontOrderItem = mlfrontOrderItemList.get(0);
  			Item item = new Item();
  			String name=mlfrontOrderItem.getOrderitemPname();
//  			if(name.length()>40){
//  				name= name.substring(0, 40);
  				name=name+"...";
//  			}
  			Integer skuNum=mlfrontOrderItem.getOrderitemPskuNumber();
  			String skuNumStr = skuNum+"";
  			String money = mlfrontOrderItem.getOrderitemPskuReamoney();
  			String oneMoney = getOnemoney(skuNum,money);
//  			item.setName(name).setQuantity("1").setCurrency("USD").setPrice(money);
  			item.setName(name).setQuantity(skuNumStr).setCurrency("USD").setPrice(oneMoney);
  			money = getOneAllMoney(skuNum,oneMoney);
  			subMoney = money;
  			List<Item> items = new ArrayList<Item>();
  			items.add(item);
  			itemList.setItems(items);
  		}
  	  	//地址参数
        ShippingAddress shippingAddress = getShippingAddress(mlfrontAddress);
        //itemList.setShippingAddress(shippingAddress); 		
  		
  		Details details = new Details();
  		details.setShipping("0");
  		details.setSubtotal(subMoney);
  		details.setTax("0");//shipping_discount
  		details.setShippingDiscount("-0.00");

  		// ###Amount
  		// Let's you specify a payment amount.
  		Amount amount = new Amount();
  		amount.setCurrency("USD");
  		// Total must be equal to sum of shipping, tax and subtotal.
  		amount.setTotal(subMoney);
  		amount.setDetails(details);
  		transaction.setAmount(amount);
  		transaction.setItemList(itemList);
  		
  		
  		// The Payment creation API requires a list of
  		// Transaction; add the created `Transaction`
  		// to a List
  		List<Transaction> transactions = new ArrayList<Transaction>();
  		transactions.add(transaction);

  		// ###Payer
  		// A resource representing a Payer that funds a payment
  		// Payment Method
  		// as 'paypal'
  		Payer payer = new Payer();
  		payer.setPaymentMethod("paypal");

  		// ###Payment
  		// A Payment Resource; create one using
  		// the above types and intent as 'sale'
  		Payment payment = new Payment();
  		payment.setIntent("sale");
  		payment.setPayer(payer);
  		payment.setTransactions(transactions);
  		
  		RedirectUrls redirectUrls = new RedirectUrls();
  		redirectUrls.setCancelUrl(cancelUrl);
  		redirectUrls.setReturnUrl(successUrl);
  		payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

	private String getOneAllMoney(Integer skuNum, String oneMoney) {
		Double oneMoneyDou = new Double(oneMoney);
		Double OneAllM = oneMoneyDou*skuNum;
		String OneAllMoney = String.format("%.2f", OneAllM);
		return OneAllMoney;
	}

	private String getOnemoney(Integer skuNum, String money) {
		Double moneyAll = new Double(money);
		Double oneM = moneyAll/skuNum;
		String Onemoney = String.format("%.2f", oneM);
		return Onemoney;
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }
	
	
	private ItemList getItemList(List<MlfrontOrderItem> mlfrontOrderItemList) {
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<Item>();
		for(MlfrontOrderItem mlfrontOrderItem:mlfrontOrderItemList){
			Item item = new Item();
			String name=mlfrontOrderItem.getOrderitemPname();
//			if(name.length()>40){
 // 				name= name.substring(0, 40);
  				name=name+"...";
//  			}
			Integer skuNum=mlfrontOrderItem.getOrderitemPskuNumber();
			String skuNumStr = skuNum+"";
			String money = mlfrontOrderItem.getOrderitemPskuReamoney();
			String oneMoney =getOnemoney(skuNum,money);
			item.setName(name).setQuantity(skuNumStr).setCurrency("USD").setPrice(oneMoney);
			money = getOneAllMoney(skuNum,oneMoney);
			
			items.add(item);
        }
		itemList.setItems(items);
		return itemList;
	}
	
	private String getItemListsMoney(List<MlfrontOrderItem> mlfrontOrderItemList) {
		
		Double MoneyDuball=new Double("0.00");
		for(MlfrontOrderItem mlfrontOrderItem:mlfrontOrderItemList){
			String name=mlfrontOrderItem.getOrderitemPname();
			if(name.length()>40){
  				name= name.substring(0, 40);
  				name=name+"...";
  			}
			Integer skuNum=mlfrontOrderItem.getOrderitemPskuNumber();
			String money = mlfrontOrderItem.getOrderitemPskuReamoney();
			String oneMoney =getOnemoney(skuNum,money);
			money = getOneAllMoney(skuNum,oneMoney);
			Double MoneyDub=new Double(money);
			MoneyDuball=MoneyDuball+ MoneyDub;
			
        }
		String OneAllMoney = String.format("%.2f", MoneyDuball);
		return OneAllMoney;
	}
	
	private ShippingAddress getShippingAddress(MlfrontAddress mlfrontAddress) {
		ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setId(mlfrontAddress.getAddressId()+"");
        shippingAddress.setCountryCode(mlfrontAddress.getAddressCountry());
        shippingAddress.setLine1(mlfrontAddress.getAddressProvince());
        shippingAddress.setCity(mlfrontAddress.getAddressCity());
        shippingAddress.setLine2(mlfrontAddress.getAddressDetail());
        shippingAddress.setPostalCode(mlfrontAddress.getAddressPost());
        shippingAddress.setPhone(mlfrontAddress.getAddressTelephone());
        shippingAddress.setRecipientName(mlfrontAddress.getAddressUserfirstname()+" "+mlfrontAddress.getAddressUserlastname());
		return shippingAddress;
	}

}
