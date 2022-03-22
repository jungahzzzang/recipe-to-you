<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>

<link href="/recipetoyou/Resources/User/Css/Notice2/noticeBulkOrder.css"
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
					<h2>대량주문 문의</h2>
					<span>
					최소 구매금액 100만원 이상 시 해당 서비스를 이용하실 수 있습니다. ( 기준 충족 시 다중 배송 가능 )<br/>
					여러 주소지에 배송 주문 시, 주소지 1곳 당 결제금액이 4만원 미만일 경우 주소지당 개별 배송비가 발생 됩니다.<br/>
					문의를 남겨주시면 빠른 시간 내에 상담 전화 드립니다. ( ☎ 1111 - 0000, 메일 : abcd@abcd.com) <br/>
					</span>
				</div>
				<div class="orderTable">
					<table>
						<tr>
							<th>신청하는분 이름<span class="needStar">*</span></th>
							<td class="bulkOrderName"><input type="text" placeholder="신청하는 분 이름을 입력해주세요."/></td>
						</tr>
						<tr>
							<th>신청하는분 연락처<span class="needStar">*</span></th>
							<td class="bulkOrderName"><input type="text" placeholder="'-' 없이 숫자만"/></td>
						</tr>
						<tr>
							<th>신청하는분 이메일<span class="needStar">*</span></th>
							<td class="bulkOrderName"><input type="text" placeholder="abcd@example.com"/>
								<p class="warning">이메일 주소를 작성해주시면 원활한 소통이 가능합니다.</p>
							</td>
						</tr>
						<tr>
							<th>수령희망일<span class="needStar">*</span></th>
							<td class="bulkOrderName"><input type="date"/>
							<p class="warning">
								수령 희망일이 명확하지 않을 경우, 가장 빠른 예상 일자를 선택바랍니다.<br/>
								대량 주문은 모두 택배로 배송되며, 희망 수령일은 화/수/목/금/토요일 중 선택 가능합니다.(일/월요일 제외)
							</p>
							</td>
						</tr>
						<tr>
							<th>배송지</th>
							<td>
								<label><input class="bulkAddress" name="bulkAddress" type="radio"/>&nbsp;여러곳으로 수령</label>&nbsp;&nbsp;&nbsp;
								<label><input class="bulkAddress" name="bulkAddress" type="radio"/>&nbsp;한 곳으로 수령</label>
							</td>
						</tr>
						<tr>
							<th>문의사항</th>
							<td><textarea></textarea>
							<p class="warning">원활한 상담을 위해 상품명, 수량, 상담전화 희망 시간 등을 적어주세요.</p>
							</td>
						</tr>
						<tr class="lastTr">
							<th>주의사항</th>
							<td>
								아래 경우 배송이 불가합니다.<br/>
								<sub>
 								&nbsp;-제주도 및 도서산간, 상품에 따른 배송 이외지역의 경우<br/>
  								&nbsp;-수령 배송지가 명확하지 않을 경우</sub></td>
						</tr>
					</table>
				</div>
				<div class="infoAgree">
					<h2>개인정보 수집·이용 동의&nbsp;<span class="needStar">*</span> </h2>
				</div>
				<div class="agreeDetail">
					<input type="checkbox"/>&nbsp;개인정보 수집 및 이용 동의<strong>(필수)</strong>
					<a href="#">보기></a>
				</div>
				
				<div class="QASendBtn">
					<a href="${contextPath}/notice/noticeBulkOrder.do">문의하기</a>
				</div>
		
			</div>


</body>
</html>