/**
 * 
 */

$(document).ready( function() {
//재고정보 테이블의 재고관리에서 '재고를 관리합니다' 선택시 1)재고옵션선택사항이 나타나고
//2)재고수량이 사라지는 기능
$("#stk1").click( function() {
	$(".table .stock_count").attr("style","display:none");
	$(".table .stock_option").attr("style","display:table-row");
});

//재고정보 테이블의 재고관리에서 '재고를 관리하지 않습니다' 선택시 1)재고옵션선택사항이 사라지고
//2)재고수량도 사라지고 3)옵션정보테이블이 사라지는 기능
$("#stk2").click( function() {
	console.log("aa");
	$(".table .stock_count").attr("style","display:none");
	$(".table .stock_option").attr("style","display:none");
	$(".option_fram").attr("style","display:none");
});

//옵션있음 클릭하면 - 재고수량 없어지고 옵션정보테이블 나타남.
$("#stock_option_use").click( function() {
		$(".table .stock_count").attr("style","display:none");
    	$(".option_fram").attr("style","display:table-row");
	});
 
//옵션없음 클릭하면 - 재고수량 나타나고 옵션정보테이블 사라짐.
$("#stock_option_useNo").click( function() {
		$(".table .stock_count").attr("style","display:table-row");
    	$(".option_fram").attr("style","display:none");
	});

//옵션등록버튼을 클릭하면 alert창 나타남
$('#goodsRegister_option').click(function() {
	$('#option_regist_frame').show();
	$("#is_required_frame").attr("style","display:none");
});

//옵션등록버튼을 클릭하면 보이는 alert창의 닫기버튼 누르면 alert창이 사라짐
$('#goodsRegister_optionClose').click(function() {
	$('#option_regist_frame').hide();
});  

//추가옵션등록버튼을 클릭하면 클릭하면 alert창 나타남
$('#goodsRegister_addOption').click(function() {
	$('#option_regist_frame').show();
	$("#is_required_frame").attr("style","display:table-row");
});  

// 상품추가 버튼 클릭시 화면에 타나나기
$('#goodsAdd_open').click(function() {
	$('#goodsAdd_frame').show();
});

//상품추가 팝업창에서 닫기 버튼 클릭시 화면 사라지기
$('.goods_close').click(function() {
	$('#goodsAdd_frame').hide();
});


//추가옵션 테이블에서 체크박스 전체선택 기능
$(function () {
	$('#checkboxAllChoice').click(function () {
		var checked = $('#checkboxAllChoice').is(':checked');
		
		if(checked)
			$('input.chChoice:checkbox').prop('checked',true);
		else 
			$('input.chChoice:checkbox').prop('checked',false);
	});
});


//상품추가 팝업창에서 체크박스 전체선택 기능
$(function () {
	$('#popupCheckboxAllChoice').click(function () {
		var checked = $('#popupCheckboxAllChoice').is(':checked');
		
		if(checked)
			$('input.popChChoice:checkbox').prop('checked',true);
		else 
			$('input.popChChoice:checkbox').prop('checked',false);
	});
});


//옵션정보에서 테이블에서 체크박스 전체선택 기능
$(function () {
	$('#optionCheckboxAllChoice').click(function () {
		var checked = $('#optionCheckboxAllChoice').is(':checked');
		
		if(checked)
			$('input.optionChChoice:checkbox').prop('checked',true);
		else 
			$('input.optionChChoice:checkbox').prop('checked',false);
	});
});

//GoodRegister_remove
$(document).ready(function() {
	$('#GoodRegister_remove').click(function(){
		alert('정말 삭제하시겠습니까?');
		
	});
});

		


function readURL(input, index) {
	if(input.files && input.files[0]){
		var reader = new FileReader();
		reader.onload = function(e){
			$('#goodsImg').attr('src',e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

/* CKEditor5 적용 */
	ClassicEditor
		.create(document.querySelector('#prod_content'))
		.catch(error=>{
			console.error(error);
		})

	});
		
	