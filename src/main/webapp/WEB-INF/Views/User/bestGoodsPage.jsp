<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe to You :: 내일의 장보기, 레시피투유</title>
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="/recipetoyou/Resources/User/Css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="/recipetoyou/Resources/User/Css/sparePage.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
	crossorigin="anonymous">
</head>
<body>
	<div class="body" id="content">
		<!-- body -->
		<div class="body_inn">
			<!-- body_inn -->
			<div class="top_menu">
				<h3 class="tit">베스트</h3>
			</div>
		</div>

		<div class="goods_list">
			<!-- 상품 리스트  -->
			<div class="lists">
				<p class="count">
					<span class="inner_counts">총 ${cnt}개</span>
				</p>
				<ul>
					<li class="price_asc"><a href="#">높은가격순</a></li>
					<li class="price_desc"><a href="#">낮은가격순 &#124;</a></li>
					<li class="benefit_list"><a href="#">혜택순 &#124;</a></li>
					<li class="order_list"><a href="#">판매량순 &#124;</a></li>
					<li class="new_list"><a href="#">신상품순 &#124;</a></li>
					<li class="recommand_list"><a href="#">추천순 &#124;</a></li>
				</ul>
			</div>
		</div>

			<div class="list_goods">
			<!-- list_goods -->
			<div class="inner_listgoods">
				<c:forEach var="goods" items="${goodsList}">
				
					<ul class="glists">
						<li class="image">
							<div class="image_wrap" data-prod_code="${goods.imageList[0].prod_code}" data-path="${goods.imageList[0].uploadPath}"
														data-uuid="${goods.imageList[0].uuid}" data-filename="${goods.imageList[0].fileName}">
								<a href="${contextPath}/user/goodsView.do?prod_code=${goods.prod_code}">
								
							<img src="/recipetoyou/Resources/Admin/Img/AdgoodsImg/${goods.imageList[0].uploadPath}/s_${goods.imageList[0].uuid}_${goods.imageList[0].fileName}">
							</a>
							</div>
							<div class="group_btn">
							<%-- ${} --%>
								<!-- 장바구니 아이콘 -->
								<i class="fas fa-cart-arrow-down"></i>
							</div>
							<div class="item">
								<a class="info"> <span class="name">
										${goods.prod_name }</span><br> <span class="cost">${goods.prod_price }</span><br> <br>
								</a>
							</div>
						</li>
					</ul>
				</c:forEach>
			</div>
			<c:if test="${listCheck == 'empty'}">
				<div>
					등록된 상품이 없습니다.
				</div>
			</c:if>
		</div>
		<!-- list_goods -->


		<div class="page">
				<ul>
				<c:if test="${pm != null and pm.endPage != 1}">
					<c:if test="${pm.prev }">
				 		<li><a href="${contextPath}/user/newGoodsPage.do?page=${pm.startPage-1}">&laquo;</a></li>
				 	</c:if>
				 			<!-- 페이지블럭 -->
					<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
								<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
						<li ${pm.vo.page == idx? 'class=active':''}>
						 	<a href="${contextPath}/user/newGoodsPage.do?page=${idx}">${idx}</a>
						</li>				
					</c:forEach>
				 			<!-- 다음next -->
				 	<c:if test="${pm.next && pm.endPage > 0}">
				 		<li><a href="${contextPath}/user/newGoodsPage.do?page=${pm.endPage+1}">&raquo;</a></li>
				 	</c:if>
				 	</c:if>
				</ul>
			</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
											
		//이미지 삽입
		$(".image_wrap").each(function(i, obj){
			
			const bobj = $(obj);
				if(bobj.data("prod_code")){
				
				const uploadPath = bobj.data("path");
				const uuid = bobj.data("uuid");
				const fileName = bobj.data("filename");
				
				const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
				console.log("fileCallPath:" + fileCallPath);
				
				}else {
					$(this).find("img").attr('src', '/recipetoyou/Resources/Admin/Img/SubgoodsImg/ready.jpg');
				} 
		});	
		
		});
	</script>
</body>
</html>