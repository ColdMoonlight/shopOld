<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
 %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="post" action="${APP_PATH }/paypal/pay">
    <button type="submit"><img src="${APP_PATH }/static/m/img/other/paypal.jpg" width="100px;" height="30px;"/></button>
</form>
</body>
</html>