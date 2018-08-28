// JavaScript Document
/*
 * 文件名：entry-inspect.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */


/**
 * 入口检录读卡
 */
function ReadCard() {
	var nRet;
	nRet = SynCardOcx1.ReadCardMsg();
	if(nRet==0) {
		var cardNum = SynCardOcx1.CardNo;
		//test code
		//alert("身份证号：" + cardNum);
		// 查询身份证号
		queryDoctorInfo(cardNum);
	}
}

/**
 * 开始
 */
function start() {
	// 寻找读卡器
	FindReader();
	// 开始自动读卡
	setInterval(ReadCard, 1000);
}

/**
 * 查询考生信息-通用
 */
function queryDoctorInfoCom(cardNum){
	$.ajax({
		type: "post",
		dataType: "json",
		url: "doctorServlet?method=getDoctorInfo",
		data: "condition=card='" + cardNum + "'",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("queryDoctorInfoCom('" + cardNum + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 0) {
				$.common.layer.msg('考生信息不存在！', {icon: 2, time: 2000});
			} else {
				displayDoctorInfo(data.info);
			}
		}
	});
}

/**
 * 查询考生信息
 */
function queryDoctorInfo(cardNum){
	queryDoctorInfoCom(cardNum);
}

/**
 * 手动输入
 */
function queryDoctorInfoByHand(){
	if ($("#card-num").val() == "" || $("#card-num").val().length != 18) {
		alert("证件号为空或不正确！");
	} else {
		$("#lianxi").attr("style","display:none");
		queryDoctorInfoCom($("#card-num").val());
	}
}

/**
 * 显示考生信息
 */
function displayDoctorInfo(data) {
	$("#doctor-tmplete-n").processTemplate(data);
	$("#doctor-info").attr("style","display:block");
}

/**
 * 检录确认
 */
function inspectConfirm(id){
	$("#doctor-info").attr("style","display:none");
	// 插入考生检录信息
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "inspectServlet?method=doctorInspect",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("inspectConfirm('" + id + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 1) {
				getNotEntStryation1Doctor();
			} else if (data.result == 2) {
				alert("题组号已经存在,请重新检录分配！");
			} else if (data.result == 4) {
				alert("已检录！");
			} else {
				alert("检录失败！");
			}
		}
	});
}

/**
 * 点击进入第一站
 */
function entryStation1(id) {
	$.ajax({
		type: "post",
		dataType: "json",
		//url: "inspectServlet?method=entryStation1",
		url: "inspectServlet?method=entrySation",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("entryStation1", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 1) {
				playTipVoice();
				$("#" + id).remove();
				getEntryingStation1Doctor();
			}
		}
	});
}

/**
 * 取消正在进入第一考站
 */
function cancalEntryingStation1Doctor(id) {
	if(confirm("确认返回等候吗？")) {
		$.ajax({
			type: "post",
			dataType: "json",
			url: "inspectServlet?method=cancalInspectEntrying",
			data: "id=" + id,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				ajaxErrorMsg("cancalEntryingStation1Doctor", XMLHttpRequest, textStatus, errorThrown);
			},
			success: function(data){
				getNotEntStryation1Doctor();
				getEntryingStation1Doctor();
			}
		});
	}
}

$(function(){
	// 医生信息
	$("#doctor-tmplete-n").setTemplateElement("doctor-tmplete-m");
	// 检录未入站的考生
	$("#inspect-info-n").setTemplateElement("inspect-info-m");
	// 检录正在进入第一站的考生
	$("#tmplete-n").setTemplateElement("tmplete-m");
	// 启动读卡器
	//start();
	// 未进入考生考生
	getNotEntStryation1Doctor();
	// 正在进入考站的考生
	getEntryingStation1Doctor();
//	// 未进入考生考生
//	setInterval(getNotEntStryation1Doctor, 10*1000);
	// 正在进入考站的考生
	setInterval(getEntryingStation1Doctor, 10*1000);
	
});