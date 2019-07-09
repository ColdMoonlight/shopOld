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
<div class="main"></div>
 
<jsp:include page="mfooter.jsp"></jsp:include>
</body>
<script>
var param = window.location.href.split('?')[1].split('&').reduce(function(obj, item) {var arr=item.split('='); obj[arr[0]] = arr[1]; return obj;}, {});

// console.log(param)

$.ajax({
	url: '${APP_PATH}/MlbackFootNav/getMlfrontFootNavAll',
	type: 'post',
	async: false,
	success: function(data) {
		
		// console.log(data);
		var resData = data.extend;
		var html = '';
		if(resData.isNav === 0) {
			html = '没获取到相关数据';
		}
		if(resData.isNav === 1) {			
			var article = getArticle(resData[param.block], param.id);
			html = '<div class="article-title">'+ article.footnavName +'</div>' +
			'<div class="article-content">'+ article.footnavDesc +'</div>';
		}
		$('.main').html(html)
	}
});

function getArticle(data, id) {
	var article = {};
	for(var i=0, len=data.length; i<len; i+=1) {
		if (parseInt(data[i].footnavId) === parseInt(id)) {
			article = data[i];
			break;
		}
	}
	return article;
	console.log(article)
}
</script>
</html>