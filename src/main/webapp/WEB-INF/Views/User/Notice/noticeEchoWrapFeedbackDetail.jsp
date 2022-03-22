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
	href="/recipetoyou/Resources/User/Css/Notice2/noticeEchoWrapFeedbackDetail.css"
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
<link href="/recipetoyou/Resource/User/Img/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<body>

	<div class="content">
		<div class="title">
			<h2>에코포장 피드백</h2>
			<span> 에코 박스에 대한 피드백이나 새로운 포장재에 대한 제안을 남겨주세요.<br /> 더욱 세심하게
				포장되었으면 하는 상품이 있다면 언제든 말씀주세요.<br /> 제안해 주신 의견은 담당자가 실시간으로 모니터링할 예정이나
				별도 답변 안내는 되지 않음을 양해 부탁드립니다.<br /> 배송관련, 주문(취소/교환/환불)관련 문의 및 요청 사항은
				1:1문의/카카오톡/고객센터(0000-0000)로 문의 바랍니다.<br />
			</span>
		</div>

		<div class="offerWriteTable">
			<table>
				<tr class="offerTitle">
					<th>제목</th>
					<td><select>
							<option>선택해주세요.</option>
							<option>디자인</option>
							<option>사이즈</option>
							<option>신선도</option>
							<option>완충성</option>
							<option>분리수거</option>
							<option>포장재제안</option>
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
						<div class="offerImgDiv">
							<span>1</span><input class="fileupload" type="file"> <input
								id="fileUpBtn" class="fileuploadBtn" type="button"
								value="업로드 추가" /><br />
						</div>
						<div class="offerImgDiv1">
							<span>2</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove'+fileNo+'"
								type="button" value="업로드 삭제" /><br />
						</div>
						<div class="offerImgDiv2">
							<span>3</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove'+fileNo+'"
								type="button" value="업로드 삭제" /><br />
						</div>
						<div class="offerImgDiv3">
							<span>4</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove'+fileNo+'"
								type="button" value="업로드 삭제" /><br />
						</div>
						<div class="offerImgDiv4">
							<span>5</span><input class="fileupload" type="file">&nbsp;
							<input id="fileUp" class="fileuploadRemove'+fileNo+'"
								type="button" value="업로드 삭제" /><br />
						</div>
						<div>
							<p class="txt">-파일은 최대 5개 까지만 가능합니다.</p>
						</div>
					</td>
				</tr>
			</table>
		</div>


		<div class="writeBtn">
			<a href="${contextPath}/notice/noticeEchoWrapFeedback.do">등록</a>
		</div>
	</div>


	<script
		src="/recipetoyou/Resources/User/Js/Notice/noticeEchoWrapFeedbackDetail.js">
	</script>
</body>
</html>