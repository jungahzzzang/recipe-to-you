<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
%>    
<c:if test="${admin.adminId == null }">
	<script>
		alert("관리자 로그인 후 이용이 가능합니다.");
		location.href="${contextPath}/admin/adLogin.do";
	</script>
</c:if>
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
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/ShoppingMallManagement/adgoodsRegister.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="/recipetoyou/Resources/Common/ckeditor/ckeditor.js"></script>
	<!-- <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script> -->
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/ShoppingMallManagement/adgoodsRegister.js" charset="UTF-8"></script>
	
	
	<!-- datepicker 적용 -->
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	
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

			
				<div class="main-content">
					<div class="sub-title">| 상품 기본정보</div>											<!-- 파일 업로드 기능 -->
					<form action="${contextPath}/adgoods/register.do" method="post" id="registerForm" enctype="multipart/form-data">
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
											<option value="">선택</option>
										</select>
										
									<label>2차 분류</label>
										<select class="category2" name="cateCode">
											<option value="">선택</option>
										</select>
										
										<span class="ck_msg cateCode_msg">카테고리를 선택해주세요.</span>
									<div class="helper blue mt5">
										<img src="/recipetoyou/Resources/Admin/Img/ShoppingMallManagement/Question-blue.png" width="12px" height="12px">
										카테고리 설정은	 
										<a href="#" class="helper">[상품분류설정]</a>
										에서 설정가능합니다.
									</div>
								</td>
							</tr>
							<tr>
								<th>상품명</th>
								<td><input type="text" value="" id="prod_name" name="prod_name"/>
								<span class="ck_msg prod_name_msg">상품명을 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>간단설명</th>
								<td>
									<textarea value="" id="prod_content" name="prod_content"></textarea>
									<span class="ck_msg prod_content_msg">상품 설명을 입력해주세요.</span>
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
									<input type="text" id="prod_price" name="prod_price">
									<span class="ck_msg prod_price_msg">판매가격을 입력해주세요.</span>
									
								</td>
							</tr>
							<tr>
								<th>할인율</th>
								<td>
									<input type="text" id="prod_discount" name="prod_discount"/>
									<input type="hidden" name="goodsDiscount">
									<span class="discount">할인 가격 : <span class="discount_area"></span></span>
									<span class="ck_msg prod_discount_msg">1~99 사이의 숫자를 입력해주세요.</span>
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
																<!-- 여러 이미지 선택 허용 -->							
											<input type="file" multiple="multiple" id="fileItem" name= "uploadFile">
											<div id="uploadArea">
											<!-- <div class="preview"><img id="goodsImg" alt="" src="" width="300px" height="300px"></div>	 -->
											<!-- <div id="result_card">
												<div class="imgDeleteBtn">x</div>
												<img alt="" src="">
											</div> -->
											</div>
									</div>	
								</td>
							</tr>
							<tr>
								<th>알레르기정보</th>
								<td>
								<input type="text" id="prod_allergy" name="prod_allergy">
								<span class="ck_msg prod_allergy_msg">알레르기 정보를 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>주의사항</th>
								<td>
								<input type="text" id="prod_caution" name="prod_caution">
								<span class="ck_msg prod_caution_msg">주의사항을 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>배송구분</th>
								<td>
								<input type="text" id="prod_delivery_type" name="prod_delivery_type">
								<span class="ck_msg prod_delivery_type_msg">배송 유형을 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>원산지</th>
								<td>
								<input type="text" id="prod_from" name="prod_from">
								<span class="ck_msg prod_from_msg">원산지 정보를 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>안내사항</th>
								<td>
								<input type="text" id="prod_info" name="prod_info">
								<span class="ck_msg prod_info_msg">안내사항을 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>포장타입</th>
								<td>
								<input type="text" id="prod_wrap_type" name="prod_wrap_type">
								<span class="ck_msg prod_wrap_type_msg">포장타입을 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>유통기한</th>
								<td>							<!-- autocomplete : input 태그 클릭했을 때 이전 데이터 뜨는 것을 막기 위해 -->
								<input id="prod_vaild_date" name="prod_vaild_date" autocomplete="off" readonly="readonly">
								<span class="ck_msg prod_vaild_date_msg">유통기한을 입력해주세요.</span>
								</td>
								
								<!-- 
									DB에 유통기한 컬럼의 데이터 타입이 DATE이기 때문에
									반드시 "yyyy-MM-dd" 형식으로 입력되어야 한다.
									=>jquery에서 제공하는 datepicker를 활용해 'yyyy-MM-dd' 형식으로 <input>태그에
									값이 입력되도록 함.
								 -->
								
							</tr>
							<tr>
								<th>판매단위</th>
								<td>
								<input type="text" id="prod_sell_unit" name="prod_sell_unit">
								<select name="select_unit">
									<option>단위 선택</option>
									<option>봉</option>
									<option>개</option>
									<option>망</option>
									<option>팩</option>
								</select>
								<span class="ck_msg prod_sell_unit_msg">판매단위를 입력해주세요.</span>
								</td>
								
							</tr>
							<tr>
								<th>수량</th>
								<td>
								<input type="text" id="prod_quantity" name="prod_quantity">
								<span class="ck_msg prod_quantity_msg">수량을 입력해주세요.</span>
								</td>
								
							</tr>
														
							
						</tbody>
					</table>
					
						<div class="btn-box" style="margin-top: 10px">
						
						<input type="button" class="btn btn-lg btn-blue" id="saveBtn" value="저장">
						
						<button class="btn btn-lg" id="listBtn">목록</button>
						
						<button class="btn btn-lg btn-red" id="deleteBtn">삭제</button>
					</div>
					</form>
					
					</div>
				</div>	
	
	<script type="text/javascript">
	
	/* 카테고리 */
	let cateList = JSON.parse('${cateList}');
	let cate1Array = new Array();
	let cate1Obj = new Object();

	
	//1차 분류 셀렉트박스 삽입 데이터 준비
	for(let i=0; i<cateList.length; i++){
		if(cateList[i].level == "1"){
			
		cate1Obj = new Object();
		cate1Obj.cateCode = cateList[i].cateCode;
		cate1Obj.cateName = cateList[i].cateName;
		cate1Array.push(cate1Obj);
	}
}
	//1차 분류 셀렉트박스에 데이터 삽입
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
		
		
		//cate2Select 값을 제거함(초기화)
		cateSelect2.children().remove();
		
		$("option:selected", this).each(function(){
			
			let selectVal = $(this).val();	//현재 선택한 cateSelect1 값 저장
			cateSelect2.append("<option value='" + selectVal + "'>전체</option>");	//cateSelect2의 '전체'에 현재 선택한 cateSelect1과 같은 값 부여
			
			//cate2Array의 데이터를 cateSelect2에 추가
			for(let i=0; i<cate2Array.length; i++){
				
				if(selectVal == cate2Array[i].cateParent){
					cateSelect2.append("<option value='"+cate2Array[i].cateCode+"'>" + cate2Array[i].cateName + "</option>")
				}
			}
		});
	});
	
	/* 이미지 업로드 */
	$("input[type='file']").on("change", function(e){
		
		/* 이미지 존재시 삭제 */
		if($("#result_card").length>0){
			deleteFile();
		}
		
		/*
			사용자가 선택한 파일을 서버에 전송하기 위해서는 선택된 파일에 접근하는 방법을 알아야 한다.
			
			1.<input> 태그를 통해 선택된 파일은 File 객체의 형태로 표현됨.
			2.File 객체는 FileList(배열 형태의 객체) 객체의 요소로 저장이 됨.
			3.FileList의 요소에는 File 객체가 저장됨 -> File 객체는 type이 'file'인 <input> 태그의 "files"의 속성.
			4.사용자가 <input>태그를 통해 파일1개를 선택하게 되면 FileList 첫 번째 요소(FileList[0])인 File 객체에 파일 데이터가 저장됨.
			5.여러 개의 파일을 선택한다면 선택한 갯수(n)만큼 FileList 첫 번째요소(FileList[0])부터 순서대로 각 요소(FileLsit[n]) File 객체에 저장됨.
			
			=>사용자가 선택한 파일을 선택한 파일인 File 객체에 접근하기 위해서는 결국
			FileList 객체(<input>태그의 files 속성)에 접근해야 함.
		*/
		
		let formData = new FormData();	//첨부 파일을 서버로 전송하기 위한 가상의 <form>태그
		let fileInput = $('input[name="uploadFile"]');
		let fileList = fileInput[0].files;
		let fileObj = fileList[0];
		
		console.log("fileList : " + fileList);
		console.log("fileName : " + fileObj.name);
		console.log("fileSize : " + fileObj.size);
		console.log("fileType(MimeType) : " + fileObj.type);
		
		
		
		if(!fileChk(fileObj.name, fileObj.size)){
			return false;
		}

		
		//multiple 속성을 부여하여 사용자가 여러 개의 파일을 선택할 수 있도록함.
		//for(let i=0; i<fileList.length; i++){
			//formData.append("uploadFile", fileList[i]);
		//}
		
		formData.append("uploadFile", fileObj);
			
			$.ajax({
				
				url : '${contextPath}/adgoods/uploadAction.do',	//서버로 요청을 보낼 url
				processData : false,			//서버로 전송할 데이터를 queryString 형태로 변환할지 여부
				contentType : false,			//서버로 전송되는 데이터의 content-type
				data : formData,				//서버로 전송할 데이터
				type : 'POST',					//서버 요청 타입(GET, POST)
				dataType : 'json',				//서버로부터 반환받을 데이터 타입
				success : function(result){
					console.log(result);
					showUploadImage(result);
				},
				error : function(result){
					//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					alert("에러");
					}
			});
	}); 

	/* 파일 형식 체크 */
	 
	let regex = new RegExp("(.*?)\.(jpg|png)$"); //.jpg, .png 업로드 형식으로 지정
	let maxSize = 1048576; //1MB

	function fileChk(fileName, fileSize){
		
		if(fileSize >= maxSize ){
			alert("파일 사이즈 초과");
			return false;
		}
		
		if(!regex.test(fileName)){
			alert("올바른 파일 형식이 아닙니다.");
			return false;
		}
		
		return true;
	}
	
	/* 이미지 출력 */
	function showUploadImage(uploadResultArr){
		
		//전달받은 데이터 체크
		if(!uploadResultArr || uploadResultArr.length == 0){return}
		
		let uploadResult = $("#uploadArea");
		
		let obj = uploadResultArr[0];
		
		let str = "";
		
		let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
		
		str += "<div id='result_card'>";
		str += "<img src='${contextPath}/adgoods/getImageInfo.do?fileName=" + fileCallPath +"'>";
		str += "<div class='imgDeleteBtn' data-file='" + fileCallPath + "'>x</div>";
		str += "<input type='hidden' name='imageList[0].fileName' value='"+ obj.fileName +"'>";
		str += "<input type='hidden' name='imageList[0].uuid' value='"+ obj.uuid +"'>";
		str += "<input type='hidden' name='imageList[0].uploadPath' value='"+ obj.uploadPath +"'>";
		str += "</div>";		
		
			uploadResult.append(str); 
		
	}
	
	
	
	
	
	/* 이미지 삭제 버튼 동작 */
	$("#uploadArea").on("click", ".imgDeleteBtn", function(e){
		deleteFile();
	})

	/* 파일 삭제 메서드 */
	function deleteFile(){
		
		let targetFile = $(".imgDeleteBtn").data("file");
		
		let targetDiv = $("#result_card");
		
		$.ajax({
			
			url : '${contextPath}/adgoods/deleteFile.do',
			//contentType : false,
			data : {fileName : targetFile},
			dataType : 'text',
			type : 'POST',
			success : function(result){
				console.log(result);
				
				targetDiv.remove();
				$("input[type='file']").val("");
			},
			
			error : function(result){
				
				console.log(result);
				alert("파일을 삭제하지 못하였습니다.")
			}
		});
	}
	
	/* CKEditor5 적용 */
	var ckeditor_config = {
		resize_enaleb : false,
		enterMode : CKEDITOR.ENTER_BR,
		shiftEnterMode : CKEDITOR.ENTER_P,
		filebrowserUploadUrl : "${contextPath}/adgoods/ckimageUpload.do"
		}
		CKEDITOR.replace("prod_content", ckeditor_config);
	
	
	/* 상품 할인율 설정 */
	$("#prod_discount").on("propertychange change keyup paste input", function(){
		let showInput = $("#prod_discount");
		let discountInput = $("input[name='goodsDiscount']");
		
		let discountRate = showInput.val();							//입력한 할인값
		let sendDiscountRate = discountRate / 100;					//서버에 전송할 할인값
		let goodsPrice = $("input[name='prod_price']").val();		//원가
		let discountPrice = goodsPrice * (1 - sendDiscountRate);	//할인가격
		
		if(!isNaN(discountRate)){
			$(".discount_area").html(discountPrice);
			discountInput.val(sendDiscountRate);
		}
		
	});
	
	/* 판매 단위 선택 */
	$("select[name=select_unit]").on("change", function(){
		var $unit = $(this).closset(".form").find("input[name=prod_sell_unit]");
		if($(this).val()=="etc"){
			$unit.val('');
			$unit.prop("readonly",false);
		}else{
			$unit.val($(this).val());
			$unit.prop("readonly",true);
		}
	});
	
</script> 
	
</body>
</html>