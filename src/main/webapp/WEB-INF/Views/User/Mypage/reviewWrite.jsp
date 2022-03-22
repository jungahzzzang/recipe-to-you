<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지_주문내역</title>
<link rel="stylesheet"
	href="/recipetoyou/Resources/User/Css/Mypage2/reviewWrite.css">
<link href="/recipetoyou/Resources/User/Css/Mypage2/reset.css" rel="stylesheet"
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
<link href="/recipetoyou/Resources/User/Img/Mypage2/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<script src="/recipetoyou/Resources/Common/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<!-- datepicker 적용 -->
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>
		<form action="${contextPath}/goods/insertReview.do" id="reviewFrm" method="post">
		<input type="hidden" id="prod_code" name="prod_code" value="${param.prod_code }">
		<div class="content">
		
			<div class="review_main">
					<h2 class="title">후기작성</h2>
						<div class="reviewWriteWrap">

							<td colspan="4">
								소중한 후기를 남겨주세요.
							</td>
							<td colspan="4">
								궁금하신 게 있다면 언제든지 물어봐주세요^^
							</td>
								<table class="reviewWrite">
									<tr class="reviewWriteTitle">
										<th>
											제목
										</th>
										<td>
											<input name="title" id="title" type="text" placeholder="제목을 입력해주세요."/>
												<input type="text" hidden="hidden" name="prod_code" value="${prod_code}">"
										</td>
									</tr>
									<tr class="userId">
										<th>
											사용자 아이디
										</th>
										<td>
											${userVO.user_id }
										</td>
									</tr>
									<tr class="content">
										<th>
											후기작성
										</th>
										<td>
											<textarea placeholder="자세한 후기는 다른 고객의 구매에 많은 도움이 되며,&#13;&#10;일반식품의 효능이나 효과 등에 오해의 소지가 있는 내용을 작성 시 검토 후 비공개 조치될 수 있습니다.&#13;&#10;반품/환불 문의는 1:1문의로 가능합니다."
											id="content" name="content"
											></textarea>
										</td>
									</tr>

									<div class="writeBtn">
								
									<button type="button" id="write" class="writeBtn">글쓰기</button>
									</div>

								</table>
							</form>
						</div>
		
			</div>
			<!-- review_main -->
		</div>
		<!-- content -->
		
		<script type="text/javascript">
		
		/* CKEditor5 적용 */
		var ckeditor_config = {
			resize_enaleb : false,
			enterMode : CKEDITOR.ENTER_BR,
			shiftEnterMode : CKEDITOR.ENTER_P,
			filebrowserUploadUrl : "${contextPath}/goods/ckimageUpload.do"
			}
			CKEDITOR.replace("content", ckeditor_config);
		
		 $(document).ready(function(){
		    	
	    	  $("#write").on("click",function(e){	//작성하기 버튼
	    		  e.preventDefault();
	    		  fn_insertReview();
	    	  });
	    	  
	    	  /*$("#update").on("click",function(e){ //수정하기 버튼
	    		  e.preventDefault();
	    		  fn_updateReview();
	    	  });*/
	    	  
	    	  function fn_insertReview(){	//후기 작성 유효성 체크
		    	  //var comSubmit = new ComSubmit("reviewFrm");	//객체 생성
		    	  //comSubmit.setUrl("${contextPath}/goods/insertReview.do'/>");	//url 설정
		    	  
		    	  var newForm = document.createElement('reviewFrm');
		    	  newForm.name='reviewFrm';
		    	  newForm.method='post';
		    	  newForm.action='${contextPath}/goods/insertReview.do';
		    	  
		    	  //제목 필요
		    	  if(!$("#title").val()){
		    		  alert("제목을 입력해주세요.");
		    		  $("#title").focus();
		    		  return false;
		    	  }
		    	  
		    	  //내용 필요
		    	  if(CKEDITOR.instances.content.getData()==''||CKEDITOR.instances.content.getData().length==0){
		    		  alert("내용을 입력해주세요.");
		    		  $("#content").focus();
		    		  return false;
		    	  }
		    	  
		    	  $("#reviewFrm").submit();
		    	  
		      }
	    	  
	      });
		

			
	     

		</script>

</body>
</html>






















