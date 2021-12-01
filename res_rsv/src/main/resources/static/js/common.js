$(document).ready(function () {
	$('#searchInput').on('keydown', function (e) {
		if (e.keyCode === 13) {
			// ENTER KEY CODE
			search();
		}
	});

	$('#searchButton').on('click', function () {
		search();
	});
});

// 검색
function search() {
	var searchKeyword = $('#searchInput').val().trim();
	
	if (searchKeyword === "") {
		alert("검색어를 입력해주세요.");
		$('#searchInput').focus();
		return;
	}
	window.location.href = '/res/search?searchKeyword=' + searchKeyword;
}