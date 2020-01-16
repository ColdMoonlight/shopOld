<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Product List</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, viewport-fit=cover">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!--  禁用telphone -->
	<meta name="format-detection" content="telephone=no">
	<!-- 关闭下拉刷新 -->
	<meta id="WV.Meta.DisableRefresh" value="true">
	<!-- 禁用ios的bounces效果 -->
	<meta id="WV.Meta.Share.Disabled" value="true">
	<!-- uc 字体放大-->
	<meta name="wap-font-scale" content="no">
	<meta name="aplus-touch" content="1">
	
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
	<script>
  		fbq('track', 'ViewContent');
	</script>
	<!-- Facebook Pixel Code end -->
</head>

<body>

	<jsp:include page="pcheader.jsp"></jsp:include>
 <link rel="stylesheet" href="${APP_PATH }/static/common/swiper/swiper.min.css">
	<script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
	<!-- main -->
	<div class="main">
		<!-- <div class="condition select">
			<select class="select-item select-category" data-type="category"></select>
		</div> -->
		<div class="container">
			<div class="product-list product-list_home">
				<div class="product-list"></div>
			</div>
			<div class="hot_box_product clearfix" style="display:none">
				   <h3>YOU MIGTH ALSO LIKE</h3>
				   <div class="swiper-container hot_box_product_cont">
				   	<div class="swiper-wrapper"></div>
				   	<div class="swiper-pagination swiper-pagination2"></div>
					<div class="swiper-button-nextcc"></div>
					<div class="swiper-button-prevcc"></div>
				   </div>
			</div>
			
		</div>
		
	</div>

	<jsp:include page="pcfooter.jsp"></jsp:include>

	<script>
		var condition = $('.select');
		var productList = $('.product-list');
		var sessionScopeSearchName = '${sessionScope.productName}';
		//var cidA = window.location.href.split('?')[1].split('=');
        var Search;
		//default codition
		

		/* category condition */
		$.ajax({
			url: "${APP_PATH}/MlbackProduct/searchProductLike",
			data: "productName=" + sessionScopeSearchName,
			type: "POST",
			success: function (data) {
				// console.log(data)
				if(data.code==100){
					var resultlist = data.extend.mlbackProductResList;
					var  resultlistlength = resultlist.length
					// console.log(resultlistlength);
					var name =data.extend.productName;
					Search = name;
					// console.log(resultlist);
					// rednerProductmm(productList,resultlist);
					if(resultlist==null){
						renderErrorMsg(productList, 'No product-related data was obtained');
					}else{
						var DataproListBySaleNum =orderProListBySaleNum(resultlist);
						rednerProductmm(productList,DataproListBySaleNum);
					}
					if(resultlistlength==0){
						$(".hot_box_product").show();
					}else{
						$(".hot_box_product").hide();
					}
					
					
				}
			}
		});
		function orderProListBySaleNum(reqData) {
			if(reqData.length>0){
			   var n = reqData.length;
			   for(var i=0;i<n;i++){
				 for(var j=0;j<n-1-i;j++){
					// console.log(reqData[j].productHavesalenum);
				   if(reqData[j].productHavesalenum<reqData[j+1].productHavesalenum){
					 var  DateOne = reqData[j];
					 reqData[j] = reqData[j+1];
					 reqData[j+1] = DateOne;
				   }
				 }
			   }
			 }
			return reqData;
		}
		function renderErrorMsg(parent, msg) {
			parent.html('<p class="notfind">' + msg + '</p>');
		}
		

		function rednerProductmm(parent, data) {
			var html = '';
			if (data.length > 0) {
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
					html += '<div class="product-item">' +
					 '<span class="hui_icon '+showspan+'"></span>'+
						'<div class="product-img">' +
						/* '<a href="${APP_PATH}/MlbackProduct/tomProductDetailPage?productId=' + data[i].productId + '">' + */
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
						'</div>';
				}

				parent.html(html);
			} else {
				renderErrorMsg(parent, 'did not find----- “'+ Search+'”');
				
				
			}
		}

		function renderCondition(parent, data, defaultHtml) {
			var html = defaultHtml || '';
			html += ''

			for (var i = 0, len = data.length; i < len; i += 1) {
				if (data[i].categoryId === parseInt(cidA[1])) {
					// console.log("*********")
					html = '<option value="' + data[i].categoryId + '">' + data[i].categoryName + '</option>' + html;
				} else {
					html += '<option value="' + data[i].categoryId + '">' + data[i].categoryName + '</option>';
				}
			}

			parent.html(html);
		}
		
		/****************/
		var hot_pic = $('.hot_box_product_cont .swiper-wrapper');
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
		
				parent.html(html);
		}
		 
		
		$.ajax({
			 url: '${APP_PATH}/MlbackSlide/getMlbackSlidepcListByArea',
				data: JSON.stringify({
			   "slideArea": 3
			 }),
			 type: 'post',
			 dataType: 'text',
			 contentType: 'application/json',
			 success: function (data) {
					    // console.log(JSON.parse(data))/***data**/
					if (JSON.parse(data).code === 100) {
					  // var resData = JSON.parse(data).extend.mlbackSlideList;;
					  var resDataProduct = JSON.parse(data).extend.mlbackProductResList;;
					  // console.log(resData);
					  // console.log(resDataProduct);
					 rednerProduct(hot_pic,resDataProduct)
					 new Swiper('.hot_box_product_cont', {
					         	  slidesPerView: 5,
					   spaceBetween: 10,
					   freeMode: true,
					   loop:true,
					   observer: true,//修改swiper自己或子元素时，自动初始化swiper
					   observeParents: true,//修改swiper的父元素时，自动初始化swiper
					  autoplay: {
					      disableOnInteraction: false,
					    },
					   // loop:true,
					    simulateTouch : false,//禁止鼠标模拟
						pagination: {
							el: '.swiper-pagination2',
							clickable: true
						},
						navigation: {
							nextEl: '.swiper-button-nextcc',
							prevEl: '.swiper-button-prevcc',
						},
				    })
					 
					} else {
					  // renderErrorMsg(prodcutBox, 'No product-related data was obtained');
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