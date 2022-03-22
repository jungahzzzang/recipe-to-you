<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
<link rel="stylesheet" href="/recipetoyou/Resources/User/Css/Mypage2/mypageInfo.css"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/orderlist.css" rel="stylesheet"
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
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>	

</head>
<body>
 	<div class="content">
		 <div class="order_main">
			<div class="head">
				<h2 class="title">
					주문 내역 <span class="subtitle">지난 3년간의 주문 내역 조회가 가능합니다</span>
				</h2>
				<select class='data_year' name="abd" id="seach_year">
					<option value='all_year' selected>전체기간</option>
					<option value='2022'>2022</option>
					<option value='2021'>2021</option>
					<option value='2020'>2020</option>
				</select>
			</div> 
			
		<!-- head -->
		<c:forEach var="orderList" items="${orderList }">
			<div class="order_list">
				<div class="order_date_wrap">
					<span class="order_date">${orderList.ord_date}</span>
				</div>
				<div class="orderlist_wrap">
					<div class="order_tit">
						<a href="${contextPath}/orderDetail.do?ord_code=${orderList.ord_code}">${orderList.prod_name}
						<i class="fas fa-chevron-right"></i>
						</a>
					</div>
					
					<div class="order_info">
						<!-- 이미지 정보가 담기도록 함. -->
						<div class="image_wrap" data-prod_code="${orderList.imageList[0].prod_code}" data-path="${orderList.imageList[0].uploadPath}"
												data-uuid="${orderList.imageList[0].uuid}" data-filename="${orderList.imageList[0].fileName}">
												

						<img src="/recipetoyou/Resources/Admin/Img/AdgoodsImg/${orderList.imageList[0].uploadPath}/s_${orderList.imageList[0].uuid}_${orderList.imageList[0].fileName}">

						<a href="${contextPath}/user/goodsView.do?prod_code=${orderList.prod_code}">
							<img src="/recipetoyou/Resources/Admin/Img/AdgoodsImg/${orderList.imageList[0].uploadPath}/s_${orderList.imageList[0].uuid}_${orderList.imageList[0].fileName}">
						</a>

						</div>
						
						<!-- order_info_img -->
						<div class="desc">
							<dl>
								<dt>주문번호</dt>
								<dd>${orderList.ord_code}</dd>
							</dl>
							<dl>
								<dt>결제금액</dt>
								<dd>${orderList.price}원</dd>
							</dl>
							<dl>
								<dt>주문상태</dt>
								<dd>${orderList.status}</dd>
							</dl>
						</div>
						<!-- desc -->	
					
					</div>
					<!-- noticeOneToOneQuestionDetail.do -->
					<!-- order_info -->
					<div class="order_status">
						<a href="${contextPath}/notice/noticeOneToOneQuestionDetail.do" class="inner_status">
						1:1 문의
						</a>
					</div>
					<!-- order_status -->
				</div>
				<!-- orderlist_wrap -->
			</div>
			<!-- order_list -->
			
		</c:forEach>		
			
		</div>
		<!-- order_main -->
	</div>
	<%--content end --%>
	<script>
	
	</script>
	
	
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
			
			$(this).find("img").attr('src', '${contextPath}/adgoods/getImageInfo.do?fileName=' + fileCallPath);
			
			}else {
				$(this).find("img").attr('src', '/recipetoyou/Resources/Admin/Img/SubgoodsImg/ready.jpg');
			}
	});
	</script>
	
	
</body>
</html>


















