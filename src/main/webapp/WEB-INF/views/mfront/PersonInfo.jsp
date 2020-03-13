<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Personnal</title>
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
	<link rel="stylesheet" href="${APP_PATH }/static/m/css/wapindex.css">
	 <div class="main person-info">
		<div class="return_prev"><a href="javascript:history.go(-1)"><span>返回</span></a></div>
		<div class="list_info clearfix">
			
		</div>	
		<div class="tanceng_box">
			<span class="gb_tang">x</span>
			<input class="userid" name="userId" type="hidden" />
			<div class="boxedit nameli_box">
				
				<label for="userFirstname" class="span_tip">First Name :</label>
				<input type="text" id="" value="" class="textinpt userFirstname" placeholder="Please add" />
				<label for="userLastname" class="span_tip">Last  Name :</label>
				<input type="text" id="" value="" class="textinpt userLastname" placeholder="Please add" />
				<input type="submit" id="" name="" class="sub_ipn" data-flag="0" />
			</div>
			<div class="boxedit mailli_box">
				<label for="userEmail" class="span_tip">Change Mail :</label>
				<input type="text" id="" value="" class="textinpt userEmail" />
				<input type="submit" id="" name="" class="sub_ipn" data-flag="0" />
			</div>
			<div class="boxedit phoneli_box">
				<label for="userTelephone" class="span_tip">Please add Telphone :</label>
				<input type="text" id="" value="" class="textinpt userTelephone" placeholder="Please add" />
				<input type="submit" id="" name="" class="sub_ipn" data-flag="0" />
			</div>
			<div class="boxedit passwordli_box">
				<label for="userPassword" class="span_tip">Change Password :</label>
				<input type="text" id="" value="" class="textinpt userPassword" />
				<input type="submit" id="" name="" class="sub_ipn" data-flag="0" />
			</div>
			<div class="boxedit passwordli_box">
				<label for="userPoint" class="span_tip">Please add UserPoint:</label>
				<input type="text" id="" value="" class="textinpt userPoint" placeholder="Please add" />
				<input type="submit" id="" name="" class="sub_ipn" data-flag="0" />
			</div>
			<div class="boxedit Addressli_box">
				<label for="address" class="span_tip">Please add Address :</label>
				<div class="box_newcountry">
					<div class="form-groupinfo form-groupcountry">
						<label for="addressCountry" class="form-label required">Country</label>
						<input type="text" id="" value="" class="textinpt addressCountry" id="country" placeholder="Please add" />
					</div>
					<!-- stateprovinceName -->
					<div class="form-groupinfo form-group_select selectActive">
						<label for="addressProvince" class="form-label required">State/Province</label>
						<input type="text" id="" value="" class="textinpt addressProvince" id="province" placeholder="Please add" />
					</div>
					<!-- city -->
					<div class="form-groupinfo form-group2">
						<label for="addressCity" class="form-label required">City</label>
						<input type="text" name="addressCity" class="textinpt form-control city userAddressCity" placeholder="Please add" />
					</div>
					<!-- Zip/Postal code -->
					<div class="form-groupinfo">
						<label for="addressPost" class="form-label required">Zip/Postal code</label>
							<input type="text" name="addressPost" class="textinpt form-control code userAddressPostalcode" placeholder="Please add" />
					</div>
				</div>
				<input type="submit" id="" name="" class="sub_ipn" data-flag="0" />
			</div>
		</div>
	 </div>
	<jsp:include page="mfooter.jsp"></jsp:include>
</body>

