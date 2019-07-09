<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
  %>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, viewport-fit=cover">
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
  <link rel="stylesheet" href="${APP_PATH }/static/common/swiper/swiper.min.css">
  <script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
</head>
<body>

<jsp:include page="mheader.jsp"></jsp:include>

<!-- main -->
<div class="main">
 <!-- <input type="hidden" value="${productId}" id="productId"/> -->
 <div class="product-details"> </div>

</div>
 
<jsp:include page="mfooter.jsp"></jsp:include>

<script>
/* load tpl for detail of product */
$('.product-details').load('${APP_PATH}/static/tpl/productDetail.html', function() {
	//接到产品id，查询本id产品的详情
	var pidA = window.location.href.split('?')[1].split('=');
	var dataPrice = null;
	
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
	var skuCheckData={};
	$.ajax({
	  //url: '${APP_PATH}/MlbackProductSku/getOneProductAllSku',
	  url: '${APP_PATH}/MlbackProductSku/getfrontOneProductAllSku',//这个是只查yes的sku
	  data: {"productId": pidA[1]},
	  type:"POST",
	  success: function(data) {
	    if(data.code === 100) {
	    	// console.log(data)
	    	var conditionArr = data.extend.mlbackProductSkuResList;
	    	for(var i=0, len = conditionArr.length; i<len; i+=1) {
	    		skuCheckData[conditionArr[i].productskuName] = null;
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
					// console.log(activeItem.parent().parent().data('name'), activeItem.data('price'))
					skuCheckData[activeItem.parent().parent().data('name')] = activeItem.data('price');
					resetPrice();
				})
			})
		});
	}
	function renderCondition(parent, data) {
		var conditionEl = $('<div class="container product-d-length" data-name="'+ data.productskuName +'" data-id="'+ data.productskuId +'"/>');
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
	   	html +=  '<span class="sku-id-name">'+ data.productskuName +':</span>';
	   	html +=  '<div class="list">';
	   	for(var i=0; i<len; i+=1) {
	   		if (i===0) {
	   			html +=  '<span class="price-item" data-price="'+ toNumber(data.productskuMoneyDetails[i]) +'">'+ data.productskuNameDetails[i] +'</span>'
	   		} else {
	   			html +=  '<span class="price-item" data-price="'+ toNumber(data.productskuMoneyDetails[i]) +'">'+ data.productskuNameDetails[i] +'</span>'
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
	    	dataPrice = productData;
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
		$(prodcutDpriceText.find('.original')).text('$' +original);
    	$(prodcutDpriceText.find('.discount')).text('$' +discount);
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
	
	// add-to-cart
	/*
    private Integer cartitemProductId;
    private String cartitemProductName;
    private BigDecimal cartitemProductOriginalprice;
    private String cartitemProductMainimgurl;
    private Integer cartitemProductActoff;
    private String cartitemProductskuIdstr;
    private String cartitemProductskuIdnamestr;
    private String cartitemProductskuNamestr;
    private String cartitemProductskuMoneystr;
    private Integer cartitemProductNumber;
	*/
	$('.add-to-cart').on('click', function() {
		// console.log(dataPrice)
		var skuData = getSkuData($('.product-d-length'));
		var reqData = {};
		reqData.cartitemProductId = parseInt(pidA[1]);
		reqData.cartitemProductName = dataPrice.productName;
		reqData.cartitemProductOriginalprice = dataPrice.productOriginalprice;
		reqData.cartitemProductMainimgurl = dataPrice.productMainimgurl;
		reqData.cartitemProductActoff = dataPrice.productActoffid;
		reqData.cartitemProductskuIdstr = skuData.id.join(',');
		reqData.cartitemProductskuIdnamestr = skuData.idName.join(',');
		reqData.cartitemProductskuNamestr = skuData.itemName.join(',');
		reqData.cartitemProductskuMoneystr = skuData.price.join(',');
		reqData.cartitemProductNumber = productNum.val();
		// console.log(data);
		
		// name, id, price
		function getSkuData(els) {
			var data = {
					itemName: [],
					id:[],
					idName: [],
					price: []
			};
			els.each(function(i, item) {
				data.itemName.push($(item).find('.price-item.active').text());
				data.id.push($(item).data('id'));
				data.idName.push($(item).data('name'));
				data.price.push($(item).find('.price-item.active').data('price'));
			});
			
			return data;
		}
		
		var flag = false
		
		// console.log(skuCheckData);
		flag = checkSku(skuCheckData);
		// console.log(flag)
		if (flag) generateOrder(reqData);
		
	});
	
	function checkSku(skuCheckData) {
		for(var i in skuCheckData) {
			if (skuCheckData[i] === null) {
				alert('请选择产品属性 ' + i);
				return false;
			}
		}
		
		return true;
	}
	
	function generateOrder(reqData) {
		// console.log(reqData)
		$.ajax({
			  url: '${APP_PATH}/MlbackCart/toAddToCart',
			  data: JSON.stringify(reqData),
			  type:"POST",
			  dataType: 'JSON',
			  contentType: 'application/json',
			  success: function(data) {
				var resData = JSON.parse(data);
			    if(resData.code === 100) {
			    	// console.log(resData)
			    	// cartText.text(parseInt(cartText.text()) + 1);
			    	window.location.href='${APP_PATH}/MlbackCart/toCartList';
			    }
			  },
			  error: function(data) {
				  cartText.text(num);
			  }
		});
	}

	/* $('.buy-now').on('click', function() {
		window.location.href='${APP_PATH}/MlbackCart/toCartList';
	}) */
	
	
	$('.buy-now').on('click', function() {
		// console.log(dataPrice)
		var skuData = getSkuData($('.product-d-length'));
		var reqData = {};
		reqData.cartitemProductId = parseInt(pidA[1]);
		reqData.cartitemProductName = dataPrice.productName;
		reqData.cartitemProductOriginalprice = dataPrice.productOriginalprice;
		reqData.cartitemProductMainimgurl = dataPrice.productMainimgurl;
		reqData.cartitemProductActoff = dataPrice.productActoffid;
		reqData.cartitemProductskuIdstr = skuData.id.join(',');
		reqData.cartitemProductskuIdnamestr = skuData.idName.join(',');
		reqData.cartitemProductskuNamestr = skuData.itemName.join(',');
		reqData.cartitemProductskuMoneystr = skuData.price.join(',');
		reqData.cartitemProductNumber = productNum.val();
		// console.log(data);
		
		// name, id, price
		function getSkuData(els) {
			var data = {
					itemName: [],
					id:[],
					idName: [],
					price: []
			};
			els.each(function(i, item) {
				data.itemName.push($(item).find('.price-item.active').text());
				data.id.push($(item).data('id'));
				data.idName.push($(item).data('name'));
				data.price.push($(item).find('.price-item.active').data('price'));
			});
			
			return data;
		}
		
		var flag = false
		
		// console.log(skuCheckData);
		flag = checkSku(skuCheckData);
		// console.log(flag)
		if (flag) generateOrderNow(reqData);
		
	});
	
	
	function generateOrderNow(reqData) {
		// console.log(reqData)
		$.ajax({
			  url: '${APP_PATH}/MlbackCart/toBuyNow',
			  data: JSON.stringify(reqData),
			  type:"POST",
			  dataType: 'JSON',
			  contentType: 'application/json',
			  success: function(data) {
				var resData = JSON.parse(data);
			    if(resData.code === 100) {
			    	// console.log(resData)
			    	// cartText.text(parseInt(cartText.text()) + 1);
			    	window.location.href='${APP_PATH}/MlbackCart/toCheakOut';
			    }
			  },
			  error: function(data) {
				  cartText.text(num);
			  }
		});
	}
	
});
</script>
</body>
</html>