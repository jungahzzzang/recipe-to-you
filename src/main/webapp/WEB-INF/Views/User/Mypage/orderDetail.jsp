<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜한 목록</title>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/mypageInfo.css"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/picklist_add.css"
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
<!-- 파비콘 링크 -->
<link href="/recipetoyou/Resources/User/Img/Mypage2/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>		
</head>
<body>
	<div class="content">
		<div class="pickadd_main">
			<div class="head">
				<h2 class="title">
					주문내역상세
				</h2>
				<div class="order_num">
					${myorderVO.ord_code}
				</div>
				
				<div class="sub_link">
					배송 또는 상품에 문제가 있나요?
					<a class="qb_link" href="${contextPath}/notice/noticeOneToOneQuestionDetail.do">1:1 문의하기</a>
				</div>
			</div>
			<!-- head -->
			<div class="pickpick">
	
					<div class="pick_add_list">		
						
						<div class="subject">
						
							<img src="/recipetoyou/Resources/Admin/Img/AdgoodsImg/${myorderVO.imageList[0].uploadPath}/s_${myorderVO.imageList[0].uuid}_${myorderVO.imageList[0].fileName}" class="orderDetail">			
						
							<div class="orderName">
								${myorderVO.prod_name}
							 </div>
							
							<div class="goods_content">
								<span class="goods_sub">
									${myorderVO.prod_content}
								</span>
							</div>
							
							<div class="goods_price">
								 <span class="goods_discountPrice">
									${myorderVO.price}원
								 </span>
								 <span class="goods_costPrice">
								 	 ${myorderVO.prod_discount}원
								 </span>
							</div> 
							
							<!-- price -->
						</div>
						<!-- subject -->
				
					</div>
					<!-- pick_add_list -->
		
				</div>
				<!-- pickpick -->
				
				<div class="order_cancle">
					<div class="inner_cancle">
						<button type="button" class="all_cart"><i class="fas fa-shopping-cart"></i>상품 담기</button>
						<a href="${contextPath}/orderCancle.do?ord_code=${myorderVO.ord_code}">
							<button type="button" class="all_cart_cancle">주문 취소</button>
						</a>
					</div>
					<p class="cancle_notice">주문취소는 ‘배송준비중’ 이전 상태일 경우에만 가능합니다.</p>
				</div>
			</div>
			<!-- pickadd_main -->
		</div>
		<!-- content -->
	
		
<script type="text/javascript">
$(document).ready(function(){
	

	/* 이미지 정보 호출 */
	let prod_code = '<c:out value="${myorderVO.prod_code}"/>';
	let uploadArea = $("#uploadArea");
										/* 여러 개의 이미지를 반환하기 때문에 이미지 정보를 배열 형태로 전달받음. */
	$.getJSON("${contextPath}/adgoods/getImageList.do", {prod_code : prod_code}, function(arr){
		
		//이미지 없는 경우 대체 이미지 출력
		if(arr.length == 0){
			
			let str = "";
			str += "<div id = 'result_card'>";
			str += "<img src='/recipetoyou/Resources/Admin/Img/SubgoodsImg/ready.jpg'>";
			str += "</div>";
			
			uploadArea.html(str);
			
			return;
		}
		
		let str = "";
		let obj = arr[0];
		
		let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
		str += "<div id='result_card'";
		str += "data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "'";
		str += ">";
		str += "<img src='${contextPath}/adgoods/getImageInfo.do?fileName=" + fileCallPath +"'>";
		str += "<input type='hidden' name='imageList[0].fileName' value='"+ obj.fileName +"'>";
		str += "<input type='hidden' name='imageList[0].uuid' value='"+ obj.uuid +"'>";
		str += "<input type='hidden' name='imageList[0].uploadPath' value='"+ obj.uploadPath +"'>";	
		str += "</div>";
		
		uploadArea.html(str);
	});	
});
	
	$(".all_cart").click(function () {
		
		var check = confirm("상품이 장바구니에 담겼습니다. 확인하시겠습니까?");
		
		if(check) {
			location.assign("cart.do");
		}
	});		
</script>
	
</body>
</html>














