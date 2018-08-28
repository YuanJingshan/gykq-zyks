// JavaScript Document
/*
 * 文件名：station-entry-2.js
 * 功能：第二考站-分号入场
 * 作者：YuanjJingshan
 * 时间：2014-06-18
 */
//分号入场
/**
 * 第二考站开始
 */
function station2Start() {
	// 寻找读卡器
	FindReader();
	// 开始自动读卡
	setInterval(station2ReadCard, 1000);
}

/**
 * 第二考站检录读卡
 */
function station2ReadCard() {
	var nRet;
	nRet = SynCardOcx1.ReadCardMsg();
	if(nRet==0) {
		var cardNum = SynCardOcx1.CardNo;
		// 查询身份证号
		queryStation2DoctorInfo(cardNum);
	}
}

/**
 * 第二考站：检录考生信息通用
 */
function queryStation2DoctorInfoCom(cardNum){
	$.ajax({
		type: "post",
		dataType: "json",
		//url: "stationDoctorServlet?method=getStation2DoctorInfo",
		url: "inspectServlet?method=getInspectDoctorByCard",
		data: "card=" + cardNum,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("queryStation2DoctorInfoCom('" + cardNum + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 0) {
				//modified by yjs at 2016-06-25 from alert("第一考站未考完！"); to alert("未检录！");
				alert("未检录，请到入口处检录！");
			} else {
				var result = [];
				result.push(data.info);
				displaySation2DoctorInfo(result);
			}
		}
	});
}

/**
 * 第二考站：检录考生信息
 */
function queryStation2DoctorInfo(cardNum){
	queryStation2DoctorInfoCom(cardNum);
}

/**
 * 第二考站：手动输入检录
 */
function queryStation2DoctorInfoByHand(){
	if ($("#card-num").val() == "" || $("#card-num").val().length != 18) {
		alert("证件号为空或不正确！");
	} else {
		$("#lianxi").attr("style","display:none");
		queryStation2DoctorInfoCom($("#card-num").val());
	}
}


/**
 * 第二考站：显示考生信息
 */
function displaySation2DoctorInfo(data) {
	$("#doctor-tmplete-n").processTemplate(data);
	$("#doctor-info").attr("style","display:block");
}

/**
 * 第二考站：已检录的考生
 */
function station2InspectConfirm(id) {
	$("#doctor-info").attr("style","display:none");
	// 插入考生检录信息
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=station2DoctorInspect",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("station2InspectConfirm('" + id + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			//modified by yjs at 2016-06-25 begin
			/*if (data.result == 1) {
				displayStation2NotEntry();
			} else {
				alert("检录失败！");
			}*/
			if (data.result == 1) {
				displayStation2NotEntry();
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
 * 第二考站：点击提示进入考场
 */
function entryStation2Exam(id) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=entryStation2Exam",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("entryStation2Exam(" + id + ")", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 1) {
				playTipVoice();
				$("#" + id).remove();
				displayStation2Entried();
			}
		}
	});
}

/**
 * 第二考站：取消正在入场的考生
 */
function cancalStation2ExamEntried(id) {
	if(confirm("确认返回等候吗？")) {
		$.ajax({
			type: "post",
			dataType: "json",
			url: "stationDoctorServlet?method=cancalStation2ExamEntry",
			data: "id=" + id,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				ajaxErrorMsg("cancalStation2ExamEntried(" + id + ")", XMLHttpRequest, textStatus, errorThrown);
			},
			success: function(data){
				displayStation2NotEntry();
				displayStation2Entried();
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
	//station2Start();
	// 候考区考生信息
	displayStation2NotEntry();
	// 考区考生信息
	displayStation2Entried();
	
	// 考区考生信息
	setInterval(displayStation2Entried, 10*1000);
});