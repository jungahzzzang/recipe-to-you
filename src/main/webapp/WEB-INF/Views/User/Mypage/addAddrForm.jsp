<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새배송지 추가</title>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/mypageInfo.css" type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/addAddrForm.css" rel="stylesheet"
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
<script type="text/javascript" src="/recipetoyou/Resources/User/Js/Mypage/userAddress.js" charset="UTF-8"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	
	<div class="addAddrPopup">
		<div class="popupTitle">
			<div class="popupTitle1">새배송지 추가</div>
			<p>오늘 주문하면 다음 날 바로 도착해요.(일요일 휴무)</p>
		</div>
		
		<form action="" class="addressForm">
			<input type="text" name="zonecode" id="zonecode" readonly="readonly" placeholder="   우편번호"><a href="" onclick="addAddr()">우편번호검색</a><br>
			<input type="text" name="roadAddress" id="roadAddress" readonly="readonly"><br>
			<input type="text" name="namugiAddress" id="namugiAddress" placeholder="   나머지 주소를 입력해주세요"><br>
			<input type="text" name="addName" id="addName" placeholder="   받으실 분을 입력해주세요"><br>
			<input type="text" name="addPhone" id="addPhone" placeholder="   연락처를 입력해주세요 ( - 을 반드시 포함해주세요)"><br>
			<button type="submit" class="save" value="저장">저장</button>
		</form>
	</div>
</body>
</html>
