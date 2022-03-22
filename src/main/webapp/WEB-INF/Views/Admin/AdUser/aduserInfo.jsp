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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원정보</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/AdUser/aduserInfo.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/AdUser/aduserInfo.js" charset="UTF-8"></script>
</head>
<body>

	<!-- aduserList.jsp 에서 이름 클릭시 나오는 회원정보창
		항목은 조금 수정했음.
	 -->
	<div class="wrap">
	
	<div class="mainTitle">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  		<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>
		</svg>
		회원 상세 정보
	</div>
	
	<div class="title">
	<c:out value="${aduserVO.user_name}"/>님의 회원 정보입니다.
	</div>
	
	<form action="">
	
		<div class="adUserData">
		<table id="userTable">
			<tr>
				<td class="grayBg">이름</td>
				<td class="whiteBg">${aduserVO.user_name}</td>
				<td class="grayBg">추천인아이디</td>
				<td class="whiteBg">${aduserVO.recommendId}</td>
			</tr>
			<tr>
				<td class="grayBg">아이디</td>
				<td class="whiteBg">${aduserVO.user_id}</td>
				<td class="grayBg">생일</td>
				<td class="whiteBg">${aduserVO.user_birth}</td>
			</tr>
			<tr>
				<td class="grayBg">성별</td>
				<td class="whiteBg">${aduserVO.user_gender}</td>
				<td class="grayBg">가입일시</td>
				<td class="whiteBg">${aduserVO.join_date}</td>
			</tr>
			<tr>
				<td class="grayBg">회원등급</td>
				<td class="whiteBg"><b>${aduserVO.user_grade}</b></td>
				<td class="grayBg">비밀번호</td>
				<!-- 클릭시 회원로그인기록 loginRecord.jsp 페이지로 이동 -->
				<!-- <td "whiteBg"><a href="loginRecord.jsp"><div class="skyblueFont">[LOG]</div></a></td> -->
				<td class="whiteBG">${aduserVO.user_pw}</td>
			</tr>
			<tr>
				<td class="grayBg">휴대전화</td>
				<td class="whiteBg">${aduserVO.user_phone}</td>
				<td class="grayBg">이메일</td>
				<td class="whiteBg">${aduserVO.user_email}</td>
			</tr>
			<tr>
				<td class="grayBg">주소</td>
				<td class="whiteBg" colspan="3">${aduserVO.user_addr}</td>
			</tr>
			<tr>
				<td class="grayBg">적립금</td>
				<td class="whiteBg">${aduserVO.user_point}</td>
				<td class="grayBg">쿠폰</td>
				<td class="whiteBg">${aduserVO.cp_code}</td>
			</tr>
			<tr>
				<td class="grayBg">뉴스레터 수신</td>
				<td class="whiteBg">${aduserVO.email_agree}</td>
				<td class="grayBg">문자메시지 수신</td>
				<td class="whiteBg">${aduserVO.sms_agree}</td>
			</tr>
			<tr>
				<td class="grayBg">개인정보수신동의</td>
				<td class="whiteBg">${aduserVO.info_agree}</td>
				<td class="grayBg">투유패쓰</td>
				<td class="whiteBg">${aduserVO.toYou_pass}</td>
			</tr>
			<tr colspan="2">
				<td class="grayBg">참여이벤트명</td>
				<td class="whiteBg">${aduserVO.join_event}</td>
			</tr>

		</table>
		</div>
		
		<div class="title">
		관리자메모
		</div>
		
		<div class="adminMemo">
			<table>
				<tr>
					<td class="memograyBg">관리자메모</td>
					<td class="memowhiteBg"></td>
				</tr>
				<%-- </c:forEach> --%>
			</table>
		</div>
		<!-- ★버튼 2개 가운데 정렬 필요-->
		<!-- 버튼 클릭시 alert창 띄우기 js구현되어있음 -->
		<button type="button" class="backBtn" onclick="location.href='${contextPath}/aduser/listadUsers.do'">뒤로가기</button>
	</form>
	</div>
</body>
</html>