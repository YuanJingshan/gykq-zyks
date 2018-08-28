//JavaScript Document
/*************************************************************************
 * 文件名：user-list.js
 * 功能：用户列表显示、操作
 * 作者：YuanjJingshan
 * 时间：2014-05-06
 *************************************************************************/

/**
 * 删除会员
 * @return
 */
function deleteTeam() {
	if (getSelectId().idStr == '') {
		alert("请选择要删除的管理员！");
	} else {
		deleteById(getSelectId().idStr);
	}
}

//加载页面
$(function() { 
	// 附上模版数据
	$("#tmplete-n").setTemplateElement("tmplete-m");
	// 分页
	setParam(10,"userServlet?method=getCount","userServlet?method=getPageData","userServlet?method=delete","pageSize=10&pageNum=");
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