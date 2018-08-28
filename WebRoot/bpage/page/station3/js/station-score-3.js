// JavaScript Document
/*
 * 文件名：station-score-3.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */

/**
 * 第二考站：已考完出站考生
 */
function displayStation3Exit() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation3Exit",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1Entrying", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#exit-num").text(data.exitNum);
			$("#exit-info-n").processTemplate(data.info);
		}
	});
}

/**
 * 查询显示页面数据
 */
function displayPageData() {
	// 考区考生
	displayStation3Entried();
	// 已考完出站考生
	displayStation3Exit();
}


$(function(){
	// 考区考生
	$("#entried-info-n").setTemplateElement("entried-info-m");
	// 已考完出站的考生
	$("#exit-info-n").setTemplateElement("exit-info-m");
	//显示页面数据
	displayPageData();
	//定时更新
	setInterval(displayPageData, 10*1000);
});