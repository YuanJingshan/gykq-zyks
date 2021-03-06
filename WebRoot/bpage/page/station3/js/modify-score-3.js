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
function modifyStation3scoreConfirm() {
	var dataStr = "&id=" + $("#doctor-id").val();
	$(".score-count").each(function(){
		dataStr = dataStr + "&" + this.id + "=" + $(this).text();
	});
	dataStr = dataStr + "&count=" + $("#count").text();
	dataStr = $("#station3-score-n").serialize() + dataStr;
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationScoreServlet?method=modifyStation3Score",
		data: dataStr,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("modifyStation3scoreConfirm", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 1) {
				alert("修改成功！");
				openPage("/doctorexam/bpage/page/station3/score-list-3.jsp","_self");
			} else if (data.result == -101) {
				alert("总分大于100，请仔细检查！");
			} else {
				alert("修改分数失败！");
			}
		}
	});
}

/**
 * 获取考生的成绩详细信息
 */
function getStation3ScoreDetail() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationScoreServlet?method=getStation3ScoreDetail",
		data: "id=" + $("#doctor-id").val(),
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("getStation3ScoreDetail", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#station3-score-n").processTemplate(data);
		}
	});
}

$(function(){
	// 检录-考区
	$("#station3-score-n").setTemplateElement("templete-m");
	getStation3ScoreDetail();
});

