$(document).ready(function() {
	var state = "expanded";
	//Check if navbar is expanded or minimized and handle 
	$('#navbar-toggle').click(function() {
		if (state == "expanded") {
			$('.sidebar').css('margin-left', '-180px');
			state = "minimized";
		} else {
			if (state == "minimized") {
				$('.sidebar').css('margin-left', '0px');
				state = "expanded";
			}
		}
	});
});

function adminLogin() {
	$.ajax({
		url: '/admin/login',
		method: 'POST',
		data: {
			username: $('#username').val(),
			password: $('#password').val()
		},
		success: function(data) {
			console.log(data);
			if (data.result) {
				window.location.reload();
			} else {
				alert(data.message);
			}
		}
	})
}