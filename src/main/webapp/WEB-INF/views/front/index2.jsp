<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
 %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
html, body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  min-height: 300px;
  min-width: 300px;
  overflow: hidden;
  dispplay: flex;
  justify-content: center;
  alignt-items: center;
  backgound-color: #fdfdfd;
}
img {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>

<img src="${APP_PATH }/static/img/weihu.jpg" alt="">
</body>
</html>