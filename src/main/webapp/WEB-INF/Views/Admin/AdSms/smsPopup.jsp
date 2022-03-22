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
	<title>발송된 SMS 내용 보기</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/Sms/smsPopup.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css">
</head>
<body>
	<div class="wrap">
	
		<table>
			<tr>
				<td class="grayBg">ID</td>
				<td class="grayBg">이름</td>
				<td class="grayBg">핸드폰</td>
			</tr>
			<tr>
				<td class="whiteBg">lssds123</td>
				<td class="whiteBg">강수종</td>
				<td class="whiteBg">010-3944-7445</td>
			</tr>
			<tr>
				<td class="whiteBg">hong</td>
				<td class="whiteBg">홍길동</td>
				<td class="whiteBg">010-4115-4444</td>
			</tr>
		</table>
		
		<!-- 닫기 이벤트 구현 -->
		<button onclick="window.close()">닫기</button>
	</div>
</body>
</html>