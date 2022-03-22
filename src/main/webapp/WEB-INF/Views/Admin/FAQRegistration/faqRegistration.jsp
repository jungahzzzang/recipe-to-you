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
	<link rel="stylesheet" href="/recipetoyou/Resources/Admin/Css/FAQRegistration/faqRegistration.css">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="/recipetoyou/Resources/Common/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="/recipetoyou/Resources/Common/ckeditor/config.js"></script>
	<script type="text/javascript" src="/recipetoyou/Resources/Admin/Js/FAQManagement/faqRegistration.js" charset="UTF-8"></script>					
	<title>FAQ 정보 등록</title>
</head>
<body>
	<div class="wrap">
		<div class="main-content">
			<form action="${contextPath}/adfaq/FAQInsert.do" method="POST">
				<table class="subtitle" align="center">
					<p>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  						<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>	
						</svg>
						FAQ기본정보
					</p>
					<tr>
						<th>FAQ분류</th>
						<td><input type="text" id="faq_cate_code" name="faq_cate_code"/></td>
					</tr>
					<tr>
						<th>질문</th>
						<td><input type="text" id="faq_title" name="faq_title"/></td>
					</tr>

					<tr>
						<th>답변</th>
						<td colspan="2">
							<textarea id="faq_info" name="faq_info"></textarea>
							<script type="text/javascript">
								CKEDITOR.replace('faq_info');
							</script>
						</td>
					</tr>
				</table>
				<input type="submit" class="saveBtn" value="등록">
				<button type="button" class="backBtn" onclick="location.href='${contextPath}/adfaq/faqAdManagement.do'">뒤로가기</button>
			</form>
		</div>	
	</div>
</body>
</html>