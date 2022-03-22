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
<link href="/recipetoyou/Resources/User/Css/main.css"  rel="stylesheet"  type="text/css">
<link href="/recipetoyou/Resources/User/Css/reset.css" rel="stylesheet"  type="text/css">
<!-- fontawesome 링크 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
<!-- font 링크 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
<!-- 파비콘 링크 -->
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel= "icon" type="image/x-icon"/>
</head>

<body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<div id="header" class="container">
				<div class="topBar" id="topMessage">	<!-- banner 가입시 100원~ -->
					<a href="#" id="eventPage">	<%-- 고유 페이지임으로 id 선언 --%>
						지금 가입하고 인기상품 <b>100원</b>에 받아가세요!
						<i class="fas fa-angle-right"></i>
					</a>
				</div>
				<div class="header">			<!-- header -->
					<div id ="userMenu">		<!-- 로그인, 회원가입, 고객센터 목록 -->
						<ul class="list_menu">	
							<c:choose>
								<c:when test="${isLogOn == true && userVO != null }">
									<li class="menu_login"><a href="#none" class ="link-menu2">${userVO.user_name}님</a></li>
									<li class="menu_list">	<!-- onclick시 카데고리  -->
									<a href="${contextPath}/orderList.do">마이페이지</a></li>
									<li>
										<a href="${contextPath}/notice/notice.do"  class ="link-menu3" onclick="">고객센터<i class="fas fa-caret-down"></i></a>
									</li>
									<li class="menu_join"><a href="${contextPath}/login/logout.do"  class ="link-menu1" style=" color: #5f0080;">로그아웃 &#124;</a></li>
								</c:when>
								<c:otherwise>
									<li>
									<a href="${contextPath}/notice/notice.do"  class ="link-menu3" onclick="">고객센터<i class="fas fa-caret-down"></i></a>
									</li>
									<li class="menu_login"><a href="${contextPath}/login/login.do" class ="link-menu2">로그인 &#124;</a></li>
									<li class="menu_join"><a href="${contextPath}/join/regist.do"  class ="link-menu1" style=" color: #5f0080;">회원가입 &#124;</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
					</div>
				
					<div class="delivery">	<!-- 새벽 배송안내 이미지 -->
						<a href="#"><img alt="delivery" src="/recipetoyou/Resources/User/Img/delivery.png"></a>	
					</div>
					<div class="logo">
						<a href="${contextPath}/main.do"><img alt="logo" src="/recipetoyou/Resources/User/Img/RecipeToYou_logo_1.png"></a>
					</div>
				
		
					<div id="catagoryMenu" class="Tcatagory" >	     <!-- 전체 카데고리 -->
						<ul>
							<li class="menu1">
								<a href="${contextPath }/main.do" onclick="">
									<span class="ico"><i class="fas fa-bars"></i></span>
									<span class="txt">전체 카테고리</span>
								</a>
							</li>
							<li class="menu2">
								<a href="${contextPath}/community/communityRecipeMain.do" class="link_comu" onclick="">커뮤니티</a>
							</li>
							<li class="menu3">
								<a href="${contextPath }/user/newGoodsPage.do" class="link_new" onclick="">신상품</a>
							</li>
							<li class="menu4">
								<a href="${contextPath }/user/bestGoodsPage.do" class="link_best" onclick="">베스트</a>
							</li>
							<li class="menu5">
								<a href="${contextPath }/user/saleGoodsPage.do" class="link_sale" onclick="">알뜰쇼핑</a>
							</li>
							<li class="menu6">
								<a href="${contextPath }/user/benefitPage.do" class="link_benefit" onclick="">특가/혜택</a>
							</li>
						</ul>
						
						<div id="allCate">
							<ul id="cateMain">
								<li id="sul"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/gift.png"/>설 선물세트</li>
								<li id="vegetables"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/carrot.png"/>채소</li>
								<li id="fruit"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/apple.png"/>과일ㆍ견과ㆍ쌀</li>
								<li id="seafood"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/fish.png"/>수산ㆍ해산ㆍ건어물</li>
								<li id="meat"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/meat.png"/>정육ㆍ계란</li>
								<li id="meal"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/soup.png"/>국ㆍ반찬ㆍ메인요리</li>
								<li id="salad"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/salad.png"/>샐러드ㆍ간편식</li>
								<li id="noodle"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/noodle.png"/>면ㆍ양념ㆍ오일</li>
								<li id="snack"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/cookie.png"/>간식ㆍ과자ㆍ떡</li>
								<li id="bakery"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/bakery.png"/>베이커리ㆍ치즈ㆍ델리</li>
								<li id="health"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/healthFood.png"/>건강식품</li>
								<li id="liquor"><img class="cateImg" src="/recipetoyou/Resources/User/Img/Cate/alcohol.png"/>전통주</li>
							</ul>
							<ul class="sul">
								<li>홍삼ㆍ즙ㆍ건강식품</li>	
								<li>정육ㆍ가공육ㆍ건육</li>
								<li>수산ㆍ건어물ㆍ젓갈</li>
								<li>과일ㆍ견과ㆍ곡류</li>
								<li>디저트ㆍ치즈ㆍ다과류</li>
								<li>면ㆍ양념ㆍ오일ㆍ캔류</li>
								<li>생활ㆍ주방ㆍ뷰티</li>
								<li>간편식ㆍ반찬</li>
							</ul>						
							<ul class="vegetables">
								<li>친환경</li>	
								<li>고구마ㆍ감자ㆍ당근</li>
								<li>시금치ㆍ쌈채소ㆍ나물</li>
								<li>브로콜리ㆍ파프리카ㆍ양배추</li>
								<li>양파ㆍ대파ㆍ마늘ㆍ배추</li>
								<li>오이ㆍ호박ㆍ고추</li>
								<li>냉동ㆍ이색ㆍ간편채소</li>
								<li>콩나물ㆍ버섯</li>
							</ul>
							<ul class="fruit">
								<li>친환경</li>	
								<li>제철과일</li>
								<li>국산과일</li>
								<li>수입과일</li>
								<li>간편과일</li>
								<li>냉동ㆍ건과일</li>
								<li>견과류</li>
								<li>쌀ㆍ잡곡</li>
							</ul>
							<ul class="seafood">
								<li>제철수산</li>	
								<li>생선류</li>
								<li>굴비ㆍ반건류</li>
								<li>오징어ㆍ낙지ㆍ문어</li>
								<li>새우ㆍ게ㆍ랍스터</li>
								<li>해산물ㆍ조개류</li>
								<li>수산가공품</li>
								<li>김ㆍ미역ㆍ해조류</li>
								<li>건어물ㆍ다시팩</li>
							</ul>
							<ul class="meat">
								<li>국내산소고기</li>	
								<li>수입산소고기</li>
								<li>돼지고기</li>
								<li>계란류</li>
								<li>닭ㆍ오리고기</li>
								<li>양념육ㆍ돈까스</li>
								<li>양고기</li>
							</ul>
							<ul class="meal">
								<li>국ㆍ탕ㆍ찌개</li>	
								<li>밀키트ㆍ메인요리</li>
								<li>밑반찬</li>
								<li>김치ㆍ젓갈ㆍ장류</li>
								<li>두부ㆍ어묵ㆍ부침개</li>
								<li>베이컨ㆍ햄ㆍ통조림</li>
							</ul>
							<ul class="salad">
								<li>샐러드ㆍ닭가슴살</li>	
								<li>도시락ㆍ밥류</li>
								<li>파스타ㆍ면류</li>
								<li>떡볶이ㆍ튀김ㆍ순대</li>
								<li>피자ㆍ핫도그ㆍ만두</li>
								<li>폭립ㆍ떡갈비ㆍ안주</li>
								<li>죽ㆍ스프ㆍ카레</li>
								<li>선식ㆍ시리얼</li>
							</ul>
							<ul class="noodle">
								<li>파스타ㆍ면류</li>	
								<li>식초ㆍ소스ㆍ드레싱</li>
								<li>양념ㆍ액젓ㆍ장류</li>
								<li>식용유ㆍ참기름ㆍ오일</li>
								<li>소금ㆍ설탕ㆍ향신료</li>
								<li>밀가루ㆍ가루ㆍ믹스</li>
							</ul>
							<ul class="snack">
								<li>과자ㆍ스낵ㆍ쿠키</li>	
								<li>초콜릿ㆍ젤리ㆍ캔디</li>
								<li>떡ㆍ한과</li>
								<li>아이스크림</li>
							</ul>
							<ul class="bakery">
								<li>식빵ㆍ빵류</li>	
								<li>잼ㆍ버터ㆍ스프레드</li>
								<li>케이크ㆍ파이ㆍ디저트</li>
								<li>치즈</li>
								<li>델리</li>
								<li>올리브ㆍ피클</li>
							</ul>
							<ul class="health">
								<li>영양제</li>	
								<li>유산균</li>
								<li>홍삼ㆍ인삼ㆍ꿀</li>
								<li>건강즙ㆍ건강음료</li>
								<li>건강분말ㆍ건강환</li>
								<li>다이어트ㆍ이너뷰티</li>
								<li>유아동</li>
							</ul>
							<ul class="liquor">
								<li>막걸리ㆍ약주</li>	
								<li>증류주ㆍ과실주</li>
							</ul>
						</div>
					</div>
				
				<div id="side_search" class="search"> <!-- search 검색  -->
						<input class="inp_search" type="search" placeholder="검색어를 입력해주세요.">
						<a href="#"><i class="fas fa-search"></i></a>
				</div>
				
				<div class="icons">	<!-- 아이콘 목록 -->
					<div class="location_set">	<!-- 배송지 등록 -->
						<a href="#"><i class="fas fa-map-marker-alt"></i></a>
					</div>
					<div class="pick_set">	<!-- 찜한 상품보기 -->
						<a href="#"><i class="far fa-heart"></i></a>
					</div>
					<div class="cart_set">	<!-- 장바구니 -->
						<a href="${contextPath}/cart.do"><i class="fas fa-shopping-cart"></i></a>
					</div>
				</div>
			</div>	<!-- head -->
		</div>	<!-- container -->

