<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
 %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<jsp:include page="pcheader.jsp"></jsp:include>
<!-- banner -->

<!--限时促销-->
<div class="index_row container">
    <div class="product_banner product_banner1 m_t_20"></div>
    <div class="product_list product_list1">
       <div class="row tt-layout-product-item"></div>
    </div>
</div>


<div class="index_row m_t_20 container">
    <div class="product_banner product_banner2 m_t_20"></div>
    <div class="product_list product_list2">
       <div class="row tt-layout-product-item"></div>
    </div>
</div>
<!-- ins -->
<div class="instagram-feed-area text-center">
    <div class="instagram-content-header">
        <h3><span>@Megalook</span> shop on Instagram</h3>
        <em>Follow us on instagram</em>
    </div>

    <div class="instagram-feed-thumb">
        <div id="instafeed" class="instagram-carousel" data-userid="6665768655"
            data-accesstoken="6665768655.1677ed0.313e6c96807c45d8900b4f680650dee5">
        </div>
    </div>

</div>

<jsp:include page="pcfooter.jsp"></jsp:include>
<%-- 
<script src="${APP_PATH }/static/pc/js/flickerplate.min.js" type="text/javascript"></script> --%>
<script>
/* banner */
var productBox = $('.product_list1').find('.tt-layout-product-item');
$.ajax({
  url: '${APP_PATH}/MlbackCategory/getOneMlbackCategoryDetail',
  data:"categoryId="+41,
  type:"POST",
  success: function(data) {
    if(data.code === 100) {
      // console.log(data.extend.mlbackCategoryOne);
      var category = data.extend.mlbackCategoryOne;
      // categoryName categoryImgurl
      var  html = '';
      $('.product_banner1').html('<img src="' + category.categoryImgurl + '" alt=" + category.categoryName + ">');
    } else {
      renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
    }
  }
});
 /*------block1 rednerProduct1----------*/
function rednerProduct1(parent, data) {
  var html='';
  for(var i=0; i<data.length; i+=1) {
		html += '<div class="col-6 col-md-4 col-lg-3">' +
			'<div class="tt-product thumbprod-center">' +
				'<div class="tt-image-box">' +
					'<a href="#" class="tt-btn-quickview" data-toggle="modal" data-target="#ModalquickView"	data-tooltip="Quick View" data-tposition="left"></a>' +
					'<a href="#" class="tt-btn-wishlist" data-tooltip="Add to Wishlist" data-tposition="left"></a>' +
					'<a href="#" class="tt-btn-compare" data-tooltip="Add to Compare" data-tposition="left"></a>' +
					'<a href="${APP_PATH}/MlbackProduct/tomProductDetailPagePC?productId=' + data[i].productId +'">' +
						'<span class="tt-img"><img src="' + data[i].productMainimgurl + '" alt=""></span>' +
						'<span class="tt-img-roll-over"><img src="' + data[i].productMainFuimgurl + '" alt=""></span>' +
					'</a>' +
				'</div>' +
				'<div class="tt-description">' +
					'<div class="tt-row">' +
						'<ul class="tt-add-info">' +
							'<li><a href="#">' + data[i].productCategoryname + '</a></li>' +
						'</ul>' +
						'<div class="tt-rating">';
						for(var j=0; j<5; j+=1) {
							html+= '<i class="icon-star"></i>';
						}
			html+=     '</div>' +
					'</div>' +
					'<h2 class="tt-title"><a href="${APP_PATH}/MlbackProduct/tomProductDetailPagePC?productId=' + data[i].productId +'">' + data[i].productName + '</a></h2>' +
					'<div class="tt-price">$' + (data[i].productOriginalprice && data[i].productActoffoff ? (data[i].productOriginalprice*data[i].productActoffoff/100).toFixed(2) : 0) + '</div>' +
					'<div class="tt-reviews">'+ data[i].productReviewnum +' Reviews</div>' +
					'<div class="tt-product-inside-hover">' +
						'<div class="tt-row-btn">' +
							'<a href="#" class="tt-btn-addtocart thumbprod-button-bg" data-toggle="modal" data-target="#modalAddToCartProduct">ADD TO CART</a>' +
						'</div>' +
						'<div class="tt-row-btn">' +
							'<a href="#" class="tt-btn-quickview" data-toggle="modal" data-target="#ModalquickView"></a>' +
							'<a href="#" class="tt-btn-wishlist"></a>' +
							'<a href="#" class="tt-btn-compare"></a>' +
						'</div>' +
					'</div>' +
				'</div>' +
			'</div>' +
		'</div>';
  }

  parent.html(html);
}

