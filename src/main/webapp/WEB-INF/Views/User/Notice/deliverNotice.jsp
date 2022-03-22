<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe to You :: 내일의 장보기, 레시피 투 유</title>
<!-- //recipetoyou/Resources/User/Css -->
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<!-- <link rel="stylesheet" type="text/css"
	href="/recipetoyou/Resources/User/Css/reset.css" /> -->
<link rel="stylesheet" type="text/css"
	href="/recipetoyou/Resources/User/Css/notice/notice.css" />	
<!-- slick 링크 연결 -->
<link rel="stylesheet" type="text/css" href="slick/slick.css" />
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css" />
<!-- JQuery -->	
<script type="text/javascript"
						src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/recipetoyou/Resources/User/Js/address.js"></script>						

</head>
<body>
	<div class="wrap">
		
		<div class="notice_deliver_wrap">
			<div class="notice_deliver_tit">
				<h2 class="tit">공지사항</h2>
				<p class="sub">레시피 투 유의 새로운 소식들과 유용한 정보들을 한곳에서 확인하세요.</p>
			</div>
			<!-- notice_deliver_tit -->
			
			<div id="main">
				<div class="main_tb">
					<table width="100%" align="center" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>제목</th>
								<td>마켓컬리 배송 안내</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>Recipe To You</td>
							</tr>
							
							<tr class="twos">
								<td colspan="2" class="twos_tb">
									<ul>
										<li class="write_date">
											<strong class="th">작성일</strong>
											<span class="td">2022-01-12</span>			
										</li>
										<li class="click_count">
											<strong class="th">조회수</strong>
											<span class="td">1</span>	
										</li>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>	
				</div>
				<!-- main_tb -->
			
			</div>
			<!-- main 공지사항 테이블 헤드 부분-->
			
			<div class="img_noticeview">
				<img alt="신선함을 문앞까지" src="/recipetoyou/Resources/User/Img/Notice/deliver_1.jpg">
				<img alt="샛별배송" src="/recipetoyou/Resources/User/Img/Notice/deliver_2.jpg" class="deliver_img_in">
				<img alt="한눈에 보기" src="/recipetoyou/Resources/User/Img/Notice/deliver_3.jpg" class="deliver_img_in">
				<img alt="주 7일 샛별배송" src="/recipetoyou/Resources/User/Img/Notice/deliver_4.jpg" class="deliver_img_in">
				
				<a href="#">
					<img alt="배송지역 검색" src="/recipetoyou/Resources/User/Img/Notice/deliver_5.jpg"  class="deliver_img_search">
				</a>
				
				<img alt="주 6일 샛별 배송" src="/recipetoyou/Resources/User/Img/Notice/deliver_6.jpg" class="deliver_img_in">
				<img alt="배송 이미지 하단" src="/recipetoyou/Resources/User/Img/Notice/deliver_7.jpg" class="deliver_img_bottom">
			</div>
			<!-- img_noticeview -->
			
			<div class="list_btn_wrap">
				<div class="list_btn">
					<a href="${contextPath}/notice/notice.do"><!-- notice.jsp -->
						<button type="button" class="list_click">목록</button>
					</a>
				</div>
				<!-- list_btn -->
			</div>
			<!-- list_btn_wrap -->
			
			<div class="notice_board">
				<ul>
					<li class="prev">
						<a href="" class="board_icons"><i class="fas fa-angle-up">이전글</i></a>
						<a href="#">후기게시판(Product review)과 1:1문의 게시판 운영정책</a>
					</li>
					<li class="next">
						<a href="" class="board_icons"><i class="fas fa-angle-down">다음글</i></a>
						<a href="#">냉동제품 포장방법 변경에 대한 안내의 글</a>
					</li>
				</ul>
			
			</div>
			<!-- notice_board -->
			
		</div>
		<!-- notice_deliver_wrap 전체 태그 -->

	</div>
	<!-- wrap -->
</body>
</html>