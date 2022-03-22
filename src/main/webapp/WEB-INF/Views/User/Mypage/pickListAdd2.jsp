<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
	<div class="content">
		<div class="pickadd_main">
			<div class="head">
				<h2 class="title">
					찜한 상품
				</h2>
			</div>
			<!-- head -->
			<div class="pickpick">
			
			<c:choose>
			<c:when test="${!empty pickList}">
			
			<c:forEach var="pickList" items="${pickList}">
					<div class="pick_add_list">
													<!-- 이미지 정보가 담기도록 함. -->
						<div class="image_wrap" data-prod_code="${cartList.imageList[0].prod_code}" data-path="${cartList.imageList[0].uploadPath}"
												data-uuid="${cartList.imageList[0].uuid}" data-filename="${cartList.imageList[0].fileName}">
							<img style="height: 108px; width: 90px; padding: 10px;">
						</div>
						
						<div class="subject">
							<a href="">${pickList.prod_name}</a>
							<div class="price">
								<span class="discountRate">${pickList.prod_discount}%</span> <span class="discountPrice">3,627원</span>
								<span class="costPrice">${pickList.prod_price}원</span>
							</div>
							<!-- price -->
							<div class="${pickList.fav_flag_code} ">
							${pickList.prod_code}
								<form name="form1"  method="post" class="form1" action="${contextPath}/insertCart.do">
								<input type="hidden" name="prod_code" value="${pickList.prod_code}">
									<div class="formInfo">
										<select name ="prod_quantity">
											<c:forEach begin="1" end="10" var="i">
												<option value = '${i}'>${i}</option>
											</c:forEach>
										</select>&nbsp;개	
									</div>
								
									<div class="button_two">	<!-- 쿼리스트링으로 넘어가는 값은 파라미터=값(파라미터 이름으로 적용) -->
										<a href="${contextPath}/removePick.do?prod_name=${pickList.prod_name}">
											<button class="btn_delete">삭제</button>
										</a>
										<br/>
										
										<a href="#" onclick="">
										<button type="submit" class="btn_add">
											<i class="fas fa-shopping-cart"></i>담기
										</button>
										</a>
									</div>		
								</form>
							</div>
						</div>
						<!-- subject -->
						
						<!-- button_two -->
					</div>
					<!-- pick_add_list -->
			</c:forEach>
			</c:when>
			<c:otherwise>
				<h3 style="text:align:center">찜한 목록이 없습니다.</h3>
			</c:otherwise>
			</c:choose>
				</div>
				<!-- pickpick -->
			</div>
			<!-- pickadd_main -->
		</div>
		<!-- content -->
	
		
<script type="text/javascript">
	//이미지 삽입
	$(".image_wrap").each(function(i, obj){
				
				const bobj = $(obj);
				if(bobj.data("prod_code")){
					
					const uploadPath = bobj.data("path");
					const uuid = bobj.data("uuid");
					const fileName = bobj.data("filename");
					
					const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
					
					$(this).find("img").attr('src', '${contextPath}/adgoods/getImageInfo.do?fileName=' + fileCallPath);
					
					}else {
						$(this).find("img").attr('src', '/recipetoyou/Resources/Admin/Img/SubgoodsImg/ready.jpg');
					}
			});
	 	
	$(".btn_add").click(function () {
		var check = confirm("상품이 장바구니에 담겼습니다. 확인하시겠습니까?");
		if(check) {
			var form1 = document.querySelector(".form1");
			form1.submit();
		}else{
			return false;
		}
	});
	
	
	 
	
	
	 
	 
</script>
	
</body>
</html>














