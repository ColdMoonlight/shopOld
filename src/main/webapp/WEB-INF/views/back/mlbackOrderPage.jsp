<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/main.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/table.css">
	<%-- <link rel="stylesheet" href="${APP_PATH }/static/back/js/datepicker/datepicker.css"> --%>
</head>

<body>
	<div class="container">
		<div class="aside-bar"></div>
		<div class="main-body">
			<div class="main-box">
				<div class="header">
					<h2>订单页面列表</h2>
					<span class="user" id="UEmailSession">*</span>
				</div>
				<div class="content">
					<div class="table-box">
						<!-- operator -->
						<div class="op">
							<a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i>订单页面列表</a>
							<!-- <a href="#" id="task_add_modal_btn" class="btn btn-primary" role="button"><i class="glyphicon glyphicon-plus"></i> 新增</a> -->
						</div>
						<!-- table-content -->
						<div class="table-content">
							<table class="table table-striped table-hover" id="task_table">
								<thead>
									<tr>
										<th>orderId</th>
										<th>订单金额</th>
										<th>订单状态</th>
										<th>订单地址Id</th>
										<th>订单优惠Code</th>
										<th>订单发起时间</th>
										<th>订单更新时间</th>
									</tr>
								</thead>
								<tbody> </tbody>
							</table>
						</div>
						<!-- 显示分页信息 -->
						<div class="row">
							<!--分页文字信息  -->
							<div class="col-md-6 col-sm-6" id="page_info_area"></div>
							<!-- 分页条信息 -->
							<div class="col-md-6 col-sm-6" id="page_nav_area"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${APP_PATH }/static/back/js/sidenav.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/nav.js"></script>

	<script type="text/javascript">
		var adminAccname = '${sessionScope.AdminUser.adminAccname}';
		console.log("adminAccname:" + adminAccname);
		$("#UEmailSession").html(adminAccname);
	</script>

	<%-- <script type="text/javascript" src="${APP_PATH }/static/back/js/moment.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/datepicker/datepicker.js"></script> --%>

	<script type="text/javascript">
		var totalRecord, currentPage, editid;
		var count = 1;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		$(function () {
			//去首页
			to_page(1);
		});

		function to_page(pn) {
			$.ajax({
				url: "${APP_PATH}/MlfrontOrder/getMlfrontOrderByPage",
				data: "pn=" + pn,
				type: "GET",
				success: function (result) {
					//console.log(result);
					//1、解析并显示员工数据
					build_task_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);
				}
			});
		}

		function build_task_table(result) {
			//清空table表格
			$("#task_table tbody").empty();
			var task = result.extend.pageInfo.list;
			// console.log(task)
			$.each(task, function (index, item) {
				var orderId = $("<td></td>").append(item.orderId);
				var orderMoney = $("<td></td>").append(parseFloat(item.orderMoney));
				var orderStatus = $("<td></td>").append((item.orderStatus === 1 ? '已支付' : '未支付'));
				var addressinfoId = $("<td></td>").append(item.addressinfoId);
				var orderCouponCode = $("<td></td>").append((item.orderCouponCode ? item.orderCouponCode : '未使用'));
				var orderCreatetime = $("<td></td>").append(item.orderCreatetime);
				var orderMotifytime = $("<td></td>").append(item.orderMotifytime);
				var viewBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
					.append($("<span></span> ").addClass("glyphicon glyphicon-eye-open")).append("查看");
				//为编辑按钮添加一个分类id
				viewBtn.attr("edit-id", item.orderId);
				/* var delBtn =  $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个分类id
				delBtn.attr("del-id",item.orderId); */
				var btnTd = $("<td></td>").append(viewBtn);
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(orderId)
					.append(orderMoney)
					.append(orderStatus)
					.append(addressinfoId)
					.append(orderCouponCode)
					.append(orderCreatetime)
					.append(orderMotifytime)
					/* .append(btnTd) */
					.appendTo("#task_table tbody");
			});
		}
		//解析显示分页信息
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总" +
				result.extend.pageInfo.pages + "页,总" +
				result.extend.pageInfo.total + "条记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(result) {
			//page_nav_area
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");

			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加点击翻页的事件
				firstPageLi.click(function () {
					to_page(1);
				});
				prePageLi.click(function () {
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function () {
					to_page(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function () {
					to_page(result.extend.pageInfo.pages);
				});
			}

			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums, function (index, item) {

				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function () {
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);

			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		//新建任務
		$('#task_add_modal_btn').click(function () {
			// 获取分类页面模板
			loadTpl();
		});
		//新建/编辑任務提交按钮
		$(document).on('click', '#tasksubmit', function () {
			var data = $('form').serializeArray();
			// console.log(data)
			data = data.reduce(function (obj, item) {
				obj[item.name] = item.value;
				return obj
			}, {});
			data.orderStatus = $(":input[name='orderStatus']").val();
			// console.log(data);
			$.ajax({
				url: "${APP_PATH}/MlfrontOrder/save",
				data: JSON.stringify(data),
				dataType: "json",
				contentType: 'application/json',
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						alert('新建/编辑成功！');
						window.location.href = "${APP_PATH}/MlfrontOrder/toMlbackPayInfoList";
					}
				}
			});
		});

		//编辑任务
		$("#task_table").on("click", ".edit_btn", function () {
			// tab tpl
			loadTpl($(this).attr('edit-id'));

		});

		function tianchong(data) {
			$(":input[name='orderId']").val(data.orderId);
			$(":input[name='orderMoney']").val(data.orderMoney);
			$(":input[name='addressinfoId']").val(data.addressinfoId);
			$(":input[name='orderCouponCode']").val((data.orderCouponCode ? data.orderCouponCode : '未使用'));
			$(":input[name='orderCreatetime']").val(data.orderCreatetime);
			$(":input[name='orderMotifytime']").val(data.orderMotifytime);
		}


		function loadTpl(orderId) {
			$('.table-box').load('${APP_PATH}/static/tpl/addOrder.html', function () {
				$('.coupon-status').find('input').on('change', function () {
					var spanEl = $(this).parent().find('span');
					$(this).is(':checked') ? $(this).val(1) && spanEl.text('已支付') : $(this).val(0) && spanEl.text('未支付');
				});

				if (orderId) {
					// fetch data
					var reqdata = {
						"orderId": orderId
					};
					$.ajax({
						url: "${APP_PATH}/MlfrontOrder/getOneMlfrontOrderDetail",
						data: reqdata,
						type: "POST",
						success: function (result) {
							if (result.code == 100) {
								console.log(result);
								var resData = result.extend.mlfrontOrderOne;
								console.table(resData)
								tianchong(resData);
							} else {
								alert("联系管理员");
							}
						}
					});
				}
			});
		}
	</script>
</body>

</html>