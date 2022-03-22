<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>
<link href="/recipetoyou/Resources/User/Css/Notice2/noticeDetail.css"
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
<body>
	<div class="noticeTitle">
		<h2>공지사항</h2>
		<span>컬리의 새로운 소식들과 유용한 정보들을 한곳에서 확인하세요.</span>
	</div>
	<div class="detailTable">
		<table>
			<tr>
				<th class="td1">제목</th>
				<td class="td2"><span>${noticeVO.notice_title }</span></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td class="td3"><span>${noticeVO.admin_id }</span></td>
			</tr>

			<tr>
				<td colspan="2">
					<ul>
						<li class="dateTitle">작성일</li>
						<li class="writeDate"><span>${noticeVO.notice_reg_date }</span></li>
						<li class="hitTitle">조회수</li>
						<li class="hit"><span>${noticeVO.notice_hit }</span></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td class="contentRow" colspan="3">
					<div class="content">
						${noticeVO.notice_content}
					</div>
				</td>
			</tr>
			<tr>
				<td class="btn" colspan="3"><a class="noticeList"
					href="${contextPath}/notice/notice.do">목록</a></td>
			</tr>
		</table>
	</div>
	<div class="prevNextBox">
		<ul>
			<li><strong><i class="fas fa-angle-up"></i>&nbsp;이전글</strong><a
				href="${contextPath}//notice/noticeDetail.do">[가격인상공지][피코크]순희네 빈대떡 (2022. 1. 3~)</a></li>
			<li><strong><i class="fas fa-angle-down"></i>&nbsp;다음글</strong><a
				href="${contextPath}//notice/noticeDetail.do">[마켓컬리]근무자 코로나19 확진 관련 안내</a></li>
		</ul>
	</div>
</body>
</html>