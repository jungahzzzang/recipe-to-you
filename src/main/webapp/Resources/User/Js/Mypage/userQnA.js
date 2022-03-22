function Open() {
	if(document.getElementById('content').style.display === 'block') {
		document.getElementById('content').style.display = 'none';
	} 
	else {
		document.getElementById('content').style.display = 'block';
	}
}
		
function remove_QnA(){
	if(confirm("작성한 문의를 삭제 하시겠습니까?") == true){
		document.delForm.submit();
	}
	else{
		return;
	}
}


