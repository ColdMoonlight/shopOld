<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MEGALOOK</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<link rel="shortcut icon" href="${APP_PATH }/static/pc/img/favicon1.ico" />
	<link rel="stylesheet" href="${APP_PATH }/static/pc/css/theme.css">
	<link rel="stylesheet" href="${APP_PATH }/static/pc/css/main.css">
	<link rel="stylesheet" href="${APP_PATH }/static/pc/css/new.css">
	
	<!-- Global site tag (gtag.js) - Google Analytics 生产-->
 	<!-- <script async src="https://www.googletagmanager.com/gtag/js?id=UA-145178467-1"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());
	
	  gtag('config', 'UA-145178467-1');
	</script> -->
	
	
	<!-- Global site tag (gtag.js) - Google Analytics 测试-->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-148326913-1"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());
	
	  gtag('config', 'UA-148326913-1');
	</script>
	
</head>

<body>
	<!-- <div class="fixed_link"><a href="${APP_PATH}/Activty.html"></a></div> -->
	<header>
		<!-- tt-desktop-header -->
		<div class="tt-desktop-header">
			<!-- <div class="img_show">
				<a href="${APP_PATH}/Activty.html"><img src="${APP_PATH }/static/pc/huodong/pcban.png" /></a> 
				<div class="img_show_cont">
					<a href="javascript:;"></a>
				</div>
			</div> -->
			<!-- account tip language -->
