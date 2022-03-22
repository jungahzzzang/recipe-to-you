<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>

<link
	href="/recipetoyou/Resources/User/Css/Notice2/noticeOneToOneQuestion.css"
	rel="stylesheet" type="text/css">
<link href="/recipetoyou/Resources/User/Css/reset.css" rel="stylesheet"
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
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<body>

	<div class="content">
		<div class="title">
			<h2>1:1문의</h2>
		</div>

		<div class="oneToOneQATable">
			<table>
				<tr class="th">
					<th class="num">번호</th>
					<th class="cate">카테고리</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="writeDate">작성일</th>
				</tr>
				
				<c:choose>
				<c:when test="${cnt != 0}">
				<c:forEach var="list" items="${noticeOneToOneList }">
					<tr class="QAList1">
						<td class="rn">${list.rn }</td>
						<td>${list.inq_title_code }</td>
						<td>${list.inq_title }</td>
						<td>${list.user_id }</td>
						<td>${list.inq_date}</td>
					</tr>
					
					<tr class="QADetail1" id="${list.rn }">
						<td colspan="5">
							<div>
								<span>${list.inq_content}</span>
								<div class="QABtn">
									<button class="editBtn" type="button">수정</button>
									<button class="deleteBtn" type="button" onclick="QAdelte('${list.inq_idx}'">삭제</button>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
				<tr class="noneQnA">
					<td colspan="5">1:1문의 내역이 존재하지 않습니다.</td>
				</tr>
				</c:otherwise>
				</c:choose>


			</table>
		</div>
		<div class="page">
			<c:if test="${cnt  != 0}">
				<ul>
					<c:if test="${pm.prev }">
				 		<li><a href="${contextPath}/notice/noticeOneToOneQuestion.do?page=${pm.startPage-1}">&laquo;</a></li>
				 	</c:if>
				 			<!-- 페이지블럭 -->
					<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
								<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
						<li ${pm.vo.page == idx? 'class=active':''}>
						 	<a href="${contextPath}/notice/noticeOneToOneQuestion.do?page=${idx}">${idx}</a>
						</li>				
					</c:forEach>
				 			<!-- 다음next -->
				 	<c:if test="${pm.next && pm.endPage > 0}">
				 		<li><a href="${contextPath}/notice/noticeOneToOneQuestion.do?page=${pm.endPage+1}">&raquo;</a></li>
				 	</c:if>
				</ul>
			</c:if>
		</div>

		<div class="writeBtn">
			<a href="${contextPath}/notice/noticeOneToOneQuestionDetail.do">글쓰기</a>
		</div>
	</div>


	<script>
			$(document).ready(function() {
				$('.QAList1').click(function() {
					var temp = $(this).children(".rn").text();
					$('#'+temp).fadeToggle();
				});
			});
			
			function QAdelte(idx){
				
			}
	</script>
</body>
</html>