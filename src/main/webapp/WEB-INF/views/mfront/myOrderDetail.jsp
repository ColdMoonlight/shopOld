<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
  %>
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
		<div class="address bd-t"></div>

		<div class="order-list"></div>

		<div class="order-data">
			<div class="title">订单时间</div>
			<div class="body"></div>
		</div>
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
	var containerBox = $(".order-list");
	$.ajax({
		url: '${APP_PATH }/MlfrontOrder/getOneMlfrontOrderDetail',
		type: "POST",
		data: reqData,
		success: function (data) {
			console.log(data)
			var resDataAddress = data.extend.addressInfo;
			var resDataOrder = data.extend.mlfrontOrderOne;
			var resDataOrderItem = data.extend.mlfrontOrderItemList;
			renderAddressDetail($('.address'), resDataAddress);
			renderContainer(containerBox, [resDataOrder], resDataOrderItem);
			renderOrderinfo($('.order-data .body'), resDataOrder);
		}
	});

	function renderAddressDetail(parent, data) {
		var html = '';
		html += '<div class="address-details address-trigger">' +
			'<i class="icon address"></i>' +
			'<div class="address-info">' +
			'<div class="address-i-item">' +
			'<span class="address-i-name">' + (data.addressUserlastname + ' ' + data.addressUserfirstname) + '</span>' +
			'<span class="address-i-phone">' + data.addressTelephone + '</span>' +
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

	function renderContainer(parent, data, orderItemList) {
		var map = orderMap(orderItemList);
		//console.log(map);
		var html = '';
		if (data.length) {
			for (var key in data) {
				html += '<div class="order-item" data-orderid="' + data[key].orderId + '" onclick="toDetailPage(event)">' +
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
						'<span class="price">$' + (item.orderitemPskuReamoney / item.orderitemPskuNumber) + '</span>' +
						'<span class="num">X' + item.orderitemPskuNumber + '</span>' +
						'</div>' +
						'</div>';
				}
				html += '</div>' +
					'<div class="order-item-footer">' +
					'<div class="order-i-i"><span>订单总价</span><span>$ ' + (parseFloat(data[key].orderMoney) + parseFloat(data[key]
						.orderCouponPrice)) + '<span></div>' +
					'<div class="order-i-i"><span>优惠券</span><span>-$ ' + data[key].orderCouponPrice + '<span></div>' +
					'<div class="order-i-i"><span>实际付款</span><span>$ ' + data[key].orderMoney + '<span></div>' +
					'</div>' +
					'</div>';
			}

			parent.html(html);
		} else {
			renderErrorMsg(containerBox, '没有任何订单');
		}
	}

	function renderOrderinfo(parent, data) {
		var html = '';
		html = '<div><span>支付方式：</span><span>' + data.orderPayPlate + '</span></div>' +
			//'<div><span>付款交易码：</span><span>'+ data.payinfoPlatformserialcode +'</span></div>' +
			'<div><span>创建时间：</span><span>' + data.orderCreatetime + '</span></div>' +
			'<div><span>发货时间：</span><span>' + (data.orderSendtime ? data.orderSendtime : "未发货") + '</span></div>' +
			'<div><span>支付时间：</span><span>' + data.orderPaytime + '</span></div>';
		parent.html(html);
	}
</script>

</html>