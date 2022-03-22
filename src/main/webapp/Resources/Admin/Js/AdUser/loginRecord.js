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

/* 3개월 로그 버튼 클릭시 메세지 띄우기 */
function threeMsg(){
	if(confirm("3개월전 로그 데이터를 삭제하시겠습니까?") == true){
		document.form.submit();
	}else{
		return;
	}
}
/* 로그 초기화 버튼 클릭시 메세지 띄우기 */
function dellogMsg(){
	if(confirm("로그 데이터를 초기화하시겠습니까?") == true){
		document.form.submit();
	}else{
		return;
	}
}