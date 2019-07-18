<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="UTF-8">
  <title>Shop Hair</title>
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
</head>

<body>

  <jsp:include page="mheader.jsp"></jsp:include>

  <!-- main -->
  <div class="main">
    <!-- sale -->
    <div class="banner">
      <a href="#" alt="">
        <img src="${APP_PATH }/static/m/img/firstpage/first1.jpg" alt="">
      </a>
    </div>
    <!-- count date -->
    <div class="banner">
      <a href="#" alt="">
        <img src="${APP_PATH }/static/m/img/firstpage/first2.jpg" alt="">
      </a>
    </div>
    <!-- countDownArea date -->
    <div id="countdown-area"> </div>
    <!-- product intro -->
    <div id="showPro"></div>
    <!-- product show -->
    <div id="product-block"></div>
  </div>

  <jsp:include page="mfooter.jsp"></jsp:include>
  <script src="${APP_PATH }/static/js/countdown.min.js"></script>
 <%--  <script src="${APP_PATH }/static/common/intersectionobserver.js"></script> --%>
  <script>
    function rednerProductActShowPro(parent, data) {
      var html = '';
      for (var i = 0; i < data.length; i += 1) {
        html += '<div class="banner">' +
          '<a href="${APP_PATH}/MlbackProduct/tomProductDetailPage?productId=' + data[i].actshowproProid + '">' +
//          	'<img /* src="${APP_PATH }/static/img/position.png" data- */src="' + data[i].actshowproImgwapurl + '" alt="">' +
		'<img src="' + data[i].actshowproImgwapurl + '" alt="">' +
          '</a>' +
          '</div>';
      }
      parent.html(html);
    }
		/* xxxx */
    $.ajax({
      url: '${APP_PATH}/MlbackActShowPro/getMlbackActShowProListByActnum',
      data: "actshowproActnum=" + 1,
      type: "POST",
      success: function (data) {
        // console.log("mlbackActShowProList");
        if (data.code === 100) {
          // console.log(data.extend.mlbackActShowProList);
          rednerProductActShowPro($('#showPro'), data.extend.mlbackActShowProList)
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });
    
    /*---------------countDownArea--------*/
    function rednerCountDownAreaOne(parent, data) {
      var html = '';
      html += '<div class="title">'+data.countdownTitle+'</div>'+
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
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });

    /*------rednerProduct----------*/
    function rednerProduct(data) {
      var html = '';
      for (var i = 0; i < data.length; i += 1) {
        html += '<div class="product-item">' +
          '<div class="product-img">' +
          '<a href="${APP_PATH}/MlbackProduct/tomProductDetailPage?productId=' + data[i].productId + '">' +
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

      return $('<div class="product-list"></div>').html(html);
    }
    /*------rednerBanner----------*/
    function renderBanner(data) {
    	return $('<div class="banner"></div>').html('<img src="' + data.showareaImgurl + '" alt=" + data.showareaName + ">');
    }
    
		var blockList = [
 		  { banner: 1, product: 1},
 		  { banner: 2, product: 2},
 		  { banner: 3, product: 3},
 		  { banner: 4, product: 4}
 		];
    /*---------------product block--------*/
    for (var i=0, len=blockList.length; i<len; i+=1) {
    	var productBlock = $('#product-block');
    	// banner
   	 	$.ajax({
 	      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
 	      data: "showareaNumth=" + blockList[i].banner,
 	      type: "POST",
 	      async: false,
 	      success: function (data) {
 	        if (data.code === 100) {
 	          var bannerData = data.extend.mlbackShowAreaOne;
 	          // console.log(bannerData);
 	          // categoryName categoryImgurl;
 	          productBlock.append(renderBanner(bannerData))
 	        } else {
 	          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
 	        }
 	      }
 	    });
    	// product
   	 	$.ajax({
         url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
         data: "productLable=" + blockList[i].product,
         type: "POST",
         async: false,
         success: function (data) {
           // console.log(productList1)
           if (data.code === 100) {
             var productData = data.extend.mlbackProductResList;
             // console.log(productData);
             productBlock.append(rednerProduct(productData));
           } else {
             renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
           }
         }
       });
    }
  </script>
</body>

</html>