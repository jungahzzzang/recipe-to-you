<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/mypageSideMenu.css">
<div class="sidemenu">
	<h2 class="side_title">마이 레시피</h2>
	<ul>
		<li class="order"><a href="${contextPath}/orderList.do">주문내역
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="gift"><a href="${contextPath}/giftList.do">선물내역
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="pick"><a href="${contextPath}/picklist_add.do">찜한상품
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="address"><a href="${contextPath}/addresslist.do">배송지관리
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="review" id="review"><a href="${contextPath}/review.do">상품 후기
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="QandA"><a href="${contextPath}/QnA.do">상품 문의
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="point"><a href="${contextPath}/point.do">적립금
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="coupon"><a href="${contextPath}/coupon.do">쿠폰
			<i class="fas fa-chevron-right"></i></a></li>
		<li class="userInfo"><a href="${contextPath}/mypageUserInfoPwdCheck.do">개인 정보 수정
			<i class="fas fa-chevron-right"></i>
		</a></li>
	</ul>
	<div class="inquiry">
		<a href="${contextPath}/notice/noticeOneToOneQuestionDetail.do">
			<span class="help">도움이 필요하신가요?</span><br>
			<p>1:1 문의하기</p> <i class="fas fa-chevron-right"></i>
		</a>
	</div>
</div>
