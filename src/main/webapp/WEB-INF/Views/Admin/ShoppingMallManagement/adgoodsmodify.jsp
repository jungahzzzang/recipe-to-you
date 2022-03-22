<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>상품 등록</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css"> 
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/ShoppingMallManagement/adgoodsInfo.css">
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<!-- <script src="https://code.jquery.com/jquery-3.4.1.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>

	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/ShoppingMallManagement/adgoodsInfo.js" charset="UTF-8"></script>
	<!-- datepicker 적용 -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	
	<!-- cdn 활용하여 ckeditor 생성 -->
	<script src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
	
	
</head>
<body>
	<!-- 쇼핑몰관리 -> 상품관리 -> 상품등록페이지 -->
	<div class="wrap">
	<div class="bar">상품등록</div>
	<div class="sub-menu">
		<ul>	<!-- css 수정 필요함. 왼쪽으로 이동해야 됨. -->
		<li><a href="${contextPath}/adgoods/moveRegister.do">상품등록</a></li>
		<li><a href="${contextPath}/adgoods/listProduct.do" class="selected">상품목록</a></li>
		</ul>
	</div>
	
	<form action="${contextPath}/adgoods/register.do" method="post" id="modifyForm">
	<input type="hidden" name="prod_code" value="${goodsVO.prod_code }">
	<!-- 수정(UPDATE) 쿼리문에서 PROD_CODE가 필요하기 때문에 hidden 태그로 추가 -->
	
	<table align="center">
	<tbody>
		<tr>
			<td align="left">
				
				<div class="main-content">
					<div class="sub-title">| 상품 기본정보</div>
					
					<table class="table table1 line_top table_line">
						<colgroup>
							<col width="120px">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>상품분류</th>
								<td>
									<label>1차 분류</label>
										<select class="category1">
											<option selected="selected" value="none"></option>
										</select>
								
									<label>2차 분류</label>
										<select class="category2">
											<option selected="selected" value="none" name="cateCode"></option>
										</select>
								
											
									<div class="helper blue mt5">
										<img src="/recipetoyou/Resources/Admin/Img/ShoppingMallManagement/Question-blue.png" width="12px" height="12px">
										카테고리 설정은	 <%-- <a>태그의 상품분류설정은 생략하기로 했음 --%>
										<a href="#" class="helper">[상품분류설정]</a>
										에서 설정가능합니다.
									</div>
								</td>
							</tr>
							<tr>
								<th>상품명</th>
								<td>
								<input type="text" value="${goodsVO.prod_name}"/>
								</td>
							</tr>
							<tr>
								<th>간단설명</th>
								<td>
									<textarea id="prod_content" name="prod_content">${goodsVO.prod_content }</textarea>
				
									<div class="helper blue mt5">
										<span class="red"><span id="ex_byte">0</span>/120Byte</span>
										<img src="/recipetoyou/Resources/Admin/Img/ShoppingMallManagement/Question-blue.png" width="12px" height="12px">
										미입력시 노출되지 않습니다.
									</div>
								</td>
							</tr>
							<tr>
								<th>판매가격</th>
								<td>
									<input type="text" value="${goodsVO.prod_price }"/>
								</td>
							</tr>
							<tr>
								<th>할인율</th>
								<td>
									<input type="text" value="${goodsVO.prod_discount }">
									<div class="helper blue mt5">
										<img src="/recipetoyou/Resources/Admin/Img/ShoppingMallManagement/Question-blue.png" width="12px" height="12px">
										할인을 하지 않으실 경우 판매가격만 적어 주시면 됩니다.
									</div>
									
								</td>
							</tr>
							<tr>
								<th>상품이미지</th>
								<td>
									<div class="file_div">
											<label for="fileItem" class="input-file-btn">이미지 찾기</label>
											<!-- <button type="button" class="file_button btn">이미지 찾기</button> -->
											<input type="file"  multiple="multiple" id="fileItem" name="file" name='uploadFile'>
											<div id="uploadArea">
											<!-- <div class="preview"><img id="goodsImg" alt="" src="" width="300px" height="300px"></div> -->
											
											</div>
									</div>		
								</td>
							</tr>
							<tr>
								<th>알레르기정보</th>
								<td>
								<input type="text" value="${goodsVO.prod_allergy}" name="prod_allergy">
								
								</td>
								
							</tr>
							<tr>
								<th>주의사항</th>
								<td>
								<input type="text" name="prod_caution" value="${goodsVO.prod_caution}">
								
								</td>
								
							</tr>
							<tr>
								<th>배송구분</th>
								<td>
								<input type="text" value="${goodsVO.prod_delivery_type}" name="prod_delivery_type">
								
								</td>
								
							</tr>
							<tr>
								<th>원산지</th>
								<td>
								<input type="text" value="${goodsVO.prod_from}" name="prod_from">
								
								</td>
								
							</tr>
							<tr>
								<th>안내사항</th>
								<td>
								<input type="text" value="${goodsVO.prod_info}" name="prod_info">
								
								</td>
								
							</tr>
							<tr>
								<th>포장타입</th>
								<td>
								<input type="text" value="${goodsVO.prod_wrap_type}" name="prod_wrap_type">
								
								</td>
								
							</tr>
							<tr>
								<th>유통기한</th>
								<td>
								<input id="prod_vaild_date" name="prod_vaild_date" autocomplete="off" readonly="readonly">
								
								</td>
								
							</tr>
							<tr>
								<th>판매단위</th>
								<td>
								<input type="text" value="${goodsVO.prod_sell_unit}" name="prod_sell_unit">
								
								</td>
								
							</tr>
							<tr>
								<th>수량</th>
								<td>
								<input type="text" value="${goodsVO.stock_quantity}" name="stock_quantity">
								
								</td>
								
							</tr>
							
							
							
						</tbody>
					</table>
					
					<div class="btn-box" style="margin-top: 10px">
						<%-- 1)버튼 클릭시 저장하시겠습니까 alert창이 나타나는 기능 추가해야 됨(상품분류기능을 생략했기때문에 '1차분류입력하세요' alert창도 생략해도 될것 같음.)
						 	 2)저장버튼 클릭시 상품이 저장되는 기능 넣기  -> 상품목록 페이지로 이동 기능 넣기  --%>
						<button class="btn btn-lg btn-blue" id="saveBtn">저장</button>
						
						<button class="btn btn-lg" 
						onclick="document.location.href='productList.jsp'">목록</button>
						<%-- 삭제버튼 클릭시 상품후기 목록에서 해당상품이 삭제되는 기능 넣기 -> 상품후기목록 페이지로 이동 기능 넣기 --%>
						<button id="deleteBtn" class="btn btn-lg btn-red" onclick="">삭제</button>
					</div>
					
					<!-- 옵션정보 테이블의 옵션등록버튼 클릭시, 또는 추가옵션 테이블의 추가옵션등록버튼 클릭시 나타나는 팝업창 -->
					
				</div>
			</td>
		</tr>
	</tbody>
	</table>
	</form>
	
	</div>
	
	
	<form id="moveForm" action="${contextPath}/adgoods/listProduct.do" method="get">
			<%-- <input type="hidden" name="page" value="${pm.vo.page}">
			<input type="hidden" name="pageSize" value="${pm.vo.pageSize}">
			<input type="hidden" name="keyword" value="${pm.vo.keyword}"> --%>
	</form>

	<script type="text/javascript">
	
	$(document).ready(function(){
		
		/*유통기한 입력 위한 캘린더 위젯 적용*/

		/* 설정 */
		const config = {
				dateFormat: 'yy-mm-dd',
				showOn : "button",
				buttonText : "날짜 선택",
				prevText: '이전 달',
			    nextText: '다음 달',
			    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			    dayNames: ['일','월','화','수','목','금','토'],
			    dayNamesShort: ['일','월','화','수','목','금','토'],
			    dayNamesMin: ['일','월','화','수','목','금','토'],
			    yearSuffix: '년',
			    changeMonth: true,
		        changeYear: true
		}

		/* 캘린더 */
		$(function(){
			let vaildDate = '${goodsVO.prod_vaild_date}';
			let vaild_length = vaildDate.indexOf(" ");
			vaildDate = vaildDate.substring(0, vaild_length);
			$("input[name='prod_vaild_date']").datepicker(config);
			$("input[name='prod_vaild_date']").datepicker('setDate', vaildDate);
		});
		
		/* 카테고리 데이터 가져오기 */
		let cateList = JSON.parse('${cateList}');
		
		let cate1Array = new Array();
		let cate1Obj = new Object();
		
		
		
		for(let i=0; i<cateList.length; i++){
			if(cateList[i].level == "1"){
				
			cate1Obj = new Object();
			cate1Obj.cateCode = cateList[i].cateCode;
			cate1Obj.cateName = cateList[i].cateName;
			cate1Array.push(cate1Obj);
		}
	}
		let cateSelect1 = $("select.category1");
		
		for(let i=0; i<cate1Array.length; i++){
			cateSelect1.append("<option value='"+cate1Array[i].cateCode+"'>" + cate1Array[i].cateName + "</option>");
		}
		
		$(document).on("change", "select.category1", function(){
			let cate2Array = new Array();
			let cate2Obj = new Object();
			
			//2차 분류 셀렉트박스에 삽입할 데이터 준비
			for(let i=0; i<cateList.length; i++){
				
				if(cateList[i].level == "2"){
					
					cate2Obj = new Object();	//초기화
					cate2Obj.cateCode = cateList[i].cateCode;
					cate2Obj.cateName = cateList[i].cateName;
					cate2Obj.cateParent = cateList[i].cateParent;
					
					cate2Array.push(cate2Obj);
				}
			}
			
			let cateSelect2 = $("select.category2");
			
			cateSelect2.children().remove();
			
			$("option:selected", this).each(function(){
				
				let selectVal = $(this).val();
				cateSelect2.append("<option value='" + selectVal + "'>전체</option>");
			})
			
			for(let i=0; i<cate2Array.length; i++){
				if(selectVal == cate2Array[i].cateParent){
					
					cateSelect2.append("<option value='"+cate2Array[i].cateCode+"'>" + cate2Array[i].cateName + "</option>");
				}
				
			}
		});
		
		
		
		let select_cateCode = '${goodsVO.cateCode}';
		let select_cateParent = '${goodsVO.cateParent}';
		let select_cateName = '${goodsVO.cateName}';
		
		if(select_cateParent != null && select_cateParent != ''){
			$(".category1").val(select_cateParent);
			$(".category2").val(select_cateCode);
			$(".category2").children().remove();
			$(".category2").append("<option value='" + select_cateCode + "'>"+select_cateName+"</option>");
		}else{
			$(".category1").val(select_cateCode);
			$(".category2").append("<option value='"+ select_cateCode + "' selected='selected'>전체</option>");
		}
		
});
	

		/* 이미지 정보 호출 */
		let prod_code = '<c:out value="${goodsVO.prod_code}"/>';
		let uploadArea = $("#uploadArea");
											/* 여러 개의 이미지를 반환하기 때문에 이미지 정보를 배열 형태로 전달받음. */
		$.getJSON("${contextPath}/adgoods/getImageList.do", {prod_code : prod_code}, function(arr){
			
			//이미지 없는 경우 대체 이미지 출력
			if(arr.length == 0){
				
				let str = "";
				str += "<div id = 'result_card'>";
				str += "<img src='/recipetoyou/Resources/Admin/Img/SubgoodsImg/ready.jpg'>";
				
				uploadArea.html(str);
				
				return;
			}
			
			let str = "";
			let obj = arr[0];
			
			let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
			str += "<div id='result_card'";
			str += "data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "'";
			str += ">";
			str += "<img src='${contextPath}/adgoods/getImageInfo.do?fileName=" + fileCallPath +"'>";
			str += "</div>";
			
			uploadArea.html(str);
		});	
											
		/* 삭제 버튼 */
		$("#deleteBtn").on("click", function(e){
			//e.preventDefault();
			let moveForm = $("#moveForm");
			moveForm.find("input").remove();
			moveForm.append('<input type="hidden" name="prod_code" value="${goodsVO.prod_code}">');
			moveForm.attr("action", "/adgoods/goodsDelete.do");
			moveForm.attr("method", "post");
			moveForm.submit();
		}) 
		
	

