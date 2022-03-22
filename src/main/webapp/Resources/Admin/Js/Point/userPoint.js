/**
 * 
 */
 
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

function appliMessage(){
	alert('적립금 지급 회원을 선택하여주십시오');
}




