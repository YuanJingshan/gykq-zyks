// JavaScript Document
/*
 * 文件名：paging.js
 * 功能：jqery实现分页及页面操作，按页码来查选操作
 * 作者：YuanJingshan
 * 时间：2014-04-15
 */

/*******************jquery前端分页-begin**************************/	
var totalCount = 0; // 总记录数  
var pageTotal = 0; // 总页数 
var pn = 1; // 页码

/******************每次使用需要根据具体情况修改-begin********************/
var pageSize = 10; // 每页显示几条记录  
var countUrl; // 获取总数地址
var pageUrl; // 获取指定页面数据地址
var delUrl; // 删除数据页面
var sendParam; // 获取指定页面数据参数
var countParam; // 获取总数参数
/******************每次使用需要根据具体情况修改-end**********************/

/**
 * 设置参数
 * @param pSize
 * @param pCountUrl
 * @param pDataUrl
 * @param pSendParam
 * @return
 */
function setParam(pSize,pCountUrl,pDataUrl,pDelUrl,pSendParam,pCountParam) {
	pageSize = pSize;
	countUrl = pCountUrl;
	pageUrl = pDataUrl;
	delUrl = pDelUrl;
	sendParam = pSendParam;
	countParam = pCountParam != undefined ? pCountParam : "";
}
 
/**
 * 获取页面显示，控制跳转
 * @param data
 */
function getPageAndDisplay() {
	// 下一页
	$("#next").click(function() {  
		if (pn == pageTotal) {  
			toastr.warning("当前已是最后一页！");  
			pn = pageTotal;  
		} else {  
			pn = pn + 1;  
			gotoPageByNum(pn);  
		}  
	});  
	// 上一页
	$("#prev").click(function() {  
		if (pn == 1) {  
			toastr.warning("当前已是第一页！");  
			pn = 1;  
		} else {  
			pn = pn -1;  
			gotoPageByNum(pn);  
		}  
	});  
	// 首页
	$("#firstPage").click(function() {  
		pn = 1;  
		gotoPageByNum(pn);  
	});  
	// 尾页
	$("#lastPage").click(function() {  
		pn = pageTotal;  
		gotoPageByNum(pn);  
	});
	// 页面跳转
	$("#page-jump").click(function(){  
		if($(".page-num").val()  <= pageTotal && $(".page-num").val() != ''){  
			pn = $(".page-num").val();  
			gotoPageByNum(pn);  
		}else{  
			toastr.warning("您输入的页码有误！");  
			$(".page-num").val('').focus();  
		}  
	}); 
	
	$("#firstPage").trigger("click");
};  

/**
 * 获取总页数、总记录数，设置相关值
 * @param url
 * @return
 */
function getPageCount() {
	$.ajax({
		type: "post", 
		dataType: "json", 
		url: countUrl,
		data: countParam,
		success: function(data){
			totalCount = data.totalCount;
			pageTotal = Math.ceil(totalCount / pageSize) == 0 ? 1:Math.ceil(totalCount / pageSize);  
			$(".page-count").text(pageTotal);  
			$(".others-record").text(data.othersRcord);
			$(".count-record").text(totalCount);
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
}

/**
 * 根据页号跳转到显示 pn：页号 url：地址
 * @param pn
 * @param url
 * @return
 */
function gotoPageByNum(pn) {
	$.ajax({
		type: "post", 
		dataType: "json", 
		url: pageUrl,
		data: sendParam + pn,
		success: function(data){
			$("#tmplete-n").processTemplate(data);
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
	
    $(".current-page").text(pn);  
}; 

/**
 * 显示第一页数据
 * @return
 */
function displayPage1() {
	$.ajax({
		type: "post", 
		dataType: "json", 
		url: pageUrl,
		data: sendParam + 1,
		success: function(data){
			$("#tmplete-n").processTemplate(data);
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
	
    $(".current-page").text(pn);  
}

/**
 * 分页提交出错提示
 * @param funcname
 * @param XMLHttpRequest
 * @param textStatus
 * @param errorThrown
 * @return
 */
function pagingError(funcname, XMLHttpRequest, textStatus, errorThrown) {
	if (console) {
		console.log(funcname + "-error, " + XMLHttpRequest.readyState + " " + textStatus + " " + errorThrown);
	} else {
		alert(funcname + "-error, " + XMLHttpRequest.readyState + " " + textStatus + " " + errorThrown);
	}
}

/**
 * 全选
 * @return
 */
function selectAll() {
	$("#checkAll").attr("checked", true);
	$(".checkItem").each(function() {
		$(this).attr("checked", true);
	});
}

/**
 * 取消全选
 * @return
 */
function cacalSelAll() {
	$("#checkAll").attr("checked", false);
	$(".checkItem").each(function() {
		$(this).attr("checked", false);
	});
}

/**
 * 获取选择行的id
 * @return
 */
function getSelectId() {
	var str = '';
	var num = 0;
	$(".checkItem").each(function() {
		if ($(this).attr("checked") == "checked") {	
			str = str + $(this).val() + ', ';
			num = num + 1;
		}
	});
	str = str.substring(0, str.length-2);
	return {
		idStr:str,
		number:num
	};
}

/**
 * 根据条件来删除会员
 * @param data
 * @return
 */
function deleteById(data) {
	$.ajax({
		type: "post", 
		dataType: "json", 
		url: delUrl,
		data: "idStr=" + data, 
		success: function(data){
			if (data.result == 1) {
				toastr.success("删除成功！");
				location.reload();
        	} else {
        		toastr.error("删除失败！");
        	}
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
} 

//删除医生考试信息
function deleteTeam() {
	if (getSelectId().idStr == '') {
		toastr.info("请选择要删除的医生！");
	} else {
		deleteById(getSelectId().idStr);
	}
}
/*******************jquery前端分页-end****************************/