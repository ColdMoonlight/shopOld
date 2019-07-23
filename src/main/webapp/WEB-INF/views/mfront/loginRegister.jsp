<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Login & Register</title>
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
		<div class="login-register">
			<div class="tab">
				<div class="tab-item active" data-id="signin">Sign In</div>
				<div class="tab-item" data-id="register">Register</div>
			</div>
			<div class="tab-pane signin active">
				<form id="signin">
					<div class="input-group">
						<label for="userEmail">e-mail</label>
						<input type="email" name="userEmail" placeholder="eamil" required>
					</div>
					<div class="input-group">
						<label for="userPassword">password</label>
						<input type="password" name="userPassword" placeholder="password at least six figures">
					</div>
				</form>

				<a href="javascript:;" class="btn btn-pink sigin"> SIGIN </a>
			</div>
			<div class="tab-pane register">
				<form id="register">
					<div class="input-group">
						<label for="userEmail">e-mail</label>
						<input type="email" name="userEmail" placeholder="please input eamil" required>
					</div>
					<div class="input-group">
						<label for="userPassword">password</label>
						<input type="password" name="userPassword" placeholder="password at least six figures">
					</div>
				</form>

				<a href="javascript:;" class="btn btn-pink register"> REGISTER </a>
			</div>
		</div>
	</div>

	<jsp:include page="mfooter.jsp"></jsp:include>
</body>

<script>
	var loginRegister = $('.login-register');
	var activeItem = loginRegister.find('.tab-item.active');
	var tabPaneActive = loginRegister.find('.tab-pane.active');
	loginRegister.find('.tab-item').each(function (i, item) {
		$(item).on('click', function () {
			if ($(this).html() !== activeItem.html()) {
				activeItem.removeClass('active');
				activeItem = $(this);
				activeItem.addClass('active')
				var tabPaneId = $(this).data('id');
				tabPaneActive.removeClass('active');
				tabPaneActive = loginRegister.find('.tab-pane.' + tabPaneId);
				tabPaneActive.addClass('active');
			}
		})
	})
	/**
	 private String userEmail;
	 private String userPassword;
	 ${APP_PATH }/MlfrontUser/login",//register
	 */

	$('.btn.sigin').on('click', function () {
		var email = $('#signin input[name=userEmail]').val();
		var password = $('#signin input[name=userPassword]').val();
		var reqData = {};
		reqData.userEmail = email;
		reqData.userPassword = password;
		// console.log(reqData);

		if (inputCheck(reqData)) {
			$.ajax({
				url: "${APP_PATH }/MlfrontUser/login", //register
				type: 'POST',
				data: JSON.stringify(reqData),
				dataType: 'json',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend;
					if (resData.loginYes === 0) {
						alert(resData.resMsg)
					}

					if (resData.loginYes === 1) {
						alert(resData.resMsg)
						window.location.href = "${APP_PATH}/index/isMobileOrPc";
					}
				}
			})
		} else {
			alert('email or password format incorrect!');
		}
	})

	$('.btn.register').on('click', function () {
		var email = $('#register input[name=userEmail]').val();
		var password = $('#register input[name=userPassword]').val();
		var reqData = {};
		reqData.userEmail = email;
		reqData.userPassword = password;
		// console.log(reqData);

		if (inputCheck(reqData)) {
			$.ajax({
				url: "${APP_PATH }/MlfrontUser/register",
				type: 'POST',
				data: JSON.stringify(reqData),
				dataType: 'json',
				contentType: 'application/json',
				success: function (data) {
					// console.log(data);
					var resData = data.extend;
					if (resData.registerYes === 0) {
						alert(resData.resMsg)
					}

					if (resData.registerYes === 1) {
						alert(resData.resMsg)
						window.location.href = "${APP_PATH}/index/isMobileOrPc";
					}
				}
			})
		} else {
			alert('email or password format incorrect!');
		}
	})

	function inputCheck(data) {
		var flag = true;
		for (var key in data) {
			if (key === 'userEmail') {
				var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
				if (!pattern.test(data[key])) {
					flag = !flag;
					break;
				}
			}

			if (key === 'userPassword') {
				if (data[key].trim().length < 6) {
					flag = !flag;
					break;
				}
			}
		}

		return flag;
	}
</script>


</html>