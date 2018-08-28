// JavaScript Document
/*
 * 文件名：station-entry-1.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-24
 */

$(function(){
	// 检录-候考区
	$("#not-entry-info-n").setTemplateElement("templete-m");
	// 检录-考区
	$("#entried-info-n").setTemplateElement("templete-m");

	// 考站考生信息
	displayStation1Info();
});