/* 수정 버튼 */
$("#saveBtn").on("click", function(e){
			
	/* 체크 변수 */	
	let cateCodeChk = false;
	let nameChk = false;
	let contentChk = false;
	let priceChk = false;
	let discountChk = false;
	let imgChk = false;
	let deliveryChk = false;
	let infoChk = false;
	let wrapChk = false;
	let vaildDateChk = false;
	let sellUnitChk = false;
	let quantityChk = false;
	


	/* 체크 대상 변수 */

	let cateCode = $("select[name='cateCode']").val();
	let name = $("input[name='prod_name']").val();
	let content = $("input[name='prod_content']").val();
	let price = $("input[name='prod_price']").val();
	let discount = $("input[name='prod_discount']").val();
	let img = $("input[name='prod_img']").val();
	let delivery = $("input[name='prod_delivery_type']").val();
	let info = $("input[name='prod_info']").val();
	let wrap = $("input[name='prod_wrap_type']").val();
	let vaildDate = $("input[name='prod_vaild_date']").val();
	let sellUnit = $("input[name='prod_sell_unit']").val();
	let quantity = $("input[name='prod_quantity']").val();
	


	/* 각 항목 확인 */
	/* 공란일 경우 <span>태그를 보이도록 하고 '체크 변수'에 false값을 대입한다. */
	/* 공란이 아닐 경우 <span> 태그를 숨기고 '체크 변수'에 true값을 대입한다. */


	if(cateCode){
		$(".cateCode_msg").css('display','none');
		cateCodeChk = true;
	} else{
		$(".cateCode_msg").css('display','block');
		cateCodeChk = false;
	}	
	if(name){
		$(".prod_name_msg").css('display','none');
		nameChk = true;
	} else{
		$(".prod_name_msg").css('display','block');
		nameChk = false;
	}
	if(content){
		$(".prod_content_msg").css('display','none');
		contentChk = true;
	} else{
		$(".prod_content_msg").css('display','block');
		contentChk = false;
	}
	if(price){
		$(".prod_price_msg").css('display','none');
		priceChk = true;
	} else{
		$(".prod_price_msg").css('display','block');
		priceChk = false;
	}
	
	if(!isNaN(discount)){
		$(".prod_discount_msg").css('display','none');
	} else{
		$(".prod_discount_msg").css('display','block');
		priceChk = false;
	}	
	
	if(img){
		$(".prod_img_msg").css('display','none');
		imgChk = true;
	} else{
		$(".prod_img_msg").css('display','block');
		imgChk = false;
	}

	if(delivery){
		$(".prod_delivery_msg").css('display','none');
		deliveryChk = true;
	} else{
		$(".prod_delivery_msg").css('display','block');
		deliveryChk = false;
	}

	if(info){
		$(".prod_info_msg").css('display','none');
		infoChk = true;
	} else{
		$(".prod_info_msg").css('display','block');
		infoChk = false;
	}

	if(wrap){
		$(".prod_wrap_msg").css('display','none');
		nameChk = true;
	} else{
		$(".prod_wrap_msg").css('display','block');
		nameChk = false;
	}

	if(vaildDate){
		$(".prod_vaild_date_msg").css('display','none');
		vaildDateChk = true;
	} else{
		$(".prod_vaild_date_msg").css('display','block');
		vaildDateChk = false;
	}

	if(sellUnit){
		$(".prod_sell_unit_msg").css('display','none');
		sellUnitChk = true;
	} else{
		$(".prod_sell_unit_msg").css('display','block');
		sellUnitChk = false;
	}		

	if(quantity){
		$(".prod_quantity_msg").css('display','none');
		quantityChk = true;
	} else{
		$(".prod_quantity_msg").css('display','block');
		quantityChk = false;
	}
	
	/* '체크 변수'들이 모두 true일 때 <form>태그 전송 */ 
	/*if(cateCodeChk && nameChk && contentChk && priceChk &&  imgChk &&
	deliveryChk && infoChk && wrapChk && vaildDateChk && sellUnitChk && quantityChk){*/

		$("#modifyForm").submit();
		
	/*} else{
		return false;
	}*/	


}); 
		
		
</script>
	

		<!-- <button value="팝업창호출" onclick="showPopup()">지도키관리</button>
		 <script
			language="javascript">
			 function showPopup() { window.open("MapKey.jsp", "a", "width=700, height=500, left=100, top=50"); }
		  -->
	
	
	
	
</body>
</html>