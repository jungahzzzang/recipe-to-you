/**
 * 
 */
 
 function remove_Address(){
	if(confirm("삭제 하시겠습니까?") == true){
		document.delForm.submit();
	}
	else{
		return;
	}
}

function openPop() {
	 window.open("addAddress.do", "배송지추가", "width=600, height=600");
}



function addAddr() {
         new daum.Postcode({
        	oncomplete: function(data) {
             
                var addr = ''; 
                var extraAddr = ''; 
 
                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else { 
                    addr = data.jibunAddress;
                }
 
                
                if(data.userSelectedType === 'R'){
                   
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    
                
                	addr += extraAddr;
                
					} 
                	else {
                    	addr += ' ';
                	}
                
                	$("#zonecode").val(data.zonecode);
                	$("#roadAddress").val(addr);
                
                	$("#namugiAddress").attr("readonly",false);
                	$("#namugiAddress").focus();
 
                
 
            }
		}).open();  
     }
	



	








	 
