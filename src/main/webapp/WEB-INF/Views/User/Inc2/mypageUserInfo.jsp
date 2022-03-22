<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<%
	request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="myPageTop">
			<div class="mypagetop_user">
				<div class="inner_mypagetop">
					<div class="grade_user">
						<div class="grade_wrap">
							<div class="grade_logo">
								일반 </div>
								<strong class="name">${userVO.user_name}님</strong>
							<div class="grade_benefit">
								<strong class="benefit">적립 0.5%</strong>
							</div>
							<!-- grade_benefit -->
							<div class="grade_view">
								<a href="#" onclick="" class="total_grade">전체등급 보기</a> <a
									href="#" onclick="" class="next_month_grade">다음 달 예상등급 보기</a>
							</div>
							<!-- grade_view -->
						</div>
						<!-- grade_wrap -->
					</div>
					<!-- grade_user -->
					
					<div class="list_mypage">
						<div class="list">
							<a href="#" onclick="" class="link_wrap">
								<div class="link_title">
									적립금<i class="fas fa-chevron-right"></i>
								</div>
								<p class="info">
									0 원 <span class="expire">소멸 예정 0 원</span>
								</p>
							</a> <a href="#" onclick="" class="link_wrap">
								<div class="link_title">
									쿠폰<i class="fas fa-chevron-right"></i>
								</div>
								<p class="info">0 개</p>
							</a> <a href="#" onclick="" class="link_wrap">
								<div class="link_title">
									투유 박스<i class="fas fa-chevron-right"></i>
								</div>
								<p class="info">알아보기</p>
							</a> <a href="#" onclick="" class="link_wrap">
								<div class="link_title">
									투유패스<i class="fas fa-chevron-right"></i>
								</div>
								<p class="info">알아보기</p>
							</a>
						</div>
						<!-- list -->
					</div>
					<!-- list_mypage -->
				</div>
				<!-- inner_mypagetop -->
				<div class="mypage_banner">
					<a href=""><img src="/recipetoyou/Resources/User/Img/Mypage/mypage_invite.jpg" alt=""></a>
				</div>
			</div>
			<!-- mypagetop_user -->
		</div>
</body>
</html>