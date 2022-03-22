/**
 * 
 */
 
 /* 저장 버튼 클릭시 메세지 띄우기 */
function saveMessage(){
	if(confirm("이 설정대로 저장하시겠습니까?") == true){
		document.form.submit();
	}else{
		return;
	}
}

$(document).ready(function(){
	function addName(){
		$("#orderMsg").append('<div>{주문자}</div>');
	};
});


function addProduct(){
	const product = '<input type="text" value="{주문상품명}">';
	$("#orderMsg").append(name);
}

function addName(){
	const date= '<input type="text" value="{주문일}">';
	$("#orderMsg").append(name);
}

function addName(){
	const number = '<input type="text" value="{주문번호}">';
	$("#orderMsg").append(name);
}