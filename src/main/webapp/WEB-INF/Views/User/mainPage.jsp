<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe to You :: 내일의 장보기, 레시피투유</title>
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<!-- slick 링크 연결 -->
<link rel="stylesheet" type="text/css" href="/recipetoyou/Resources/Common/slick/slick.css" />
<link rel="stylesheet" type="text/css" href="/recipetoyou/Resources/Common/slick/slick-theme.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="/recipetoyou/Resources/Common/slick/slick.min.js"></script>

</head>
<body>

	<div class="banner">
		<!-- banner -->
		<div class="banner-img">
			<div>
				<a href="#"><img alt="main1"
					src="/recipetoyou/Resources/User/Img/main1.jpg"></a>
			</div>
			<div>
				<a href="#"><img alt="main1"
					src="/recipetoyou/Resources/User/Img/main2.jpg"></a>
			</div>
			<div>
				<a href="#"><img alt="main1"
					src="/recipetoyou/Resources/User/Img/main3.jpg"></a>
			</div>
		</div>
		<!-- banner js 부분 -->


		<script type="text/javascript">
			$('.banner-img').slick({
				infinite : true,
				slidesToShow : 1,
				autoplay : true,
				autoplayspeed : 1800
			});
		</script>

		<div class="main">
			<!-- main -->
			<div class="item1">
				<!-- item1 -->
				<div class="item_how">
					<!-- .item-how -->
					<b>이 상품은 어때요?</b>
				</div>
				
				<div class="how_goods">	
 				<!-- goods_info 태그 - 상품 리스크 상위 태그 -->
 					<c:forEach var="goods" items="${goodsInfo}" >
						<div class="goods_info">
							
							<div class="image_wrap" data-prod_code="${goods.imageList[0].prod_code}" data-path="${goods.imageList[0].uploadPath}"
												data-uuid="${goods.imageList[0].uuid}" data-filename="${goods.imageList[0].fileName}">

									<a href="${contextPath}/user/goodsView.do?prod_code=${goods.prod_code}">
								
							<img src="/recipetoyou/Resources/Admin/Img/AdgoodsImg/${goods.imageList[0].uploadPath}/s_${goods.imageList[0].uuid}_${goods.imageList[0].fileName}">
	
									</a>
							</div>
							<p>
								<span class="name">${goods.prod_name}</span>
								<span id="goodsCost" class="goodsCost">${goods.prod_price}</span>원
							</p>
						</div>
					</c:forEach>	
				</div>
				
				<script type="text/javascript">
				// 숫자 타입에서 쓸 수 있도록 format() 함수 추가
				Number.prototype.format = function(){
				    if(this==0) return 0;

				    var reg = /(^[+-]?\d+)(\d{3})/;
				    var n = (this + '');

				    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');

				    return n;
				};

				// 문자열 타입에서 쓸 수 있도록 format() 함수 추가
				String.prototype.format = function(){
				    var num = parseFloat(this);
				    if( isNaN(num) ) return "0";

				    return num.format();
				};
				
				jQuery('.goodsCost').text(function() {
				    jQuery(this).text(
				        jQuery(this).text().format()
				    );
				});
				</script>
				
				<!-- how_goods 닫힌 태그 -->
 
			
				<div class="arrowSlider">
						<span class="prev" id="aro1_prev"><i class="fas fa-angle-left"></i></span> 
						<span class="next" id="aro1_next"><i class="fas fa-angle-right"></i></span>
				</div>

				<!-- how_goods 페이징 기능.js -->
					<script type="text/javascript">
											$('.how_goods').slick({
												slidesToShow : 4,
												slidesToScroll : 1,
												dots : false,
												arrows : true,
												infinite : true,
												autoplay : false,
												speed : 500,
												prevArrow : $('#aro1_prev'),
												nextArrow : $('#aro1_next'),
												autoplaySpeed : 3000
											});
					</script>
			</div>
			<!-- item1 닫힌 태그 -->


			<div class="beef">
				<!-- 고기 광고 -->
				<div class="beef_img">
					<a href="#"><img alt="beef" src="/recipetoyou/Resources/User/Img/beefb.jpg"></a>
				</div>
			</div>


		<div class="item2">
		<!-- 	item_price 코드 시작 -->
			
				<div class="item_price">
					<b>놓치면 후회할 가격 > </b>
				</div>
			<!-- 	item_price 태그 상품이미지 리스트 포함 -->
					
			<!-- 	price_goods 태그 - 상품 리스크 상위 태그 -->
				<div class="price_goods">
				
 				<!-- goods_info 태그 - 상품 리스크 상위 태그 -->
 					<c:forEach var="bargain" items="${bargain}" >
						<div class="goods_info">
							<div class="image_wrap" data-prod_code="${bargain.imageList[0].prod_code}" data-path="${bargain.imageList[0].uploadPath}"
												data-uuid="${bargain.imageList[0].uuid}" data-filename="${bargain.imageList[0].fileName}">
								<a href="${contextPath}/user/goodsView.do?prod_code=${bargain.prod_code}">
									<img src="/recipetoyou/Resources/Admin/Img/AdgoodsImg/${bargain.imageList[0].uploadPath}/s_${bargain.imageList[0].uuid}_${bargain.imageList[0].fileName}">
								</a>
							</div>	
						
							<p>
								<span class="name">${bargain.prod_name}</span>
								<span id="bargain" class="bargain">${bargain.prod_price}</span>원
							</p>
						</div>
					</c:forEach>	
				</div>
				
				<script type="text/javascript">
				// 숫자 타입에서 쓸 수 있도록 format() 함수 추가
				Number.prototype.format = function(){
				    if(this==0) return 0;

				    var reg = /(^[+-]?\d+)(\d{3})/;
				    var n = (this + '');

				    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');

				    return n;
				};

				// 문자열 타입에서 쓸 수 있도록 format() 함수 추가
				String.prototype.format = function(){
				    var num = parseFloat(this);
				    if( isNaN(num) ) return "0";

				    return num.format();
				};
				
				jQuery('.bargain').text(function() {
				    jQuery(this).text(
				        jQuery(this).text().format()
				    );
				});
				</script>
				
				<!-- price_goods 닫힌 태그 -->
				
				
				<div class="arrowSlider">
						<span class="prev" id="aro2_prev"><i class="fas fa-angle-left"></i></span> 
						<span class="next" id="aro2_next"><i class="fas fa-angle-right"></i></span>
				</div>
		

			<!-- 	price_goods 페이징 기능.js -->
				<script type="text/javascript">
						$('.price_goods').slick({
							
							slidesToShow : 4,
							slidesToScroll : 1,
							dots : false,
							arrows : true,
							infinite : true,
							autoplay : false,
							speed : 500,
							prevArrow : $('#aro2_prev'),
							nextArrow : $('#aro2_next'),
							autoplaySpeed : 3000
											});
				</script>

			</div>
			<!-- item2 딛힌 태그  -->

			<!-- 새벽 배송 광고 -->
			<div class="dawn_delivery">
				<div class="dawn_ads">
					<a><img alt="dawn ads"
						src="/recipetoyou/Resources/User/Img/dawnAds.jpg"></a>
				</div>
			</div>
			<!-- dawn_delivery -->
			
			
			<div class="review">
				<div class="review_list">
					<span class="customer_review">고객 후기</span> <span
						class="review_more">더 많은 후기가 궁금하다면?</span>
					<div class="review_photo">					
							<img alt="후기1" src="/recipetoyou/Resources/User/Img/Review/1.jpg">
							<img alt="후기2" src="/recipetoyou/Resources/User/Img/Review/2.jpg">
							<img alt="후기3" src="/recipetoyou/Resources/User/Img/Review/3.jpg">
							<img alt="후기4" src="/recipetoyou/Resources/User/Img/Review/4.jpg">
							<img alt="후기5" src="/recipetoyou/Resources/User/Img/Review/5.jpg">
							<img alt="후기6" src="/recipetoyou/Resources/User/Img/Review/6.jpg">
							<img alt="후기7" src="/recipetoyou/Resources/User/Img/Review/7.jpg">
							<img alt="후기8" src="/recipetoyou/Resources/User/Img/Review/8.jpg">
							<img alt="후기9" src="/recipetoyou/Resources/User/Img/Review/9.jpg">
							<img alt="후기10" src="/recipetoyou/Resources/User/Img/Review/10.jpg">
					</div>
				</div>
				<!-- review_list -->

				<!-- 고객 후기 paging -->
				<div class="arrowSlider2">
						<span class="prev3" id="aro3_prev"><i class="fas fa-angle-left"></i></span> 
						<span class="next3" id="aro3_next"><i class="fas fa-angle-right"></i></span>
				</div>


				<!-- 고객 후기 paging.js -->
				 <script type="text/javascript">
						$('.review_photo').slick({
							
							slidesToShow :6,
							slidesToScroll : 1,
							dots : false,
							arrows : true,
							infinite : true,
							autoplay : false,
							speed : 500,
							prevArrow : $('#aro3_prev'),
							nextArrow : $('#aro3_next'),
							autoplaySpeed : 3000
											});
				</script>


				<div class="move">
					<div class="move_comu">
						<span class="review_more2">더 많은 후기가 궁금하다면?</span><br>
						 <a	href="${contextPath }/community/communityRecipeMain.do"><span>커뮤니티 바로가기</span></a>
					</div>
				</div>
				<!-- move-->
			</div>
			<!-- review 닫힌 태그 -->
		</div>
		<!-- main 닫힌 테그 -->
	</div>
	<!-- banner 닫힌 테그 -->

	<script type="text/javascript">
		$(document).ready(function(){						
			//이미지 삽입
			$(".image_wrap").each(function(i, obj){
				
				const bobj = $(obj);
				console.log(bobj.attr("class"));
				if(bobj.data("prod_code")){
					
					const uploadPath = bobj.data("path");
					const uuid = bobj.data("uuid");
					const fileName = bobj.data("filename");
					
					const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
					
					//$(this).find("img").attr('src', '${contextPath}/user/getImageInfo.do?fileName='+fileCallPath);
					
				} else {
					$(this).find("img").attr('src', '/recipetoyou/Resources/Admin/Img/SubgoodsImg/ready.jpg');
				}
			});	
		}); 
	</script>
</body>
</html>


