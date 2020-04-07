<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Megalook</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/main.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/table.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/js/datepicker/datepicker.css">
</head>

<body>
	<div class="container">
		<div class="aside-bar nicescroll">
			<jsp:include page="leftnav.jsp"></jsp:include>
		</div>
		<div class="main-body">
			<div class="main-box nicescroll">
				<div class="header">
					<h2>控制台</h2>
					<span class="user" id="UEmailSession">*</span>
				</div>
				<div class="content">
					<div class="model">
						<div class="model-h">
							<span class="model-name">今日完成指标数</span>
							<span><i class="glyphicon glyphicon-info-sign"></i></span>
						</div>
						<div class="model-b model-list"></div>
					</div>
					<!-- pie -->
					<div class="model" data-type="pie">
						<div class="model-h">
							<span class="model-name">各项指标</span>
							<div class="c-datepicker-date-editor date-timepicker data_num">
								<i class="c-datepicker-range__icon kxiconfont icon-clock"></i>
								<input placeholder="开始日期" name="" value="" class="c-datepicker-data-input">
								<span class="c-datepicker-range-separator">-</span>
								<input placeholder="结束日期" name="" value="" class="c-datepicker-data-input">
							</div>
						</div>
						<div class="model-b model-pie num_data">
							<div class="model-pie-data model-pie-list num_box_list">
								<a href="${APP_PATH }/MlbackProductViewDetail/toMlbackProductViewDetailPage" title="浏览量"
									class="model-item liulan">
									<div class="model-text">浏览量</div>
									<div class="model-num">0</div>
								</a>
								<span class="model-item addcart_box">
									<a href="${APP_PATH }/MlbackAddCartViewDetail/toMlbackAddCartViewDetailPage"
										title="加购量" class="cart_num addcart">
										<div class="model-text">加购量</div>
										<div class="model-num">0</div>
									</a>
									<a href="${APP_PATH }/MlbackAddCartViewDetail/toMlbackAddCartViewbuynowDetailPage"
										title="buynow加购量" class="cart_num addcart2">
										<div class="model-text">buynow加购量</div>
										<div class="model-num">0</div>
									</a>
								</span>
								<span class="model-item addcart_box">
									<a href="${APP_PATH }/MlbackAddCheakoutViewDetail/toMlbackAddCheakoutViewDetailPage"
										title="购物车结算" class="cart_num addcart_num">
										<div class="model-text">购物车结算</div>
										<div class="model-num">0</div>
									</a>
									<a href="${APP_PATH }/MlbackAddCheakoutViewDetail/toMlbackAddCheakoutBuyNowViewDetailPage"
										title="buynow结算" class="cart_num buy_nownum">
										<div class="model-text">buynow结算</div>
										<div class="model-num">0</div>
									</a>
								</span>
								<a href="${APP_PATH }/MlbackAddOrderViewDetail/toMlbackAddOrderViewDetailPage"
									title="order出品量" class="model-item addorder_num">
									<div class="model-text">出单产品量</div>
									<div class="model-num">0</div>
								</a>
							</div>
						</div>
						<hr style="border-color: #ccc;" />
						<div class="model-b model-pie num_data">
							<div class="model-pie-data model-pie-list num_box_list">
								<a href="${APP_PATH }/MlbackAddPayinfoViewDetail/toMlbackAddPayinfoViewDetailPage"
									title="成交金额" class="model-item PayinfoSuccessNum">
									<div class="model-text">成交num</div>
									<div class="model-num">0</div>
								</a>
								
								<a href="javascript:;" title="结算量" class="model-item accounts">
									<div class="model-text">结算量</div>
									<div class="model-num">0</div>
								</a>
							</div>
						</div>
					</div>
					<!-- pie -->
					<div class="model today-details" data-type="pay" style="display: none;">
						<div class="model-h">
							<span class="model-name">今日订单明细</span>
							<div></div>
						</div>
						<div class="model-b model-table">
							<div class="table-content">
								<table class="table table-striped table-hover task_table">
									<thead>
										<tr>
											<th>结算单id</th>
											<th>订单id</th>
											<th>支付状态</th>
											<th>金额</th>
											<th>支付渠道</th>
											<th>下单时间</th>
											<th>更新时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody> </tbody>
								</table>
							</div>
							<!-- 显示分页信息 -->
							<div class="row">
								<!--分页文字信息  -->
								<div class="col-md-6 page_info_area"></div>
								<!-- 分页条信息 -->
								<div class="col-md-6 page_nav_area"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${APP_PATH }/static/back/js/jquery-nicescroll.min.js"></script>
	<script src="${APP_PATH }/static/back/js/sidenav.js"></script>
	<!-- <script src="${APP_PATH }/static/back/js/nav.js"></script> -->

	<script src="${APP_PATH }/static/back/js/datepicker/moment.min.js"></script>
	<script src="${APP_PATH }/static/back/js/datepicker/datepicker.js"></script>

	<script src="https://www.chartjs.org/dist/2.8.0/Chart.min.js"></script>

	<script type="text/javascript">
		var adminAccname = '${sessionScope.AdminUser.adminAccname}';
		// console.log("adminAccname:" + adminAccname);
		$("#UEmailSession").html(adminAccname);
	</script>
	<script type="text/javascript">
		$('.nicescroll').each(function (i, item) {
			$(item).niceScroll({
				cursorcolor: "rgba(0,0,0,.3)",
				cursorwidth: "14px",
				cursorborder: "none",
				horizrailenabled: false,
				enablekeyboard: false,
			}).resize()
		});
		var targetInput = $('.date-timepicker');
		var date = new Date();
		var minDate = moment()
			.set({
				'date': date.getDate() - 1,
				'hour': date.getHours(),
				'minute': date.getMinutes(),
				'second': date.getSeconds()
			})
			.format('YYYY-MM-DD HH:mm:ss');
		var minDate2 = moment()
			.set({
				'date': date.getDate() - 1,
				'hour': 23,
				'minute': 59,
				'second': 59
			})
			.format('YYYY-MM-DD HH:mm:ss');
		var minDate22 = moment()
			.set({
				'date': date.getDate(),
				'hour': 0,
				'minute': 0,
				'second': 0
			})
			.format('YYYY-MM-DD HH:mm:ss');
		var maxDate = moment()
			.set({
				'date': date.getDate(),
				'hour': date.getHours(),
				'minute': date.getMinutes(),
				'second': date.getSeconds()
			})
			.format('YYYY-MM-DD HH:mm:ss');
		/*****初始化时间*****************/
		var storage = window.localStorage;
		var startime = storage.getItem('startTime') || minDate22;
		var endtime = storage.getItem('endTime') || maxDate;

		function initHtml() {
			var $input = targetInput.find('input');
			$input.eq(0).val(startime);
			$input.eq(1).val(endtime);
		}

		function initData() {
			/*****初始调取浏览量*****************/
			$.ajax({
				url: '${APP_PATH}/MlbackProductViewDetail/getProductViewDetailNum',
				data: JSON.stringify({
					"proviewdetailStarttime": startime,
					"proviewdetailEndtime": endtime,
				}),
				type: 'post',
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend.mlbackActShowProList;
					$(".liulan .model-num").html(resData.length)
				}
			});
			/*****初始调取仅加购量****************/
			$.ajax({
				url: '${APP_PATH}/MlbackAddCartViewDetail/getAddCartViewDetailNum',
				data: JSON.stringify({
					"addcartviewdetailStarttime": startime,
					"addcartviewdetailEndtime": endtime,
				}),
				type: 'post',
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend.toDayNum;

					$(".addcart .model-num").html(resData);

				},

			});
			/*****初始调取加购量****************/
			$.ajax({
				url: '${APP_PATH}/MlbackAddCartViewDetail/getAddCartViewDetailBuyNowNum',
				data: JSON.stringify({
					"addcartviewdetailStarttime": startime,
					"addcartviewdetailEndtime": endtime,
				}),
				type: 'post',
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend.toDayNum;
					$(".addcart2 .model-num").html(resData);
				},

			});
			/****************buynow量**************************************************/
			$.ajax({
				url: '${APP_PATH}/MlbackAddCheakoutViewDetail/getAddCheakoutViewDetailBuyNowNum',
				data: JSON.stringify({
					"addcheakoutviewdetailStarttime": startime,
					"addcheakoutviewdetailEndtime": endtime,
				}),
				type: 'post',
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend.toDayNum;
					$(".buy_nownum .model-num").html(resData);
				},

			});
			/****************购物车结算**************************************************/
			$.ajax({
				url: '${APP_PATH}/MlbackAddCheakoutViewDetail/getAddCheakoutViewDetailNum',
				data: JSON.stringify({
					"addcheakoutviewdetailStarttime": startime,
					"addcheakoutviewdetailEndtime": endtime,
				}),
				type: 'post',
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend.toDayNum;
					$(".addcart_num .model-num").html(resData);
				},

			});
			/****************实际OrderItem出单详情**************************************************/
			$.ajax({
				url: '${APP_PATH}/MlbackAddOrderViewDetail/getAddOrderViewDetailNum',
				data: JSON.stringify({
					"addorderviewdetailStarttime": startime,
					"addorderviewdetailEndtime": endtime,
				}),
				type: 'post',
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend.toDayNum;
					$(".addorder_num .model-num").html(resData);
				},

			});
			/****************************************************第二行**************************************************/
			/****************实际OrderItem出单详情**************************************************/
			$.ajax({
				url: '${APP_PATH}/MlbackAddPayinfoViewDetail/getAddPayinfoViewDetailSuccessNum',
				data: JSON.stringify({
					"addpayinfoviewdetailStarttime": startime,
					"addpayinfoviewdetailEndtime": endtime,
				}),
				type: 'post',
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend.toDayNum;
					$(".PayinfoSuccessNum .model-num").html(resData);
				},

			});
		}

		/***********************************************/
		function initJs() {
			targetInput.each(function (i, item) {
				$(item).datePicker({
					hasShortcut: true,
					min: '2018-01-01 06:00:00',
					max: maxDate,
					isRange: true,
					shortcutOptions: [{
						name: '昨天',
						day: '-1,-1',
						time: '00:00:00,23:59:59'
					}, {
						name: '最近一周',
						day: '-7,0',
						time: '00:00:00,'
					}, {
						name: '最近一个月',
						day: '-30,0',
						time: '00:00:00,'
					}, {
						name: '最近三个月',
						day: '-90, 0',
						time: '00:00:00,'
					}],
					hide: function (type) {
						startime = this.$input.eq(0).val();
						endtime = this.$input.eq(1).val();
						storageTime();
						initData();
					}
				})
			})
		}
		
		function storageTime() {
			storage.setItem('startTime', startime);
			storage.setItem('endTime', endtime);
		}

		$(function () {
			initData();
			initHtml();
			initJs();
		});
	</script>
	<!-- 
