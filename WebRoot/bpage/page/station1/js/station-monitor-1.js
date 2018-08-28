// JavaScript Document
/*
 * 文件名：station-monitor-1.js
 * 功能：第一考站-考场监控
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */

/**
 * 显示页面数据
 */
function displayPageData() {
	// 候考区考生信息
	displayStation1Inspected();
	// 考区考生信息
	displayStation1Entried();
}

$(function(){
	// 候考区考生信息
	$("#not-entry-info-n").setTemplateElement("not-entry-info-m");
	// 考区考生信息
	$("#entried-info-n").setTemplateElement("entried-info-m");
	//显示页面数据
	displayPageData();
	// 定时刷新
	setInterval(displayPageData, 10*1000);
});