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
	<title>상품문의</title>
	<link rel=“stylesheet” href=“https://use.fontawesome.com/releases/v5.14.0/css/all.css”
     integrity=“sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc” crossorigin=“anonymous”>
 	<link href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=“stylesheet”>
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/HomePageHeaderSide/reset.css"> 
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/ShoppingMallManagement/adInquiryDetail.css">
	<!-- cdn 활용하여 ckeditor 생성 -->
	<script src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	
	<div class="wrap">
		<div class="bar">상품문의</div>
		<table align="center">
			<tbody>
				<tr>
					<td align="left">
						<div class="main-content">
							<div class="sub-title">| 문의상세</div>
							
							<form action="${contextPath}/adgoods/updateProdQna.do" method="post" id="inqForm">
							<input type="hidden" id="prod_inq_code" name="prod_inq_code" value="${inquiry.prod_inq_code }">
							<input type="hidden" id="prod_code" name="prod_code" value="${inquiry.prod_code }">
							<input type="hidden" id="inq_level" name="inq_level" value="${inquiry.inq_level }">
							
							<table class="table table1 line_top table_line">
								<colgroup>
									<col width="120px">
									<col>
									<col width="120px">
									<col>
								</colgroup>
								<tbody>
									<tr>
										<th>작성자</th>
										<td><input type="text" value="${inquiry.user_id }" name="user_id"></td>
										<th>작성일시</th>
										<td><input type="text" value="${inquiry.inq_reg_date }" name="inq_reg_date"></td>
									</tr>
									<tr>
										<th>문의제목</th>
										<td colspan="3"><input type="text" value="${inquiry.inq_title }" name="inq_title"></td>
									</tr>
									<tr>
										<th>문의내용</th>
										<td colspan="3"><textarea name="inq_content" id="inq_content">${inquiry.inq_content }</textarea></td>
									</tr>
								</tbody>
							</table>
							<div class="sub-title" style="margin-top: 20px">| 답변하기</div>
							
							<table class="table table1 line_top table_line">
								<colgroup>
									<col width="120px">
									<col>
								</colgroup>
								<tbody>
									<tr>
										<th>답변내용</th>
										<td style="padding: 5px">
										
											<div class="preparedPage">
												<p>준비중 페이지</p>
												<textarea name="inq_an" id="prepared" rows="10" cols="100" >${inquiry.inq_an }</textarea>
												<script>
											        ClassicEditor
											            .create( document.querySelector('#prepared'))
											            .then(edit => {
											            	console.log(prepared);
											            })
											            .catch(error => {
											                console.error(error);
											            });
											    </script>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							</form>
							
							<div class="btn-box">
								<!-- 답변저장버튼 클릭시 나타나는 기능 넣기!! -->
								<button class="btn btn-lg btn-blue" id="saveBtn">답변저장</button>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript">
		$("#saveBtn").on("click", function(e){
			$("#inqForm").submit();
		})
	</script>
</body>
</html>