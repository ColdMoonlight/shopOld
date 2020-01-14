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

	<jsp:include page="../mheader.jsp"></jsp:include>

	<!-- main -->
	<!-- main -->
	<div class="main">
		<div class="container videobox  clearfix">
			<div class="videocont clearfix">
				<ul class="clearfix">
			
				</ul>
			</div>
		</div>
	</div>

	<jsp:include page="../mfooter.jsp"></jsp:include>

	<script>
          var videocont= $(".videocont ul")
          function videoCont(parent, data,videoNum) {
            var html = '';
            for (var i=0, len=data.length; i < len; i += 1) {
				 var v_num =videoNum[i];
          		html += '<li>' +
          				'<a href="${APP_PATH }/MlbackVideo/toVideoAreaPage?videoArea='+data[i].videoshowareaId+'">' +
          				'<img src="'+data[i].videoshowareaWapimgurl+'">' +
          				'<p><em>'+data[i].videoshowareaName+'</em><span>('+v_num+')</span></p>'+
          				'</a>' +
          				'</li>';
          		}
            parent.html(html);
          }
          
          $.ajax({
          		 url: '${APP_PATH}/MlbackVideoShowArea/getMlbackVideoShowAreapcListByArea',
          			data: JSON.stringify({
          		   "videoshowareaAreanum": 2
          		 }),
          		 type: 'post',
          		 dataType: 'JSON',
          		 contentType: 'application/json',
          		 success: function (data) {
					 var JsonDate = JSON.parse(data);
          			console.log(JsonDate)/***data**/
          			   if (JsonDate.code === 100) {
          				 var resData = JsonDate.extend.mlbackVideoShowAreaList;
						  var videoNum = JsonDate.extend.videoNumByAreaListList;
          				 console.log(resData)
          				 videoCont(videocont,resData,videoNum)
          				 
          			   } 
          			 }
                 });

	</script>
	<!-- megalook-->
  	<script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script>
	<!-- megalookhair 
  	<script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
  	<!-- huashuohair -->
  	<!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>