<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<link href="/recipetoyou/Resources/User/Css/Notice2/sideMenu.css" rel="stylesheet" type="text/css">
<div class="sideMenu">
	<h2>고객센터</h2>
	<ul>
		<li><a href="${contextPath}/notice/notice.do">공지사항<i class="fas fa-chevron-right"></i></a></li>
		<li><a href="${contextPath}/notice/noticeFrequencyQuestion.do">자주하는 질문<i class="fas fa-chevron-right"></i></a></li>
		<li><a href="javascript:fn_articleForm('${isLogOn}','${contextPath}/login/login.do','${contextPath}/notice/noticeOneToOneQuestion.do')">
		1:1문의<i class="fas fa-chevron-right"></i></a></li>
		<li><a href="javascript:fn_articleForm('${isLogOn}','${contextPath}/login/login.do','${contextPath}/notice/noticeBulkOrder.do')">
		대량주문 문의<i class="fas fa-chevron-right"></i></a></li>
		<li><a href="javascript:fn_articleForm('${isLogOn}','${contextPath}/login/login.do','${contextPath}/notice/noticeGoodsOffer.do')">
		상품제안<i class="fas fa-chevron-right"></i></a></li>
		<li><a href="javascript:fn_articleForm('${isLogOn}','${contextPath}/login/login.do','${contextPath}/notice/noticeEchoWrapFeedback.do')">
		에코포장 피드백<i class="fas fa-chevron-right"></i></a></li>
		<li class="oneToOneFaq"><a href="javascript:fn_articleForm('${isLogOn}','${contextPath}/login/login.do',
		'${contextPath}/notice/noticeOneToOneQuestion.do')"><span>도움이 필요하신가요?<br />
				<small>1:1문의하기</small></span><i class="fas fa-chevron-right"></i></a></li>
	</ul>
</div>
<script>
function fn_articleForm(isLogOn,login,noticeRead) {
		if (isLogOn != '' && isLogOn != 'false') {
			location.href=noticeRead;
		} 
		else {
			alert("로그인을 먼저 해주세요!");
			location.href=login;
		}
	}
</script>