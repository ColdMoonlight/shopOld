<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="UTF-8">
  <title>Pay Success</title>
  <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
  <meta name="viewport"
    content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, viewport-fit=cover">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <!--  禁用telphone -->
  <meta name="format-detection" content="telephone=no">
  <!-- 关闭下拉刷新 -->
  <meta id="WV.Meta.DisableRefresh" value="true">
  <!-- 禁用ios的bounces效果 -->
  <meta id="WV.Meta.Share.Disabled" value="true">
  <!-- uc 字体放大-->
  <meta name="wap-font-scale" content="no">
  <meta name="aplus-touch" content="1">
  <link rel="stylesheet" href="${APP_PATH }/static/common/swiper/swiper.min.css">
  <script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
  <!-- Facebook Pixel Code 这是facebook广告插件可以注释掉，但不要删除-->
	<script>
	  !function(f,b,e,v,n,t,s)
	  {if(f.fbq)return;n=f.fbq=function(){n.callMethod?
	  n.callMethod.apply(n,arguments):n.queue.push(arguments)};
	  if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
	  n.queue=[];t=b.createElement(e);t.async=!0;
	  t.src=v;s=b.getElementsByTagName(e)[0];
	  s.parentNode.insertBefore(t,s)}(window, document,'script',
	  'https://connect.facebook.net/en_US/fbevents.js');
	  fbq('init', '246433859565492');
	  //fbq('init', '667403967094866');
	  fbq('track', 'PageView');
	</script>
	<noscript><img height="1" width="1" style="display:none"src="https://www.facebook.com/tr?id=667403967094866&ev=PageView&noscript=1"/></noscript>
	<!-- End Facebook Pixel Code -->
	
	<script>
  		fbq('track', 'ViewContent');
	</script>
	<!-- Facebook Pixel Code end -->
</head>

<body>

  <jsp:include page="pcheader.jsp"></jsp:include>
  <!-- main -->
  <div class="main">
    <div class="container pay_box">
  	<input type="hidden" class="order-id" name="orderId">

    <!-- purechase step -->
	<div class="cart-title">
		 <img class="purechase-step" src="${APP_PATH }/static/pc/img/sep4.jpg">
	</div>
   
   <div class="box-none_success">
       	<div class="left_location">
            <div class="right_head clearfix">
            	<img src="${APP_PATH}/static/m/img/other/pay-success.png" alt="">
            	  <div class="revceiver-info"> </div>
            	  <div class="info_order"> </div>
            </div>
			<div class="box-none_cont clearfix">
				<div class="info_one"></div>
				<div class="info_two"></div>
			</div>
			<p class="small_tips">If there's any questions, plz contact the customer service </p>
			<a href="${APP_PATH}/index.html" class="btnContinue">Continue Shopping</a>
       	</div>  
   		<div class="right_ship">
   			<div class="order-info clearfix">
   				<div class="product_shop clearfix">
   				</div>
   				<div class="cal-info clearfix">
   				</div>
   			</div>
   		</div>
   </div>

	
  </div>
