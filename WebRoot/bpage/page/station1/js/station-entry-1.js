// JavaScript Document
/*
 * 文件名：station-entry-1.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */
// 分号入场
/**
 * 第一考站检录读卡
 */
function station1ReadCard() {
	var nRet;
	nRet = SynCardOcx1.ReadCardMsg();
	if(nRet==0) {
		var cardNum = SynCardOcx1.CardNo;
		// 查询身份证号
		queryStation1DoctorInfo(cardNum);
	}
}

/**
 * 第一考站开始
 */
function station1Start() {
	// 寻找读卡器
	FindReader();
	// 开始自动读卡
	setInterval(station1ReadCard, 3000);
}

/**
 * 第一考站：检录考生信息通用
 */
function queryStation1DoctorInfoCom(cardNum){
	$.ajax({
		type: "post",
		dataType: "json",
		//url: "stationDoctorServlet?method=getStation1DoctorInfo",
		url: "inspectServlet?method=getInspectDoctorByCard",
		data: "card=" + cardNum,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("queryStation1DoctorInfoCom('" + cardNum + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 0) {
				alert("未检录！");
			} else {
				var result = [];
				result.push(data.info);
				displaySation1DoctorInfo(result);
			}
		}
	});
}

/**
 * 第一考站：检录考生信息
 */
function queryStation1DoctorInfo(cardNum){
	queryStation1DoctorInfoCom(cardNum);
}

/**
 * 第一考站：手动输入检录
 */
function queryStation1DoctorInfoByHand(){
	if ($("#card-num").val() == "" || $("#card-num").val().length != 18) {
		alert("证件号为空或不正确！");
	} else {
		$("#lianxi").attr("style","display:none");
		queryStation1DoctorInfoCom($("#card-num").val());
	}
}


/**
 * 第一考站：显示考生信息
 */
function displaySation1DoctorInfo(data) {
	$("#doctor-tmplete-n").processTemplate(data);
	$("#doctor-info").attr("style","display:block");
}

/**
 * 第一考站：检录考生信息
 */
function station1InspectConfirm(id) {
	$("#doctor-info").attr("style","display:none");
	// 插入考生检录信息
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=station1DoctorInspect",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("station1InspectConfirm('" + id + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			//modified by yjs at 2016-06-25 begin
			if (data.result == 1) {
				displayStation1Inspected();
			} else if (data.result == 3) {
				alert("入口未检录，请到入口检录！");
			} else if (data.result == 4) {
				alert("已检录！");
			} else {
				alert("检录失败！");
			}
			//modified by yjs at 2016-06-25 end
		}
	});
}

/**
 * 第一考站：点击提示进入考场
 */
function entryStation1Exam(id) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=entryStation1Exam",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("entryStation1", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 1) {
				playTipVoice();
				$("#" + id).remove();
				displayStation1Entried();
			}
		}
	});
}

/**
 * 第一考站：取消正在入场的考生
 */
function cancalStation1ExamEntried(id) {
	if(confirm("确认返回等候吗？")) {
		$.ajax({
			type: "post",
			dataType: "json",
			url: "stationDoctorServlet?method=cancalEntryingExam",
			data: "id=" + id,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				ajaxErrorMsg("cancalStation1ExamEntrying", XMLHttpRequest, textStatus, errorThrown);
			},
			success: function(data){
				displayStation1Inspected();
				displayStation1Entrying();
			}
		});
	}
}

$(function(){
	// 医生信息
	$("#doctor-tmplete-n").setTemplateElement("doctor-tmplete-m");
	// 候考区考生信息
	$("#not-entry-info-n").setTemplateElement("not-entry-info-m");
	// 考区考生信息
	$("#entried-info-n").setTemplateElement("entried-info-m");
	
	// 启动读卡器
	station1Start();
	// 候考区考生信息
	displayStation1Inspected();
	// 考区考生信息
	displayStation1Entried();
	
	// 考区考生信息
	setInterval(displayStation1Entried, 10*1000);
});