<!-- 			<a class="logosmall" href="${APP_PATH}/index.html">
				<img src="${APP_PATH }/static/m/img/index/logo.png" alt="">
			</a> -->
			<!-- <div class="alinktop"><a href="${APP_PATH}/Activty.html"><img src="${APP_PATH }/static/pc/img/tp.jpg" ></a></div> -->
		   <div class="logo_search">
			   	<div class="container head_box">
				<!-- search logo cart -->
				<div class="header_holder">
					<div class="logo">
						<a href="${APP_PATH}/index.html">
							 <img src="${APP_PATH }/static/m/img/index/logo.png" alt="">
						</a>
					</div>
					 <div class="serch_cont">
						<div class="serch_box">
							<div class="tt-col">
								<input type="text" class="tt-search-input" placeholder="Search Products..." />
								<button class="tt-btn-search" type="submit"></button>
							</div>
							<ul class="show_ul">
								<li>bob</li>
								<li>wigs</li>
								<li>bundle</li>
								<li>wig 613</li>
								<li>Water Wave</li>
							</ul>
						</div>
					 </div>
					 <div class="loginbox">
						<div class="tt-desctop-parent-account tt-parent-box person">
							<div class="tt-account tt-dropdown-obj">
								<button class="tt-dropdown-toggle" data-tooltip="My Account" data-tposition="bottom">
									<i class="icon-f-94"></i>
								</button>
							</div>
						</div>
					 </div>
				</div>
				</div>
		   </div>
			<div class="container head_box">
				
				
				<!-- tt-menu -->
				<div class="tt-desctop-parent-menu tt-parent-box">
					<div class="tt-desctop-menu">
						<nav>
							<ul>
							</ul>
						</nav>
						<div class="sendnav"></div>
					</div>
					<a class="logosmall" href="${APP_PATH}/index.html"><img src="${APP_PATH }/static/m/img/index/logo.png" alt=""></a>
				</div>
				<!-- /tt-menu -->
			</div>
		</div>
	</header>
	<div class="fix_iconnav">
		<ul class="icon_nav">
			<li id="cart_icon" class="cart_icon"><a href="###"></a><span class="cart_num">0</span></li>
			<li class="go_top"><a href="###"></a></li>
		</ul>
	</div>

	
	
	<script src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<script src="${APP_PATH }/static/pc/js/jquery.fly.min.js"></script>
	<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script>
       $(function(){
		   MenuSenondnav()
		    //定义一个变量用来记录li宽度的累加值
		       var sumWidth=0;
		       //假设$("li")返回的就是这3个li
		       $(".dropdown").each(function(){
		           sumWidth += $(this).outerWidth();
		       });
			   if(sumWidth>1300){
				   $(".head_box").addClass("active")
			   }
		   
		   
		   $(".img_show_cont a").click(function(){
			 $(".img_show").animate({ 
			    height: "0", 
			  }, 100);
		   })
		   		$(".go_top").click(function(){
					$("body,html").animate({scrollTop:0},500);  
					   return false;
				   });
			   $(window).scroll(function(){
				   // var scrollhead=$(window).scrollTop();
				   // if(scrollhead>5){
					  //  $(".tt-desktop-header").addClass("headActive")
				   // }else{
					  //  $(".tt-desktop-header").removeClass("headActive")
				   // }
				/**************************/
				var winS=$(this).scrollTop();
				if(winS>0){
					$(".go_top").show();
					// $('.serch_cont').slideUp(200);
				}else{
					$(".go_top").hide();
				}
			   });
			   /***************************************/
	   })
		var categoryActiveNum = 1;
		var iCart = $('.cart_icon');
		var iPerson = $('.person');
		var mask = $('<div class="mask"></div>');
		var sysFlag = 0;
		function renderErrorMsg(parent, msg) {
			  parent.html('<p class="without-data">' + msg + '</p>');
		}
    function renderSysMsg(msg) {
    	var elBox = $('<div class="modal sys-box pc_tanc" style="display: block;"></div>');
    	
    	var html = '<div class="sys-title">' +
    		'<span class="icon close"></span>' +
    	'</div>' +
    	'<div class="sys-body"><p>'+ msg +'</p></div>';
 
    	$(document.body).append(elBox.html(html));
    	$(document.body).append(mask)
    	
    	$('.sys-box .close').on('click', function() {
    		$('.sys-box').remove();
    		$('.mask').remove();
    		sysFlag = !sysFlag;
    	});
    }
			function toNumber(val) {
			  var n = parseFloat(val);
			  return isNaN(n) ? 0 : n
			}

		function renderMainCategory(parent, data) {
			var html = '';
			for (var i in data) {
				var categoryLableInt = data[i].categoryLable;
				var	classimg = "";
				if(categoryLableInt == 0){
					classimg = "classimg0";
				}else if(categoryLableInt == 1){
					classimg = "classimg1";
				}else if(categoryLableInt == 2){
					classimg = "classimg2";
				}else if(categoryLableInt == 3){
					classimg = "classimg3";
				}else if(categoryLableInt == 4){
					classimg = "classimg4";
				}
				var iddata =data[i].categoryId;
				var no_show=""
				if(iddata==7){
						no_show="hide";
						html += '<li class="dropdown megamenuid megamenu '+classimg+'" categoryId-id="'+data[i].categoryId+'">'+
						'<a href="${APP_PATH}/Category/49.html">' + data[i].categoryName + '</a>';
				}else{
					html += '<li class="dropdown megamenuid megamenu '+classimg+'" categoryId-id="'+data[i].categoryId+'">'+
					'<a href="${APP_PATH}/search/' + data[i].categorySeo + '.html">' + data[i].categoryName + '</a>';
				}
				html +='<div class="dropdown-menu '+no_show+'">' +
					'</div>';
			}
			parent.html(html);
			
		}
		var mainCategory = $('.tt-desctop-menu ul');
		var categoryData = {};
		// 获取全部的category信息,文件信息
		$.ajax({
			url: '${APP_PATH}/MlbackCategory/getCategoryMenu',
			method: 'GET',
			success: function (data) {
				console.log(data)
				var resData = data.extend.mlbackCategorydownFirst;
				// console.log(resData);/**********resData*********/
				if (data.code === 100) {
					categoryData = resData.reduce(function (obj, item) {
						if (item.categoryParentId === -1) {
							item.list = obj.hasOwnProperty(item.categoryId) && obj[item.categoryId].hasOwnProperty('list') ?
								obj[item.categoryId].list : [];
							obj[item.categoryId] = item;
							return obj;
						} else {
							if (!obj[item.categoryParentId]) {
								obj[item.categoryParentId] = {}
							}
							if (!obj[item.categoryParentId].list) {
								obj[item.categoryParentId].list = []
							}
							obj[item.categoryParentId].list.push(item);
							return obj;
						}
					}, {});
					//console.log(categoryData)
					renderMainCategory(mainCategory, categoryData);
				} else {
					renderErrorMsg(prodcutBox, '未获取到目录相关的数据');
				}
			}
		})
		/**********************************************************/
		function MenuSenondnav(){
			function renderMainCategorythreenav(parent, data) {
				var html = '';
				for (var i in data) {
					html +='<ul class="">sdfsdfsdfsdf</ul>';
				}
			}
			$(".megamenuid").on("mouseover",function(){
				var mainCategorythree =$(".sendnav")
				
				var dropdown_categoryid= $(this).attr('categoryid-id');
				console.log(dropdown_categoryid)
				/* category condition */
				 $.ajax({
				   url: '${APP_PATH}/MlbackCategory/getCategoryMenuSenond',
				   data: JSON.stringify({
				     "categoryParentId":dropdown_categoryid
				   }),
				   type: 'post',
				   dataType: 'JSON',
				   contentType: 'application/json',
				   success: function (data) {
				       console.log("***********data = JSON.parse(data);*************")
				       console.log(data.extend.mlbackCategoryfirstdownList);
				       console.log("***********data = JSON.parse(data);*************")
					   
					   
					   
					   var datathreenav =data.extend.mlbackCategoryfirstdownList;
					   renderMainCategorythreenav(mainCategorythree,datathreenav)
					   
					   
					   
				   }
				 });
				
			});
			
			
		}
		
		
		
		 
		
		
		
	
		
		
		
		
		
		
		
		
		
	 // function mainCategoryTrigger() {
		//   var activeItem = mainCategory.find('.active');
		//   var items = mainCategory.find('.category-item');
		
		//   items.each(function (i, item) {
		//     $(item).on('click', function () {
		//       activeItem.removeClass('active');
		//       $(this).addClass('active');
		//       activeItem = $(this);
		//       var data = categoryData[$(this).data('id')];
		//       renderSubCategory(subCategory, data);
		// 	 	//  var iddata =data.categoryId;
		// 		 // if(iddata==7){
		// 			// window.location.href = "${APP_PATH }/Category/49.html";
		// 		 // }
		//     })
		//   })
		// }
		 //    function renderSubCategory(parent, data) {
			//   parent.find('.title .name').text(data.categoryName);
			//   var html = '';
			//   if (data.list && data.list.length) {
			
			// 	for (var i = 0; i < data.list.length; i += 1) {
			// 	  html += '<div class="sub-category-product">' +
			// 		'<a href="${APP_PATH}/MlbackCategory/toproductlist?categoryId=' + data.list[i].categoryId + '">' +
			// 		'<div class="product-img">' +
			// 		'<img src="' + data.list[i].categoryImgurl + '" alt="">' +
			// 		'</div>' +
			// 		'<span class="product-name">' + data.list[i].categoryName + '</span>' +
			// 		/* '<span class="product-name">' + data.list[i].categoryDesc + '</span>'+ */
			
			// 		'</a>' +
			// 		'</div>';
			// 	}
			// 	parent.find('.body').html(html);
			//   } else {
			// 	renderErrorMsg(parent.find('.body'), 'Related products have been removed！')
			//   }
			
			//   parent.parent().addClass('active');
			// }
		
		// cart icon default number
		var cartText = iCart.find('.cart_num');
		var num = window.localStorage.getItem('productNum') || 0;
		
		$.ajax({
		  url: '${APP_PATH}/MlbackCart/getCartProductNumber',
		  type: 'POST',
		  success: function (data) {
		    cartText.text(parseInt(data.extend.number) || 0);
		  }
		})
		iCart.on('click', function () {
		  window.location.href = "${APP_PATH }/myCart.html";
		})
		iPerson.on('click', function () {
		  if ($(this).hasClass('active')) {
		    window.location.href = "${APP_PATH }/MlfrontUser/topcUserCenter";
		  } else {
		    window.location.href = "${APP_PATH }/MlfrontUser/toPcLoginRegisterPage";
		  }
		})
		 /* check user is login or not  */
		$.ajax({
		  url: "${APP_PATH }/MlfrontUser/ifLogin",
		  type: 'POST',
		  success: function (data) {
		    // console.log(data);
		    var resData = data.extend;
		
		    if (resData.ifLogin === 1) {
		      if (!iPerson.hasClass('active')) iPerson.addClass('active')
		    }
		
		    if (resData.ifLogin === 0) {
		      if (iPerson.hasClass('active')) iPerson.removeClass('active')
		    }
		  }
		})
		
		/* check user is login or not  */
		  function toProductItem(id) {
		  if (parseInt(id)) window.location.href = "${APP_PATH }/MlbackProduct/topcProductDetailPage?productId=" + id;
		}
