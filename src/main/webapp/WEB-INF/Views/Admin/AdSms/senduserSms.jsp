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
	<title>회원SMS발송</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/Sms/senduserSms.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/Sms/senduserSms.js" charset="UTF-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css">
</head>
<body>
	<!--  
		회원SMS발송 페이지
		list_head : 달력 검색 버튼 있는 테이블
		leftContent : 문자메시지 화면 그림, 버튼
		rightContent : 안내박스, 테이블
	-->
	<div class="wrap">
		<div class="titleBox">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  		<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>
		</svg>
			회원 SMS 발송
		</div>
	
		<form action="#" method="post">
			<div class="list_head">
			<table align="center" id="tableGroup">
				<tr>
					<td>
							<input type="checkbox">
							<!-- 달력 js 구현되어있음 -->
							<input type="text" id="datepicker1"> ~
  							<input type="text" id="datepicker2">
							<input class="btn_option" type="button" value="오늘날짜">
							<input class="btn_option" type="button" value="최근1주일">
							<input class="btn_option" type="button" value="최근15일">
							<input class="btn_option" type="button" value="최근 1개월">
							<input class="btn_option" type="button" value="최근2개월">
							<input class="btn_option" type="button" value="최근3개월">
					</td>
				</tr>
				
				<tr>
					<td>
							<select name="userGrade">
								<option value="generalUser">회원등급</option>
								<option value="Operator">운영자</option>
								<option value="sub_Operator">부운영자</option>
								<option value="specialUser">특별회원</option>
								<option value="superUser">우수회원</option>
								<option value="regularUser">정회원</option>
								<option value="assoUser">준회원</option>
							</select>
							<select name="searchOption">
								<option value="userId">아이디</option>
								<option value="userName">이름</option>
								<option value="userEmail">이메일</option>
							</select>
							<input type="text" name="userSearch">
							<input type="checkbox">수신거부제외
							<input class="search_btn" type="button" value="검색">
					</td>
				</tr>	
			</table>
			</div>
			
			<div class="middle_title">
				SMS를 수신할 회원이 총 2명 검색되었습니다.
			</div>
			
			<div class="wrap_content">
			
				<div class="leftContent">
				
					<div class="messageImg">
						<img alt="문자" src="/recipetoyou/Resources/Admin/Img/Sms/half_msg.png"><br>
						<input type="text" id="msgText">
					</div>
			
				<div class="bottomContent">
					보내는사람<br>
					<input type="text" class="sendText"><br>
					<button class="sendBtn" onclick="sendMessage()">보내기</button><br>
					
					<!-- 팝업창 이벤트 구현 -->
					<a href="${contextPath}/adsms/smsPopup.do" onclick="window.open(this.href,'팝업창','width=400, height=500'); return false;">
					<button class="viewBtn">발송될 핸드폰번호보기</button><br>
					</a>
					
					<!-- ★랭크업에서는 실제 문자 보내는 기능이 들어 있어서 추후 확인 필요 -->
					<a href="${contextPath}/adsms/msgPopup.do" onclick="window.open(this.href,'팝업창','width=240, height=500'); return false;">
					<button class="indisendBtn">개인 메시지 발송하기</button>
					</a>
				</div>
			</div>
			
			<div class="rightContent">
			
				<div class="infoBox">
					최대 글자수는 80Byte 입니다. 80Byte초과시 뒷부분이 삭제되어 발송됩니다.<br>
  					아래 형식을 사용하면 문자전송시 자동으로 반영되어 전송됩니다.
				</div>
			
				<table>

				<tr>
					<td class="grayBg">{도메인}</td>
					<td class="whiteBg">
					사이트의 도메인명이 출력됩니다.<br>
					예)rankup.co.kr
					</td>
				</tr>
				
				<tr>
					<td class="grayBg">{날짜}</td>
					<td class="whiteBg">
					오늘 날짜가 출력됩니다.<br>
					예)12월 25일
					</td>
				</tr>
				
				<tr>
					<td class="grayBg">{아이디}</td>
					<td class="whiteBg">
						회원 아이디가 출력됩니다.<br>
						예)rankup
					</td>
				</tr>
				
				<tr>
					<td class="grayBg">{이름}</td>
					<td class="whiteBg">
					회원 이름이 출력됩니다.<br>
					예)랭크업
					</td>
				</tr>
				</table>
			
			</div>
		</div>
		
		</form>
	</div>
</body>
</html>