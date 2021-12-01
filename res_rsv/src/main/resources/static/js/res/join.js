function joinMbr() {
	var id = $('#id').val();
	var pw = $('#pw').val();
	var pwCheck = $('#pwCheck').val();
	var nm = $('#nm').val();
	var phoneNum = $('#phoneNum').val();
	var email = $('#email').val();
	
	if (id.trim() == '') {
		alert("아이디를 입력해주세요.");
		$('#id').focus();
		return;
	}
	
	if (pw.trim() == '') {
		alert("비밀번호를 입력해주세요.");
		$('#pw').focus();
		return;
	}
	
	if (pwCheck.trim() == '') {
		alert("비밀번호 확인을 입력해주세요.");
		$('#pwCheck').focus();
		return;
	}
	
	if (pw !== pwCheck) {
		alert("비밀번호가 틀렸습니다.");
		$('#pw').val("");
		$('#pwCheck').val("");
		$('#pw').focus();
		return;
	}
	
	if (nm.trim() == '') {
		alert("이름을 입력해주세요.");
		$('#nm').focus();
		return;
	}
	
	if (phoneNum.trim() == '') {
		alert("휴대폰 번호를 입력해주세요.");
		$('#phoneNum').focus();
		return;
	}
	
	if (email.trim() == '') {
		alert("이메일을 입력해주세요.");
		$('#email').focus();
		return;
	}
	
	$('#joinForm').submit();
}