<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>
	<link href="/recipetoyou/Resources/User/Css/Notice2/notice.css" rel="stylesheet" type="text/css">
<!-- fontawesome 링크 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
	crossorigin="anonymous">
<!-- font 링크 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap"
	rel="stylesheet">

<body>
	<div class="content">
		<div class="title">
			<h2>
				공지사항 <span>레시피 to you의 새로운 소식들과 유용한 정보들을 한곳에서 확인하세요.</span>
			</h2>
		</div>
		<form name="frmSearch">
			<div class="Contsearch">
				<span>검색어</span> 
				<label><input name="type" type="checkbox" value="W"/>이름</label>
				<label><input name="type" type="checkbox" value="T"/>제목</label>
				<label><input name="type" type="checkbox" value="C"/>내용</label>
				<input class="searchInput" type="text" name="keyword"/>
				<a id="searchBtn"><i class="fas fa-search"></i></a>
			</div>
		</form>
		<div class="noticeTable">
			<table>
				<tr class="th">
					<th class="num">번호</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="writeDate">작성일</th>
					<th class="hit">조회</th>
				</tr>
				<c:forEach var="notice" items="${noticeList}">
					<tr>
						<td>${notice.notice_type }</td>
						<td class="titleCont"><a href="${contextPath}/notice/noticeDetail.do?notice_idx=${notice.notice_idx}">
						${notice.notice_title }</a></td>
						<td>${notice.admin_id }</td>
						<td>${notice.notice_reg_date }</td>
						<td>${notice.notice_hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<c:if test="${cnt} != 0">
				<ul>
					<c:if test="${pm.prev }">
				 		<li><a href="${contextPath}/community/communityRecipeMain.do?page=${pm.startPage-1}">&laquo;</a></li>
				 	</c:if>
				 			<!-- 페이지블럭 -->
					<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
								<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
						<li ${pm.vo.page == idx? 'class=active':''}>
						 	<a href="${contextPath}/community/communityRecipeMain.do?page=${idx}">${idx}</a>
						</li>				
					</c:forEach>
				 			<!-- 다음next -->
				 	<c:if test="${pm.next && pm.endPage > 0}">
				 		<li><a href="${contextPath}/community/communityRecipeMain.do?page=${pm.endPage+1}">&raquo;</a></li>
				 	</c:if>
				</ul>
			</c:if>
		</div>
	</div>
<script type="text/javascript">
$(document).ready(function(){
	var _type = "";
	var _typeArr = [];
	var i=0;
	$("#searchBtn").click(function(){
		var search = $(".searchSelect input:checkbox[name=type]").each(function(){
			
			if(this.checked){
				_typeArr[i] = this.value;		
			}
			i = i+1;
		});
		_typeArr= _typeArr.filter(function(item) {
			  return item !== null && item !== undefined && item !== '';
			});
		_type = _typeArr.join("");
		
		var frmSearch = document.frmSearch;
		var type = $(".searchSelect input:checkbox[name=type]");
		type = _type;
		frmSearch.method = "post";
		frmSearch.action = "${contextPath}/notice/notice.do";
		frmSearch.submit();
	});
});
</script>

</body>
</html>