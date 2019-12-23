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
					<div class="table-box_list">
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
<!-- 								<div class="date-timepicker2">
									<div class="form-group row">
										<label for="reviewCreatetime" class="col-sm-2 control-label">编造评论时间:</label>
										<div class="col-sm-6 J-datepicker">
											<input type="text" autocomplete="off" class="form-control countdown-start" placeholder="格式:年-月-日-时-分-秒，如：2020-08-01 12:30:00" name="reviewCreatetime">
										</div>
									</div>
									<div class="form-group row">
										<label for="reviewConfirmtime" class="col-sm-2 control-label">审核评论时间:</label>
										<div class="col-sm-6 J-datepicker">
											<input type="text" autocomplete="off" class="form-control countdown-end" placeholder="格式:年-月-日-时-分-秒，如：2020-08-01 12:30:00" name="reviewConfirmtime">
										</div>
									</div>
								</div> -->
								
								
								<div class="form-group pinglun" style="float: left;">
								    <label class="control-label" style="float: left;">评论状态</label>
								    <div class="" style="float: left;">
								        <select class="form-control selectpl">
										  <option value ="999" selected="selected">全部</option>
										  <option value ="0">不生效</option>
										  <option value ="1">生效</option>
										</select>
								    </div>
								</div>
								<div class="form-group staricon" style="float: left;">
								    <label class="control-label" style="float: left;">星级:</label>
								    <div class="" style="float: left;">
								        <select class="form-control xing">
										  <option value ="0" selected="selected">全部</option>
										  <option value ="1">1颗星</option>
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
					<div class="table-box box_new_review">
						
					</div>
				</div>
			</div>
		</div>
	</div>
     <div class="maskbg"></div>
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
		
		
		/**产品id****/
		var reviewPid=999;
		getCategoryDown()
		function getCategoryDown() {
			$.ajax({
				url: "${APP_PATH}/MlbackProduct/getMlbackProductAllList",
				type: "GET",
				async: false,
				success: function (result) {
					if (result.code == 100) {
						function setCategoryDescSelect(el, data) {
						var html = '<option value="999">---全部---</option>';
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
		var reviewStatus=999;
		var reviewProstarnum=0;
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
			function  datePickerint(){
				$('.J-datepicker').datePicker({
				  hasShortcut:true,
				  min:'2018-01-01 04:00:00',
				  max:'2050-09-09 20:59:59',
				  shortcutOptions:[{
					name: '今天',
					day: '0'
				  }, {
					name: '昨天',
					day: '-1',
					time: '00:00:00'
				  }, {
					name: '一周前',
					day: '-7'
				  }],
				  hide:function(){
					console.info(this)
				  }
				}); 
			}
			$(function () {
				initHtml();
				initJs();
				 datePickerint()
				
			});
		console.log( "初始化"+"pn:"+ 1 + "reviewPid:"+reviewPid+"reviewStatus:"+reviewStatus+"reviewProstarnum:"+reviewProstarnum+"reviewStarttime"+reviewStarttime+"reviewEndtime"+reviewEndtime);
		$(".btn_search").click(function(){
		console.log(reviewPid)
			console.log("点击"+"pn:"+ 1 + "reviewPid:"+reviewPid+"reviewStatus:"+reviewStatus+"reviewProstarnum:"+reviewProstarnum+"reviewStarttime"+reviewStarttime+"reviewEndtime"+reviewEndtime);
   //         if(reviewProstarnum=="0"){
			// 	alert("请选择星级")
			// }else if(reviewPid=="999"){
			// 	alert("请选择产品")
			// }else{
				
			// }
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
					  var task = result.extend.pageInfo.list;
					  if(task.length==0){
						  alert("没有查到")
					  }
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
		//新建任務
		$('#task_add_modal_btn').click(function () {
			$(".maskbg").show();
			$(".box_new_review").addClass("active")
			// $(".box_new_review").css("height","600px");
			
			$('.table-box').load('${APP_PATH}/static/tpl/addReviewnew.html',function () {
					// 设置归属类
					getProductDown();
					getCategoryDown();
					// $(":input[name='reviewCreatetime']").val(minDatestar);
					// $(":input[name='reviewConfirmtime']").val(reviewEndtime);
					datePickerint()
					
					$(".closeaddreview").click(function(){
						$(".box_new_review").removeClass("active")
						$(".maskbg").hide();
					})
				}
			);
		});
		//保存
		$(document).on('click', '#tasksubmit', function () {
			var data = $('form').serializeArray();
			reqData = data.reduce(function (obj, item) {
				obj[item.name] = item.value;
				return obj
			}, {});
			console.log(reqData)
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/save",
				data: JSON.stringify(reqData),
				dataType: "json",
				contentType: 'application/json',
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						alert('操作成功！');
						// window.location.href = "${APP_PATH}/MlfrontReview/toMlfrontReviewPage";
						$(".box_new_review").removeClass("active")
						$(".maskbg").hide();
					}
				}
			});
		});
		// 删除该条（id）评论信息
		$("#task_table").on("click", ".btn-danger", function () {
			var data = {
				reviewId: $(this).attr('del-id')
			};
			console.log(data)
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/delete",
				data: JSON.stringify(data),
				dataType: "json",
				contentType: 'application/json',
				type: "post",
				success: function (result) {
					if (result.code == 100) {
						alert('删除成功！');
						to_page(1);
					}
				}
			});
		});
		// // fetch all product infos
		var productData;
		function getProductDown() {
			$.ajax({
				url: "${APP_PATH}/MlbackProduct/getMlbackProductAllList",
				type: "GET",
				async: false,
				success: function (result) {
					if (result.code == 100) {
						function setCategoryDescSelect(el, data) {
							var html = '';
							for (var i = 0; i < data.length; i += 1) {
								html += '<option value="' + data[i].productId + '">' + data[i].productId +" "+ data[i].productName + '</option>';
							}
							el.html(html);
						}
						productData = result.extend.mlbackProductResList;
						var categoryIdSelect = $('#reviewPid');
						setCategoryDescSelect(categoryIdSelect, productData);
					} else {
						alert("联系管理员");
					}
				}
			});
		}
		
		// 跳转到编辑页面/并做编辑页面的相关处理
		$("#task_table").on("click", ".edit_btn", function () {
			$(".maskbg").show();
			$(".box_new_review").addClass("active")
			var reviewId = parseInt($(this).attr('edit-id'))
			// tab tpl
			$('.table-box').load('${APP_PATH}/static/tpl/addReviewnew.html', function () {
				// 获取产品列表
				// getProductDown();
				getProductDown();
				getCategoryDown()
				// init
				initOtherInfo(reviewId)
				initImgList(reviewId);//附图文件
		
				// boot upload img
				/* $('#upload-img-main').on("change", upload); */ //头像图不再上传，从名字的第一个字母生成
				$('.upload-img-fu').each(function (i, item) {
					$(item).on("change", function () {
						uploadfu($(this), i + 1);
					})
				});
				$('#upload-img-fu1').on("change", uploadfu);
					$(".clear_img").on("click",function(id){
						var selfimg =this;
							var data = {
								reviewimgId:$(this).parents(".upload-img-btn").attr("id")
							};
							// console.log(data);
							$.ajax({
								url: "${APP_PATH}/MlbackReviewImg/delete",
								data: JSON.stringify(data),
								dataType: "json",
								contentType: 'application/json',
								type: "post",
								success: function (result) {
									console.log(result)
									if (result.code == 100) {
										alert('删除成功！');
										$(selfimg).parents(".upload-img-btn").css({"background":"url(/ShopTemplate/static/img/plus.png) no-repeat","background-size":"200px"})
									}
								}
							});
						});
				
			$(".closeaddreview").click(function(){
				$(".box_new_review").removeClass("active")
				$(".maskbg").hide();
			})	
				
			});
		});
		// fetch data about review imgs
		function initImgList(id) {
			$.ajax({
				url: "${APP_PATH}/MlbackReviewImg/getMlbackReviewImgListByReviewId",
				data: {
					"reviewId": id
				},
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						// render data
						tianchongImg(result.extend.mlbackReviewImgResList);
					} else {
						alert("联系管理员");
					}
				}
			});
		}
		
		// fetch data about reivew
		function initOtherInfo(id) {
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/getOneMlfrontReviewDetailById",
				data: {
					"reviewId": id
				},
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						var obj = result.extend.mlfrontReviewOne;
						// console.log(obj)
						// render data
						tianchong(obj);
						// $(":input[name='reviewCreatetime']").val(minDatestar);
						// $(":input[name='reviewConfirmtime']").val(reviewEndtime);
						 datePickerint()
						
					} else {
						alert("联系管理员");
					}
				}
			});
		}
		// 编辑-回显-数据（不带图片）
		function tianchong(data) {
			$(":input[name='reviewId']").val(data.reviewId);
			$(":input[name='reviewUid']").val(data.reviewUid);
			$(":input[name='reviewUname']").val(data.reviewUname);
			$(":input[name='reviewPid']").val(data.reviewPid);
			$(":input[name='reviewPname']").val(data.reviewPname);
			
			$(":input[name='reviewCreatetime']").val(data.reviewCreatetime);
			$(":input[name='reviewConfirmtime']").val(data.reviewConfirmtime);
		
			$(":input[name='reviewStatus']").val(data.reviewStatus);
			
			if (data.reviewUimgurl && data.reviewUimgurl.length) {
				$("#upload-img-main").parent().css("background-image", "url(" + data.reviewUimgurl + ")");
			}
			$(":input[name='reviewDetailstr']").val(data.reviewDetailstr);
			$(":input[name='reviewImgidstr']").val(data.reviewImgidstr);
			$(":input[name='reviewProstarnum']").val(data.reviewProstarnum);
		}
		
		
		// 编辑-回显-数据（仅图片）
		function tianchongImg(data) {
			console.log(data);
			var elImgs = $('.sub-img').find('.upload-img-btn');
			for (var i = 0; i < data.length; i += 1) {
				$(elImgs[data[i].reviewimgSortOrder - 1]).css("background-image", "url(" + data[i].reviewimgUrl + ")");
				var imgid =data[i].reviewimgId;
				$(elImgs[data[i].reviewimgSortOrder - 1]).attr("id",imgid)
			}
		}
		
		// upload img 
		function upload() {
			var self = this;
			//实例化一个FormData
			var obj = new FormData();
			obj.append('file', $(this)[0].files[0]);
			// console.log($(this)[0].files[0])
			var reviewIdUP = $(":input[name='reviewId']").val();
			if (reviewIdUP == null) {
				//如果没有pid,弹出"请先输入产品名，保存后再次进入"
				// console.log("productIdUP:"+productIdUP);
				alert("请先输入产品名，保存后从编辑进入");
			} else {
				obj.append('reviewId', reviewIdUP);
				$.ajax({
					url: "${APP_PATH}/UpImg/uploadReviewUImg",
					type: "post",
					dataType: "json",
					cache: false,
					data: obj,
					processData: false, // 不处理数据
					contentType: false, // 不设置内容类型
					success: function (data) {
						//设置背景为我们选择的图片
						// console.log(data);
						var returl = data.extend.uploadUrl;
						$(self).parent().css({
							"background-image": "url(" + '${APP_PATH }/static/img/ReviewUImg/' + returl + ")"
						});
					}
				});
			}
		}
		
		// upload img 1-2
		function uploadfu(item, index) {
			var self = this;
			// console.log(self)
			//实例化一个FormData
			var obj = new FormData();
			obj.append('file', item[0].files[0]);
			// console.log($(this)[0].files[0])
			var reviewIdUP = $(":input[name='reviewId']").val();
			if (reviewIdUP == null) {
				alert("请先输入产品名，保存后从编辑进入");
			} else {
				obj.append('reviewId', reviewIdUP);
				obj.append('sort', index);
				$.ajax({
					url: "${APP_PATH}/UpImg/uploadReviewAllImg",
					type: "post",
					dataType: "json",
					cache: false,
					data: obj,
					processData: false, // 不处理数据
					contentType: false, // 不设置内容类型
					success: function (data) {
						//设置背景为我们选择的图片
						// console.log(data);
						var returl = data.extend.uploadUrl;
						item.parent().css({
							"background-image": "url(" + '${APP_PATH }/static/img/reviewAllImg/' + returl + ")"
						});
					}
				});
			}
		}
		
		
		
	</script>
</body>

</html>