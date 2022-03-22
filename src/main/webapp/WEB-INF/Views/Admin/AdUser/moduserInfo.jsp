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
	<meta charset="EUC-KR">
	<title>회원정보수정</title>
	<script src="https://kit.fontawesome.com/7d11552255.js" crossorigin="anonymous"></script>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/AdUser/moduserInfo.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/AdUser/moduserInfo.js" charset="UTF-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

	<!-- 
		회원리스트 중 수정 버튼 클릭시 넘어오는 페이지
	 -->
	<div class="wrap">
		<div class="mainTitle">
			회원기본정보
		</div>
		
		<form action="${contextPath}/aduser/userUpdate.do" method="post">
		
			<table border="1">
			<c:set var="user" />
				<tr>
					<td class="grayBg">아이디</td>
					<td class="whiteBg"><input id="text" type="text" value="${userVO.user_id}" readonly="readonly">
					<input type="hidden" name="user_id" value="${userVO.user_id }">
					</td>
					
				</tr>
				
				<tr>
					<td class="grayBg">
					<i class="fas fa-check" id="checkIcon"></i>
					이름
					</td>
					<td class="whiteBg"><input id="text" type="text" name="user_name" value="${userVO.user_name}"><div class="skyblueFont">+최대50자까지 입력 가능</div>
					<%-- <input type="hidden" name="user_name" value="${userVO.user_name}"/> --%>
					</td>
					
				</tr>
				
				<tr>
					<td class="grayBg">
					<i class="fas fa-check fa-xs" id="checkIcon"></i>
					생년월일
					</td>
					<td class="whiteBg">
					${userVO.user_birth}
					<input type="hidden" name="user_birth" value="${userVO.user_birth}">
						
					</td>
				</tr>
				
				<tr>
					<td class="grayBg">
					<i class="fas fa-check fa-xs" id="checkIcon"></i>
					성별
					</td>
					<td class="whiteBg">
						${userVO.user_gender}
						<%-- <c:out value="${userVO.user_gender}"/> --%>
						<!-- <input type="radio">남<input type="radio">여 -->
					</td>
				</tr>
				
				<tr>
					<td class="grayBg">비밀번호</td>
					<td class="whiteBg">
					<input type="text" name="user_pw" value="${userVO.user_pw}">
					<%-- <input type="hidden" name="user_pw" value="${userVO.user_pw }"> --%>
					<div class="skyblueFont">+4~15자의 영문자,숫자조합</div>
					<div class="redFont">(비밀번호 변경시에만 입력하십시오)</div>
					</td>
				</tr>
			
				
				<tr>
					<td class="grayBg"><i class="fas fa-check fa-xs" id="checkIcon"></i>회원등급</td>
					<td class="whiteBg">
					${userVO.user_grade}
					</td>
				</tr>
				
				<tr>
					<td class="grayBg">이메일주소</td>
					<td class="whiteBg">
					<input id="text" type="text" name="user_email" value="${userVO.user_email}">
					<%-- <input type="hidden" name="user_email" value="${userVO.user_email}"> --%>
					</td>
				</tr>
				
				
				<tr>
					<td class="grayBg"><i class="fas fa-check fa-xs" id="checkIcon"></i>휴대전화</td>
					<td class="whiteBg">
					<input id="text" type="text" name="user_phone" value="${userVO.user_phone}"/>
					<%-- <input type="hidden" name="user_phone" value="${userVO.user_phone}"> --%>
					</td>
				</tr>
				
				<tr>
					<td class="grayBg"><i class="fas fa-check fa-xs" id="checkIcon"></i>주소</td>
					<td class="whiteBg">
					<input id="text" type="text" name="user_addr" value="${userVO.user_addr}">
					<%-- <input type="hidden" name="user_addr" value="${userVO.user_addr}"><br> --%>
					</td>
				</tr>
			</table>
			
			<div class="title">
				정보수신설정
			</div>
			
			<table>
				<tr>
					<td class="grayBg">뉴스레터 수신</td>
					<td class="whiteBg">
					${userVO.email_agree}
					<%-- <c:out value="${userVO.email_agree}"/> --%>
					</td>
				</tr>
				
				<tr>
					<td class="grayBg">문자메시지 수신</td>
					<td class="whiteBg">
					${userVO.sms_agree}
					<%-- <c:out value="${userVO.sms_agree}"/> --%>
					</td>
				</tr>
				
			</table>
			
			<!-- <div class="title">
				관리자메모
			</div> -->
			
		
		
			<%-- <button type="button" class="saveBtn" onsubmit="return _onSubmit();"><a href="${contextPath}/user/userUpdate.do?user_id=${userVO.user_id}">수정</a></button> --%>
			<input type="submit" class="saveBtn" value="수정">
			</form>
			
			<!-- 버튼 클릭시 뒤로가는 js구현되어있음.  -->
			<button type="button" class="backBtn" onclick="location.href='${contextPath}/user/listadUsers.do'">뒤로가기</button>
		</div>

	</div>
</body>
</html>