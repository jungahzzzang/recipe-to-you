<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지_주문내역</title>
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="/recipetoyou/Resources/User/Css/Mypage2/review.css"
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
<link href="/recipetoyou/Resources/User/Img/Mypage2/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
		<div class="content">
			<div class="review_main">
				<div class="head">
					<h2 class="title">상품후기</h2>
					<div class="subtitle">
						<p>
							<b>후기 작성 시 사진후기100원, 글후기 50원을 적립해드립니다.</b>
						</p>
						<p>-퍼플, 더퍼플은 2배 적립(사진200원, 글100원)</p>
						<p>-주간 베스트 후기로 선정 시 5,000원을 추가 적립</p>
						<p>*후기 작성은 배송 완료일로부터 30일 이내 가능합니다.</p>
					</div>
					<!-- subtitle -->
				</div>
				<!-- head -->
				
				<table class="review_menu">
					<tr>
						<td class="review_before">작성가능 후기</td>
						<td class="review_after">작성완료 후기</td>
					</tr>
					<tr class="review_before_no">
						<td colspan="2">작성가능 후기 내역이 없습니다.</td>
					</tr>
					<tr class="review_after_no">
						<td colspan="2">
						<c:forEach var="reviewList" items="${reviewList}">
							<div class="review_prodName">
								<span>${reviewList.prod_name}</span>
							</div>
							<div class="review_box">
								<div class="review_txtBox">
									<span class="review_title">${reviewList.title}</span>
									<span class="review_date"><span>${reviewList.reg_date}</span> 작성</span>
								</div>
								<div class="prod">
									<div class="prodInfo">
										<span class="prodSub">${reviewList.content}</span>
									</div>
								</div>
							</div>
							</c:forEach>
						</td>
					</tr>
				</table>
				
				<!-- review_menu -->
			</div>
			<!-- review_main -->
		</div>
		<!-- content -->
	<script type="text/javascript">
		$(function(){ 
			$('.review_before').click(function(){
				$('.review_before').css("color","#5f0080");
				$('.review_before').css("border-bottom", "2px solid #5f0080");
				$('.review_after_no').css("display","none");
				$('.review_after').css("border-bottom", "1px solid #5f0080");
				$('.review_after').css("color","#999");
				$('.review_before_no').css("display","table-row");
			});
			$('.review_after').click(function(){
				$('.review_after').css("color","#5f0080");
				$('.review_after').css("border-bottom", "2px solid #5f0080");
				$('.review_before_no').css("display","none");
				$('.review_before').css("border-bottom", "1px solid #5f0080");
				$('.review_before').css("color","#999");
				$('.review_after_no').css("display","table-row");
			});
		});
		
	</script>
</body>
</html>






















