//JavaScript Document
/*************************************************************************
 * 文件名：doctor-list.js
 * 功能：医生信息列表
 * 作者：YuanjJingshan
 * 时间：2014-06-12
 *************************************************************************/

/**
 * 删除会员
 * @return
 */
function deleteTeam() {
	if (getSelectId().idStr == '') {
		alert("请选择要删除的医生信息！");
	} else {
		deleteById(getSelectId().idStr);
	}
}

//加载页面
$(function() { 
	// 附上模版数据
	$("#tmplete-n").setTemplateElement("tmplete-m");
	// 分页
	setParam(10,"doctorServlet?method=getNotCount","doctorServlet?method=getPageNotData","doctorServlet?method=delete","pageSize=10&pageNum=");
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
});