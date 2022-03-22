/**
 * 
 */
 
 /* 저장 버튼 클릭시 메세지 띄우기 */
function saveMessage() {
	alert("저장되었습니다.")
}

/* 초기화 버튼 클릭시 메세지 띄우기 */
function resetMessage(){
	if(confirm("설정을 초기화하시겠습니까?") == true){
		document.form.submit();
	}else{
		return;
	}
}