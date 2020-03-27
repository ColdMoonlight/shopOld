<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>购物车结算量</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<link rel="stylesheet" href="${APP_PATH }/static/back/js/datepicker/datepicker.css">
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/main.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/table.css">

	<%-- <link rel="stylesheet" href="${APP_PATH }/static/back/js/datepicker/datepicker.css"> --%>
	<style>
		tr>td:nth-last-of-type(2), th>td:nth-last-of-type(2) { max-width: 100px; }
	</style>
</head>

<body>
	<div class="container">
		<div class="aside-bar nicescroll">
			<jsp:include page="leftnav.jsp"></jsp:include>
		</div>
		<div class="main-body">
			<div class="main-box nicescroll">
				<div class="header">
					<h2>购物车结算量</h2>
					<span class="user" id="UEmailSession">*</span>
				</div>
				<div class="content">
					<!-- pie -->
					<div class="model" data-type="pie">
						<div class="model-h">
							<div class="c-datepicker-date-editor date-timepicker data_num">
								<i class="c-datepicker-range__icon kxiconfont icon-clock"></i>
								<input placeholder="开始日期" name="" value="" class="c-datepicker-data-input">
								<span class="c-datepicker-range-separator">-</span>
								<input placeholder="结束日期" name="" value="" class="c-datepicker-data-input">
							</div>
						</div>
					</div>
					<!-- pie -->
					<div class="table-box">
						<!-- operator -->
						<!-- table-content -->
						<div class="table-content num_box">
							<table class="table table-striped table-hover" id="task_table">
								<thead>
									<tr>
										<th>产品SEO名称</th>
										<th>购物车结算量</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="td_name"></td>
										<td class="td_num"></td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- 显示分页信息 -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${APP_PATH }/static/back/js/jquery-nicescroll.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/sidenav.js"></script>
	<!-- <script type="text/javascript" src="${APP_PATH }/static/back/js/nav.js"></script> -->
	<script src="${APP_PATH }/static/back/js/datepicker/moment.min.js"></script>
	<script src="${APP_PATH }/static/back/js/datepicker/datepicker.js"></script>
	<script type="text/javascript">
		var adminAccname = '${sessionScope.AdminUser.adminAccname}';
		$("#UEmailSession").html(adminAccname);
	</script>
	<script type="text/javascript">
		$('.nicescroll').each(function (i, item) {
			$(item).niceScroll({
				cursorcolor: "rgba(0,0,0,.3)",
				cursorwidth: "4px",
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

		function initHtml() {
			var $input = targetInput.find('input');
			$input.eq(0).val(minDate22);
			$input.eq(1).val(maxDate);
		}

		var startime = minDate22;
		var endtime = maxDate;
		$.ajax({
			url: '${APP_PATH}/MlbackAddCheakoutViewDetail/getAddCheakoutViewDetailList',
			data: JSON.stringify({
				"addcheakoutviewdetailStarttime": startime,
				"addcheakoutviewdetailEndtime": endtime,
			}),
			type: 'post',
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				// console.log(data);
				renderTable($('#add-table-body'), data.extend.arrayA, '购物车结算量');
			}
		});

		function renderTable(parent, data, type) {
			var htmlStr = '';
			$.each(data, function (index, item) {
				htmlStr += '<tr>'
					+ '<td>'+ type +' --- ' + item.seoString + '.html</td>'
					+ '<td>' + item.seoStringCount + '</td>'
				+ '</tr>';
			});
			
			parent.html(htmlStr);
		}

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
						var startime = this.$input.eq(0).val();
						var endtime = this.$input.eq(1).val();
						$(".td_name").empty();
						$(".td_num").empty();
						$.ajax({
							url: '${APP_PATH}/MlbackAddCheakoutViewDetail/getAddCheakoutViewDetailList',
							data: JSON.stringify({
								"addcheakoutviewdetailStarttime": startime,
								"addcheakoutviewdetailEndtime": endtime,
							}),
							type: 'post',
							dataType: 'json',
							contentType: 'application/json',
							success: function (data) {
								// console.log(data);
								renderTable($('#add-table-body'), data.extend.arrayA, '购物车结算量');
							}
						});
					}
				})
			})
		}

		$(function () {
			initHtml();
			initJs();
		});
	</script>
</body>

</html>