<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />
	
<!DOCTYPE html>
<html>
<head>
<link
	href="/recipetoyou/Resources/User/Css/Community/communityRecipeModify.css"
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
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link href="/recipetoyou/Resources/User/Img/KurlyIcon.png" rel="icon"
	type="image/x-icon" />
<script type="text/javascript" src="/recipetoyou/Resources/Common/ckeditor/ckeditor.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div class="main">
			<form name="frmRecipe" enctype="multipart/form-data">
				<h2>레시피등록</h2>
				<div class="content">
					<div class="title">
						<div class="recipeTitle">
							<span>Recipe Title</span>
							<input type="text" name="recipe_title" placeholder="예) 소고기 미역국 끓이기" />
	
						</div>
						<div class="cate">
							<span>Category </span> 
							<select class="cate1">
							</select> 
							<select  class="cate2" name="recipe_cate_code">
							</select> 
						</div>
						<div class="recipeIngred">
							<span>Ingredient</span>
							<textarea name="recipe_ingre"
							placeholder="나만의 레시피에 들어가는 요리 재료를 적어주세요. ex)미역국에 필요한 재료"></textarea>
						</div>
					
					</div>
						<div class="contents">
							<h3>대표이미지 등록</h3>
							<input type="file" name="recipe_img"/>
					</div>
					
				</div>
				<div class="recipeContent">
					<span>Recipe Content</span>
				</div>
				<textarea name="recipe_content"></textarea>
					<script type="text/javascript">
							CKEDITOR.replace('recipe_content', {
			                    height: 300,
			                    filebrowserUploadUrl: "${contextPath}/mine/imageUpload.do"
			                 });
							CKEDITOR.instances.recipe_content.getData();
					</script>
				<input type="hidden" name="prod_code"/>
					
				<div class="writeBtn">
					<button type="button" onclick="recipeWrite()">글쓰기</button>
				</div>
	
			</form>
		</div>
	</div>


<script>
	function recipeWrite(){ 
		var recipe_content = CKEDITOR.instances.recipe_content.getData();
		var recipe_ingre = frmRecipe.recipe_ingre.value;
		var recipe_cate_code = frmRecipe.recipe_cate_code.value;
		var recipe_img = frmRecipe.recipe_img.value;
		var prod_code = frmRecipe.prod_code.value;
		var recipe_title = frmRecipe.recipe_title.value;
		if(recipe_title == "" || recipe_title == null){
			alert("제목을 입력해주세요.")
		}else if(recipe_ingre == "" || recipe_ingre == null){
			alert("재료를 입력해주세요.");
		}else if(recipe_img == "" || recipe_img == null || recipe_img == undefined){
			alert("섬네일 이미지를 등록해주세요.");
		}else if(recipe_content == "" || recipe_content == null){
			alert("내용을 입력해주세요.");
		}else{
			frmRecipe.method="post";
			frmRecipe.action = "${contextPath}/community/communityRecipeWriteProcess.do";
			frmRecipe.submit();
		}
	}

$(document).ready(function(){
	let cateList = JSON.parse('${cateList}');
	
	let cate1Array = new Array();
	let cate2Array = new Array();
	
	let cate1Obj = new Object();
	let cate2Obj = new Object();
	
	let cateSelect1 = $(".cate1");		
	let cateSelect2 = $(".cate2");
	var a = 1;
	for(let i = 0; i < cateList.length; i++){
		
		if(cateList[i].recipe_cate_code == a){
			let cate1Obj = new Object();
			cate1Obj.recipe_cate_code = cateList[i].recipe_cate_code;
			cate1Obj.recipe_cate = cateList[i].recipe_cate;
			cate1Obj.recipe_cate_parent = cateList[i].recipe_cate_parent;
			cate1Array.push(cate1Obj);				
			
		}
		a = a+1;
	}
	
	
	function makeCateArray(obj,array,cateList){
		for(let i = 0; i < cateList.length; i++){
				obj = new Object();
				obj.recipe_cate_code = cateList[i].recipe_cate_code;
				obj.recipe_cate = cateList[i].recipe_cate;
				obj.recipe_cate_parent = cateList[i].recipe_cate_parent;
				
				array.push(obj);				
			}
	}	
	
	makeCateArray(cate2Obj,cate2Array,cateList);
	
	for(let i = 0; i < cate1Array.length; i++){
		cateSelect1.append("<option value='"+cate1Array[i].recipe_cate_code+"'>" + cate1Array[i].recipe_cate + "</option>");
	}
	
	$(cateSelect1).on("change",function(){
		let selectVal1 = $(this).find("option:selected").val();	
		
		cateSelect2.children().remove();
		
		cateSelect2.append("<option value='none'>선택</option>");
		
		for(let i = 0; i < cate2Array.length; i++){
			if(selectVal1 == cate2Array[i].recipe_cate_parent && cate2Array[i].recipe_cate != '전체'){
				cateSelect2.append("<option value='"+cate2Array[i].recipe_cate_code+"'>" + cate2Array[i].recipe_cate + "</option>");	
			}
		}
	});
});
	
		
</script>
	
</body>
</html>