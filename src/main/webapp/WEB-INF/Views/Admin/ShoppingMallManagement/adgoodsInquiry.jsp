<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }"/>  
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
	<title>상품문의 목록</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css"> 
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/ShoppingMallManagement/adgoodsInquiry.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- 쇼핑몰관리 -> 상품문의 -> 상품문의목록 페이지 -->
	<div class="wrap">
		<div class="bar">상품문의 목록</div>
		<table align="center">
			<tbody>
				<tr>
					<td align="left">
						<div class="main-content">
							
							<form method="post" action="${contextPath }/adgoods/inquiryList.do">
							<input type="hidden" name="page" value="${pageMaker.vo.page}">
							<input type="hidden" name="pageSize" value="${pageMaker.vo.pageSize}">
							<input type="hidden" name="keyword" value="${pageMaker.vo.keyword }">
								<table class="table table1 table_line" >
									<colgroup>
										<col width="120px">
										<col>
										<col width="120px">
										<col>
									</colgroup>
									<tbody>
										<tr>
											<th>문의일자</th>
											<td style="text-align: left;"><input type="date" /> ~ <input type="date" /></td>
											<th>답변여부</th>
											<td style="text-align: left;">
												
												<label class="lbl">
													<input type="radio" name="reply_status" value="all" checked/>전체
												</label>
												<label class="lbl">
													<input type="radio" name="reply_status" value="wait"/>답변대기
												</label>
												<label class="lbl">
													<input type="radio" name="reply_status" value="done"/>답변완료
												</label>
											</td>
										</tr>
										<tr>
											<th>검색어</th>
											<td colspan="3" style="text-align: left;">
											<div class="search_area">
												<select name="searchOption">
												<option value="inq_title" <c:out value="${pageMaker.vo.searchOption == 'inq_title'?'selected':''}"/>>
												제목</option>
							
												<option value="id" <c:out value="${pageMaker.vo.searchOption == 'id'?'selected':''}"/>>
												문의자 아이디</option>
											</select>
												<input type="text" name="keyword" style="width: 500px" value="${pm.vo.keyword}"/>
											</div>
											</td>
										</tr>
									</tbody>
								</table>
								<div class="btn-box">	<%-- 인라인 속성이기 떄문에 버튼을 가운데로 보내기위해 <div>태그로 감쌌다. --%>
									<button type="submit" id="searchBtn" class="btn btn-sm btn-blue">검색</button>
									<%-- href 추가해야됨 --%>
									<button type="reset" class="btn btn-sm" 
									onclick="document.location.href='productInquirylist.jsp'">처음으로</button>
								</div>
								</div>
							</form>	
							
							<div class="list-tools">
							<div class="list-action">
								<%-- 버튼클릭시 삭제되는 onclick기능 추가 --%>
								<button id="selectRemove" class="btn btn-red" type="button" onclick="">선택삭제</button>
							</div>
							<div class="summary">
								<span class="split">|</span>
								총 문의 &nbsp;
								<span class="f-bold f-num"></span>
								${cnt }개
								<span class="split">|</span>
								검색된 문의 &nbsp;
								<span class="f-bold f-num"></span>
								${searchcnt }개
							</div>
						</div>
						
						<table class="table table1 list_top table_line table-center table_list">
							<colgroup>
								<col width="60px">
								<col width="60px">
								<col width="80px">
								<col>
								<col width="100px">
								<col width="150px">
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<%-- 체크박스 선택시 나타나는 기능 추가해야됨 --%>
									<th><input id="checkboxAllChoice" type="checkbox" onclick="" /></th>
									<th>답변여부</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일시</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="inquiry" items="${inquiryList}">
							<tr>
								<td>${inquiry.prod_inq_code}</td>
								<td><input class="chChoice" type="checkbox" value="286"/></td>
								<td>
									<c:choose>
										<c:when test="${inquiry.inq_level eq 1}">
										<span class="lable">답변 완료</span>
										</c:when>
									<c:when test="${inquiry.inq_level ne 1}">
										<span class="lable">답변 대기</span>
									</c:when>
									</c:choose>				
								</td>
								<td style="text-align: left">
									<a href="${contextPath }/adgoods/adInquiryDetail.do?prod_inq_code=${inquiry.prod_inq_code}">${inquiry.inq_title}</a>
								</td>
								<td>${inquiry.user_id}</td>
								<td>${inquiry.inq_reg_date}</td>
							</tr>
							</c:forEach>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>	
	<div class="box-footer">
			<div class="page_wrap">
				<ul class="pagination">
				 			<!-- 이전prev -->
				 	<c:if test="${pm.prev }">
				 		<li class="pageBtn prev"><a href="listInquiry.do?page=${pm.startPage-1}">이전</a></li>
				 	</c:if>
				 			<!-- 페이지블럭 -->
					<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
								<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
						<li ${pm.vo.page == idx? 'class=active':''}>
						 	<a href="listInquiry.do?page=${idx}">${idx}</a>
						</li>				
					</c:forEach>
				 			<!-- 다음next -->
				 	<c:if test="${pm.next && pm.endPage > 0}">
				 		<li class="pageBtn next"><a href="listInquiry.do?page=${pm.endPage+1}">다음</a></li>
				 	</c:if>
				 </ul>
			</div>
		</div> 
	</div>
	

		
		<form id="moveForm" action="${contextPath}/adgoods/inquiryList.do" method="get">
			<input type="hidden" name="page" value="${pm.vo.page}">
			<input type="hidden" name="pageSize" value="${pm.vo.pageSize}">
			<input type="hidden" id="keyword" name="keyword" value="${pm.vo.keyword}">
			<input type="hidden" id="searchOption" name="searchOption" value="${pm.vo.searchOption }">
		</form>
	
	<script type="text/javascript">
		//체크박스 모두 선택하는 기능
		$(function () {
			$('#checkboxAllChoice').click(function () {
				var checked = $('#checkboxAllChoice').is(':checked');
				
				if(checked) 
					$('input.chChoice:checkbox').prop('checked',true);
				else 
					$('input.chChoice:checkbox').prop('checked',false);
			});
		});
		
		$(document).ready(function() {
			$('#selectRemove').click(function(){
				alert('삭제할 문의를 선택하세요.');
			});
			
			let moveForm = $("#moveForm");
			
			$("#searchBtn").on("click",function(e){
				e.preventDefault();
				
				let searchOption = $(".search_area select").val();
				let keyword = $(".search_area input[name='keyword']").val();
				
				if(!searchOption){
					alert("검색 종류를 선택하세요.");
					return false;
				}
				
				if(!keyword){
					alert("검색어를 입력하세요.");
					return false;
				}
				
				moveForm.find("input[name='searchOption']").val(searchOption);
				moveForm.find("input[name='keyword']").val(keyword);
				moveForm.find("input[name='page']").val(1);
				moveForm.submit();
			});
			
		});
		
		//
	
	</script>
	
	
	
</body>
</html>