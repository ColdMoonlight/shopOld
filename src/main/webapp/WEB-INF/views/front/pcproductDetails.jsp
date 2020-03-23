<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Product Details</title>
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
		!function (f, b, e, v, n, t, s) {
			if (f.fbq) return; n = f.fbq = function () {
				n.callMethod ?
				n.callMethod.apply(n, arguments) : n.queue.push(arguments)
			};
			if (!f._fbq) f._fbq = n; n.push = n; n.loaded = !0; n.version = '2.0';
			n.queue = []; t = b.createElement(e); t.async = !0;
			t.src = v; s = b.getElementsByTagName(e)[0];
			s.parentNode.insertBefore(t, s)
		}(window, document, 'script',
			'https://connect.facebook.net/en_US/fbevents.js');
		fbq('init', '246433859565492');
	</script>
	<noscript><img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=667403967094866&ev=PageView&noscript=1" /></noscript>
	<!-- End Facebook Pixel Code -->
</head>

<body>
	<jsp:include page="pcheader.jsp"></jsp:include>
	<script src="${APP_PATH }/static/pc/js/jquery.jqzoom-core.js"></script>
	<link rel="stylesheet" href="${APP_PATH }/static/common/swiper/swiper.min.css">
	<script src="${APP_PATH }/static/common/swiper/swiper.min.js"></script>
	<!-- main -->
	<div class="main">
		<div class="container">
			<!-- <input type="hidden" value="${productId}" id="productId"/> -->
			<div class="product-details clearfix"> </div>
		</div>
	</div>
	<div class="maskreview"></div>
	<div class="win-box review-box review-box-cont hide">
		<div class="win-box-title">
			<span class="review-cancel">x</span>
		</div>
		<div class="win-box-content">
			<div class="review-box-item">
				<div class="name">NAME</div>
				<input type="text" name="username" placeholder="Enter your name (public)">
			</div>
			<div class="review-box-item">
				<div class="name">RANTING</div>
				<div class="stars-list review-star" data-star="5">
					<i class="icon star2" data-id="1"></i>
					<i class="icon star2" data-id="2"></i>
					<i class="icon star2" data-id="3"></i>
					<i class="icon star2" data-id="4"></i>
					<i class="icon star2" data-id="5"></i>
				</div>
			</div>
			<div class="review-box-item">
				<div class="name">REVIEW</div>
				<textarea class="review-details" placeholder="Write your comments here"></textarea>
			</div>
			<div class="review-box-item">
				<div class="name">PICTURE <span>(Maximum upload file size: 3M )</span></div>
				<div class="reviews-img-list">
					<div class="review-img-add">
						<input type="file">
						<i class="icon plus"></i>
					</div>
					<div class="reviews-img-box"></div>
					<div class="maskdd"></div>
				</div>
			</div>
			<span class="review-ok">publish</span>
		</div>
	</div>

	<jsp:include page="pcfooter.jsp"></jsp:include>

	<script src="${APP_PATH }/static/js/relativetime.min.js"></script>
	<script src="${APP_PATH }/static/js/countdown.min.js"></script>
	<script>
		var imgCount = 1,
			reviewId = null,
			sessionScopeproductId = '${sessionScope.productDetailId}';

		/* load tpl for detail of product */
		$('.product-details').load('${APP_PATH}/static/tpl/pcproductDetail.html', function () {
			$(".jqzoom").imagezoom();
			$(".jqPreload0").remove();
			var pidA = sessionScopeproductId,
				dataPrice = null,
				swiper = $('.product__details-banner .swiper-wrapper'),
				swipersmall = $('.additional_pic .swiper-wrapper'),
				conditionBox = $('.conditionBox'),
				productDetailsBox = $('.product__details-text'),
				prodcutDtitle = $('.product-d-title'),
				productDlengthList = $('.product-d-length').find('.list'),
				prodcutDpriceText = $('.product-d-price .price-text'),
				descriptionBox = $('.group-details.description'),
				reviewBox = $('.group-details.reviews-info'),
				add = $('#product-num-add'),
				sub = $('#product-num-sub'),
				productNum = $('input[name="productNum"]'),
				skuCheckData = {};

			/* details of banner */
			$.ajax({
				url: '${APP_PATH}/MlbackProductImg/getMlbackProductImgListByProductId',
				data: { "productId": pidA },
				type: "POST",
				success: function (data) {
					if (data.code == 100) {
						var resData = data.extend.mbackProductImgResList;
						renderProductDetailsBanner(swiper, resData);
						var galleryleft = new Swiper('.additional_pic', {
							direction: 'vertical',
							slidesPerView: 6,
							freeMode: true,
							navigation: {
								nextEl: '.swiper-button-next',
								prevEl: '.swiper-button-prev',
							},
						});
						var galleryright = new Swiper('.product__details-banner', {
							pagination: {
								el: '.swiper-pagination',
								clickable: true
							},
							navigation: {
								nextEl: '.swiper-button-next',
								prevEl: '.swiper-button-prev',
							},
							thumbs: {
								swiper: galleryleft
							}

						});
						$(".jqzoom").imagezoom();
					} else {
						renderErrorMsg(swiper, 'No data for the relevant image was obtained');
					}
				}
			});
			/* couponlist */
			$.ajax({
				url: '${APP_PATH}/MlbackCouponDescTitle/getMlbackCouponDescTitlepcListByStatus',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				success: function (data) {
					var saleCouponEl = $('.sale_coupon'),
						titleData = data.extend.mlbackCouponDescTitleList,
						couponArrData = data.extend.mlbackCouponDescDetailList;
					if (data.code == 100 && titleData.length > 0) {
						renderSaleCoupon(saleCouponEl, {
							title: titleData[0],
							couponList: couponArrData
						});
					} else {
						saleCouponEl.hide();
					}
				}
			});
			function renderSaleCoupon(parent, data) {
				var htmlStr = '';
				if (data.title && data.title.coupondesctielePcstatus)
					htmlStr += '<img src="' + data.title.coupondesctielePcimgurl + '" />';
				htmlStr += '<div class="sale_coupon-body"><p>' + data.title.coupondesctieleTieledetail + '</p><ul>';
				for (var i = 0, len = data.couponList.length; i < len; i++) {
					htmlStr += '<li>' + data.couponList[i].coupondescdetailStrengthpre + '<span>'
						+ data.couponList[i].coupondescdetailStrength + '</span>'
						+ data.couponList[i].coupondescdetailCodepre
						+ ' <b>' + data.couponList[i].coupondescdetailCode + '</b></li>';
				}
				htmlStr += '</ul></div>';
				parent.html(htmlStr);
			}
			/* detials of condition（sku） */
			$.ajax({
				url: '${APP_PATH}/MlbackProductSku/getfrontOneProductAllSku', //这个是只查yes的sku
				data: { "productId": pidA },
				type: "POST",
				success: function (data) {
					if (data.code == 100) {
						var conditionArr = data.extend.mlbackProductSkuResList;
						for (var i = 0, len = conditionArr.length; i < len; i += 1) {
							skuCheckData[conditionArr[i].productskuName] = null;
							renderCondition(conditionBox, conditionArr[i])
						}
						resetPrice(conditionBox);
						triggerCondition(conditionBox);
					}
				}
			});

			function renderProductDetailsBanner(parent, data) {
				var htmlbig = '';
				var htmlsmall = '';
				for (var i = 0, len = data.length; i < len; i += 1) {
					htmlbig += '<div class="swiper-slide">' +
						'<img src="' + data[i].productimgUrl + '" rel="' + data[i].productimgUrl + '" alt="' + data[i].productimgName + '" class="jqzoom">' +
						'</div>';
				}
				for (var a = 0, len = data.length; a < len; a += 1) {
					htmlsmall += '<div class="swiper-slide">' +
						'<img src="' + data[a].productImgsecleturl + '">' +
						'</div>';
				}

				swipersmall.html(htmlsmall);
				swiper.html(htmlbig);
			}

			function triggerCondition(parent) {
				parent.find('.product-d-length').each(function (i, item) {
					var activeItem = $(item).find('.price-item.active');
					$(item).find('.price-item').each(function (i, item) {
						$(item).on('click', function () {
							activeItem.removeClass('active');
							$(item).addClass('active');
							activeItem = $(item);
							skuCheckData[activeItem.parent().parent().data('name')] = activeItem.data('price');
							resetPrice();
						})
					})
				});
			}

			function renderCondition(parent, data) {
				var productskuNameDetails = data.productskuNameDetails.split(',');
				var lengthsku = productskuNameDetails.length;
				var conditionEl = $('<div class="container product-d-length" data-name="' + data.productskuName +
					'" data-id="' + data.productskuId + '"/>');
				var html = '';
				var len = 1;
				for (var key in data) {
					if (typeof data[key] == 'string' && data[key].indexOf(',') > -1) {
						data[key] = data[key].split(',');
						if (len == 1) {
							len = data[key].length;
						}
					}
				}
				html += '<i>* </i>' + '<span class="sku-id-name">' + data.productskuName + ':</span>';
				html += '<div class="list">';
				for (var i = 0; i < len; i += 1) {
					if (lengthsku > 1) {
						html += '<span class="price-item" data-price="' + (data.productskuMoneyDetails[i]) + '">' + data.productskuNameDetails[i] + '</span>'
					} else {
						html += '<span class="price-item" data-price="' + (data.productskuMoneyDetails) + '">' + data.productskuNameDetails + '</span>'
					}
				}
				html += '</div>';
				parent.append(conditionEl.html(html));
			}
			/* details of main */
			$.ajax({
				url: '${APP_PATH}/MlbackProduct/getOneMlbackProductDetail',
				data: { "productId": pidA },
				type: "POST",
				success: function (data) {
					if (data.code == 100) {
						var productData = data.extend.mlbackProductOne;
						addHeaderInfo(productData);
						var fbpid = productData.productId;
						var fbprice = (productData.productOriginalprice * productData.productActoffoff / 100).toFixed(2);
						fbq('track', 'PageView', {
							content_ids: fbpid,
							contents: [{ "id": fbpid, "quantity": 999, "item_price": fbprice }],
							content_type: 'product',
							value: fbprice,
							currency: 'USD'
						});
						fbq('track', 'ViewContent', {
							content_ids: fbpid,
							contents: [{ "id": fbpid, "quantity": 999, "item_price": fbprice }],
							content_type: 'product',
							value: fbprice,
							currency: 'USD'
						});
						dataPrice = productData;
						prodcutDtitle.text(productData.productName);
						prodcutDpriceText.attr('data-price', productData.productOriginalprice);
						prodcutDpriceText.attr('data-discount', productData.productActoffoff);
						calPrice(productData.productOriginalprice, (productData.productOriginalprice * productData.productActoffoff / 100).toFixed(2));
						descriptionBox.html(productData.productDesc);
						repeatCalPrice();
					} else {
						renderErrorMsg(productDetailsBox, 'No product-related data was obtained');
					}
				}
			});
			function addHeaderInfo(productData) {
				var productNameStr = productData.productName,
					productMetaDescStr = productData.productMetaDesc,
					productSeoStr = productData.productSeo,
					urlStr = 'https://megalook.com/' + productSeoStr + '.html',
					imageStr = productData.productMainimgurl,
					amountStr = (productData.productOriginalprice * productData.productActoffoff / 100).toFixed(2),
					productIdStr = productData.productId;
				var meta = $('<meta property = "og:title" content ="' + productNameStr + '">' +
					'<meta property = "og:description" content = "' + productMetaDescStr + '" >' +
					'<meta property = "og:url" content = "' + urlStr + '" >' +
					'<meta property = "og:image" content = "' + imageStr + '" >' +
					'<meta property = "product:brand" content = "MegaLook" >' +
					'<meta property = "product:availability" content = "in stock" >' +
					'<meta property = "product:condition" content = "new" > ' +
					'<meta property = "product:price:amount" content = "' + amountStr + '" >' +
					'<meta property = "product:price:currency" content = "USD" >' +
					'<meta property = "product:retailer_item_id" content = "' + productIdStr + '" >' +
					'');
				$(document.head).append(meta);
			}
			/*
				review汇总接口
				Integer productId;
				return StartNumList各个星级评论数		allReviewNum评论总数
			*/
			$.ajax({
				url: '${APP_PATH}/MlfrontReview/getMlfrontReviewCount',
				data: { "productId": pidA },
				type: "POST",
				success: function (data) {
					if (data.code == 100) {
						var productData = data.extend,
							staticData = data.extend.StartNumList,
							reviewTotal = data.extend.allReviewNum,
							reviewStatics = $(".reviews-statics"),
							dataMap = {},
							toalStar = 0;

						function renderProgress(parent, num, total) {
							var html = '';
							var percent = (num * 100 / total || 0).toFixed(2);
							html += '<div class="progress">' +
								'<div class="progress-inner" style="width: ' + percent + '%"></div>' +
								'</div>' +
								'<div class="data">' + percent + '%</div>';

							parent.append($(html));
						}
						if (reviewTotal > 0) {
							for (var i = 0, len = staticData.length; i < len; i += 1) {
								toalStar += staticData[i].startNum * staticData[i].startCount;
								dataMap[staticData[i].startNum] = staticData[i].startCount;
							}

							var avgStar = Math.round(toalStar / reviewTotal);
							$('.reviews-data .stars-list').find('.icon').each(function (index, item) {
								if (index < avgStar) {
									$(item).removeClass('star').addClass('star2');
								}
							});
						}

						$('.reivew-toal-num').find('.data').html(reviewTotal);

						renderProgress($('.review-statics-item.five'), dataMap[5], reviewTotal);
						renderProgress($('.review-statics-item.four'), dataMap[4], reviewTotal);
						renderProgress($('.review-statics-item.three'), dataMap[3], reviewTotal);
						renderProgress($('.review-statics-item.two'), dataMap[2], reviewTotal);
						renderProgress($('.review-statics-item.one'), dataMap[1], reviewTotal);
					} else {
						renderErrorMsg(productDetailsBox, 'No product-related data was obtained');
					}
				}
			});

			to_page(1);
			/*
				review分页接口
				Integer productId;//产品ID
				Integer pn;//页数
				return	分页信息(pageInfo),5条评论内容(mlfrontReviewResreturn)，5条评论中的图片(imgUrlStrListst)
			*/
			function to_page(pn) {
				$.ajax({
					url: "${APP_PATH}/MlfrontReview/getMlfrontReviewByProductIdAndPage",
					data: {
						"productId": pidA,
						"pn": pn
					},
					type: "POST",
					success: function (result) {
						var reviewTextData = result.extend.mlfrontReviewResreturn;
						var reviewImgData = result.extend.imgUrlStrListst;
						var pageInfo = result.extend.pageInfo;
						var reviewBoxList = reviewBox.find('.review-list');
						var pageArea = reviewBox.find('.page-info-area');
						if (reviewImgData.length > 0) {
							renderReviewList(reviewBoxList, reviewTextData, reviewImgData);
							pageArea.removeClass('hide');
							render_page_nav(pageArea, pageInfo);
						} else {
							renderErrorMsg(reviewBoxList, 'No comment information, please add.');
						}
					}
				});
			}

			// render reiew list
			function renderReviewList(parent, text, img) {
				var html = '';
				for (var i = 0, len = img.length; i < len; i++) {
					html += '<li class="review-item" data-reviewid="' + text[i].reviewId + '">' +
						'<div class="review-title">' +
						'<div class="img"><img src="' + text[i].reviewUimgurl + '" alt=""></div>' +
						'<div class="review-data">' +
						'<div class="stars-list review-d-rank">';
					for (var j = 0; j < 5; j++) {
						if (j < text[i].reviewProstarnum) {
							html += '<i class="icon star2"></i>';
						} else {
							html += '<i class="icon star"></i>';
						}
					}
					html += '</div>' +
						'<div class="review-d-author">' + text[i].reviewUname + '</div>' +
						'</div>' +
						'<div class="review-date">' + (new RelativeTIime({ date: text[i].reviewCreatetime }).output) + '</div>' +
						'</div>' +
						'<div class="review-content">' +
						'<div class="review-text">' + text[i].reviewDetailstr + '</div>' +
						'</div>' +
						'<div class="review-imgs">';
					var imgLen = img[i].length <= 5 ? img[i].length : 5;
					for (var k = 0; k < imgLen; k++) {
						html += '<img src="' + img[i][k] + '">';
					}
					html += '</div>' + '</li>';
				}
				parent.html(html);

				var mySwiper = new Swiper('.swiper-container2', {
					simulateTouch: false,//禁止鼠标模拟
					pagination: {
						el: '.swiper-pagination_1',
						type: 'fraction',
					},
					navigation: {
						nextEl: '.swiper-button-next',
						prevEl: '.swiper-button-prev',
					},
					observer: true,//修改swiper自己或子元素时，自动初始化swiper
					observeParents: true,//修改swiper的父元素时，自动初始化swiper
				})
				$(".review-item").on("click", ".review-imgs img",
					function () {
						var imgBox = $(this).parents(".review-imgs").find("img");
						var i = $(imgBox).index(this);
						$(".big_img .swiper-wrapper").html("")
						for (var j = 0, c = imgBox.length; j < c; j++) {
							$(".big_img .swiper-wrapper").append('<div class="swiper-slide"><div class="cell"><div class="img_boxcont"><div class="close_box"><span class="close_an">×</span> </div><img src="' + imgBox.eq(j).attr("src") + '" / ></div></div></div>');
						}
						$(".big_img").css({
							"z-index": 10001,
							"opacity": "1"
						});
						mySwiper.slideTo(i, 0, false);
						return false;
					});

				$("body").on('click', '.close_an', function () {
					$(this).parents(".big_img").css({
						"z-index": "-1",
						"opacity": "0"
					});

				});
			}

			// render page nav
			function render_page_nav(parent, pageInfo) {
				//page_nav_area
				parent.empty();
				var ul = $("<ul></ul>").addClass("pagination");

				//构建元素
				var firstPageLi = $("<li></li>").append($("<a></a>").append("first").attr("href", "javascript:;"));
				var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
				if (pageInfo.hasPreviousPage == false) {
					firstPageLi.addClass("disabled");
					prePageLi.addClass("disabled");
				} else {
					//为元素添加点击翻页的事件
					firstPageLi.click(function () {
						to_page(1);
					});
					prePageLi.click(function () {
						to_page(pageInfo.pageNum - 1);
					});
				}

				var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
				var lastPageLi = $("<li></li>").append($("<a></a>").append("last").attr("href", "javascript:;"));
				if (pageInfo.hasNextPage == false) {
					nextPageLi.addClass("disabled");
					lastPageLi.addClass("disabled");
				} else {
					nextPageLi.click(function () {
						to_page(pageInfo.pageNum + 1);
					});
					lastPageLi.click(function () {
						to_page(pageInfo.pages);
					});
				}

				//添加首页和前一页 的提示
				ul.append(firstPageLi).append(prePageLi);
				//1,2，3遍历给ul中添加页码提示
				$.each(pageInfo.navigatepageNums, function (index, item) {

					var numLi = $("<li></li>").append($("<a></a>").append(item));
					if (pageInfo.pageNum == item) {
						numLi.addClass("active");
					}
					numLi.click(function () {
						to_page(item);
					});
					ul.append(numLi);
				});
				//添加下一页和末页 的提示
				ul.append(nextPageLi).append(lastPageLi).appendTo(parent);
			}
			// write a reivew
			$('.write-review').on('click', function () {
				$.ajax({
					url: "${APP_PATH}/MlfrontReview/saveNew",
					data: JSON.stringify({
						reviewPid: pidA,
					}),
					dataType: "json",
					contentType: 'application/json',
					type: "POST",
					async: false,
					success: function (result) {
						if (result.code == 100) {
							reviewId = result.extend.mlfrontReviewOne.reviewId;
						} else {
							renderSysMsg('System error, please contact the administrator！');
						}
					}
				});
				$('.review-box').removeClass('hide');
				$(".maskreview").show();
			});
			// close review box
			$('.review-cancel').on('click', function () {
				$('.review-box').addClass('hide');
				deleteReview();
			});
			// select star reank
			$('.review-star .icon').each(function () {
				var parent = $(".icon").parent(".review-star");
				$(".review-star .icon").on('click', function () {
					parent.find('.icon').removeClass('star2').addClass('star');
					$(this).removeClass('star').addClass('star2').prevAll('.icon').removeClass('star').addClass('star2');
					parent.attr('data-star', $(this).data('id'));
				})
			});
			// add reivew imgs
			$('.review-img-add').on('click', function () {
				if (imgCount == 5) {
					$('.maskdd').show();
				} else {
					uploadfu($(this).parent(), $(this).find('input')[0]);
				}
			})
			$('.maskdd').on('click', function () {
				renderSysMsg('Upload up to 5 review images');
			})
			// save a reivew
			$('.review-ok').on('click', function () {
				var details = $('.review-details').val().trim();
				var starNum = parseInt($('.review-star').data('star'), 10);
				var username = $('input[name="username"]').val().trim();
				if (username.length < 1) {
					renderSysMsg('Please enter user name');
					return;
				}

				if (starNum < 1) {
					renderSysMsg('Please Rating');
					return;
				}

				if (details.length < 1) {
					renderSysMsg('Comment content cannot be empty');
					return;
				}
				// review reqData
				var reqData = {
					reviewId: reviewId,
					reviewUname: username,
					reviewPid: pidA,
					reviewDetailstr: details,
					reviewProstarnum: starNum
				}
				$.ajax({
					url: "${APP_PATH}/MlfrontReview/save",
					data: JSON.stringify(reqData),
					dataType: "json",
					contentType: 'application/json',
					type: "POST",
					async: false,
					success: function (result) {
						if (result.code == 100) {
							renderSysMsg('Successful operation. New comment information needs to be reviewed before it can be displayed.！');
							setInterval(function () {
								if (sysFlag) {
									window.location.href = window.location.href;
								}
							}, 500);
						} else {
							renderSysMsg('Operation Failed！');
						}
					}
				});
			});

			$(".descript_cont").find(".group-details:first").css("display", "block");
			$(".list-group li").each(function (j) {
				$(this).click(function () {
					$(".list-group li.list-group-item").removeClass("active");
					$(this).addClass("active");
					$(".group-details").hide();
					$(".group-details:eq(" + j + ")").show();
				});
			});

			$('.review-list').find('.review-more').each(function (i, item) {
				$(item).on('click', function () {
					if ($(this).find('.icon').hasClass('bottom')) {
						$(this).find('.icon').removeClass('bottom').addClass('top').parent().parent().find('.review-text')
							.removeClass('review-ellipsis')
					} else {
						$(this).find('.icon').removeClass('top').addClass('bottom').parent().parent().find('.review-text')
							.addClass('review-ellipsis')
					}
				})
			});

			function calPrice(original, discount) {
				$(prodcutDpriceText.find('.original')).text('$' + original);
				$(prodcutDpriceText.find('.discount')).text('$' + discount);
			}

			function repeatCalPrice() {
				var discount = prodcutDpriceText.data('discount') / 100;
				sub.on('click', function () {
					var originalPrice = prodcutDpriceText.data('price') + calOverPrice();
					if (productNum.val() <= 1) {
						productNum.val(1);
						calPrice(
							originalPrice.toFixed(2),
							(originalPrice * discount).toFixed(2)
						);
					} else {
						productNum.val(parseInt(productNum.val()) - 1);
						calPrice(
							(productNum.val() * originalPrice).toFixed(2),
							(productNum.val() * parseFloat((originalPrice * discount).toFixed(2))).toFixed(2)
						);
					}
				});
				add.on('click', function () {
					var originalPrice = prodcutDpriceText.data('price') + calOverPrice();
					productNum.val(parseInt(productNum.val()) + 1);
					calPrice(
						(productNum.val() * originalPrice).toFixed(2),
						(productNum.val() * parseFloat((originalPrice * discount).toFixed(2))).toFixed(2)
					);
				})
			}

			function calOverPrice() {
				var overPrice = 0;
				conditionBox.find('.price-item.active').each(function (i, item) {
					overPrice += parseFloat($(item).data('price'));
				});
				return overPrice;
			}
			// 重置价格
			function resetPrice() {
				var original = 0,
					discount = 0;
				original = ((parseFloat(prodcutDpriceText.data('price')) + calOverPrice()) * parseInt(productNum.val())).toFixed(2);
				discount = (original * parseFloat(prodcutDpriceText.data('discount')) / 100).toFixed(2);
				calPrice(original, discount);
			}
			var offset = $("#cart_icon").offset();  //结束的地方的元素
			// add-to-cart
			$('.add-to-cart').on('click', function (event) {
				//是$(".addcar")这个元素点击促发的 开始动画的位置就是这个元素的位置为起点
				var skuData = getSkuData($('.product-d-length')),
					reqData = {},
					flag = false;
				reqData.cartitemProductId = parseInt(pidA);
				reqData.cartitemProductName = dataPrice.productName;
				reqData.cartitemProductOriginalprice = dataPrice.productOriginalprice;
				reqData.cartitemProductMainimgurl = dataPrice.productMainimgurl;
				reqData.cartitemProductActoff = dataPrice.productActoffid;
				reqData.cartitemProductskuIdstr = skuData.id.join(',');
				reqData.cartitemProductskuIdnamestr = skuData.idName.join(',');
				reqData.cartitemProductskuNamestr = skuData.itemName.join(',');
				reqData.cartitemProductskuMoneystr = skuData.price.join(',');
				reqData.cartitemProductNumber = productNum.val();

				// name, id, price
				function getSkuData(els) {
					var data = {
						itemName: [],
						id: [],
						idName: [],
						price: []
					};
					els.each(function (i, item) {
						data.itemName.push($(item).find('.price-item.active').text());
						data.id.push($(item).data('id'));
						data.idName.push($(item).data('name'));
						data.price.push($(item).find('.price-item.active').data('price'));
					});

					return data;
				}

				flag = checkSku(skuCheckData);
				if (flag) generateOrder(reqData);
			});

			function checkSku(skuCheckData) {
				for (var i in skuCheckData) {
					if (skuCheckData[i] == null) {
						renderSysMsg('Please select product attributes ' + i);
						return false;
					}
				}

				return true;
			}

			function generateOrder(reqData) {
				var fbpid = reqData.cartitemProductId,
					fbprice = reqData.cartitemProductOriginalprice;
				$.ajax({
					url: '${APP_PATH}/MlbackCart/toAddToCart',
					data: JSON.stringify(reqData),
					type: "POST",
					dataType: 'json',
					contentType: 'application/json',
					success: function (data) {
						if (data.code == 100) {
							setTimeout(function () {
								cartText.text(parseInt(cartText.text()) + 1);
							}, 600)
							//追踪'添加购物车'事件    facebook广告插件可以注释掉，但不要删除
							fbq('track', 'AddToCart', {
								content_ids: fbpid,
								content_type: 'product',
								value: fbprice,
								currency: 'USD'
							});
						}
					},
					error: function (data) {
						cartText.text(num);
					}
				});
				var img = $(".add-to-cart").parents(".top_detial").children(".left_swiper_cont").children(".additional_pic").children(".swiper-wrapper").children(".swiper-slide").eq(0).find('img').attr('src');
				var flyer = $('<img class="u-flyer" src="' + img + '" />');
				flyer.fly({
					start: {
						left: event.pageX,
						top: event.pageY
					},
					end: {
						left: offset.left + 10,
						top: offset.top + 10,
						width: 0,
						height: 0
					},
					onEnd: function () {
						this.destory();
					}
				});
			}

			$('.buy-now').on('click', function () {
				buyNow();
			});

			function buyNow() {
				var skuData = getSkuData($('.product-d-length')),
					reqData = {};
				reqData.cartitemProductId = parseInt(pidA);
				reqData.cartitemProductName = dataPrice.productName;
				reqData.cartitemProductOriginalprice = dataPrice.productOriginalprice;
				reqData.cartitemProductMainimgurl = dataPrice.productMainimgurl;
				reqData.cartitemProductActoff = dataPrice.productActoffid;
				reqData.cartitemProductskuIdstr = skuData.id.join(',');
				reqData.cartitemProductskuIdnamestr = skuData.idName.join(',');
				reqData.cartitemProductskuNamestr = skuData.itemName.join(',');
				reqData.cartitemProductskuMoneystr = skuData.price.join(',');
				reqData.cartitemProductNumber = productNum.val();

				var InitiateCheckoutMoney = getnowproductMoney(reqData.cartitemProductActoff, reqData.cartitemProductOriginalprice, reqData.cartitemProductskuMoneystr);

				function getnowproductMoney(cartitemProductActoff, cartitemProductOriginalprice, cartitemProductskuMoneystr) {
					var reallymoney = 0,
						skuMoneyArr = cartitemProductskuMoneystr.split(',');
					reallymoney = (getPrice(cartitemProductOriginalprice, skuMoneyArr, cartitemProductActoff * 10).current)
					return reallymoney;
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

				//fbq('track', 'InitiateCheckout');//追踪'发起结账'事件		facebook广告插件可以注释掉，但不要删除
				fbq('track', 'InitiateCheckout', {
					content_ids: reqData.cartitemProductId,
					content_type: 'product',
					value: InitiateCheckoutMoney,
					currency: "USD"
				});
				// name, id, price
				function getSkuData(els) {
					var data = {
						itemName: [],
						id: [],
						idName: [],
						price: []
					};
					els.each(function (i, item) {
						data.itemName.push($(item).find('.price-item.active').text());
						data.id.push($(item).data('id'));
						data.idName.push($(item).data('name'));
						data.price.push($(item).find('.price-item.active').data('price'));
					});

					return data;
				}

				var flag = false;
				flag = checkSku(skuCheckData);
				if (flag) generateOrderNow(reqData);
			}

			function generateOrderNow(reqData) {
				$.ajax({
					url: '${APP_PATH}/MlbackCart/toBuyNow',
					data: JSON.stringify(reqData),
					type: "POST",
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
				});
			}

			/*---------------countDownArea--------*/
			function rednerCountDownAreaOne(parent, data) {
				var html = '';
				html += '<div class="title">' + data.countdownTitle + '</div>' +
					'<div class="body"></div>' +
					'<div class="desc">' + data.countdownDescription + '</div>';

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
					state: false,
				});

				if (countdown && countdown.state == 'after') {
					$('#countdown-area').addClass('hide');
				}
			}
			var countDownArea = $('#countdown-area');
			$.ajax({
				url: '${APP_PATH}/MlbackCountDown/getOneMlbackCountDownDetail',
				data: "countdownId=" + 1,
				type: "POST",
				success: function (data) {
					if (data.code == 100) {
						data.extend.mlbackCountDownOne && rednerCountDownAreaOne(countDownArea, data.extend.mlbackCountDownOne);
					} else {
						renderErrorMsg(productBox, 'No product-related data was obtained.');
					}
				}
			});
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
						'<span class="product-now-price">$' + (data[i].productOriginalprice && data[i].productActoffoff ? (data[i]
							.productOriginalprice * data[i].productActoffoff / 100).toFixed(2) : 0) + '</span>' +
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
						var resDataProduct = data.extend.mlbackProductResList;
						rednerProduct(hot_pic, resDataProduct)
						new Swiper('.hot_box_product_cont', {
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
		});

		function deleteReview() {
			var data = { reviewId: reviewId };
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/deleteNew",
				data: JSON.stringify(data),
				dataType: "json",
				contentType: 'application/json',
				type: "POST",
				async: false,
				success: function (result) {
					if (result.code == 100) {
						reviewId = null;
						window.location.href = window.location.href;
					} else {
						renderSysMsg('系统错误，请联系管理员！');
					}
				}
			});
		}

		function uploadfu(parent, file) {
			//实例化一个FormData
			$(file).off('change').val('');
			$(file).on('change', function () {
				var obj = new FormData();
				var fileObj = file.files[0],
					filesize = fileObj.size;
				if (filesize >= 3 * 1024 * 1024) {
					alert("Maximum upload file size: 3M")
					return false
				} else {
					obj.append('file', file.files[0]);
					obj.append('reviewId', reviewId);
					obj.append('sort', imgCount);
					$.ajax({
						url: "${APP_PATH}/UpImg/uploadReviewAllImg",
						type: "post",
						dataType: "json",
						cache: false,
						data: obj,
						processData: false, // 不处理数据
						contentType: false, // 不设置内容类型
						success: function (data) {
							if (data.code == 100) {
								var returl = data.extend.uploadUrl;
								var img = $('<img src="${APP_PATH }/static/img/reviewAllImg/' + returl + '">');
								parent.find('.reviews-img-box').append(img);
								imgCount++;
							}
						}
					});
				}
			})
		}
	</script>
	<!-- megalook-->
	<script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script>
	<!-- megalookhair 
  	<script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
	<!-- huashuohair -->
	<!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>