参数都是这三个  JSON格式	POST 请求，，

	private Integer pn;	页数，默认1,
	
    private String beginTime;2019-06-11 17:47:52

    private String endTime;

4个接口
MlfrontUser/getMlfrontUserByDate	

MlbackCart/getMlfrontCartByDate

MlfrontOrder/getMlfrontOrderByDate

MlfrontPayInfo/getMlfrontPayInfoByDate
 -->

	<script>
		var reqData = {
			pn: null,
			beginTime: minDate,
			endTime: maxDate
		};
		/* default */
		var modelList = $('.model-b.model-list');
		var userData = getUser(reqData);
		var orderData = getOrder(reqData);
		var cartData = getCart(reqData);
		var payData = getPay(reqData);
		renderMdoleItem(modelList, {
			href: '${APP_PATH }/MlfrontPayInfo/toMlbackPayInfoList',
			text: '支付订单', //每个上面绑个id事件，点击跳转接口（界面）,要不事件绑在字上，要不绑在数字上
			num: payData.countNumber,
			title: "查看历史支付订单"
		});
		renderMdoleItem(modelList, {
			href: '${APP_PATH }/MlfrontOrder/toMlbackOrderPage',
			text: '订单总数',
			num: orderData.countNumber,
			title: "查看历史订单"
		});
		renderMdoleItem(modelList, {
			href: '${APP_PATH }/MlbackCart/toMlbackCartPage',
			text: '加购物车产品',
			num: cartData.countNumber,
			title: "查看历史购物产品"
		});
		renderMdoleItem(modelList, {
			href: '${APP_PATH }/MlfrontUser/toMlbackUserPage',
			text: '用户注册',
			num: userData.countNumber,
			title: "查看历史注册用户"
		});

		/* order of today */

		var payBox = $('.model.today-details');
		to_page(payBox, 1);

		function to_page(parent, pageNum) {
			reqData.beginTime = minDate2;
			reqData.pn = pageNum;
			var result = {};
			if (parent.data('type') === 'pay') {
				result = getPay(reqData);
				// console.log(result)
				if (result.countNumber) {
					build_pay_table(parent, result);
				} else {
					// alert('未查询到任何数据')
				}
			}
			build_page_info(parent, result);
			build_page_nav(parent, result);
		}


		/* pie */
		var modelPieList = $('.model-pie-list');

		var config = {
			type: 'pie',
			data: {
				datasets: [{
					data: [],
					backgroundColor: [],
					label: 'Dataset'
				}],
				labels: []
			},
			options: {
				responsive: true,
				legend: {
					position: 'left',
					labels: {
						boxWidth: 20,
						fontColor: '#333'
					}
				}
			}
		};

		// var ctx = document.querySelector('.model-pie-chart canvas').getContext('2d');
		// window.myPie = new Chart(ctx, config);
		// window.myPie.update()


		function getUser(reqData) {
			var resData = {};
			$.ajax({
				type: 'post',
				url: '${APP_PATH }/MlfrontUser/getMlfrontUserByDate',
				data: JSON.stringify(reqData),
				dataType: 'json',
				async: false,
				contentType: 'application/json',
				success: function (data) {
					resData = data.extend;
					// console.log(resData)
				}
			})
			return resData;
		}

		function getCart(reqData) {
			var resData = {};
			$.ajax({
				type: 'post',
				url: '${APP_PATH }/MlbackCart/getMlfrontCartByDate',
				data: JSON.stringify(reqData),
				dataType: 'json',
				async: false,
				contentType: 'application/json',
				success: function (data) {
					resData = data.extend;
					// console.log(resData)
				}
			})
			return resData;
		}

		function getOrder(reqData) {
			var resData = {};
			$.ajax({
				type: 'post',
				url: '${APP_PATH }/MlfrontOrder/getMlfrontOrderByDate',
				data: JSON.stringify(reqData),
				dataType: 'json',
				async: false,
				contentType: 'application/json',
				success: function (data) {
					resData = data.extend;
					// console.log(resData)
				}
			})
			return resData;
		}

		function getPay(reqData) {
			var resData = {};
			$.ajax({
				type: 'post',
				url: '${APP_PATH }/MlfrontPayInfo/getMlfrontPayInfoByDate', //首页的list，放这个表的信息。不放order（不一定付款），这个里全是付款的（）
				data: JSON.stringify(reqData),
				dataType: 'json',
				async: false,
				contentType: 'application/json',
				success: function (data) {
					resData = data.extend;
					// console.log(resData)
				}
			})
			return resData;
		}

		function renderMdoleItem(parent, data) {
			var item = $('<a href="' + (data.href ? data.href : 'javascript:;') + '" title="' + (data.title ? data.title :
				'javascript:;') + '" class="model-item"></a>');
			var itemHtml = '';
			itemHtml = '<div class="model-text">' + data.text + '</div>' +
				'<div class="model-num">' + data.num + '</div>';
			item.html(itemHtml)
			parent.append(item);
		}

		function renderMdolePieItem(parent, data) {
			var item = $('<div class="modle-pie-item"></div>');
			var itemHtml = '';
			itemHtml = '<div class="model-pie-text">' + data.text + '</div>' +
				'<div class="model-pie-num">' + data.num + '</div>';
			item.html(itemHtml)
			parent.append(item);
		}

		function build_pay_table(parent, result) {
			//清空table表格
			var tbody = parent.find(".task_table tbody");
			tbody.empty();
			$.each(result.pageInfo.list, function (index, item) {
				var payinfoId = $("<td></td>").append(item.payinfoId);
				var payinfoOid = $("<td></td>").append(item.payinfoOid);
				// var payinfoStatus = $("<td></td>").append((item.payinfoStatus ? '已支付' : '未支付'));
				if (item.payinfoStatus === 1) {
					var payinfoStatus = $("<td class='yzf_bg'></td>").append('<b>已支付</b>');
				} else {
					var payinfoStatus = $("<td class='wzf_bg'></td>").append('<b>未支付</b>');
				}

				var payinfoMoney = $("<td></td>").append(payinfoMoney);
				var payinfoPlatform = $("<td></td>").append(item.payinfoPlatform);
				var payinfoCreatetime = $("<td></td>").append(item.payinfoCreatetime);
				var payinfoMotifytime = $("<td></td>").append(item.payinfoMotifytime);

				var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性，来表示当前productId
				editBtn.attr("edit-id", item.payinfoId);
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的productId
				delBtn.attr("del-id", item.payinfoId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ");
				//var delBtn = 
				//append方法执行完成以后还是返回原来的元素
				var tr = $("<tr></tr>").append(payinfoId)
					.append(payinfoOid)
					.append(payinfoStatus)
					.append(payinfoMoney)
					.append(payinfoPlatform)
					.append(payinfoCreatetime)
					.append(payinfoMotifytime)
					.append(btnTd);
				tbody.append(tr);
			});
		}
		//解析显示分页信息
		function build_page_info(parent, result) {
			var totalRecord = result.pageInfo.total;
			var currentPage = result.pageInfo.pageNum;
			parent.find(".page_info_area").empty().append(
				"当前" + result.pageInfo.pageNum +
				"页,总" + result.pageInfo.pages +
				"页,总" + result.pageInfo.total + "条记录"
			);
		}
		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(parent, result) {
			//page_nav_area
			var parentArea = parent.find(".page_nav_area");
			parentArea.empty();
			var ul = $("<ul></ul>").addClass("pagination");

			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if (result.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加点击翻页的事件
				firstPageLi.click(function () {
					to_page(1);
				});
				prePageLi.click(function () {
					to_page(result.pageInfo.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
			if (result.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function () {
					to_page(parent, result.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function () {
					to_page(parent, result.pageInfo.pages);
				});
			}

			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.pageInfo.navigatepageNums, function (index, item) {

				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function () {
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
			parentArea.append($("<nav></nav>").append(ul));
		}
	</script>
</body>

</html>