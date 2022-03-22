<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 수정</title>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/mypageUserInfo.css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
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
<script type="text/javascript" src="/recipetoyou/Resources/User/Js/Mypage/userInfo.js" charset="UTF-8"></script>
</head>
<body>
	<div class="main">
		<div class="content">
			<div class="head">
				<h2 class="title">개인 정보 수정</h2>
			</div>
			<!-- head -->
			<form name="infoView" action="UserUpdate.do" method="POST" class="form-signup form-user panel-body"  autocomplete="off">
			<input type="hidden" id="user_name_yn" name="user_name_yn" value="N"/>
			<table class="myInfoMain">
				
				<tr>
					<th>아이디</th>
					
					<td><input type="text" value="${userVO.user_id}" id="id" name="user_id" readonly="readonly"></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" value="" id="new_pwd" name="user_pw"></td>
				</tr>
			</table>
			
			</form>
			<div class="form_footer">
				<a href="${contextPath}/withdrawUser.do?user_id=${userVO.user_id}" class="fnWithdraw">
							탈퇴하기
				</a>
				<button type="submit" id="infoSubmit" name="infoSubmit" >회원정보수정</button>
			</div>
			<!-- form_footer -->
		</div>
		<!-- content -->
	</div>
	<!-- main -->
	
	<script type="text/javascript">
		$("#infoSubmit").click(function () {
		var infoView = document.infoView;	
		var new_pwd = infoView.user_pw.value;
			
		if(new_pwd != null ||new_pwd != "") {
			alert("수정이 완료되었습니다.");
			infoView.submit();
		}else{
			return false;
		}  
	});
		
	$(".fnWithdraw").click(function(){
		alert("탈퇴가 완료되었습니다.");
	})	
		</script>
</body>
</html>













