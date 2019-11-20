<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Checkout</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
	<meta name="viewport"	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, viewport-fit=cover">
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
	<!-- End Facebook Pixel Code -->
	
	<script>
  		fbq('track', 'ViewContent');
	</script>
	<!-- Facebook Pixel Code end -->
</head>

<body>
	<jsp:include page="pcheader.jsp"></jsp:include>
<!-- main -->
	<div class="main">
		<div class="container pc_cheakout clearfix">
		<!-- purechase step -->
		<div class="cart-title">
		   <img class="purechase-step" src="${APP_PATH }/static/pc/img/sep2.jpg">
	    </div>
		<!-- ordrer list  -->
		<div class="order-list clearfix">
			<div class="order-item clearfix">
					<!-- add/show address -->
				<div class="left_list_check">
				<!-- <div class="address bd-t"></div> -->
				<div class="rece">
			    	<b>Receiving information</b>	
				</div>
				<div class="address-box">
					<div class="win-box-content">
						<form action="">
							<!-- address id -->
							<input type="hidden" class="address-id" name="addressId" />
							<!-- first name -->
							<div class="form-group">
								<label for="addressUserfirstname" class="form-label required">First Name</label>
								<div class="form-input">
									<input type="text" name="addressUserfirstname" class="form-control firstname">
								</div>
							</div>
							<!-- last name -->
							<div class="form-group">
								<label for="addressUserlastname" class="form-label required">Last Name</label>
								<div class="form-input">
									<input type="text" name="addressUserlastname" class="form-control lastname">
								</div>
							</div>
							<!-- email address -->
							<div class="form-group">
								<label for="addressEmail" class="form-label required">Email Adress</label>
								<div class="form-input">
									<input type="text" placeholder="eg:@gmail.com,and so on" name="addressEmail" class="form-control email">
								</div>
							</div>
							<!-- telephone -->
							<div class="form-group">
								<label for="addressTelephone" class="form-label required ">Telephone</label>
								<div class="form-input">
									<input type="text" name="addressTelephone" class="form-control phone">
								</div>
							</div>
							<!-- address -->
							<div class="form-group" style="width: 100%">
								<label for="addressDetail" class="form-label required">Address</label>
								<span class="label-exp">Don't forget the apartment No.</span>
								<div class="form-input">
									<input type="text" name="addressDetail" placeholder="street address (Dont't forget the apartment)"
										class="form-control address addreNo">
								</div>
							</div>
							<!-- Zip/Postal code -->
							<div class="form-group">
								<label for="addressPost" class="form-label required">Zip/Postal code</label>
								<div class="form-input">
									<input type="text" name="addressPost" class="form-control code">
								</div>
							</div>
							<!-- city -->
							<div class="form-group">
								<label for="addressCity" class="form-label required">City</label>
								<div class="form-input">
									<input type="text" name="addressCity" class="form-control city">
								</div>
							</div>
							<!-- country -->
							<div class="form-group form-groupcountry">
								<label for="addressCountry" class="form-label required">Country</label>
								<div class="form-input">
								<select name="addressCountry" class="form-control" id="country">
									<option value="AF">
										Afghanistan
									</option>
									<option value="AX">
										Åland Islands
									</option>
									<option value="AL">
										Albania
									</option>
									<option value="DZ">
										Algeria
									</option>
									<option value="AS">
										American Samoa
									</option>
									<option value="AD">
										Andorra
									</option>
									<option value="AO">
										Angola
									</option>
									<option value="AI">
										Anguilla
									</option>
									<option value="AQ">
										Antarctica
									</option>
									<option value="AG">
										Antigua and Barbuda
									</option>
									<option value="AR">
										Argentina
									</option>
									<option value="AM">
										Armenia
									</option>
									<option value="AW">
										Aruba
									</option>
									<option value="AU">
										Australia
									</option>
									<option value="AT">
										Austria
									</option>
									<option value="AZ">
										Azerbaijan
									</option>
									<option value="BS">
										Bahamas
									</option>
									<option value="BH">
										Bahrain
									</option>
									<option value="BD">
										Bangladesh
									</option>
									<option value="BB">
										Barbados
									</option>
									<option value="BY">
										Belarus
									</option>
									<option value="BE">
										Belgium
									</option>
									<option value="BZ">
										Belize
									</option>
									<option value="BJ">
										Benin
									</option>
									<option value="BM">
										Bermuda
									</option>
									<option value="BT">
										Bhutan
									</option>
									<option value="BO">
										Bolivia
									</option>
									<option value="BA">
										Bosnia and Herzegovina
									</option>
									<option value="BW">
										Botswana
									</option>
									<option value="BV">
										Bouvet Island
									</option>
									<option value="BR">
										Brazil
									</option>
									<option value="IO">
										British Indian Ocean Territory
									</option>
									<option value="VG">
										British Virgin Islands
									</option>
									<option value="BN">
										Brunei
									</option>
									<option value="BG">
										Bulgaria
									</option>
									<option value="BF">
										Burkina Faso
									</option>
									<option value="BI">
										Burundi
									</option>
									<option value="KH">
										Cambodia
									</option>
									<option value="CM">
										Cameroon
									</option>
									<option value="CA">
										Canada
									</option>
									<option value="CV">
										Cape Verde
									</option>
									<option value="KY">
										Cayman Islands
									</option>
									<option value="CF">
										Central African Republic
									</option>
									<option value="TD">
										Chad
									</option>
									<option value="CL">
										Chile
									</option>
									<option value="CN">
										China
									</option>
									<option value="CX">
										Christmas Island
									</option>
									<option value="CC">
										Cocos (Keeling) Islands
									</option>
									<option value="CO">
										Colombia
									</option>
									<option value="KM">
										Comoros
									</option>
									<option value="CG">
										Congo - Brazzaville
									</option>
									<option value="CD">
										Congo - Kinshasa
									</option>
									<option value="CK">
										Cook Islands
									</option>
									<option value="CR">
										Costa Rica
									</option>
									<option value="CI">
										Côte d’Ivoire
									</option>
									<option value="HR">
										Croatia
									</option>
									<option value="CU">
										Cuba
									</option>
									<option value="CY">
										Cyprus
									</option>
									<option value="CZ">
										Czech Republic
									</option>
									<option value="DK">
										Denmark
									</option>
									<option value="DJ">
										Djibouti
									</option>
									<option value="DM">
										Dominica
									</option>
									<option value="DO">
										Dominican Republic
									</option>
									<option value="EC">
										Ecuador
									</option>
									<option value="EG">
										Egypt
									</option>
									<option value="SV">
										El Salvador
									</option>
									<option value="GQ">
										Equatorial Guinea
									</option>
									<option value="ER">
										Eritrea
									</option>
									<option value="EE">
										Estonia
									</option>
									<option value="ET">
										Ethiopia
									</option>
									<option value="FK">
										Falkland Islands
									</option>
									<option value="FO">
										Faroe Islands
									</option>
									<option value="FJ">
										Fiji
									</option>
									<option value="FI">
										Finland
									</option>
									<option value="FR">
										France
									</option>
									<option value="GF">
										French Guiana
									</option>
									<option value="PF">
										French Polynesia
									</option>
									<option value="TF">
										French Southern Territories
									</option>
									<option value="GA">
										Gabon
									</option>
									<option value="GM">
										Gambia
									</option>
									<option value="GE">
										Georgia
									</option>
									<option value="DE">
										Germany
									</option>
									<option value="GH">
										Ghana
									</option>
									<option value="GI">
										Gibraltar
									</option>
									<option value="GR">
										Greece
									</option>
									<option value="GL">
										Greenland
									</option>
									<option value="GD">
										Grenada
									</option>
									<option value="GP">
										Guadeloupe
									</option>
									<option value="GU">
										Guam
									</option>
									<option value="GT">
										Guatemala
									</option>
									<option value="GG">
										Guernsey
									</option>
									<option value="GN">
										Guinea
									</option>
									<option value="GW">
										Guinea-Bissau
									</option>
									<option value="GY">
										Guyana
									</option>
									<option value="HT">
										Haiti
									</option>
									<option value="HM">
										Heard &amp; McDonald Islands
									</option>
									<option value="HN">
										Honduras
									</option>
									<option value="HK">
										Hong Kong SAR China
									</option>
									<option value="HU">
										Hungary
									</option>
									<option value="IS">
										Iceland
									</option>
									<option value="IN">
										India
									</option>
									<option value="ID">
										Indonesia
									</option>
									<option value="IR">
										Iran
									</option>
									<option value="IQ">
										Iraq
									</option>
									<option value="IE">
										Ireland
									</option>
									<option value="IM">
										Isle of Man
									</option>
									<option value="IL">
										Israel
									</option>
									<option value="IT">
										Italy
									</option>
									<option value="JM">
										Jamaica
									</option>
									<option value="JP">
										Japan
									</option>
									<option value="JE">
										Jersey
									</option>
									<option value="JO">
										Jordan
									</option>
									<option value="KZ">
										Kazakhstan
									</option>
									<option value="KE">
										Kenya
									</option>
									<option value="KI">
										Kiribati
									</option>
									<option value="KW">
										Kuwait
									</option>
									<option value="KG">
										Kyrgyzstan
									</option>
									<option value="LA">
										Laos
									</option>
									<option value="LV">
										Latvia
									</option>
									<option value="LB">
										Lebanon
									</option>
									<option value="LS">
										Lesotho
									</option>
									<option value="LR">
										Liberia
									</option>
									<option value="LY">
										Libya
									</option>
									<option value="LI">
										Liechtenstein
									</option>
									<option value="LT">
										Lithuania
									</option>
									<option value="LU">
										Luxembourg
									</option>
									<option value="MO">
										Macau SAR China
									</option>
									<option value="MK">
										Macedonia
									</option>
									<option value="MG">
										Madagascar
									</option>
									<option value="MW">
										Malawi
									</option>
									<option value="MY">
										Malaysia
									</option>
									<option value="MV">
										Maldives
									</option>
									<option value="ML">
										Mali
									</option>
									<option value="MT">
										Malta
									</option>
									<option value="MH">
										Marshall Islands
									</option>
									<option value="MQ">
										Martinique
									</option>
									<option value="MR">
										Mauritania
									</option>
									<option value="MU">
										Mauritius
									</option>
									<option value="YT">
										Mayotte
									</option>
									<option value="MX">
										Mexico
									</option>
									<option value="FM">
										Micronesia
									</option>
									<option value="MD">
										Moldova
									</option>
									<option value="MC">
										Monaco
									</option>
									<option value="MN">
										Mongolia
									</option>
									<option value="ME">
										Montenegro
									</option>
									<option value="MS">
										Montserrat
									</option>
									<option value="MA">
										Morocco
									</option>
									<option value="MZ">
										Mozambique
									</option>
									<option value="MM">
										Myanmar (Burma)
									</option>
									<option value="NA">
										Namibia
									</option>
									<option value="NR">
										Nauru
									</option>
									<option value="NP">
										Nepal
									</option>
									<option value="NL">
										Netherlands
									</option>
									<option value="AN">
										Netherlands Antilles
									</option>
									<option value="NC">
										New Caledonia
									</option>
									<option value="NZ">
										New Zealand
									</option>
									<option value="NI">
										Nicaragua
									</option>
									<option value="NE">
										Niger
									</option>
									<option value="NG">
										Nigeria
									</option>
									<option value="NU">
										Niue
									</option>
									<option value="NF">
										Norfolk Island
									</option>
									<option value="MP">
										Northern Mariana Islands
									</option>
									<option value="KP">
										North Korea
									</option>
									<option value="NO">
										Norway
									</option>
									<option value="OM">
										Oman
									</option>
									<option value="PK">
										Pakistan
									</option>
									<option value="PW">
										Palau
									</option>
									<option value="PS">
										Palestinian Territories
									</option>
									<option value="PA">
										Panama
									</option>
									<option value="PG">
										Papua New Guinea
									</option>
									<option value="PY">
										Paraguay
									</option>
									<option value="PE">
										Peru
									</option>
									<option value="PH">
										Philippines
									</option>
									<option value="PN">
										Pitcairn Islands
									</option>
									<option value="PL">
										Poland
									</option>
									<option value="PT">
										Portugal
									</option>
									<option value="PR">
										Puerto Rico
									</option>
									<option value="QA">
										Qatar
									</option>
									<option value="RE">
										Réunion
									</option>
									<option value="RO">
										Romania
									</option>
									<option value="RU">
										Russia
									</option>
									<option value="RW">
										Rwanda
									</option>
									<option value="BL">
										Saint Barthélemy
									</option>
									<option value="SH">
										Saint Helena
									</option>
									<option value="KN">
										Saint Kitts and Nevis
									</option>
									<option value="LC">
										Saint Lucia
									</option>
									<option value="MF">
										Saint Martin
									</option>
									<option value="PM">
										Saint Pierre and Miquelon
									</option>
									<option value="WS">
										Samoa
									</option>
									<option value="SM">
										San Marino
									</option>
									<option value="ST">
										São Tomé and Príncipe
									</option>
									<option value="SA">
										Saudi Arabia
									</option>
									<option value="SN">
										Senegal
									</option>
									<option value="RS">
										Serbia
									</option>
									<option value="SC">
										Seychelles
									</option>
									<option value="SL">
										Sierra Leone
									</option>
									<option value="SG">
										Singapore
									</option>
									<option value="SK">
										Slovakia
									</option>
									<option value="SI">
										Slovenia
									</option>
									<option value="SB">
										Solomon Islands
									</option>
									<option value="SO">
										Somalia
									</option>
									<option value="ZA">
										South Africa
									</option>
									<option value="GS">
										South Georgia &amp; South Sandwich Islands
									</option>
									<option value="KR">
										South Korea
									</option>
									<option value="ES">
										Spain
									</option>
									<option value="LK">
										Sri Lanka
									</option>
									<option value="VC">
										St. Vincent &amp; Grenadines
									</option>
									<option value="SD">
										Sudan
									</option>
									<option value="SR">
										Suriname
									</option>
									<option value="SJ">
										Svalbard and Jan Mayen
									</option>
									<option value="SZ">
										Swaziland
									</option>
									<option value="SE">
										Sweden
									</option>
									<option value="CH">
										Switzerland
									</option>
									<option value="SY">
										Syria
									</option>
									<option value="TW">
										Taiwan
									</option>
									<option value="TJ">
										Tajikistan
									</option>
									<option value="TZ">
										Tanzania
									</option>
									<option value="TH">
										Thailand
									</option>
									<option value="TL">
										Timor-Leste
									</option>
									<option value="TG">
										Togo
									</option>
									<option value="TK">
										Tokelau
									</option>
									<option value="TO">
										Tonga
									</option>
									<option value="TT">
										Trinidad and Tobago
									</option>
									<option value="TN">
										Tunisia
									</option>
									<option value="TR">
										Turkey
									</option>
									<option value="TM">
										Turkmenistan
									</option>
									<option value="TC">
										Turks and Caicos Islands
									</option>
									<option value="TV">
										Tuvalu
									</option>
									<option value="UG">
										Uganda
									</option>
									<option value="UA">
										Ukraine
									</option>
									<option value="AE">
										United Arab Emirates
									</option>
									<option value="GB">
										United Kingdom
									</option>
									<option value="US" selected="selected">
										United States
									</option>
									<option value="UY">
										Uruguay
									</option>
									<option value="UM">
										U.S. Outlying Islands
									</option>
									<option value="VI">
										U.S. Virgin Islands
									</option>
									<option value="UZ">
										Uzbekistan
									</option>
									<option value="VU">
										Vanuatu
									</option>
									<option value="VA">
										Vatican City
									</option>
									<option value="VE">
										Venezuela
									</option>
									<option value="VN">
										Vietnam
									</option>
									<option value="WF">
										Wallis and Futuna
									</option>
									<option value="EH">
										Western Sahara
									</option>
									<option value="YE">
										Yemen
									</option>
									<option value="ZM">
										Zambia
									</option>
									<option value="ZW">
										Zimbabwe
									</option>
								</select>
								</div>
							</div>
							<!-- stateprovinceName -->
							<div class="form-group form-group_select selectActive" style="display: none;">
								<label for="addressProvince" class="form-label required">State/Province</label>
								<div class="form-input">
									<select name="addressProvince" class="select-province form-control">
										<!-- <optgroup label="province"> </optgroup> -->
										<!-- <optgroup label="province" class="qwqw"> </optgroup> -->
									</select>
								</div>
							</div>
							<!-- city -->
							<div class="form-group form-group2">
								<label for="addressCity" class="form-label required">City</label>
								<div class="form-input">
									<input type="text" name="addressCity" class="form-control city">
								</div>
							</div>
							<!-- Zip/Postal code -->
							<div class="form-group">
								<label for="addressPost" class="form-label required">Zip/Postal code</label>
								<div class="form-input">
									<input type="text" name="addressPost" class="form-control code">
								</div>
							</div>
						</form>
					<div class="errortips"><span>A match of the shipping Address city,State and Postal Code failed.</span></div>
					</div>
					<div class="shipping">SHIPPING COST: <span>$0</span></div>
				</div>
