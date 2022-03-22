<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>

<link href="/recipetoyou/Resources/User/Css/Notice2/noticeFrequencyQuestion.css"
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
			<h2>
				자주하는 질문 <span>고객님들께서 가장 자주하시는 질문을 모두 모았습니다.</span>
			</h2>
			<div class="optional">
				<a href="#none" class="listOff">선택<i class="fas fa-caret-down"></i></a>
				<ul class="choiceLayer">
					<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?faq_cate_code=1"><input type="hidden" value="1"/>배송/포장/상품</a></li>
					<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?faq_cate_code=2"><input type="hidden" value="2"/>선물하기</a></li>
					<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?faq_cate_code=3"><input type="hidden" value="3"/>주문/결제/대량주문</a></li>
					<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?faq_cate_code=4"><input type="hidden" value="4"/>취소/교환/환불</a></li>
					<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?faq_cate_code=5"><input type="hidden" value="5"/>이벤트/쿠폰/적립금</a></li>
					<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?faq_cate_code=6"><input type="hidden" value="6"/>회원</a></li>
					<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?faq_cate_code=7"><input type="hidden" value="7"/>서비스이용</a></li>
				</ul>
			</div>
		</div>

		<div class="noticeTable">
			<table>
				<tr class="th">
					<th class="num">번호</th>
					<th class="cate">카테고리</th>
					<th class="title">제목</th>
				</tr>
				<tbody class="abcd">
				<c:forEach var="notice" items="${noticeFrequencyList }">
					<tr>
						<td>${notice.faq_title }</td>
						<td>${notice.faq_code}</td>
						<td class="cont detail"><a href="#none">
						<input class="${notice.faq_title}" type="hidden" value="${notice.faq_title}"/>
						${notice.faq_info}</a></td>
						
					</tr>
					<tr class="faq ${notice.faq_title}">
						<td><img src="/recipetoyou/Resources/User/Img/Notice/market1.gif"></td>
						<td class="cont" colspan='2'>
						${notice.faq_reply}
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="page">
			<ul>
				<c:if test="${pm.prev }">
			 		<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?page=${pm.startPage-1}">&laquo;</a></li>
			 	</c:if>
			 			<!-- 페이지블럭 -->
				<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
							<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
					<li ${pm.vo.page == idx? 'class=active':''}>
					 	<a href="${contextPath}/notice/noticeFrequencyQuestion.do?page=${idx}">${idx}</a>
					</li>				
				</c:forEach>
			 			<!-- 다음next -->
			 	<c:if test="${pm.next && pm.endPage > 0}">
			 		<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do?page=${pm.endPage+1}">&raquo;</a></li>
			 	</c:if>
			</ul>
		</div>
	</div>


	<script>
		$(document).ready(function() {
			$('.listOff').click(function() {
				$('.choiceLayer').fadeToggle();
				$('ul.choiceLayer').css("top","20px");
				$('ul.choiceLayer li').css("width","162px");
			});
			
			$(".faq").css("display","none");
			
			$('.detail a').click(function() {
				var str = $(this).children().val();
				$("."+str).fadeToggle();
			
			});
		});
	</script>
</body>
</html>