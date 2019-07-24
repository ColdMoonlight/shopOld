<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>My Counpon</title>
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
	<div class="main coupon-info"></div>

	<jsp:include page="mfooter.jsp"></jsp:include>
</body>

<script>
	/* 初始化请求这个接口
 ${APP_PATH }/MlbackCoupon/getOneMlbackCouponDetailByUId
 查询该用户名下所有优惠券 post请求，无参数
*/

	$.ajax({
		url: "${APP_PATH }/MlbackCoupon/getOneMlbackCouponDetailByUId",
		type: 'POST',
		success: function (data) {
			//console.log(data);
			var box = $('.coupon-info');
			if (data.code === 100) {
				var userType = data.userType;
				var resData = data.extend.mlbackCouponReturnList;
				// console.table(resData)
				if (resData.length) {
					renderCoupon(box, resData);
				} else {
					renderErrorMsg(box, '没有相关的优惠券！');
					renderErrorMsg(box, 'There are no coupons!');
				}
			} else {
				renderSysMsg('系统错误');
			}
		}
	})

	function renderCoupon(parent, data) {
		var html = ''
		for (var i = 0, len = data.length; i < len; i += 1) {
			html += '<div class="coupon-item" title="需要拷贝优惠码">' +
				'<div class="coupon-text">' +
				'<div class="price">$' + data[i].couponPrice + '</div>' +
				'<div class="name">' + data[i].couponName + '</div>' +
				// '<div class="date">' + (data[i].couponStatus ? '可以使用' : '已失效') + '</div>' +
				'<div class="date">' + (data[i].couponStatus ? 'You can use' : 'Has the failure') + '</div>' +
				'</div>' +
				'<span>' + data[i].couponCode + '</span>' +
				'</div>';
		}

		parent.html(html);
	}
</script>


</html>