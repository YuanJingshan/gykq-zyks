// JavaScript Document
/*
 * 文件名：exit-verify.js
 * 功能：入口检录
 * 作者：YuanjJingshan
 * 时间：2014-06-24
 */

//分号入场
/**
 * 出口审核-开始
 */
function exitVerifyStart() {
	// 寻找读卡器
	FindReader();
	// 开始自动读卡
	setInterval(exitReadCard, 3000);
}

/**
 * 出口审核-阅读器读卡
 */
function exitReadCard() {
	var nRet;
	nRet = SynCardOcx1.ReadCardMsg();
	if(nRet==0) {
		var cardNum = SynCardOcx1.CardNo;
		// 查询身份证号
		queryExitVerifyDoctorInfo(cardNum);
	}
}

/**
 * 出口审核：检录考生信息（通用）
 */
function queryExitVerifyDoctorInfoCom(cardNum){
	$.ajax({
		type: "post",
		dataType: "json",
		url: "exitVerifyServlet?method=getExitVerifyDoctorInfo",
		data: "card=" + cardNum,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("queryExitVerifyDoctorInfoCom('" + cardNum + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 0) {
				//modified by yjs at 2016-06-25 from alert("第三考站未考完！"); to alert("未检录！");
				alert("未检录，请到检录处检录！");
			} else {
				displayVerifyInfo(data);
				//displayExitVerifyDoctorInfo(data.info);
			}
		}
	});
}

/**
 * 出口审核：阅读考生信息
 */
function queryExitVerifyDoctorInfo(cardNum){
	queryExitVerifyDoctorInfoCom(cardNum);
}

/**
 * 出口审核：手动输入检录
 */
function queryExitVerifyDoctorInfoByHand(){
	if ($("#card-num").val() == "" || $("#card-num").val().length != 18) {
		alert("证件号为空或不正确！");
	} else {
		$("#lianxi").attr("style","display:none");
		queryExitVerifyDoctorInfoCom($("#card-num").val());
	}
}

/**
 * 出口审核：显示考生信息
 */
function displayExitVerifyDoctorInfo(data) {
	$("#doctor-tmplete-n").processTemplate(data);
//	$("#doctor-info").attr("style","display:block");
}

/**
 * 出口审核：阅读确认考生
 */
/*function exitVerifyInspectConfirm(id) {
//	$("#doctor-info").attr("style","display:none");
	$.ajax({ 
		type: "post",
		asyn: false,
		dataType: "json",
		url: "exitVerifyServlet?method=exitVerifyDoctorInspect",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("exitVerifyInspectConfirm('" + id + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			//modified by yjs at 2016-06-25 begin
			//displayVerifyInfo(data);
			$("#doctor-info").attr("style","display:none");
			if (data.result == 1) {
				//出口审核
				exitVerify(id);
			} else if (data.result == 3) {
				alert("入口未检录，请到入口检录！");
			} else if (data.result == 4) {
				//出口审核
				exitVerify(id);
			} else {
				alert("检录失败！");
			}
			//modified by yjs at 2016-06-25 end
		}
	});
}*/

//added by yjs at 2016-06-25 begin
/**
 * 出口审核：阅读确认考生
 */
/*function exitVerify(id) {
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "exitVerifyServlet?method=getExitVerifyDoctorInfo",
		data: "id=" + id,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("exitVerifyInspectConfirm('" + id + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			displayVerifyInfo(data);
		}
	});
}*/

/**
 * 出口审核：获取审核人数
 */
function getVerifyNum() {
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "exitVerifyServlet?method=getExitVerifyInfo",
		data: null,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("getVerifyNum()", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#exit-verify-num").text(data.count);
		}
	});
}
//added by yjs at 2016-06-25 end
	
/**
 * 出口审核：显示审核信息
 * @param data
 * @return
 */
