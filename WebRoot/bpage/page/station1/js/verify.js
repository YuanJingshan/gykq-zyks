var getScoreData = function() {
	debugger;
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation1Exit",
		success: function(data){
			if(!!data) {
				$("#score_num").text(data.exitNum);
				$("#score_info_n").processTemplate(data.info);
			}
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
}

var getVerifyData = function() {
	debugger;
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation1Verify",
		success: function(data){
			if(!!data) {
				$("#verify_num").text(data.num);
				$("#verify_info_n").processTemplate(data.info);
			}
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
}

/**
 * 更新页面数据
 */
function dispalyPageData() {
	getScoreData();
	getVerifyData();
}

$(function(){
	// 已登分考生
	$("#score_info_n").setTemplateElement("score_info_m");
	// 已审核考生
	$("#verify_info_n").setTemplateElement("verify_info_m");
	
	dispalyPageData();
	
	//定时更新
	setInterval(dispalyPageData, 10*1000);
});