/*******搜索****************************************/
		   $(".tt-btn-search").click(function(){
		     var seaProductName = $(this).parents(".tt-col").find("input.tt-search-input").val();
		     if(seaProductName==""){
		          alert("Please enter keywords;")
		     }else{
		         window.location.href = "${APP_PATH}/MlbackProduct/topSearchPage?seaProductName=" +seaProductName;
		     }
		   });
				$(".show_ul li").click(function(){
				  var seaProductName =$(this).html();
								window.location.href = "${APP_PATH}/MlbackProduct/topSearchPage?seaProductName=" +seaProductName;
				 });
				
				
				$(".tt-search-input").focus(function(){
					 $(".serch_box").find("ul.show_ul").slideDown(200);
				})
				
				$('body').delegate('.show_ul li','click',function(e){
					var val = $(this).text();
					$(".tt-col").find("input.tt-search-input").val(val);
					$(".serch_box").find("ul.show_ul").slideUp(200)
					e.stopPropagation();
				});
				
			    $("body").on('click', '.close_serch',function() {
				    $('.serch_cont').slideUp(200)
				})
				
				
				$(document).click(function(e){
				    var target = $(e.target);
				     if(target.closest(".tt-search-input").length != 0) return;
				    $('ul.show_ul').slideUp(200)
				})
				
		
		
	</script>
</body>



</html>