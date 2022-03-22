/**
 * 
 */
 
 /* 저장하기 버튼 클릭시 메세지 띄우기 */
function saveMessage() {
	if(confirm("설정사항을 저장하시겠습니까?") == true){
		document.form.submit();
	}else{
		return;
	}
}