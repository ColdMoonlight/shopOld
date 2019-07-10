<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>产品详情</title>
  <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
  %>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, viewport-fit=cover">
  <link rel="stylesheet" href="${APP_PATH }/static/common/swiper/swiper.min.css">
  <script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
</head>
<body>

<jsp:include page="pcheader.jsp"></jsp:include>

<!-- main -->
<div class="main">
 <!-- <input type="hidden" value="${productId}" id="productId"/> -->
 <div class="product-details"> </div>

</div>
 
<jsp:include page="pcfooter.jsp"></jsp:include>

<script>
/* load tpl for detail of product */
$('.product-details').load('${APP_PATH}/static/tpl/productDetail.html', function() {
	//接到产品id，查询本id产品的详情
	var pidA = window.location.href.split('?')[1].split('=');
	
 	var swiper = $('.product__details-banner .swiper-wrapper');

	var conditionBox = $('.conditionBox');
	
	var productDetailsBox = $('.product__details-text');
	var prodcutDtitle = $('.product-d-title');
	var productDlengthList = $('.product-d-length').find('.list');
	var prodcutDpriceText = $('.product-d-price .price-text');
	var descriptionBox = $('.group-details.description');
	var reviewBox = $('.group-details review');

	var add = $('#product-num-add');
	var sub = $('#product-num-sub');
	var productNum = $('input[name="productNum"]');
	
	
	/* details of banner */
 	$.ajax({
 	  url: '${APP_PATH}/MlbackProductImg/getMlbackProductImgListByProductId',
 	  data: {"productId": pidA[1]},
 	  type:"POST",
 	  success: function(data) {
 	    if(data.code === 100) {
 	    	var html = '';
 	    	var imgs = data.extend.mbackProductImgResList;
 	    	for (var i=0; i<imgs.length; i+=1) {
 	    		html += '<div class="swiper-slide">' +
	 	 	         '<img src="'+ imgs[i].productimgUrl +'" alt="'+ imgs[i].productimgName +'">' +
	 	 	     '</div>';
 	    	}
 	    	
 	    	swiper.html(html);
 	    	
 	    	new Swiper('.product__details-banner', {
 	    		pagination: {
    		      el: '.swiper-pagination',
    		      clickable: true
    		    }
 	    	})
 	    } else {
 	      renderErrorMsg(swiper, '未获取到相关图片的数据');
 	    }
 	  }
 	});
	/* detials of condition（sku） */
	// MlbackProductSku/getOneProductAllSku  productId
	$.ajax({
	  url: '${APP_PATH}/MlbackProductSku/getOneProductAllSku',
	  data: {"productId": pidA[1]},
	  type:"POST",
	  success: function(data) {
	    if(data.code === 100) {
	    	// console.log(data)
	    	var conditionArr = data.extend.mlbackProductSkuResList;
	    	for(var i=0, len = conditionArr.length; i<len; i+=1) {
	    		renderCondition(conditionBox, conditionArr[i])	
	    	}
	    	resetPrice(conditionBox);
	    	triggerCondition(conditionBox);
	    }
	  }
	});
	
	function triggerCondition(parent) {
		parent.find('.product-d-length').each(function(i, item) {
			var activeItem = $(item).find('.price-item.active');
			$(item).find('.price-item').each(function(i, item) {
				$(item).on('click', function() {
					activeItem.removeClass('active');
					$(item).addClass('active');
					activeItem = $(item);
					resetPrice();
				})
			})
		});
	}
	function renderCondition(parent, data) {
		var conditionEl = $('<div class="container product-d-length"/>');
		var html = '';
		var len = 1;
		for(var key in data) {
			if (typeof data[key] === 'string' && data[key].indexOf(',') > -1) {
				data[key] = data[key].split(',');
				if (len === 1 ) {
					len = data[key].length;
				}
			}
		}
	   	html +=   '<span>'+ data.productskuName +':</span>';
	   	html +=   '<div class="list">';
	   	for(var i=0; i<len; i+=1) {
	   		if (i===0) {
	   			html +=   '<span class="price-item" data-price="'+ data.productskuMoneyDetails[i] +'">'+data.productskuNameDetails[i]+'</span>'
	   		} else {
	   			html +=   '<span class="price-item" data-price="'+ data.productskuMoneyDetails[i] +'">'+data.productskuNameDetails[i]+'</span>'
	   		}
	   	}
	   	html +=   '</div>';
	   	parent.append(conditionEl.html(html));
	}
	/* details of main */
	$.ajax({
	  url: '${APP_PATH}/MlbackProduct/getOneMlbackProductDetail',
	  data: {"productId": pidA[1]},
	  type:"POST",
	  success: function(data) {
	    if(data.code === 100) {
	    	var productData = data.extend.mlbackProductOne;
	    	// console.log(productData)
	    	prodcutDtitle.text(productData.productName);
	    	prodcutDpriceText.attr('data-price', productData.productOriginalprice);
	    	prodcutDpriceText.attr('data-discount', productData.productActoffoff);
	    	calPrice(productData.productOriginalprice, (productData.productOriginalprice*productData.productActoffoff/100).toFixed(2));
	    	descriptionBox.html(productData.productDesc);
	    	
	    	repeatCalPrice();
	    	
	    } else {
	      renderErrorMsg(productDetailsBox, '未获取到产品相关的数据');
	    }
	  }
	});
	// manipulate dom
	$('.list-group')
	.find('.list-group-item')
	.each(function(i, item) {
	  var details = $(item).find(".group-details");
	  $(item).find('.group-title').on('click', function() {
	    if(details.hasClass('active')) {
	      details.removeClass('active').hide();
	      $(this).find('.icon').removeClass('bottom').addClass('right');
	    } else {
	      details.addClass('active').show();
	      $(this).find('.icon').removeClass('right').addClass('bottom');
	    }
	  })
	});
	
	$('.review-list').find('.review-more').each(function(i, item) {
		$(item).on('click', function() {
		  if($(this).find('.icon').hasClass('bottom')) {
		   $(this).find('.icon').removeClass('bottom').addClass('top').parent().parent().find('.review-text').removeClass('review-ellipsis')
		  } else {
		   $(this).find('.icon').removeClass('top').addClass('bottom').parent().parent().find('.review-text').addClass('review-ellipsis')
		  }
		})
	});

	function calPrice(original, discount) {
		$(prodcutDpriceText.find('.original')).text('$' + original);
    	$(prodcutDpriceText.find('.discount')).text('$' + discount);
	}
	
	function repeatCalPrice() {
		var discount = prodcutDpriceText.data('discount')/100;
		sub.on('click', function() {
			var originalPrice = prodcutDpriceText.data('price') + calOverPrice();
			if (productNum.val() <= 1) {
				productNum.val(1);
				calPrice(originalPrice.toFixed(2), (originalPrice*discount).toFixed(2));
			} else {
				productNum.val(parseInt(productNum.val()) - 1);
				calPrice((productNum.val()*originalPrice).toFixed(2), (productNum.val()*originalPrice*discount).toFixed(2));
			}
		});
		add.on('click', function() {
			var originalPrice = prodcutDpriceText.data('price') + calOverPrice();
			productNum.val(parseInt(productNum.val()) + 1);
			calPrice((productNum.val()*originalPrice).toFixed(2), (productNum.val()*originalPrice*discount).toFixed(2));
		})
	}
	function calOverPrice() {
		var overPrice = 0;
		conditionBox.find('.price-item.active').each(function(i, item) {
			overPrice += parseFloat($(item).data('price'));
		});
		return overPrice;
	}
	// 重置价格
	function resetPrice() {
		var original = 0;
		var discount = 0;
		original = ((parseFloat(prodcutDpriceText.data('price')) + calOverPrice())*parseInt(productNum.val())).toFixed(2);
		discount = (original*parseFloat(prodcutDpriceText.data('discount'))/100).toFixed(2);
		calPrice(original, discount);
	}
});
</script>
</body>
</html>