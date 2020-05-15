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

	<jsp:include page="mheader.jsp"></jsp:include>

	<!-- main -->
	<div class="main order-info">
		<div class="tab">
			<div class="tab-item active" data-id="999">All orders</div>
			<div class="tab-item" data-id="0">Unpaid</div>
			<div class="tab-item" data-id="1">Paid</div>
			<div class="tab-item" data-id="3">Processing</div>
			<div class="tab-item" data-id="4">Shipped</div>
			<div class="tab-item" data-id="5">Refund</div>
		</div>
		<div class="tab-content">
			<div class="order-list"></div>
			<div class="page-info-area"></div>
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
	// 0未支付1已支付2,已审核3,已发货;

	var mainBox = $(".main .tab-content");
	var containerBox = mainBox.find(".order-list");
	var pageArea = mainBox.find(".page-info-area");
	var orderStatus = {
		0: 'Unpaid',
		1: 'Paid',
		3: 'Processing',
		4: 'Shipped',
		5:'refund'
	}
	//去首页
	to_page(1,999);
    // console.log(pn)
	// console.log(type)
	var orderStatusid=999;
	var activeItem = $('.tab-item.active');
	$('.order-info .tab-item').each(function (i, item) {
		$(item).on('click', function () {
			if ($(item).html() !== activeItem.html()) {
				activeItem.removeClass('active');
				$(this).addClass('active');
				activeItem = $(this);
				to_page(1, String($(this).data('id')));
				var myid =String($(this).data('id'));
				orderStatusid=myid;
			}
		})
	})
	
	function to_page(pn, orderStatus) {
		console.log("pn："+pn);
		console.log("type："+orderStatus);
		$.ajax({
			url: "${APP_PATH}/MlfrontOrderList/selectOrderlistBySearch",
			// data: "pn=" + pn,
			data:{
				"pn": pn,
				"orderStatus":orderStatus,
			},
			type: "POST",
			success: function (result) {
				// console.log(result);
				var pageInfo = result.extend.pageInfo;
				var orderList = result.extend.pageInfo.list;
				// console.log(orderList)
				var orderItemList = result.extend.mlfrontOrderItemReturnList;
				renderContainer(containerBox, orderList, orderItemList);
				render_page_nav(pageInfo);
			}
		});
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
				var orderStatusword=orderStatus[data[key].orderStatus];
				var showspan = "";
				if(orderStatusword=="Shipped"){
					showspan = "show"
				}
				html += '<div class="order-item" data-orderid="' + data[key].orderId + '" onclick="toDetailPage(event)">' +
					'<div class="order-item-title">' +
					'<span class="order-id">order Id: ' + data[key].orderId + '</span>' +
					'<span class="order-status">' + orderStatusword+ '</span>' +
					'</div>' +
					'<div class="order-item-body">';
				var len = data[key].orderOrderitemidstr.split(',').length;
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
					'<div class="order-item-footer">Total' + len + 'goods，total $ ' + data[key].orderMoney + '$</div>' +
					'<div class="view_status '+showspan+'"><span onclick="logisticsInfo(event)">View Logistics</span></div>'+
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
		window.location.href = '${APP_PATH }/MlfrontOrder/getMlfrontOrderDetailPage?orderId=' + $(e.target).parents(
			'.order-item').data('orderid');
	}
	//解析显示分页条，点击分页要能去下一页....
	function render_page_nav(pageInfo) {
		//page_nav_area
		pageArea.empty();
		var ul = $("<ul></ul>").addClass("pagination");
        // console.log(pageInfo.pages);
		//构建元素
		var firstPageLi = $("<li></li>").append($("<a></a>").append("first").attr("href", "javascript:;"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (pageInfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//为元素添加点击翻页的事件
			firstPageLi.click(function () {
				to_page(1,orderStatusid);
				console.log("orderStatusid："+orderStatusid)
			});
			prePageLi.click(function () {
				to_page(pageInfo.pageNum - 1,orderStatusid);
			console.log("orderStatusid："+orderStatusid)
			});
		}
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("last").attr("href", "javascript:;"));
		if (pageInfo.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function () {
				to_page(pageInfo.pageNum + 1,orderStatusid);
				console.log("orderStatusid："+orderStatusid)
			});
			lastPageLi.click(function () {
				to_page(pageInfo.pages,orderStatusid);
			console.log("orderStatusid："+orderStatusid)
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
				to_page(item,orderStatusid);
				console.log("orderStatusid"+orderStatusid)
			});
			ul.append(numLi);
		});
		//添加下一页和末页 的提示
		ul.append(nextPageLi).append(lastPageLi).appendTo(pageArea);
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