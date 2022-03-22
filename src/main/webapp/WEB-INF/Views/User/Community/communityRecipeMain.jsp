<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link href="/recipetoyou/Resources/User/Css/Community/communityRecipeMain.css"
	rel="stylesheet" type="text/css">
<!-- fontawesome 링크 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
	crossorigin="anonymous">
<!-- font 링크 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap"
	rel="stylesheet">
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel= "icon" type="image/x-icon"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div class="main">
			<div class="title">
				<h2>레시피 투 유의 추천 레시피</h2>
				<span>레시피 투 유의 새로운 소식들과 유용한 레시피를 한 곳에서 확인하세요.</span>
			</div>
			
			<div class="searchBar">
			<form name="frmSearch">
				<div class="searchSelect">
					<span>·&nbsp;검색어</span>
					<label><input name="type" type="checkbox" value="W"/>이름</label>
					<label><input name="type" type="checkbox" value="T"/>제목</label>
					<label><input name="type" type="checkbox" value="C"/>내용</label>
				</div>
				
				<div class="searchInput">
					<input type="text" name="keyword"/>
					<a id="searchBtn"><i class="fas fa-search"></i></a>
				</div>
			</form>
			</div>
			
			<div class="cateList">
					<c:forEach var="titleList" items="${cateTitleList}" varStatus="status" begin="0" end="5" >
						<div class="cateRow">
							<span class="cateType">${titleList.recipe_cate}</span>
							<c:forEach var="cateDetailList" items="${cateDetailList}" varStatus="status1">
								<c:if test="${cateDetailList.recipe_cate_parent eq status.count}">
									<c:choose>
										
											<c:when test="${cateDetailList.recipe_cate eq '전체' }">
											<div class="disInlineBlock">
												<a class="allCate cateSearch" href="${contextPath}/community/communityRecipeMain.do?cateCode=${cateDetailList.recipe_cate_code}">${cateDetailList.recipe_cate}</a>
												<input class="code" type="hidden" value="${cateDetailList.recipe_cate_code}"/>
											</div>
											</c:when>
											<c:otherwise>
											<div class="disInlineBlock">
												<a href="${contextPath }/community/communityRecipeMain.do?cateCode=${cateDetailList.recipe_cate_code}" class="cateSearch">${cateDetailList.recipe_cate}</a>
												<input class="code" type="hidden" value="${cateDetailList.recipe_cate_code}"/>
												</div>
											</c:otherwise>
										
									</c:choose>
								</c:if>
							</c:forEach> 
						</div>
					</c:forEach>
			</div>
				
			<div class="writeBtn">
				<a href="javascript:fn_articleForm('${isLogOn}','${contextPath}/login/login.do',
				'${contextPath}/community/communityRecipeWrite.do')">글쓰기</a>
			</div>
			<div class="recipeList">
				<ul>
					<c:forEach var="list" items="${recipeList}">
					<li>
						<a href="${contextPath }/community/communityRecipeDetail.do?recipe_idx=${list.recipe_idx}">
							<div class="recipeImg">
								<img src="/recipetoyou/Resources/Upload/Recipe/${list.recipe_img}">
							</div>
							<div class="detail">
								<span class="recipeTitle">${list.recipe_title}</span>
								<br/>
								<span class="writeId">${list.user_id}</span>
								<br/>
								<span class="recipeStar">
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
								</span>
								<span class="recipeReview">(57)</span>
								<span class="recipeHit">조회수 <span class="recipeHitNumber">15</span>만</span>
							</div>
						</a>
					</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="page">
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
			</div>
		</div>
	</div>
	<script>
	function fn_articleForm(isLogOn,login,recipeWrite) {
		if (isLogOn != '' && isLogOn != 'false') {
			location.href=recipeWrite;
		} 
		else {
			alert("로그인 후 글쓰기가 가능합니다.");
			location.href=login;
		}
	}
	
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
			frmSearch.action = "${contextPath}/community/communityRecipeMain.do";
			frmSearch.submit();

		});
	});
	</script>
</body>
</html>