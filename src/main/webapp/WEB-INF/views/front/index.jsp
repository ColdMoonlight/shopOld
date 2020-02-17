<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
 %>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${APP_PATH }/static/common/swiper/swiper.min.css">
	
	
	<!-- Facebook Pixel Code 这是facebook广告插件可以注释掉，但不要删除-->
	<script>
	  !function(f,b,e,v,n,t,s)
	  {if(f.fbq)return;n=f.fbq=function(){n.callMethod?
	  n.callMethod.apply(n,arguments):n.queue.push(arguments)};
	  if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
	  n.queue=[];t=b.createElement(e);t.async=!0;
	  t.src=v;s=b.getElementsByTagName(e)[0];
	  s.parentNode.insertBefore(t,s)}(window, document,'script',
	  'https://connect.facebook.net/en_US/fbevents.js');
	  fbq('init', '246433859565492');
	  //fbq('init', '667403967094866');
	  fbq('track', 'PageView');
	</script>
	<noscript><img height="1" width="1" style="display:none"src="https://www.facebook.com/tr?id=667403967094866&ev=PageView&noscript=1"/></noscript>
	<!-- End Facebook Pixel Code -->
	
	<script>
  		fbq('track', 'ViewContent');
	</script>
	<!-- Facebook Pixel Code end -->
