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
	<title>적립금관리</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
    <link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/Point/userPoint.css">
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/Point/userPoint.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
 	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css">
</head>
<body>
	
	<!-- 적립금관리 페이지
		.mainTitle : 최상단 회색 제목 박스
		.list_head : 날짜 검색 버튼이 있는 테이블
		userList_wrap : 적립금 관리 메인 테이블
		
	-->
	<div class="wrap">
		<div class="mainTitle">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  			<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>
			</svg>
			전체회원관리
		</div>
	
	
	<form action="#" method="post">
		<div class="list_head">
			<table align="center" id="tableGroup">
				<tr>
					<td>
							<input type="checkbox">
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
								<option value="phone">휴대전화</option>
								<option value="addr">주소</option>
							</select>
							<input type="text" name="userSearch">
							<input class="search_btn" type="button" value="검색">
					</td>
				</tr>	
			</table>
			</div>
			
		<div class="middle_titleBox">
			총 5명의 회원이 검색되었습니다.		
		</div>
		
		<div class="userList_wrap">
			<table align="center" id="tableGroup">
			<thead>
				<tr align="center" class="table_title">
					<td id="checkCol"><input type="checkbox" id="checkAll" name="chk"></td>
					<td id="idCol">아이디</td>
					<td id="nameCol">이름</td>
					<td id="levelCol">등급</td>
					<td id="pointCol">적립금</td>
				</tr>
			</thead>
			
			<tbody class = "table_content" >	
				<c:forEach var="listPoint" items="${listPoint}">
				
				
				<tr>  <%--  <a href="aduserInfo.jsp">${listPoint.userVO.user_id}</a> --%> 
					<td><input type="checkbox" name="chk" value="${listPoint.userVO.user_id}"></td>
					<td><a href="${contextPath}/aduser/aduserInfo.do?id=${listPoint.userVO.user_id}">${listPoint.userVO.user_id}</a></td>
					<td>${listPoint.userVO.user_name}</td>
					<td>${listPoint.userVO.user_grade}</td>
					<td>${listPoint.point}</td>
				</tr>
				
				</c:forEach>
			
				<tr>
					<td><input type="checkbox" name="chk"></td>
					<td><a href="aduserInfo.jsp">mshmsh</a></td>
					<td>김펜션</td>
					<td>더퍼플</td>
					<td>5000</td>
				</tr>
				
				<tr>
					<td><input type="checkbox" name="chk"></td>
					<td><a href="aduserInfo.jsp">c2tfiw11</a></td>
					<td>이택범</td>
					<td>프렌즈</td>
					<td>0</td>
				</tr>
			
				<tr>
					<td><input type="checkbox" name="chk"></td>
					<td><a href="aduserInfo.jsp">didrod</a></td>
					<td>양혜경</td>
					<td>일반회원</td>
					<td>1000</td>
				</tr>
			</tbody>	
		</table>
		</div>
		<div class="btnGroup">
		
		<!-- 버튼클릭시 전체선택되는 js구현되어있음 -->
		<input type="button" value="전체선택" id="check_all">
		<!-- 버튼클릭시 전체선택 해제되는 js구현되어있음 -->
		<input type="button" value="전체해제" id="uncheck_all">
		<input type="text">
		
		<select name="pointOption">
			<option>지급</option>
			<option>차감</option>
		</select>
		
		<!-- 클릭시 alert창 띄우는 js 구현되어있음 -->
		<button class="appliBtn" onclick="appliMessage()">적용</button><br><br><br>
		</div>
		
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
	
	<script type="text/javascript">

	/* 체크박스 값 넘기기 */
	function checkboxArr() {
	    var checkArr = [];     // 배열 초기화
	    $("input[name='chk']:checked").each(function(i)) {
	        checkArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
	    }
	 
	    $.ajax({
	        url: 'chk'
	        , type: 'post'
	        , dataType: 'text'
	        , data: {
	            chkValueArr: checkArr
	        }
	    });
	}
	
	</script>
</body>
</html>