<script>
	$(function(){
		$(".gb_tang").click(function(){
			$(".tanceng_box").hide()
		})
	})
	var tyu;
	initialData()
	function initialData() {
		$.ajax({
			url: "${APP_PATH }/MlfrontUser/getLoginUserDetail",
			type: 'POST',
			success: function (data) {
				// console.log(data);
				var resData = data.extend.mlfrontUserOne;
				if(resData){
					tianchong(list_info,resData);
				}
			}
		})
	}
   var list_info=$(".list_info");
	function tianchong(parent,data) {
		  var html = '';
		    html += '<ul class="clearfix">';
			var Firstname=data.userFirstname;
			var Lastname=data.userLastname;
			var Telephone= data.userTelephone;
			var AddressCity= data.userAddressCountry;
			var UserPoint= data.userPoint;
			if(Firstname==null||Lastname==null){
				html += '<li><span>Name</span><em>Please add</em></li>';
			}else{
				html += '<li><span>Name</span><em>'+data.userFirstname+' '+data.userLastname+'</em></li>';
			}
			html += '<li><span>E-mail</span><em>'+data.userEmail+'</em></li>';
			if(Telephone==null){
			html += '<li><span>Telephone</span><em>Please add</em></li>';	
			}else{
				html += '<li><span>Telphone</span><em>'+data.userTelephone+'</em></li>';
			}
			html += '<li><span>Password</span><em>'+data.userPassword+'</em></li>';
			html += '<li><span>UserPoint</span><em></em></li>';
			if(AddressCity==null){
				html += '<li><span>Address</span><em>Please add</em></li>';
			}else{
				html += '<li><span>Address</span><em>'+data.userAddressCountry+''+data.userAddressProvince+'</em></li>';
			}
		  html +=  '</ul>';
		$(".userid").val(data.userId);
		$("input.userEmail").val(data.userEmail ? data.userEmail : 'Please add');
		$("input.userPassword").val(data.userPassword ? data.userPassword : 'Please add');
		$("input.userTelephone").val(data.userTelephone ? data.userTelephone : '');
		$("input.addressCountry").val(data.userAddressCountry ? data.userAddressCountry : '');
		$("input.addressProvince").val(data.userAddressProvince ? data.userAddressProvince : '');
		$("input.userAddressCity").val(data.userAddressCity ? data.userAddressCity : '');
		$("input.userAddressStreetaddress").val(data.userAddressStreetaddress ? data.userAddressStreetaddress : '');
		$("input.userAddressPostalcode").val(data.userAddressPostalcode ? data.userAddressPostalcode : '');
		$("input.userFirstname").val(data.userFirstname ? data.userFirstname : '');
		$("input.userLastname").val(data.userLastname ? data.userLastname : '');
		$("input.userPoint").val(data.userPoint ? data.userPoint : '');
		 parent.html(html);
		 $(".list_info ul li").each(function(){
			 // getProvinceData($('#country').val());
			 $(this).on("click",function(){
				$(".tanceng_box").show();
				var index=$(this).index();
				 $(".tanceng_box div.boxedit").hide();
				$(".tanceng_box div.boxedit").eq(index) .show();
			})
		});
	}
	var editSave = $('.sub_ipn');
	editSave.on('click', function () {
		var reqData = {
			userId: parseInt($(".userid").val()),
			userEmail: $("input.userEmail").val() === "Please add" ? null : $("input.userEmail").val(),
			userPassword: $("input.userPassword").val() === "Please add" ? null : $("input.userPassword").val(),
			userTelephone: $("input.userTelephone").val() === "Please add" ? null : $("input.userTelephone").val(),
			userAddressCountry: $("input.addressCountry").val() === "Please add" ? null : $("input.addressCountry").val(),
			userAddressProvince: $("input.addressProvince").val() === "Please add" ? null : $("input.addressProvince").val(),
			userAddressCity: $("input.userAddressCity").val() === "Please add" ? null : $(".userAddressCity").val(),
			userAddressStreetaddress: $("input.userAddressStreetaddress").val() === "Please add" ? null : $(
				"input.userAddressStreetaddress").val(),
			userAddressPostalcode: $("input.userAddressPostalcode").val() === "Please add" ? null : $(
				"input.userAddressPostalcode").val(),
			userFirstname: $("input.userFirstname").val() === "Please add" ? null : $("input.userFirstname").val(),
			userLastname: $("input.userLastname").val() === "Please add" ? null : $("input.userLastname").val(),
			userPoint: $("input.userPoint").val() === "Please add" ? null : parseInt($("input.userPoint").val())
		}
		/*****/
		// console.table("*****************reqData")
		// console.table(reqData)
		// console.table("*****************reqData")
		// save
		$.ajax({
			url: "${APP_PATH }/MlfrontUser/update",
			type: 'POST',
			data: JSON.stringify(reqData),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				// console.log(data);
				if (data.code === 100) {
					console.log(data.extend.resMsg);
					var timer = null;
					timer = setInterval(function() {
						window.location.reload()
					}, 300);
				}
			}
		})
	
	})
	
</script>


</html>