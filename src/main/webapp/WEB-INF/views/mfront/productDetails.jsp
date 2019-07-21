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
</head>

<body>

	<jsp:include page="mheader.jsp"></jsp:include>

	<!-- main -->
	<div class="main">
		<!-- <input type="hidden" value="${productId}" id="productId"/> -->
		<div class="product-details"> </div>
	</div>

	<jsp:include page="mfooter.jsp"></jsp:include>

  <script src="${APP_PATH }/static/js/countdown.min.js"></script>
	<script>
		/* load tpl for detail of product */
		$('.product-details').load('${APP_PATH}/static/tpl/productDetail.html', function () {
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
			var reviewBox = $('.group-details.reviews-info');

			var add = $('#product-num-add');
			var sub = $('#product-num-sub');
			var productNum = $('input[name="productNum"]');


			/* details of banner */
			$.ajax({
				url: '${APP_PATH}/MlbackProductImg/getMlbackProductImgListByProductId',
				data: {
					"productId": pidA[1]
				},
				type: "POST",
				success: function (data) {
					if (data.code === 100) {
						var html = '';
						var imgs = data.extend.mbackProductImgResList;
						for (var i = 0; i < imgs.length; i += 1) {
							html += '<div class="swiper-slide">' +
								'<img src="' + imgs[i].productimgUrl + '" alt="' + imgs[i].productimgName + '">' +
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
			var skuCheckData = {};
			$.ajax({
				//url: '${APP_PATH}/MlbackProductSku/getOneProductAllSku',
				url: '${APP_PATH}/MlbackProductSku/getfrontOneProductAllSku', //这个是只查yes的sku
				data: {
					"productId": pidA[1]
				},
				type: "POST",
				success: function (data) {
					if (data.code === 100) {
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
				var conditionEl = $('<div class="container product-d-length" data-name="' + data.productskuName +
					'" data-id="' + data.productskuId + '"/>');
				var html = '';
				var len = 1;
				for (var key in data) {
					if (typeof data[key] === 'string' && data[key].indexOf(',') > -1) {
						data[key] = data[key].split(',');
						if (len === 1) {
							len = data[key].length;
						}
					}
				}
				html += '<span class="sku-id-name">' + data.productskuName + ':</span>';
				html += '<div class="list">';
				for (var i = 0; i < len; i += 1) {
					if (i === 0) {
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
			/* details of main */
			$.ajax({
				url: '${APP_PATH}/MlbackProduct/getOneMlbackProductDetail',
				data: {
					"productId": pidA[1]
				},
				type: "POST",
				success: function (data) {
					if (data.code === 100) {
						var productData = data.extend.mlbackProductOne;
						console.log(productData)
						dataPrice = productData;
						prodcutDtitle.text(productData.productName);
						prodcutDpriceText.attr('data-price', productData.productOriginalprice);
						prodcutDpriceText.attr('data-discount', productData.productActoffoff);
						calPrice(productData.productOriginalprice, (productData.productOriginalprice * productData.productActoffoff / 100).toFixed(2));
						descriptionBox.html(productData.productDesc);
						repeatCalPrice();

					} else {
						renderErrorMsg(productDetailsBox, '未获取到产品相关的数据');
					}
				}
			});
			$.ajax({
				url: '${APP_PATH}/MlfrontReview/getMlfrontReviewListByPId',
				data: {
					"productId": pidA[1]
				},
				type: "POST",
				success: function (data) {
					if (data.code === 100) {
						var reviewTextData = data.extend.mlfrontReviewResList;
						var reviewImgData = data.extend.imgUrlStrListst;
						//console.log(data.extend);
						// renderReviewList(reviewBox.find('.review-list'), reviewTextData, reviewImgData);
						to_page(1);
					} else {
						renderErrorMsg(productDetailsBox, '未获取到产品评论相关的数据');
					}
				}
			});
			 
			/*
      review汇总接口  
      Integer productId;
      return StartNumList各个星级评论数		allReviewNum评论总数
      */
      $.ajax({
        url: '${APP_PATH}/MlfrontReview/getMlfrontReviewCount',
        data: {
          "productId": pidA[1]
        },
        type: "POST",
        success: function (data) {
          if (data.code === 100) {
            var productData = data.extend;
            console.log("MlfrontReview/getMlfrontReviewCount");
            console.log(data.extend)
          } else {
            renderErrorMsg(productDetailsBox, '未获取到产品相关的数据');
          }
        }
      });
      /*
      review分页接口
      Integer productId;//产品ID
      Integer pn;//页数
      return	分页信息(pageInfo),5条评论内容(mlfrontReviewResreturn)，5条评论中的图片(imgUrlStrListst)
      */			
      function to_page(pn, type) {
	  		$.ajax({
	  			url: "${APP_PATH}/MlfrontReview/getMlfrontReviewByProductIdAndPage",
	  			data: {
 	          "productId": pidA[1],
 	          "pn": 1
 	        },
	  			type: "POST",
	  			success: function (result) {
	  				// console.log(result);
	  				var reviewTextData = result.extend.mlfrontReviewResreturn;
	  				var reviewImgData = result.extend.imgUrlStrListst;
	  				var pageInfo = result.extend.pageInfo;
	  				// 列表数据
	  				renderReviewList(reviewBox.find('.review-list'), reviewTextData, reviewImgData);
	  				// 解析显示分页条数据
	  				render_page_nav(reviewBox.find('.page-info-area'), pageInfo);
	  			}
	  		});
	  	}

			// render reiew list
			function renderReviewList(parent, text, img) {
				var html = '';
				for(var i=0, len = img.length; i<len; i++) {
					html += '<li class="review-item" data-reviewid="'+ text[i].reviewId +'">' +
						 '<div class="review-title">' +
		           '<img src="'+ text[i].reviewUimgurl +'" alt="">' +
		           '<div class="review-data">' +
		             '<div class="review-d-author">AUTHOR: '+ text[i].reviewUname +'</div>' +
		             '<div class="review-d-rank">';
		             		for(var j=0; j<5; j++) {
		             			if (j < text[i].reviewProstarnum) {
		             				html += '<i class="icon star active"></i>';
		             			} else {
		             				html += '<i class="icon star"></i>';
		             			}
		             		}
		             html += '</div>' +
		           		'</div>' +
		           	'<div class="review-date">'+ text[i].reviewCreatetime +'</div>' +
		         '</div>' +
		         '<div class="review-imgs">';
		          var imgLen = img[i].length <= 5 ? img[i].length : 5;
		         	for (var k=0; k<imgLen; k++) {
		         		html += '<img src="'+ img[i][k] +'">';
		         	}
		         html += '</div>' +
             '<div class="review-content">' +
	             '<div class="review-text">'+ text[i].reviewDetailstr +'</div>' +
	             /* '<span class="review-more">more<i class="icon bottom"></i></span>' + */
	           '</div>' +
	         '</li>';
				}
				parent.html(html);
			}
			
			// render page nav
			function render_page_nav(parent, pageInfo) {
				//page_nav_area
				parent.empty();
				var ul = $("<ul></ul>").addClass("pagination");

				//构建元素
				var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
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
				var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
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
						calPrice(originalPrice.toFixed(2), (originalPrice * discount).toFixed(2));
					} else {
						productNum.val(parseInt(productNum.val()) - 1);
						calPrice((productNum.val() * originalPrice).toFixed(2), (productNum.val() * originalPrice * discount)
							.toFixed(2));
					}
				});
				add.on('click', function () {
					var originalPrice = prodcutDpriceText.data('price') + calOverPrice();
					productNum.val(parseInt(productNum.val()) + 1);
					calPrice((productNum.val() * originalPrice).toFixed(2), (productNum.val() * originalPrice * discount)
						.toFixed(2));
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
				var original = 0;
				var discount = 0;
				original = ((parseFloat(prodcutDpriceText.data('price')) + calOverPrice()) * parseInt(productNum.val()))
					.toFixed(2);
				discount = (original * parseFloat(prodcutDpriceText.data('discount')) / 100).toFixed(2);
				calPrice(original, discount);
			}

			// add-to-cart
			$('.add-to-cart').on('click', function () {
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

				var flag = false

				// console.log(skuCheckData);
				flag = checkSku(skuCheckData);
				// console.log(flag)
				if (flag) generateOrder(reqData);

			});

			function checkSku(skuCheckData) {
				for (var i in skuCheckData) {
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
					type: "POST",
					dataType: 'JSON',
					contentType: 'application/json',
					success: function (data) {
						var resData = JSON.parse(data);
						if (resData.code === 100) {
							// console.log(resData)
							// cartText.text(parseInt(cartText.text()) + 1);
							window.location.href = '${APP_PATH}/MlbackCart/toCartList';
						}
					},
					error: function (data) {
						cartText.text(num);
					}
				});
			}

			/* $('.buy-now').on('click', function () {
				window.location.href = '${APP_PATH}/MlbackCart/toCartList';
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
		      state: false,
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
		});
		
		
		/****************************以下是所需介绍***************************************************/
		
		/**
		
			格式
			url: "${APP_PATH}/MlfrontReview/saveNew",
			data: JSON.stringify(reqData),
			dataType: "json",
			contentType: 'application/json',
			type: "POST",
			
			参数	private Integer reviewPid;
			
			return mlfrontReviewOne(这里面有reviewId)
		
		*/
		//点击write a review		可用下面格式的代码改成
		$(document).on('click', '#tasksubmit', function () {
			var data = $('form').serializeArray();
			reqData = data.reduce(function (obj, item) {
				obj[item.name] = item.value;
				return obj
			}, {});
			//console.log(reqData)
			//alert(data.productDesc);
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/saveNew",
				data: JSON.stringify(reqData),
				dataType: "json",
				contentType: 'application/json',
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						alert('操作成功！');
						window.location.href = "${APP_PATH}/MlfrontReview/toMlfrontReviewPage";
					}
				}
			});
		});
			
		/*************************************************************************************/	
		
		/**
		private Integer reviewId;	//页面已经有了，带回来即可
	    private String reviewUname;	//存放uName
	    private String reviewPname; //存放uEmail
	    private String reviewDetailstr;	//存放评论详情
	    private Integer reviewProstarnum;	//存放打分
		*/
		//提交评论--新建编辑任務提交按钮
		$(document).on('click', '#tasksubmit', function () {
			var data = $('form').serializeArray();
			reqData = data.reduce(function (obj, item) {
				obj[item.name] = item.value;
				return obj
			}, {});
			//console.log(reqData)
			//alert(data.productDesc);
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/save",
				data: JSON.stringify(reqData),
				dataType: "json",
				contentType: 'application/json',
				type: "POST",
				success: function (result) {
					if (result.code == 100) {
						alert('操作成功！');
						window.location.href = "${APP_PATH}/MlfrontReview/toMlfrontReviewPage";
					}
				}
			});
		});	
			
		/*************************************************************************************/		
		// 取消评论--删除该条（id）分类信息
		$("#task_table").on("click", ".btn-danger", function () {
			var data = {
				reviewId: $(this).attr('del-id')
			};
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/delete",
				data: JSON.stringify(data),
				dataType: "json",
				contentType: 'application/json',
				type: "post",
				success: function (result) {
					if (result.code == 100) {
						alert('删除成功！');
						to_page(1);
					}
				}
			});
		});
		
		/************************传买家秀图片的方法*********************************************/
		
		/**这是你在addreview.html页面的样式代码*/
		/* <div>
			  <div class="upload-img-btn">
			     <input class="uploadImg upload-img-fu" type="file" >
			  </div>
			  <div class="upload-img-btn">
			     <input class="uploadImg upload-img-fu" type="file" >
			  </div>
			  <div class="upload-img-btn">
			     <input class="uploadImg upload-img-fu" type="file" >
			  </div>
		  </div>
		  <div>
			  <div class="upload-img-btn">
			     <input class="uploadImg upload-img-fu" type="file" >
			  </div>
			  <div class="upload-img-btn">
			     <input class="uploadImg upload-img-fu" type="file" >
			  </div>
		  </div> */
		
		/**这是你在addreview.html页面的js代码*/
		$('.upload-img-fu').each(function (i, item) {
			$(item).on("change", function () {
				uploadfu($(this), i + 1);
			})
		});
		  /**这是具体上传的js代码*/
		// upload img 1-2
		function uploadfu(item, index) {
			var self = this;
			// console.log(self)
			//实例化一个FormData
			var obj = new FormData();
			obj.append('file', item[0].files[0]);
			// console.log($(this)[0].files[0])
			var reviewIdUP = $(":input[name='reviewId']").val();
			if (reviewIdUP == null) {
				//如果没有pid,弹出"请先输入产品名，保存后再次进入"
				// console.log("productIdUP:"+productIdUP);
				alert("请先输入产品名，保存后从编辑进入");
			} else {
				obj.append('reviewId', reviewIdUP);
				obj.append('sort', index);
				$.ajax({
					url: "${APP_PATH}/UpImg/uploadReviewAllImg",
					type: "post",
					dataType: "json",
					cache: false,
					data: obj,
					processData: false, // 不处理数据
					contentType: false, // 不设置内容类型
					success: function (data) {
						//设置背景为我们选择的图片
						// console.log(data);
						var returl = data.extend.uploadUrl;
						item.parent().css({
							"background-image": "url(" + '${APP_PATH }/static/img/reviewAllImg/' + returl + ")"
						});
					}
				});
			}
		}
		
		
	</script>
</body>

</html>