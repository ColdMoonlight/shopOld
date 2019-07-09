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
	        <li><a href="${APP_PATH }/HomePage/toMoneyOutApplyPage"> <i class="glyphicon glyphicon-stats"></i> 打款申请列表</a> </li>
	        <li><a href="${APP_PATH }/HomePage/toAllEndTaskPage"> <i class="glyphicon glyphicon-stats"></i> 用户完成记录列表</a></li>
	    </ul>
	</div>
	<div class="main-body">
	    <div class="main-box">
	        <div class="header">
	            <h2>后台管理系统</h2>
	            <span class="user">admin</span>
	        </div>
	        <div class="content">
	            <div class="table-box">
	                <!-- operator -->
	                <div class="op">
	                    <a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i> 对接列表</a>
	                    <a href="#" id="task_add_modal_btn" class="btn btn-primary" role="button" data-toggle="modal" data-target="#add-modal"><i class="glyphicon glyphicon-plus"></i> 新增</a>
	                </div>
	                <!-- table-content -->
	                <div class="table-content">
	                    <table class="table table-striped table-hover" id="task_table">
	                        <thead>
	                            <tr>
	                                <th>应用名</th>
	                                <th>id</th>
	                                <th>来源平台</th>
	                                <th>appsotreid</th>
	                                <th>广告id</th>
	                                <th>发布时间</th>
	                                <th>操作</th>
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
<!-- add modal -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="addItem">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
            <form class="form-horizontal">
                <!-- from -->
                <!-- task -->
              	<div class="form-group">
                    <label for="taskname" class="col-sm-2 control-label">应用名:</label>
                    <div class="col-sm-10">
                        <input class="form-control" name="taskName" placeholder="如:欢乐牛牛"></input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="from" class="col-sm-2 control-label">来源:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" placeholder="如:赚8" name="taskSource">
                    </div>
                </div>
                <!-- appstoreid -->
                <div class="form-group">
                    <label for="appsotreid" class="col-sm-2 control-label">appsotreid:</label>
                    <div class="col-sm-10">
                        <input class="form-control" name="taskAppstoreId" placeholder="appsotreid"></input>
                    </div>
                </div>
                <!-- ad -->
                <div class="form-group">
                    <label for="appadid" class="col-sm-2 control-label">广告ID:</label>
                    <div class="col-sm-10">
                        <input class="form-control" name="taskAdId" placeholder="appadid"></input>
                    </div>
                </div>
                <!-- 是否排重 -->
                <div class="form-group">
                    <label for="isReport" class="col-sm-2 control-label">是否排重:</label>
                    <div class="col-sm-10 form-radio">
                        <input type="radio" name="taskIfonly" value="0">&nbsp;&radic;&nbsp;否</input>
                        <input type="radio" name="taskIfonly" value="1" checked>&nbsp;&Chi;&nbsp;是</input>
                    </div>
                </div>
                <!-- 是否点击 -->
                <div class="form-group">
                    <label for="isReport" class="col-sm-2 control-label">是否点击:</label>
                    <div class="col-sm-10 form-radio">
                        <input type="radio" name="taskIfclick" value="0">&nbsp;&radic;&nbsp;否</input>
                        <input type="radio" name="taskIfclick" value="1" checked>&nbsp;&Chi;&nbsp;是</input>
                    </div>
                </div>
                <!-- 是否上报 -->
                <div class="form-group">
                    <label for="isReport" class="col-sm-2 control-label">是否上报:</label>
                    <div class="col-sm-10 form-radio">
                        <input type="radio" name="taskIfreport" value="0">&nbsp;&radic;&nbsp;否</input>
                        <input type="radio" name="taskIfreport" value="1" checked>&nbsp;&Chi;&nbsp;是</input>
                    </div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary bianji" id="tasksubmit">确定</button>
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
	var totalRecord,currentPage,submit=0,editid;
	//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
	$(function(){
		//去首页
		to_page(1);
	});
	function to_page(pn){
		$.ajax({
			url:"${APP_PATH}/taskfrom/getTaskByPage",
			data:"pn="+pn,
			type:"GET",
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
			var taskNameTd = $("<td></td>").append(item.taskName);
			var taskIdTd = $("<td></td>").append(item.taskId);
			var taskSourceTd = $("<td></td>").append(item.taskSource);
			var taskAppstoreIdTd = $("<td></td>").append(item.taskAppstoreId);
			var taskAdIdTd = $("<td></td>").append(item.taskAdId);
			var taskCreatimeTd = $("<td></td>").append(item.taskCreatime);

			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工id
			editBtn.attr("edit-id",JSON.stringify(item));
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("del-id",item.taskId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			//var delBtn = 
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(taskNameTd)
				.append(taskIdTd)
				.append(taskSourceTd)
				.append(taskAppstoreIdTd)
				.append(taskAdIdTd)
				.append(taskCreatimeTd)
				.append(btnTd)
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
	//新建任務
	$('#tasksubmit').click(function(){
		var data = $('form').serializeArray();
		// console.log(data);
		if(submit == 1){
			data.push({"name":"taskId","value":editid})
			console.log(data);
			$.ajax({
	 			url:"${APP_PATH}/taskfrom/update",
	 			data:data,
	 			type:"POST",
	 			success:function(result){
	 				if(result.code == 100){
	 					alert('编辑成功！');
	 					$('#add-modal').modal('hide');
	 					to_page(1);
	 				}
	 			}
	 		});
		}else{
			$.ajax({
				url:"${APP_PATH}/taskfrom/insert",
				data:data,
				type:"POST",
				success:function(result){
					if(result.code == 100){
						alert('添加成功！');
						$('#add-modal').modal('hide');
						to_page(1);
					}
				}
			});
		}
		submit == 0;
	});
	$('#task_add_modal_btn').click(function(){
		$(".modal-title").text('添加');
		$(":input[name='taskSource']").val('');
 		$(":input[name='taskName']").val('');
 		$(":input[name='taskAdId']").val('');
 		$("input[name='taskIfreport']:eq(1)").prop("checked",'checked');
 		$("input[name='taskIfonly']:eq(1)").prop("checked",'checked');
 		$("input[name='taskIfclick']:eq(1)").prop("checked",'checked');
	})
	//删除任務
 	 $("#task_table").on("click",".btn-danger", function() {
 		 var data = 'taskId='+$(this).attr('del-id');
 		console.log(data);
 		$.ajax({
 				url:"${APP_PATH}/taskfrom/delete",
 				data:data,
 				type:"post",
 				success:function(result){
 					if(result.code == 100){
 						alert('删除成功！');
 						to_page(1);
 					}
 				}
 			});
 	 });
 	//编辑任务
 	 $("#task_table").on("click",".edit_btn", function() {
 		 submit = 1;
 		$(".modal-title").text('编辑');
 		 var data = JSON.parse($(this).attr('edit-id'));
 		 console.log(data);
 		 editid = data.taskId;
 		$(":input[name='taskSource']").val(data.taskSource);
 		$(":input[name='taskName']").val(data.taskName);
 		$(":input[name='taskAppstoreId']").val(data.taskAppstoreId);
 		$(":input[name='taskAdId']").val(data.taskAdId);
 		$('#add-modal').modal('show');
 		if(data.taskIfclick == 1){
 			$("input[name='taskIfclick']:eq(0)").prop("checked",'checked');
 		}else{
 			$("input[name='taskIfclick']:eq(1)").prop("checked",'checked');
 		};
 		if(data.taskIfonly == 1){
 			$("input[name='taskIfonly']:eq(0)").prop("checked",'checked');
 		}else{
 			$("input[name='taskIfonly']:eq(1)").prop("checked",'checked');
 		};
 		if(data.taskIfreport == 1){
 			$("input[name='taskIfreport']:eq(0)").prop("checked",'checked');
 		}else{
 			$("input[name='taskIfreport']:eq(1)").prop("checked",'checked');
 		} 
 	 });
</script>
</body>
</html>