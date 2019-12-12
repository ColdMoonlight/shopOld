<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>评论管理</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/main.css">
	<link rel="stylesheet" href="${APP_PATH }/static/back/css/table.css">
	
	<link rel="stylesheet" href="${APP_PATH }/static/back/js/datepicker/datepicker.css">

	<!-- summernote css -->
	<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/back/js/summernote/codemirror.min.css" />
	<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/back/js/summernote/monokai.min.css">
	<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/back/js/summernote/summernote.css">
	<style>
		tr>td:nth-of-type(3),
		th>td:nth-of-type(3) {
			max-width: 100px;
		}
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
					<h2>评论列表高级管理</h2>
					<span class="user" id="UEmailSession">*</span>
				</div>
				<div class="content">
					<div class="table-box">
						<!-- operator -->
						<div class="op">
							<a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i> 评论列表列表</a>
							<a href="#" id="task_add_modal_btn" class="btn btn-primary" role="button"><i class="glyphicon glyphicon-plus"></i> 新增</a>
						</div>
							<ul id="productTab" class="nav nav-tabs tabultop">
								<li class="active"><a data-href="#allreview" data-toggle="tab">全部评论</a></li>
								<li><a data-href="#myreview" data-toggle="tab">我发布的品论</a></li>
							</ul>
							<div class="choose_screen">
								<div class="c-datepicker-date-editor date-timepicker" style="float: left; margin: 0 20px 0 0;">
									<i class="c-datepicker-range__icon kxiconfont icon-clock"></i>
									<input placeholder="开始日期" name="" value="" class="c-datepicker-data-input">
									<span class="c-datepicker-range-separator">-</span>
									<input placeholder="结束日期" name="" value="" class="c-datepicker-data-input">
								</div>
								<div class="form-group staricon" style="float: left;">
								    <label class="control-label" style="float: left;">星级:</label>
								    <div class="" style="float: left;">
								        <select class="form-control">
										  <option value ="1" selected="selected">1颗星</option>
										  <option value ="2" selected="selected">2颗星</option>
										  <option value ="3" selected="selected">3颗星</option>
										  <option value ="4" selected="selected">4颗星</option>
										  <option value ="5" selected="selected">5颗星</option>
										</select>
								    </div>
								</div>
								<div class="form-group cp_select">
								     <label for="actshowproProid" style="float: left;" class="control-label">产品名字:</label>
								     <div class="" style="float: left;">
								         <select id="actshowproProid" name="actshowproProid" class="form-control"></select>
								     </div>
								 </div>
								   <div class="form-group btn_search">
									   <input type="submit" id="" value="搜索" name="" />
							       </div>
							</div>
							<div id="productTabContent" class="tabreview tab-content">
								<div class="tab-pane in active" id="allreview">
									111111111111111111111111111111111111
								</div>
								<div class="tab-pane in" id="myreview">
									222222222222222222222222222222222222
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${APP_PATH }/static/back/js/jquery-nicescroll.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/sidenav.js"></script>
	<!-- <script type="text/javascript" src="${APP_PATH }/static/back/js/nav.js"></script> -->

	<script type="text/javascript" src="${APP_PATH }/static/back/js/summernote/codemirror.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/summernote/xml.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/summernote/summernote.min.js"></script>

	<script type="text/javascript" src="${APP_PATH }/static/back/js/session.js"></script>
	
	<script type="text/javascript" src="${APP_PATH }/static/back/js/datepicker/moment.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/datepicker/datepicker.js"></script>

	<script type="text/javascript">
		var adminAccname = '${sessionScope.AdminUser.adminAccname}';
		// console.log("adminAccname:" + adminAccname);
		$("#UEmailSession").html(adminAccname);
	</script>
	<script type="text/javascript">
		$('.nicescroll').each(function(i, item) {
			$(item).niceScroll({
					cursorcolor: "rgba(0,0,0,.3)",
					cursorwidth: "4px",
					cursorborder: "none",
					horizrailenabled: false,
					enablekeyboard: false,
			}).resize()
		});
		/******************************/
		getCategoryDown()
		function getCategoryDown() {
			$.ajax({
				url: "${APP_PATH}/MlbackProduct/getMlbackProductAllList",
				type: "GET",
				async: false,
				success: function (result) {
					if (result.code == 100) {
						function setCategoryDescSelect(el, data) {
							var html = '<option value="-1">---无绑定产品---</option>';
							for (var i = 0; i < data.length; i += 1) {
								html += '<option value="' + data[i].productId + '">'+ data[i].productId+"    " + data[i].productName + '</option>';
							}
							el.html(html);
						}
						objparentList = result.extend.mlbackProductResList;
						// console.log("objparentList");
						 // console.log(objparentList);
						var categoryIdSelect = $('#actshowproProid');
						setCategoryDescSelect(categoryIdSelect, objparentList);
					} else {
						alert("联系管理员");
					}
				}
			});
		}
         /*****/
		 
		 				var targetInput = $('.date-timepicker');
		 				var date = new Date();
		 				var minDate = moment().set({
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
		 					
		 					/****************************/
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
		 				
		 /*******初始化显示*************/
		               var startime =minDate22;
		               var endtime =maxDate;
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
		 							},{
		 							 name: '最近一周',
		 							 day: '-7,0',
		 							 time:'00:00:00,'
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
		 								// console.log(1);
		 								// console.info(this.$input.eq(0).val(), this.$input.eq(1).val());
		 								var startime = this.$input.eq(0).val();
		 								var endtime = this.$input.eq(1).val();
		 								 $(".td_name").empty();
		 								 $(".td_num").empty();
		 								
		 							}
		 						})
		 					})
		 				}
		 
		/*****/
		$(function () {
			initHtml();
			initJs();
		});
	</script>
</body>

</html>