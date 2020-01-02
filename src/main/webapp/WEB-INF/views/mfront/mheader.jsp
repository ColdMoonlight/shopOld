<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
   <link rel="stylesheet" href="${APP_PATH }/static/common/swiper/swiper.min.css">
  <link rel="stylesheet" href="${APP_PATH }/static/m/css/main.css">
  <script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
  <script src="${APP_PATH }/static/m/js/zepto.min.js"></script>
  <script>
	  $.fn.prevAll = function(selector){
		  var prevEls = [];
		  var el = this[0];
		  if(!el) return $([]);
			while (el.previousElementSibling) {
		    var prev = el.previousElementSibling;
		    if (selector) {
		      if($(prev).is(selector)) prevEls.push(prev);
		    }
		    else prevEls.push(prev);
		    el = prev;
			}
	    return $(prevEls);
	 	};
	  
		$.fn.nextAll = function (selector) {
	    var nextEls = [];
	    var el = this[0];
	    if (!el) return $([]);
	    while (el.nextElementSibling) {
	      var next = el.nextElementSibling;
	      if (selector) {
	        if($(next).is(selector)) nextEls.push(next);
	      }
	      else nextEls.push(next);
	      el = next;
	    }
	    return $(nextEls);
	 };
  </script>
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
  <!-- info -->
  <!--header  -->
  <!-- <div class="fixed_link"><a href="${APP_PATH}/Activty.html"></a> <span class="close"></span></div> -->
    <!-- <div class="fixed_small"><a href="javascript:;"></a></div> -->
  <div class="header bd-b">
	  <div class="img_show">
	  <a href="${APP_PATH}/Activty.html"><img src="${APP_PATH }/static/m/img/shengdan/gh0.jpg" /></a>	
	  	<div class="img_show_cont">
	  		<a href="javascript:;"></a>
	  	</div>
	  </div>