</head>
<body>
  <jsp:include page="pcheader.jsp"></jsp:include>
	<div id="banner" class="swiper-container">
	  <div class="swiper-wrapper"></div>
	  <div class="swiper-pagination"></div>
	  <div class="swiper-button-nexta"></div>
	  <div class="swiper-button-preva"></div>
	</div>
	<div class="narrow clearfix" id="hot-two"></div>
	<div class="coupon_cont2"></div>
	<div id="countdown-area"> </div>
	<div class="actionhot clearfix" id="hot-product"></div>
	<div class="grid" id="hot-adv"></div>
	<div class="banner_fl_1"></div>
  <div class="hot_index_product clearfix">
	   <div class="hot_box_product_cont">
	    	<div class="swiper-wrapper"></div>
	      <div class="swiper-button-prev hotbtn_prev"></div>
        <div class="swiper-button-next hotbtn_next"></div>
	   </div>
   </div>
	    <!--*********新品推荐******************-->
  <div class="banner_fl_2"></div>
	<div class="new_index_product clearfix">
		   <div class="new_box_product_cont">
		   	<div class="swiper-wrapper"></div>
		   	 <div class="swiper-button-prev newbtn_prev"></div>
	       <div class="swiper-button-next newbtn_next"></div>
		   </div>
	   </div>
	   
	    <!-- product show -->
	     <div class="banner_fl_3"></div>
	      <div class="comment_cont clearfix"> </div>
	    <!-- buyer show -->
	    <!--<div id="buyer-show">
	    	<img src="${APP_PATH }/static/pc/show.jpg">
	    </div>-->
  	<!--</div>-->
  <!--</div>-->
  <jsp:include page="pcfooter.jsp"></jsp:include>
 	<script src="${APP_PATH }/static/js/countdown.min.js"></script>
	<script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
  <script>
  /******一下是首页轮播展示*********************/
	  	function renderSlide(parent, data) {
			// console.log(data);
			var html = '';
			for (var i=0, len=data.length; i<len; i+=1) {
				var slideIfinto_click = data[i].slideIfinto;
				var slideIfproORcateORpage =data[i].slideIfproORcateORpage;
				// console.log(slideIfproORcateORpage);
				if(slideIfinto_click==0){
					html += '<div class="swiper-slide">' +
						  '<a href="javascript:;" style="background:url('+ data[i].slidePcimgurl +') no-repeat center">' +'</a>' +
						'</div>';
				}else{
					if(slideIfproORcateORpage==0){
						html += '<div class="swiper-slide">' +
								  '<a href="${APP_PATH}/' + data[i].slideSeoname + '.html" style="background:url('+ data[i].slidePcimgurl +') no-repeat center">' +'</a>' +
							'</div>';
					}else if(slideIfproORcateORpage==1){
						html += '<div class="swiper-slide">' +
								  '<a href="${APP_PATH}/search/' + data[i].slideCateSeoname + '.html" style="background:url('+ data[i].slidePcimgurl +') no-repeat center">' +'</a>' +
							'</div>';
					}else if(slideIfproORcateORpage==2){
						html += '<div class="swiper-slide">' +
								  '<a href="${APP_PATH}/' + data[i].slidePageSeoname + '.html" style="background:url('+ data[i].slidePcimgurl +') no-repeat center">' +'</a>' +
							'</div>';
					}
					
				}
			}
			parent.html(html);
		}
	$.ajax({
		 url: '${APP_PATH}/MlbackSlide/getMlbackSlidepcListByArea',
	      data: JSON.stringify({
		 	"slideArea": 1
		 }),
		 type: 'post',
		 dataType: 'JSON',
		 contentType: 'application/json',
		 success: function (data) {
		 	 // console.log(data)/***data**/
           if (data.code === 100) {
             var resData = data.extend.mlbackSlideList;;
		 	 // console.log(resData);
			renderSlide($('#banner .swiper-wrapper'), resData);
			new Swiper('#banner', {
			  freeMode: true,
					pagination: {
						el: '.swiper-pagination',
						clickable: true
					},
					 simulateTouch : false,//禁止鼠标模拟
					 loop:true,
					   autoplay: {
					      delay: 5000,
					      stopOnLastSlide: false,
					      disableOnInteraction: false,
					      },
					  
					  navigation: {
						nextEl: '.swiper-button-nexta',
						prevEl: '.swiper-button-preva',
					  },
			});
		
           } else {
             renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
           }
         }
       });
  
  	/****热播推荐四个图片******************************/
    function renderHotProduct(parent, data) {
       var html = '';
       html += '<div class="actionhot_cont clearfix">';
       html += '<ul class="clearfix">';
      for (var i = 0; i < data.length; i += 1) {
		  var actshowprolei = data[i].actshowproIfproORcate;
//		  console.log(actshowprolei)
		  	if(actshowprolei==0){
		  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/' + data[i].actshowproSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}else if(actshowprolei==1){
		  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/search/' + data[i].actshowproCateSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}else if(actshowprolei==2){
		  				  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/' + data[i].actshowproPageSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}
		  
		  
		   
      }
       html +=  '</ul>';
       html +=  '</div>';
      parent.html(html);
    }
		/* xxxx */
    $.ajax({
      url: '${APP_PATH}/MlbackActShowPro/getMlbackActShowProListByActnum',
      data: "actshowproActnum=" + 7,
      type: "POST",
      success: function (data) {
        // console.log("mlbackActShowProList");
        if (data.code === 100) {
        	var resData = data.extend.mlbackActShowProList;
          // console.log(resData);
          renderHotProduct($('#hot-product'), resData);
        } else {
          renderErrorMsg(prodcutBox, 'Not acquired product-related data');
        }
      }
    });
    /************热推图片22222*******************/
       function rednerHotTwo(parent, data) {
	      var html = '';
	       html += '<div class="narrow_cont clearfix">';
	      for (var i = 0; i < data.length; i += 1) {
			  var actshowprolei = data[i].actshowproIfproORcate;
			  				  	if(actshowprolei==0){
		  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/' + data[i].actshowproSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}else if(actshowprolei==1){
		  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/search/' + data[i].actshowproCateSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}else if(actshowprolei==2){
		  				  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/' + data[i].actshowproPageSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}
	      }
	       html +=  '</div>';
	      parent.html(html);
	    }
/*******************/
        $.ajax({
		      url: '${APP_PATH}/MlbackActShowPro/getMlbackActShowProListByActnum',
		      data: "actshowproActnum=" + 6,
		      type: "POST",
		      success: function (data) {
		        if (data.code === 100) {
//		        	 console.log("*****11111111************")
//					     console.log(data)
//					   console.log("*****11111111************")
		        	var resData = data.extend.mlbackActShowProList;
		          rednerHotTwo($('#hot-two'), resData)
		        } else {
		          renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
		        }
		      }
		    });
   
   /*****新品推荐开始****************************************/
    var hot_pic = $('.hot_box_product_cont .swiper-wrapper');
		var new_pic = $('.new_box_product_cont .swiper-wrapper');
		
   function rednerProduct(parent, data) {
			var html = '';
				for (var i = 0; i < data.length; i += 1) {
					 var productactoffif = data[i].productActoffIf;
					// console.log(productactoffif)
					var productactoffid  =  data[i].productActoffid;
					 // console.log(productactoffid)  
					var cp_icon = "";
					var showspan = "";
					if(productactoffif == 1){
								  if(productactoffid==1){
									   showspan ="showactive1"
								  }else if(productactoffid==2){
									   showspan ="showactive2"
								  }else if(productactoffid==3){
									   showspan ="showactive3"
								  }else if(productactoffid==4){
									   showspan ="showactive4"
								  }
								  
					}else{
								   showspan ="hideactive"
					}
					html += '<div class="swiper-slide">' +
						'<div class="product-item" data-productid="'+ data[i].productId +'">' +
					    '<span class="hui_icon '+showspan+'"></span>'+
						'<div class="product-img">' +
						'<a href="${APP_PATH}/' + data[i].productSeo + '.html">' +
						'<img src="' + data[i].productMainimgurl + '" alt="">' +
						'</a>' +
						'</div>' +
						'<div class="product-desc">' +
						'<div class="product-title">' + data[i].productName + '</div>' +
						'<div class="product-type"></div>' +
						'<div class="product-data">' +
						'<span class="pay-num">' + (data[i].productHavesalenum ? data[i].productHavesalenum : 0) + ' Payment</span>' +
						'<span class="review-num">' + (data[i].productReviewnum ? data[i].productReviewnum : 0) +
						' Review(s)</span>' +
						'</div>' +
						'<div class="product-price">' +
						'<span class="product-now-price">$' + (data[i].productOriginalprice && data[i].productActoffoff ? (data[i]
							.productOriginalprice * data[i].productActoffoff / 100).toFixed(2) : 0) + '</span>' +
						'<span class="product-define-price">$' + (data[i].productOriginalprice ? data[i].productOriginalprice : 0) +
						'</span>' +
						'<span class="product-to-cart" data-id="' + data[i].productId + '"><i class="icon cart2"></i></span>' +
						'</div>' +
						'</div>' +
						'</div>'+
						'</div>';
				}
        html += '<div class="swiper-slide" style="width:100%; height:100%"><a href="${APP_PATH}/search/Pop-Trending.html" style="width:100%;;dispaly:block" class="morelink"> <span>VIEW</span><b>+</b><em>MORE</em> </a></div>'
				parent.html(html);
		}
   /******M-Series-Hair**********************************/
     		$.ajax({
         url: '${APP_PATH}/MlbackCategory/searchBycategorySeo',
					data: JSON.stringify({
						"categorySeo": "M-Series-Hair"
					}),
			 type: 'post',
			 dataType: 'text',
			 contentType: 'application/json',
			 success: function (data) {
					if (JSON.parse(data).code === 100) {
					   var resDataProduct = JSON.parse(data).extend.mlbackProductResList;
					    var dataLength =resDataProduct.length;
             var lens=parseInt(dataLength-(dataLength%8));
             rednerProduct(hot_pic,resDataProduct.slice(0,lens));
//           rednerProduct(new_pic,resDataProduct.slice(0,lens));
					 new Swiper('.hot_box_product_cont', {
					     slidesPerView: 5,
					    spaceBetween:5,
					    freeMode: true,
					    navigation: {
					      nextEl: '.hotbtn_next',
					      prevEl: '.hotbtn_prev',
					    }
					 });
					 
					} else {
					  renderErrorMsg(prodcutBox, 'No product-related data was obtained');
					}
				  }
		});	
   
   		$.ajax({
         url: '${APP_PATH}/MlbackCategory/searchBycategorySeo',
					data: JSON.stringify({
						"categorySeo": "Pop-Trending"
					}),
			 type: 'post',
			 dataType: 'text',
			 contentType: 'application/json',
			 success: function (data) {
					if (JSON.parse(data).code === 100) {
					   var resDataProduct = JSON.parse(data).extend.mlbackProductResList;
					    var dataLength =resDataProduct.length;
             var lens=parseInt(dataLength-(dataLength%8));
             rednerProduct(new_pic,resDataProduct.slice(0,lens));
	 					 new Swiper('.new_box_product_cont', {
					    slidesPerView: 5,
					    spaceBetween:5,
					    freeMode: true,
					    navigation: {
					      nextEl: '.newbtn_next',
					      prevEl: '.newbtn_prev',
					    }
					 })
					 
					} else {
					  renderErrorMsg(prodcutBox, 'No product-related data was obtained');
					}
				  }
		});	
   
   
	function number5Times(len,resDataProduct) {
        var lens=parseInt(len-(len%9));
//      Console.log(lens)
		return resDataProduct.slice(0,lens);
       }	
   /*****新品推荐结束****************************************/ 
   /******advadvadvadvadv******************************/  
    function rednerHotAdv(parent, data) {
	      var html = '';
	       html += '<div class="grid_cont clearfix">';
	      for (var i = 0; i < data.length; i += 1) {
			  var actshowprolei = data[i].actshowproIfproORcate;
			  		 		  	if(actshowprolei==0){
		  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/' + data[i].actshowproSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}else if(actshowprolei==1){
		  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/search/' + data[i].actshowproCateSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}else if(actshowprolei==2){
		  				  		 html += '<li>' +
		  			  '<a href="${APP_PATH}/' + data[i].actshowproPageSeoname + '.html">' +
		  			  					'<img src="' + data[i].actshowproImgpcurl + '" alt="">' +
		  			  '</a>' +
		  			  '</li>';
		  	}
	      }
	       html +=  '</div>';
	      parent.html(html);
	    }
/*******************/
        $.ajax({
		      url: '${APP_PATH}/MlbackActShowPro/getMlbackActShowProListByActnum',
		      data: "actshowproActnum=" + 8,
		      type: "POST",
		      success: function (data) {
		        if (data.code === 100) {
		        	 console.log("*****11111111************")
					     console.log(data)
					   console.log("*****11111111************")
		        	var resData = data.extend.mlbackActShowProList;
		          rednerHotAdv($('#hot-adv'), resData)
		        } else {
		          renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
		        }
		      }
		    });	
   
   
   
    /*---------------countDownArea--------*/
    function rednerCountDownAreaOne(parent, data) {
      var html = '';
      html += '<h3 class="title">'+ data.countdownTitle +'</h3>'+
        '<div class="body"></div>'+
        '<div class="desc">'+ data.countdownDescription +'</div>';

      parent.html(html);
      var countdown = new countDown('#countdown-area .body', {
	      start: {
	        time: data.countdownStarttime
	      },
	      end: {
	        time: data.countdownEndtime
	      },
	      format: 'DD : HH : MM : SS',
	      themeClass: 'dark',
	      interval: 1000,
	      stateText: {
    	    before: 'Start of distance activity:',
    	    progress: 'End of distance activity:',
    	    after: 'The activity is over:',
	    	}
	    });

      if (countdown && countdown.state === 'after') {
    	  $('#countdown-area').addClass('hide');
      }
    }
    var countDownArea = $('#countdown-area');
    $.ajax({
      url: '${APP_PATH}/MlbackCountDown/getOneMlbackCountDownDetail',
      data: "countdownId=" + 1,
      type: "POST",
      success: function (data) {
        // console.log("mlbackCountDownOne");
        if (data.code === 100) {
          // console.log(data.extend.mlbackCountDownOne);
          if(data.extend.mlbackCountDownOne==null){
          	// console.log("mlbackCountDownOne为null");
          }else{
          	rednerCountDownAreaOne(countDownArea, data.extend.mlbackCountDownOne)
          }
        } else {
          renderErrorMsg(prodcutBox, 'Not acquired product-related data');
        }
      }
    });

    /*------分类管理图片----------*/
		   var productBlock1 =$(".banner_fl_1");
		   var productBlock2 =$(".banner_fl_2");
		   var productBlock3 =$(".banner_fl_3");
	    function renderBanner(data) {
	    	return $('<div class="bannerpic"></div>').html('<img src="' + data.showareaImgurl + '" alt=" + data.showareaName + ">');
	    }
	 	$.ajax({
	 	      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
	 	      data: "showareaNumth=" + 1,
	 	      type: "POST",
	 	      async: false,
	 	      success: function (data) {
//	 	      	 console.log(data);
	 	        if (data.code === 100) {
	 	          var resData = data.extend.mlbackShowAreaOne;
//	 	           console.log(resData);
	 	          productBlock1.append(renderBanner(resData))
	 	        } else {
	 	          renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
	 	        }
	 	      }
	 	    });
	 	    	 	$.ajax({
	 	      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
	 	      data: "showareaNumth=" + 2,
	 	      type: "POST",
	 	      async: false,
	 	      success: function (data) {
	 	        if (data.code === 100) {
	 	          var resData = data.extend.mlbackShowAreaOne;
	 	          // console.log(resData);
	 	          productBlock2.append(renderBanner(resData))
	 	        } else {
	 	          renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
	 	        }
	 	      }
	 	    });
    	 	$.ajax({
		 	      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
		 	      data: "showareaNumth=" + 3,
		 	      type: "POST",
		 	      async: false,
		 	      success: function (data) {
		 	        if (data.code === 100) {
		 	          var resData = data.extend.mlbackShowAreaOne;
		 	          // console.log(resData);
		 	          productBlock3.append(renderBanner(resData))
		 	        } else {
		 	          renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
		 	        }
		 	      }
		 	    });
				/***ins品论*****************************/
				var masonrycont=$(".comment_cont")
					function number5Times(len,productData) {
			        var lens=parseInt(len-(len%5));
				    	return productData.slice(0,lens);
			       }	
					$.ajax({
						url: "${APP_PATH}/MlfrontReview/selectReviewListFrom",
							data:{
							  "reviewFrom": 2
							},
							type: "POST",
							success: function (result) {
							  if (result.code == 100) {
							  	console.log("/**result************/");
//									console.log(result);
									console.log("/**result************/");
									  resData = result.extend.mlfrontReviewList;
									  resDataimg = result.extend.mlfrontReviewImgList;
									   var dataimgLength =resDataimg.length;
									   var resDatalength =resData.length;
                     var lensimg=parseInt(dataimgLength-(dataimgLength%10));
                     var lenslist=parseInt(resDatalength-(resDatalength%10));
                     masonryHtml(masonrycont,resData.slice(0,lenslist),resDataimg.slice(0,lensimg));
								  }
							}
					  });
				function masonryHtml(parent, data1, data2){
							var html = '';
							html += '<ul class="clearfix">';
							for(var i=0;i<data1.length;i++){
								html += '<li class="list_ins" onclick="clickVideo(event)" videonum-id="'+data1[i].reviewPid+'">';
								for(var j=0;j<data2[i].length;j++){
								    html +=	'<img src="'+data2[i][j].reviewimgUrl+'" />';
								 }	
								 html += '</li>';
							}
							 html += '</ul>';
							  parent.html(html);
						}
				/*******************************/
			function videoProduct (data){
			 var elBox = $('<div class="video_enlarge_corver index_tcbox" style="display: block;"></div>');
			 var html = '<div class="video_enlarge_wrap">'+
			                   '<div class="video_enlarge_content">'+
							             '<div class="promotion_product_list clearfix">'+
										   '<a href="###" class="product-image"><img src="'+data.productMainimgurl+'" alt=""></a>'+
										   '<div class="rightcont">'+
										   '<h3 class="product-name"><a href="javascript:;">'+data.productName+'</a></h3>'+
										    '<div class="price-box_promotion">'+	
											     '<div class="price-box">'+ 
														'<p class="old-price">'+
															'<span class="price-label">Regular Price:</span>'+
															'<span class="price">$' + (data.productOriginalprice ? data.productOriginalprice : 0) +
														'</p>'+
														'<p class="special-price span12">'+
															'<span class="price-label">SALE PRICE:</span>'+
															'<span class="price">$' + (data.productOriginalprice && data.productActoffoff ? (data.productOriginalprice * data.productActoffoff / 100).toFixed(2) : 0) + '</span>' +
															
														'</p>'+	
										    	 '</div>'+	
										    '</div>'+	
											'<a class="video_link_buyBtn" href="${APP_PATH }/'+data.productSeo+'.html">Buy Now </a>'+
											'</div>'+
										 '</div>'+		
			                    '</div>'+	
								'<button class="video_enlarge_close">X</button>'		
			             '</div>'+						
			 $(document.body).append(elBox.html(html));
			 $(".video_enlarge_close").on("click",function(){
				 elBox.remove();
			 })
			}
	/*********************************/
					function clickVideo(e) {
							e.stopPropagation();
							var item  = $(e.target);
							var productId = item.parent().attr('videonum-id');
							data = {
								"productId":productId
							};
//							console.log(productId)
							$.ajax({
									 url: '${APP_PATH}/MlbackProduct/getOneProductSimple',
							        data:data,
									 type: 'post',
									 success: function (data) {
//										 console.log(data)/***data**/
										   if (data.code === 100) {
															    var resData = data.extend. mlbackProductOne;
																videoProduct(resData)
										   } 
										 }
							       });
						}	
	   /*******优惠券*************************/
	   	                  var bannercoupon=$(".coupon_cont2")
	   					function rednerCoupon(parent, data) {
	   						  var html = '';
	   						  for (var i = 0; i < data.length; i += 1) {
	   							   var slideIfinto_click = data[i].slideIfinto;
	   							  if(slideIfinto_click==0){
	   								  html += '<div class="coupon_ban">' +
	   								  '<a href="javascript:;">' +
	   								  '<img src="' + data[i].slidePcimgurl + '" alt="">' +
	   								  '</a>' +
	   								  '</div>';
	   							  }else{
	   								  html += '<div class="coupon_ban">' +
	   								  '<a href="${APP_PATH}/' + data[i].slideSeoname + '.html">' +
	   								  '<img src="' + data[i].slidePcimgurl + '" alt="">' +
	   								  '</a>' +
	   								  '</div>';
	   							  }
	   							  
	   							
	   						  }
	   						  parent.html(html);
	   						}
	   				 $.ajax({
	   					 url: '${APP_PATH}/MlbackSlide/getMlbackSlidewapListByArea',
	   						data: JSON.stringify({
	   					   "slideArea": 2
	   					 }),
	   					 type: 'post',
	   					 dataType: 'JSON',
	   					 contentType: 'application/json',
	   					 success: function (data) {
	   							// console.log(data)/***data**/
	   							if (data.code === 100) {
	   							  var resData = data.extend.mlbackSlideList;;
	   							  // console.log(resData);
	   					         rednerCoupon(bannercoupon,resData)
	   							} else {
	   							  renderErrorMsg(prodcutBox, 'No product-related data was obtained.');
	   							}
	   						  }
	   	   });	
  </script>
  	<!-- megalook-->
  	<script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script>
	<!-- megalookhair 
  	<script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
  	<!-- huashuohair -->
  	<!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>