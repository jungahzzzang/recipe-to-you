<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%request.setCharacterEncoding("UTF-8");%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>관리자 모드</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
 	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
 	<link href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/homePage.css" rel="stylesheet">
	<link href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/HomePageHeaderSide/homePage.js"></script>
</head>
<body class="homeBody">
	<div class="wrap">
		<div class="header">
		<h1>
			<a href="${contextPath}/admin/adMainForm.do">관리자모드</a>
		</h1>	
			<c:choose>
				<c:when test="${admin.adminId == null}">
					<a href="${contextPath}/admin/adLogin.do">관리자 로그인</a>
				</c:when>
				<c:otherwise>
					${admin.adminName}님이 로그인중입니다.
					<a href="${contextPath}/admin/logout.do">관리자 로그아웃</a>
				</c:otherwise>
			</c:choose>
		
			<div class="topBar">
				<ul>
					<li><a href="${contextPath}/admin/adMainForm.do"><i class="fas fa-home"></i></a></li>
					<li><a href="${contextPath}/adgoods/listProduct.do">상품관리</a></li>
					<li><a href="${contextPath}/aduser/listadUsers.do">회원관리</a></li>
					<li><a href="${contextPath}/adorder/listadOrd.do">주문관리</a></li>
					<li><a href="${contextPath}/adpayment/listadPay.do">결제관리</a></li>
					<li><a href="${contextPath}/adsend/listadSend.do">발송관리</a></li>
					<li><a href="${contextPath}/adfaq/faqAdManagement.do">FAQ관리</a></li>
				</ul>
			</div>
		</div>
	
		<div class="sideBar" id="followMenuBtn">
			<button onclick="dropMenu_btn1()" class="sideMenu"><i class="fas fa-bars"> Menu</i></button>
			<div class="sideBtn" id="drop_content1">	
				<ul>
					<div class="menu"><li class="bold" onclick="dropMenu_btn2(); return false;">쇼핑몰관리</div>				
						<ul id="drop_content2">
							<li>메인페이지</li>
							<li><a href="${contextPath}/adgoods/listProduct.do">상품관리</a></li>
							<li><a href="${contextPath}/adorder/listadOrd.do">주문관리</a></li>
							<li><a href="${contextPath}/adpayment/listadPay.do">결제관리</a></li>
							<li><a href="${contextPath }/adgoods/inquiryList.do">상품문의</a></li>
							<li><a href="${contextPath }/adgoods/adReviewList.do">상품후기</a></li>
							<li><a href="${contextPath}/adrecipe/listadRecipe.do">레시피관리</a></li>
						</ul>
					</li>	

					<div class="menu"><li class="bold" onclick="dropMenu_btn3(); return false;">회원관리</div>	
						<div id="drop_content3">
						<ul>
							<li><a href="${contextPath}/aduser/listadUsers.do">회원관리</a></li>
							<li><a href="${contextPath}/aduserWithdraw/listadUsersWithdraw.do">탈퇴회원관리</a></li>
							<li><a href="${contextPath}/adfaq/faqAdManagement.do">FAQ관리</a></li>
							<li><a href="${contextPath}/adnotice/listadNotice.do">공지사항관리</a></li>
						</ul>
						</div>
					</li>
						
					<div class="menu"><li class="bold" onclick="dropMenu_btn4(); return false;">발송관리</div>
						<div id="drop_content4">
						<ul>
							<li><a href="${contextPath}/adsend/listadSend.do">회원sms발송</a></li>
						</ul>
						</div>
					</li>
					
				</ul>
			</div>
		</div>
		
	</div>
</body>
</html>

















