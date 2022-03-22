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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>공지사항 관리</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
 	<link href="/recipetoyou/Resources/Admin/Css/FAQManagement/noticeList.css" rel="stylesheet">
	<link href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/AdUser/adNoticeList.js" charset="UTF-8"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css">
</head>
<body>

	<div class="mainTitle">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  			<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>
			</svg>
			공지사항 관리
		</div>
	<div class="list_head">
			<table align="center" id="tableGroup">
				<tr>
					<td>
						<div class="search_area">
							<select name="searchOption">
								<option value="I" <c:out value="${pageMaker.vo.searchOption eq 'I'?'selected':''}"/>>
								제목</option>
								<option value="S" <c:out value="${pageMaker.vo.searchOption eq 'S'?'selected':''}"/>>
								내용</option>
							</select>
							<input type="text" name="keyword" style="width: 100px" value="${pm.vo.keyword}"/>
							<button type="submit" id="searchBtn" class="btn btn-sm btn-blue">검색</button>
						</div>				
					</td>
				</tr>	
			</table>	
			</div>
		<div class="middle_titleBox">
			총 ${cnt }개의 공지사항이 조회 되었습니다.		
		</div>
		
		<div class="userList_wrap">
		<table align="center" id="tableGroup">
			<thead>
				<tr align="center" class="table_title">
					<td width="6%">
					
					<!-- 테이블 제목에 있는 체크박스 클릭시 전체선택되는 js구현되어있음 -->
					<input type="checkbox" id="checkAll" name="chk">
					
					</td>
					<td id="ordCol">고유번호</td>
					<td id="nameCol">타입</td>
					<td id="phoneCol">제목</td>
					<td id="phoneCol">내용</td>
					<td id="payCardCol">작성일</td>
					<td id="ordDateCol">작성자</td>
					<td id="delCol">삭제</td>
				</tr>
			</thead>	
				
		<tbody class="table_content">
			<c:forEach var="notice" items="${noticeList }">
				<tr align="center">
					<td><input type="checkbox" name="chk"></td>
					<td>${notice.notice_idx }</td>
					<td>${notice.notice_type }</td>
					<td>${notice.notice_title }</td>
					<td>${notice.notice_content }</td>
					<td>${notice.notice_reg_date }</td>
					<td>${notice.admin_id }</td>
					<td><button onclick="deleteMessage()"><a href="${contextPath}/adnotice/removeNotice.do?id=${notice.notice_idx}">삭제</a></button></td>
				</tr>
			</c:forEach>
		</tbody>	
		</table>
		</div>
		
		<div class="btnGroup">
			<!-- 버튼클릭시 전체선택되는 js구현되어있음 -->
			<input type="button" value="전체선택" id="check_all">
			<!-- 버튼클릭시 전체선택 해제되는 js구현되어있음 -->
			<input type="button" value="전체해제" id="uncheck_all">
		</div>
		
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
				 			<!-- 이전prev -->
				 	<c:if test="${pm.prev }">
				 		<li><a href="${pm.startPage-1}">&laquo;</a></li>
				 	</c:if>
				 			<!-- 페이지블럭 -->
					<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
								<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
						<li ${pm.vo.page == idx? 'class=active':''}>
						 	<a href="${idx}">${idx}</a>
						</li>				
					</c:forEach>
				 			<!-- 다음next -->
				 	<c:if test="${pm.next && pm.endPage > 0}">
				 		<li><a href="${pm.endPage+1}">&raquo;</a></li>
				 	</c:if>
				 </ul>
			</div>
		</div> 
		<form id="moveForm" method="get">		
			<input type="hidden" name="page" value="${pm.vo.page}">
			<input type="hidden" name="pageSize" value="${pm.vo.pageSize}">
			<input type="hidden" id="keyword" name="keyword" value="${pm.vo.keyword}">
			<input type="hidden" id="searchOption" name="searchOption" value="${pm.vo.searchOption }">
		</form>
</body>
</html>