<script>
	$(document).ready(function (){
	     $('#catagoryMenu .menu1').mouseenter(function(){
	        $('#allCate ul').css('display','block');
	        $('.sul').css('display','block');
	        $('.sul').css('z-index','300');
        	$('.vegetables').css('display','none');
        	$('.fruit').css('display','none');
        	$('.seafood').css('display','none');
        	$('.meat').css('display','none');
        	$('.meal').css('display','none');
        	$('.salad').css('display','none');
        	$('.noodle').css('display','none');
        	$('.snack').css('display','none');
        	$('.bakery').css('display','none');
        	$('.health').css('display','none');
        	$('.liquor').css('display','none');
        	
	        $('#sul').mouseenter(function(){
	        	$('.sul').css('display','block');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.sul').mouseleave(function(){
	        		$('.sul').css('display','none');
	        	});
	        });
	        
	        $('#vegetables').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','block');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.vegetables').mouseleave(function(){
	        		$('.vegetables').css('display','none');
	        	});
	        });
	        $('#fruit').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','block');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.fruit').mouseleave(function(){
	        		$('.fruit').css('display','none');
	        	});
	        });
	        
	        $('#seafood').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','block');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.seafood').mouseleave(function(){
	        		$('.seafood').css('display','none');
	        	});
	        });
	        $('#meat').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','block');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.meat').mouseleave(function(){
	        		$('.meat').css('display','none');
	        	});
	        });
	        $('#meal').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','block');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.meal').mouseleave(function(){
	        		$('.meal').css('display','none');
	        	});
	        });
	        $('#salad').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','block');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.salad').mouseleave(function(){
	        		$('.salad').css('display','none');
	        	});
	        });
	        $('#noodle').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','block');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.noodle').mouseleave(function(){
	        		$('.noodle').css('display','none');
	        	});
	        });
	        $('#snack').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','block');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.snack').mouseleave(function(){
	        		$('.snack').css('display','none');
	        	});
	        });
	        $('#bakery').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','block');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','none');
	        	$('.bakery').mouseleave(function(){
	        		$('.bakery').css('display','none');
	        	});
	        });
	        $('#health').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','block');
	        	$('.liquor').css('display','none');
	        	$('.health').mouseleave(function(){
	        		$('.health').css('display','none');
	        	});
	        });
	        $('#liquor').mouseenter(function(){
	        	$('.sul').css('display','none');
	        	$('.vegetables').css('display','none');
	        	$('.fruit').css('display','none');
	        	$('.seafood').css('display','none');
	        	$('.meat').css('display','none');
	        	$('.meal').css('display','none');
	        	$('.salad').css('display','none');
	        	$('.noodle').css('display','none');
	        	$('.snack').css('display','none');
	        	$('.bakery').css('display','none');
	        	$('.health').css('display','none');
	        	$('.liquor').css('display','block');
	        	$('.liquor').mouseleave(function(){
	        		$('.liquor').css('display','none');
	        	});
	        });
	        
	    }); 
	    $('#allCate').mouseleave(function() {
	        $('#allCate ul').css('display','none');
	    });  
	});
</script>

</body>
</html>






