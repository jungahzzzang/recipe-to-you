/**
 * 
 */
 	//사용
	function used() {

		if (confirm("선택하신 게시판의 사용여부를 '미사용'으로 변경하시겠습니까?") == true) {    //확인
			alert("성공적으로 정보가 적용 되었습니다.");
				document.getElementById("used1").innerText = "미사용";
		}
		else{   //취소
			return false;
	     
	 	}
	}
	
	//삭제
	function remove() {
	
		if (confirm("선택하신 게시판을 삭제하시겠습니까?") == true) {    //확인
			alert("성공적으로 정보가 삭제 되었습니다.");
		}
		else {   //취소
			return false;
		}
	}

	//리스트 순서이동
	//td 위로 이동
	function upbtn(ths) {
		var $td = $(ths).parent().parent();		// 클릭한 버튼이 속한 td 요소
			$td.prev().before($td);              	// 현재 td 의 이전 td 앞에 선택한 td 넣기
			alert("변경된 게시판 순서를 저장하였습니다.");
	}
	 
	//td 아래로 이동
	function dwbtn(ths) {
	    var $td = $(ths).parent().parent(); 		// 클릭한 버튼이 속한 td 요소
	    	$td.next().after($td);             		// 현재 td 의 다음 td 뒤에 선택한 td 넣기
	    	alert("변경된 게시판 순서를 저장하였습니다.");
	}
	
	