<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../../Resources/Admin/Css/PaymentManagement/paymentManagement.css">
	<meta charset="UTF-8">
	<title>결제환경설정</title>
</head>
<body>
	<div class="wrap">
		<div class="main-content">
		
			<!-- 결제 모듈연동 확인 -->
			<form action="" method="POST" name="userComment" autocomplete="off" >
				<table class="subtitle" align="center">
					<caption>| 결제 모듈 연동(웹)</caption>
					<tr>
						<th>결제모듈선택</th>
						<td>
							<input type="radio" id="INISIS" name="CreditSelect">이니시스
							<input type="radio" id="IGISOLDERGATE" name="CreditSelect">이지스올더게이트
						</td>
					</tr>
					<tr>
						<th>상점아이디</th>
						<td>
							<input id="marketID" type="text" placeholder="아이디를 입력해주세요">
						</td>
					</tr>
					<tr>
						<th>상점 singkey</th>
						<td>
						<input id="marketKEY" type="text" placeholder="상점아이디를 입력해주세요.">
						</td>
					</tr>
					<tr>
						<th>플러그인 상점로고</th>
						<td>
							 <input type="file" name="uploadFile">
						</td>
					</tr>
					<tr>
						<th>플러그인 스킨</th>
						<td>
							<select name="selectChar">
									<option value="1">ORIGINAL</option>
									<option value="2">GREEN</option>
									<option value="3">ORANGE</option>
									<option value="4">BlUE</option>
									<option value="5">KAKKY</option>
									<option value="6">GRAY</option>
									
							</select>
						</td>
					</tr>
					<tr>
						<th>결제방법</th>
						<td>
							<label><input type="checkbox" name="CreditMethod" value="creditcard"> 신용카드</label>
      						<label><input type="checkbox" name="CreditMethod" value="cellurPhone"> 휴대폰결제</label>
      						<label><input type="checkbox" name="CreditMethod" value="accountTransfer"> 실시간계좌이체</label>
      						<label><input type="checkbox" name="CreditMethod" value="depositor"> 무통장입금</label>
      						
						</td>
					</tr>
					<tr>
						<th>에스크로 결제</th>
						<td>
							<input type="radio" id="ascroUse" name="use">사용함
							<input type="radio" id="ascroNoUse" name="noUse">사용안함
						</td>
					</tr>
					<tr>
						<th>에스크로 상점아이디</th>
						<td>
							<input id="marketKEY" type="text" placeholder="에스크로 상점아이디를 입력해주세요.">
						</td>
					</tr>
					<tr>
						<th>상점 signkey(에스크로)</th>
						<td>
							<input id="ascroMarketKEY" type="text" placeholder="상점 signKey를 입력해주세요.">
						</td>
					</tr>
					<tr>
						<th>에스크로 결제금액</th>
						<td>
							<input id="ascroPayAmount" type="text">
						</td>
					</tr>
					<tr>
						<th>에스크로 결제방법</th>
						<td>
							<label><input type="checkbox" name="CreditMethod" value="creditcard"> 신용카드</label>
      						<label><input type="checkbox" name="CreditMethod" value="accountTransfer"> 실시간계좌이체</label>
						</td>
					</tr>
					<tr>
						<th>모바일 아이디</th>
						<td>
							<input type="text" >
						</td>
					</tr>
					<tr>
						<th>모바일 결제방식</th>
						<td>
							<label><input type="checkbox" name="CreditMethod" value="creditcard"> 신용카드</label>
      						<label><input type="checkbox" name="CreditMethod" value="cellurPhone"> 휴대폰결제</label>
      						<label><input type="checkbox" name="CreditMethod" value="depositor"> 무통장입금</label>
						</td>
					</tr>
					<tr>
						<th>상점관리</th>
						<td>승인내역조회/승인취소/상점관리</td>
					</tr>
					<tr  height="20">
						<td>
							<button type="submit" >보내기</button>
						</td>	
					</tr>	
				</table>
				
				<tr height="20">
					<td></td>
				</tr>
				<!--은행 계좌관리 테이블  -->
				<table class="subtitle" align="center">
					
					<tr height="24">
						<td>
							<span>| 은행 계좌 관리</span>
							<span id="tip">+무통장 입금 선택시 출력</span>
						</td>
					</tr>
					
				</table>
			</form>
				<table>
					<tr>
						<th>
							<td></td>
							<td>순서</td>
							<td>은행명</td>
							<td>계좌번호</td>
							<td>예금주</td>
							<td>삭제</td>
							<td></td>
						</th>
						<td>
						</td>
					</tr>
					<tr></tr>
				
				</table>
			<form>
				<input type="hidden" name="mode" value="#">
				
			</form>
		</div>
	</div>
</body>
</html>