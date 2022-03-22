/**
 * 
 */
  function goUrl(url) {
		location.href=url;
	}
	// 회원가입 시 입력안한 칸이 있는지 확인
	function boardWriteCheck() {
		var form = document.userInfo;
		
		if (form.u_id.value == '' || form.u_id.value == null) {
			alert('아이디를 입력하세요.');
			form.u_id.focus();
			return false;
		}
		
		if (form.pwd.value == '' || form.pwd.value == null) {
			alert('비밀번호를 입력하세요');
			form.pwd.focus();
			return false;
		}
		if (form.repwd.value == '' || form.repwd.value == form.pwd.value) {
			alert('비밀번호가 다릅니다.');
			form.repwd.focus();
			return false;
		}
	
	}