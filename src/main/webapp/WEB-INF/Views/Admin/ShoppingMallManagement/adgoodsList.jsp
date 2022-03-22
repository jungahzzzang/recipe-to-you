<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json");
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
	<meta charset="UTF-8" contentType="application/json;">
	<title>Insert title here</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css"> 
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/ShoppingMallManagement/adgoodsList.css">
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/ShoppingMallManagement/adgoodsList.js" charset="UTF-8"></script>

</head>
<body>
	<div class="wrap">
		<div class="bar">상품목록</div>
		<div class="sub-menu">
			<ul>	<!-- css 수정 필요함. 왼쪽으로 이동해야 됨. -->
			<li><a href="${contextPath}/adgoods/moveRegister.do">상품등록</a></li>
			<li><a href="${contextPath}/adgoods/listProduct.do" class="selected">상품목록</a></li>
			</ul>
		</div>
	
	<%-- <form id="searchForm" action="${contextPath}/product/listCategory.do" method="post"> --%>
		<form id="searchForm" method="get"  enctype="multipart/form-data">
			<input type="hidden" name="page" value="${pageMaker.vo.page}">
			<input type="hidden" name="pageSize" value="${pageMaker.vo.pageSize}">
			<input type="hidden" value="${pageMaker.vo.keyword }">
			<input type="hidden" name="cateCode" value="${pageMaker.vo.cateCode}">
	
			<div class="main-content">
				<table class="table table1 table_line">
					<colgroup>
						<col width="120px">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th>판매상태</th>
							<td style="text-align: left;"><!-- radio기능 넣어야 됨 -->
								<label class="lbl">
									<input type="radio" name="sale_status" value="all" checked/>전체
								</label>
								<label class="lbl">
									<input type="radio" name="sale_status" value="on"/>판매중
								</label>
								<label class="lbl">
									<input type="radio" name="sale_status" value="soldout" />품절
								</label>
							</td>
						</tr>
							
						<tr>
							<th>상품분류</th>
							<td style="text-align: left;">	
								<label>1차 분류</label>
								<select class="category1" id="category1">
									<option selected="selected" value="none">선택</option>
								</select>
								<label>2차 분류</label>
								<select class="category2" id="category2">
									<option selected="selected" value="none" name="cateCode" value="${pm.vo.cateCode}">선택</option>
								</select>
							</td>
						</tr>
					
						<tr>
							<th>상품명</th>
							<td style="text-align: left;">
								<input type="text" id="keywordInput" name="keyword" style="width: 70%" value="${pm.vo.keyword}"/>
								<button type="submit" id="searchBtn" class="btn btn-sm btn-blue">검색</button>
								<button type="button" class="btn btn-sm"><a href="${contextPath}/adgoods/listProduct.do">처음으로</a></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>	
	</div>
	
		<div class="list-tools">
			<div class="summary">
				검색된 상품
				<span class="f-bold f-red f-num"></span>
				${searchcnt }개
				<span>|</span>
				총 등록상품
				<span class="f-bold f-num"></span>
				${cnt }개
			</div>
		</div>
	<div>
		<table class="table table1 list_top table_line table-center">
			<colgroup>
				<col width="60px">
				<col>
				<col width="100px">
			</colgroup>
			<thead>
				<tr>
					<th>
					<!-- 체크박스 기능 넣기 -->
					<input id="checkboxAllChoice" type="checkbox"/>
					</th>
					<th>상품정보</th>
					<th>판매상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="prod" items="${prodList}">
					<tr>
						<td>
							<input class="chChoice" type="checkbox" value="294"/>
						</td>
						<td class="image" style="text-align: left; padding: 5px">
							<div style="float: left; width: 60px">
			
								<div class="image_wrap" data-prod_code="${prod.imageList[0].prod_code}" data-path="${prod.imageList[0].uploadPath}"
													data-uuid="${prod.imageList[0].uuid}" data-filename="${prod.imageList[0].fileName}">
										<img src="/recipetoyou/Resources/Admin/Img/AdgoodsImg/${prod.imageList[0].uploadPath}/s_${prod.imageList[0].uuid}_${prod.imageList[0].fileName}">
								</div>
							</div>		
							<div style="margin-left: 110px">
								<div style="line-height: 28px">
									<a href="${contextPath}/adgoods/adgoodsInfo.do?prod_code=${prod.prod_code}">
									<%-- <a class="move" href="<c:out value="${goodsVO.prod_code}"/>"> --%>
										<b>${prod.prod_name }</b>
									</a>
									<div style="float: right;">
										<a class="a_style">
										<!-- 새창보기아이콘 넣기 -->
										<i></i>
										<span class="f-small">새창보기</span>
										</a>
									</div>
									<div class="div_style1">
										<!-- onclick기능 넣기 (복사기능) -->
										<a class="a_style" onclick="">
										<!-- 복사 아이콘 넣기 -->
										<i></i>
										<span class="f-small">복사</span>
										</a>
									</div>
								</div>
								<div class="div_style2">
									<span class="red_b">분류: ${prod.cateName}</span>
								</div>
								<div class="div_style2">
									<span class="sky_b">${prod.prod_price }</span>
								</div>
							</div>
						</td>
						<td>
							<c:choose>
								<c:when test="${prod.stock_quantity != 0}">
									<span class="lable label-xs lable-blue">판매중</span>
								</c:when>
								<c:otherwise>
									<span class="lable label-xs lable-blue">품절</span>
								</c:otherwise>
							</c:choose>	
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${listCheck == 'empty'}">
		<div>
			등록된 상품이 없습니다.
		</div>
	</c:if>
					
	<div class="box-footer">
		<div class="page_wrap">
				<ul class="pagination">
				 			<!-- 이전prev -->
				 	<c:if test="${pm.prev }">
				 		<li class="pageBtn prev">
				 			<a href="listProduct.do?page=${pm.startPage-1}">이전</a>
				 		</li>
				 	</c:if>
				 			<!-- 페이지블럭 -->
					<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
								<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
						<li ${pm.vo.page == idx? 'class=active':''}>
						 	<a href="listProduct.do?page=${idx}">${idx}</a>
						</li>				
					</c:forEach>
				 			<!-- 다음next -->
				 	<c:if test="${pm.next && pm.endPage > 0}">
				 		<li class="pageBtn next"><a href="listProduct.do?page=${pm.endPage+1}">다음</a></li>
				 	</c:if>
				 </ul>
			</div>
		</div> 
		
		<form id="moveForm" action="${contextPath}/adgoods/listProduct.do" method="get">
			<input type="hidden" name="page" value="${pm.vo.page}">
			<input type="hidden" name="pageSize" value="${pm.vo.pageSize}">
			<input type="hidden" id="keyword" name="keyword" value="${pm.vo.keyword}">
			<input type="hidden" id="cateCode" name="cateCode" value="${pm.vo.cateCode}">
		</form>
		
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
		
		
		let moveForm = $("#moveForm");
		
		//상품 조회 페이지
		$(".move").on("click", function(e){
			
			e.preventDefault();
			
			moveForm.append("<input type='hidden' name='prod_code', value='"+$(this).attr("href")+"'>");
			moveForm.attr("action", "${contextPath}/adgoods/adgoodsInfo.do");
			moveForm.submit();
		}) 
	
		$(document).ready(function(){
												
		//이미지 삽입
		$(".image_wrap").each(function(i, obj){
			
			const bobj = $(obj);
			if(bobj.data("prod_code")){
				
				const uploadPath = bobj.data("path");
				const uuid = bobj.data("uuid");
				const fileName = bobj.data("filename");
				
				const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
				
				//$(this).find("img").attr('src', '${contextPath}/adgoods/getImageInfo.do?fileName=' + fileCallPath);
				
			}else {
					$(this).find("img").attr('src', '/recipetoyou/Resources/Admin/Img/SubgoodsImg/ready.jpg');
			}
		});	
		
		});
		
		/* 상품 등록 성공 이벤트 */
		let eResult = '<c:out value="${goodsResult}"/>';
		checkResult(eResult);
		function checkResult(result){
			
			if(result == ""){
				return;
			}
			alert("상품"+eResult+"등록이 완료되었습니다.");
		}
		
		/* 수정 성공 이벤트 */
		let modify_result = '${modify_result}';
		
		if(modify_result == 1){
			alert("수정 완료");
		}
		
		/* 삭제 성공 이벤트 */
		let delete_result = '${delete_result}';
		
		if(delete_result == 1){
			alert("삭제 완료");
		}
		
		
		/*상품명 검색*/
		$("#searchBtn").on("click", function(e){
			e.preventDefault();
			
			let val = $("input[name='keyword']").val();
			
			if(!($("#category1 option:selected")).val() != "none"){
				var val2 = $("#category2 option:selected");
				
				if(val2.val() != "undefinded"){
					var val3 = $("#category2 option:selected").val();
				}
			}
			
			if(val != ""){
				$("#keyword").val(val);
			}else{
				$("#keyword").val("");
			}
			if(val3 != "" && val3 != "none"){
				$("#cateCode").val(val3);
			}else{
				$("#cateCode").val(100000);
			}
			moveForm.find("input[name='page']").val(1);
			
		
			
			moveForm.submit();
		    
		   
		});
		
		</script>
</body>
</html>