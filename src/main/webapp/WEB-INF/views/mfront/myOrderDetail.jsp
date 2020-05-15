<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Order Info</title>
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
</head>

<body>

	<jsp:include page="mheader.jsp"></jsp:include>

	<!-- main -->
	<div class="main order-info">
<!-- 		<div class="state_num">
			<span>状态：1111</span>
		</div> -->
        <!-- <div class="goback"><a href="javascript:history.go(-1)">返回列表</a> </div> -->
		<div class="address bd-t"></div>

		<div class="order-list"></div>
        <div class="open_Logistics_info" onclick="logisticsInfo(event)" style="text-align: center;">
				查看物流信息
	   </div>
		<div class="order-data">
			<div class="title">Order Time</div>
			<div class="body"></div>
		</div>
	</div>
 <div class="listtrack">
 	<span class="close_wllist">X</span>
 	<div class="name_logistics">
 		
 	</div>
 	<ul class="clearfix">
 	</ul>
 </div>
	<jsp:include page="mfooter.jsp"></jsp:include>
</body>
<script type="text/javascript">
	/* 
url: MlfrontOrder/getOneMlfrontOrderDetail
method:  POST请求	
param:　orderId
*/

	var orderId = window.location.href.split('?')[1].split('=')[1];
	var reqData = {
		"orderId": orderId
	};
	var orderStatus = {
		0: 'Unpaid',
		1: 'Paid',
		3: 'Processing',
		4: 'Shipped',
		5:'refund'
	};
	var containerBox = $(".order-list");
	$.ajax({
		url: '${APP_PATH }/MlfrontOrder/getOneMlfrontOrderDetail',
		type: "POST",
		data: reqData,
		success: function (data) {
			console.log(data)
			var resDataAddress = data.extend.addressInfo;
			var resDataOrder = data.extend.mlfrontOrderOne;
			var resDataAfterMoney = data.extend.areafreightMoney;
			var resDataOrderItem = data.extend.mlfrontOrderItemList;
			renderAddressDetail($('.address'), resDataAddress);
			renderContainer(containerBox, [resDataOrder], resDataOrderItem,resDataAfterMoney);
			renderOrderinfo($('.order-data .body'), resDataOrder);
		}
	});

	function renderAddressDetail(parent, data) {
		var html = '';
		html += '<div class="address-details address-trigger">' +
			// '<i class="icon address"></i>' +
			'<div class="address-info">' +
			'<div class="address-i-item">' +
			'<span class="address-i-name">Consignee：' + (data.addressUserlastname + ' ' + data.addressUserfirstname) + '</span>' +
			'<span class="address-i-phone">Phone：' + data.addressTelephone + '</span>' +
			'</div>' +
			'<div class="address-i-item">' +
			'<span class="address-i-address">' + data.addressDetail + ' ' + data.addressCity + ' ' + data.addressProvince +
			' ' + data.addressCountry + '</span>' +
			'</div>' +
			'</div>' +
			'</div>';
		parent.html(html);
	}

	function orderMap(data) {
		var orderMap = {};
		var orderItemMap = {}
		for (var i = 0, len = data.length; i < len; i += 1) {
			if (orderMap[data[i].orderId]) {
				orderMap[data[i].orderId].push(data[i].orderitemId);
			} else {
				orderMap[data[i].orderId] = [data[i].orderitemId]
			}
			orderItemMap[data[i].orderitemId] = data[i];
		}
		return {
			orderMap: orderMap,
			orderItemMap: orderItemMap
		}
	}
	function orderStatus_Top(parent,data){
		//console.log(map);
		var html = '';
		if (data.length) {
			for (var key in data) {
				var numstatus= data[key].orderStatus;
				html += '<span class="order-status status'+numstatus+'">'+ (orderStatus[data[key].orderStatus]) +'</span>'
			}
		}
		parent.html(html);
	}

	function renderContainer(parent, data, orderItemList,resDataAfterMoney) {
		var map = orderMap(orderItemList);
		//console.log(map);
		var html = '';
		if (data.length) {
			for (var key in data) {
				html += '<div class="order-item" data-orderid="' + data[key].orderId + '">' +
					'<div class="order-item-title">' +
					'<span class="order-id">order Id: ' + data[key].orderId + '</span>' +
					//'<span class="order-status">'+ (orderStatus[data[key].orderStatus]) +'</span>' +
					'</div>' +
					'<div class="order-item-body">';
				var len = data[key].orderProNumStr.split(',').length;
				for (var i = 0; i < len; i++) {
					var item = map.orderItemMap[map.orderMap[data[key].orderId][i]];
					html += '<div class="order-item-item">' +
						'<img class="order-img" src="' + item.orderitemProductMainimgurl + '">' +
						'<div class="order-text">' +
						'<div class="title">' + item.orderitemPname + '</div>' +
						'<div class="sku">' + (item.orderitemPskuNamestr.split(',').join(' ')) + '</div>' +
						'</div>' +
						'<div class="order-num">' +
						'<span class="price">$' + (item.orderitemPskuReamoney / item.orderitemPskuNumber).toFixed(2) + '</span>' +
						'<span class="num">X' + item.orderitemPskuNumber + '</span>' +
						'</div>' +
						'</div>';
				}
				html += '</div>' +
					'<div class="order-item-footer">' +
					'<div class="order-i-i"><span>Total Amount</span><span>$ ' + (parseFloat(data[key].orderMoney) + parseFloat(data[key].orderCouponPrice)-(parseFloat(resDataAfterMoney))) + '<span></div>' +
					'<div class="order-i-i"><span>Coupon</span><span>-$ ' + data[key].orderCouponPrice + '<span></div>' +
					'<div class="order-i-i"><span>shop</span><span>' + resDataAfterMoney + '<span></div>' +
					'<div class="order-i-i"><span>Actual payment</span><span>$ ' + data[key].orderMoney + '<span></div>' +
					'</div>' +
					'</div>';
			}

			parent.html(html);
		} else {
			renderErrorMsg(containerBox, 'No orders.');
		}
	}

	function renderOrderinfo(parent, data) {
		var html = '';
		html = '<div><span>Payment_Method：</span><span>' + data.orderPayPlate + '</span></div>' +
			'<div><span>Creation_Time：</span><span>' + data.orderCreatetime + '</span></div>' +
			'<div><span>Shipping Time：</span><span>' + (data.orderSendtime ? data.orderSendtime : "Unfilled") + '</span></div>' +
			'<div><span>Payment time：</span><span>' + data.orderPaytime + '</span></div>';
		parent.html(html);
	}
	
	
	function logisticsInfo(event){
		 event.stopPropagation();//阻止事件冒泡即可
		var trackingNumber="392338333836";
		var Slug="FedEx";
		var reqData = {
		  "trackingNumber":trackingNumber,
		  "Slug":Slug,
		}
		$.ajax({
			url: '${APP_PATH }/MlfrontOrder/getCheckpointByTrackingNumber',
			type: "GET",
			data: reqData,
			success: function (data) {
				console.log(data)
				$(".listtrack").show();
				var resDataOrderItemList = data.extend.TrackingRes.checkpoints;
				renderOrderInfo(listTrack,resDataOrderItemList);
				var wlname = data.extend.TrackingRes.slug;
				var wlnum = data.extend.TrackingRes.trackingNumber;
				var wlphone = data.extend.TrackingRes.smses;
	            	baseTrack(baseinfo,wlname,wlnum,wlphone)			
			}
		});
	}
	var baseinfo =$(".name_logistics");
	function baseTrack (parent,wlname,wlnum,wlphone){
		var html = '';
		html += '<dl>'+
			'<dd>'+wlname+'</dd>'+
			'<dd>'+wlnum+'</dd>'+
			'<dd>'+wlphone+'</dd>'+
			'</dl>'
		parent.html(html);	
	}
	
	
	$(".close_wllist").click(function(){
		$(".listtrack").hide();
	})
	var listTrack=$(".listtrack ul");
	function renderOrderInfo(parent,data){
		var html = '';
		for (var i = 0; i < data.length; i += 1) {
			var timeall= data[i].checkpointTime.split(/[T+-]/);
			html += '<li>' +
			'<span><b><i>'+timeall[1]+'</i>-<i>'+timeall[2]+'</i>-<i>'+timeall[0]+'</i></b><em>'+timeall[3]+'</em></span>'+
			'<div class="rightcont">'+
			   '<p><b>'+ data[i].message  +' </b></p>'+
			    '<p>'+ data[i].city  +' </p>'+
			'</div>'+
	      '</li>';
		}
		
	parent.html(html);	
	}
	
	
	
</script>

</html>