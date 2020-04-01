<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Product List</title>
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
	<script>
  		fbq('track', 'ViewContent');
	</script>
	<!-- Facebook Pixel Code end -->
	
</head>

<body>

	<jsp:include page="../pcheader.jsp"></jsp:include>

	<!-- main -->
	<div class="main">
		<div class="ban_insimg">
			<img src="${APP_PATH }/static/pc/img/insimg1.jpg" >
			<img src="${APP_PATH }/static/pc/img/insimg11.jpg" >
		</div>
		<div class="container clearfix">
			
            <div class="list_pro_cont" id="waterfull">
            	<ul>
            		
            	</ul>
            </div>
			
			
		</div>
	</div>

	<jsp:include page="../pcfooter.jsp"></jsp:include>
	<script src="${APP_PATH }/static/js/masonry.min.js"></script>
	<script type="text/javascript">
        $(function(){
			// rec()
			// function rec(){
			// 	var mymessage=confirm("你喜欢javascript吗？");
			// 	if(mymessage==true){
			// 		document.write("很好，加油！");
			// 	}else if(mymessage==false){
			// 		document.write("要学javascript，而且必须学");
			// 	}
			// }
			var masonrycont =$("#waterfull ul")
			var loading=$('#imloading');
			// 初始化loading状态
			loading.data("on",true);
			$.ajax({
				url: "${APP_PATH}/MlfrontReview/selectReviewListFrom",
					data:{
					  "reviewFrom": 2
					},
					type: "POST",
					success: function (result) {
					  if (result.code == 100) {
							console.log(result);
							  resData = result.extend.mlfrontReviewList;
							  resDataimg = result.extend.mlfrontReviewImgList;
							  masonryHtml(masonrycont,resData,resDataimg)
						  }
					}
			  });
			function masonryHtml(parent, data1, data2){
				var html = '';
				for(var i=0;i<data1.length;i++){
					html += '<li class="item">';
					// var data11 =data2[i];
					 // console.log(data11);
					for(var j=0;j<data2[i].length;j++){
						// var data11 =data2[i][j].reviewimgUrl;
						 // console.log(data11);
					    html +=	'<img src="'+data2[i][j].reviewimgUrl+'" />';
					 }	
					 html +=  '<p class="p_contpl">'+ data1[i].reviewDetailstr +'</p>'+
							  '<p class="time_namep2">'+
							  '<span class="time">by <i class="sp1"> '+ data1[i].reviewUname +'</i></span>'+
							  '<span class="time">'+ data1[i].reviewCreatetime +'</span>'+
							  '<p class="btnlink">'+
							  '<a href="${APP_PATH }/MlbackProduct/topcProductDetailPage?productId='+data1[i].reviewPid+'" class="btn_shop">Shop This Look</a>'+
							  '</p>';
							  '</p>';
					
					 html += '</li>';
				}
				  parent.html(html);
				/*瀑布流开始*/
				var $container = $('.list_pro_cont ul');
				/*判断瀑布流最大布局宽度，最大为1280*/
				function tores(){
					var tmpWid=$(window).width();
					if(tmpWid>1300){
						tmpWid=1300;
					}else{
						var column=Math.floor(tmpWid/325);
						tmpWid=column*325;
					}
					$('.list_pro_cont ul').width(tmpWid);
				}
				tores();
				$(window).resize(function(){
					tores();
				});
				$container.imagesLoaded( function(){
					$container.masonry({
							columnWidth: 325,
							itemSelector : '.item',
							isFitWidth: true,//是否根据浏览器窗口大小自动适应默认false
							isRTL:false,//设置布局的排列方式，即：定位砖块时，是从左向右排列还是从右向左排列。默认值为false，即从左向右
							isResizable: true,//是否自动布局默认true
					});
				});
				/******************/
				
			}		
		})
		
		addTidio();
	</script>
  	<!-- megalook-->
  	<!-- <script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script> -->
	<!-- megalookhair 
  	<script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
  	<!-- huashuohair -->
  	<!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>