<!-- 	  <div class="info_adv">
	  	<p style="text-align: center;">Free Shipping World Wide.</p>
	  	<div id="adv_silder">
	  		<div class="swiper-wrapper">
	  		</div>
	  	</div>
	  </div> -->
    <div class="container">
      <span id="menu" class="icon menu"></span>
      <span class="icon person"></span>
	  <a href="TEL:(501)7226336" class="icon myphone"></a>
      <a href="${APP_PATH}/index.html">
	      <div class="logo">
	        <img src="${APP_PATH }/static/m/img/index/logo.png" alt="">
	      </div>
      </a>
      <span class="icon cart"><span class="num hide">0</span></span>
      <span class="icon search"></span>
    </div>
  </div>
  <div class="category">
    <i class="icon close close2"></i>
    <ul class="main-category category_ul bd-b">
		
	</ul>
  </div>
  
   <div class="serch_cont">
      <div class="serch_box">
        <span class="close_serch">X</span>
        <p class="serch_tit">What are you Looking for?</p>
        <div class="tt-col">
          <input type="text" class="tt-search-input" placeholder="Search Products..." />
          <button class="tt-btn-search" type="submit">Search</button>
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

  <script>
	  $(function(){
		  $(window).scroll(function(){
			   var scrollhead=$(window).scrollTop();
			   if(scrollhead>5){
				   $(".header").addClass("headActive")
			   }else{
				   $(".header").removeClass("headActive")
			   }
		  });
		  
		  /*****************************/
	  	$(".fixed_link .close").click(function(){
	  		$(".fixed_link").addClass("active");
	  		$(".fixed_small").addClass("active");
	  	});
	  	$(".fixed_small").click(function(){
	  		$(".fixed_link").removeClass("active");
	  		$(this).removeClass("active");
	  	})
	  	
	  	
	  })
	  
    var categoryActiveNum = 1;
    var iCart = $('.icon.cart');
    var iPerson = $('.icon.person');
	var mask = $('<div class="mask"></div>');
	var sysFlag = 0;

    function renderErrorMsg(parent, msg) {
      parent.html('<p class="without-data">' + msg + '</p>');
    }

    function renderSysMsg(msg, cls) {
    	var elBox = $('<div class="modal sys-box '+ cls +'" style="display: block;"></div>');
    	
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
/************************/
              var mainCategory =$(".main-category");
			  var categoryBox = $('.category');
			function renderMainCategory(parent,data1,data2) {
				var html="";
				for(var i=0;i<data1.length;i++){
					var categoryLableInt = data1[i].categoryLable;
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
					html += '<li class="home-menu_list '+classimg+'"><a href="${APP_PATH}/search/' + data1[i].categorySeo + '.html">'+ data1[i].categoryName +'</a><i class="gw-i"></i>'
					if(data2 && data2.length > 0 && data2[i] && data2[i].length > 0){
				    html += '<div class="menu_list-wap">';
					for(var j=0;j<data2[i].length;j++){
						  if(data2[i][j] && data2[i][j].length > 0){
							  html += '<dl>'; 
							   for(var k=0;k<data2[i][j].length;k++){
								   var categoryLableInt2 = data2[i][j][k].categoryLable;
								   var	classimg = "";
								   if(categoryLableInt2 == 0){
								   	classimg = "classimg0";
								   }else if(categoryLableInt2 == 1){
								   	classimg = "classimg1";
								   }else if(categoryLableInt2 == 2){
								   	classimg = "classimg2";
								   }else if(categoryLableInt2 == 3){
								   	classimg = "classimg3";
								   }else if(categoryLableInt2 == 4){
								   	classimg = "classimg4";
								   }
								     html += '<dd class="'+classimg+'"><a href="${APP_PATH}/' + data2[i][j][k].categorySeo + '.html">'+ data2[i][j][k].categoryName +'</a><i class="gw-i2"></i></dd>';   
							   }
							     html +=  '</dl>';
						  }
					 }	
					 html += '</div>';	
					}
					 html += '	</li>';	
			    }
			 parent.html(html);
			 
			 $(".category_ul li i.gw-i").click(function(){
			   // $(this).toggleClass('active').next('.menu_list-wap').show(200);
			   var str = $(this).next('.menu_list-wap').css('display');
			   if(str == 'none'){
			   	$(this).next('.menu_list-wap').show(200);
				$(this).addClass("active");
			   }else{
			   	$(this).next('.menu_list-wap').hide(200);
				$(this).removeClass("active");
			   }
			   $(this).parent('.home-menu_list').siblings('.home-menu_list').find('.gw-i').removeClass('active').next('.menu_list-wap').hide(200);
			 })
			 
			 $(".menu_list-wap dl dd:first-child .gw-i2").click(function(){
				 $(this).toggleClass('active');
				 if($(this).hasClass('active')){
					   $(this).parents("dl").addClass("submenu");
					   $(this).parents("dl").siblings("dl").removeClass("submenu"); 
					   $(this).parents("dl").siblings("dl").children("dd:first-child").find(".gw-i2").removeClass("active"); 
				 }else{
					  $(this).parents("dl").removeClass("submenu");
					  $(this).removeClass("active")
				 }
			   // $(this).toggleClass('active').parents("dl").toggleClass("submenu");
			   // $(this).parents("dl").siblings("dl").removeClass("submenu");
			   
			 })
			 
			 
			}


		$.ajax({
			url: '${APP_PATH}/MlbackCategory/getCategorySuperMenu',
		    type: 'POST',
			dataType: 'JSON',
			contentType: 'application/json',
			success: function (data) {
				console.log("***JsonDate******222******");
				var JsonDate = JSON.parse(data);
				console.log(JsonDate);
				console.log("***JsonDate******222******");
			  if(JsonDate.code === 100){
				  FirstList = JsonDate.extend.categoryFirstList;
				  SuperList = JsonDate.extend.mlbackCategorySuperList;
				  console.log("-------------FirstList------------------")
				  console.log(FirstList)
				  console.log("-------------FirstList------------------")
				  console.log("-------------SuperList------------------")
				   console.log(SuperList)
				   console.log("-------------SuperList------------------")
				  renderMainCategory(mainCategory,FirstList,SuperList)
			  }else{
				 // renderErrorMsg(prodcutBox, '未获取到目录相关的数据'); 
			  }
			  
			}
		  })


    $('#menu').on('click', function () {
      categoryBox.show();
    });
    categoryBox.find('.close2').on('click', function () {
      categoryBox.hide();
    });


    // cart icon default number
    var cartText = iCart.find('.num');
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
        window.location.href = "${APP_PATH }/MlfrontUser/toUserCenter";
      } else {
        window.location.href = "${APP_PATH }/MlfrontUser/toLoginRegisterPage";
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

    function toProductItem(id) {
      if (parseInt(id)) window.location.href = "${APP_PATH }/MlbackProduct/tomProductDetailPage?productId=" + id;
    }
	
	/************advlistpic**********************************/
	var banneradv=$("#adv_silder .swiper-wrapper")
	   function rednertop(parent, data) {
		  var html = '';
		  for (var i = 0; i < data.length; i += 1) {
				html += '<div class="swiper-slide">' +
					'<a href="javascript:;">' +
							'<img src="' + data[i].slideWapimgurl + '" alt="">' +
					'</a>' +
					'</div>';
		  }
		  parent.html(html);
		}
			$.ajax({
			 url: '${APP_PATH}/MlbackSlide/getMlbackSlidewapListByArea',
				data: JSON.stringify({
			   "slideArea": 4
			 }),
			 type: 'post',
			 dataType: 'JSON',
			 contentType: 'application/json',
			 success: function (data) {
					// console.log(data)/***1111111111data**/
					if (JSON.parse(data).code === 100) {
					  var resData = JSON.parse(data).extend.mlbackSlideList;
					  // console.log(resData)/****************首页广告******/
						rednertop(banneradv, resData);
						  new Swiper('#adv_silder', {
							// freeMode: true,
							// loop:true,
							// autoplay: {
							//     disableOnInteraction: false,
							//   },
							})
					  // console.log(resData);
					 // rednertop(bannerfirst,resData)
					} else {
					  renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
					}
				  }
		});
	
	  /************************/
	        $(".tt-btn-search").click(function(){
	           var seaProductName = $(this).parents(".tt-col").find("input.tt-search-input").val();
			   if(seaProductName==""){
				   alert("Please enter keywords;")
			   }else{
				    window.location.href = "${APP_PATH}/MlbackProduct/tomSearchPage?seaProductName=" +seaProductName;
			   }
	        });
			  $(".show_ul li").click(function(){
			    var seaProductName =$(this).html();
				window.location.href = "${APP_PATH}/MlbackProduct/tomSearchPage?seaProductName=" +seaProductName;
	           });
	    /**************搜索*************************/
	        $(".tt-search-input").focus(function(){
	          $(".serch_box").find("ul.show_ul").show()
	        });
	        $('body').delegate('.show_ul li','click',function(e){
	          var val = $(this).text();
	          $(".tt-col").find("input.tt-search-input").val(val);
	          $(".serch_box").find("ul.show_ul").hide()
	          e.stopPropagation();
	        });
	        $("body").on('click', '.search',function() {
	            $('.serch_cont').show()
	        })
	        $("body").on('click', '.close_serch',function() {
	            $('.serch_cont').hide()
	        })
	
	
	

	
  </script>
</body>

</html>