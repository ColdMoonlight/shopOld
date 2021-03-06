<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Cart List</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
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

	<!-- Facebook Pixel Code 这是facebook广告插件可以注释掉，但不要删除-->
	<script>
		!function (f, b, e, v, n, t, s) {
			if (f.fbq) return; n = f.fbq = function () {
				n.callMethod ?
				n.callMethod.apply(n, arguments) : n.queue.push(arguments)
			};
			if (!f._fbq) f._fbq = n; n.push = n; n.loaded = !0; n.version = '2.0';
			n.queue = []; t = b.createElement(e); t.async = !0;
			t.src = v; s = b.getElementsByTagName(e)[0];
			s.parentNode.insertBefore(t, s)
		}(window, document, 'script', 'https://connect.facebook.net/en_US/fbevents.js');
		fbq('init', '246433859565492');//huashuohair
		//fbq('init', '667403967094866');//megalook
		fbq('track', 'PageView');
	</script>
	<!--huashuohair-->
	<noscript><img height="1" width="1" style="display:none"src="https://www.facebook.com/tr?id=246433859565492&ev=PageView&noscript=1" /></noscript>
	<!--megalook-->
	<!-- <noscript><img height="1" width="1" style="display:none"src="https://www.facebook.com/tr?id=667403967094866&ev=PageView&noscript=1" /></noscript> -->
	<!-- End Facebook Pixel Code -->
 
	<script>
		fbq('track', 'ViewContent');
	</script>
	<!-- Facebook Pixel Code end -->
</head>

