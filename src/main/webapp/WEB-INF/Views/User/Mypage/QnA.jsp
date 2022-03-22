<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지_주문내역</title>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/mypageInfo.css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="/recipetoyou/Resources/User/Css/Mypage2/QnA.css"
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
<script type="text/javascript" src="/recipetoyou/Resources/User/Js/Mypage/userQnA.js" charset="UTF-8"></script>
<body>
	<form action="" method="post" name="delForm">
		<div class="content">
			<div class="review_main">
				<div class="head">
					<h2 class="title">상품문의</h2>
					<ul>
						<li>· 상품에 대한 문의를 남기는 공간입니다. 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로 이동될 수 있습니다.</li>
						<li>· 배송관련, 주문(취소/교환/환불)관련 문의 및 요청사항은 마이컬리 내
						<a href="${contextPath}/notice/noticeOneToOneQuestionDetail.do">1:1문의</a>에 남겨주세요.
						</li>
					</ul>
				</div>
				<!-- head -->
				<table class="QnA_main">
					<tr>
						<th class="title">제목</th>
						<th class="date">작성일</th>
						<th class="reply">답변상태</th>
					</tr>
				</table>
				<!-- QnA_main -->
				<c:forEach var="qnaList" items="${qnaList}">
				<table class="QnA_content">
					<tr>
						<td class="content_prodName">${qnaList.prod_name}</td>
						<td class="content_title" onclick="Open()">${qnaList.inq_title}</td>
						<td class="content_date">${qnaList.inq_reg_date}</td>
							<c:choose>
								<c:when test="${qnaList.inq_level eq 1 }">
								<td class="content_reply">답변 완료</td>
								</c:when>
							<c:when test="${qnaList.inq_level ne 1 }">
								<td class="content_reply">답변 대기</td>
							</c:when>
							</c:choose>
					</tr>
				</table>
				<div id="content">
					<span>${qnaList.inq_content}</span>
					<div class="btn">
						<a href="" id="btn-edit" onclick="">수정</a>
						<a href="${contextPath}/removeQnA.do?prod_inq_code=${qnaList.prod_inq_code}" id="btn-remove" onclick="remove_QnA()">삭제</a>
					</div>
				</div>
				</c:forEach>
				<!-- QnA_content -->
				<div class="paging_navi">
					<button type="button" class="paging_prev">
						<i class="fas fa-chevron-left"></i>
					</button>
					<button type="button" class="paging_next">
						<i class="fas fa-chevron-right"></i>
					</button>
				</div>
				<!-- paging_navi -->
			</div>
			<!-- review_main -->
		</div>
		<!-- content -->
	</form>

	
</body>
</html>












