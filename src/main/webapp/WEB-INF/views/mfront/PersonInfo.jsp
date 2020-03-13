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
						<!-- <div class="form-input">
							<select name="addressCountry" class="form-control" id="country" value="US">
								<option value="US" selected="selected">United States</option>
							</select>
						</div> -->
					</div>
					<!-- stateprovinceName -->
					<div class="form-groupinfo form-group_select selectActive">
						<label for="addressProvince" class="form-label required">State/Province</label>
						<input type="text" id="" value="" class="textinpt addressProvince" id="province" placeholder="Please add" />
						<!-- <div class="form-input">
							<select name="addressProvince" class="form-control" id="province">
								<option value="Alabama" selected="selected">Alabama</option>
							</select>
						</div> -->
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
	 


	<!-- main -->
<!-- 	<div class="main person-info">
		<div class="form-op"><span class="edit-save" data-flag="0">edit</span></div>
		<div class="form">
			<input class="userid" name="userId" type="hidden" />
			<div class="input-group">
				<label for="userEmail">e-mail</label>
				<div class="input userEmail"></div>
			</div>
			<div class="input-group">
				<label for="userPassword">password</label>
				<div class="input userPassword"></div>
			</div>
			<div class="input-group">
				<label for="userTelephone">telphone</label>
				<div class="input userTelephone"></div>
			</div>
			<div class="input-group">
				<label for="userFirstname">firstName</label>
				<div class="input userFirstname"></div>
			</div>
			<div class="input-group">
				<label for="userLastname">lastname</label>
				<div class="input userLastname"></div>
			</div>
			<div class="input-group">
				<label for="userAddressCountry">country</label>
				<div class="input userAddressCountry"></div>
			</div>
			<div class="input-group">
				<label for="userAddressProvince">province</label>
				<div class="input userAddressProvince"></div>
			</div>
			<div class="input-group">
				<label for="userAddressCity">city</label>
				<div class="input userAddressCity"></div>
			</div>
			<div class="input-group">
				<label for="userAddressStreetaddress">details address</label>
				<div class="input userAddressStreetaddress"></div>
			</div>
			<div class="input-group">
				<label for="userAddressPostalcode">post code</label>
				<div class="input userAddressPostalcode"></div>
			</div>
			<div class="input-group">
				<label for="userPoint">user point</label>
				<div class="input userPoint"></div>
			</div>
		</div>
	</div> -->

	<jsp:include page="mfooter.jsp"></jsp:include>
</body>

