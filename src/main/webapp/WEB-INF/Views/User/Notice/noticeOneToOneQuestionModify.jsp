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
	href="/recipetoyou/Resources/User/Css/Notice2/noticeOneToOneQuestionDetail.css"
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
			<h2>1:1 문의</h2>
		</div>

		<div class="offerWriteTable">
		<form name="frmOneToOne">
			<table>
				<tr class="offerTitle">
					<th class="title">제목</th>
					<td><select name="inq_title_code">
							<option>선택해주세요.</option>
							<option value="1">배송지연/불만</option>
							<option value="2">레시피패스(무료배송)</option>
							<option value="3">반품문의</option>
							<option value="4">A/S문의</option>
							<option value="5">환불문의</option>
							<option value="6">주문결제문의</option>
							<option value="7">회원정보문의</option>
							<option value="8">취소문의</option>
							<option value="9">교환문의</option>
							<option value="10">상품정보문의</option>
							<option value="11">기타문의</option>
					</select><br /> <input type="text" name="inq_title"/>
					<input type="hidden" name="user_id"/></td>
				</tr>
				<tr>
					<th>주문번호</th>
					<td><input type="text" name="ord_code" /><input type="button" value="주문조회" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="user_mail" placeholder="ezen@gmail.com" />
					<input class="ma" name="user_mail_send_agree" type="checkbox" /><span>답변수신을 이메일로 받겠습니다.</span></td>
				</tr>
				<tr>
					<th>문자메시지</th>
					<td><input type="text" name="user_phone" placeholder="010-1234-2313" />
					<input class="pa" name="user_phone_send_agree" type="checkbox" /><span>답변수신을 문자메시지로 받겠습니다.</span></td>
				</tr>

				<tr>
					<th>내용</th>
					<td>
						<p class="txt">
							<strong>1:1 문의 작성 전 확인해주세요!</strong>
						</p>
						<p class="txt">
							<strong>반품 / 환불</strong>
						</p>
						<p class="txt">제품 하자 혹은 이상으로 반품 (환불)이 필요한 경우 사진과 함께 구체적인 내용을
							남겨주세요.</p>
						<p class="txt">
							<strong>주문취소</strong>
						</p>
						<p class="txt">배송 단계별로 주문취소 방법이 상이합니다.</p>
						<p class="txt">[입금확인] 단계 : [마이컬리 > 주문내역 상세페이지] 에서 직접 취소 가능</p>
						<p class="txt">[입금확인] 이후 단계 : 고객행복센터로 문의</p>
						<p class="txt">비회원은 모바일 App 또는 모바일 웹사이트에서 [마이컬리 > 비회원 주문 조회
							페이지] 에서 취소가 가능합니다.</p>
						<p class="txt">일부 예약상품은 배송 3~4일 전에만 취소 가능합니다.</p>
						<p class="txt">주문상품의 부분 취소는 불가능합니다. 전체 주문 취소 후 재구매 해주세요.</p>
						<p class="txt">
							<strong>배송</strong>
						</p>
						<p class="txt">주문 완료 후 배송 방법(샛별 / 택배)은 변경이 불가능합니다.</p>
						<p class="txt">배송일 및 배송시간 지정은 불가능합니다. (예약배송 포함)</p>
						<p class="txt">※ 전화번호, 이메일, 주소, 계좌번호 등의 상세 개인정보가 문의 내용에 저장되지
							않도록 주의해 주시기 바랍니다.</p> <textarea name="inq_content"></textarea>
					</td>
				</tr>

			</table>
		</form>
		</div>


		<div class="writeBtn">
			<button type="submit" id="frmSubmit">저장</button>
		</div>
	</div>


	<script>
	var fileNo = 2;
	
	$('.QAList1').click(function() {
		$('.QADetail1').fadeToggle();
	});

	$("#frmSubmit").click(function(){
		var inq_title_code = frmOneToOne.inq_title_code.value;
		var ord_code = frmOneToOne.ord_code.value;
		var user_mail = frmOneToOne.user_mail.value;
		var user_mail_send_agree = frmOneToOne.user_mail_send_agree.value;
		var user_phone = frmOneToOne.user_phone.value;
		var user_phone_send_agree = frmOneToOne.user_phone_send_agree.value;
		var inq_content = frmOneToOne.inq_content.value;
		var user_id = frmOneToOne.user_id.value;
		var inq_title = frmOneToOne.inq_title.value;
		
		if(inq_title_code == null || inq_title_code == ""){
			alert("문의 종류를 선택해주세요.");
		}else if(inq_title == null || inq_title == ""){
			alert("제목을 입력해주세요.");
		}else if (user_mail == null || user_mail == ""){
			alert("메일을 입력해주세요.");
		}else if(user_phone == null || user_phone == ""){
			alert("핸드폰 번호를 입력해주세요.");
		}else if(inq_content == null || inq_content == ""){
			alert("문의 내용을 입력해주세요.");
		}else{
			var ma = $(".ma").is(':checked'); 
			if(ma){
				$(".ma").val(1);
			}
			var pa = $(".pa").is(':checked'); 
			if(pa){
				$(".pa").val(1);
			}
			frmOneToOne.method="post";
			frmOneToOne.action="${contextPath}/notice/noticeOneToOneWrite.do";
			frmOneToOne.submit();
			
		}
	});
	
			
	function QAdelte(){
		alert('삭제되었습니다.');
	}
	</script>
</body>
</html>