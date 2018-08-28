//JavaScript Document
/*************************************************************************
 * 文件名：score-list-2.js
 * 功能：第二考站-考站成绩列表
 * 作者：YuanjJingshan
 * 时间：2014-06-12
 *************************************************************************/

/**
 * 删除会员
 * @return
 */
function deleteTeam() {
	if (getSelectId().idStr == '') {
		alert("请选择要删除的医生考试信息！");
	} else {
		deleteById(getSelectId().idStr);
	}
}

//加载页面
$(function() { 
	// 附上模版数据
	$("#tmplete-n").setTemplateElement("tmplete-m");
	// 时间控件
	$('#start-dt').datetimepicker({lang:"ch"});
	$('#end-dt').datetimepicker({lang:"ch"});
	
	// 分页
	setParam(10,"stationScoreServlet?method=getCountSecond","stationScoreServlet?method=getPageDataSecond","stationScoreServlet?method=deleteSecond","pageSize=10&pageNum=");
	getPageCount();
	getPageAndDisplay();
	
	// 刷新
	$("#refresh").click(function() {
		refresh();
	});

	// 删除
	$("#delete").click(function() {
		deleteTeam();
	});	
	
	// 全选
	$(".checkAll").click(function() {	
		var checkFlag = $(".checkAll").attr("checked");
		if (checkFlag == "checked") {
			selectAll();
		} else if (checkFlag == undefined){
			cacalSelAll();
		}
	});
	
	$("#query-condition").change(function(){
		// 条件选择
		conditionChoose();
	});
});