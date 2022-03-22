/**
 * 
 */
 
 $("#checkAll").click(function(){
			
		});
		
		/* 체크박스 전체 선택 및 해제 */
		$(document).on('click', '#checkAll', function(){
			if($('#checkAll').is(':checked')){
				$('.checkGroup').prop('checked', true);
			}else{
				$('.checkGroup').prop('checked', false);
			}
		});
		
		/* 체크박스 개별 선택 */
		$(document).on('click','.checkGroup',function(){ 
		    if($('.checkGroup:not(:disabled)').length == $('.checkGroup:checked').length){
		        $('#checkAll').prop('checked',true);
		    }else{
		        $('#checkAll').prop('checked',false);
		    }
		});
		
		/* 삭제 버튼 클릭시 메세지 띄우기 */
		function deleteMessage() {
			if(confirm("선택하신 발송내역을 삭제하시겠습니까?") == true){
				document.form.submit();
			}else{
				return;
			}
		}
		
		/* 달력 위젯 */
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