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
					<h2>注册用户列表</h2>
					<span class="user" id="UEmailSession">*</span>
				</div>
				<div class="content">
					<div class="table-box">
						<!-- operator -->
						<div class="op">
							<a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i>注册用户列表页面</a>
						</div>
						<!-- table-content -->
						<div class="table-content">
							<table class="table table-striped table-hover" id="task_table">
								<thead>
									<tr>
										<th>userId</th>
										<th>用户账号</th>
										<th>用户电话</th>
										<th>用户国家</th>
										<th>用户省份</th>
										<th>用户市区</th>
										<th>街道</th>
										<th>用户注册时间</th>
										<th>用户上次在线时间</th>
										<th>操作</th>
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
	<%-- <script type="text/javascript" src="${APP_PATH }/static/back/js/moment.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/daterangepicker.js"></script> --%>
	<script type="text/javascript">
		var adminAccname = '${sessionScope.AdminUser.adminAccname}';
		console.log("adminAccname:" + adminAccname);
		$("#UEmailSession").html(adminAccname);
	</script>
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
				url: "${APP_PATH}/MlfrontUser/getMlfrontUserByPage",
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
				var userId = $("<td></td>").append(item.userId);
				var userEmail = $("<td></td>").append(item.userEmail);
				var userTelephone = $("<td></td>").append(item.userTelephone);
				var userAddressCountry = $("<td></td>").append(item.userAddressCountry);
				var userAddressProvince = $("<td></td>").append(item.userAddressProvince);
				var userAddressCity = $("<td></td>").append(item.userAddressCity);
				var userAddressStreetaddress = $("<td></td>").append(item.userAddressStreetaddress);
				var userCreatetime = $("<td></td>").append(item.userCreatetime);
				var userLastonlinetime = $("<td></td>").append(item.userLastonlinetime);
				var viewBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
					.append($("<span></span> ").addClass("glyphicon glyphicon-eye-open")).append("查看");
				//为编辑按钮添加一个分类id
				viewBtn.attr("edit-id", item.userId);
				var btnTd = $("<td></td>").append(viewBtn);
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(userId)
					.append(userEmail)
					.append(userTelephone)
					.append(userAddressCountry)
					.append(userAddressProvince)
					.append(userAddressCity)
					.append(userAddressStreetaddress)
					.append(userCreatetime)
					.append(userLastonlinetime)
					.append(btnTd)
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
		/* $(document).on('click', '#tasksubmit', function(){
			var data = $('form').serializeArray();
			// console.log(data)
			data = data.reduce(function(obj, item) { obj[item.name] = item.value; return obj }, {});
			data.orderStatus =  $(":input[name='orderStatus']").val();
			// console.log(data);
			$.ajax({
				url:"${APP_PATH}/MlfrontOrder/save",
				data: JSON.stringify(data),
				dataType:"json",
				contentType: 'application/json',
				type:"POST",
				success:function(result){
					if(result.code == 100){
						alert('新建/编辑成功！');
						window.location.href="${APP_PATH}/MlfrontOrder/toMlbackPayInfoList";
					}
				}
			}); 
		}); */
		//删除任務
		/* $("#task_table").on("click",".btn-danger", function() {
 		var data = {payinfoId: $(this).attr('del-id') };
 		$.ajax({
 				url:"${APP_PATH}/MlfrontPayInfo/delete",
 				data: JSON.stringify(data),
				dataType:"json",
				contentType: 'application/json',
 				type:"post",
 				success:function(result){
 					if(result.code == 100){
 						alert('删除成功！');
 						to_page(1);
 					}
 				}
 			});
 	 }); */
		//查看任务
		$("#task_table").on("click", ".edit_btn", function () {
			// tab tpl
			loadTpl();
			// fetch data
			data = {
				"userId": $(this).attr('edit-id')
			};
			$.ajax({
				url: "${APP_PATH}/MlfrontUser/getOneMlfrontUserDetail",
				data: data,
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						obj = result.extend.mlfrontUserOne;
						tianchong(obj);
					} else {
						alert("联系管理员");
					}
				}
			});

			function tianchong(data) {
				$(":input[name='userId']").val(data.userId);
				$(":input[name='userEmail']").val(data.userEmail);
				$(":input[name='userTelephone']").val(data.userTelephone);
				$(":input[name='userAddressCountry']").val(data.userAddressCountry);
				$(":input[name='userAddressProvince']").val(data.userAddressProvince);
				$(":input[name='userAddressCity']").val(data.userAddressCity);
				$(":input[name='userAddressStreetaddress']").val(data.userAddressStreetaddress);
				$(":input[name='userFirstname']").val(data.userFirstname);
				$(":input[name='userLastname']").val(data.userLastname);
				$(":input[name='userCreatetime']").val(data.userCreatetime);
				$(":input[name='userMotifytime']").val(data.userMotifytime);
				$(":input[name='userLastonlinetime']").val(data.userLastonlinetime);
			}
		});


		function loadTpl() {
			$('.table-box').load('${APP_PATH}/static/tpl/addUser.html', function () {
				$('.coupon-status').find('input').on('change', function () {
					var spanEl = $(this).parent().find('span');
					$(this).is(':checked') ? $(this).val(1) && spanEl.text('已支付') : $(this).val(0) && spanEl.text('未支付');
				});
			});
		}
	</script>
</body>

</html>