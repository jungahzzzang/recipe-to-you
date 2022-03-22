<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰</title>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/mypageInfo.css" type="text/css">	
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/coupon.css" rel="stylesheet"
	type="text/css">
<!-- fontawesome 링크 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
	crossorigin="anonymous">
<!-- font 링크 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap"
	rel="stylesheet">
<!-- 파비콘 링크 -->
<link href="/recipetoyou/Resources/User/Img/Mypage2/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
</head>
<body>
	<div class="main">
		<div class="content">
			<div class="head">
				<h2 class="title">쿠폰</h2>
			</div>
			<!-- head -->
			
			
			<div class="notice">
				<div class="noticeMain">· 쿠폰은 적용 가능한 상품이 따로 적용되어 있는 경우 해당 상품 구매 시에만 사용이 가능합니다.</div>
			</div>
			<!-- notice -->
			<table class="couponCate">
				<tr>
					<th class="cateName">쿠폰명</th>
					<th class="cateFunction">기능</th>
					<th class="cateBenefit">할인/적립</th>
					<th class="cateVaild">사용가능기간</th>
					<th class="cateCheck">사용여부</th>
				</tr>
			</table>
			<!-- couponCate -->

			<!-- coupon -->
			<c:set var = "total" value = "0" />
			<c:forEach var="couponList" items="${couponList}" varStatus="status">
				<table class="couponList">
					<tr>
						<th class="couponName">
							<div class="coupon">${couponList.cp_name}</div>
							<p>${couponList.cp_content}</p>
							<div class="terms">
								<a href="" onclick="window.open('');">사용조건 보기</a>
							</div>
						</th>
						<th class="couponFunction">${couponList.cp_function}</th>
						<th class="couponBenefit">${couponList.cp_price}</th>
						<th class="couponVaild">${couponList.cp_end_date}</th>
						<th class="couponCheck">${couponList.cp_payment_details}</th>
					</tr>
					
						
				</table>
				<!-- couponList -->
			</c:forEach>
			<div class="coupon_box">
				<div class="coupon_view">
					<div class="title_now">사용가능쿠폰 : </div>
					<div class="coupon_now">
								<c:out value="${result}"/>장
					</div>
				</div>
				<!-- coupon_view -->
			</div>
			<!-- coupon_box -->
			
		</div>
		<!-- content -->
	</div>
	<!-- main -->
</body>
</html>


















