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
			  <div class="nav_boxfirst">
				  <ul class="navul">
				  	
				  </ul>
			  </div>
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
		    var menuTimer;
		   $('.home-menu_list').hover(function () {
			   var _this = this;
			   // var menuContentHright = $(_this).find('.home-menu_list_wrap .home-menu_list_wrap_inner').outerHeight();
			   if(menuTimer){
				   clearTimeout(menuTimer);
			   }
			  menuTimer = setTimeout(function () {
				  // $('.navbar_itemContent-background').height(menuContentHright);
				  $(_this).siblings('.home-menu_list').find('.menu_list-wap').each(function () {
				   if($(_this).hasClass('wrap_active')){
					   $(_this).removeClass('wrap_active');
				   }
			   });
			   $(_this).find('.menu_list-wap').addClass('wrap_active');

			   return false;
			   },100)
		   },function () {
			   var _this = this;
			   if(menuTimer){
				   clearTimeout(menuTimer);
			   }
			   $(_this).find('.menu_list-wap').removeClass('wrap_active');
			   setTimeout(function () {
				   $('.navbar_itemContent-background').height(0);
				   return false;
			   },100);

		   });
		   
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
			/**********************************/
			var nav_boxfirst =$(".navul")
			
			// for(var i=0;i<FirstList.length;i++){
			//     htm += '<li>'
			//     htm += '<a href="javascript:void(0)">'+ FirstList[i].categoryName +'</a>'
			    
			//     if(SuperList && SuperList.length > 0 && SuperList[i] && SuperList[i].length > 0){
			//         htm += '<div>'
			//         for(var j=0;j<SuperList[i].length;j++){
			//             if(SuperList[i][j] && SuperList[i][j].length > 0){
			//                 htm += '<ol>'
			//                 for(var k=0;k<SuperList[i][j].length;k++){
			//                     //SuperList[i][j][k]
			//                     htm += '<li><a href="javascript:void(0)">'+ SuperList[i][j][k].categoryName +'</a></li>'
			//                 }
			//                 htm +=  '</ol>'
			//             }
			//         }
			//         htm += '</div>'
			//     }
			    
			//     htm += '</li>'
			// }
			
			function renderMainCategory(parent,data1,data2) {
				var html="";
				for(var i=0;i<data1.length;i++){
					html += '<li class="home-menu_list"><a href="javascript:void(0)">'+ data1[i].categoryName +'</a>'
					if(data2 && data2.length > 0 && data2[i] && data2[i].length > 0){
				    html += '<div class="menu_list-wap">';
					for(var j=0;j<data2[i].length;j++){
						  if(data2[i][j] && data2[i][j].length > 0){
							  html += '<dl>'; 
							   for(var k=0;k<data2[i][j].length;k++){
								  html += '<dd><a href="javascript:void(0)">'+ data2[i][j][k].categoryName +'</a></dd>';  
							   }
							     html +=  '</dl>';
						  }
					 }	
					 html += '</div>';	
					}
					 html += '	</li>';	
			    }
			 parent.html(html);
			}

		$.ajax({
		        url: '${APP_PATH}/MlbackCategory/getCategorySuperMenu',
		        method: 'POST',
		        success: function (data) {
				  if(data.code === 100){
					  FirstList = data.extend.categoryFirstList,
					  SuperList = data.extend.mlbackCategorySuperList;
					  renderMainCategory(nav_boxfirst,FirstList,SuperList)
				  }else{
					 renderErrorMsg(prodcutBox, '未获取到目录相关的数据'); 
				  }
				  
		        }
		      })
		

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