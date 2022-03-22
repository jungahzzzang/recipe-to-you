<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
	type="text/css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/cart.css"
	rel="stylesheet" type="text/css">
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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    
</head>
<body>
	<div class="body">
		<div class="title">
			<h2>장바구니</h2>
		</div>
		<!-- title -->

	
		<div class="content">
			<div class="cart_main">
				<div class="cart_select">
					<label> 
						<input type="checkbox" name="checkItem" value="selectall" onclick="selectAll(this)"> 
						<span>전체선택(1/<span class="checkboxLength">1</span>)</span>
					</label>
				</div>
				<!-- cart_select -->
	
			<!-- 장바구니 비어있는 경우 -->
			<c:choose>
				<c:when test="${map.count == 0 }">
					장바구니가 비어있습니다.
				</c:when>
				<c:otherwise>
		
		
					<c:forEach var="cartList" items="${cartList}" varStatus="i">	
							<div class="cartlist">
								<label class="inn_check"> 
									<input type="checkbox" name="checkItem" >
								</label>
					
							<div class="item">
								<!-- 이미지 정보가 담기도록 함. -->
								<div class="image_wrap" data-prod_code="${cartList.imageList[0].prod_code}" data-path="${cartList.imageList[0].uploadPath}"
									data-uuid="${cartList.imageList[0].uuid}" data-filename="${cartList.imageList[0].fileName}">
									<img style="height: 108px; width: 90px; padding: 10px;">
								</div>
								<div class="subject">
									<a href="#" class="subject_tit">${cartList.prod_name}</a> 
									<span class="subject_in">${cartList.prod_content}</span>
								</div>
										
								<div class="prodCount">
									<input type="hidden" name="productId" value="${cartList.prod_code}">
									<input class="cart_code" type="hidden" name="cart_code" value="${cartList.cartAddVO.cart_code}">
								</div>
										
							<!-- prodCount -->
					
									
								<div class="inner_option">
									<button type="button" class="btn down">
										<i class="fas fa-minus"></i>
									</button>
									<input type="number" readonly="readonly" name="amount" class="inp" value="1">
									<button type="button" class="btn up">
										<i class="fas fa-plus"></i>
									</button>
								</div>
					
								<div class="cancle">
									<a href="${contextPath}/removeCart.do?prod_name=${cartList.prod_name}">
										<i class="fas fa-window-close"></i>
									</a>
								</div>
								
								<div class="totalItem_prices">
									 <span class="item_prices"><span id="itemPrice" class="num">${cartList.prod_price}</span>원</span> 
								</div>
								<!-- totalItem_prices -->
							</div>
							<!-- item -->	
						</div>
							<!-- cartlist -->
							
					</c:forEach>
				</c:otherwise>
			</c:choose>	
			</div>
				<div class="bills">
					<div class="billsInfo">
						<div class="deliverTitle">배송지</div>
						<div class="address">${addrList.addr }</div>
						<div class="deliveryType">${addrList.delivery_type }</div>
						<div class="changeBtn">
							<button class="changeAddress" onclick="daumPostcode()">배송지 변경</button>
						</div>
						<div class="TotalPriceWrap">
							<div class="TotalPrice">
								<div class="prodPrice">
									<span class="txt">상품금액</span>
									<span class="price"><span id="basicPrice" class="num">0</span>원</span>
								</div>
								<div class="prodDiscount">
									<span class="txt">상품할인금액</span>
									<span class="price"><span id="discountPrice" class="num">0</span>원</span>
								</div>
								<div class="deliveryPrice">
									<span class="txt">배송비</span>
									<span class="price"><span id="deliveryPrice" class="num">0</span>원</span>
								</div>
								<hr/>
								<div class="prePayment">
									<span class="txt">결제예정금액</span>
									<span class="price">
									<span id="totalPrice" class="num">0</span>원</span> 
								</div>
								<div class="reserve">구매 시1000원 적립</div>
							</div>
						</div>
					</div>
				
					<div class="orderBtn">
						<button id="order" class="btn" >주문하기</button>
					</div>
						
							
					<div class="info">
						<span>쿠폰/적립금은 주문서에서 사용 가능합니다</span><br /> <span>‘입금확인’ 상태일
							때는 주문 내역 상세에서 직접 주문취소가 가능합니다.</span><br /> <span>‘입금확인’ 이후 상태에는
							고객센터로 문의해주세요.</span>
					</div>
				</div>
			</div>
			<!-- content -->
		</div>
		<!-- cart_main -->
	<!-- body -->
	
	
	<script type="text/javascript">
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

	
	
	
		$(document).ready(function() {
			
			var basicPrice = $("#basicPrice").text();
			
			var aa = $(this).parent().parent().find(".inner_option").find(".inp").val();
			
			var prodAmount = $(".inp").val();
			$(".down").click(function() {
				var aa1 = $(this).parent("div").find(".inp");
				var aa = $(this).parent("div").find(".inp").val();
				if (aa > 1) {
					aa = parseInt(aa) - 1;
					aa1.val(aa);
				} else {
					alert('구매수량은 1개 이상이여야 합니다.');
				}
				
				var flag = $(this).parent().parent().parent().find(".inn_check").find("input:checkbox[name=checkItem]").is(":checked");
				if(flag){
					var price = $(this).parent().parent().find(".totalItem_prices").find(".item_prices").find("#itemPrice").text();
					var basicPrice = $("#basicPrice").text();
					basicPrice = basicPrice.replace(/,/g,"");
					result = parseInt(basicPrice) - parseInt(price);
					$("#basicPrice").text(addStr(result,","));
				}
			});
		
			$(".up").click(function() {
			    aa1 = $(this).parent("div").find(".inp");
				var aa = $(this).parent("div").find(".inp").val();
				aa = parseInt(aa) + 1;
				aa1.val(aa);
				var flag = $(this).parent().parent().parent().find(".inn_check").find("input:checkbox[name=checkItem]").is(":checked");
				
				if(flag){
					var price = $(this).parent().parent().find(".totalItem_prices").find(".item_prices").find("#itemPrice").text();
					var basicPrice = $("#basicPrice").text();
					basicPrice = basicPrice.replace(/,/g,"");
					result = parseInt(basicPrice) +  parseInt(price);;
					$("#basicPrice").text(addStr(result,","));
				}
			});
			
			$(".checkboxLength").text($("input:checkbox[name=checkItem]").length-1);
			
			$("input:checkbox[name=checkItem]").change(function(){
				var aa = $(this).parent().parent().find(".inner_option").find(".inp").val();
				
				var flag = $(this).is(":checked");
				if(flag){
					var price = $(this).parent().parent().find(".item").find(".totalItem_prices").find(".item_prices").find("#itemPrice").text();
					price.trim();
					price.replace(/,/g,"");
					price = parseInt(aa) * parseInt(price);
					var prePrice = $("#basicPrice").text();
					prePrice = removeStr(prePrice,",");
					var result = parseInt(price) + parseInt(prePrice);
					var temp = parseInt(basicPrice);
					
					temp = temp + result;
					$("#basicPrice").text(addStr(temp,","));
					
					
				}else{
					var price = $(this).parent().parent().find(".item").find(".totalItem_prices").find(".item_prices").find("#itemPrice").text();
					price.trim();
					price.replace(/,/g,"");
					price = parseInt(aa) * parseInt(price);
					
					var prePrice = $("#basicPrice").text();
					prePrice = removeStr(prePrice,",");
					var result = parseInt(prePrice) - parseInt(price) ;
					var temp = parseInt(basicPrice);
					temp = temp + result;
					if(temp < 0 ){
						temp= 0;
					}
					$("#basicPrice").text(addStr(temp,","));
				}
				
			});	
		});
		
		$("#order").click(function(){
			var resultCodeArr =[];
			var resultQuantityArr = [];
			var i=0;
			$("input:checkbox[name='checkItem']").each(function(){
				if($(this).is(":checked") == true) {
					//resultCodeArr[i] =
					//resultQuantityArr[i] = 
					var _quantity  = $(this).parent().parent().find(".inner_option").find(".inp").val();
					var _cart_code = $(this).parent().parent().find(".item").find(".prodCount").find(".cart_code").val();
					resultCodeArr[i] = _cart_code;
					resultQuantityArr[i] = _quantity;
					i = i+1;
				}
			});
			$.ajax({
				type: "post",
				async: true,
				url: "http://localhost:8080/recipetoyou/order/orderRegist.do",
				dataType: "text",
				data: {'cart_code' : resultCodeArr,'quantity':resultQuantityArr},
				success: function(result) {
					alert("상품을 주문내역에 담았습니다.");
					location.href="${contextPath}/order/order.do";
				},
				error:function(request, status, error){

					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

				},
				complete : function(data, textStatus) {			
				}					
			 });
		});
		
	function removeStr(doc, str){
		doc = doc.replace(str,"");
		return doc;
	}
	
	function addStr(doc,str){
		doc = String(doc);
		var length = doc.length;
		if(length >= 8){
			doc = doc.slice(0,5)+str+doc.slice(2,length);
		}else if(length >= 7){
			doc = doc.slice(0,4)+str+doc.slice(2,length);
		}else if(length >= 6){
			doc = doc.slice(0,3)+str+doc.slice(3,length);
		}else if(length >= 5){
			doc = doc.slice(0,2)+str+doc.slice(2,length);
		}else if(length >= 4){
			doc = doc.slice(0,1)+str+doc.slice(1,length);
		}else{
			doc = doc;
		}
		console.log("add "+doc);
		return doc;
	}
	
	
	function priceInfo(prodAmount){
		var item_price = $("#itemPrice").text();
		item_price = removeStr(item_price,",");
		var basicPrice = $('#basicPrice').text();
		basicPrice = removeStr(basicPrice,",");
		var discountPrice = $('#discountPrice').text();
		if(discountPrice != 0){
			discountPrice = removeStr(discountPrice,",");
		}else{
			discountPrice = 0;
		}
		var deliveryPrice = $('#deliveryPrice').text();
		if(deliveryPrice != 0){
			deliveryPrice = removeStr(deliveryPrice,",");
		}else{
			deliveryPrice = 0;
		}
		var resultStr = (item_price * (prodAmount+1)- item_price + deliveryPrice);
		var result = addStr(resultStr,",");
		
		$('#totalPrice').text(result);
	}
		
	
	//전체 체크
	function selectAll(selectAll) {
			
		const checkboxes = document.getElementsByName('checkItem');
		  
		  checkboxes.forEach((checkbox) => {
		    checkbox.checked = selectAll.checked;
		  });
	}
	
	
	 
	//배송지 변경_미완
	 function daumPostcode() {
               new daum.Postcode({
                   oncomplete: function(data) {
                      
                       var roadAddr = data.roadAddress; // 도로명 주소 변수
                       var extraRoadAddr = ''; 
                      
                       if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                           extraRoadAddr += data.bname;
                       }
                       // 건물명이 있고, 공동주택일 경우 추가한다.
                       if(data.buildingName !== '' && data.apartment === 'Y'){
                           extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                       }
                      
                       // 우편번호와 주소 정보를 해당 필드에 넣는다.
                       document.getElementById('postcode').value = data.zonecode;
                       document.getElementById("roadAddress").value = roadAddr;
                   }
               })
               .open();
           }
	
		
	
	 </script>
</body>
</html>




















