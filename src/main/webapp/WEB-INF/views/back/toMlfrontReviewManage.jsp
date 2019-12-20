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
								<div class="form-group pinglun" style="float: left;">
								    <label class="control-label" style="float: left;">评论状态</label>
								    <div class="" style="float: left;">
								        <select class="form-control selectpl">
										  <option value ="0" selected="selected">不生效</option>
										  <option value ="1">生效</option>
										</select>
								    </div>
								</div>
								<div class="form-group staricon" style="float: left;">
								    <label class="control-label" style="float: left;">星级:</label>
								    <div class="" style="float: left;">
								        <select class="form-control xing">
										  <option value ="1" selected="selected">1颗星</option>
										  <option value ="2">2颗星</option>
										  <option value ="3">3颗星</option>
										  <option value ="4">4颗星</option>
										  <option value ="5">5颗星</option>
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
								    <!-- table-content -->
								    <div class="table-content">
								    	<table class="table table-striped table-hover" id="task_table">
								    		<thead>
								    			<tr>
								    				<th>reviewId</th>
								    				<th>评论客户</th>
								    				<th>客户头像</th>
								    				<th>产品id</th>
								    				<!-- <th>产品名称</th> -->
								    				<th>评论时间</th>
								    				<th>评论状态</th>
								    				<!-- <th>评论图片数</th> -->
								    				<th>评分星级</th>
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
		var reviewPid;
		var reviewStatus=0;
		var reviewProstarnum;
		var reviewStarttime;
		var reviewEndtime;
		var totalRecord, currentPage, editid;
		$(".pinglun .selectpl").change(function(){
			var reviewStatusselect=$(this).val();
			reviewStatus=reviewStatusselect;
			console.log(reviewStatus)
		});
		$(".staricon .xing").change(function(){
			var xingselect=$(this).val();
			reviewProstarnum=xingselect;
			console.log(reviewProstarnum)
		})
		
		/**时间插件***/
		var targetInput = $('.date-timepicker');
		var date = new Date();
			var minDatestar = moment()
				.set({
					'date': date.getDate(),
					'hour': 0,
					'minute': 0,
					'second': 0
				}).format('YYYY-MM-DD HH:mm:ss');
			 reviewStarttime =minDatestar;
			var maxDateend = moment()
				.set({
					'date': date.getDate(),
					'hour': date.getHours(),
					'minute': date.getMinutes(),
					'second': date.getSeconds()
				}).format('YYYY-MM-DD HH:mm:ss');
			reviewEndtime =maxDateend;	
			/***********************************************/
			 				function initJs() {
			 					targetInput.each(function (i, item) {
			 						$(item).datePicker({
			 							hasShortcut: true,
			 							min: '2018-01-01 06:00:00',
			 							max: maxDateend,
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
											var changestar = this.$input.eq(0).val();
											var changeEnd = this.$input.eq(1).val();
											reviewStarttime=changestar;
											reviewEndtime=changeEnd;
			 							}
			 						})
			 					})
			 				}
			function initHtml() {
				var $input = targetInput.find('input');
				$input.eq(0).val(minDatestar);
				$input.eq(1).val(maxDateend);
			}
			$(function () {
				initHtml();
				initJs();
			});
			

		/**时间插件***/
		/**产品id****/
		getCategoryDown()
		function getCategoryDown() {
			$.ajax({
				url: "${APP_PATH}/MlbackProduct/getMlbackProductAllList",
				type: "GET",
				async: false,
				success: function (result) {
					if (result.code == 100) {
						function setCategoryDescSelect(el, data) {
							var html = '';
							for (var i = 0; i < data.length; i += 1) {
								 // var productId = data[i].productId;
								 // console.log(productId)
								html += '<option value="' + data[i].productId + '">'+ data[i].productId+"    " + data[i].productName + '</option>';
							}
							el.html(html);
						}
						objparentList = result.extend.mlbackProductResList;
						var categoryIdSelect = $('#actshowproProid');
						setCategoryDescSelect(categoryIdSelect, objparentList);
						categoryIdSelect.change(function(){
							var productSelectid=$(this).val();
							reviewPid=productSelectid;
							// console.log(reviewPid)
						})
						
						
					} else {
						alert("联系管理员");
					}
				}
			});
		}
		/********************************/
		// console.log(reviewStarttime)
		// console.log(reviewEndtime)
		console.log( "初始化"+"pn:"+ 1 + "reviewPid:"+reviewPid+"reviewStatus:"+reviewStatus+"reviewProstarnum:"+reviewProstarnum+"reviewStarttime"+reviewStarttime+"reviewEndtime"+reviewEndtime);
		$(".btn_search").click(function(){
			var reviewProstarnum =$(".staricon .xing").val();
			console.log("点击"+"pn:"+ 1 + "reviewPid:"+reviewPid+"reviewStatus:"+reviewStatus+"reviewProstarnum:"+reviewProstarnum+"reviewStarttime"+reviewStarttime+"reviewEndtime"+reviewEndtime);
			to_page(1,reviewPid,reviewStatus,reviewProstarnum,reviewStarttime,reviewEndtime)
		})
		function to_page(pn,reviewPid,reviewStatus,reviewProstarnum,reviewStarttime,reviewEndtime) {
			 // Integer reviewStatus;
			 //   * Integer reviewProstarnum;
			 //   * String reviewStarttime;
			 //   * String reviewEndtime;
		      $.ajax({
		        url: "${APP_PATH}/MlfrontReview/selectMlblackReviewListBySearch",
				data:{
					"pn": pn,
					"reviewPid": reviewPid,
					"reviewStatus":reviewStatus,
					"reviewProstarnum":reviewProstarnum,
					"reviewStarttime":reviewStarttime,
					"reviewEndtime":reviewEndtime
				},
		        type: "POST",
		        success: function (result) {
		          if (result.code == 100) {
		            console.log(result)
					//1、解析并显示员工数据
					build_task_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);
		          } else {
		            alert("联系管理员");
		          }
		        }
		      });
		    }
		/**************/
		function build_task_table(result) {
			//清空table表格
			$("#task_table tbody").empty();
			var task = result.extend.pageInfo.list;
			$.each(task, function (index, item) {
				var reviewId = $("<td></td>").append(item.reviewId);
				var reviewUname = $("<td></td>").append(item.reviewUname);
				var imgurl = item.reviewUimgurl;
				var image = '<img src=' + imgurl + ' ' + 'width=40 height=40>';
				var reviewUimgurl = $("<td></td>").append(image);
				var reviewPid = $("<td></td>").append(item.reviewPid);
				var reviewPname = $("<td></td>").append(item.reviewPname);
				var reviewCreatetime = $("<td></td>").append(item.reviewCreatetime);
				var reviewStatus = $("<td></td>").append((item.reviewStatus ? '已生效' : '未生效'));
				var reviewImgidstr = $("<td></td>").append(item.reviewImgidstr);
				var reviewProstarnum = $("<td></td>").append(item.reviewProstarnum);
		
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性，来表示当前productId
				editBtn.attr("edit-id", item.reviewId);
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的productId
				delBtn.attr("del-id", item.reviewId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ");
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(reviewId)
					.append(reviewUname)
					.append(reviewUimgurl)
					.append(reviewPid)
					.append(reviewCreatetime)
					.append(reviewStatus)
					.append(reviewProstarnum)
					.append(btnTd)
					.appendTo("#task_table tbody");
			});
		}
		//解析显示分页信息
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前" + result.extend.pageInfo.pageNum + "页,总" +
					result.extend.pageInfo.pages + "页,总" +
					result.extend.pageInfo.total + "条记录"
			);
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
					// to_page(1);
					to_page(1,reviewPid,reviewStatus,reviewProstarnum,reviewStarttime,reviewEndtime)
				});
				prePageLi.click(function () {
					// to_page(result.extend.pageInfo.pageNum - 1);
					to_page(currentPage-1,reviewPid,reviewStatus,reviewProstarnum,reviewStarttime,reviewEndtime)
					
				});
			}
		
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function () {
					// to_page(result.extend.pageInfo.pageNum + 1);
					to_page(currentPage+1,reviewPid,reviewStatus,reviewProstarnum,reviewStarttime,reviewEndtime)
				});
				lastPageLi.click(function () {
					// to_page(result.extend.pageInfo.pages);
					to_page(result.extend.pageInfo.pages,reviewPid,reviewStatus,reviewProstarnum,reviewStarttime,reviewEndtime)
					
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
					// to_page(item);
					// console.log("点击数字"+"pn:"+ item + "reviewPid:"+reviewPid+"reviewStatus:"+reviewStatus+"reviewProstarnum:"+reviewProstarnum+"reviewStarttime"+reviewStarttime+"reviewEndtime"+reviewEndtime);
					// console.log(reviewProstarnum)
					// console.log(reviewStatus)
					to_page(item,reviewPid,reviewStatus,reviewProstarnum,reviewStarttime,reviewEndtime)
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
		
			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
	</script>
</body>

</html>