var verify = function() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=station1Verify",
		data: "id=" + $("#doctor-id").val(),
		success: function(data){
			if (!!data) {
				switch(data.result) {
					case 0:
						$.common.layer.msg("审核成功！",  {icon: 1, time: 2000}, function() {
							openPage("/doctorexam/bpage/page/station1/verify.jsp","_self");
						});
						breack;
					case -101:
						toastr.error("考生信息不存在！");
						breack;
					case -102:
						toastr.error("考试未完成！");
						breack;
					case -103:
						toastr.error("已审核！");
						breack;
				}
			}
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
}

/**
 * 获取考生的成绩详细信息
 */
function getStation1ScoreDetail() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationScoreServlet?method=getStation1ScoreDetail",
		data: "id=" + $("#doctor-id").val(),
		success: function(data){
			$("#station1-score-n").processTemplate(data);
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
}

$(function(){
	// 检录-考区
	$("#station1-score-n").setTemplateElement("templete-m");
	
	getStation1ScoreDetail();
});