<body>
	<jsp:include page="pcheader.jsp"></jsp:include>
	<!-- main -->
	<div class="main cart-box clearfix">
		<div class="container cat_list_box clearfix">
			<div class="cart-title" style="display: none">
				<img class="purechase-step" src="${APP_PATH }/static/pc/img/sep1.jpg">
			</div>
			<!-- purechase step -->
			<div class="cart-page">
				<div class="cart-list"></div>
				<div class="cart-footer" style="display: none">
					<div class="show-t-num">
						<span class="show-t-num-text">NUMTOTAL:</span>
						<span class="show-t-num-num"></span>
					</div>
					<div class="show-t-price">
						<span class="show-t-price-text">SUBTOTAL:</span>
						<span class="show-t-price-num"></span>
					</div>
					<div class="op">
						<a href="${APP_PATH}/index.html" class="btn add-product">Continue To Add</a>
						<a href="javascript:;" class="btn calc-price" id="clickCheckoutGooGle">calculate Price</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container hot_tuijian">
		<!--**********热门推荐*********************************-->
		<div class="hot_box_product clearfix" style="display: none;">
			<h3>RECOMMENDATION FOR YOU</h3>
			<div class="swiper-container hot_box_product_cont">
				<div class="swiper-wrapper"></div>
				<div class="swiper-pagination swiper-pagination2"></div>
				<div class="swiper-button-nextcc"></div>
				<div class="swiper-button-prevcc"></div>
			</div>
		</div>
	</div>
	<jsp:include page="pcfooter.jsp"></jsp:include>

	<script>
		var cartBox = $('.main.cart-box'),
			cartList = $('.cart-list'),
			cartObj = {},
			subTotal = $('.show-t-price-num'),
			numTotal = $('.show-t-num-num');

		function clearData(data) {
			var targetObj = JSON.parse(window.window.localStorage.getItem('cartlist')) || {};
			if (targetObj == {}) { } else {
				for (var key in data) {
					if (targetObj[data[key].cartitemId]) {
						cartObj[data[key].cartitemId] = targetObj[data[key].cartitemId]
					}
				}
			}
		}
		var cartitemMap = {};
		function renderProdcutList(parent, data) {
			var html = '';
			for (var i = 0, len = data.length; i < len; i += 1) {
				var hasStorageItem = cartObj[data[i].cartitemId];
				html += '<div class="cart-item bd-b" data-actoff="' + data[i].cartitemProductActoff + '" " data-originalprice="' + data[i].cartitemProductOriginalprice + '">' + '<input onclick="selectCartItem(event)" ' + (hasStorageItem ? 'checked' : '') + ' class="checkbox" type="checkbox" data-cartitemid="' + data[i].cartitemId + '" data-productid="' + data[i].cartitemProductId + '">' +
					'<img class="img" src="' + data[i].cartitemProductMainimgurl + '" alt="">' +
					'<div class="content">' +
					' <div class="text">' +
					'<div class="title">' + data[i].cartitemProductName + '</div>' +
					' <div class="condition" style="position: relative;">';
				var skuIdArr = data[i].cartitemProductskuIdstr.split(',');
				var skuIdNameArr = data[i].cartitemProductskuIdnamestr.split(',');
				var skuNameArr = data[i].cartitemProductskuNamestr.split(',');
				var skuPriceArr = data[i].cartitemProductskuMoneystr.split(',');
				for (var j = 0, len2 = skuIdArr.length; j < len2; j += 1) {
					html += '<div class="c-item" data-id="' + skuIdArr[j] + '" data-price="' + skuPriceArr[j] + '">' + skuIdNameArr[j] +
						': ' + skuNameArr[j] + '</div>';
				}
				html += '<span class="sku-edit" style="position: absolute; top: 0; right: 0; color: #ff6f5e;" onclick="skuEdit(event);"> EDIT </span>';
				var dataPrice = getPrice(data[i].cartitemProductOriginalprice, skuPriceArr, data[i]
					.cartitemProductActoff);
				html += '</div>' +
					'</div>' +
					'<div class="num" data-cartitemid="' + data[i].cartitemId + '" data-cartid="' + data[i].cartitemCartId +
					'" data-productname="' + data[i].cartitemProductName + '">' +
					'<span class="price">$' + (dataPrice.current) + '</span>' +
					'<span class="original">$' + (dataPrice.origin) + '</span>' +
					'<span class="icon delete"  onclick="deleteCartItem(event)">' + '</span>' +
					'<div class="input-group">' +
					'<span class="input-group-addon" id="product-num-sub" onclick="subNum(event)"><i class="icon sub"></i></span>' +
					'<input type="text" name="cart-product-num" disabled="disabled" class="form-control" value="' + (data[i].cartitemProductNumber) + '">' +
					'<span class="input-group-addon" id="product-num-add" onclick="addNum(event)"><i class="icon plus"></i></span>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'</div>';
			}

			parent.html(html);
		}
		var skuCheckData = {};
		function skuEdit(e) {
			var cartItem = $(e.target).parents('.cart-item');
			var productId = cartItem.find('input').data('productid');
			skuCheckData[productId] = {};
			var elBox = $('<div class="sys-box" style="position: fixed;z-index: 999999; display: block; height: 460px; margin-top: -230px; padding: 0 1em;"></div>');

			var html = '<div class="sys-body" style="overflow-y: auto;height:390px; border-bottom: 1px solid #ccc;"></div>' +
				'<div class="sys-footer" style="display: flex; justify-content: space-between; margin-top: 1em;">' +
				'<button class="btn btn-red cancel" style="width: 45%; padding: .75em; border-radius: 0;">cancel</button>' +
				'<button class="btn btn-pink ok" style="width: 45%; padding: .75em; border-radius: 0;">OK</button>' +
				'</div>';

			$(document.body).append(elBox.html(html));
			$(document.body).append(mask);
			$('.sys-box .cancel').on('click', function () {
				$('.sys-box').remove();
				$('.mask').remove();
				sysFlag = !sysFlag;
			});
			$('.sys-box .ok').on('click', function () {
				if (skuCheckData[productId] && Object.keys(skuCheckData[productId]).length > 0) {
					// delete order
					$.ajax({
						url: '${APP_PATH}/MlbackCart/delCartItem',
						type: 'POST',
						data: JSON.stringify({ cartitemId: parseInt(cartItem.find('.checkbox').data('cartitemid'), 10) }),
						async: false,
						contentType: 'application/json',
						success: function (data) {
							var resData = data.extend;
							if (data.code !== 100) {
								alert('sys error!')
							} else {
								var skuIdstr = [];
								var skuIdnamestr = [];
								var skuMoneystr = [];
								var skuNamestr = [];
								for (var key in skuCheckData[productId]) {
									skuIdstr.push(skuCheckData[productId][key].id);
									skuIdnamestr.push(skuCheckData[productId][key].name);
									skuMoneystr.push(skuCheckData[productId][key].cprice);
									skuNamestr.push(skuCheckData[productId][key].cname);
								}
								var cartitemProductActoffid = parseInt(cartItem.data('actoff'), 10);
								var reqData = {};
								reqData.cartitemProductId = parseInt(productId);
								reqData.cartitemProductName = cartItem.find('.title').text();
								reqData.cartitemProductOriginalprice = parseFloat(cartItem.data('originalprice')).toFixed(2);
								reqData.cartitemProductMainimgurl = cartItem.find('img').attr('src');
								reqData.cartitemProductActoff = cartitemProductActoffid / 10;
								reqData.cartitemProductskuIdstr = skuIdstr.join(',');
								reqData.cartitemProductskuIdnamestr = skuIdnamestr.join(',');
								reqData.cartitemProductskuNamestr = skuNamestr.join(',');
								reqData.cartitemProductskuMoneystr = skuMoneystr.join(',');
								reqData.cartitemProductNumber = parseInt(cartItem.find('input[type="text"]').val(), 10);

								$.ajax({
									url: '${APP_PATH}/MlbackCart/toAddToCart',
									data: JSON.stringify(reqData),
									type: "post",
									dataType: 'json',
									contentType: 'application/json',
									success: function (data) {
										if (data.code == 100) {
											window.location.href = window.location.href;
										} else {
											alert('sys error!');
										}
									}
								});
							}
						}
					});
				} else {
					alert('Please select product properties!');
				}
			});

			renderSkuData($('.sys-body'), productId);
		}

		function renderSkuData(conditionBox, productId) {
			$.ajax({
				url: '${APP_PATH}/MlbackProductSku/getfrontOneProductAllSku', //这个是只查yes的sku
				data: { "productId": productId },
				type: "post",
				success: function (data) {
					if (data.code == 100) {
						var conditionArr = data.extend.mlbackProductSkuResList;
						for (var i = 0, len = conditionArr.length; i < len; i += 1) {
							skuCheckData[productId] = {};
							renderCondition(conditionBox, conditionArr[i])
						}
						triggerCondition(conditionBox, productId);
					}
				}
			});
		}

		function triggerCondition(parent, productId) {
			parent.find('.product-d-length').each(function (i, item) {
				var activeItem = $(item).find('.price-item.active');
				$(item).find('.price-item').each(function (i, item) {
					$(item).on('click', function () {
						activeItem.removeClass('active');
						$(item).addClass('active');
						activeItem = $(item);
						var skuId = activeItem.parent().parent().data('id');
						if (skuCheckData[productId] && skuCheckData[productId][skuId]) {
							skuCheckData[productId][skuId].cname = activeItem.text();
							skuCheckData[productId][skuId].cprice = activeItem.data('price');
						} else {
							skuCheckData[productId][skuId] = {};
							skuCheckData[productId][skuId]['id'] = skuId;
							skuCheckData[productId][skuId]['name'] = activeItem.parent().parent().data('name');
							skuCheckData[productId][skuId]['cname'] = activeItem.text();
							skuCheckData[productId][skuId]['cprice'] = activeItem.data('price');
						}
					})
				})
			});
		}

		function renderCondition(parent, data) {
			var conditionEl = $('<div class="container product-d-length" data-name="' + data.productskuName + '" data-id="' + data.productskuId + '"/>'),
				html = '',
				len = 1;
			for (var key in data) {
				if (typeof data[key] == 'string' && data[key].indexOf(',') > -1) {
					data[key] = data[key].split(',');
					if (len == 1) {
						len = data[key].length;
					}
				}
			}
			html += '<span class="sku-id-name">' + data.productskuName + ':</span>';
			html += '<div class="list">';
			for (var i = 0; i < len; i += 1) {
				if (i == 0) {
					html += '<span class="price-item" data-price="' + toNumber(data.productskuMoneyDetails[i]) + '">' + data
						.productskuNameDetails[i] + '</span>'
				} else {
					html += '<span class="price-item" data-price="' + toNumber(data.productskuMoneyDetails[i]) + '">' + data
						.productskuNameDetails[i] + '</span>'
				}
			}
			html += '</div>';
			parent.append(conditionEl.html(html));
		}

		function renderProductNone(parent) {
			var html = '';
			html += '<div class="box-none">' +
				'<img src="${APP_PATH}/static/m/img/index/cart-none.png" alt="">' +
				'<p>The shopping cart is empty. Come and fill it up!</p>' +
				'<a href="${APP_PATH}/index.html" class="btn btn-pink"> Shop Now</a>' +
				'</div>';
			parent.html(html)
		}
		/*******hot_box_product********************************/
		var hot_pic = $('.hot_box_product_cont .swiper-wrapper');
		function rednerProduct(parent, data) {
			var html = '';
			for (var i = 0; i < data.length; i += 1) {
				var productactoffif = data[i].productActoffIf;
				var productactoffid = data[i].productActoffid; 
				var cp_icon = "";
				var showspan = "";
				if (productactoffif == 1) {
					if (productactoffid == 1) {
						showspan = "showactive1"
					} else if (productactoffid == 2) {
						showspan = "showactive2"
					} else if (productactoffid == 3) {
						showspan = "showactive3"
					} else if (productactoffid == 4) {
						showspan = "showactive4"
					}

				} else {
					showspan = "hideactive"
				}
				html += '<div class="swiper-slide">' +
					'<div class="product-item" data-productid="' + data[i].productId + '">' +
					'<span class="hui_icon ' + showspan + '"></span>' +
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
					'<span class="product-now-price">$' + (data[i].productOriginalprice && data[i].productActoffoff ? (data[i].productOriginalprice * data[i].productActoffoff / 100).toFixed(2) : 0) + '</span>' +
					'<span class="product-define-price">$' + (data[i].productOriginalprice ? data[i].productOriginalprice : 0) +
					'</span>' +
					'<span class="product-to-cart" data-id="' + data[i].productId + '"><i class="icon cart2"></i></span>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'</div>';
			}

			parent.html(html);
		}

		$.ajax({
			url: '${APP_PATH}/MlbackSlide/getMlbackSlidepcListByArea',
			data: JSON.stringify({ "slideArea": 3 }),
			type: 'post',
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				if (data.code == 100) {
					var resDataProduct = data.extend.mlbackProductResList;;
					rednerProduct(hot_pic, resDataProduct)
					new Swiper('.hot_box_product_cont', {
						observer: true,//修改swiper自己或子元素时，自动初始化swiper
						observeParents: true,//修改swiper的父元素时，自动初始化swiper
						slidesPerView: 5,
						spaceBetween: 10,
						freeMode: true,
						loop: true,
						autoplay: {
							disableOnInteraction: false,
						},
						simulateTouch: false,//禁止鼠标模拟
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
					renderErrorMsg(prodcutBox, 'No product-related data was obtained');
				}
			}
		});

		function addNum(e) {
			e.stopPropagation();
			var item = $(e.target),
				checkbox = item.parents('.cart-item').find('.checkbox'),
				productNum = item.parent().parent().find('input'),
				productNumText = parseInt(productNum.val());
			productNumText += 1;
			productNum.val(productNumText);

			if (checkbox.is(':checked')) {
				cartObj[checkbox.data('cartitemid')].num = productNumText;
				getTotalPrice();
			}

			updateCartItemNum(item, productNumText);
		}

		function subNum(e) {
			e.stopPropagation();
			var item = $(e.target),
				checkbox = item.parents('.cart-item').find('.checkbox'),
				productNum = item.parent().parent().find('input'),
				productNumText = parseInt(productNum.val());
			if (productNumText <= 1) {
				productNumText = 1;
				productNum.val(productNumText);
			} else {
				productNumText -= 1;
				productNum.val(productNumText);
			}

			if (checkbox.is(':checked')) {
				cartObj[checkbox.data('cartitemid')].num = productNumText;
				getTotalPrice();
			}
			updateCartItemNum(item, productNumText);
		}
		function updateCartItemNum(el, num) {
			target = el.parent().parent().parent();
			var reqData = {
				cartitemId: target.data('cartitemid'),
				cartitemProductName: target.data('productname'),
				cartitemProductNumber: num
			}
			$.ajax({
				url: '${APP_PATH}/MlbackCart/updateCartItemSkuNum	',
				data: JSON.stringify(reqData),
				type: "post",
				dataType: 'json',
				contentType: 'application/json',
				success: function (data) {
					console.info('success')
				},
				error: function () {
					alert('add fail')
				}
			})
		}
		function getPrice(originalePrice, skuPriceArr, discount) {
			var singlePrice = parseFloat(originalePrice);
			for (var k = 0, len = skuPriceArr.length; k < len; k += 1) {
				singlePrice += (parseFloat(skuPriceArr[k]) ? parseFloat(skuPriceArr[k]) : 0);
			}
			return {
				origin: parseFloat(singlePrice).toFixed(2),
				current: parseFloat(singlePrice * ((parseFloat(discount) ? parseFloat(discount) : 100) / 100)).toFixed(2)
			}
		}
		function getTotalPrice() {
			var price = 0,
				num = 0;
			for (var i in cartObj) {
				price = (parseFloat(price) + cartObj[i].num * cartObj[i].price).toFixed(2);
				num += cartObj[i].num;
			}
			numTotal.text(num)
			subTotal.text('$ ' + price);
		}

		function calcTotalPrice() {
			var cartItemArr = []
			$('input[type="checkbox"]').each(function (i, item) {
				if ($(item).is(':checked')) {
					cartItemArr.push({
						cartitemId: $(item).data('cartitemid'),
						cartitemProductId: $(item).data('productid'),
						cartitemProductNumber: $(item).parent().find('.input-group input').val()
					});
				}
			})
			function toFbidsPurchase(resData) {
				var infoStrlids = '',
					infoRelids = '';
				for (var i = 0; i < resData.length; i++) {
					infoStrlids = infoStrlids + resData[i].cartitemProductId + ',';
				}
				infoRelids = infoStrlids.substr(0, infoStrlids.length - 1);
				return infoRelids;
			}
			if (cartItemArr.length) {
				orderMoney = subTotal.text().slice(1);
				var shopidlist = toFbidsPurchase(cartItemArr);
				// 追踪'发起结账'事件  facebook广告插件可以注释掉，但不要删除
				fbq('track', 'InitiateCheckout', {
					content_ids: [shopidlist],
					content_type: 'product',
					value: orderMoney,
					currency: 'USD'
				});
				$.ajax({
					url: '${APP_PATH}/MlbackCart/cartToOrder',
					data: JSON.stringify(cartItemArr),
					type: "post",
					dataType: 'json',
					contentType: 'application/json',
					success: function (data) {
						if (data.code == 100) {
							window.location.href = '${APP_PATH}/MlbackCart/toCheakOut';
						}
					},
					error: function (data) {
						cartText.text(num);
					}
				})
			} else {
				renderSysMsg('Please select the final product to buy！')
			}
		}
		$('.btn.calc-price').on('click', function () {
			calcTotalPrice();
		});
		$.ajax({
			url: '${APP_PATH}/MlbackCart/getCartProductNumber',
			type: 'post',
			success: function (data) {
				if (data.extend.number) {
					$.ajax({
						url: '${APP_PATH}/MlbackCart/getCartitemIdDetails',
						type: 'post',
						success: function (data) {
							var resData = data.extend.mlfrontCartItemListRes;
							if (resData.length > 0) {
								$(".hot_box_product").remove();
								$('.cart-title').show();
								renderProdcutList(cartList, resData);
								$('.cart-footer').show();
								getTotalPrice();
								// for all cart-product bind event of going product-details
								toProductDetails();
							} else {
								renderProductNone(cartBox);
								$(".hot_box_product").show();
							}
						}
					})
				} else {
					renderProductNone(cartBox);
					$(".hot_box_product").show();
				}
			}
		})
		function toProductDetails() {
			$(".cart-item").each(function () {
				var textlink = $(this).children(".content").children(".text").find(".title");
				textlink.on('click', function () {
					var product_id = $(this).parents(".content").parents(".cart-item").find(".checkbox").data('productid');
					toProductItem(product_id)
				});
			}, true)
		}

		function selectCartItem(e) {
			e.stopPropagation();
			var item = $(e.target),
				cartItemId = item.data('cartitemid');
			$(".coupons .coupon-item input[type=radio]").removeClass("active");
			item.addClass("active");
			if (item.is(':checked') && !cartObj[cartItemId]) {
				cartObj[cartItemId] = {
					num: parseInt(item.parent().find('input[type=text]').val().trim(), 10),
					price: (+item.parent().find('.price').text().trim().substring(1))
				}
			} else {
				delete cartObj[cartItemId];
			}
			window.localStorage.setItem('cartlist', JSON.stringify(cartObj));
			getTotalPrice();
		}
		var cartNum = parseInt(cartText.text());
		function deleteCartItem(e) {
			e.stopPropagation();
			// 只需要传递这一个参数就可以了。cartitemId
			var el = $(e.target),
				reqData = {
					cartitemId: el.parent().data('cartitemid')
				};
			el.parent().parent().parent().remove();
			cartNum -= 1
			if (cartNum <= 0) {
				cartText.text(0);
				renderProductNone(cartBox);
				$(".hot_box_product").show();
			} else {
				cartText.text(cartNum);
			}
			$.ajax({
				url: '${APP_PATH}/MlbackCart/delCartItem',
				type: 'post',
				data: JSON.stringify(reqData),
				contentType: 'application/json',
				success: function (data) {
					var resData = data.extend;
					if (data.code == 100) {
						if (resData.isDelSuccess == 1) {
							window.location.href = '${APP_PATH}/myCart.html';
						}
						if (resData.isDelSuccess == 0) {
							renderSysMsg('The system is abnormal, please try again later');
							if (sysFlag) {
								window.location.href = '${APP_PATH}/myCart.html';
							}
						}
					} else {
						renderSysMsg('The system is abnormal, please try again later');
						if (sysFlag) {
							window.location.href = '${APP_PATH}/myCart.html';
						}
					}
				}
			})
		}
	</script>
</body>

</html>