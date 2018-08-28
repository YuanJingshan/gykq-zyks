// JavaScript Document
/*
 * 文件名：station-entry-3.js
 * 功能：第三考站分号入场
 * 作者：YuanjJingshan
 * 时间：2014-06-24
 */

//分号入场
/**
 * 第三考站开始
 */
function station3Start() {
	// 寻找读卡器
	FindReader();
	// 开始自动读卡
	setInterval(station3ReadCard, 1000);
}

/**
 * 第三考站检录读卡
 */
function station3ReadCard() {
	var nRet;
	nRet = SynCardOcx1.ReadCardMsg();
	if(nRet==0) {
		var cardNum = SynCardOcx1.CardNo;
		// 查询身份证号
		queryStation3DoctorInfo(cardNum);
	}
}

/**
 * 第三考站：检录考生信息通用
 */
function queryStation3DoctorInfoCom(cardNum){
	$.ajax({
		type: "post",
		dataType: "json",
		//url: "stationDoctorServlet?method=getStation3DoctorInfo",
		url: "inspectServlet?method=getInspectDoctorByCard",
		data: "card=" + cardNum,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("queryStation3DoctorInfoCom('" + cardNum + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 0) {
				//alert("第二考站未考完！");
				alert("未检录！");
			} else {
				var result = [];
				result.push(data.info);
				displaySation3DoctorInfo(result);
			}
		}
	});
}

/**
 * 第三考站：检录考生信息
 */
function queryStation3DoctorInfo(cardNum){
	queryStation3DoctorInfoCom(cardNum);
}

/**
 * 第三考站：手动输入检录
 */
function queryStation3DoctorInfoByHand(){
	if ($("#card-num").val() == "" || $("#card-num").val().length != 18) {
		alert("证件号为空或不正确！");
	} else {
		$("#lianxi").attr("style","display:none");
		queryStation3DoctorInfoCom($("#card-num").val());
	}
}


/**
 * 第三考站：显示考生信息
 */
function displaySation3DoctorInfo(data) {
	$("#doctor-tmplete-n").processTemplate(data);
	$("#doctor-info").attr("style","display:block");
}

/**
 * 第三考站：已检录的考生
 */
function station3InspectConfirm(id) {
	$("#doctor-info").attr("style","display:none");
	// 插入考生检录信息
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=station3DoctorInspect",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("station3InspectConfirm('" + id + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			//modified by yjs at 2016-06-25 begin
			/*if (data.result == 1) {
				displayStation3NotEntry();
			} else {
				alert("检录失败！");
			}*/
			if (data.result == 1) {
				displayStation3NotEntry();
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
 * 第三考站：点击提示进入考场
 */
function entryStation3Exam(id) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=entryStation3Exam",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("entryStation3Exam(" + id + ")", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 1) {
				playTipVoice();
				$("#" + id).remove();
				displayStation3Entried();
			}
		}
	});
}

/**
 * 第三考站：取消正在入场的考生
 */
function cancalStation3ExamEntried(id) {
	if(confirm("确认返回等候吗？")) {
		$.ajax({
			type: "post",
			dataType: "json",
			url: "stationDoctorServlet?method=cancalStation3ExamEntry",
			data: "id=" + id,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				ajaxErrorMsg("cancalStation3ExamEntried(" + id + ")", XMLHttpRequest, textStatus, errorThrown);
			},
			success: function(data){
				displayStation3NotEntry();
				displayStation3Entried();
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
	station3Start();
	// 候考区考生信息
	displayStation3NotEntry();
	// 考区考生信息
	displayStation3Entried();
	
	// 考区考生信息
	setInterval(displayStation3Entried, 10*1000);
});