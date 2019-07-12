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
    <div class="product-banner1 banner"></div>
    <div class="product-list1 product-list"> </div>
    <div class="product-banner2 banner"></div>
    <div class="product-list2 product-list"> </div>
    <div class="product-banner3 banner"></div>
    <div class="product-list3 product-list"> </div>
    <div class="product-banner4 banner"></div>
    <div class="product-list4 product-list"> </div>
  </div>

  <jsp:include page="mfooter.jsp"></jsp:include>
  <script src="${APP_PATH }/static/js/countdown.min.js"></script>
  <script>
    function rednerProductActShowPro(parent, data) {
      var html = '';
      for (var i = 0; i < data.length; i += 1) {
        html += '<div class="banner">' +
          '<a href="${APP_PATH}/MlbackProduct/tomProductDetailPage?productId=' + data[i].actshowproProid + '">' +
          '<img src="' + data[i].actshowproImgwapurl + '" alt="">' +
          '</a>' +
          '</div>';
      }
      parent.html(html);
    }
    var productFirstList = $('#showPro');
    $.ajax({
      url: '${APP_PATH}/MlbackActShowPro/getMlbackActShowProListByActnum',
      data: "actshowproActnum=" + 1,
      type: "POST",
      success: function (data) {
        // console.log("mlbackActShowProList");
        if (data.code === 100) {
          console.log(data.extend.mlbackActShowProList);
          rednerProductActShowPro(productFirstList, data.extend.mlbackActShowProList)
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
	      format: 'd : h : m : S',
	      themeClass: 'dark',
	      interval: 1000,
	      state: true,
	    });
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
    /*---------------block1 banner1--------*/
    $.ajax({
      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
      data: "showareaNumth=" + 1,
      type: "POST",
      success: function (data) {
        if (data.code === 100) {
          // console.log(data.extend.mlbackCategoryOne);
          var showArea = data.extend.mlbackShowAreaOne;
          // categoryName categoryImgurl
          $('.product-banner1.banner').html('<img src="' + showArea.showareaImgurl +
            '" alt=" + showArea.showareaName + ">');
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });
    /*------block1 rednerProduct1----------*/
    function rednerProduct1(parent, data) {
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

      parent.html(html);
    }
    var productList1 = $('.product-list1');
    $.ajax({
      url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
      data: "productLable=" + 1,
      type: "POST",
      success: function (data) {
        // console.log(productList1)
        if (data.code === 100) {
          // console.log(data.extend.mlbackProductResList);
          rednerProduct1(productList1, data.extend.mlbackProductResList)
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });
    /*---------------block2 banner2--------*/

    $.ajax({
      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
      data: "showareaNumth=" + 2,
      type: "POST",
      success: function (data) {
        if (data.code === 100) {
          // console.log(data.extend.mlbackCategoryOne);
          var showArea = data.extend.mlbackShowAreaOne;
          // categoryName categoryImgurl
          $('.product-banner2.banner').html('<img src="' + showArea.showareaImgurl +
            '" alt=" + showArea.showareaName + ">');
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });
    /*------rblock2 ednerProduct2----------*/
    function rednerProduct2(parent, data) {
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

      parent.html(html);
    }
    var productList2 = $('.product-list2');
    $.ajax({
      url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
      data: "productLable=" + 2,
      type: "POST",
      success: function (data) {
        //console.log(productList2)
        if (data.code === 100) {
          //console.log(data.extend.mlbackProductResList);
          rednerProduct2(productList2, data.extend.mlbackProductResList)
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });

    /*---------------block3 banner3--------*/
    $.ajax({
      /* url: '${APP_PATH}/MlbackCategory/getOneMlbackCategoryDetail',
      data: "categoryId=" + 57,
      type: "POST",
      success: function (data) {
        if (data.code === 100) {
          //console.log(data.extend.mlbackCategoryOne);
          var category = data.extend.mlbackCategoryOne;
          // categoryName categoryImgurl
          $('.product-banner3.banner').html('<img src="' + category.categoryImgurl +
            '" alt=" + category.categoryName + ">');
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      } */
      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
      data: "showareaNumth=" + 3,
      type: "POST",
      success: function (data) {
        if (data.code === 100) {
          // console.log(data.extend.mlbackCategoryOne);
          var showArea = data.extend.mlbackShowAreaOne;
          // categoryName categoryImgurl
          $('.product-banner3.banner').html('<img src="' + showArea.showareaImgurl +
            '" alt=" + showArea.showareaName + ">');
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });

    /*------block3 rednerProduct3----------*/
    function rednerProduct3(parent, data) {
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

      parent.html(html);
    }
    var productList3 = $('.product-list3');
    $.ajax({
      url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
      data: "productLable=" + 3,
      type: "POST",
      success: function (data) {
        // console.log(productList)
        if (data.code === 100) {
          //console.log(data.extend.mlbackProductResList);
          rednerProduct3(productList3, data.extend.mlbackProductResList)
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });
    /*---------------block4 banner4--------*/
    $.ajax({
      url: '${APP_PATH}/MlbackShowArea/getMlbackShowAreaOne',
      data: "showareaNumth=" + 4,
      type: "POST",
      success: function (data) {
        if (data.code === 100) {
          // console.log(data.extend.mlbackCategoryOne);
          var showArea = data.extend.mlbackShowAreaOne;
          // categoryName categoryImgurl
          $('.product-banner4.banner').html('<img src="' + showArea.showareaImgurl +
            '" alt=" + showArea.showareaName + ">');
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });

    /*------block4 rednerProduct4----------*/
    function rednerProduct4(parent, data) {
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

      parent.html(html);
    }
    var productList4 = $('.product-list4');
    $.ajax({
      url: '${APP_PATH}/MlbackProduct/getMlbackProductLableList',
      data: "productLable=" + 4,
      type: "POST",
      success: function (data) {
        // console.log(productList)
        if (data.code === 100) {
          console.log("productList4");
          rednerProduct4(productList4, data.extend.mlbackProductResList)
        } else {
          renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
        }
      }
    });
  </script>
</body>

</html>