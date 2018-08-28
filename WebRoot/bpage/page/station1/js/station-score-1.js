// JavaScript Document
/*
 * 文件名：station-entry-1.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */
/**
 * 第一考站：已考完出站考生
 */
function displayStation1Exit() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation1Exit",
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
 * 更新页面数据
 */
function dispalyPageData() {
	// 考区考生
	displayStation1Entried();
	// 已考完出站考生
	displayStation1Exit();
}

$(function(){
	// 考区考生
	$("#entried-info-n").setTemplateElement("entried-info-m");
	// 已考完出站的考生
	$("#exit-info-n").setTemplateElement("exit-info-m");
	
	//显示页面数据
	dispalyPageData();
	//定时更新
	setInterval(dispalyPageData, 10*1000);
});