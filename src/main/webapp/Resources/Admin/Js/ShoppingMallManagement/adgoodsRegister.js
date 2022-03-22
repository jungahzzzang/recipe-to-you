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
		});	

	
/* 유효성검사 */
	/*
 $(document).ready(function() : 함수 또는 코드가 호출 또는 실행되는 시점을 스케줄링할 수 있게 해준다.
		 =>그 시점은 바로 문서 객체 모델이라고 하는 DOM (Document Object Model)이 모두 로딩되었을 때.
	=>$(document).ready(function() 안에 위치한 코드를 DOM이 모두 준비된 이후에 실행되게끔 해준다.	 
*/
//$(document).ready(function(){
	
	/* 상품등록버튼 */
/* 저장버튼 클릭시 */
$(document).on("click", "#saveBtn", function(){
	
	
	/* 체크 변수 */	
	let cateCodeChk = false;
	let nameChk = false;
	let contentChk = false;
	let priceChk = false;
	let discountChk = false;
	let imgChk = false;
	let deliveryChk = false;
	let infoChk = false;
	let wrapChk = false;
	let vaildDateChk = false;
	let sellUnitChk = false;
	let quantityChk = false;
	


	/* 체크 대상 변수 */

	let cateCode = $("select[name='cateCode']").val();
	let name = $("input[name='prod_name']").val();
	let content = $("input[name='prod_content']").val();
	let price = $("input[name='prod_price']").val();
	let discount = $("input[name='prod_discount']").val();
	let img = $("input[name='prod_img']").val();
	let delivery = $("input[name='prod_delivery_type']").val();
	let info = $("input[name='prod_info']").val();
	let wrap = $("input[name='prod_wrap_type']").val();
	let vaildDate = $("input[name='prod_vaild_date']").val();
	let sellUnit = $("input[name='prod_sell_unit']").val();
	let quantity = $("input[name='prod_quantity']").val();
	


	/* 각 항목 확인 */
	/* 공란일 경우 <span>태그를 보이도록 하고 '체크 변수'에 false값을 대입한다. */
	/* 공란이 아닐 경우 <span> 태그를 숨기고 '체크 변수'에 true값을 대입한다. */


	if(cateCode){
		$(".cateCode_msg").css('display','none');
		cateCodeChk = true;
	} else{
		$(".cateCode_msg").css('display','block');
		cateCodeChk = false;
	}	
	if(name){
		$(".prod_name_msg").css('display','none');
		nameChk = true;
	} else{
		$(".prod_name_msg").css('display','block');
		nameChk = false;
	}
	if(content){
		$(".prod_content_msg").css('display','none');
		contentChk = true;
	} else{
		$(".prod_content_msg").css('display','block');
		contentChk = false;
	}
	if(price){
		$(".prod_price_msg").css('display','none');
		priceChk = true;
	} else{
		$(".prod_price_msg").css('display','block');
		priceChk = false;
	}
	
	if(!isNaN(discount)){
		$(".prod_discount_msg").css('display','none');
	} else{
		$(".prod_discount_msg").css('display','block');
		priceChk = false;
	}	
	
	if(img){
		$(".prod_img_msg").css('display','none');
		imgChk = true;
	} else{
		$(".prod_img_msg").css('display','block');
		imgChk = false;
	}

	if(delivery){
		$(".prod_delivery_msg").css('display','none');
		deliveryChk = true;
	} else{
		$(".prod_delivery_msg").css('display','block');
		deliveryChk = false;
	}

	if(info){
		$(".prod_info_msg").css('display','none');
		infoChk = true;
	} else{
		$(".prod_info_msg").css('display','block');
		infoChk = false;
	}

	if(wrap){
		$(".prod_wrap_msg").css('display','none');
		nameChk = true;
	} else{
		$(".prod_wrap_msg").css('display','block');
		nameChk = false;
	}

	if(vaildDate){
		$(".prod_vaild_date_msg").css('display','none');
		vaildDateChk = true;
	} else{
		$(".prod_vaild_date_msg").css('display','block');
		vaildDateChk = false;
	}

	if(sellUnit){
		$(".prod_sell_unit_msg").css('display','none');
		sellUnitChk = true;
	} else{
		$(".prod_sell_unit_msg").css('display','block');
		sellUnitChk = false;
	}		

	if(quantity){
		$(".prod_quantity_msg").css('display','none');
		quantityChk = true;
	} else{
		$(".prod_quantity_msg").css('display','block');
		quantityChk = false;
	}
	
	/* '체크 변수'들이 모두 true일 때 <form>태그 전송 */ 
	/*if(cateCodeChk && nameChk && contentChk && priceChk &&  imgChk &&
	deliveryChk && infoChk && wrapChk && vaildDateChk && sellUnitChk && quantityChk){*/

		$("#registerForm").submit();
		
	/*} else{
		return false;
	}*/	

});

/* 상품목록 버튼 클릭시 */
$("#listBtn").click(function(){
	location.href='${contextPath}/adgoods/listProduct.do';
});


/*유통기한 입력 위한 캘린더 위젯 적용*/

/* 설정 */
const config = {
		dateFormat: 'yy-mm-dd',
		showOn : "button",
		buttonText : "날짜 선택",
		prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    yearSuffix: '년',
	    changeMonth: true,
        changeYear: true
}

/* 캘린더 */
$(function(){
	$("input[name='prod_vaild_date']").datepicker(config);
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
	
/*document.getElementById("fileItem").onchange = function(){
	
	var reader = new FileReader();
	
	if(this.files && this.files[0]){
		
		reader.onload = function(data){
			document.getElementById("goodsImg").src = data.target.result;
	};
	reader.readAsDataURL(this.files[0]);
	
	};
	
};*/
 




