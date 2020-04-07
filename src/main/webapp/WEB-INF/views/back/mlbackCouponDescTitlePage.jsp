<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>优惠券title管理</title>
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
		<div class="aside-bar nicescroll">
			<jsp:include page="leftnav.jsp"></jsp:include>
		</div>
		<div class="main-body">
			<div class="main-box nicescroll">
				<div class="header">
					<h2>优惠券title列表</h2>
					<span class="user" id="UEmailSession">*</span>
				</div>
				<div class="content">
					<div class="table-box">
						<!-- operator -->
						<div class="op">
							<a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i>优惠券title列表</a>
							<a href="#" id="task_add_modal_btn" class="btn btn-primary" role="button"><i
									class="glyphicon glyphicon-plus"></i> 新增</a>
						</div>
						<!-- table-content -->
						<div class="table-content">
							<table class="table table-striped table-hover" id="task_table">
								<thead>
									<tr>
										<th>id</th>
										<th>标题name</th>
										<th>标题namedeatil</th>
										<th>手机图</th>
										<th>wap是否有效</th>
										<th>PC端图</th>
										<th>pc是否有效</th>
										<th>创建时间</th>
										<th>修改时间</th>
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

	<script type="text/javascript" src="${APP_PATH }/static/back/js/jquery-nicescroll.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/back/js/sidenav.js"></script>

	<script type="text/javascript">
		var adminAccname = '${sessionScope.AdminUser.adminAccname}';
		$("#UEmailSession").html(adminAccname);
	</script>

	<script type="text/javascript">
		$('.nicescroll').each(function(i, item) {
			$(item).niceScroll({
				cursorcolor: "rgba(0,0,0,.3)",
				cursorwidth: "14px",
				cursorborder: "none",
				horizrailenabled: false,
				enablekeyboard: false,
	    }).resize()
		});
		var totalRecord, currentPage, editid;
		var count = 1;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		$(function () {
			//去首页
			to_page(1);
		});

		function to_page(pn) {
			$.ajax({
				url: "${APP_PATH}/MlbackCouponDescTitle/getMlbackCouponDescTitleByPage",
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
				
				var coupondesctieleId = $("<td></td>").append(item.coupondesctieleId);
				var coupondesctieleName = $("<td></td>").append(item.coupondesctieleName);
				var coupondesctieleTieledetail = $("<td></td>").append(item.coupondesctieleTieledetail);
				
				var coupondesctieleWapstatus = $("<td></td>").append((item.coupondesctieleWapstatus == 1 ? '生效' : '不生效'));
				var coupondesctielePcstatus = $("<td></td>").append((item.coupondesctielePcstatus == 1 ? '生效' : '不生效'));
				var imgurl = item.coupondesctieleWapimgurl;
				var image = '<img src=' + imgurl + ' ' + 'width=50 height=50>';
				var coupondesctieleWapimgurl = $("<td></td>").append(image);
				var imgurlpc = item.coupondesctielePcimgurl;
				var imagepc = '<img src=' + imgurlpc + ' ' + 'width=50 height=50>';
				var coupondesctielePcimgurl = $("<td></td>").append(imagepc);
				var coupondesctieleCreatetime = $("<td></td>").append(item.coupondesctieleCreatetime);
				var coupondesctieleMotifytime = $("<td></td>").append(item.coupondesctieleMotifytime);
				
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个分类id
				editBtn.attr("edit-id", item.coupondesctieleId);
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个分类id
				delBtn.attr("del-id", item.coupondesctieleId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ");
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(coupondesctieleId)
					.append(coupondesctieleName)
					.append(coupondesctieleTieledetail)
					.append(coupondesctieleWapimgurl)
					.append(coupondesctieleWapstatus)
					.append(coupondesctielePcimgurl)
					.append(coupondesctielePcstatus)
					.append(coupondesctieleCreatetime)
					.append(coupondesctieleMotifytime)
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
				url: "${APP_PATH}/MlbackCouponDescTitle/save",
				data: data,
				dataType: "json",
				contentType: 'application/json',
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						alert('添加成功！');
						window.location.href = "${APP_PATH}/MlbackCouponDescTitle/toMlbackCouponDescTitlePage";
					}
				}
			});
		});
		//删除任務
		$("#task_table").on("click", ".btn-danger", function () {
			$.ajax({
				url: "${APP_PATH}/MlbackCouponDescTitle/delete",
				data: JSON.stringify({ coupondesctieleId: $(this).attr('del-id') }),
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
		

		function loadTpl(id) {
			$('.table-box').load('${APP_PATH}/static/tpl/addCouponDescTitle.html', function () {
				// fetch data
				$.ajax({
					url: "${APP_PATH}/MlbackCouponDescTitle/getOneMlbackCouponDescTitleDetail",
					data: { "coupondesctieleId": id },
					type: "POST",
					success: function (result) {
						if (result.code == 100) {
							tianchong(result.extend.mlbackCouponDescTitleOne);
						} else {
							alert("联系管理员");
						}
					}
				});
			});
		}

		//编辑任务
		$("#task_table").on("click", ".edit_btn", function () {
			// tab tpl
			loadTpl($(this).attr('edit-id'));
		});

		function tianchong(data) {
			$(":input[name='coupondesctieleId']").val(data.coupondesctieleId);
			$(":input[name='coupondesctieleName']").val(data.coupondesctieleName);
			$(":input[name='coupondesctieleTieledetail']").val(data.coupondesctieleTieledetail);
			$(":input[name='coupondesctieleWapstatus']").val(data.coupondesctieleWapstatus);
			$(":input[name='coupondesctielePcstatus']").val(data.coupondesctielePcstatus);
			
			$(":input[name='coupondesctieleCreatetime']").val(data.coupondesctieleCreatetime);
			$(":input[name='coupondesctieleMotifytime']").val(data.coupondesctieleMotifytime);
			if (data.coupondesctieleWapimgurl && data.coupondesctieleWapimgurl.length) {
				var el = $(".upload-img-btn.img");
				el.attr("style", "background-repeat: no-repeat; background-position: center; background-size: 100%;");
				setImage(el, data.coupondesctieleWapimgurl);
			}
			if (data.coupondesctielePcimgurl && data.coupondesctielePcimgurl.length) {
				var el2 = $(".upload-img-btn.img2");
				el2.attr("style", "background-repeat: no-repeat; background-position: center; background-size: 100%;");
				setImage(el2, data.coupondesctielePcimgurl);
			}
			
		}

		$(document.body).on("change", "#file1", upload);
		$(document.body).on("change", "#file2", uploadMainFu);

		function upload() {
			var self = this;
			var obj = new FormData();
			obj.append('file', $(this)[0].files[0]);
			var coupondesctieleIdUP = $(":input[name='coupondesctieleId']").val();
			//console.log("categoryIdUP:"+categoryIdUP);
			if (coupondesctieleIdUP == '') {
				//如果没有pid,弹出"请先输入产品名，保存后再次进入"
				// console.log("productIdUP:"+productIdUP);
				alert("请先输入类名，保存后从编辑进入");
			} else {
				obj.append('coupondesctieleId', coupondesctieleIdUP);
				$.ajax({
					url: "${APP_PATH}/UpImg/uploadCouponDescTitleWapImg",
					type: "post",
					dataType: "json",
					cache: false,
					data: obj,
					processData: false, // 不处理数据
					contentType: false, // 不设置内容类型
					success: function (data) {
						// console.log(data);
						var returl = data.extend.uploadUrl;
						setImage($(self).parent(), returl);
					}
				});
			}
		}

		function setImage(el, url) {
			var img = new Image();
			url = url.indexOf('://') > -1 ? url : '${APP_PATH }/static/img/CouponDescTitle/' + url;
			img.src = url;
			img.onload = function () {
				var winW = $('#categoryTabContent').width();
				var imgW = img.width;
				var imgH = img.height;

				if (imgW >= winW) {
					el.css({
						'width': '100%',
						'height': Math.floor(img.height * $('#categoryTabContent').width() / img.width) + 'px',
						'backgroundImage': 'url(' + url + ')',
						'backgroundSize': '100%'
					});
				} else {
					el.css({
						'width': imgW + 'px',
						'height': imgH + 'px',
						'backgroundImage': 'url(' + url + ')',
						'backgroundSize': '100%'
					});
				}
			}
		}

		function uploadMainFu() {
			var self = this;
			//实例化一个FormData
			var obj = new FormData();
			obj.append('file', $(this)[0].files[0]);
			// console.log($(this)[0].files[0])
			var coupondesctieleIdUP = $(":input[name='coupondesctieleId']").val();
			if (coupondesctieleIdUP == "") {
				// 如果没有pid,弹出"请先输入产品名，保存后再次进入"
				// console.log("productIdUP:"+productIdUP);
				alert("请先输入产品名，保存后从编辑进入");
			} else {
				obj.append('coupondesctieleId', coupondesctieleIdUP);
				$.ajax({
					url: "${APP_PATH}/UpImg/uploadCouponDescTitlePcImg",
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