/**
 * 
 */
 
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

