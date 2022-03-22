<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>

<link href="/recipetoyou/Resources/User/Css/Notice2/noticeGoodsOffer.css"
	rel="stylesheet" type="text/css">
<link href="/recipetoyou/Resources/User/Css/reset.css" rel="stylesheet"
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
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<body>

	<div class="content">
		<div class="title">
			<h2>상품제안</h2>
			<span> 마켓컬리에서 추가적으로 판매되면 좋을 상품을 제안해주세요.<br /> 고객님의 의견을 발 빠르게
				반영하여 더욱 편리한 마켓컬리가 되겠습니다.<br /> 주의)알콜 제품은 법령상 온라인 판매가 불가하오니, 이 점 참고하여
				작성부탁드립니다.<br /> 담당 MD가 제안해주신 의견을 실시간으로 모니터링할 예정이나, 별도 답변 안내는 되지 않음을
				양해부탁드립니다.<br />
			</span>
		</div>

		<div class="offerTable">
			<table>
				<tr class="th">
					<th class="num">번호</th>
					<th class="cate">카테고리</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="writeDate">작성일</th>
				</tr>

				<tr class="offerList1">
					<td>1</td>
					<td>[신선식품]</td>
					<td><a class="offerTitle" href="#none">겨울 설향 딸기 판매에 관한 건</a></td>
					<td>market</td>
					<td>2022-01-05</td>
				</tr>
				<tr class="offerDetail1">
					<td colspan="5">
						<div>
							<span class="offerAnswer"> 겨울 설향 딸기를 판매해주세요.</span>
							<div class="offBtn">
								<button class="editBtn" href="">수정</button>
								<button class="deleteBtn" type="button" onclick="QAdelte()">삭제</button>
							</div>
						</div>
					</td>
				</tr>

				<tr class="offerList">
					<td>1</td>
					<td>[문의선택]</td>
					<td>배송받은 상품이 마음에 들지 않습니다.</td>
					<td>market</td>
					<td>2022-01-05</td>
				</tr>


			</table>
		</div>
		<div class="page">
			<ul>
				<li><a href="#"><i class="fas fa-angle-double-left"></i></a></li>
				<li><a href="#"><i class="fas fa-angle-left"></i></a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#"><i class="fas fa-angle-right"></i></a></li>
				<li><a href="#"><i class="fas fa-angle-double-right"></i></a></li>
			</ul>
		</div>

		<div class="writeBtn">
			<a href="${contextPath }/notice/noticeGoodsOfferDetail.do">글쓰기</a>
		</div>
	</div>


	<script src="/recipetoyou/Resources/User/Js/Notice/noticeGoodsOffer.js"></script>
</body>
</html>