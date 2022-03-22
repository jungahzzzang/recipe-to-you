/**
 * 
 */
 
$(document).ready(function() {
	let moveForm = $("#moveForm");
	
	
	
	$(".pagination a").on("click", function(e){
		e.preventDefault();
		moveForm.find("input[name='page']").val($(this).attr("href"));
		moveForm.attr("action", "listadPay.do");
		moveForm.submit();
		
	});		
	
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
 /* 체크 박스 전체 선택과 전체 취소 */
	
$(function(){
	$("#checkAll").click(function(){
		/* checkAll이 체크되었을 때 */
		/* chk라는 name을 가진 input 태그를 찾아 checked를 true로 정의 */
		if($("#checkAll").prop("checked")){
			$("input[name=chk]").prop("checked", true)
			/* checkAll이 체크되지 않았을 때 */
			/* chk라는 name을 가진 input 태그를 찾아 checked를 false로 정의 */
		}else{
			$("input[name=chk]").prop("checked", false)
		}
	})
});

/* 버튼으로 전체 선택과 전체 취소 구현 */
jQuery(document).ready(function($){
   $("#check_all").click(function() {
        $("input[name=chk]:checkbox").attr("checked", true);
    });
  $("#uncheck_all").click(function() {
       $("input[name=chk]:checkbox").attr("checked", false);
  });
 	/*   $("#count_check").click(function() {
        alert($("input[name=chk]:checkbox:checked").length);
    }); */
});

/* 달력 */
window.onload = function(){
  $.datepicker.setDefaults({
    dateFormat: 'yy-mm',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
  });
  
  $(function() {
    $("#datepicker1, #datepicker2").datepicker();
  });
}

/* 삭제 버튼 클릭시 메세지 띄우기 */
function deleteMessage() {
	if(confirm("선택하신 회원을 삭제하시겠습니까?") == true){
		document.form.submit();
	}else{
		return;
	}
}
	
/* 엑셀 저장하기 버튼 클릭시 메세지 띄우기 */
function saveMessage() {
	if(confirm("현재 목록을 엑셀파일로 저장하시겠습니까?") == true){
		document.form.submit();
	}else{
		return;
	}
}