function displayVerifyInfo(data) {
	debugger;
	$("#exit-verify-num").text(data.verifiy_num);
	if (!!data.info) {
		$("#name").text(data.info.name);
		$("#ksh").text(data.info.ksh);
		$("#card").text(data.info.card);
		$("#serialNumber").text(data.info.serialNumber);
	}
	if(!!data.result) {
		if (data.result.result == 3) {
			toastr.error("未检录，请到入口检录！");
		} else if (data.result == 2) {
			toastr.error("总分大于100，请仔细检查！");
		} else if (data.result.result == 0) {
			$("#exam_result").text('考试完成!');
			$("#station1_r").text('已考!');
			$("#station2_r").text('已考!');
			$("#station3_r").text('已考!');
			$("#station4_r").text('已考!');
			$("#station5_r").text('已考!');
			$("#station6_r").text('已考!');
		} else if (data.result.result == '1') {
			$("#exam_result").text('考试未完成!');
			if (data.result.station_1 == '2') {
				$("#station1_r").text('已登分未审核!');
			} else if (data.result.station_1 == '3') {
				$("#station1_r").text('已考!');
			} else {
				$("#station1_r").text('未考!');
			}
			if (data.result.station_2 == '2') {
				$("#station2_r").text('已登分未审核!');
			} else if (data.result.station_2 == '3') {
				$("#station2_r").text('已考!');
			} else {
				$("#station2_r").text('未考!');
			}
			if (data.result.station_3 == '2') {
				$("#station3_r").text('已登分未审核!');
			} else if (data.result.station_3 == '3') {
				$("#station3_r").text('已考!');
			} else {
				$("#station3_r").text('未考!');
			}
			if (data.result.station_4 == '2') {
				$("#station4_r").text('已登分未审核!');
			} else if (data.result.station_4 == '3') {
				$("#station4_r").text('已考!');
			} else {
				$("#station4_r").text('未考!');
			}
			if (data.result.station_5 == '2') {
				$("#station5_r").text('已登分未审核!');
			} else if (data.result.station_5 == '3') {
				$("#station5_r").text('已考!');
			} else {
				$("#station5_r").text('未考!');
			}
			if (data.result.station_6 == '2') {
				$("#station6_r").text('已登分未审核!');
			} else if (data.result.station_6 == '3') {
				$("#station6_r").text('已考!');
			} else {
				$("#station6_r").text('未考!');
			}
		}
	}
	/*if (data.result == 0 || data.result == -101) {
		toastr.error("未检录，请到入口检录！");
	} else if (data.result == -102) {
		$("#station1_r").text('未考!');
		$("#station2_r").text('已考!');
		$("#station3_r").text('已考!');
		$("#exam_result").text('考试未完成!');
	} else if (data.result == -103) {
		$("#station1_r").text('未考!');
		$("#station2_r").text('已考!');
		$("#station3_r").text('未考!');
		$("#exam_result").text('考试未完成!');
	} else if (data.result == -104) {
		$("#station1_r").text('未考!');
		$("#station2_r").text('未考!');
		$("#station3_r").text('已考!');
		$("#exam_result").text('考试未完成!');
	}  else if (data.result == -105) {
		$("#station1_r").text('未考!');
		$("#station2_r").text('未考!');
		$("#station3_r").text('未考!');
		$("#exam_result").text('考试未完成!');
	}  else if (data.result == -106) {
		$("#station1_r").text('已考!');
		$("#station2_r").text('已考!');
		$("#station3_r").text('未考!');
		$("#exam_result").text('考试未完成!');
	}  else if (data.result == -107) {
		$("#station1_r").text('已考!');
		$("#station2_r").text('未考!');
		$("#station3_r").text('已考!');
		$("#exam_result").text('考试未完成!');
	}  else if (data.result == -108) {
		$("#station1_r").text('已考!');
		$("#station2_r").text('未考!');
		$("#station3_r").text('未考!');
		$("#exam_result").text('考试未完成!');
	}  else if (data.result == -109) {
		toastr.error("总分大于100，请仔细检查！");
	}  else if (data.result == 1){
		$("#station1_r").text('已考!');
		$("#station2_r").text('已考!');
		$("#station3_r").text('已考!');
		$("#exam_result").text('考试已完成!');
	}*/
	$(".ksxi_1").show();
}

$(function(){
	// 医生信息
	$("#doctor-tmplete-n").setTemplateElement("doctor-tmplete-m");
	
	//启动读卡器
	exitVerifyStart();
	
	//获取已经审核人数
	getVerifyNum();
});