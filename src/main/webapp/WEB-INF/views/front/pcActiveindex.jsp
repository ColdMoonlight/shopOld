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
  
  <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/pc/css/shengdan.css"/>
	<!-- main -->
		<div class="hd_ban clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_01.jpg" /></div>
		<div class="con_ban clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_02.jpg"/></div>	
		<div class="box_con1 clearfix">
			<div class="word1 clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_03.jpg" /></div>
			<div class="zs_link clearfix"><a href="${APP_PATH}/B-360-Body-Wave-Wig.html"><img src="${APP_PATH }/static/pc/shengdan/sdhd_06.jpg" ></a></div>	
			<div class="xia_two clearfix">
				<div class="zss_link clearfix"><a href="${APP_PATH}/2x6-Straight-Wave-Bob-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_09.jpg" ></a></div>
				<div class="zxx_link clearfix"><a href="${APP_PATH}/search/13x6-Lace-Frontal-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_11.jpg" ></a></div>	
			</div>
			<div class="xia_two clearfix">
				<div class="zss_link clearfix"><a href="${APP_PATH}/2x6-Straight-Wave-Bob-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_15.jpg" ></a></div>
				<div class="zxx_link clearfix"><a href="${APP_PATH}/search/13x6-Lace-Frontal-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_16.jpg" ></a></div>	
			</div>
			<br />	<br />	<br />	<br />	<br />
		</div>	
		<div class="yellowbg">
			<div class="word2 clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_19.jpg" /></div>
			<div class="five_5cont clearfix"> <div id="product-block"></div></div>	
			<br />	<br />	<br />	<br />	<br />
		</div>
		<div class="hongbg clearfix">
			 <div class="word3 clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_21.jpg" /></div>
			<div class="dwbox">
				<div class="product_box_cont clearfix">
						<div id="product-block2"></div>
						<p class="morelink"><a href="${APP_PATH}/search/13x4-Lace-Frontal-Wig.html">VIEW MORE>></a></p>
				</div>
			</div>
			<br />	<br />	<br />
		</div>
		<div class="box_con1 clearfix">
			 <div class="word3 clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_23.jpg" /></div>
			<div class="lei_cont clearfix">
				<ul class="clearfix">
					<li><a href="${APP_PATH}/search/360-Lace-Frontal-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_26.jpg" ></a></li>
					<li><a href="${APP_PATH}/search/Full-Lace-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_28.jpg" ></a></li>
					<li><a href="${APP_PATH}/search/13x4-Lace-Frontal-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_30.jpg" ></a></li>
					<li><a href="${APP_PATH}/search/Bob-Wig.html"><img src="${APP_PATH}/static/pc/shengdan/sdhd_32.jpg" ></a></li>
				</ul>
				<br />	<br />	<br /><br />	<br />
			</div>
			<div class="cont_mybox">
				 <div class="word3 clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_38.jpg" /></div>
				<div class="product_box_cont producthuang clearfix">
					<div class="">
				    	<div id="product-block3"></div>
						<!-- <p class="morelink"><a href="###">VIEW MORE>></a></p> -->
					</div>
					<br />	<br />	<br /><br />	<br />
				</div>
				 <div class="word3 clearfix"><img src="${APP_PATH}/static/pc/shengdan/sdhd_21.jpg" /></div>
				<div class="product_box_cont producthong clearfix">
					<div class="" style="">
				    	<div id="product-block4"></div>
						<p class="morelink"><a href="${APP_PATH}/search/Bundle-With-Closure.html">VIEW MORE>></a></p>
					</div>
					<br />	<br />	<br />
					<div class="link_home"><a href="${APP_PATH}/index.html">BACK TO HOME!</a></div>
					<br />	<br />	<br />
				</div>
			</div>
		</div>
		
			
		
		
	 
			
			
		
  
  <jsp:include page="pcfooter.jsp"></jsp:include>
 	<script src="${APP_PATH }/static/js/countdown.min.js"></script>
	<script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
  <script>


    /*------rednerProduct----------*/
    function rednerProduct(data) {
      var html = '';
      for (var i = 0; i < data.length; i += 1) {
		  var productactoffif = data[i].productActoffIf;
		  // console.log(productactoffif)
		  var productactoffid  =  data[i].productActoffid;
           // console.log(productactoffid)  
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
		  
        html += '<div class="product-item col-lg-3">' +
		          '<span class="hui_icon '+showspan+'"></span>'+
          		'<div class="product-img">' +
          		'<a href="${APP_PATH}/' + data[i].productSeo + '.html">' +
          		'<img src="' + data[i].productMainimgurl + '" alt="">' +
          		'</a>' +
          		/* '<div class="product-item col-lg-3">' +
          		'<div class="product-img">' +
          		'<a href="${APP_PATH}/MlbackProduct/topcProductDetailPage?productId=' + data[i].productId + '">' +
          		'<img src="' + data[i].productMainimgurl + '" alt="">' +
          		'</a>' + */
          '</div>' +
          '<div class="product-desc">' +
          '<div class="product-title">' + data[i].productName + '</div>' +
          '<div class="product-type"></div>' +
          // '<div class="product-data">' +
          // '<span class="pay-num">' + (data[i].productHavesalenum ? data[i].productHavesalenum : 0) + ' Payment</span>' +
          // '<span class="review-num">' + (data[i].productReviewnum ? data[i].productReviewnum : 0) +
          // ' Review(s)</span>' +
          // '</div>' +
          '<div class="product-price">' +
          '<span class="product-now-price">$' + (data[i].productOriginalprice && data[i].productActoffoff ? (data[i]
            .productOriginalprice * data[i].productActoffoff / 100).toFixed(2) : 0) + '</span>' +
          '<span class="product-define-price">$' + (data[i].productOriginalprice ? data[i].productOriginalprice : 0) +
          '</span>' +
          '<span class="product-to-cart" data-id="' + data[i].productId + '"><i class="icon cart2"></i></span>' +
          '</div>' +
		  '<div class="buynew">' +
		  '<a href="${APP_PATH}/' + data[i].productSeo + '.html">' +
		  '<span>BUY NOW</span>'+
		  '</a>' +
		  '</div>' +
          '</div>' +
          '</div>';
      }

      return $('<div class="product-list"></div>').html(html);
    }
    /*------rednerBanner----------*/

    /*---------------product block--------*/
    	var productBlock = $('#product-block');
    	// product
   	 	$.ajax({
         url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
         data: "productLable=" +1,
         type: "POST",
         async: false,
         success: function (data) {
           // console.log(productList1)
           if (data.code === 100) {
             var productData = data.extend.mlbackProductResList;
             // number5Times(productData.length,productData);
             // console.log(productData);
             // productBlock.append(rednerProduct(productData));
			 productBlock.append(rednerProduct(number5Times(productData.length,productData)));
           } else {
             renderErrorMsg(prodcutBox, 'Not acquired product-related data');
           }
         }
       });
	   function number5Times(len,productData) {
	       var lens=parseInt(len-(len%5));
	   	return productData.slice(0,lens);
	      }
    /*---------------product block2--------*/
    	var productBlock2 = $('#product-block2');
    	// product
     	$.ajax({
         url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
         data: "productLable=" +2,
         type: "POST",
         async: false,
         success: function (data) {
           // console.log(productList1)
           if (data.code === 100) {
             var productData = data.extend.mlbackProductResList;
             // number5Times(productData.length,productData);
             // console.log(productData);
             // productBlock.append(rednerProduct(productData));
    		 productBlock2.append(rednerProduct(number4Times(productData.length,productData)));
           } else {
             renderErrorMsg(prodcutBox, 'Not acquired product-related data');
           }
         }
       });
	/**********************************************************/

		var productBlock3 = $('#product-block3');
		// product
	 	$.ajax({
	     url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
	     data: "productLable=" +3,
	     type: "POST",
	     async: false,
	     success: function (data) {
	       // console.log(productList1)
	       if (data.code === 100) {
	         var productData = data.extend.mlbackProductResList;
	         // number5Times(productData.length,productData);
	         // console.log(productData);
	         // productBlock.append(rednerProduct(productData));
			 productBlock3.append(rednerProduct(number4Times(productData.length,productData)));
	       } else {
	         renderErrorMsg(prodcutBox, 'Not acquired product-related data');
	       }
	     }
	   });
	   /*************************************/
	var productBlock4 = $('#product-block4');
			// product
		 	$.ajax({
	  url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
	  data: "productLable=" +4,
	  type: "POST",
	  async: false,
	  success: function (data) {
	    // console.log(productList1)
	    if (data.code === 100) {
	      var productData = data.extend.mlbackProductResList;
	      // number5Times(productData.length,productData);
	      // console.log(productData);
	      // productBlock.append(rednerProduct(productData));
				 productBlock4.append(rednerProduct(number4Times(productData.length,productData)));
	    } else {
	      renderErrorMsg(prodcutBox, 'Not acquired product-related data');
	    }
	  }
	});
	
	/****************************/
		  function number4Times(len,productData) {
		      var lens=parseInt(len-(len%4));
		  	return productData.slice(0,lens);
		     }
/***********************************************/



	
  </script>
  	<!-- megalook-->
  	<script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script>
	<!-- megalookhair 
  	<script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
  	<!-- huashuohair -->
  	<!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>