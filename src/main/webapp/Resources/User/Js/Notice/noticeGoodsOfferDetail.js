var fileNo = 1;
			$(document).ready(function() {
				$('.QAList1').click(function() {
					$('.QADetail1').fadeToggle();
				});
				
				$('#fileUpBtn').click(function() {
					if(fileNo <= 5){
					 $('.offerImgDiv'+fileNo).css("display","block");
					fileNo = fileNo +1;
					}else {
						alert('최대 5개까지만 추가가 가능합니다.');
					}
				});
				
				$(".offerImgDiv2").click(function(){
					 $('.offerImgDiv2').css("display","none");
					fileNo = fileNo -1;
				});
				$(".offerImgDiv3").click(function(){
					 $('.offerImgDiv3').css("display","none");
					fileNo = fileNo -1;
				});
				$(".offerImgDiv4").click(function(){
					 $('.offerImgDiv4').css("display","none");
					fileNo = fileNo -1;
				});
				$(".offerImgDiv5").click(function(){
					 $('.offerImgDiv5').css("display","none");
					fileNo = fileNo -1;
				});
				
			});
			function QAdelte(){
				alert('삭제되었습니다.');
			}