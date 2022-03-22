<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>관리자 모드</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	 integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
 	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/AdminLogin/adminLogin.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css">
</head>
<style>


</style>
<body>
	<div class="wrap">
		<div class="homePageMain">
			<div class="loginForm">
				<form name="frmLogin" method="post" action="${contextPath}/admin/adMain.do">
					<table class="loginTable">
						<tr class="title">
							<td colspan="2">
								<h2>레시피 투유 관리자 사이트</h2>
							</td>
						</tr>
						<tr align="center">
							<td>아이디</td>
							<td>
								<input type="text" name="adminId" value="" size="20">
							</td>
						</tr>
						<tr align="center">
							<td>비밀번호</td>
							<td>
								<input type="password" name="adminPw" value="" size="20">
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" value="로그인" class="submit-btn">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>