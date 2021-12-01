var isPaging = false;
var isFinished = false;

$(document).ready(function () {
	$(window).on('scroll', function (e) {
		let scrollLocation = document.documentElement.scrollTop; // 현재 스크롤바 위치
		let windowHeight = window.innerHeight; // 스크린 창
		let fullHeight = document.body.scrollHeight; //  margin 값은 포함 x
	
		if(!isFinished && !isPaging && scrollLocation + windowHeight + 150 >= fullHeight){
			isPaging = true;
			var pageNum = parseInt($('#pageNum').val());
			pageNum++;
			$('#pageNum').val(pageNum);
			$.ajax({
				url : '/res/search/ajax',
				method: 'GET',
				data : $('#pagingForm').serialize(),
				success : function (data) {
					for (var i=0; i<data.length; i++) {
						var html = '<li>';
							html+= '<a href="/res/detail/' + data[i].no + '">';
							html+= '	<img class="thumb" alt="res-thumb" src="' + data[i].thumb + '">';
							html+= '	<span class="item-title">' + data[i].nm + '</span>';
							html+= '</a>';
							html+= '<span class="item-addr">'+ data[i].addr + " " + data[i].betterAddr +'</span>';
							html+= '</li>';
							$('#rsItemList').append(html);
					}
					
					if (data.length < 6) {
						isFinished = true;
					}
				},
				complete : function () {
					setTimeout(function () {
						isPaging = false;
					}, 500);
				}
			})
		}
	})
	
	$('#sword').on('keydown', function (e) {
		if (e.keyCode === 13) {
			// ENTER
			search2();
		}
	})
});

function search2() {
	var searchKeyword = $('#sword').val().trim();

	if (searchKeyword === "") {
		alert("검색어를 입력해주세요.");
		$('#sword').focus();
		return;
	}
	window.location.href = '/res/search?searchKeyword=' + searchKeyword;
}