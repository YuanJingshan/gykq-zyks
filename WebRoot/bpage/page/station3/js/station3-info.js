// JavaScript Document
/*
 * 文件名：station3-info.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-24
 */

/**
 * 显示第二站考生信息
 */
function displayStation3Info() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation3Info",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1Info", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntry.count);
			$("#entried-num").text(data.entried.count);
			$("#not-entry-info-n").processTemplate(data.notEntry.info);
			$("#entried-info-n").processTemplate(data.entried.info);
		}
	});
}

$(function(){
	// 检录-候考区
	$("#not-entry-info-n").setTemplateElement("templete-m");
	// 检录-考区
	$("#entried-info-n").setTemplateElement("templete-m");

	// 考站考生信息
	displayStation3Info();
});