<!-- 				<div class="win-box-title">
					<span class="save">  <b>save it</b> </span>
				</div> -->
				</div>
				<!--*********************-->
				<div class="right_checkout clearfix">
					<div class="list-group clearfix">
						<li class="list-group-item">
							<div class="group-title"><span>Choose Coupons</span> <!-- <span class="price-info"></span> --><!-- <iclass="icon right"></i> --></div>
							<div class="sale_copen">
								<p>Anuniversary Sale ！</h3> 
								<ul>
									<li><span>$3 off</span> upon order $3 with code：<b>HOT3</b></li>
									<li><span>$10 off </span>upon order $99 with code：<b>HOT10</b></li>
									<li><span>$15 off</span> upon order $180 with code：<b>HOT15</b></li>
								</ul>
							</div>
							<div class="group-details coupons"></div>
						</li>
						<li class="list-group-item">
							<div class="group-title"><span>PAYMENT METHOD</span> <!-- <i class="icon bottom"></i> --></div>
							<div class="group-details pay-method active">
								<div class="coupon-item">
									<input type="radio" name="payment" data-payid="0" checked onclick="selectPay(event)" class="checkbox active">
									<img src="${APP_PATH }/static/m/img/other/paypal.jpg">
								</div>
							</div>
						</li>
						
						<li class="list-group-item">
							<div class="group-title"><span>Buyer messages</span> <!-- <i class="icon right"></i> --></div>
							<div class="group-details customer-message">
								<textarea placeholder="Buyer message"></textarea>
							</div>
						</li>
					</div>
				</div>
				<div class="bottom_list_account">
					<div class="left_bt_list">
						<div class="order-title">
							<i class="icon bag"></i>
							<span class="text" id="newDate_zsh">*</span>
						</div>
						<div class="order-body">
							<div class="cart-list"> </div>
						</div>
						
					</div>
					<div class="right_allcont">
						<div class="order-cal bd-t">
							<div class="cal-price">
								<div class="cal-price-item c-prototal">
									<span class="cal-price-text">prototal:</span>
									<span class="cal-price-num"></span>
								</div>
								<div class="cal-price-item c-shipping">
									<span class="cal-price-text">shipping:</span>
									<span class="cal-price-num"></span>
								</div>
								<div class="cal-price-item c-coupon">
									<span class="cal-price-text">coupon:</span>
									<span class="cal-price-num">-$0</span>
								</div>
								<div class="cal-price-item c-subtotal">
									<span class="cal-price-text">subtotal:</span>
									<span class="cal-price-num"></span>
								</div>
							</div>
							<div class="btn btn-black place-order">Pay Securely Now</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
	<div class="loading">
		<div class="boxload"> <div class="loader-14"></div></div>
	</div>
	<jsp:include page="pcfooter.jsp"></jsp:include>
	<script type="text/javascript">
		var myDate = new Date();
		var year_zsh = myDate.getFullYear(); // 获取完整的年份(4位,1970-????)
		var month_zsh = myDate.getMonth() + 1; // 获取当前月份(0-11,0代表1月)
		var day_zsh = myDate.getDate(); // 获取当前日(1-31)
		var hours_zsh = myDate.getHours(); // 获取当前小时数(0-23)
		var minutes_zsh = myDate.getMinutes(); // 获取当前分钟数(0-59)
		var seconds_zsh = myDate.getSeconds(); // 获取当前秒数(0-59)
		if (seconds_zsh < 10) {
			seconds_zsh = "0" + seconds_zsh;
		}
		var newDate_zsh = year_zsh + "-" + month_zsh + "-" + day_zsh + " " + hours_zsh + ":" + minutes_zsh + ":" +
		seconds_zsh;
		$("#newDate_zsh").html(newDate_zsh);
	</script>
	<script>
	var totalPrice = 0;
	var resDataMoney = 0; // 邮费
	var totalPriceText = $('.total-price').find('.text');
	var subtotalPriceText = $('.cal-price-item.c-subtotal').find('.cal-price-num');
	var prototalPriceText = $('.cal-price-item.c-prototal').find('.cal-price-num');
	var shippingPriceText = $('.cal-price-item.c-shipping').find('.cal-price-num');
	var couponPriceText = $('.cal-price-item.c-coupon').find('.cal-price-num');
	var couponId;
	var couponCode = '';
	var addressId;
	var orderId;
	var orderItemArr = [];
	var productNumArr = [];
	var payplate = 0;
	var addressIdIntInt;
	var couponPriceOld =0;
	
	var tips;
	var PaypalErrorName = '${sessionScope.PaypalErrorName}';
	   tips=PaypalErrorName;
	   console.log(tips)
	if(tips==="VALIDATION_ERROR"){
		$(".errortips").show();
	}else{
		$(".errortips").hide();
	}
	$(".select-province,.form-group .city,.form-group .code").click(function(){
		$(".errortips").hide();
	})
	
	
	
	function datalocation (dataname){
		var dataname = $("#country").val();
		$.ajax({
			  url: '${APP_PATH}/MlfrontAddress/getAreafreightMoney',
			  data: JSON.stringify({
				"addressCountry": dataname
			  }),
			  type: 'post',
			  dataType: 'text',
			  contentType: 'application/json',
			  success: function (data) {
				// console.log(data)
				var resData = JSON.parse(data);
				var resareafreightMoney = resData.extend.areafreightMoney;
				var mlPaypalStateprovinceList = resData.extend.mlPaypalStateprovinceList;
				console.log(mlPaypalStateprovinceList)
				console.log(mlPaypalStateprovinceList.length)
				if(null != mlPaypalStateprovinceList && "" != mlPaypalStateprovinceList){
					renderCondition($('.select-province'), mlPaypalStateprovinceList)
					$(".form-group_select").show();
					$(".form-groupcountry").css("width","50%")
				  } else {
				   $(".form-group_select").hide();
				   $(".form-groupcountry").css("width","100%")
				  }	
				// console.log(resareafreightMoney)/***sdfsdfsdf*/
				// console.log("resareafreightMoney:"+resareafreightMoney)
				// $('.shipping').find('span').text(' of $' + resareafreightMoney+'w1');
				// shippingPriceText.text('$' + resareafreightMoney)
				couponPriceText.text('-$' + 0);
				totalPrice = (parseFloat(totalPrice) - resDataMoney).toFixed(2);
				resDataMoney = resareafreightMoney;
				totalPrice = (parseFloat(totalPrice) + resDataMoney).toFixed(2);
				subtotalPriceText.text('$' + totalPrice);
			  }
			});
	}
       var dataname="US";
		datalocation (dataname)
	
	$("#country").bind("change",function(){
		var radio_zt =$(".coupons .coupon-item input[type='radio']");
		$(".coupons .coupon-item input[type=radio]").removeClass("active");
		   couponPriceText.text('-$' + 0);
		   $(".coed_inp").val("");
		   $(".without-data").text("Enter coupon code to get a discount!");
		 var dataname = $(this).val();
		 $.ajax({
			  url: '${APP_PATH}/MlfrontAddress/getAreafreightMoney',
			  data: JSON.stringify({
				"addressCountry": dataname
			  }),
			  type: 'post',
			  dataType: 'text',
			  contentType: 'application/json',
			  success: function (data) {
				// console.log(data)
				var resData = JSON.parse(data);
				var resareafreightMoney = resData.extend.areafreightMoney;
				var mlPaypalStateprovinceList = resData.extend.mlPaypalStateprovinceList;
				console.log(mlPaypalStateprovinceList)
				console.log(mlPaypalStateprovinceList.length)
				if(null != mlPaypalStateprovinceList && "" != mlPaypalStateprovinceList){
					renderCondition($('.select-province'), mlPaypalStateprovinceList)
					$(".form-group_select").show();
					$(".form-group_select").addClass("selectActive")
					$(".form-groupcountry").css("width","50%")
				  } else {
				   $(".form-group_select").hide();
				    $(".form-group_select").removeClass("selectActive")
				   $(".form-groupcountry").css("width","100%")
				  }	
				
				$('.shipping').find('span').text(' of $' + resareafreightMoney);
				shippingPriceText.text('$' + resareafreightMoney)
				var prototalnum =$(".c-prototal .cal-price-num").text().slice(1)
				resDataMoney = resareafreightMoney;
				var  totalPriceselect = (parseFloat(prototalnum) + resDataMoney).toFixed(2);
				subtotalPriceText.text('$' + totalPriceselect);
				couponPriceold2 =0;
				couponPriceOld = 0;
				
			  }
			});
	});
	
		function renderAddressDetail(data) {
			// console.log(data)
		$("input.firstname").val(data.addressUserfirstname ? data.addressUserfirstname : '');
			$("input.lastname").val(data.addressUserlastname ? data.addressUserlastname : '');
			$("input.email").val(data.addressEmail ? data.addressEmail : '');
			$("input.phone").val(data.addressTelephone ? data.addressTelephone : '');
			$("input.address").val(data.addressDetail ? data.addressDetail : '');
			$("input.code").val(data.addressPost ? data.addressPost : '');
			$("input.city").val(data.addressCity ? data.addressCity : '');
			$("input.province").val(data.addressProvince ? data.addressProvince : '');
			// $("select option:checked").text(data.addressCountry ? data.addressCountry : ''); 
			$("#country").val(data.addressCountry ? data.addressCountry : ''); 
			
		}
	
		function renderAddressAdd(parent) {
			parent.html(
				'<div class="add-address address-trigger" style="display:none"><!--*<i class="icon plus"></i>*--><b> Add address consignee information</b></div>');
		}
		/* 初始化地址模块 */
		$.ajax({
			url: '${APP_PATH}/MlfrontAddress/getOneMlfrontAddressDetailByUinfo',
			type: 'post',
			success: function (data) {
				// console.log("MlfrontAddress/getOneMlfrontAddressDetailByUinfo")
				// console.log(data)
				var resDataAddress = data.extend.mlfrontAddressOne;
				var resDataUserType = data.extend.usertype;
				console.log(resDataAddress)/*rtrty*/
				console.log(resDataUserType)/*24234*/
				
				addressId = resDataAddress ? resDataAddress.addressId : null;
				resDataMoney = data.extend.areafreightMoney;
				console.log(resDataMoney)/*666*/
				var addressBox = $('.address');
				var couponBox = $('.coupons');
				console.log(data)
				renderCoupons(couponBox, resDataUserType);
				if (resDataAddress) {
					renderAddressDetail(resDataAddress);
					$('.address-id').val(resDataAddress.addressId);
					$('.shipping').find('span').text(' of $' + resDataMoney);
					shippingPriceText.text('$' + resDataMoney)
					$(".address").addClass("active")
				} else {
					// renderAddressAdd(addressBox);
					$('.shipping').find('span').text(' of $' + resDataMoney);
					shippingPriceText.text('$' + resDataMoney)
				}

				var subtotalText = (parseFloat(resDataMoney) + parseFloat(totalPrice)).toFixed(2);

				subtotalPriceText.text('$' + subtotalText);
				
			}
		});
		function renderCondition(parent, data, defaultHtml) {
			var html = defaultHtml || '';
			html += ''
			html =html+'<option value="" selected="selected">province</option>';
			for (var i = 0, len = data.length; i < len; i += 1) {
					html =  html + '<option value="' + data[i].stateprovinceName + '">' + data[i].stateprovinceName + '</option>';
			}
		    
			parent.html(html);
		}

		
		/* 所购商品列表 */
		function renderCartList(parent, data) {
			var html = '';
			// console.log(data)
			for (var i = 0, len = data.length; i < len; i += 1) {
				orderItemArr.push(data[i].orderitemId);
				productNumArr.push(data[i].orderitemPskuNumber);
				// html += '<div class="cart-item bd-b" data-orderitemid="' + data[i].orderitemId + '" onclick="toProductItem(' +data[i].orderitemPid + ')">' +
					html += '<div class="cart-item bd-b" data-orderitemid="' + data[i].orderitemId + '">' +
					'<img class="img" src="' + data[i].orderitemProductMainimgurl + '" alt="">' +
					'<div class="content">' +
					'<div class="text">' +
					'<div class="title">' + data[i].orderitemPname + '</div>' +
					'<div class="condition">';
				var skuIdNameArr = data[i].orderitemPskuIdnamestr.split(',');
				var skuNameArr = data[i].orderitemPskuNamestr.split(',');
				var skuMoneyArr = data[i].orderitemPskuMoneystr.split(',');
				var len2 = skuNameArr.length;
				for (var j = 0; j < len2; j += 1) {
					html += '<span class="c-item">' + skuIdNameArr[j] + ': ' + skuNameArr[j] + '</span>'
				}
				html += '</div>' +
					'</div>' +
					'<div class="num">' +
					'<span class="price">' + (getPrice(data[i].orderitemProductOriginalprice, skuMoneyArr, data[i]
						.orderitemProductAccoff).current) + '</span>' +
					'<span class="original">' + (getPrice(data[i].orderitemProductOriginalprice, skuMoneyArr, data[i]
						.orderitemProductAccoff).origin) + '</span>' +
					/* '<span class="p-num">X' + data[i].orderitemPskuNumber + '</span>' + */
					'<div class="input-group">' +
					'<span class="input-group-addon" id="product-num-sub" onclick="subNum(event)"><i class="icon sub"></i></span>' +
					'<input type="text" name="cart-product-num" disabled="disabled" class="form-control" value="' + data[i].orderitemPskuNumber + '">' +
					'<span class="input-group-addon" id="product-num-add" onclick="addNum(event)"><i class="icon plus"></i></span>' +
					'</div>' +
					'<span class="icon delete" onclick="deleteOrderItem(event)">' + '</span>' +
					'</div>' +
					'</div>' +
					'</div>';
			}
			parent.html(html)
		}
  var shopidlist;
		$.ajax({
			url: '${APP_PATH}/MlfrontOrder/tomOrderDetailOne',
			type: 'get',
			success: function (data) {
				var resData = data.extend.mlfrontOrderItemList;
				// console.log(resData);/*2222*/
				shopidlist = toFbidsPurchase(resData);
				orderId = resData && resData.length > 0 ? resData[0].orderId : null;
				var cartList = $('.cart-list');
				cartList.attr('data-id', resData.orderId);
				renderCartList(cartList, resData)
				// console.log(typeof totalPrice)
				var allPriceObj = calAllProductPrice(resData);
				// console.log(allPriceObj);
				prototalPriceText.text('$' + (allPriceObj.allSubtotalPrice).toFixed(2));
				var resDataMoneym =shippingPriceText.text().slice(1)*1;
				totalPrice = (allPriceObj.allSubtotalPrice + resDataMoneym).toFixed(2);
				
				subtotalPriceText.text('$' + totalPrice);
			}
		})

		function addNum(e) {
			e.stopPropagation();
			var item  = $(e.target);
			var productNum = item.parent().parent().find('input');
			var productNumText = parseInt(productNum.val());
			productNumText += 1;
			productNum.val(productNumText);

			reCalPrice(item, true);

			updateOrderItemNum(item, productNumText);
		}

		function subNum(e) {
			e.stopPropagation();
			var item  = $(e.target);
			var productNum = item.parent().parent().find('input');
			var productNumText = parseInt(productNum.val());

			if (productNumText > 1) {
				productNumText -= 1;
				reCalPrice(item, false);
				productNum.val(productNumText);
				updateOrderItemNum(item, productNumText);
			}
		}
		
		function reCalPrice(item, flag) {
			
			var parentEl = $(item).parents('.num');
			var prototalEl = $('.c-prototal>.cal-price-num');
			var subtotalEl = $('.c-subtotal>.cal-price-num');
			var currentPrice = parseFloat(parentEl.find('.price').text());
			if (flag) {
				prototalEl.text('$' + (parseFloat(prototalEl.text().slice(1)) + currentPrice).toFixed(2));
				totalPrice = (parseFloat(subtotalEl.text().slice(1)) + currentPrice);
				subtotalEl.text('$' + totalPrice.toFixed(2));
				
			} else {
				prototalEl.text('$' + (parseFloat(prototalEl.text().slice(1)) - currentPrice).toFixed(2));
				totalPrice = (parseFloat(subtotalEl.text().slice(1)) - currentPrice+couponPriceOld+couponPriceold2);
				couponPriceold2 =0;
				couponPriceOld = 0;
				couponPriceText.text('-$' + 0);
				$(".coed_inp").val("");
				$(".without-data").text("Enter coupon code to get a discount!");
				subtotalEl.text('$' + totalPrice.toFixed(2));
				$(".coupons .coupon-item input[type=radio]").removeClass("active");
				
			}
		}

		function updateOrderItemNum(el, num) {
			var orderItem = el.parents('.cart-item');
			var reqData = {
				orderitemId: orderItem.data('orderitemid'),
				orderitemPskuNumber: num
			}
			// console.table(reqData);
			$.ajax({
				url: '${APP_PATH}/MlfrontOrder/updateOrderItemNum',
				data: JSON.stringify(reqData),
				type: "POST",
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					console.info('success')
				},
				error: function () {
					renderSysMsg('handle product fail.')
				}
			});
		}
		
		function deleteOrderItem(e) {
			e.stopPropagation();
			var orderItem = $(e.target).parents('.cart-item');
			var reqData = {
				orderitemId: orderItem.data('orderitemid')
			};
			
			// console.table(reqData);

			$.ajax({
				url: '${APP_PATH}/MlfrontOrder/delOrderItem',
				data: JSON.stringify(reqData),
				type: "POST",
				dataType: 'JSON',
				contentType: 'application/json',
				success: function (data) {
					//renderSysMsg('Delete success.');
					var jsondate = data;
					// console.log(JSON.parse(data));
					
					var isDelSuccess = jsondate.extend.isDelSuccess;
					var orginalItemNum = jsondate.extend.orginalItemNum;
					if(isDelSuccess==0){
						renderSysMsg('Delete error.');
					}else{
						if(orginalItemNum>0){
							window.location.href = '${APP_PATH}/MlbackCart/toCheakOut';
						}else{
							renderSysMsg('The shopping cart is empty, return to the shopping cart page after 5s.');
							setTimeout(function() {
								window.location.href = '${APP_PATH}/myCart.html';
							}, 5000);
						}
					}
				},
				error: function () {
					renderSysMsg('Handle product fail, please contact customer service.')
				}
			})
		}

		/* all */
		function calAllProductPrice(data) {
			var len = data.length;
			var allSubtotalPrice = 0;
			var allOriginPrice = 0;
			if (len === 0) {
				return 0;
			}
			// console.log(data);
			for (var i = 0; i < len; i += 1) {
				var singPrice = 0;
				var originalPrice = parseFloat(data[i].orderitemProductOriginalprice);
				var discount = parseFloat(data[i].orderitemProductAccoff) / 100;
				var skuPriceArr = data[i].orderitemPskuMoneystr.split(',');
				singlePrice = skuPriceArr.reduce(function (price, item) {
					return (price + parseFloat(item))
				}, originalPrice);
				// console.log(data[i])
				var originSinglePrice = parseFloat(singlePrice.toFixed(2));
				var currentSinglePrice = parseFloat((singlePrice * discount).toFixed(2));
				allOriginPrice = parseFloat((allOriginPrice + originSinglePrice * data[i].orderitemPskuNumber).toFixed(2));
				allSubtotalPrice = parseFloat((allSubtotalPrice + currentSinglePrice * data[i].orderitemPskuNumber).toFixed(2));
			}
			return {
				allOriginPrice: allOriginPrice,
				allSubtotalPrice: allSubtotalPrice
			};
		}
		/* single */
		/* single */
		function getPrice(originalePrice, skuPriceArr, discount) {
			var singlePrice = parseFloat(originalePrice);
			for (var k = 0, len = skuPriceArr.length; k < len; k += 1) {
				singlePrice += (parseFloat(skuPriceArr[k]) ? parseFloat(skuPriceArr[k]) : 0);
			}
			// console.log(singlePrice, discount)
			return {
				origin: parseFloat(singlePrice).toFixed(2),
				current: parseFloat(singlePrice * ((parseFloat(discount) ? parseFloat(discount) : 100) / 100)).toFixed(2)
			}
		}
		/* 优惠券 
		 * 
		//MlbackCoupon/getOneMlbackCouponDetailByCode
		 字段，String couponCode
		 */
		var counponDataList = {};
			function renderCoupons(parent, userType, data) {
				var html = '';
				if (userType === 0||userType === 1) {
					html = '<div class="input-group">' +
						'<input type="text" name="productNum" class="form-control coed_inp" value="" placeholder="Please enter coupon code">' +
						'<span class="input-group-addon" id="coupon-check" onclick="checkCouponCode(event)">check it</span>' +
						'</div><div class="coupon-error"><p class="without-data">Enter coupon code to get a discount!</p></div>';
				}
				/* MlbackCoupon/getOneMlbackCouponDetailByUId
				无参数  post */
				// if (userType === 1) {
				// 	$.ajax({
				// 		url: '${APP_PATH}/MlbackCoupon/getOneMlbackCouponDetailByUId',
				// 		type: 'post',
				// 		dataType: 'text',
				// 		async: false,
				// 		success: function (data) {
				// 			// console.log(data);
				// 			var resData = JSON.parse(data).extend.mlbackCouponReturnList;
				// 			var len = resData.length
				// 			for (var i = 0; i < len; i += 1) {
				// 				counponDataList[resData[i].couponId] = resData[i];
				// 				html += '<div class="coupon-item">' +
				// 					'<input type="radio" name="coupon" data-couponid="' + resData[i].couponId +
				// 					'" onclick="selectCoupon(event)" class="checkbox">' +
				// 					'<span class="price">$' + resData[i].couponPrice + '</span>' +
				// 					'<span class="name">' + resData[i].couponName + '</span>' +
				// 					
				// 					'</div>';
				// 			}
				// 		}
				// 	});
				// }
				parent.html(html);
			}
		var couponPriceold2 = 0;

