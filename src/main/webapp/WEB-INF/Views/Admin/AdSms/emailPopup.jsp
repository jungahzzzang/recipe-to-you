<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:if test="${admin.adminId == null }">
	<script>
		alert("관리자 로그인 후 이용이 가능합니다.");
		location.href="${contextPath}/admin/adLogin.do";
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>발송된 이메일 내용 보기</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/Sms/emailPopup.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSidereset.css">
</head>
<body>
	<!-- 뉴스레터발송관리 - 발송내역조회 목록 중 제목 클릭시 나타나는 팝업창 -->
	<div class="wrap">
		<div class="title">
			발송된 이메일 내용
		</div>
		
		<div class="table_wrap">
			<table>
			<!-- db 활용하기 -->
				<tr>
					<td class="grayBg">메일제목</td>
					<td class="whiteBg">[2월] 인터넷예약시 특별할인!!</td>
				</tr>
				<tr>
					<td class="grayBg">발송건수</td>
					<td class="whiteBg">1건</td>
				</tr>
				<tr>
					<td class="grayBg">발송일시</td>
					<td class="whiteBg">2021년 2월 4일 10시 40분</td>
				</tr>
				<tr>
					<td colspan="2" width="100%" height="120%"></td>
				</tr>
			</table>
		</div>
			
		<div class="closeBtn">
			<!-- 닫기 버튼 클릭시 창닫기 이벤트 구현되어있음 -->
			<input type="button" value="닫기" onclick="window.close()">
		</div>	
	</div>
</body>
</html>