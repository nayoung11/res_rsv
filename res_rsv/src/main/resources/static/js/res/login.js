function loginMbr() {
	var id = $('#id').val();
	var pw = $('#pw').val();
	
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
	
	$.ajax({
		url : '/res/login',
		method: 'POST',
		data : $('#loginForm').serialize(),
		success : function (data) {
			console.log(data);
			
			if (data.result) {
				window.location.href = '/';
			} else {
				alert(data.message);
			}
		}
	})
}