// 		function selectCoupon(e) {
// 			var targetEl = $(e.target);
// 			var id = targetEl.data('couponid');
// 			$(".coupons .coupon-item input[type=radio]").removeClass("active");
// 			targetEl.addClass("active");
// 			var priceInfo = targetEl.parent().parent().parent().find('.price-info');
// 			var c_prototalnum =$(".c-prototal .cal-price-num").text().slice(1);
// 			// console.log(abwq);
// 			var shopingnum =$(".c-shipping .cal-price-num").text().slice(1);
// 			// console.log(shopnum);
// 			var  totalPricecou2 =c_prototalnum*1+shopingnum*1;
//             // console.log(totalPricecou2)			
// 			if (parseFloat(totalPricecou2) >= counponDataList[id].couponPriceBaseline) {
// 				var couponPrice = counponDataList[id].couponPrice;
// 				couponPriceold2 =couponPrice;
// 				priceInfo.text('-$' + couponPrice);
// 				
// 				couponPriceText.text('-$' + couponPrice);
// 				subtotalPriceText.text('$' + (totalPricecou2 - couponPrice).toFixed(2));
//                 // console.log(totalPricecou2);
// 
// 
// 				couponCode = counponDataList[id].couponCode;
// 				couponId = counponDataList[id].couponId;
// 			} else {
// 				targetEl[0].checked = false;   
// 				priceInfo.text("Cann't use this Coupon!");
// 				couponPriceText.text('-$' + 0);
// 				subtotalPriceText.text('$' + totalPricecou2);
// 			}
// 		}
		
		
		
		function selectPay(e) {
			var targetEl = $(e.target);
			payplate = targetEl.data('payid');
		}
		function checkCouponCode(event) {
			var couponCode2 = $(event.target).prev('input').val();
			var data = {
				couponCode: couponCode2
			}; // MEGA12	couponCode	
			$.ajax({
				url: '${APP_PATH}/MlbackCoupon/getOneMlbackCouponDetailByCode',
				data: JSON.stringify({
					"couponCode": couponCode2
				}),
				type: 'post',
				dataType: 'text',
				contentType: 'application/json',
				success: function (data) {
					var resData = JSON.parse(data).extend.mlbackCouponOne;
					var couponErrorBox = $('.coupon-error');
					// console.log(resData);
					if (resData) {
						// console.log(totalPrice, totalPrice - resData.couponPriceBaseline)
						var c_prototalnum =$(".c-prototal .cal-price-num").text().slice(1);
						// console.log(abwq);
						var shopingnum =$(".c-shipping .cal-price-num").text().slice(1);
						// console.log(shopnum);
						var  totalPricecou =c_prototalnum*1+shopingnum*1;
						
						if (totalPricecou >= resData.couponPriceBaseline) {
							// console.log(totalPrice2121, resData.couponPrice)
							// totalPriceText.text('$' + (totalPrice - resData.couponPrice).toFixed(2));
							couponPriceText.text('-$' + resData.couponPrice);
							subtotalPriceText.text('$' + (totalPricecou - resData.couponPrice).toFixed(2));
							couponPriceOld = resData.couponPrice;
							
							couponId = resData.couponId;
							couponCode = couponCode2;
							renderErrorMsg(couponErrorBox, resData.couponName + '，Has been used!')
						} else {
							
							// renderErrorMsg(couponErrorBox, resData.couponName + '，未超过100不能使用!')
							// console.log(resData)/*89898*/
							// alert("The minimum usage price of this coupon is "+resData.couponPriceBaseline)
							renderErrorMsg(couponErrorBox,'The minimum usage price of this coupon is'+resData.couponPriceBaseline)
							// renderErrorMsg("The minimum usage price of this coupon is "+resData.couponPriceBaseline)
							$(".coed_inp").val("");
							
						}
					} else {
						renderErrorMsg(couponErrorBox, "Coupons don't exist!");
					}
				}
			})
		}
		//MlfrontOrder/orderToPayInfo
		//这5个参数，json格式
		/* 
			private Integer orderId;  //1  都一样，随便从一条取出就行了
		    private String orderOrderitemidstr;//1 每条的orderitemId都不一样，需要拼成字段"77,78"中间逗号拼接。
		    private Integer orderCouponId  // 1  优惠码，就一个
		    private String orderCouponCode; //1，每条的产品数量，需要拼成字段"1,1"中间逗号拼接。
		    private Integer addressinfoId;//1	地址id 就一处
		 */
		$('.place-order').on('click', function () {
			// var val=$('input:radio[name="sex"]:checked').val();
			// var no_check_copn =radio_zt.
			if (inputCheck9()==1){
				return ;
			} else{
				
				// savr_address();  // addres 保存
					var formData = $('.address-box form').serializeArray();
					var reqData = formData.reduce(function (obj, item) {
						obj[item.name] = item.value;
						return obj
					}, {});
					reqData.addressId = reqData.addressId === '' ? null : parseInt(reqData.addressId);
					$.ajax({
						url: '${APP_PATH}/MlfrontAddress/save',
						type: 'post',
						dataType: 'text',
						data: JSON.stringify(reqData),
						contentType: 'application/json',
						success: function (data) {
							 // console.log(data)
							var resDataAddress = JSON.parse(data).extend.mlfrontAddress;
							 // var resDataAddress = data.extend.mlfrontAddress;
							 // console.log(resDataAddress)
							addressId = resDataAddress.addressId;
							addressIdIntInt = resDataAddress.addressId;
							returnaddressId = addressIdIntInt;
							// console.log("addressIdIntInt:"+addressIdIntInt);
							var addressBox = $('.address');
							$('.address-id').val(resDataAddress.addressId);
							var addressIdInt = $('.address-id').val();
							var reqData = {
								"orderId": orderId,
								"orderOrderitemidstr": orderItemArr.join(','),
								"orderCouponId": couponId,
								"orderCouponCode": (couponCode ? couponCode : null), //传递真的code码
								"orderPayPlate": payplate, //选择的付款方式,int类型   paypal传0，后来再有信用卡传1
								"orderProNumStr": productNumArr.join(','), //就这样,,zheli你传给我了，但是我接到之后，再处理的话，要同时动4张表。。所以，能早处理早处理。早处理的话，就动一张
								"orderBuyMess": $('.customer-message textarea').val(), //买家的留言
								"addressinfoId": addressIdInt,
							};
							
							var reqDataUp = {
									"orderId": orderId,
									"orderOrderitemidstr": orderItemArr.join(','),
									"orderCouponId": couponId,
									"orderCouponCode": (couponCode ? couponCode : null), //传递真的code码
									"orderPayPlate": payplate, //选择的付款方式,int类型   paypal传0，后来再有信用卡传1
									"orderProNumStr": productNumArr.join(','), //就这样,,zheli你传给我了，但是我接到之后，再处理的话，要同时动4张表。。所以，能早处理早处理。早处理的话，就动一张
									"orderBuyMess": $('.customer-message textarea').val(), //买家的留言
									"addressinfoId": addressIdInt,
								};
										
							// console.log(reqData)
							// console.log(reqDataUp)
							// console.log(checkAddress(reqDataUp))
							if (checkAddress(reqDataUp)) {
								// fbq('track', 'AddPaymentInfo');//追踪'发起结账'事件  facebook广告插件可以注释掉，但不要删除
								stridsContent=shopidlist;
								orderMoney = subtotalPriceText.text().slice(1)
								
								console.log(stridsContent)
								fbq('track', 'AddPaymentInfo', {
								              content_ids: [stridsContent],
								              //contents: [strContent],
								              content_type: 'product',
								              value: orderMoney,
								              currency: 'USD'
								            });
								
								$.ajax({
									url: '${APP_PATH}/MlfrontOrder/orderToPayInfo',
									data: JSON.stringify(reqData),
									type: 'post',
									dataType: 'text',
									contentType: 'application/json',
									success: function (data) {
										var resData = JSON.parse(data).extend;
										// console.log(data)
										$(".loading").show();
										window.location.href = '${APP_PATH }/paypal/ppay';
									}
								})
							} else {
								renderSysMsg('Please fill in the shipping address ')
							 }
							
							
						}
					})
				
			}
			
		})
		
		/******************************************************/
		       function toFbidsPurchase(resData){
		       	var infoStrlids = '';
		       	var infoRelids = '';
		       	for(var i=0;i<resData.length;i++){
		       		infoStrlids=infoStrlids+resData[i].orderitemPid+',';
		       	}
		       	infoRelids=infoStrlids.substr(0,infoStrlids.length-1);
		       	//console.log("infoRelids:"+infoRelids);
		       	return infoRelids;
		       }
		/******************************************************/
		function checkAddress(reqDataUp) {
			var flag = false;
			$.ajax({
				url: '${APP_PATH}/MlfrontAddress/getOneMlfrontAddressDetailByUinfo',
				type: 'post',
				async: false,
				success: function (data) {
					// console.log("/MlfrontAddress/getOneMlfrontAddressDetailByUinfo");
					// console.log(data)
					var resData = data.extend;
					//console.log(resData.mlfrontAddressOne)
					if (resData.mlfrontAddressOne) {
						flag = true;
					} else {
						falg = false;						
						var addressinfoIdss = reqDataUp.addressinfoId;
						// console.log("addressinfoIdss:"+addressinfoIdss);
						if(addressinfoIdss!=null){
							flag = true;
						}
					}
				}
			});
			return flag;
		}
		 function inputCheck(data) {
				var flag = true;
				//1验证是否为空
				//2验证格式
				for (var key in data) {
					// console.log(key)
					if (key === 'addressEmail') {
						var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
						if (!pattern.test(data[key])) {
							flag = !flag;
							renderSysMsg('Email address format is incorrect');
							break;
						}
					} else if (key === "addressId") {
						continue;
					} else {
						if (data[key].trim().length < 1) {
							flag = !flag;
							$(".save").removeClass("active")
							renderSysMsg('Required fields with an asterisk cannot be empty. Please check before submitting');
							break;
							
						}
					}
				}
				return flag;
			}
					function inputCheck9() {
				
				var flag = 0;
				var firstnamestr = $(".firstname").val();
				// console.log("firstnamestr:"+firstnamestr);
				var lastnamestr = $(".lastname").val();
				// console.log("lastnamestr:"+lastnamestr);
				var emailstr = $(".email").val();
				var phonestr = $(".phone").val();
				var addressstr = $(".addreNo").val();
				var codestr = $(".code").val();
				var citystr = $(".city").val();
				// var countrystr = $("#country").val();
				var provincestr = $(".province").val();
				var country_address = $("#country option:checked").text(); 
				// var radio_zt_copn=$(".coupons .coupon-item input[type='radio']").val();
				// if(radio_zt_copn==null||radio_zt_copn==''){
				// 	flag = 1;
				// 	alert("优惠券未使用")
				// }

				
				if(firstnamestr==null||firstnamestr==''){
					flag = 1;
					// alert("firstnamestr is empty");
					renderSysMsg('firstnamestr is empty')
					$(".firstname").addClass("error_br");
					$(".firstname").focus(function(){
						$(this).removeClass("error_br")
					})
				}else if(lastnamestr==null||lastnamestr==''){
					flag = 1;
					// alert("lastnamestr is empty");
					renderSysMsg('lastnamestr is empty')
					$(".lastname").addClass("error_br");
					$(".lastname").focus(function(){
						$(this).removeClass("error_br")
					})
				}else if(emailstr==null||emailstr==''){
					flag = 1;
					// alert("emailstr is empty");
					renderSysMsg('emailstr is empty')
					$(".email").addClass("error_br");
					$(".email").focus(function(){
						$(this).removeClass("error_br")
					})
				}else if(phonestr==null||phonestr==''){
					flag = 1;
					// alert("phonestr is empty");
					renderSysMsg('phonestr is empty')
					$(".phone").addClass("error_br");
					$(".phone").focus(function(){
						$(this).removeClass("error_br")
					})
				}else if(addressstr==null||addressstr==''){
					flag = 1;
					// alert("addressstr is empty");
					renderSysMsg('addressstr is empty')
					$(".addressstr").addClass("error_br");
					$(".addressstr").focus(function(){
						$(this).removeClass("error_br")
					})
				}else if(codestr==null||codestr==''){
					flag = 1;
					// alert("codestr is empty");
					renderSysMsg('codestr is empty')
					$(".codestr").addClass("error_br");
					$(".codestr").focus(function(){
						$(this).removeClass("error_br")
					})
				}else if(country_address==null||country_address==''||country_address=='select the Country'){
					flag = 1;
					// alert("countrystr is empty");
					renderSysMsg('countrystr is empty')
					$("#country").addClass("error_br");
					$("#country").focus(function(){
						$(this).removeClass("error_br")
					})
				}else if(provincestr=='province'){
					flag = 1;
					// alert("provincestr is empty");
					renderSysMsg('provincestr is empty')
					$(".province").addClass("error_br");
					$(".province").focus(function(){
						$(this).removeClass("error_br")
					})
				}
				return flag;
				
					
					
				
			}
			
	</script>
  	<!-- megalook-->
  	<script src="//code.tidio.co/sjcpaqy3xxtkt935ucnyf2gxv1zuh9us.js"></script>
	<!-- megalookhair 
  	<script src="//code.tidio.co/0rpdotjoqewxstfjahkd1ajtxrcp8phh.js"></script>-->
  	<!-- huashuohair -->
  	<!-- <script src="//code.tidio.co/folzahtp5vdopiwathysfiyz75dk5vnm.js"></script> -->
</body>

</html>