// JavaScript Document
/*
 * 文件名：exam-monitor.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */

var stationJK = function(station) {
	var params = "station=" + station;
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationInfoServlet?method=info",
		data: params,
		success: function(data){
			if(!!data) {
				var result = [];
				$.each(data.wait.info, function(index, value){
					result.push(value);
				});
				$.each(data.exam.info, function(index, value){
					result.push(value);
				});
				/*result.push(data.wait.info);
				result.push(data.exam.info);*/
				
				switch(station) {
					case 4:
						$("#wait-num-4").text(data.wait.count);
						$("#exam-num-4").text(data.exam.count);
						$("#station4-info").processTemplate(result);
						break;
					case 5:
						$("#wait-num-5").text(data.wait.count);
						$("#exam-num-5").text(data.exam.count);
						$("#station5-info").processTemplate(result);
						break;
					case 6:
						$("#wait-num-6").text(data.wait.count);
						$("#exam-num-6").text(data.exam.count);
						$("#station6-info").processTemplate(result);
						break;
					default:
						break;
				}
			}
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
}

/**
 * 显示页面数据
 */
function displayPageData() {
	getNotEntStryation1Doctor(); // 入口检录
	displayStation1InfoJk(); // 第一考站
	displayStation2InfoJk(); // 第二考站
	displayStation3InfoJk(); // 第三考站
	stationJK(4);
	stationJK(5);
	stationJK(6);
	getExitVerifyInfo(); // 出口审核
}

$(function(){
    $("#inspect-info-n").setTemplateElement("templete-a-m");
    $("#station1-info").setTemplateElement("templete-m");
    $("#station2-info").setTemplateElement("templete-m");
    $("#station3-info").setTemplateElement("templete-m");
    $("#station4-info").setTemplateElement("templete-m");
    $("#station5-info").setTemplateElement("templete-m");
    $("#station6-info").setTemplateElement("templete-m");
    $("#exit-verify-info-n").setTemplateElement("templete-e-m");
    
    //显示页面数据
    displayPageData();
	// 每隔10秒钟则刷新一次页面数据
	setInterval(displayPageData, 10*1000);
});