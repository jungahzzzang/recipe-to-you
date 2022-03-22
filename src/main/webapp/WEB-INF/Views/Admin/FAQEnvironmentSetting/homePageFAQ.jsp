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
	<link rel="stylesheet" href="../../../Resources/Admin/Css/HomePageHeaderSide/homePage.css">
	<link rel="stylesheet" href="../../../Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script src="../../../Resources/Admin/Js/HomePageHeaderSide/homePage.js"></script>
	<!-- 팝업 관련 자바스크립트 => 팝업창 띄울때 사용하면 됨 
		url, name, option은 각자 구현 기능에 맞게 설정하면 됨 
	<script>
        function popup(){
            var url = "design_entire_setting.jsp";
            var name = "popup test";
            var option = "width = 1080px, height = 100%, top = 100, left = 200, location = no"
            window.open(url, name, option);
        }
    </script> -->
</head>
<body class="homeBody">
	<div class="wrap">
		<div class="header">
		<h1>관리자모드</h1>
			<div class="topBar">
				<ul>
					<li><a class="topLogo" href="homePage.jsp"><i class="fas fa-home"></i></a></li>
					<li><a href="#">이용메뉴얼보기</a></li>
					<li><a href="#">관리자모드</a></li>
					<li><a href="#">홈페이지보기</a></li>
					<li><a href="#">모바일웹보기</a></li>
				</ul>
			</div>
			<div class="nav">
				<ul>
					<li><a href="shopMallMgm.jsp">쇼핑몰관리</a></li>
					<li><a href="orignSetting.jsp">기본환경설정</a></li>
					<li><a href="boardMgm.jsp">게시물관리</a></li>
					<li><a href="formMgm.jsp">폼관리</a></li>
					<li><a href="faq.jsp">FAQ관리</a></li>
					<li><a href="paymentMgm.jsp">결제관리</a></li>
					<li><a href="backup.jsp">통계 및 백업관리</a></li>
					<li><a href="mobileWebSetting.jsp">모바일웹설정</a></li>
				</ul>
			</div>
		</div>
	
		<div class="sideBar" id="followMenuBtn">
			<button onclick="dropMenu_btn()" class="sideMenu"><i class="fas fa-bars"> Menu</i></button>
			<div class="sideBtn" id="drop_content">	
				<ul>
					<li><a href="shopMallMgm.jsp">쇼핑몰관리</a></li>
					<li><a href="orignSetting.jsp">기본환경설정</a></li>
					<li><a href="boardMgm.jsp">게시물관리</a></li>
					<li><a href="formMgm.jsp">폼관리</a></li>
					<li><a href="faq.jsp">FAQ관리</a></li>
					<li><a href="paymentMgm.jsp">결제관리</a></li>
					<li><a href="backup.jsp">통계 및 백업관리</a></li>
					<li><a href="mobileWebSetting.jsp">모바일웹설정</a></li>
				</ul>
			</div>
		</div>
		
		<div class="homePageMain">
			<!-- 팝업창 띄울 때 사용하면 됨. 구글링해서 타겟을 변경하면 다양한 기능 구현이 가능함 <a href="javascript:popup()" target="_self">팝업</a> -->
			<!-- 동적 jsp:include를 사용해서 부모 jsp 파일에 자식 jsp를 불러왔음
				 혹은 팝업창 띄우는 걸로 대체하든지 해야 함
				 일단 다들 구현이 되는지 확인만 하면 됨	
			 -->
			<jsp:include page="faqEnvironmentSetting.jsp" flush="true"/>
		</div>
	</div>
</body>
</html>

















