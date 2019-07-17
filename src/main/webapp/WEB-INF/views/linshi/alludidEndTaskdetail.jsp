<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/css/main.css">
<link rel="stylesheet" href="${APP_PATH }/static/css/table.css">
<style>
   #page_info_area{
    height:74px;
    padding-top:26px;
  }
  #page_nav_area{
   height:74px;
  } 
</style>
</head>
<body>
<div class="container">
	<div class="aside-bar">
	    <ul>
	        <li><a href="${APP_PATH }/HomePage/toHomePage"> <i class="glyphicon glyphicon-home"></i> 首页</a> </li>
	        <li class="active"><a href="#"> <i class="glyphicon glyphicon-search"></i> 商务介入列表</a> </li>
	        <li><a href="${APP_PATH }/groupDisplay/toGroupDisplayPage"> <i class="glyphicon glyphicon-stats"></i> 发布任务列表</a> </li>
	        <li><a href="#"> <i class="glyphicon glyphicon-stats"></i> 外放列表</a> </li>
	        <li><a href="#"> <i class="glyphicon glyphicon-stats"></i> 操作列表</a> </li>
	        <li><a href="${APP_PATH }/HomePage/toMoneyOutApplyPage"> <i class="glyphicon glyphicon-stats"></i> 打款申请列表</a></li>
	        <li><a href="${APP_PATH }/HomePage/toAllEndTaskPage"> <i class="glyphicon glyphicon-stats"></i> 用户完成记录列表</a></li>
	    </ul>
	</div>
	<div class="main-body">
	    <div class="main-box">
	        <div class="header">
	            <h2>个人完成任务明细页</h2> 
	            <span class="user">admin</span>
	            <input type="hidden" value="${pn }" id="method1">
	            <input type="hidden" value="${userworkUdid }" id="method2">
	        </div>
	        <div class="content">
	            <div class="table-box">
	                <!-- operator -->
	                <div class="op">
	                    <a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i> 用户完成列表</a>
	                </div>
	                <!-- table-content -->
	                <div class="table-content">
	                    <table class="table table-striped table-hover" id="task_table">
	                        <thead>
	                            <tr>
	                                <th>任务ID</th>
	                                <th>用户UDID</th>
	                                <th>任务佣金</th>
	                                <th>完成时间</th>
	                             
	                            </tr>
	                        </thead>
	                        <tbody>
	                        </tbody>
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

<script>
	$(function() {
	    $('#add-modal').on('show.bs.modal', function (event) {
	        var button = $(event.relatedTarget)
	        var modal = $(this)
	    })
	})
</script>
<script type="text/javascript">
	var totalRecord,currentPage,editid;
	//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
	$(function(){
		//去首页
		to_page(1);
	});
	function to_page(pn){
	 	var userworkUdidGet = $("#method2").val();
	  //  var json = 'pn='+'1'+'&'+'userworkUdid='+userworkUdidGet;
		$.ajax({
			url:"${APP_PATH}/userWork/udidEndTaskDetail",
			data:"pn="+pn+'&'+'userworkUdid='+userworkUdidGet,
			type:"POST",
			success:function(result){
				console.log(result);
				//1、解析并显示员工数据
				build_task_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
			}
		});
	}
	function build_task_table(result){
		//清空table表格
		$("#task_table tbody").empty();
		var task = result.extend.pageInfo.list;
		$.each(task,function(index,item){
			//var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
			var userworkGroupdisplayIdTd = $("<td></td>").append(item.userworkGroupdisplayId);
			var userworkUdidTd = $("<td></td>").append(item.userworkUdid);
			var userworkPriceTd = $("<td></td>").append(item.userworkPrice);
			var userworkReceivetimeTd = $("<td></td>").append(item.userworkReceivetime);
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("查看所有");
				//为编辑按钮添加一个自定义的属性，来表示当前员工id
				editBtn.attr("userMsg",JSON.stringify(item));
				var btnTd = $("<td></td>").append(editBtn);
					$("<tr></tr>").append(userworkGroupdisplayIdTd)
				.append(userworkUdidTd)
				.append(userworkPriceTd)
				.append(userworkReceivetimeTd)
			
				.appendTo("#task_table tbody");
		});
	}
	//解析显示分页信息
	function build_page_info(result){
		$("#page_info_area").empty();
		$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
				result.extend.pageInfo.pages+"页,总"+
				result.extend.pageInfo.total+"条记录");
		totalRecord = result.extend.pageInfo.total;
		currentPage = result.extend.pageInfo.pageNum;
	}
	//解析显示分页条，点击分页要能去下一页....
	function build_page_nav(result){
		//page_nav_area
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");
		
		//构建元素
		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if(result.extend.pageInfo.hasPreviousPage == false){
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		}else{
			//为元素添加点击翻页的事件
			firstPageLi.click(function(){
				to_page(1);
			});
			prePageLi.click(function(){
				to_page(result.extend.pageInfo.pageNum -1);
			});
		}
		
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
		if(result.extend.pageInfo.hasNextPage == false){
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		}else{
			nextPageLi.click(function(){
				to_page(result.extend.pageInfo.pageNum +1);
			});
			lastPageLi.click(function(){
				to_page(result.extend.pageInfo.pages);
			});
		}
		
		//添加首页和前一页 的提示
		ul.append(firstPageLi).append(prePageLi);
		//1,2，3遍历给ul中添加页码提示
		$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
			
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if(result.extend.pageInfo.pageNum == item){
				numLi.addClass("active");
			}
			numLi.click(function(){
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
	//查看详情操作
	 $("#task_table").on("click",".edit_btn", function() {
	 	var userworkUdidGet = $("#method2").val();
	   // alert("pnGet:"+pnGet+",userworkUdidGet:"+userworkUdidGet);
		//var data = JSON.parse($(this).attr('userMsg'));
		var json = 'pn='+'1'+'&'+'userworkUdid='+userworkUdidGet;
		console.log(json);
	 
	 });

</script>
</body>
</html>