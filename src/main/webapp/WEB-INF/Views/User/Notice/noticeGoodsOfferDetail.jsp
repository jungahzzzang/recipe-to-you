<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>

<link
	href="/recipetoyou/Resources/User/Css/Notice2/noticeGoodsOfferDetail.css"
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
				반영하여 더욱 편리한 마켓컬리가 되겠습니다.<br /> 주의)알콜 제품은 법령상 온라인 판매가 불가하오니, 이 점
				참고하여 작성부탁드립니다.<br /> 담당 MD가 제안해주신 의견을 실시간으로 모니터링할 예정이나, 별도 답변 안내는
				되지 않음을 양해부탁드립니다.<br />
			</span>
		</div>

		<div class="offerWriteTable">
			<table>
				<tr class="offerTitle">
					<th>제목</th>
					<td><select>
							<option>선택해주세요.</option>
							<option>신선식품</option>
							<option>정육/달걀</option>
							<option>가공식품</option>
							<option>양념/반찬</option>
							<option>Home Dining</option>
							<option>Deli/Bakery</option>
							<option>Daily+</option>
							<option>기타</option>
					</select> <input type="text" /></td>
				</tr>

				<tr class="offerCont">
					<th>내용</th>
					<td><textarea></textarea></td>
				</tr>

				<tr class="offerImg">
					<th>이미지</th>
					<td>
						<div class="offerImgDiv1">
							<span>1</span><input class="fileupload" type="file"> <input
								id="fileUpBtn" class="fileuploadBtn" type="button"
								value="업로드 추가" /><br />
						</div>
						<div class="offerImgDiv2">
							<span>2</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove" type="button"
								value="업로드 삭제" /><br />
						</div>
						<div class="offerImgDiv3">
							<span>3</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove" type="button"
								value="업로드 삭제" /><br />
						</div>
						<div class="offerImgDiv4">
							<span>4</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove" type="button"
								value="업로드 삭제" /><br />
						</div>
						<div class="offerImgDiv5">
							<span>5</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove" type="button"
								value="업로드 삭제" /><br />
						</div>

						<div>
							<p class="txt">-파일은 최대 5개 까지만 가능합니다.</p>
						</div>
					</td>
				</tr>
			</table>
		</div>


		<div class="writeBtn">
			<a href="${contextPath }/notice/noticeGoodsOffer.do">등록</a>
		</div>
	</div>

	<script src="/recipetoyou/Resources/User/Js/Notice/noticeGoodsOfferDetail.js"></script>
</body>
</html>