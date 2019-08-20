<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>My Order</title>
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

	<jsp:include page="pcheader.jsp"></jsp:include>

	<!-- main -->
	<div class="main order-info">
		<div class="container order_box">
			<div class="tab">
				<div class="tab-item active" data-id="all">All orders</div>
				<div class="tab-item" data-id="0">Unpaid</div>
				<div class="tab-item" data-id="1">Paid</div>
				<div class="tab-item" data-id="2">Payment failed</div>
				<div class="tab-item" data-id="3">Shipped</div>
			</div>
			<div class="tab-content">
				<div class="order-list"></div>
				<div class="page-info-area"></div>
			</div>
		</div>
	</div>

	<jsp:include page="pcfooter.jsp"></jsp:include>
</body>
<script type="text/javascript">
	// 0未支付1已支付2,支付失败3,已发货;

	var mainBox = $(".main .tab-content");
	var containerBox = mainBox.find(".order-list");
	var pageArea = mainBox.find(".page-info-area");
	var orderStatus = {
		0: 'Unpaid',
		1: 'Paid',
		2: 'Payment failed',
		3: 'Shipped',
	}
	//去首页
	to_page(1);

	function to_page(pn, type) {
		$.ajax({
			url: "${APP_PATH}/MlfrontOrder/getmOrderByUidPage",
			data: "pn=" + pn,
			type: "POST",
			success: function (result) {
				// console.log(result);
				var pageInfo = result.extend.pageInfo;
				var orderList = result.extend.pageInfo.list;
				var orderItemList = result.extend.mlfrontOrderItemReturn;
				if (!isNaN(parseInt(type))) {
					orderList = orderList.filter(function (item) {
						return item.orderStatus === parseInt(type);
					});
				}
				// 列表数据
				renderContainer(containerBox, orderList, orderItemList);
				// 解析显示分页条数据
				render_page_nav(pageInfo);
			}
		});
	}
	var activeItem = $('.tab-item.active');
	$('.order-info .tab-item').each(function (i, item) {
		$(item).on('click', function () {
			if ($(item).html() !== activeItem.html()) {
				activeItem.removeClass('active');
				$(this).addClass('active');
				activeItem = $(this);
				to_page(1, String($(this).data('id')));
			}
		})
	})

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
					'<span class="order-status">' + (orderStatus[data[key].orderStatus]) + '</span>' +
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
					'<div class="order-item-footer">Total' + len + 'goods，total $ ' + data[key].orderMoney + '$</div>' +
					'</div>';
			}

			parent.html(html);
			pageArea.removeClass('hide');
		} else {
			// renderErrorMsg(containerBox, '没有任何订单');
			renderErrorMsg(containerBox, 'No orders');
			pageArea.addClass('hide');
		}
	}

	function toDetailPage(e) {
		//window.location.href = '${APP_PATH }/MlfrontOrder/getMlfrontOrderDetailPage?orderId=' + $(e.target).parents(
		window.location.href = '${APP_PATH }/MlfrontOrder/getMlfrontOrderDetailpcPage?orderId=' + $(e.target).parents(
			'.order-item').data('orderid');
	}

	//解析显示分页条，点击分页要能去下一页....
	function render_page_nav(pageInfo) {
		//page_nav_area
		pageArea.empty();
		var ul = $("<ul></ul>").addClass("pagination");

		//构建元素
		var firstPageLi = $("<li></li>").append($("<a></a>").append("first").attr("href", "javascript:;"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (pageInfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//为元素添加点击翻页的事件
			firstPageLi.click(function () {
				to_page(1);
			});
			prePageLi.click(function () {
				to_page(pageInfo.pageNum - 1);
			});
		}

		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("last").attr("href", "javascript:;"));
		if (pageInfo.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function () {
				to_page(pageInfo.pageNum + 1);
			});
			lastPageLi.click(function () {
				to_page(pageInfo.pages);
			});
		}

		//添加首页和前一页 的提示
		ul.append(firstPageLi).append(prePageLi);
		//1,2，3遍历给ul中添加页码提示
		$.each(pageInfo.navigatepageNums, function (index, item) {

			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (pageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			numLi.click(function () {
				to_page(item);
			});
			ul.append(numLi);
		});
		//添加下一页和末页 的提示
		ul.append(nextPageLi).append(lastPageLi).appendTo(pageArea);
	}
</script>

</html>