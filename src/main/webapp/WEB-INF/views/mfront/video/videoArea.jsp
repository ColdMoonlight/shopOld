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

	<jsp:include page="../mheader.jsp"></jsp:include>

	<!-- main -->
	<div class="main">
		<div class="container videobox clearfix">
			<div class="videocont clearfix">
				<ul class="clearfix">
			
				</ul>
			</div>
		</div>
	</div>

	<jsp:include page="../mfooter.jsp"></jsp:include>

	<script>
		var videocont= $(".videocont ul")
		function videoCont(parent, data) {
		  var html = '';
		  for (var i=0, len=data.length; i < len; i += 1) {
			  var urlStr =data[i].videoUrl;
			   function matchYoutubeUrl(url){
			   var p = /^(?:https?:\/\/)?(?:www\.)?(?:youtu\.be\/|youtube\.com\/(?:embed\/|v\/|watch\?v=|watch\?.+&v=))((\w|-){11})(?:\S+)?$/;
			    return (url.match(p)) ? RegExp.$1 : false ;
			   }
			  var urlNum =  matchYoutubeUrl(urlStr)
			  var urlytb =   "https://www.youtube.com/embed/"
			  var urlall = urlytb+urlNum;
			  // console.log(urlall)
				html += '<li onclick="clickVideo(event)" videonum-id="'+data[i].videoProid+'" dataiframe="'+urlall+'">' +
						'<img src="'+data[i].videoImgUrl+'">' +
						'<p><em>'+data[i].videoName+'</em></p>'+
						'</li>';
				}
		  parent.html(html);
		}
		var videoArea = '${sessionScope.videoArea}';
		data = {
			"videoArea":videoArea
		};
		$.ajax({
				 url: '${APP_PATH}/MlbackVideo/getMlbackVideoListByVideoArea',
                data:data,
				 type: 'post',
				 success: function (data) {
					// console.log(data)/***data**/
					   if (data.code === 100) {
						 var resData = data.extend.mlbackVideoList;
						 // console.log(resData)
						 videoCont(videocont,resData)
						 
					   } 
					 }
		       });
	/***********************************/
	function videoProduct (data,videoLink){
	 var elBox = $('<div class="video_enlarge_corver" style="display: block;"></div>');
	 var html = '<div class="video_enlarge_wrap">'+
	                   '<div class="video_enlarge_content">'+
							   '<iframe frameborder="0" allowfullscreen="1" allow="autoplay; encrypted-media" title="YouTube video player" width="100%" height="260" src="'+videoLink+'"></iframe>'+
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
	function clickVideo(e) {
		e.stopPropagation();
		var item  = $(e.target);
		var videoLink = item.parent().attr('dataiframe');
		var productId = item.parent().attr('videonum-id');
		data = {
			"productId":productId
		};
		console.log(productId)
		$.ajax({
				 url: '${APP_PATH}/MlbackProduct/getOneProductSimple',
		        data:data,
				 type: 'post',
				 success: function (data) {
					// console.log(data)/***data**/
					   if (data.code === 100) {
										    var resData = data.extend. mlbackProductOne;
											videoProduct(resData,videoLink)
					   } 
					 }
		       });
		
	}
	
	
	// function clickVideo (item){
	// 	$(".videocont ul li").on("click",function(){
			     
	// 	})
	// }


	</script>
  	<!-- megalook-->
  	<script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script>
	<!-- megalookhair 
  	<script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
  	<!-- huashuohair -->
  	<!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>