</div>
  <jsp:include page="pcfooter.jsp"></jsp:include>
  <script type="text/javascript">
	   var sessionaddressMoney = '${sessionScope.addressMoney}';
	  var reqmUpdatePayInfoData = {
	  		  "pageStr": "pageStr"
	  		};
	  $.ajax({
			url: '${APP_PATH }/paypal/topUpdatePayInfoSuccess',
			data: reqmUpdatePayInfoData,
			type: "POST",
			success: function (data) {
			  getsuccessinfo()
			}
	  });
	   function getsuccessinfo(){
		   $.ajax({
		   	url: '${APP_PATH }/MlfrontPayInfo/getsuccessPayinfo',
		   	type: "POST",
		   	success: function (data) {
		   		// console.log(data)
		   		var mlfrontOrderOne = data.extend.mlfrontOrderOne;
		   		var payinfoId = data.extend.payinfoId;
		   		var orderMoney = mlfrontOrderOne.orderMoney;
		   		// console.log(mlfrontOrderOne);
		   		//console.log("orderMoney:"+orderMoney);
		   		getPayInfo(payinfoId,orderMoney);
		   		$(".order-id").val(mlfrontOrderOne.orderId);
		   		
		   	}
		   });
	   }
	  
	function getPayInfo(payinfoId,orderMoney){
		var reqData = {
				"payinfoId": payinfoId
			};
		//console.log("orderMoney:"+orderMoney);
		$.ajax({
			url: "${APP_PATH}/MlfrontPayInfo/getOneMlfrontPayInfoDetail",
			data: reqData,
			type: "POST",
			success: function (result) {
				if (result.code == 100) {
					var resData = result.extend;
					// console.log(resData)
					var resDataPayInfoOne = result.extend.mlfrontPayInfoOne;
					var resDataOrderItemList = result.extend.mlfrontOrderItemList;
					var resDataOrderPayOne = result.extend.mlfrontOrderPayOneRes;
					var resDataAddressOne = result.extend.mlfrontAddressOne;
					var mlPaypalShipAddressOne = result.extend.mlPaypalShipAddressOne;
					// console.log(mlPaypalShipAddressOne)
					var orderData = resDataOrderPayOne;
					orderData.list = resDataOrderItemList;
					orderData.payinfoMoney = resDataPayInfoOne.payinfoMoney;
					orderData.payinfoPlateNum = resDataPayInfoOne.payinfoPlateNum;
					
					renderOrderInfo(orderData);
					
					var receiveData = resDataAddressOne;
					var receiveDataaddress = mlPaypalShipAddressOne;
					renderReceiverinfo(receiveData);
					renderPaypaladdress(receiveDataaddress);
					
					
					
					
					// console.log(mlfrontOrderItemList);
					//拼接所需参数:content_ids
					stridsContent=toFbidsPurchase(resDataOrderItemList);
					//console.log("stridsContent:"+stridsContent);
					//拼接所需参数:contents
					strContent=toFbPurchase(resDataOrderItemList);
					//console.log("strContent:"+strContent);
					//fbq('track', 'Purchase');//追踪'购买'事件		facebook广告插件可以注释掉，但不要删除
					fbq('track', 'Purchase', {
						  content_ids: [stridsContent],
						  //contents: [strContent],
						  content_type: 'product',
						  value: orderMoney,
						  currency: 'USD'
						});
					
					/*准备google数据*/
					var transaction_id = resDataPayInfoOne.payinfoPlateNum;
					//console.log("transaction_id:"+transaction_id);
					var transaction_value = resDataPayInfoOne.payinfoMoney;
					//console.log("transaction_value:"+transaction_value);
					strGGContent=toGooGlePurchase(resDataOrderItemList);
					//console.log(strGGContent);
					 gtag('event', 'purchase', {
						  "transaction_id": transaction_id,
						  "affiliation": "MegaLookHair",
						  "value": transaction_value,
						  "currency": "USD",
						  "tax": 0,
						  "shipping": 0,
						  "items": strGGContent
						});
				} else {
					//alert("联系管理员");
				}
			}
		});
	}
	
	/*****************/
	function renderOrderInfo(data) {//红
	var htmlorder = '<div class="orderid">Your Order ID : '+data.payinfoPlateNum+'</div>';
	$('.info_order').html(htmlorder);
		var tbodyHtml = ''
		for (var i = 0, len = data.list.length; i < len; i += 1) {
			var imgurl = data.list[i].orderitemProductMainimgurl;
			var image = '<img src=' + imgurl + '>';
			tbodyHtml += '<div class="shop_contimg clearfix">'+ 
				'<div class="lefttp">' + image + '</div>' +
				 '<div class="cp_img">'+ 
				'<div class="rightw">' + data.list[i].orderitemPname + '</div>'+
				'<div class="listnum numhong"><span>× ' + data.list[i].orderitemPskuNumber + '</span></div>'+
				'<div class="listnum numhong"><span> '+ (getPrice(data.list[i].orderitemProductOriginalprice, data.list[i].orderitemPskuMoneystr.split(','),data.list[i].orderitemProductAccoff).current) + '</span></div>'+
				'</div>';
			tbodyHtml += '<div class="item_cont clearfix">';
			var skuNameArr = data.list[i].orderitemPskuNamestr.split(',');
			var skuItemNameArr = data.list[i].orderitemPskuIdnamestr.split(',');
			for (var j = 0, len2 = skuItemNameArr.length; j < len2; j += 1) {
				tbodyHtml += '<div class="td-item"><span>' + skuNameArr[j] +'</span>,</div>';
			}
			tbodyHtml += '</div>';
			tbodyHtml += '</div>';
		}
		$('.order-info .product_shop').html(tbodyHtml);
		var calInfoHtml = '';
		calInfoHtml = '<div class="listnum"><span>prototal：</span><span>$' + (parseFloat(data.payinfoMoney) + parseFloat(data.orderCouponPrice)-parseFloat(sessionaddressMoney) ) + '</span></div>' +
			'<div class="listnum"><span>shipping：</span><span>' + sessionaddressMoney + '</span></div>' +
			'<div class="listnum"><span>coupon：</span><span>-$' + data.orderCouponPrice + '</span></div>' +
			'<div class="listnum subtotalcont"><span>subtotal：</span><span>$' + data.payinfoMoney + '</span></div>';
		$('.order-info .cal-info').html(calInfoHtml);
		var paymoney ='<span>$' + data.payinfoMoney + '</span>'
		$('.leftww b').html(paymoney);
		
	}
	/**************/
		function renderReceiverinfo(data) {
			var htmlname = '<div classs="info_name">Thank You <b>'+ data.addressUserfirstname +' </b></div>';
			// var htmlorder '<div class="orderid">Your Order ID : '+data.payinfoPlateNum+'</div>';
			$('.revceiver-info').html(htmlname);
			// $('.info_order').html(htmlname);
			var htmlinfo='';
		    	htmlinfo= '<div class="masage_cont">Shipping Address</div>'+
				            '<ul>'+
							 '<li>Phone : '+data.addressTelephone+'</li>'+
							 '<li>' + data.addressCountry+ ' ' + data.addressProvince + ' ' + data.addressCity + ' ' + data.addressDetail + '</li>'+
						'</ul>';
			$(".info_one").html(htmlinfo);		
			
		}
		function renderPaypaladdress(data){
			var html="";
			html= '<div class="masage_cont">Billing Address</div>'+
				        '<ul>'+
							'<li>' + data.shippingaddressCountryCode + ' ' + data.shippingaddressCity + ' ' + data.shippingaddressLine1 + '</li>'+
						   '<li>Postcodes : '+data.shippingaddressPostalCode+'</li>'+
						'</ul>';
			$(".info_two").html(html);		
		}
	/* single */
	function getPrice(originalePrice, skuPriceArr, discount) {
		var singlePrice = parseFloat(originalePrice);
		for (var k = 0, len = skuPriceArr.length; k < len; k += 1) {
			singlePrice += (parseFloat(skuPriceArr[k]) ? parseFloat(skuPriceArr[k]) : 0);
		}
		return {
			origin: parseFloat(singlePrice).toFixed(2),
			current: parseFloat(singlePrice * ((parseFloat(discount) ? parseFloat(discount) : 100) / 100)).toFixed(2)
		}
	}
	
	function toFbidsPurchase(resDataOrderItemList){
		var infoStrlids = '';
		var infoRelids = '';
		for(var i=0;i<resDataOrderItemList.length;i++){
			infoStrlids=infoStrlids+resDataOrderItemList[i].orderitemPid+',';
		}
		infoRelids=infoStrlids.substr(0,infoStrlids.length-1);
		// console.log("infoRelids:"+infoRelids);
		return infoRelids;
	}
	
	function toFbPurchase(resDataOrderItemList){
		var infoRel = '';
		var infoStr = '';
		for(var i=0;i<resDataOrderItemList.length;i++){
			var infoStrOne = '';
			var pid = resDataOrderItemList[i].orderitemPid;
			var pnum = resDataOrderItemList[i].orderitemPskuNumber;
			var price = resDataOrderItemList[i].orderitemPskuReamoney;
			infoStrOne = infoStrOne+'{'+'id:'+pid+','+'quantity:'+pnum+','+'item_price:'+price+'}';
			infoStr=infoStr+infoStrOne+',';
		}
		infoRel=infoStr.substr(0,infoStr.length-1);
		// console.log("infoRel:"+infoRel);
		return infoRel;
	}
	
	function toGooGlePurchase(resDataOrderItemList){
		var infoRel = '';
		var infoStr = '[';
		for(var i=0;i<resDataOrderItemList.length;i++){
			var infoStrOne = '';
			var pid = resDataOrderItemList[i].orderitemPid;
			var pname = resDataOrderItemList[i].orderitemPname;
			var pnum = resDataOrderItemList[i].orderitemPskuNumber;
			var allprice = resDataOrderItemList[i].orderitemPskuReamoney;
			var price = ((allprice/pnum).toFixed(2));
			infoStrOne = infoStrOne+'{' + '"id":' + pid +', "name": "'+ pname + '" ,' + '"list_name": "Search Results", "brand": "MLH", "quantity": ' + pnum + ', "price": "'+ price +'"}';
			infoStr=infoStr+infoStrOne+',';
		}
		infoRel=infoStr.substr(0, infoStr.length-1);
		infoRel=infoRel+']';
		//console.log("infoRel:*********");
		//console.log(JSON.parse(infoRel));
		return JSON.parse(infoRel);
	}
</script>
<!-- megalook-->
    <script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script>
  <!-- megalookhair 
    <script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
    <!-- huashuohair -->
    <!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>