<script>
	$(function(){

		$(".gb_tang").click(function(){
			$(".tanceng_box").hide()
		})
		
		
	})
	
	/* 初始化请求这个接口
 ${APP_PATH }/MlfrontUser/getLoginUserDetail
 
 
 无参数，post请求
 
$('.btn.signout').on('click', function() {	
	console.log('*******')
	$.ajax({
		url: "${APP_PATH }/MlfrontUser/exit",
		type:'POST',
		success:function(data) {
			console.log(data);
			var resData = data.extend;
			
			if (resData.exitInt === 0) {
				alert(resData.resMsg)
				window.location.href="${APP_PATH }/MlfrontUser/toLoginRegisterPage";
			}
		}
	})
})

    private Integer userId;
	private String userEmail;
    private String userPassword;(明文展示就行)
    private String userTelephone;
    private String userAddressCountry;
    private String userAddressProvince;
    private String userAddressCity;
    private String userAddressStreetaddress;
    private String userAddressPostalcode;
    private String userFirstname;
    private String userLastname;
    // private String userLastonlinetime;
    private Integer userPoint;
    // private String userCouponidstr; .split(","),显示成数量s
    
点击编辑，修改完走

json格式，post请求

${APP_PATH }/MlfrontUser/update 
*/
	// get user info
	var tyu;
	initialData()
	function initialData() {
		$.ajax({
			url: "${APP_PATH }/MlfrontUser/getLoginUserDetail",
			type: 'POST',
			success: function (data) {
				console.log(data);
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
		// var dataprov = data.userAddressProvince ? data.userAddressProvince : '';
		// 	console.log(dataprov)
		// var jiecountry = data.userAddressCountry ? data.userAddressCountry : '';
		// $("#country").val();
		// $("#country").attr("data-name", jiecountry);
		// $("#country option:checked").attr("value", jiecountry);
		// $("#country option:checked").text(data.userAddressCountry ? data.userAddressCountry : '');
		// if (dataprov == "") {
		// 	$(".form-group_select").hide();
		// 	$(".form-groupcountry").css("width", "90%")
		// } else {
		// 	$(".form-group_select").addClass("selectActive")
		// 	 $(".selectActive #province").val();
		// 	$(".selectActive #province option:checked").val(dataprov);
		// 	$(".selectActive #province option:checked").text(dataprov);
		// 	$(".form-groupcountry").css("width", "90%");
		// 	$(".form-group_select").show();
		// }
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
		console.table("*****************reqData")
		console.table(reqData)
		console.table("*****************reqData")
		// save
		$.ajax({
			url: "${APP_PATH }/MlfrontUser/update",
			type: 'POST',
			data: JSON.stringify(reqData),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				console.log(data);
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


		// $('#country').on('focus', function(e) {
		// 	var targetEl = e.target,
		// 		defaultValue = $(targetEl).val();
		// 	if (targetEl.options.length < 2) {
		// 		var htmlStr = '',
		// 			countryList = [ {name:"Afghanistan", nickname:"AF"}, {name:"Åland Islands", nickname:"AX"}, {name:"Albania", nickname:"AL"}, {name:"Algeria", nickname:"DZ"}, {name:"American Samoa", nickname:"AS"}, {name:"Andorra", nickname:"AD"}, {name:"Angola", nickname:"AO"}, {name:"Anguilla", nickname:"AI"}, {name:"Antarctica", nickname:"AQ"}, {name:"Antigua and Barbuda", nickname:"AG"}, {name:"Argentina", nickname:"AR"}, {name:"Armenia", nickname:"AM"}, {name:"Aruba", nickname:"AW"}, {name:"Australia", nickname:"AU"}, {name:"Austria", nickname:"AT"}, {name:"Azerbaijan", nickname:"AZ"}, {name:"Bahamas", nickname:"BS"}, {name:"Bahrain", nickname:"BH"}, {name:"Bangladesh", nickname:"BD"}, {name:"Barbados", nickname:"BB"}, {name:"Belarus", nickname:"BY"}, {name:"Belgium", nickname:"BE"}, {name:"Belize", nickname:"BZ"}, {name:"Benin", nickname:"BJ"}, {name:"Bermuda", nickname:"BM"}, {name:"Bhutan", nickname:"BT"}, {name:"Bolivia", nickname:"BO"}, {name:"Bosnia and Herzegovina", nickname:"BA"}, {name:"Botswana", nickname:"BW"}, {name:"Bouvet Island", nickname:"BV"}, {name:"Brazil", nickname:"BR"}, {name:"British Indian Ocean Territory", nickname:"IO"}, {name:"British Virgin Islands", nickname:"VG"}, {name:"Brunei", nickname:"BN"}, {name:"Bulgaria", nickname:"BG"}, {name:"Burkina Faso", nickname:"BF"}, {name:"Burundi", nickname:"BI"}, {name:"Cambodia", nickname:"KH"}, {name:"Cameroon", nickname:"CM"}, {name:"Canada", nickname:"CA"}, {name:"Cape Verde", nickname:"CV"}, {name:"Cayman Islands", nickname:"KY"}, {name:"Central African Republic", nickname:"CF"}, {name:"Chad", nickname:"TD"}, {name:"Chile", nickname:"CL"}, {name:"China", nickname:"CN"}, {name:"Christmas Island", nickname:"CX"}, {name:"Cocos (Keeling) Islands", nickname:"CC"}, {name:"Colombia", nickname:"CO"}, {name:"Comoros", nickname:"KM"}, {name:"Congo - Brazzaville", nickname:"CG"}, {name:"Congo - Kinshasa", nickname:"CD"}, {name:"Cook Islands", nickname:"CK"}, {name:"Costa Rica", nickname:"CR"}, {name:"Côte d’Ivoire", nickname:"CI"}, {name:"Croatia", nickname:"HR"}, {name:"Cuba", nickname:"CU"}, {name:"Cyprus", nickname:"CY"}, {name:"Czech Republic", nickname:"CZ"}, {name:"Denmark", nickname:"DK"}, {name:"Djibouti", nickname:"DJ"}, {name:"Dominica", nickname:"DM"}, {name:"Dominican Republic", nickname:"DO"}, {name:"Ecuador", nickname:"EC"}, {name:"Egypt", nickname:"EG"}, {name:"El Salvador", nickname:"SV"}, {name:"Equatorial Guinea", nickname:"GQ"}, {name:"Eritrea", nickname:"ER"}, {name:"Estonia", nickname:"EE"}, {name:"Ethiopia", nickname:"ET"}, {name:"Falkland Islands", nickname:"FK"}, {name:"Faroe Islands", nickname:"FO"}, {name:"Fiji", nickname:"FJ"}, {name:"Finland", nickname:"FI"}, {name:"France", nickname:"FR"}, {name:"French Guiana", nickname:"GF"}, {name:"French Polynesia", nickname:"PF"}, {name:"French Southern Territories", nickname:"TF"}, {name:"Gabon", nickname:"GA"}, {name:"Gambia", nickname:"GM"}, {name:"Georgia", nickname:"GE"}, {name:"Germany", nickname:"DE"}, {name:"Ghana", nickname:"GH"}, {name:"Gibraltar", nickname:"GI"}, {name:"Greece", nickname:"GR"}, {name:"Greenland", nickname:"GL"}, {name:"Grenada", nickname:"GD"}, {name:"Guadeloupe", nickname:"GP"}, {name:"Guam", nickname:"GU"}, {name:"Guatemala", nickname:"GT"}, {name:"Guernsey", nickname:"GG"}, {name:"Guinea", nickname:"GN"}, {name:"Guinea-Bissau", nickname:"GW"}, {name:"Guyana", nickname:"GY"}, {name:"Haiti", nickname:"HT"}, {name:"Heard &amp; McDonald Islands", nickname:"HM"}, {name:"Honduras", nickname:"HN"}, {name:"Hong Kong SAR China", nickname:"HK"}, {name:"Hungary", nickname:"HU"}, {name:"Iceland", nickname:"IS"}, {name:"India", nickname:"IN"}, {name:"Indonesia", nickname:"ID"}, {name:"Iran", nickname:"IR"}, {name:"Iraq", nickname:"IQ"}, {name:"Ireland", nickname:"IE"}, {name:"Isle of Man", nickname:"IM"}, {name:"Israel", nickname:"IL"}, {name:"Italy", nickname:"IT"}, {name:"Jamaica", nickname:"JM"}, {name:"Japan", nickname:"JP"}, {name:"Jersey", nickname:"JE"}, {name:"Jordan", nickname:"JO"}, {name:"Kazakhstan", nickname:"KZ"}, {name:"Kenya", nickname:"KE"}, {name:"Kiribati", nickname:"KI"}, {name:"Kuwait", nickname:"KW"}, {name:"Kyrgyzstan", nickname:"KG"}, {name:"Laos", nickname:"LA"}, {name:"Latvia", nickname:"LV"}, {name:"Lebanon", nickname:"LB"}, {name:"Lesotho", nickname:"LS"}, {name:"Liberia", nickname:"LR"}, {name:"Libya", nickname:"LY"}, {name:"Liechtenstein", nickname:"LI"}, {name:"Lithuania", nickname:"LT"}, {name:"Luxembourg", nickname:"LU"}, {name:"Macau SAR China", nickname:"MO"}, {name:"Macedonia", nickname:"MK"}, {name:"Madagascar", nickname:"MG"}, {name:"Malawi", nickname:"MW"}, {name:"Malaysia", nickname:"MY"}, {name:"Maldives", nickname:"MV"}, {name:"Mali", nickname:"ML"}, {name:"Malta", nickname:"MT"}, {name:"Marshall Islands", nickname:"MH"}, {name:"Martinique", nickname:"MQ"}, {name:"Mauritania", nickname:"MR"}, {name:"Mauritius", nickname:"MU"}, {name:"Mayotte", nickname:"YT"}, {name:"Mexico", nickname:"MX"}, {name:"Micronesia", nickname:"FM"}, {name:"Moldova", nickname:"MD"}, {name:"Monaco", nickname:"MC"}, {name:"Mongolia", nickname:"MN"}, {name:"Montenegro", nickname:"ME"}, {name:"Montserrat", nickname:"MS"}, {name:"Morocco", nickname:"MA"}, {name:"Mozambique", nickname:"MZ"}, {name:"Myanmar (Burma)", nickname:"MM"}, {name:"Namibia", nickname:"NA"}, {name:"Nauru", nickname:"NR"}, {name:"Nepal", nickname:"NP"}, {name:"Netherlands", nickname:"NL"}, {name:"Netherlands Antilles", nickname:"AN"}, {name:"New Caledonia", nickname:"NC"}, {name:"New Zealand", nickname:"NZ"}, {name:"Nicaragua", nickname:"NI"}, {name:"Niger", nickname:"NE"}, {name:"Nigeria", nickname:"NG"}, {name:"Niue", nickname:"NU"}, {name:"Norfolk Island", nickname:"NF"}, {name:"Northern Mariana Islands", nickname:"MP"}, {name:"North Korea", nickname:"KP"}, {name:"Norway", nickname:"NO"}, {name:"Oman", nickname:"OM"}, {name:"Pakistan", nickname:"PK"}, {name:"Palau", nickname:"PW"}, {name:"Palestinian Territories", nickname:"PS"}, {name:"Panama", nickname:"PA"}, {name:"Papua New Guinea", nickname:"PG"}, {name:"Paraguay", nickname:"PY"}, {name:"Peru", nickname:"PE"}, {name:"Philippines", nickname:"PH"}, {name:"Pitcairn Islands", nickname:"PN"}, {name:"Poland", nickname:"PL"}, {name:"Portugal", nickname:"PT"}, {name:"Puerto Rico", nickname:"PR"}, {name:"Qatar", nickname:"QA"}, {name:"Réunion", nickname:"RE"}, {name:"Romania", nickname:"RO"}, {name:"Russia", nickname:"RU"}, {name:"Rwanda", nickname:"RW"}, {name:"Saint Barthélemy", nickname:"BL"}, {name:"Saint Helena", nickname:"SH"}, {name:"Saint Kitts and Nevis", nickname:"KN"}, {name:"Saint Lucia", nickname:"LC"}, {name:"Saint Martin", nickname:"MF"}, {name:"Saint Pierre and Miquelon", nickname:"PM"}, {name:"Samoa", nickname:"WS"}, {name:"San Marino", nickname:"SM"}, {name:"São Tomé and Príncipe", nickname:"ST"}, {name:"Saudi Arabia", nickname:"SA"}, {name:"Senegal", nickname:"SN"}, {name:"Serbia", nickname:"RS"}, {name:"Seychelles", nickname:"SC"}, {name:"Sierra Leone", nickname:"SL"}, {name:"Singapore", nickname:"SG"}, {name:"Slovakia", nickname:"SK"}, {name:"Slovenia", nickname:"SI"}, {name:"Solomon Islands", nickname:"SB"}, {name:"Somalia", nickname:"SO"}, {name:"South Africa", nickname:"ZA"}, {name:"South Georgia &amp; South Sandwich Islands", nickname:"GS"}, {name:"South Korea", nickname:"KR"}, {name:"Spain", nickname:"ES"}, {name:"Sri Lanka", nickname:"LK"}, {name:"St. Vincent &amp; Grenadines", nickname:"VC"}, {name:"Sudan", nickname:"SD"}, {name:"Suriname", nickname:"SR"}, {name:"Svalbard and Jan Mayen", nickname:"SJ"}, {name:"Swaziland", nickname:"SZ"}, {name:"Sweden", nickname:"SE"}, {name:"Switzerland", nickname:"CH"}, {name:"Syria", nickname:"SY"}, {name:"Taiwan", nickname:"TW"}, {name:"Tajikistan", nickname:"TJ"}, {name:"Tanzania", nickname:"TZ"}, {name:"Thailand", nickname:"TH"}, {name:"Timor-Leste", nickname:"TL"}, {name:"Togo", nickname:"TG"}, {name:"Tokelau", nickname:"TK"}, {name:"Tonga", nickname:"TO"}, {name:"Trinidad and Tobago", nickname:"TT"}, {name:"Tunisia", nickname:"TN"}, {name:"Turkey", nickname:"TR"}, {name:"Turkmenistan", nickname:"TM"}, {name:"Turks and Caicos Islands", nickname:"TC"}, {name:"Tuvalu", nickname:"TV"}, {name:"Uganda", nickname:"UG"}, {name:"Ukraine", nickname:"UA"}, {name:"United Arab Emirates", nickname:"AE"}, {name:"United Kingdom", nickname:"GB"}, {name:"United States", nickname:"US"}, {name:"Uruguay", nickname:"UY"}, {name:"U.S. Outlying Islands", nickname:"UM"}, {name:"U.S. Virgin Islands", nickname:"VI"}, {name:"Uzbekistan", nickname:"UZ"}, {name:"Vanuatu", nickname:"VU"}, {name:"Vatican City", nickname:"VA"}, {name:"Venezuela", nickname:"VE"}, {name:"Vietnam", nickname:"VN"}, {name:"Wallis and Futuna", nickname:"WF"}, {name:"Western Sahara", nickname:"EH"}, {name:"Yemen", nickname:"YE"}, {name:"Zambia", nickname:"ZM"}, {name:"Zimbabwe", nickname:"ZW"} ];
		// 		for (var i = 0, len = countryList.length; i < len; i++) {
		// 			htmlStr += '<option value="' + countryList[i].nickname + '"'+ (countryList[i].nickname == defaultValue ? "selected" : "") +'>' + countryList[i].name + '</option>';
		// 		}
		// 		$(targetEl).html(htmlStr);
		// 	}
		// });
		// $('#province').on('focus', function() {
			
			
			
		// });
		// $("#country").on("change", function () {
		// 	var dataname = $(this).val();
		// 	getProvinceData(dataname);
		// });
		
	// function getProvinceData(dataname) {
	// 	$.ajax({
	// 		url: '${APP_PATH}/MlfrontAddress/getAreafreightMoney',
	// 		data: JSON.stringify({ "addressCountry": dataname }),
	// 		async: false,
	// 		type: 'post',
	// 		dataType: 'json',
	// 		contentType: 'application/json',
	// 		success: function (data) {
	// 			// console.log(data)
	// 			var mlPaypalStateprovinceList = data && data.extend.mlPaypalStateprovinceList;
	// 			tyu=mlPaypalStateprovinceList;
	// 			// console.log(mlPaypalStateprovinceList)
	// 			if (mlPaypalStateprovinceList && mlPaypalStateprovinceList.length > 0) {
	// 				renderProvince($('.selectActive #province'), mlPaypalStateprovinceList);
	// 				$(".form-group_select").show();
	// 				$(".form-group_select").addClass("selectActive")
	// 				$(".form-groupcountry").css("width", "90%")
	// 			} else {
	// 				$(".form-group_select").removeClass("selectActive");
	// 				$(".form-groupcountry").css("width", "90%")
	// 				$(".form-group_select").remove();
	// 			}
	// 		}
	// 	});
	// }
	
	// function renderProvince(el, data) {
	// 	var htmlStr = '',
	// 		defaultValue = $(el).val();
	// 	for (var i = 0, len = data.length; i < len; i += 1) {
	// 		htmlStr += '<option value="' + data[i].stateprovinceName + '"'+ (defaultValue == data[i].stateprovinceName ? "selected" : "") +'>' + data[i].stateprovinceName + '</option>';
	// 	}
	
	// 	el.html(htmlStr);
	// }
	
	
</script>


</html>