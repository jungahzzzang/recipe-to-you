<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link href="/recipetoyou/resources/User/Css/reset.css" rel="stylesheet"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/order.css" rel="stylesheet"
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
<link href="/recipetoyou/Resources/User/Img/Mypage2/KurlyIcon.png"
	rel="icon" type="image/x-icon" />
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
	<div class="content">
		<div class="title">
			<h2>주문서</h2>
		</div>
		<div class="orderList">
			<h2>주문상품</h2>
			<div class="box">
			<c:forEach var="list" items="${orderList}">
				<h4>${list.prodVO.prod_name} 주문합니다.</h4>
				<input type="hidden" name="price" value="${list.totalPrice }"/>
			</c:forEach>
			</div>
		</div>
		<div class="orderInfo">
			<div class="ordContainer">
				<h2>주문자 정보</h2>
				<table class="orderTable">
					<tr>
						<th>보내는분</th>
						<td>${user.user_name}</td>
					</tr>
					<tr>
						<th>휴대폰</th>
						<td>${user.user_phone}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${user.user_email}<br />이메일을 통해 주문처리과정을 보내드립니다.<br />변경은
							개인정보 수정에서 가능합니다.
						</td>
					</tr>
				</table>
			</div>

			<div class="ordContainer">
				<h2 class="deliTitle">배송정보</h2>
				<span class="deliInfo">배송 휴무일:샛별배송(휴무없음), 택배배송(일요일)</span>
				<table>
					<tr>
						<th>배송지</th>
						<td class="txtBox"><span class="basicAddress">기본배송지</span><br />
							<span class="address">${userAddr.addr }</span><br /> <span
							class="deliMethod">${userAddr.delivery_type }</span></td>
					</tr>
					<tr>
						<th>상세정보</th>
						<td><input type="text" /></td>
					</tr>
				</table>
			</div>
			<div class="baaner">
				<img src="/recipetoyou/Resources/User/Img/Order/market1.jpg" alt="" />
			</div>

			<div class="ordContainer">
				<div class="payProcess">
					<h2>쿠폰/적립금</h2>
					<table>
						<tr>
							<th>쿠폰적용</th>
							<td><select>
									<option>사용가능쿠폰<span>0</span>개/전체<span>0</span>개
									</option>
							</select> <br /> <a href="#none">쿠폰사용문의(카카오톡) > </a></td>
						</tr>
						<tr>
							<th>적립금 적용</th>
							<td>사용 가능한 적립금이 없습니다.</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="pay ordContainer">
				<h2 class="payMethod">결제 수단</h2>
				<span class="payChk"><label><input type="checkbox" />선택한
						결제 수단을 다음에도 사용</label></span>
				<table>
					<tr>
						<th>결제수단선택</th>
						<td>
							<button id="iamportPayment" class="kakaopay">
								<img class="kakaoImg"
									src="/recipetoyou/Resources/User/Img/Order/kakaopayoff.png" />
							</button>
						</td>
					</tr>
					<tr>
						<th></th>
						<td class="payment">
							<button class="cardBtn">신용카드</button>
							<button class="portBtn">간편결제</button>
							<button class="phoneBtn">휴대폰</button>
						</td>
					</tr>
					<tr class="card">
						<th></th>
						<td><select>
								<option>카드를 선택해주세요</option>
								<option>현대</option>
								<option>신한</option>
								<option>비씨</option>
								<option>국민</option>
								<option>삼성</option>
								<option>씨티</option>
								<option>롯데</option>
						</select></td>
					</tr>
					<tr class="card">
						<th></th>
						<td><select>
								<option>할부기간을 선택해주세요.</option>
						</select><br /> <span>은행계열/체크/기프트/선불/법인/개인사업자 기업카드는 무이자 할부 시 제외</span></td>
					</tr>
					<tr class="port">
						<th></th>
						<td><label><input type="radio" />차이<span>혜택</span></label> <label><input
								type="radio" />토스<span>혜택</span></label><br /> <label><input
								type="radio" />네이버페이<span>혜택</span></label> <label><input
								type="radio" />페이코<span>혜택</span></label><br /> <label><input
								type="radio" />스마일페이</label><br /> <br /> <span> 차이<br />2만원
								이상 생애 첫 결제 시 <br />3천원 즉시할인
						</span> <span> 토스<br />1만원 이상 첫 결제 시, 1천원 캐시백 즉시 적립 <br />· 1/3
								11시 ~ 1/31 24시, 기간 내 1회, 선착순 토스로 첫 결제 시 적용
						</span> <span> 네이버페이<br />5만원 이상 결제 시 2천원 네이버페이 포인트 적립<br />·
								1/18 11시 ~ 1/24 24시, 네이버페이 ID당 1회(실명인증 기준) 선착순<br />· 2월 4일까지
								취소 되지 않는 내역에 대해 2월 8일 일괄 적립
						</span> <span> 페이코<br />페이코 최대 10% 적립 + 1천원 할인쿠폰 <br />· (1) 최대
								10% 적립<br />· 1/17 11시 ~ 1/31 11시 <br />· 페이코 충전포인트로 결제할 때 마다
								페이코 포인트 최대 10% 적립 (건당 최대 2,000P) <br />· (2) 1천원 할인 쿠폰 (15,000원
								이상 구매시)<br />· 1/3 11시 ~ 2/28 24시<br />· 페이코 앱 내 쿠폰영역에서 마켓컬리
								쿠폰 다운로드 (1일 ID당 1회)
						</span></td>
					</tr>
				</table>
			</div>
			<div>
				<span class="cont">※ 카카오페이, 차이, 토스, 네이버페이, 페이코 결제 시, 결제하신
					수단으로만 환불되는 점 양해부탁드립니다.</span><br />
				<span class="cont">※고객님은 안전거래를 위해 현금 등으로 결제시 저희 쇼핑몰에서 가입한 토스
					페이먼츠의 구매안전(에스크로) 서비스를 이용하실 수 있습니다.</span>
			</div>
			<div class="bills">
				<h2>결제금액</h2>
				<div class="billBox">
					<table>
						<tr>
							<th>주문금액</th>
							<td><span class="payPrice">28,000</span>원</td>
						</tr>
						<tr class="sub">
							<th>ㄴ 상품금액</th>
							<td><span>0</span>원</td>
						</tr>
						<tr class="sub">
							<th>ㄴ 할인금액</th>
							<td>-<span>0</span>원
							</td>
						</tr>
						<tr>
							<th>배송비</th>
							<td><span>0</span>원</td>
						</tr>
						<tr>
							<th>쿠폰할인금액</th>
							<td><span>0</span>원</td>
						</tr>
						<tr>
							<th>적립금사용</th>
							<td><span>0</span>원</td>
						</tr>
						<tr>
							<th>최종결제금액</th>
							<td><span class="totalPayment">28,050</span>원</td>
						</tr>
					</table>
				</div>
			</div>
			<div>
				<div class="personAgree">
					<h2>개인정보 수집/제공</h2>
					<div class="agree">
						<label><input type="checkbox" />
							<h3 class="disNone">결제 진행 필수 동의</h3></label><br /> &nbsp;&nbsp;<span
							class="ordTxt">개인정보 수집·이용 및 처리동의<span class="grey">(필수)</span></span><a
							href="#none">보기 > </a><br /> &nbsp;&nbsp;<span class="ordTxt">전자지급
							결제대행 서비스 이용약관 동의<span class="grey">(필수)</span>
						</span><a href="#none">보기 > </a><br />
					</div>
				</div>
				<div class="announce">
					레시피 투유 에서 판매되는 상품 중에는 레시피 투유에 입점한 개별 판매자가 판매하는 마켓플레이스(오픈마켓) 상품이
					포함되어 있습니다.<br /> 마켓플레이스(오픈마켓) 상품의 경우 레시피 투유는 통신판매중개자로서 통신판매의 당사자가
					아닙니다. 레시피 투유는 해당 상품의 주문, 품질, 교환/환불 등 의무와 책임을 부담하지 않습니다.
				</div>
				<div class="ordBtn">
					<button type="submit">
						<span>5,800</span>원 결제하기
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- body -->

	<script>
		$().ready(function() {
			var flag = true;
			$('.kakaopay').click(function() {
				if (flag) $('.kakaoImg').attr('src','/recipetoyou/Resources/User/Img/Order/kakaopayon.png');
				else $('.kakaoImg').attr('src','/recipetoyou/Resources/User/Img/Order/kakaopayoff.png');
				flag = !flag;
			});
			
			$("#iamportPayment").click(function(){ 
		    	payment(); 
		    }); 
			function payment(data) {
				
				var _name = $('.box h4').text();
				var _price = $('.totalPayment').text();
				_price = removeStr(_price,",");
				
			    IMP.init('imp38939005');
			    IMP.request_pay({
			        pg: "kakaopay.TC0ONETIME", 
			        pay_method: "card",
			        merchant_uid: "iamport_test_id",
			        name: _name, 
			        amount: _price,
			        buyer_email : "test@naver.com", 
			        buyer_name : "홍길동",
			        buyer_tel : "01000000000"
			    }, function (rsp) { 
			        if (rsp.success) {
			            alert("완료 -> imp_uid : "+rsp.imp_uid+" / merchant_uid(orderKey) : " +rsp.merchant_uid);
			        } else {
			            alert("실패 : 코드("+rsp.error_code+") / 메세지(" + rsp.error_msg + ")");
			        }
			    });
			}

			$('.cardBtn').click(function() {
				$('.card').css('display', 'table-row');
				$('.port').css('display', 'none');
				$('.cardBtn').css('background', '#5f0080');
				$('.cardBtn').css('color', 'white');
				$('.portBtn').css('background', 'white');
				$('.portBtn').css('color', 'black');
			});

			$('.portBtn').click(function() {
				$('.card').css('display', 'none');
				$('.port').css('display', 'table-row');
				$('.portBtn').css('background', '#5f0080');
				$('.portBtn').css('color', 'white');
				$('.cardBtn').css('background', 'white');
				$('.cardBtn').css('color', 'black');
			});
			
			function removeStr(doc, str){
				doc = doc.replace(str,"");
				return doc;
			}
			
			var price = 0;
			
			$("input:hidden[name='price']").each(function(){
				
				var _temp = $(this).val();
				price = price + parseInt(_temp);
				$(".payPrice").text(price);
				$(".totalPayment").text(price);
			});
			
			
			
		});
	</script>
</body>
</html>