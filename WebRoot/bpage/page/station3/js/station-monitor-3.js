// JavaScript Document
/*
 * 文件名：station-monitor-3.js
 * 功能：第三考站-考站监控
 * 作者：YuanjJingshan
 * 时间：2014-06-24
 */

/**
 * 显示页面数据
 */
function displayPageData() {
	// 候考区考生信息
	displayStation3NotEntry();
	// 考区考生信息
	displayStation3Entried();
}

$(function(){
	// 候考区考生信息
	$("#not-entry-info-n").setTemplateElement("not-entry-info-m");
	// 考区考生信息
	$("#entried-info-n").setTemplateElement("entried-info-m");
	// 显示页面数据
	displayPageData();
	// 考区考生信息
	setInterval(displayPageData, 10*1000);
});