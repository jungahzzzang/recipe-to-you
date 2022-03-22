<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="/recipetoyou/Resources/User/Css/Community/communityRecipeDetail.css"
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

		<div class="recipeBox">
			<div class="thumbnail">
				
				<img src="/recipetoyou/Resources/Upload/Recipe/${recipeVO.recipe_img}"/>
			</div>
			<div class="userName">
				<h3>${recipeVO.user_id }</h3>
				<h2>${recipeVO.recipe_title}</h2>
			</div>
			<div class="cookingImg">
				<h3>${recipeVO.recipe_content}</h3>
				
			</div>
			
			<div class="relativeItem">
				<h4>레시피와 관련된 상품</h4>
				<ul>
					<li>
						<a href="#none">
							<div class="goods">
								<img src="/recipetoyou/Resources/User/Img/goods4.jpg">
								<span>제품명</span><br/>
								<span>6,500</span>원<br/>
							</div>
						</a>
					</li>
					<li>
						<a href="#none">
							<div class="goods">
								<img src="/recipetoyou/Resources/User/Img/goods4.jpg">
								<span>제품명</span><br/>
								<span>6,500</span>원<br/>
							</div>
						</a>
					</li>
					<li>
						<a href="#none">
							<div class="goods">
								<img src="/recipetoyou/Resources/User/Img/goods4.jpg">
								<span>제품명</span><br/>
								<span>6,500</span>원<br/>
							</div>
						</a>
					</li>
					<li>
						<a href="#none">
							<div class="goods">
								<img src="/recipetoyou/Resources/User/Img/goods4.jpg">
								<span>제품명</span><br/>
								<span>6,500</span>원<br/>
							</div>
						</a>
					</li>
				</ul>
			</div>
			
			<div class="cookingReview">
				
				<h4>댓글 <strong>${cnt}</strong></h4>
				<c:forEach var="recipeReviewVO" items="${recipeReviewVO}">
				<div class="cookCont">
					
						<span class="userID">${recipeReviewVO.user_id}</span>
						<span class="regDate">${recipeReviewVO.reg_date }</span> 							
						<span class="recipeStar">
							<c:forEach begin="1" end="${recipeReviewVO.recipe_star}">
								<i class="fas fa-star"></i>
							</c:forEach>
						</span><br/>
						<span class="cookContent">
							${recipeReviewVO.content }
						</span>
					
				</div>
				</c:forEach>
				
				<div class="reviewForm">
					<form name="frmRecipeReview">
					<span class="star-input">
						<span class="input">
					    	<input type="radio" name="star-input" value="1" id="p1">
					    	<label for="p1">1</label>
					    	<input type="radio" name="star-input" value="2" id="p2">
					    	<label for="p2">2</label>
					    	<input type="radio" name="star-input" value="3" id="p3">
					    	<label for="p3">3</label>
					    	<input type="radio" name="star-input" value="4" id="p4">
					    	<label for="p4">4</label>
					    	<input type="radio" name="star-input" value="5" id="p5">
					    	<label for="p5">5</label>
					  	</span>
					  	<output for="star-input"><b>0</b>점</output>						
					</span>
					<input type="text" name="content" class="content"/>
					<button type="button" id="review_write" 
					onclick="fn_articleForm('${isLogOn}','${contextPath}/login/login.do','${contextPath}/community/communityRecipeDetail.do')">댓글쓰기</button>
					<input class="recipe_star" type="hidden" name="recipe_star"/>
					<input type="hidden" name="user_id" value="${user_id}"/>
					<input type="hidden" name="recipe_idx" value="${recipeVO.recipe_idx}"/>
					</form>
				</div>
				
			</div>
			
		</div>
		
		<div class="page">
			<ul>
				<c:if test="${pm.prev }">
			 		<li><a href="${contextPath}/community/communityRecipeDetail.do?recipe_idx=${recipeVO.recipe_idx}&page=${pm.startPage-1}">&laquo;</a></li>
			 	</c:if>
			 			<!-- 페이지블럭 -->
				<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
							<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
						<li ${pm.vo.page == idx? 'class=active':''}>
						 	<a href="${contextPath}/community/communityRecipeDetail.do?recipe_idx=${recipeVO.recipe_idx}&page=${idx}">${idx}</a>
						</li>			
				</c:forEach>
			 			<!-- 다음next -->
			 	<c:if test="${pm.next && pm.endPage > 0}">
			 		<li><a href="${contextPath}/community/communityRecipeDetail.do?recipe_idx=${recipeVO.recipe_idx}&page=${pm.endPage+1}">&raquo;</a></li>
			 	</c:if>
			</ul>
		</div>

		<c:if test="${recipeVO.user_id eq user_id}">
			<div class="BtnBox">
					<a href="${contextPath}/community/communityRecipeModify.do?recipe_idx=${recipeVO.recipe_idx}">수정</a>
					<a href="${contextPath}/community/communityRecipeDelete.do?recipe_idx=${recipeVO.recipe_idx}">삭제</a>
			</div>
		</c:if>
		<script>
		var starRating = function(){
			var $star = $(".star-input"),
			    $result = $star.find("output>b");
				
			  	$(document)
				.on("focusin", ".star-input>.input", 
					function(){
			   		 $(this).addClass("focus");
			 	})
					 
			   	.on("focusout", ".star-input>.input", function(){
			    	var $this = $(this);
			    	setTimeout(function(){
			      		if($this.find(":focus").length === 0){
			       			$this.removeClass("focus");
			     	 	}
			   		}, 100);
			 	 })
			  
			    .on("change", ".star-input :radio", function(){
			    	$result.text($(this).next().text());
			  	})
			    .on("mouseover", ".star-input label", function(){
			    	$result.text($(this).text());
			    })
			    .on("mouseleave", ".star-input>.input", function(){
			    	var $checked = $star.find(":checked");
			    		if($checked.length === 0){
			     	 		$result.text("0");
			   		 	} else {
			     	 		$result.text($checked.next().text());
			    		}
			  	});
			};

			starRating();
			
function fn_articleForm(isLogOn,login,recipeWrite) {
	if (isLogOn != '' && isLogOn != 'false') {
		var star = $(".input").find("input[name=star-input]:checked").val();
		
		var content = frmRecipeReview.content.value;
		var recipe_star = frmRecipeReview.recipe_star;
		$(".recipe_star").val(star);
		if(content == "" || content == null){
			alert("댓글을 입력해주세요.");
		}else if(recipe_star == 0 || recipe_star == null || recipe_star == undefined){
			alert("별점을 입력해주세요.");
		}else{
			frmRecipeReview.method="post";
			frmRecipeReview.action = "${contextPath}/community/communityRecipeReviewWrite.do";
			frmRecipeReview.submit();
		}
		
	}else {
		alert("로그인 후 글쓰기가 가능합니다.");
		location.href=login;
	}
}
	
		</script>
</body>
</html>