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
	href="/recipetoyou/Resources/User/Css/Notice2/noticeEchoWrapFeedback.css"
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
			<h2>에코포장 피드백</h2>
			<span> 에코 박스에 대한 피드백이나 새로운 포장재에 대한 제안을 남겨주세요.<br /> 더욱 세심하게
				포장되었으면 하는 상품이 있다면 언제든 말씀주세요.<br /> 제안해 주신 의견은 담당자가 실시간으로 모니터링할 예정이나
				별도 답변 안내는 되지 않음을 양해 부탁드립니다.<br /> 배송관련, 주문(취소/교환/환불)관련 문의 및 요청 사항은
				1:1문의/카카오톡/고객센터(0000-0000)로 문의 바랍니다.<br />
			</span>
		</div>

		<div class="echoPackTable">
			<table>
				<tr class="th">
					<th class="num">번호</th>
					<th class="cate">카테고리</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="writeDate">작성일</th>
				</tr>

				<tr class="echoList1">
					<td>1</td>
					<td>[문의선택]</td>
					<td class="echoTitleTd"><a class="echoTitle" href="#none">에코포장</a></td>
					<td>market</td>
					<td>2022-01-05</td>
				</tr>
				<tr class="echoDetail1">
					<td colspan="5">
						<div>
							<span> 환경을 생각해주세요. </span>
							<div class="echoBtn">
								<button class="editBtn" type="button">수정</button>
								<button class="deleteBtn" type="button" onclick="QAdelte()">삭제</button>
							</div>
						</div>
					</td>
				</tr>

				<tr class="QAList">
					<td>1</td>
					<td>[문의선택]</td>
					<td class="echoTitleTd"><a class="echoTitle" href="#none">배송은
							새벽에 해야합니다.</a></td>
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
			<a href="${contextPath }/notice/noticeEchoWrapFeedbackDetail.do">글쓰기</a>
		</div>
	</div>


	<script>
		$(document).ready(function() {
			$('.echoList1').click(function() {
				$('.echoDetail1').fadeToggle();
			});
		});
		
		function QAdelte(){
			alert('삭제되었습니다.');
		}
	</script>
</body>
</html>