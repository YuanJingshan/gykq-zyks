// JavaScript Document
/*
 * 文件名：modify-score-1.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */
/**
 * 分数确认提交
 */
function modifyStation1scoreConfirm() {
	var dataStr = "&id=" + $("#doctor-id").val();
	$(".score-count").each(function(){
		dataStr = dataStr + "&" + this.id + "=" + $(this).text();
	});
	dataStr = dataStr + "&count=" + $("#count").text();
	dataStr = $("#station1-score-n").serialize() + dataStr;
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationScoreServlet?method=modifyStation1Score",
		data: dataStr,
		success: function(data){
			if (data.result == 1) {
				$.common.layer.msg("修改成功！",  {icon: 1, time: 2000}, function() {
					openPage("/doctorexam/bpage/page/station1/score-list-1.jsp","_self");
				});
			} else if (data.result == -101) {
				toastr.error("总分大于100，请仔细检查！");
			} else {
				toastr.error("修改分数失败！");
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
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("getStation1ScoreDetail", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#station1-score-n").processTemplate(data);
		}
	});
}

$(function(){
	// 检录-考区
	$("#station1-score-n").setTemplateElement("templete-m");
	getStation1ScoreDetail();
});

