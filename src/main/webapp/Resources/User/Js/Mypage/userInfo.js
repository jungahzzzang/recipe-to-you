/**
 *
 */
 

$(documenct).ready(function(){
	
});

function duplicate(){
		var email=$("#email").val();

		var submitObj = new Object();
		submitObj.email=email;
		
		$.ajax({
			url : "/emailChk.do",
			type : "POST",
			contentType : "application/json; charset-utf-8",
			data : JSON.stringify(submitObj),
			dataType : "json"
			}).done(function(resMap) {
			if (resMap.res == "ok") {
			if (resMap.emailChk == 0) {
			alert("사용할 수 있는 이메일입니다.");
			$("#user_name_yn").val("Y");
			} else {
			alert("중복된 이메일입니다.");
			$("#user_name_yn").val("N");
			}
			}
			
			}).fail(function(e) {
			alert("등록 시도에 실패하였습니다.");
			}).always(function() {
			pass = false;
			});
			
			}
 
function fnSubmit(){
	var email_rule =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if ($("#name").val() == null || $("#name").val() == "") {
		alert("이름을 입력해주세요.");
		$("#name").focus();
		 
		return false;
		}
		 
		if ($("#email").val() == null || $("#email").val() == "") {
		alert("이메일을 입력해주세요.");
		$("#email").focus();
		 
		return false;
		}
			
		if ($("#user_name_yn").val() != 'Y') {
			alert("닉네임 중복체크를 눌러주세요.");
			$("#user_name_yn").focus();
			 
			return false;
			}
		
		if (confirm("수정하시겠습니까?")) {
			 
			$("#infoSubmit").submit();
			 
			return false;
			}
			
			
			
}