Cmn = {
	//ajax 사용시 공통 되는 부분이 많아서 한번더 wrapper 함수
	ajax : function(url, data, success, error) {
		$.ajax({
			async: true,
			type: 'POST',
			dataType: 'text',
			url: url,
			cache: false,
			headers: { "cache-control": "no-cache","pragma": "no-cache" },
			data: data,
			success: success,
			error: error
		});
	}
};