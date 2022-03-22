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
	<title>뉴스레터발송관리-발송내역조회</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/Sms/searchList.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/Sms/searchList.js" charset="UTF-8"></script>
 	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css">
	
</head>
<body>
	<!-- 뉴스레터발송관리 : 발송내역조회
			상단에 뉴스레터발송/발송내역조회/메일폼설정으로 이동 가능한 a태그 박스 구현 완료
		 -->
	<div class="pageTitle">
		<!-- 뉴스레터발송 페이지로 이동 -->
		<a href="${contextPath}/ademail/sendnewsSms.do">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  				<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
			</svg>
			뉴스레터발송
		</a>
			
		<!-- 발송내역조회 페이지로 이동 -->
		<a href="${contextPath}/ademail/searchList.do">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  				<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
			</svg>
			발송내역조회
		</a>
			
		<!-- 메일폼설정 페이지로 이동 -->
		<a href="${contextPath}/ademail/setmailForm.do">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  				<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
			</svg>
			메일폼설정
		</a>
	</div>
		
	<form action="#" method="post">
		<div class="list_head">
			<table align="center" id="tableGroup">
				<tr>
					<td>
							<input type="checkbox">
							<select>
								<option value="sendDate">발송일자</option>
							</select>
							<!-- 달력 js 구현되어있음 -->
							<input type="text" id="datepicker1"> ~
  							<input type="text" id="datepicker2">
  							<!-- 기능 구현 찾아봐야함  -->
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
							<select name="searchOption">
								<option value="userId">이메일제목</option>
								<option value="userName">이메일내용</option>
							</select>
							<input type="text" name="userSearch">
							<input class="search_btn" type="button" value="검색">
					</td>
				</tr>	
			</table>
		</div>
	</form>
	
	<!-- db 활용해서 조회  -->
	<div class="middle_titleBox">
			총 21건의 발송내역이 검색되었습니다.		
	</div>
	
	<div class="send_list">
		<table align="center" id="tableGroup">
			<thead>
			<tr align="center" class="table_title">
			<!-- 테이블 제목에 있는 체크박스 클릭시 전체선택되는 js구현되어있음 -->
				<th width="6%"><input type="checkbox" id="checkAll" name="chk"></th>
				<th width="60%">이메일제목</th>
				<th width="8%">발송건수</th>
				<th width="15%">발송일시</th>
				<th width="6%">삭제</th>
			</tr>
			</thead>
			
			<tbody class="table_content">
			<tr>
				<td><input type="checkbox" name="chk"></td>
				<!-- 제목 클릭시 emailPopup.jsp 팝업창 띄우기 js 구현되어있음 -->
				<td><a href="${contextPath}/ademail/emailPopup.do" onclick="window.open(this.href,'팝업창','width=800, height=800'); return false;">[2월] 인터넷예약시 특별할인!!</a></td>
				<td>1건</td>
				<td>2021.02.04 10:40:44</td>
				<!-- 버튼 클릭시 alert창 띄우는 js 구현되어있음 -->
				<!-- db에서 삭제 기능 구현 해야함   -->
				<td><button onclick="deleteMessage()">삭제</button></td>
			</tr>
			
			</tbody>
		</table>
	</div>
		
		<!-- 버튼클릭시 전체선택되는 js구현되어있음 -->
		<input type="button" value="전체선택" id="check_all">
		<!-- 버튼클릭시 전체선택 해제되는 js구현되어있음 -->
		<input type="button" value="전체해제" id="uncheck_all"><br><br><br>
	
	<!-- 페이징 작업 해야함-->
	<div class="page_wrap">
		<div class="page_nation">
			<a class="arrow pprev" href="#"></a>
			<a class="arrow prev" href="#"></a>
			<a class="selectPage" href="#">1</a>
			<a href="#">2</a>
			<a class="arrow next" href="#"></a>
			<a class="arrow nnext" href="#"></a>
		</div>
	</div>

</body>
</html>