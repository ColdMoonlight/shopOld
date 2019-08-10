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
	<style>
		tr>td:nth-last-of-type(2),
		th>td:nth-last-of-type(2) {
			max-width: 100px;
		}
	</style>
</head>

<body>
	<div class="container">
		<div class="aside-bar"></div>
		<div class="main-body">
			<div class="main-box">
				<div class="header">
					<h2>活动品管理</h2>
					<span class="user" id="UEmailSession">*</span>
				</div>
				<div class="content">
					<div class="table-box">
						<!-- operator -->
						<div class="op">
							<a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i> 活动品列表</a>
							<a href="#" id="task_add_modal_btn" class="btn btn-primary" role="button"><i
									class="glyphicon glyphicon-plus"></i> 新增</a>
						</div>
						<!-- table-content -->
						<div class="table-content">
							<table class="table table-striped table-hover" id="task_table">
								<thead>
									<tr>
										<th>id</th>
										<th>活动品name</th>
										<th>活动品归属组</th>
										<th>产品id</th>
										<th>产品名称</th>
										<th>手机图</th>
										<th>PC端图</th>
										<th>启用状态</th>
										<th>同级别编号</th>
										<th>更改时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody> </tbody>
							</table>
						</div>
						<!-- 显示分页信息 -->
						<div class="row">
							<!--分页文字信息  -->
							<div class="col-md-6" id="page_info_area"></div>
							<!-- 分页条信息 -->
							<div class="col-md-6" id="page_nav_area">

							</div>
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
				url: "${APP_PATH}/MlbackActShowPro/getMlbackActShowProByPage",
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
			$.each(task, function (index, item) {
				
				var actshowproActnum 
				
				var actshowproActStr = "";
				if (item.actshowproActnum == 1) {
					actshowproActStr = '首页活动';
				} else if (item.actshowproActnum == 2) {
					actshowproActStr = '第2活动';
				} else if (item.actshowproActnum == 3) {
					actshowproActStr = '第3活动';
				} else if (item.actshowproActnum == 4) {
					actshowproActStr = '第4活动';
				} else if (item.actshowproActnum == 5) {
					actshowproActStr = '第5活动';
				} else if (item.actshowproActnum == 99) {
					actshowproActStr = '第99活动';
				};
				
				var actshowproId = $("<td></td>").append(item.actshowproId);
				var actshowproName = $("<td></td>").append(item.actshowproName);
				var actshowproActnum = $("<td></td>").append(actshowproActStr);
				var actshowproProid = $("<td></td>").append(item.actshowproProid);
				var actshowproProname = $("<td></td>").append(item.actshowproProname);
				
				var imgurl = item.actshowproImgwapurl;
				var image = '<img src=' + imgurl + ' ' + 'width=50 height=50>';
				var actshowproImgwapurl = $("<td></td>").append(image);
				var imgurlpc = item.actshowproImgpcurl;
				var imagepc = '<img src=' + imgurlpc + ' ' + 'width=50 height=50>';
				var actshowproImgpcurl = $("<td></td>").append(imagepc);
				
				var actshowproStatus = $("<td></td>").append((item.actshowproStatus === 1 ? '已上架' : '未上架'));
				var actshowproOrderth = $("<td></td>").append(item.actshowproOrderth);
				var actshowproCreatetime = $("<td></td>").append(item.actshowproCreatetime);
				var actshowproMotifytime = $("<td></td>").append(item.actshowproMotifytime);
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个分类id
				editBtn.attr("edit-id", item.actshowproId);
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个分类id
				delBtn.attr("del-id", item.actshowproId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ");
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(actshowproId)
					.append(actshowproName)
					.append(actshowproActnum)
					.append(actshowproProid)
					.append(actshowproProname)
					.append(actshowproImgwapurl)
					.append(actshowproImgpcurl)
					.append(actshowproStatus)
					.append(actshowproOrderth)
					.append(actshowproMotifytime)
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
			loadTpl()
		});
		//新建/编辑任務提交按钮
		$(document).on('click', '#tasksubmit', function () {
			var data = $('form').serializeArray();
			data = JSON.stringify(data.reduce(function (obj, item) {
				obj[item.name] = item.value;
				return obj
			}, {}));
			$.ajax({
				url: "${APP_PATH}/MlbackActShowPro/save",
				data: data,
				dataType: "json",
				contentType: 'application/json',
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						alert('添加成功！');
						window.location.href = "${APP_PATH}/MlbackActShowPro/toMlbackActShowProPage";
					}
				}
			});
		});
		//删除任務
		$("#task_table").on("click", ".btn-danger", function () {
			var data = {
					actshowproId: $(this).attr('del-id')
			};
			$.ajax({
				url: "${APP_PATH}/MlbackActShowPro/delete",
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
		var CategoryHash = {}
		// 获取归属类下拉
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
						// console.log(objparentList);
						var categoryIdSelect = $('#actshowproProid');
						setCategoryDescSelect(categoryIdSelect, objparentList);
					} else {
						alert("联系管理员");
					}
				}
			});
		}

		function loadTpl() {
			$('.table-box').load('${APP_PATH}/static/tpl/addActShowPro.html', function () {
				// 设置归属类
				getCategoryDown();
			});
		}

		//编辑任务
		$("#task_table").on("click", ".edit_btn", function () {
			// tab tpl
			loadTpl()
			// 设置归属类
			getCategoryDown();
			// fetch data
			data = {
				"actshowproId": $(this).attr('edit-id')
			};
			$.ajax({
				url: "${APP_PATH}/MlbackActShowPro/getOneMlbackActShowProDetail",
				data: data,
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						obj = result.extend.mlbackActShowProOne;
						// console.log(obj);
						tianchong(obj);
					} else {
						alert("联系管理员");
					}
				}
			});

			function tianchong(data) {
				$(":input[name='actshowproId']").val(data.actshowproId);
				$(":input[name='actshowproName']").val(data.actshowproName);
				$(":input[name='actshowproActnum']").val(data.actshowproActnum);
				$(":input[name='actshowproProid']").val(data.actshowproProid);
				$(":input[name='actshowproProname']").val(data.actshowproProname);
				if (data.actshowproImgwapurl && data.actshowproImgwapurl.length) {
					var el = $(".upload-img-btn.img");
					el.attr("style", "background-repeat: no-repeat; background-position: center; background-size: 100%;");
					setImage(el, data.actshowproImgwapurl);
				}
				if (data.actshowproImgpcurl && data.actshowproImgpcurl.length) {
					var el2 = $(".upload-img-btn.img2");
					el2.attr("style", "background-repeat: no-repeat; background-position: center; background-size: 100%;");
					setImage(el2, data.actshowproImgpcurl);
				}
				$(":input[name='actshowproStatus']").val(data.actshowproStatus);
				$(":input[name='actshowproOrderth']").val(data.actshowproOrderth);
			}

		});

		$(document.body).on("change", "#file1", upload);
		$(document.body).on("change", "#file2", uploadMainFu);

		function upload() {
			var self = this;
			var obj = new FormData();
			obj.append('file', $(this)[0].files[0]);
			var actshowproIdUP = $(":input[name='actshowproId']").val();
			//console.log("categoryIdUP:"+categoryIdUP);
			if (actshowproIdUP == '') {
				//如果没有pid,弹出"请先输入产品名，保存后再次进入"
				// console.log("productIdUP:"+productIdUP);
				alert("请先输入类名，保存后从编辑进入");
			} else {
				obj.append('actshowproId', actshowproIdUP);
				$.ajax({
					url: "${APP_PATH}/UpImg/uploadActShowProWapImg",
					type: "post",
					dataType: "json",
					cache: false,
					data: obj,
					processData: false, // 不处理数据
					contentType: false, // 不设置内容类型
					success: function (data) {
						// 设置背景为我们选择的图片
						// console.log(data);
						var returl = data.extend.uploadUrl;
						// $(self).parent().css({ "background-image": "url("+'${APP_PATH }/static/img/category/'+returl+")" });  
						setImage($(self).parent(), returl);
					}
				});
			}
		}

		function setImage(el, url) {
			var img = new Image();
			url = url.indexOf('://') > -1 ? url : '${APP_PATH }/static/img/actShowPro/' + url;
			img.src = url;
			img.onload = function () {
				console.log(img.width)
				el.css({
					'width': img.width + 'px',
					'backgroundImage': 'url(' + url + ')'
				});
			}
		}

		function uploadMainFu() {
			var self = this;
			//实例化一个FormData
			var obj = new FormData();
			obj.append('file', $(this)[0].files[0]);
			// console.log($(this)[0].files[0])
			var actshowproIdUP = $(":input[name='actshowproId']").val();
			if (actshowproIdUP == "") {
				// 如果没有pid,弹出"请先输入产品名，保存后再次进入"
				// console.log("productIdUP:"+productIdUP);
				alert("请先输入产品名，保存后从编辑进入");
			} else {
				obj.append('actshowproId', actshowproIdUP);
				$.ajax({
					url: "${APP_PATH}/UpImg/uploadActShowProPcImg",
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
						// $(self).parent().css({ "background-image": "url("+'${APP_PATH }/static/img/category/'+returl+")" });
						setImage($(self).parent(), returl);
					}
				});
			}
		}
	</script>
</body>

</html>