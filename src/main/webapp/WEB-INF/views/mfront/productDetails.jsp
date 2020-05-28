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
		}(window, document, 'script',
			'https://connect.facebook.net/en_US/fbevents.js');
		fbq('init', '246433859565492');//huashuohair
		//fbq('init', '667403967094866');//megalook
		fbq('track', 'PageView');
		
		var title = '${sessionScope.mlbackProductMetaTitle}';
		var description = '${sessionScope.mlbackProductMeteDesc}';
		var keywords = '${sessionScope.mlbackProductMetaKeyWords}';
		function addMetaKeyword() {
			var meta = document.createElement('meta');
			meta.name = "keyword";
			meta.content = keywords;
			document.head.appendChild(meta);
		}
		
		function addMetaDescription() {
			var meta = document.createElement('meta');
			meta.name = "description";
			meta.content = description;
			document.head.appendChild(meta);
		}

		title && (document.title = title);
		keywords &&	addMetaKeyword();
		description && addMetaDescription();
	</script>
	<!--huashuohair-->
	<noscript><img height="1" width="1" style="display:none"src="https://www.facebook.com/tr?id=246433859565492&ev=PageView&noscript=1" /></noscript>
	<!--megalook-->
	<!-- <noscript><img height="1" width="1" style="display:none"src="https://www.facebook.com/tr?id=667403967094866&ev=PageView&noscript=1" /></noscript> -->
	<!-- End Facebook Pixel Code -->
</head>

