<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적립금</title>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/mypageInfo.css"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/point.css"
	rel="stylesheet" type="text/css">
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
<script type="text/javascript" src="/recipeToYou/Resources/User/Js/Mypage/userPoint.js" charset="UTF-8"></script>
</head>
<body>
	<div class="content">
		<div class="head">
			<h2 class="title">
					<h2 class="title">
					적립금 
					<span class="subtitle">보유하고 계신 적립금의 내역을 한 눈에 확인 하실 수 있습니다.</span>
				</h2>
			</div>
			<!-- head -->
			
			<table class="point_cate">
				<tr>
					<th class="cate_date">적립날짜</th>
					<th class="cate_content">내용</th>
					<th class="cate_valid">유효기간</th>
					<th class="cate_price">금액</th>
				</tr>
			</table>
			<!-- point_cate -->
			<c:set var = "total" value = "0" />
			<c:forEach var="pointList" items="${pointList}" varStatus="status">
			<table id="point_main">
				<tr>
					<td id="main_date">${pointList.accum_date}</td>
					<td id="main_content">${pointList.point_content}</td>
					<td id="main_vaild">${pointList.use_date}</td>
					<td id="main_point">${pointList.point}원</td>
				</tr>
				<c:set var="total" value="${total + pointList.point}"/>
			</table>
			<!-- point_main -->
			</c:forEach>
			<div class="point_box">
				<div class="point_view">
					<div class="title_now">현재 적립금 : </div>
					<div class="point_now"><c:out value="${total}"/>원</div>
				</div>
				<!-- point_view -->
			</div>
			<!-- point_box -->
		</div>
		<!-- content -->
	</div>
	<!-- main -->
</body>
</html>

















