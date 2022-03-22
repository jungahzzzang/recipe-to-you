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
	<title>인증번호발송기록</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="../../../Resources/Admin/Css/AdUser/sendnumList.css">
	<link rel="stylesheet" href="../../../Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../../../Resources/Admin/Js/AdUser/sendnumList.js" charset="UTF-8"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css">
	
</head>
<body>
	
	<!-- 인증번호발송기록 페이지
		.infoBox : 최상단 주황색 안내 박스
		.list_head : 날짜 검색 버튼 있는 테이블
		.sendList_wrap : 로그 검색 목록 테이블
	-->
	
	<div class="wrap">
	<div class="mainTitle">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  			<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>
			</svg>
			인증번호 발송기록
	</div>
	<div class="infoBox">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  		<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
		</svg>
		회원가입시 <div class="boldFont">휴대폰 인증번호 전송은 1일 5회로 제한</div>되어 있습니다.<br>
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  		<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
		</svg>
		전송 제한으로 인증번호를 받지 못하는 경우에는 해당 휴대전화번호의 전송내역을 삭제해 주시면 됩니다. <br>
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  		<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
		</svg>
		문자메시지 전송결과는 [마켓컬리 홈페이지>마이 페이지]에서 확인하실 수 있습니다.
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
					<td >
						<select name="searchOption">
							<option value="phone">휴대전화</option>
							<option value="Ip_addr">아이피주소</option>
						</select>
							<input type="text" name="userSearch">
							<input class="search_btn" type="button" value="검색">
					</td>
				</tr>	
			</table>
			</div>
		<div class="middle_titleBox">
			총 1건의 로그가 검색되었습니다.		
		</div>
		<div class="sendList_wrap">
		<table  align="center" id="tableGroup">
			<thead>
				<tr align="center" class="table_title">
					<td id="checkCol"><input type="checkbox" id="checkAll" name="chk"></td>
					<td id="cellCol">휴대전화번호</td>
					<td id="numCol">인증번호</td>
					<td id="ipCol">아이피</td>
					<td id="timeCol">요청시각</td>
					<td id="delCol">삭제</td>
				</tr>
			</thead>
			<tbody class="table_content">	
				<tr>	
					<!-- 테이블 제목에 있는 체크박스 클릭시 전체선택되는 js구현되어있음 -->
					<td><input type="checkbox" name="chk"></td>
					<td>010-0000-0000</a></td>
					<td>12345</td>
					<td>112.218.228.29</td>
					<td>2021-12-28 21:43:33</td>
					<td><button onclick="deleteMessage()">삭제</button></td>
				</tr>
				
				<tr>	
					<td><input type="checkbox" name="chk"></td>
					<td>010-0000-0000</a></td>
					<td>784654</td>
					<td>112.241.228.123</td>
					<td>2021-12-28 21:43:33</td>
					<td><button onclick="deleteMessage()">삭제</button></td>
				</tr>
				
				<tr>	
					<td><input type="checkbox" name="chk"></td>
					<td>010-0000-0000</a></td>
					<td>354757</td>
					<td>102.11.128.29</td>
					<td>2021-12-28 21:43:33</td>
					<td><button onclick="deleteMessage()">삭제</button></td>
				</tr>
				
				<tr>	
					<td><input type="checkbox" name="chk"></td>
					<td>010-0000-0000</a></td>
					<td>213458</td>
					<td>112.218.228.29</td>
					<td>2021-12-28 21:43:33</td>
					<td><button onclick="deleteMessage()">삭제</button></td>
				</tr>
				
				<tr>	
					<td><input type="checkbox" name="chk"></td>
					<td>010-0000-0000</a></td>
					<td>697285</td>
					<td>102.218.128.29	</td>
					<td>2021-12-28 21:43:33</td>
					<td><button onclick="deleteMessage()">삭제</button></td>
				</tr>
			</tbody>	
		</table>
		</div>
		<!-- 버튼클릭시 전체선택되는 js구현되어있음 -->
		<input type="button" value="전체선택" id="check_all">
		<input type="button" value="전체해제" id="uncheck_all">
		<!-- 클릭시 alert창 띄우는 js 구현되어있음 -->
		<input type="button" value="3개월전 로그 삭제" onclick="threeMsg()">
		<input type="button" value="로그 초기화" onclick="dellogMsg()"><br><br><br>
		
		<div class="page_wrap">
			<div class="page_nation">
				<a class="arrow pprev" href="#"></a>
				<a class="arrow prev" href="#"></a>
				<a class="selectPage" href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a class="arrow next" href="#"></a>
				<a class="arrow nnext" href="#"></a>
			</div>
		</div>
	</form>
	</div>
</body>
</html>