<body>
	<jsp:include page="mheader.jsp"></jsp:include>

	<!-- main -->
	<div class="main">
		<!-- <input type="hidden" value="${productId}" id="productId"/> -->
		<div class="product-details"> </div>
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
				<div class="name">PICTURE (optional)</div>
				<div class="reviews-img-list">
					<div class="review-img-add">
						<input type="file">
						<i class="icon plus"></i>
					</div>
					<div class="reviews-img-box"></div>
					<div class="maskdd"></div>
				</div>
				<span class="review-ok">publish</span>
			</div>
		</div>
	</div>

	<jsp:include page="mfooter.jsp"></jsp:include>
	<div class="mask5" style="display: none;"></div>
	<div class="loading">
		<div class="boxload">
			<div class="loader-14"></div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/lazyload@2.0.0-rc.2/lazyload.js"></script>
	<script src="${APP_PATH }/static/js/relativetime.min.js"></script>
	<script src="${APP_PATH }/static/js/countdown.min.js"></script>
	<script  src="https://www.paypal.com/sdk/js?client-id=AQyXf-N2nNr8QwJsFt7IudPRL-CMGYEXCCzgqOHIA037JLhSFOEchb2kGa_z_BqzKY4CmUPFiGqG_uNj"></script>
	<script>
		var imgCount = 1,
			reviewId = null,
			sessionScopeproductId = '${sessionScope.productDetailId}',
			loadProduct2Url = "${APP_PATH }/static/m/img/loading/load-product2.gif"
		/* load tpl for detail of product */
		$('.product-details').load('${APP_PATH}/static/tpl/productDetail.html', function () {
			//接到产品id，查询本id产品的详情
			var pidA = sessionScopeproductId,
				dataPrice = null,
				swiper = $('.product__details-banner .swiper-wrapper'),
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
				countDownArea = $('#countdown-area'),
				skuCheckData = {};

			/* details of banner */
			$.ajax({
				url: '${APP_PATH}/MlbackProductImg/getMlbackProductImgListByProductId',
				data: { "productId": pidA },
				type: "post",
				success: function (data) {
					if (data.code == 100) {
						// console.log(data)
						var resData = data.extend.mbackProductImgResList,
							videoData = data.extend.mlbackProductOne;
						if (videoData.productMainFuimgurl && videoData.productColor) {
							resData.unshift({
								imgUrl: videoData.productMainFuimgurl,
								videoUrl: videoData.productColor
							});
						}
						renderProductDetailsBanner(swiper, resData);
						new Swiper('.product__details-banner', {
							pagination: {
								el: '.swiper-pagination',
								clickable: true
							}
						});
						new LazyLoad(swiper.find('img'), {
							root: null,
							rootMargin: "10px",
							threshold: 0
						});
					} else {
						renderErrorMsg(swiper, 'No data for the relevant image was obtained');
					}
				}
			});
			/* couponlist */
			$.ajax({
				url: '${APP_PATH}/MlbackCouponDescTitle/getMlbackCouponDescTitlewapListByStatus',
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
				if (data.title && data.title.coupondesctieleWapstatus)
					htmlStr += '<img src="' + data.title.coupondesctieleWapimgurl + '" />';
				htmlStr += '<div class="sale_coupon-body"><p>' + data.title.coupondesctieleTieledetail + '</p><ul>';
				for (var i = 0, len = data.couponList.length; i < len; i++) {
					htmlStr += '<li>' + data.couponList[i].coupondescdetailStrengthpre + '&nbsp;<span>&nbsp;'
						+ data.couponList[i].coupondescdetailStrength + '&nbsp;</span>&nbsp;'
						+ data.couponList[i].coupondescdetailCodepre
						+ '&nbsp;<b>&nbsp;' + data.couponList[i].coupondescdetailCode + '</b></li>';
				}
				htmlStr += '</ul></div>';
				parent.html(htmlStr);
			}
			/* detials of condition（sku） */
			$.ajax({
				url: '${APP_PATH}/MlbackProductSku/getfrontOneProductAllSku', //这个是只查yes的sku
				data: { "productId": pidA },
				type: "post",
				success: function (data) {
					if (data.code == 100) {
						// console.log(data)
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
				var html = '',
					hasVideo = false;

				for (var i = 0, len = data.length; i < len; i += 1) {
					if (data[i].videoUrl && data[i].imgUrl) {
						html += '<div class="swiper-slide">' +
						'<img class="showVideo" src="' + loadProduct2Url + '" data-src="' + data[i].imgUrl + '" data-video="'+ data[i].videoUrl +'" />' +
						'</div>';
						hasVideo = true;
					} else {
						html += '<div class="swiper-slide">' +
							'<img src="' + loadProduct2Url + '" data-src="' + data[i].productimgUrl + '" alt="' + data[i].productimgName + '">' +
							'</div>';
					}
				}
	
				swiper.html(html);
				
				hasVideo && showVideo();
			}
			
			function showVideo() {
				$('.showVideo').on('click', function(e) {
					function matchYoutubeUrl(url){
						/* var p = /^(?:https?:\/\/)?(?:www\.)?(?:youtu\.be\/|youtube\.com\/(?:embed\/|v\/|watch\?v=|watch\?.+&v=))((\w|-){11})(?:\S+)?$/;
					    return (url.match(p)) ? RegExp.$1 : false ; */
					    return url.split("watch?v=")[1];
				   	}
					var videoUrl = $(this).data('video');
					if (videoUrl)
						$(this).parent().html('<iframe frameborder="0" allowfullscreen="1" allow="autoplay; encrypted-media" title="YouTube video player" width="100%" height="375" src="https://www.youtube.com/embed/'+ matchYoutubeUrl(videoUrl) +'"></iframe>');
				});
			}

			function triggerCondition(parent) {
				parent.find('.product-d-length').each(function (i, item) {
					var activeItem = $(item).find('.price-item.active');
					$(item).find('.price-item').each(function (i, item) {
						$(item).on('click', function () {
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
				var productskuNameDetails = data.productskuNameDetails.split(','),
					lengthsku = productskuNameDetails.length,
					conditionEl = $('<div class="container product-d-length" data-name="' + data.productskuName + '" data-id="' + data.productskuId + '"/>'),
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
					if (lengthsku > 1) {
						html += '<span class="price-item" data-price="' + toNumber(data.productskuMoneyDetails[i]) + '">' + data
							.productskuNameDetails[i] + '</span>'
					} else {
						html += '<span class="price-item" data-price="' + toNumber(data.productskuMoneyDetails) + '">' + data
							.productskuNameDetails + '</span>'
					}

				}
				html += '</div>';
				parent.append(conditionEl.html(html));
			}
			/* details of main */
			$.ajax({
				url: '${APP_PATH}/MlbackProduct/getOneMlbackProductDetail',
				data: { "productId": pidA },
				type: "post",
				success: function (data) {
					if (data.code == 100) {
						var productData = data.extend.mlbackProductOne;
						// console.log(productData);
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
						// console.log(productData);
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
				type: "post",
				success: function (data) {
					if (data.code == 100) {
						var productData = data.extend,
							staticData = data.extend.StartNumList,
							reviewTotal = data.extend.allReviewNum,
							reviewStatics = $(".reviews-statics"),
							dataMap = {},
							toalStar = 0;

						function renderProgress(parent, num, total) {
							var html = '',
								percent = (num * 100 / total || 0).toFixed(2);
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
					data: { "productId": pidA, "pn": pn },
					type: "post",
					success: function (result) {
						var reviewTextData = result.extend.mlfrontReviewResreturn,
							reviewImgData = result.extend.imgUrlStrListst,
							pageInfo = result.extend.pageInfo,
							reviewBoxList = reviewBox.find('.review-list'),
							pageArea = reviewBox.find('.page-info-area');
						if (reviewImgData.length > 0) {
							renderReviewList(reviewBoxList, reviewTextData, reviewImgData);
							new LazyLoad(reviewBoxList.find('img'), {
								root: null,
								rootMargin: "10px",
								threshold: 0
							});
							pageArea.removeClass('hide');
							render_page_nav(pageArea, pageInfo);
							$('.review-imgs').each(function (i, item) {
								lightbox($(item).find('img'));
							});
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
						'<div class="img"><img src="'+ loadProduct2Url +'" data-src="' + text[i].reviewUimgurl + '" alt=""></div>' +
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
						html += '<img src="'+ loadProduct2Url +'" data-src="' + img[i][k] + '">';
					}
					html += '</div>' +
						'</li>';
				}
				parent.html(html);
			}

			// render page nav
			function render_page_nav(parent, pageInfo) {
				//page_nav_area
				parent.empty();
				// 构建元素
				var ul = $("<ul></ul>").addClass("pagination"),
					firstPageLi = $("<li></li>").append($("<a></a>").append("first").attr("href", "javascript:;")),
					prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;")),
					nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;")),
					lastPageLi = $("<li></li>").append($("<a></a>").append("last").attr("href", "javascript:;"));

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
					data: JSON.stringify({ reviewPid: pidA, }),
					dataType: "json",
					contentType: 'application/json',
					type: "post",
					async: false,
					success: function (result) {
						if (result.code == 100) {
							reviewId = result.extend.mlfrontReviewOne.reviewId;
						} else {
							renderSysMsg('System error, please contact the administrator!');
						}
					}
				});
				$('.review-box').removeClass('hide');
				$(".maskreview").show();
			});
			// close review box
			$('.review-cancel').on('click', function () {
				$('.review-box').addClass('hide');
				$(".maskreview").hide();
				deleteReview();
			});
			// select star reank
			$('.review-star .icon').forEach(function (item) {
				var parent = $(item).parent();
				$(item).on('click', function () {
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
				var details = $('.review-details').val().trim(),
					starNum = parseInt($('.review-star').data('star'), 10),
					username = $('input[name="username"]').val().trim(),
					reqData = {};
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
				reqData = {
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
					type: "post",
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

			// manipulate dom
			$('.list-group')
				.find('.list-group-item')
				.each(function (i, item) {
					var details = $(item).find(".group-details");
					$(item).find('.group-title').on('click', function () {
						if (details.hasClass('active')) {
							details.removeClass('active').hide();
							$(this).find('.icon').removeClass('bottom').addClass('right');
						} else {
							details.addClass('active').show();
							$(this).find('.icon').removeClass('right').addClass('bottom');
						}
					})
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
				original = ((parseFloat(prodcutDpriceText.data('price')) + calOverPrice()) * parseInt(productNum.val()))
					.toFixed(2);
				discount = (original * parseFloat(prodcutDpriceText.data('discount')) / 100).toFixed(2);
				calPrice(original, discount);
			}

			// add-to-cart
			$('.add-to-cart').on('click', function () {
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
						renderSysMsg('Please select product attributes  ' + i);
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
					type: "post",
					dataType: 'json',
					contentType: 'application/json',
					success: function (data) {
						if (data.code == 100) {
							//追踪'添加购物车'事件		facebook广告插件可以注释掉，但不要删除
							fbq('track', 'AddToCart', {
								content_ids: fbpid,
								content_type: 'product',
								value: fbprice,
								currency: 'USD'
							});
							// cartText.text(parseInt(cartText.text()) + 1);
							selectCartOrCheckout(reqData);
							$(".mask5").show();
							setTimeout(function () {
								window.location.href = '${APP_PATH}/myCart.html';
								$(".mask5").hide();
								$(".sys-box").hide();
							}, 5000);
						}
					},
					error: function (data) {
						cartText.text(num);
					}
				});
			}

			function selectCartOrCheckout(product) {
				var allskuMoneystr = product.cartitemProductskuMoneystr,
					arrynum = new Array(),
					sku_numall = 0,
					tc_price = 0,
					html = '',
					elBox = '';
				arrynum = allskuMoneystr.split(",");
				// console.log(arrynum)
				function getSum(total, num) {
					return total * 1 + num * 1;
				}
				sku_numall = arrynum.reduce(getSum);
				tc_price = (((product.cartitemProductOriginalprice * 1 + sku_numall * 1) * product.cartitemProductActoff * product.cartitemProductNumber) / 10).toFixed(2)

				elBox = $('<div class="modal sys-box" style="display: block;"></div>');
				html = '<div class="sys-title" style="background: #000; color: #fff;">' +
					'Item successfully added to your cart!' +
					'</div>' +
					'<div class="sys-body" style="display: flex;">' +
					'<img src="' + product.cartitemProductMainimgurl + '" style="display: block; width:100px; height:100px;">' +
					'<div class="content" style="width: 70%; padding-left: 10px; text-align: left;">' +
					'<h4>' + product.cartitemProductName + '</h4>' +
					'<div style="margin: 12px 0;">PRICE: $' + tc_price + '</div>' +
					'<a href="${APP_PATH}/myCart.html" class="btn btn-red" style="padding: 8px; border-radius: 0;">view cart</a>' +
					'<button class="btn btn-pink buy-now2" style="padding: 8px; margin-left: 1em; border-radius: 0;">checkout</button>' +
					'</div>' +
					'</div>' +
					'<div class="sys-footer" style="padding: 8px 0; font-size: 14px; text-align: center; border-top: 1px solid #ccc;">Free Gift For Every Order!</div>'
					;

				$(document.body).append(elBox.html(html));

				$('.buy-now2').on('click', function () {
					buyNow();
				});
			}

			$('.buy-now').on('click', function () {
				buyNow();
			});
			
			$('.paypal-button').on('click', function() {
				$('.loading').show();
				buyNow(true);
			});

			function buyNow(isCredit) {
				var skuData = getSkuData($('.product-d-length')),
					reqData = {},
					InitiateCheckoutMoney = 0,
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

				InitiateCheckoutMoney = getnowproductMoney(reqData.cartitemProductActoff, reqData.cartitemProductOriginalprice, reqData.cartitemProductskuMoneystr);

				function getnowproductMoney(cartitemProductActoff, cartitemProductOriginalprice, cartitemProductskuMoneystr) {
					var reallymoney = 0,
						skuMoneyArr = cartitemProductskuMoneystr.split(',');
					reallymoney = (getPrice(cartitemProductOriginalprice, skuMoneyArr, cartitemProductActoff * 10).current);
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

				flag = checkSku(skuCheckData);
				if (flag) {
					if (isCredit) {
						generateCreditNow(reqData);
					} else {						
						generateOrderNow(reqData);				
					}
				} else {
					$('.loading').hide();
				}
			}
			// create order
			function generateOrderNow(reqData) {
				$.ajax({
					url: '${APP_PATH}/MlbackCart/toBuyNow',
					data: JSON.stringify(reqData),
					type: "post",
					dataType: 'json',
					contentType: 'application/json',
					success: function (data) {
						if (data.code == 100) {
							// console.log(resData)
							// cartText.text(parseInt(cartText.text()) + 1);
							window.location.href = '${APP_PATH}/MlbackCart/toCheakOut';
						}
					},
					error: function (data) {
						cartText.text(num);
					}
				});
			}
			// create direct paypal
			function generateCreditNow(reqData) {
				// create order id
				$.ajax({
					/* url: '${APP_PATH}/MlbackCart/toBuyNow', */
					url: '${APP_PATH}/ProPay/toBuyNowPay',					
					data: JSON.stringify(reqData),
					type: "post",
					dataType: 'json',
					contentType: 'application/json',
					success: function (data) {
						if (data.code == 100) {
							console.log(data)
							// cartText.text(parseInt(cartText.text()) + 1);
							// window.location.href = '${APP_PATH}/MlbackCart/toCheakOut';
							// create payment id
							$.ajax({
								url: '${APP_PATH}/MlfrontOrder/proDetailOrderToPayInfo',
								data: JSON.stringify({
									"orderId": data.extend.OrderIdBuyNowPay,
									"orderPayPlate": 1, //选择的付款方式,int类型   paypal传0，后来再有信用卡传1
									"orderProNumStr": productNum.val()
								}),
								type: 'post',
								dataType: 'json',
								contentType: 'application/json',
								success: function (data) {
									console.log(data)
									if (data.code == 100) {								
										if (data.extend.isSuccess == 0) {
											window.location.href = '${APP_PATH }/paypalProDetailExpress/mpay';
										}					
									}
								}
							})
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

			$.ajax({
				url: '${APP_PATH}/MlbackCountDown/getOneMlbackCountDownDetail',
				data: "countdownId=" + 1,
				type: "post",
				success: function (data) {
					// console.log("mlbackCountDownOne");
					if (data.code == 100) {
						if (data.extend.mlbackCountDownOne) {
							rednerCountDownAreaOne(countDownArea, data.extend.mlbackCountDownOne)
						}
					} else {
						// renderErrorMsg(prodcutBox, '未获取到产品相关的数据');
						renderErrorMsg(productBox, 'No product-related data was obtained.');
					}
				}
			});
			/*******hot_box_product********************************/
			function rednerProduct(parent, data) {
				var html = '';
				for (var i = 0; i < data.length; i += 1) {
					var productactoffif = data[i].productActoffIf,
						productactoffid = data[i].productActoffid,
						cp_icon = "",
						showspan = "";
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
						'<img src="' + loadProduct2Url + '" data-src="' + data[i].productMainimgurl + '" alt="">' +
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
				url: '${APP_PATH}/MlbackSlide/getMlbackSlidewapListByArea',
				data: JSON.stringify({ "slideArea": 3 }),
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				success: function (data) {
					if (data.code == 100) {
						var resDataProduct = data.extend.mlbackProductResList;
						rednerProduct($('.hot_box_product_cont .swiper-wrapper'), resDataProduct);
						new LazyLoad($('.hot_box_product_cont').find('img'), {
							root: null,
							rootMargin: "10px",
							threshold: 0
						});
						new Swiper('.hot_box_product_cont', {
							slidesPerView: 2,
							spaceBetween: 5,
							freeMode: true,
							loop: true,
							autoplay: {
								disableOnInteraction: false,
							},
							pagination: {
								el: '.swiper-pagination2',
								clickable: true
							}
						});
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
				type: "post",
				async: false,
				success: function (result) {
					if (result.code == 100) {
						reviewId = null;
						window.location.href = window.location.href;
					} else {
						renderSysMsg('System error, please contact administrator!');
					}
				}
			});
		}

		function uploadfu(parent, file) {
			//实例化一个FormData
			$(file).off('change').val('');
			$(file).on('change', function () {
				var obj = new FormData(),
					fileObj = file.files[0],
					filesize = fileObj.size;
				if (filesize >= 3 * 1024 * 1024) {
					alert("Maximum upload file size: 3M")
					return false
				} else {
					obj.append('file', fileObj);
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
								var returl = data.extend.uploadUrl,
									img = $('<img src="${APP_PATH }/static/img/reviewAllImg/' + returl + '">');
								parent.find('.reviews-img-box').append(img);
								imgCount++;
							}
						}
					});
				}
			});
		}

		function lightbox(imgs) {
			var win = $(window),
				winW = win.width() - 60,
				winH = win.height() - 60,
				imgW = 200,
				imgH = 200;

			imgs.each(function (i, item) {
				$(item).on('click', function () {
					var img = new Image();
					img.src = this.src;

					popup();

					img.onload = function () {
						var ratio = img.width / img.height;
						if (winW / ratio > winH) {
							img.style = 'width: auto; height: 100%;';
						} else {
							img.style = 'width: 100%; height: auto;';
						}

						$('.imgbig_cont').html(img);
					}
				});
			});

			function popup(src, style) {
				var lightboxEl = $('<div class="light_box"></div>'),
					html = "";
				html += '<div class="light_box-inner">' +
					'<div class="img_boxbig"><div class="light_box-close"><i class="icon close"></i></div><div class="imgbig_cont"></div></div>' +
					'</div>';

				$(document.body).append(lightboxEl.html(html));

				[$('.light_box'), $('.light_box-close i')].forEach(function (item) {
					$(item).on('click', function () {
						var lightboxEl = $('.light_box');
						lightboxEl.addClass('zoom_out');

						setTimeout(function () {
							lightboxEl.remove();
						}, 600);
					});
				})
			}
		}
		addTidio();
	</script>
</body>

</html>