$.ajax({
  url: '${APP_PATH}/MlbackProduct/getMlbackProductByparentCategoryIdList',
  data:"productCategoryid="+41,
  type:"POST",
  success: function(data) {
    // console.log(productList1)
    if(data.code === 100) {
      // console.log(data.extend.mlbackProductResList);
      rednerProduct1(productBox, data.extend.mlbackProductResList)
    } else {
      renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
    }
  }
});

/*---------------block2 banner2--------*/
$.ajax({
  url: '${APP_PATH}/MlbackCategory/getOneMlbackCategoryDetail',
  data:"categoryId="+41,
  type:"POST",
  success: function(data) {
    if(data.code === 100) {
      // console.log(data.extend.mlbackCategoryOne);
      var category = data.extend.mlbackCategoryOne;
      // categoryName categoryImgurl
      var  html = '';
      $('.product_banner2').html('<img src="' + category.categoryImgurl + '" alt=" + category.categoryName + ">');
    } else {
      renderErrorMsg(prodcutBox2, '未获取到产品相关的数据');
    }
  }
});
/*------rblock2 ednerProduct2----------*/
function rednerProduct2(parent, data) {
  var html='';
  for(var i=0; i<data.length; i+=1) {
	  html += '<div class="col-6 col-md-4 col-lg-3">' +
		'<div class="tt-product thumbprod-center">' +
			'<div class="tt-image-box">' +
				'<a href="#" class="tt-btn-quickview" data-toggle="modal" data-target="#ModalquickView"	data-tooltip="Quick View" data-tposition="left"></a>' +
				'<a href="#" class="tt-btn-wishlist" data-tooltip="Add to Wishlist" data-tposition="left"></a>' +
				'<a href="#" class="tt-btn-compare" data-tooltip="Add to Compare" data-tposition="left"></a>' +
				'<a href="${APP_PATH}/MlbackProduct/tomProductDetailPagePC?productId=' + data[i].productId +'">' +
					'<span class="tt-img"><img src="' + data[i].productMainimgurl + '" alt=""></span>' +
					'<span class="tt-img-roll-over"><img src="' + data[i].productMainFuimgurl + '" alt=""></span>' +
				'</a>' +
			'</div>' +
			'<div class="tt-description">' +
				'<div class="tt-row">' +
					'<ul class="tt-add-info">' +
						'<li><a href="#">' + data[i].productCategoryname + '</a></li>' +
					'</ul>' +
					'<div class="tt-rating">';
					for(var j=0; j<5; j+=1) {
						html+= '<i class="icon-star"></i>';
					}
		html+=     '</div>' +
				'</div>' +
				'<h2 class="tt-title"><a href="${APP_PATH}/MlbackProduct/tomProductDetailPagePC?productId=' + data[i].productId +'">' + data[i].productName + '</a></h2>' +
				'<div class="tt-price">$' + (data[i].productOriginalprice && data[i].productActoffoff ? (data[i].productOriginalprice*data[i].productActoffoff/100).toFixed(2) : 0) + '</div>' +
				'<div class="tt-reviews">'+ data[i].productReviewnum +' Reviews</div>' +
				'<div class="tt-product-inside-hover">' +
					'<div class="tt-row-btn">' +
						'<a href="#" class="tt-btn-addtocart thumbprod-button-bg" data-toggle="modal" data-target="#modalAddToCartProduct">ADD TO CART</a>' +
					'</div>' +
					'<div class="tt-row-btn">' +
						'<a href="#" class="tt-btn-quickview" data-toggle="modal" data-target="#ModalquickView"></a>' +
						'<a href="#" class="tt-btn-wishlist"></a>' +
						'<a href="#" class="tt-btn-compare"></a>' +
					'</div>' +
				'</div>' +
			'</div>' +
		'</div>' +
	'</div>';
  }

  parent.html(html);
}
var productBox2 = $('.product_list2').find('.tt-layout-product-item');
$.ajax({
  url: '${APP_PATH}/MlbackProduct/getMlbackProductByparentCategoryIdList',
  data:"productCategoryid="+41,
  type:"POST",
  success: function(data) {
    // console.log(productList2)
    if(data.code === 100) {
      // console.log(data.extend.mlbackProductResList);
      rednerProduct2(productBox2, data.extend.mlbackProductResList)
    } else {
      renderErrorMsg(prodcutBox2, '未获取到产品相关的数据');
    }
  }
});
</script>
</body>
</html>