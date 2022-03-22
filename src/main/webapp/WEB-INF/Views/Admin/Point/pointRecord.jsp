<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>적립금 로그</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="../../../Resources/Admin/Css/Point/pointRecord.css">
	<link rel="stylesheet" href="../../../Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../../../Resources/Admin/Js/Point/pointRecord.js" charset="UTF-8"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css">
	
</head>
<body>
	<!-- 적립금로그 페이지
		.mainTitle : 최상단 회색 제목 박스
		.list_head : 날짜 검색 버튼이 있는 테이블
		.pointList_wrap : 적립금 로그 메인 테이블
		★지급, 차감 글씨 색깔 구분해서 css수정 필요
		
	-->
	
	<div class="wrap">
		<div class="mainTitle">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  			<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>
			</svg>
			적립금로그
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
						<select name="payOption">
							<option value="pay_Option">유형</option>
							<option value="Pay">지급</option>
							<option value="Subtract">차감</option>
						</select>
						
						<select name="searchOption">
							<option value="user_Id">아이디</option>
							<option value="user_name">이름</option>
						</select>
						<input type="text" name="userSearch">
						<input class="search_btn" type="button" value="검색">
					</td>
				</tr>	
			</table>
			</div>
			
		<div class="middle_titleBox">
			총 5건의 로그가 검색되었습니다.		
		</div>
		
		<div class="pointList_wrap">
		<table  align="center" id="tableGroup">
			<thead>
				<tr align="center" class="table_title">
					<td width="6%">
					<!-- 테이블 제목에 있는 체크박스 클릭시 전체선택되는 js구현되어있음 -->
					<input type="checkbox" id="checkAll" name="chk">
					</td>
					<td id="idCol">아이디</td>
					<td id="nameCol">이름</td>
					<td id="cateCol">유형</td>
					<td id="pointCol">적립금</td>
					<td id="logCol">로그</td>
					<td id="dateCol">발생날짜</td>
				</tr>
			</thead>
				
			<tbody class = "table_content">
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<!-- 클릭시 회원정보 페이지로 넘어감 -->
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>이젠</td>
					<td>지급</td>
					<td>10</td>
					<td>상품구매 주문코드 : RANKUP_1468815394(지급)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>이젠</td>
					<td>지급</td>
					<td>10</td>
					<td>상품구매 주문코드 : RANKUP_1468815394(지급)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>이젠</td>
					<td>지급</td>
					<td>10</td>
					<td>상품구매 주문코드 : RANKUP_1468815394(지급)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>이젠</td>
					<td>지급</td>
					<td>10</td>
					<td>상품구매 주문코드 : RANKUP_1468815394(지급)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>이젠</td>
					<td>지급</td>
					<td>10</td>
					<td>상품구매 주문코드 : RANKUP_1468815394(지급)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
			</tbody>	
		</table>
		</div>	
		
		<!-- 버튼클릭시 전체선택되는 js구현되어있음 -->
		<input type="button" value="전체선택" id="check_all">
		<!-- 버튼클릭시 전체선택 해제되는 js구현되어있음 -->
		<input type="button" value="전체해제" id="uncheck_all"><br><br><br>
		
		<div class="page_wrap">
			<div class="page_nation">
				<a class="arrow pprev" href="#"></a>
				<a class="arrow prev" href="#"></a>
				<a class="selectPage" href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#">6</a>
				<a href="#">7</a>
				<a href="#">8</a>
				<a href="#">9</a>
				<a class="arrow next" href="#"></a>
				<a class="arrow nnext" href="#"></a>
			</div>
		</div>	
	</form>	
	</div>
</body>
</html>