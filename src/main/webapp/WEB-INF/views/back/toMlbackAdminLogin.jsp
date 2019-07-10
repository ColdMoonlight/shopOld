<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<!-- web路径：
			不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
			以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
			http://localhost:3306/crud
	 -->
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<style>
		html,
		body {
			position: relative;
			width: 100%;
			height: 100%;
			padding: 0;
			margin: 0;
			background-color: white;
		}

		.login-box {
			position: absolute;
			top: 50%;
			left: 50%;
			min-width: 360px;
			transform: translate(-50%, -50%);
			-moz-transform: translate(-50%, -50%);
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			padding: 46px 42px 20px 0;
			background-color: #afd1f3;
			border-radius: 4px;
		}

		.login-box .form-group {
			position: relative;
			padding-bottom: 12px;
		}

		.info {
			position: absolute;
			left: 0;
			bottom: -30px;
			display: none;
			padding-left: 20px;
			font-size: 12px;
			color: #ff0000;
		}
	</style>
</head>

<body>
	<div class="col-sm-4 login-box">
		<form class="form-horizontal">
			<!-- username -->
			<div class="form-group">
				<label for="username" class="col-sm-3 control-label">用户名:</label>
				<div class="col-sm-9">
					<input class="form-control" id="username" name="username" placeholder="请输入用户名"></input>
					<p class="info info-username">用户名格式不正确，请检查后重新输入！</p>
				</div>
			</div>
			<!-- password -->
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">密码:</label>
				<div class="col-sm-9">
					<input class="form-control" id="password" type="password" name="password" placeholder="请输入密码"></input>
					<p class="info info-password">密码格式不正确，请检查后重新输入！</p>
				</div>
			</div>
			<!-- submit -->
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button id="submit" class="btn btn-primary col-sm-3">登录</button>
				</div>
			</div>
		</form>
	</div>

	<script>
		// submit
		$(function () {
			function checkUsername(data) {
				return !(new RegExp('[A-Za-z0-9]{5,8}', 'ig')).test(data)
			}

			function checkPassword(data) {
				return !(new RegExp('[A-Za-z0-9]{8,18}', 'ig')).test(data)
			}

			function checkLogin(data) {
				// check username
				if (checkUsername(data.sysName)) {
					$('.info-username').css('display', 'block')
					return false
				}
				// check password
				if (checkPassword(data.sysPassword)) {
					$('.info-password').css('display', 'block')
					return false
				}
				return true
			}

			// clear info about info-username & info-password
			$('input').on('keyup', function (e) {
				e.preventDefault();
				$(this).siblings('.info').css('display', 'none')
			});

			// login
			$('#submit').on('click', function (e) {
				e.preventDefault();
				var username = $('#username').val().trim(),
					password = $('#password').val().trim();

				var formData = {
					adminAccname: username,
					adminPassword: password
				};

				if (checkLogin(formData)) {
					$.ajax({
						method: 'POST',
						contentType: "application/json;charset=utf-8",
						url: '/ShopTemplate/MlbackAdmin/toCheakAdminUser',
						data: JSON.stringify(formData),
						dataType: 'json',
						success: function (res) {
							console.log(res);
							if (res.code === 100) {
								//window.location.href="/ShareNum/taskfrom/toProPage";
								window.location.href = "/ShopTemplate/HomePage/toHomePage";
							} else {
								alert(res.extend.resMsg)
								//window.location.href="/ShareNum/taskfrom/toProPage";
							}
						},
						error: function (message) {
							alert('提交数据失败');
						}
					})
				}
			})
		})
	</script>
</body>

</html>