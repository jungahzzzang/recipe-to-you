<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Recipe to You :: 내일의 장보기, 레시피투유</title>
	<link href="/recipetoyou/Resources/User/Css/login.css" rel="stylesheet"
		type="text/css">
	<c:choose>
		<c:when test="${param.result == 'loginFailed'}">
			<script type="text/javascript">
				window.onload=function() {
					alert("아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!!");
				}
			</script>
		</c:when>
	</c:choose> 
</head>
<body>
		
</head>
<body>
	<form name="frmLogin" method="post" action="">
	<div class="main">
		<div class="login">
			<h3>로그인</h3>
			<div class="info">
				<input type="text" name="user_id" placeholder="아이디를 입력해주세요" />
			</div>
			<div class="info">
				<input type="password" name="user_pw" placeholder="비밀번호를 입력해주세요" />
			</div>
			<div class="text">
				<span class="security"><label><input type="checkbox" />보안접속</label></span>
				<span class="findUser"><a href="#none">아이디찾기</a> | <a
					href="#none">비밀번호 찾기</a></span>
			</div>
			<div class="btn">
				<input class="login" type="submit" value="로그인"  onclick="fn_sendUser()"/><br />
				<br /> <a class="join" href="${contextPath}/join/regist.do">회원가입</a>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript">
		function fn_sendUser() {
			var frmLogin = document.frmLogin
			var user_id = frmLogin.user_id.value;
			var user_pw = frmLogin.user_pw.value;
			
			if(user_id.length==0 || user_id=="") {
				alert("아이디는 필수입니다.");
			}
			else if(user_pw.length==0 || user_pw=="") {
				alert("비밀번호는 필수입니다.")
			}
			else {
				frmLogin.method = "post";						//전송 방법을 post로 지정함.
				frmLogin.action="${contextPath}/login/loginProcess.do";		//서블릿 매핑 이름 지정함.		
				frmLogin.submit();								//서블릿으로 전송함.
			}
		}
	</script> 
</body>
</html>