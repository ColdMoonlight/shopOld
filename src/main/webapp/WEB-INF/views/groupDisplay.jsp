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
<link rel="stylesheet" href="${APP_PATH }/static/css/daterangepicker.css">
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
	        <li><a href="${APP_PATH }/taskfrom/toProPage"> <i class="glyphicon glyphicon-search"></i> 商务介入列表</a> </li>
	        <li class="active"><a href="#"> <i class="glyphicon glyphicon-stats"></i> 发布任务列表</a> </li>
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
	                    <a href="#" class="btn btn-default" role="button"> <i class="glyphicon glyphicon-tasks"></i> 发布任务列表</a>
	                    <a href="#" id="task_add_modal_btn" class="btn btn-primary" role="button" data-toggle="modal" data-target="#add-modal"><i class="glyphicon glyphicon-plus"></i> 新增</a>
	                </div>
	                <!-- table-content -->
	                <div class="table-content">
	                    <table class="table table-striped table-hover" id="task_table">
	                        <thead>
	                            <tr>
	                            	<th>id</th>
	                            	<th>应用图标</th>
	                                <th>应用名</th>
	                                <th>来源平台</th>
	                                <th>appsotreid</th>
	                                <th>appsotre排名</th>
	                                <!-- <th>广告id</th> -->
	                                <th>任务要求</th>
	                                <th>商务</th>
	                                <th>总量</th>
	                                <th>余量</th>
	                                <th>发布时间</th>
	                                <th>开始时间</th>
	                                <th>状态</th>
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
	                <div class="form-group">
	                    <label for="groupSource" class="col-sm-2 control-label">来源:</label>
	                    <div class="col-sm-4">
	                        <input type="text" class="form-control" placeholder="请选择来源" name="groupSource">
	                    </div>
	                </div>
	                <!-- appstoreid -->
	                <div class="form-group">
	                    <label for="groupTaskName" class="col-sm-2 control-label">任务:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupTaskName" placeholder="groupTaskName"></input>
	                    </div>
	                </div>
	                <!-- task -->
	                <div class="form-group">
	                    <label for="groupAllnum" class="col-sm-2 control-label">任务量:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupAllnum" placeholder="groupAllnum"></input>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="groupAppstoreid" class="col-sm-2 control-label">Appstoreid:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupAppstoreid" placeholder="groupAppstoreid"></input>
	                    </div>
	                </div>
	                 
	                <div class="form-group">
	                    <label for="groupReqexplain" class="col-sm-2 control-label">要求:</label>
	                    <div class="col-sm-10">
	                        <select name="groupReqexplain" class="form-control">
							  <option value ="仅下载" selected="selected">仅下载</option>
							  <option value ="下载并试玩">下载并试玩</option>
							</select>
	                    </div>
	                </div>
	                <!-- ad -->
	                <div class="form-group">
	                    <label for="groupPrioritys" class="col-sm-2 control-label">排名:</label>
	                    <div class="col-sm-10">
				    	    <select name="groupPrioritys" class="form-control">
							  <option value ="1" selected="selected">1</option>
							  <option value ="2">2</option>
							  <option value ="3">3</option>
							  <option value ="4">4</option>
							  <option value ="5">5</option>
							  <option value ="6">6</option>
							  <option value ="7">7</option>
							  <option value ="8">8</option>
							  <option value ="9">9</option>
							  <option value ="10">10</option>
							</select>
	                    </div>
	                </div>
	                <!-- ad -->
	                <div class="form-group">
	                    <label for="appadid" class="col-sm-2 control-label">商务:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupPeople" placeholder="groupPeople"></input>
	                    </div>
	                </div>
	                <!-- 是否排重 -->
	                <div class="form-group">
	                    <label for="groupHowdownload" class="col-sm-2 control-label">下载:</label>
	                    <div class="col-sm-10 form-radio">
	                        <input type="radio" name="groupHowdownload" value="0">&nbsp;&nbsp;关键词</input>
	                        <input type="radio" name="groupHowdownload" value="1" checked>&nbsp;&nbsp;链接</input>
	                    </div>
	                </div>
	                <!-- ad -->
	                <div class="form-group">
	                    <label for="groupDownloadurl" class="col-sm-2 control-label">关键词/链接:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupDownloadurl" placeholder="appadid"></input>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="groupAppIdTh" class="col-sm-2 control-label">groupAppIdTh:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupAppIdTh" placeholder="groupAppIdTh"></input>
	                    </div>
	                </div>
	                <!-- ad -->
	                <div class="form-group">
	                    <label for="groupStarttime" class="col-sm-2 control-label">开始时间:</label>
	                    <div class="col-sm-10">
	                        <input id="startTime" class="form-control" name="groupStarttime" placeholder="开始时间"></input>
	                    </div>
	                </div>
	                <!-- ad -->
	                <div class="form-group">
	                    <label for="groupInprice" class="col-sm-2 control-label">商务价:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupInprice" placeholder="商务价"></input>
	                    </div>
	                </div>
	                <!-- ad -->
	                <div class="form-group">
	                    <label for="appadid" class="col-sm-2 control-label">用户价:</label>
	                    <div class="col-sm-10">
	                        <input class="form-control" name="groupOutprice" placeholder="用户价"></input>
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
<script src="${APP_PATH }/static/js/moment.min.js"></script>
<script src="${APP_PATH }/static/js/daterangepicker.js"></script>
<script>
	$(function() {
	       //定义locale汉化插件
        var locale = {
            "format": 'YYYY-MM-DD HH:mm:ss',
            "separator": "",
            "applyLabel": "确定",
            "cancelLabel": "取消",
            "fromLabel": "起始时间",
            "toLabel": "结束时间'",
            "customRangeLabel": "自定义",
            "weekLabel": "W",
            "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
            "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            "firstDay": 1
        };
        //初始化显示当前时间
        $('#startTime').val(moment(new Date()).format('YYYY-MM-DD HH:mm:ss'));
		$('#startTime').daterangepicker(
	            {
	                singleDatePicker: true,
	                showDropdowns: false,
	                autoUpdateInput: true,
	                timePicker24Hour : true,
	                timePicker : true,
	                drops:'up',
	                'locale': locale,
	            },
	            function (start, end) {
	               // $('#startTime').val(start.format('YYYY-MM-DD'));
	            }
	       );
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
			url:"${APP_PATH}/groupDisplay/getGroupDisplayByPage",
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
			var state = '';
			if(item.groupState == 0){
				state = '未发布';
			}else if(item.groupState == 1){
				state = '发布中';
			}else if(item.groupState == 2){
				state = '已终止';
			}else if(item.groupState == 3){
				state = '已完结';
			};
			var imgurl=item.groupPimageurl;
			var image = '<img src='+imgurl+' '+'width=40 height=40>';
			var groupPimageurl = $("<td></td>").append(image);
			var groupTaskName = $("<td></td>").append(item.groupTaskName);
			var groupId = $("<td></td>").append(item.groupId);
			var groupSource = $("<td></td>").append(item.groupSource);
			var groupAppstoreid = $("<td></td>").append(item.groupAppstoreid);
			var groupAppIdTh = $("<td></td>").append(item.groupAppIdTh);
			var taskAdIdTd = $("<td></td>").append('12345');
			var groupPeople = $("<td></td>").append(item.groupPeople);
			var groupAllnum = $("<td></td>").append(item.groupAllnum);
			var groupNownum = $("<td></td>").append(item.groupNownum);
			var groupCreatetime = $("<td></td>").append(item.groupCreatetime);
			var groupStarttime = $("<td></td>").append(item.groupStarttime);
			var groupReqexplain = $("<td></td>").append(item.groupReqexplain);
			var groupState = $("<td></td>").append(state);

			var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工id
			editBtn.attr("edit-id",JSON.stringify(item));
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("del-id",item.groupId);
			var startBtn =  $("<button></button>").addClass("btn btn-success btn-xs start_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-play")).append("开始");
				//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			startBtn.attr("start-id",item.groupId);
			var stopBtn =  $("<button></button>").addClass("btn btn-warning btn-xs stop_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-stop")).append("停止");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			stopBtn.attr("stop-id",item.groupId);
			var outBtn =  $("<button></button>").addClass("btn btn-default btn-xs out_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-log-out")).append("导出");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			outBtn.attr("out-id",item.groupId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ").append(startBtn).append(" ").append(stopBtn).append(" ").append(outBtn);
			//var delBtn = 
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(groupId)
				.append(groupPimageurl)
				.append(groupTaskName)
				.append(groupSource)
				.append(groupAppstoreid)
				.append(groupAppIdTh)
				/* .append(taskAdIdTd) */
				.append(groupReqexplain)
				.append(groupPeople)
				.append(groupAllnum)
				.append(groupNownum)
				.append(groupCreatetime)
				.append(groupStarttime)
				.append(groupState)
				.append(btnTd)
				.appendTo("#task_table tbody");
		});
	}
	
	"pageNum": 1,
    "pageSize": 10,
    "size": 8,
    "startRow": 1,
    "endRow": 8,
    "total": 8,
    "pages": 1,
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
	
	$('#task_add_modal_btn').click(function(){
		submit = 0;
	});
	//新建编辑任務提交按钮
	$('#tasksubmit').click(function(){
		var data = $('form').serializeArray();
		 console.log(data);
		if(submit == 1){
			data.push({"name":"groupId","value":editid})
			console.log(data);
			$.ajax({
	 			url:"${APP_PATH}/groupDisplay/update",
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
				url:"${APP_PATH}/groupDisplay/insert",
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
	});
	$('#task_add_modal_btn').click(function(){
		$(".modal-title").text('添加');
		$(":input[name='groupTaskName']").val('');
 		$(":input[name='groupSource']").val('');
 		$(":input[name='groupPrioritys']").val('');
 		$(":input[name='groupProple']").val('');
 		$(":input[name='groupStarttime']").val('');
 		$(":input[name='groupInprice']").val('');
 		$(":input[name='groupAllnum']").val('');
 		$(":input[name='groupAppstoreid']").val('');
 		$(":input[name='groupAppIdTh']").val('');
 		$(":input[name='groupOutprice']").val('');
 		$(":input[name='groupDownloadurl']").val('');
 		$("input[name='groupHowdownload']:eq(0)").prop("checked",'checked');
	})
	//删除任務
 	 $("#task_table").on("click",".btn-danger", function() {
 		 var data = 'groupId='+$(this).attr('del-id');
 		console.log(data);
 		$.ajax({
 				url:"${APP_PATH}/groupDisplay/delete",
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
 		 editid = data.groupId;
 		$(":input[name='groupTaskName']").val(data.groupTaskName);
 		$(":input[name='groupSource']").val(data.groupSource);
 		$(":input[name='groupPrioritys']").val(data.groupPrioritys);
 		$(":input[name='groupPeople']").val(data.groupPeople);
 		//$(":input[name='groupStarttime']").val(moment(data.groupCreatetime,'YYYY-MM-DD hh:mm:ss'));
 		$(":input[name='groupStarttime']").val(data.groupStarttime);
 		$(":input[name='groupInprice']").val(data.groupInprice);
 		$(":input[name='groupAllnum']").val(data.groupAllnum);
 		$(":input[name='groupOutprice']").val(data.groupOutprice);
 		$(":input[name='groupDownloadurl']").val(data.groupDownloadurl);
 		$(":input[name='groupAppstoreid']").val(data.groupAppstoreid);
 		$(":input[name='groupAppIdTh']").val(data.groupAppIdTh);
 		$('#add-modal').modal('show');
 		//if(data.taskIfclick == 1){
 		if(data.groupHowdownload == 0){
 			$("input[name='groupHowdownload']:eq(0)").prop("checked",'checked');
 		}else{
 			$("input[name='groupHowdownload']:eq(1)").prop("checked",'checked');
 		};
 	 });
 	//开始任务
 	$("#task_table").on("click",".start_btn", function() {
 		//var data = {"groupId":$(this).attr('start-id'),"groupState":"1"};
 		var data = 'groupState='+'1'+'&'+'groupId='+$(this).attr('start-id');
 		console.log(JSON.stringify(data))
 		var thiz = $(this);
 		if(thiz.parent().prev().text() == '发布中'){
 			return
 		};
 		$.ajax({
				url:"${APP_PATH}/groupDisplay/appLook",
				data:data,
				type:"post",
				success:function(result){
					if(result.code == 100){
						//alert('成功！');
						//console.log($(this).parent());
						thiz.parent().prev().text('发布中');
					}else{
						alert('操作失败！');
					}
				}
			});
 	})
 	//暂停任务
 	 	$("#task_table").on("click",".stop_btn", function() {
 		// var data = {"groupId":$(this).attr('stop-id'),"groupState":"0"};
 		var data = 'groupState='+'2'+'&'+'groupId='+$(this).attr('stop-id');
  		var thiz = $(this);
 		if(thiz.parent().prev().text() == '已终止'){
 			return
 		};
 		$.ajax({
				url:"${APP_PATH}/groupDisplay/appLookNo",
				data:data,
				type:"post",
				success:function(result){
					if(result.code == 100){
						//alert('成功！');
						thiz.parent().prev().text('已终止');
					}else{
						alert('操作失败！');
					}
				}
			});
 	})
</script>
</body>
</html>