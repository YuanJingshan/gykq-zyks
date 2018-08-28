// JavaScript Document
/*
 * 文件名：bpage.js
 * 功能：后台js
 * 作者：YuanJingshan
 * 时间：2014-05-06
 */

/******************************后台账户begin**********************************/
/**
 * 后台账户登录
 * @return
 */
function login() {
	$.ajax({
		type: "post",
        url: "userServlet?method=login",
        data: $("#login-form").serialize(),
        dataType: "json",
        error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("js方法login()", XMLHttpRequest, textStatus, errorThrown);
        },
        success: function(data) {
           	if (data.result == 1) {
           		openPage("/doctorexam/bpage/page/index.jsp","_self");
        	} else {
        		alert("登录失败！");
        		refresh();
        	}
        }
    });
}

/**
 * 账户操作
 * @param url
 * @param type
 * @return
 */
function userOper(url, type) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: url,
		data: $("#user-form").serialize(),
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("js方法userOper('"+url + "'," + type + ")", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
           	if (data.result > 0) {
           		if (type == 1) {
           			alert("增加成功！");
           			openPage("/doctorexam/bpage/page/user/user-list.jsp","_self");
           		} else {
           			alert("修改成功！");
           			if ($("#session-authority").val() == 1) {
               			openPage("/doctorexam/bpage/page/user/user-list.jsp","_self");
               		}
           		}
        	} else {
        		if (type == 1) {
        			alert("增加失败！");
        		} else {
        			alert("修改失败！");
        		}
        	}
		}
	});
	
}

/**
 * 增加后台账户
 * @return
 */
function addUser() {
	userOper("userServlet?method=add", 1);
}

/**
 * 修改后台账户
 * @return
 */
function modifyUser() {
	userOper("userServlet?method=modify", 2);
}

/**
 * 系统初始化
 * @return
 */
function sysInit() {
	var flag = confirm("确认对系统进行初始化？");
	if (flag) {
		$("#init-secret").val("");
		$("#lianxi").attr("style","display:block");
	}
}

/**
 * 系统初始化确认
 * @return
 */
function sysInitComfirm() {
	$("#lianxi").attr("style","display:none");
	$.ajax({
		type: "post",
        url: "userServlet?method=sysInit",
        dataType: "json",
        data: "secret=" + $("#init-secret").val(),
        error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("sysInit()", XMLHttpRequest, textStatus, errorThrown);
        },
        success: function(data) {
           	if (data.result == 1) {
           		alert("初始化成功！");
        	} else {
        		alert("初始化失败！");
        	}
        }
    });
}
/******************************后台账户end************************************/

/******************************考生信息begin**********************************/
/**
 * 查询医生信息
 * @return
 */
function queryDoctorInfo() {
	var condition = $("#query-condition").val();
	if ( condition == 0) {
		alert("请选择查询条件！");
	} else {
		condition = "condition=" + condition + " like 'mhcx" + $("#query-nei").val() + "mhcx'"; 
		displayListDate("doctorServlet?method=getCountByCondition", "doctorServlet?method=getPageDataByCondition", condition, condition);
	}
}

/**
 * 查询未考医生信息
 * @return
 */
function queryDoctorNotExamInfo() {
	var condition = $("#query-condition").val();
	if ( condition == 0) {
		alert("请选择查询条件！");
	} else {
		condition = condition + " like 'mhcx" + $("#query-nei").val() + "mhcx'"; 
		displayListDate("doctorServlet?method=getCountNotByCondition", "doctorServlet?method=getPageDataNotByCondition", condition, condition);
	}
}

// 时间正则表达式
//var dataReg = /^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;
var dataReg = /^(?:19|20)[0-9][0-9]\/(?:(?:0[1-9])|(?:1[0-2]))\/(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]$/;

/**
 * 条件选择
 * @return
 */
function conditionChoose() {
	if ($("#query-condition").val() == "data") {
		$("#query-nei").attr("style","display:none");
		$("#exam-type").attr("style","display:none");
		$("#date-d").attr("style","");
		$("#score-d").attr("style","display:none");
	} else if ($("#query-condition").val() == "type") {
		$("#query-nei").attr("style","display:none");
		$("#exam-type").attr("style","");
		$("#date-d").attr("style","display:none");
		$("#score-d").attr("style","display:none");
	}  else if ($("#query-condition").val() == "score") {
		$("#query-nei").attr("style","display:none");
		$("#exam-type").attr("style","display:none");
		$("#date-d").attr("style","display:none");
		$("#score-d").attr("style","");
	} else {
		$("#query-nei").attr("style","");
		$("#exam-type").attr("style","display:none");
		$("#date-d").attr("style","display:none");
		$("#score-d").attr("style","display:none");
	}
}

var fsReg = /^(([1-9]{1}[0-9]{1})|([0-9]{1}))(\.[0-9]{0,3})?$/;

/**
 * 第一站查询考试成绩
 * @return
 */
function querySationScore_1() {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		alert("请选择查询条件！");
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'"; 
				displayListDate("stationScoreServlet?method=getCountStation1ByCondition", "stationScoreServlet?method=getPageDataStation1ByCondition", condition, condition);
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score>=" + $("#start-fs").val() + " and score<=" + $("#end-fs").val();
			displayListDate("stationScoreServlet?method=getCountStation1ByCondition", "stationScoreServlet?method=getPageDataStation1ByCondition", condition, condition);
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		displayListDate("stationScoreServlet?method=getCountStation1Condition", "stationScoreServlet?method=getPageDataStation1ByCondition", condition, condition);
	} else {
		condition = "condition=" + condition + " like 'mhcx" + $("#query-nei").val() + "mhcx'"; 
		displayListDate("stationScoreServlet?method=getCountStation1ByCondition", "stationScoreServlet?method=getPageDataStation1ByCondition", condition, condition);
	}
}

/**
 * 第一站excel导出
 * @return
 */
function exportExcelStation1() {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		condition = "condition=all";
		openPage("/doctorexam/stationScoreServlet?method=exportStation1Excel&" + condition);
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'";
				openPage("/doctorexam/stationScoreServlet?method=exportStation1Excel&" + condition);
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score>" + $("#start-fs").val() + " and score<" + $("#end-fs").val();
			openPage("/doctorexam/stationScoreServlet?method=exportStation1Excel&" + condition);
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		openPage("/doctorexam/stationScoreServlet?method=exportStation1Excel&" + condition);
	} else {
		condition = "condition=" + condition + "='" + $("#query-nei").val() + "'"; 
		openPage("/doctorexam/stationScoreServlet?method=exportStation1Excel&" + condition);
	}
}

/**
 * 第二站查询考试成绩
 * @return
 */
function querySationScore_2() {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		alert("请选择查询条件！");
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + (($("#start-dt").val()).replace("/", "-")).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'";
				displayListDate("stationScoreServlet?method=getCountStation2Condition", "stationScoreServlet?method=getPageDataStation2ByCondition", condition, condition);
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score>=" + $("#start-fs").val() + " and score<=" + $("#end-fs").val();
			displayListDate("stationScoreServlet?method=getCountStation2Condition", "stationScoreServlet?method=getPageDataStation2ByCondition", condition, condition);
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		displayListDate("stationScoreServlet?method=getCountStation2Condition", "stationScoreServlet?method=getPageDataStation2ByCondition", condition, condition);
	} else {
		condition = "condition=" + condition + " like 'mhcx" + $("#query-nei").val() + "mhcx'"; 
		displayListDate("stationScoreServlet?method=getCountStation2Condition", "stationScoreServlet?method=getPageDataStation2ByCondition", condition, condition);
	}
}

/**
 * 第二站excel导出
 * @return
 */
function exportExcelStation2() {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		condition = "condition=all";
		openPage("/doctorexam/stationScoreServlet?method=exportStation2Excel&" + condition);
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'";
				openPage("/doctorexam/stationScoreServlet?method=exportStation2Excel&" + condition);
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score>" + $("#start-fs").val() + " and score<" + $("#end-fs").val();
			openPage("/doctorexam/stationScoreServlet?method=exportStation2Excel&" + condition);
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		openPage("/doctorexam/stationScoreServlet?method=exportStation2Excel&" + condition);
	} else {
		condition = "condition=" + condition + "='" + $("#query-nei").val() + "'";
		openPage("/doctorexam/stationScoreServlet?method=exportStation2Excel&" + condition);
	}
}

/**
 * 第三站查询考试成绩
 * @return
 */
function querySationScore_3() {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		alert("请选择查询条件！");
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'";
				displayListDate("stationScoreServlet?method=getCountStation3Condition", "stationScoreServlet?method=getPageDataStation3ByCondition", condition, condition);
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score>" + $("#start-fs").val() + " and score<" + $("#end-fs").val();
			displayListDate("stationScoreServlet?method=getCountStation3Condition", "stationScoreServlet?method=getPageDataStation3ByCondition", condition, condition);
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		displayListDate("stationScoreServlet?method=getCountStation3Condition", "stationScoreServlet?method=getPageDataStation3ByCondition", condition, condition);
	} else {
		condition = "condition=" + condition + " like '" + $("#query-nei").val() + "'"; 
		displayListDate("stationScoreServlet?method=getCountStation3Condition", "stationScoreServlet?method=getPageDataStation3ByCondition", condition, condition);
	}
}

/**
 * 第三站excel导出
 * @return
 */
function exportExcelStation3() {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		condition = "condition=all";
		openPage("/doctorexam/stationScoreServlet?method=exportStation3Excel&" + condition);
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'";
				openPage("/doctorexam/stationScoreServlet?method=exportStation3Excel&" + condition);
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score>" + $("#start-fs").val() + " and score<" + $("#end-fs").val();
			openPage("/doctorexam/stationScoreServlet?method=exportStation3Excel&" + condition);
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		openPage("/doctorexam/stationScoreServlet?method=exportStation3Excel&" + condition);
	} else {
		condition = "condition=" + condition + "='" + $("#query-nei").val() + "'";
		openPage("/doctorexam/stationScoreServlet?method=exportStation3Excel&" + condition);
	}
}

var getScore = function(station) {
	var condition = $("#query-condition").val();
	
	if (condition == 0) {
		toastr.warning("请选择查询条件！");
		return false;
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			$("#start-dt").val("");
			toastr.warning("确认时间格式！");
			return false;
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				$("#end-dt").val("");
				toastr.warning("确认时间格式！");
				return false;
			} else {
				condition = "station=" + station + "&condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'"; 
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			toastr.warning("输入分数的格式不正确！");
			return false;
		} else {
			condition = "station=" + station + "&condition=score>=" + $("#start-fs").val() + " and score<=" + $("#end-fs").val();
		}
	} else if (condition == "type") {
		condition = "station=" + station + "&condition=exam_type=" + $("#exam-type").val(); 
	} else {
		condition = "station=" + station + "&condition=" + condition + " like 'mhcx" + $("#query-nei").val() + "mhcx'"; 
	}
	displayListDate("stationScoreExtServlet?method=countBycon", "stationScoreExtServlet?method=getPageDataStation1ByCondition", condition, condition);
}

var exportScore = function(station) {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		condition = "station=" + station + "&condition=all";
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			toastr.warning("确认时间格式！");
			$("#start-dt").val("");
			return false;
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				toastr.warning("确认时间格式！");
				$("#end-dt").val("");
				return false;
			} else {
				condition = "station=" + station + "&condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'";
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			toastr.warning("输入分数的格式不正确！");
			return false;
		} else {
			condition = "station=" + station + "&condition=score>" + $("#start-fs").val() + " and score<" + $("#end-fs").val();
		}
	} else if (condition == "type") {
		condition = "station=" + station + "&condition=exam_type=" + $("#exam-type").val(); 
	} else {
		condition = "station=" + station + "&condition=" + condition + "='" + $("#query-nei").val() + "'"; 
	}
	openPage("stationScoreExtServlet?method=exportScore&" + condition);
}

/**
 * 查询考试成绩
 * @return
 */
function queryExamScore() {
	var condition = $("#query-condition").val();
	if ( condition == 0) {
		alert("请选择查询条件！");
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + $("#start-dt").val().replace("/", "-") + "' and insert_dt<'" + $("#end-dt").val().replace("/", "-") + "'"; 
				displayListDate("examScoreServlet?method=getCountByCondition", "examScoreServlet?method=getPageDataByCondition", condition, condition);
			}
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		displayListDate("examScoreServlet?method=getCountByCondition", "examScoreServlet?method=getPageDataByCondition", condition, condition);
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score_count>=" + $("#start-fs").val() + " and score_count<" + $("#end-fs").val();
			displayListDate("examScoreServlet?method=getCountByCondition", "examScoreServlet?method=getPageDataByCondition", condition, condition);
		}
	} else {
		condition = "condition=" + condition + " like 'mhcx" + $("#query-nei").val() + "mhcx'"; 
		displayListDate("examScoreServlet?method=getCountByCondition", "examScoreServlet?method=getPageDataByCondition", condition, condition);
	}
}

/**
 * 分页显示列表数据
 * @return
 */
function displayListDate(countFun, dataFun, pSendCondition, pCountCondition) {
	// 查询分页显示
	pn =1;
	setParam(10, countFun, dataFun, "", pSendCondition + "&pageSize=10&pageNum=", pCountCondition);
	getPageCount();
	displayPage1();
}

/**
 * 考场成绩excel导出
 * @return
 */
function exportExcelExam() {
	var condition = $("#query-condition").val();
	if (condition == 0) {
		condition = "condition=all";
		openPage("/doctorexam/examScoreServlet?method=exportExamExcel&" + condition);
	} else if (condition == "data") {
		if (!dataReg.test($("#start-dt").val())) {
			alert("确认时间格式！");
			$("#start-dt").val("");
		} else {
			if (!dataReg.test($("#end-dt").val())) {
				alert("确认时间格式！");
				$("#end-dt").val("");
			} else {
				condition = "condition=insert_dt>'" + ($("#start-dt").val()).replace("/", "-") + "' and insert_dt<'" + ($("#end-dt").val()).replace("/", "-") + "'";
				openPage("/doctorexam/examScoreServlet?method=exportExamExcel&" + condition);
			}
		}
	} else if (condition == "score") {
		if (!fsReg.test($("#start-fs").val()) || !fsReg.test($("#end-fs").val())) {
			alert("输入分数的格式不正确！");
		} else {
			condition = "condition=score_count>=" + $("#start-fs").val() + " and score_count<=" + $("#end-fs").val();
			openPage("/doctorexam/examScoreServlet?method=exportExamExcel&" + condition);
		}
	} else if (condition == "type") {
		condition = "condition=exam_type=" + $("#exam-type").val(); 
		openPage("/doctorexam/examScoreServlet?method=exportExamExcel&" + condition);
	} else {
		condition = "condition=" + condition + "='" + $("#query-nei").val() + "'"; 
		openPage("/doctorexam/examScoreServlet?method=exportExamExcel&" + condition);
	}
}
/******************************考生信息end************************************/

/******************************通用函数begin**********************************/
/**
 * 根据条件查询
 * @return
 */
function queryByCondition(url, condition, tmplete) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: url,
		data: "condition=" + condition,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("queryByCondition('"+url + "','" + condition + "','" + tmplete + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#" + tmplete).processTemplate(data);
		}
	});
}

/**
 * 根据条件查询-时间
 * @return
 */
function queryByDateCondition(url, condition, tmplete) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: url,
		data: condition,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("queryByDateCondition('"+url + "','" + condition + "','" + tmplete + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#" + tmplete).processTemplate(data);
		}
	});
}

/**
 * 播放音乐提示
 * @return
 */
function playTipVoice() {
	var audio = document.createElement("audio");
	if (audio != null && audio.canPlayType && audio.canPlayType("audio/mpeg")) {
		audio.src = "mp3/dingdong.mp3";
		audio.play();
	}
}
/******************************通用函数end************************************/

/******************************入口检录begin**********************************/
/**
 * 寻找阅读器
 */
function FindReader() {
	var str;
	str = SynCardOcx1.FindReader();
	if (str > 0) {
		if(str>1000) {
			alert("读卡器连接在USB " + str);
		} else {
			alert("读卡器连接在COM " + str);
		}
	} else {
		alert("没有找到读卡器!");
	}
}

/**
 * 等候区
 */
function getNotEntStryation1Doctor() {
	// 插入考生检录信息
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "inspectServlet?method=getInspectNotEntry",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayFrame()", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#inspect-num").text(data.inspectNum); // 检录人数
			$("#not-entry-num").text(data.notEntryNum); // 等候人数
			$("#entried-num").text(data.entriedNum); //进站人数
			$("#inspect-info-n").processTemplate(data.info);
		}
	});
}

/**
 * 考区
 */
function getEntryingStation1Doctor() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "inspectServlet?method=getInspectEntrying",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("getStation1DoctorFlagIsNot", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#inspect-num").text(data.inspectNum); // 检录人数
			$("#not-entry-num").text(data.notEntryNum); // 等候人数
			$("#entried-num").text(data.entriedNum); //进站人数
			$("#tmplete-n").processTemplate(data.info);
		}
	});
}
/******************************入口检录end************************************/

/******************************第一考站end************************************/
/**
 * 第一考站：候考区考生信息
 */
function displayStation1Inspected() {
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation1NotEntry",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1Inspected()", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntryNum);
			$("#entried-num").text(data.entriedNum);
			$("#not-entry-info-n").processTemplate(data.info);
		}
	});
}

/**
 * 第一考站：考区考生信息
 */
function displayStation1Entried() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation1Entried",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1Entrying", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntryNum);
			$("#entried-num").text(data.entriedNum);
			$("#entried-info-n").processTemplate(data.info);
		}
	});
}

// 录入分数出站
/**
 * 输入分数并计算总分
 */
function calcurateScore(topicId,data){
	var inputValue = data.value;
	// double型0.00-99.00的正则表达式
	var reg = /^(([1-9]{1}[0-9]{1})|([0-9]{1}))(\.[0-9]{0,3})?$/;
	if (!reg.test(inputValue)) {
		data.value = 0;
	}
	var countN = 0;
	for (var i=1; i<=8; i++) {
		value = 0;
		var itemVal = $("#tipic-" + topicId + "-" + i).val()
		if (itemVal == "" || itemVal == null || itemVal == "undefined") {
			value = 0;
		} else {
			value = parseFloat(itemVal);
		}
		countN = countN + value;
	}
	
	if (countN > 100) {
		alert("总分大于100,请检查输入分数！");
	} else {
		$("#count-" + topicId).text(parseFloat(countN).toFixed(3));
		var count = 0;
		for (var i=1; i<=6; i++) {
			var value = 0;
			var itemVal = $("#count-" + i).text();
			if (itemVal == "" || itemVal == null || itemVal == "undefined") {
				value = 0;
			} else {
				value = parseFloat(itemVal);
			}
			count = count + value;
		}
		if (count > 100) {
			alert("总分大于100,请检查输入分数！");
		} else {
			$("#count").text(parseFloat(count).toFixed(3));
		}
	}
}

/**
 * 成绩重置
 */
function resetScore(formId) {
	$(".score-count").each(function(){
		$(this).text(0);
	});
	$("#count").text(0);
	resetForm(formId);
}

//显示考站信息
/**
 * 显示第一站考生信息
 */
function displayStation1Info() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation1Info",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1Info", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntry.count);
			$("#entried-num").text(data.entried.count);
			$("#not-entry-info-n").processTemplate(data.notEntry.info);
			$("#entried-info-n").processTemplate(data.entried.info);
		}
	});
}

/**
 * 显示第一站考生信息-监控
 */
function displayStation1InfoJk() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation1InfoByJk",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1InfoJk", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			//$("#not-inspect-1").text(data.notInspectNum);
			$("#not-entry-num-1").text(data.notEntryNum);
			$("#entried-num-1").text(data.entriedNum);
			$("#station1-info").processTemplate(data.info);
		}
	});
}
/******************************第一考站end************************************/

/******************************第二考站end************************************/
/**
 * 第二考站：候考区考生信息
 */
function displayStation2NotEntry() {
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation2NotEntry",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation2NotEntry()", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntryNum);
			$("#entried-num").text(data.entriedNum);
			$("#not-entry-info-n").processTemplate(data.info);
		}
	});
}

/**
 * 第二考站：考区考生信息
 */
function displayStation2Entried() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation2Entried",
		success: function(data){
			$("#not-entry-num").text(data.notEntryNum);
			$("#entried-num").text(data.entriedNum);
			$("#entried-info-n").processTemplate(data.info);
		},
		error: function() {
			toastr.error($.constant.ERROR);
		}
	});
}

/**
 * 显示第二站考生信息
 */
function displayStation2Info() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation2Info",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1Info", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntry.count);
			$("#entried-num").text(data.entried.count);
			$("#not-entry-info-n").processTemplate(data.notEntry.info);
			$("#entried-info-n").processTemplate(data.entried.info);
		}
	});
}

/**
 * 显示第二站考生信息-监控
 */
function displayStation2InfoJk() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation2InfoByJk",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation2InfoJk", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			//$("#not-inspect-2").text(data.notInspectNum);
			$("#not-entry-num-2").text(data.notEntryNum);
			$("#entried-num-2").text(data.entriedNum);
			$("#station2-info").processTemplate(data.info);
		}
	});
}
/******************************第二考站end************************************/

/******************************第三考站end************************************/
/**
 * 第三考站：候考区考生信息
 */
function displayStation3NotEntry() {
	$.ajax({ 
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation3NotEntry",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation2NotEntry()", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntryNum);
			$("#entried-num").text(data.entriedNum);
			$("#not-entry-info-n").processTemplate(data.info);
		}
	});
}

/**
 * 第三考站：考区考生信息
 */
function displayStation3Entried() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation3Entried",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation3Entried()", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntryNum);
			$("#entried-num").text(data.entriedNum);
			$("#entried-info-n").processTemplate(data.info);
		}
	});
}

/**
 * 显示第二站考生信息
 */
function displayStation3Info() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation3Info",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation1Info", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			$("#not-entry-num").text(data.notEntry.count);
			$("#entried-num").text(data.entried.count);
			$("#not-entry-info-n").processTemplate(data.notEntry.info);
			$("#entried-info-n").processTemplate(data.entried.info);
		}
	});
}

/**
 * 显示第三站考生信息-监控
 */
function displayStation3InfoJk() {
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationDoctorServlet?method=getStation3InfoByJk",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("displayStation2InfoJk", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			//$("#not-inspect-3").text(data.notInspectNum);
			$("#not-entry-num-3").text(data.notEntryNum);
			$("#entried-num-3").text(data.entriedNum);
			$("#station3-info").processTemplate(data.info);
		}
	});
}
/******************************第三考站end************************************/

/******************************出站审核end************************************/
/**
 * 查询审核站的考生信息
 */
function getExitVerifyInfo(){
	$.ajax({
		type: "post",
		dataType: "json",
		url: "exitVerifyServlet?method=getExitVerifyInfo",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("getExitVerifyInfo()", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			debugger;
			$("#exit-verify-num").text(data.count);
			$("#exit-verify-info-n").processTemplate(data.info);
		}
	});
}
/******************************出站审核end************************************/


//added by yjs at 2016-07-02 begin
/**
 * 账户操作
 * @param url
 * @param type
 * @return
 */
function jgxoper(url, type) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: url,
		data: $("#jgx-form").serialize(),
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("js方法jgxoper('"+url + "'," + type + ")", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
           	if (data.result > 0) {
           		if (type == 1) {
           			alert("增加成功！");
           			openPage("/doctorexam/bpage/page/user/jgxview.jsp","_self");
           		} else {
           			alert("修改成功！");
           			if ($("#session-authority").val() == 1) {
               			openPage("/doctorexam/bpage/page/user/jgxview.jsp","_self");
               		}
           		}
        	} else {
        		if (type == 1) {
        			alert("增加失败！");
        		} else {
        			alert("修改失败！");
        		}
        	}
		}
	});
	
}

/**
 * 增加后台账户
 * @return
 */
function addJGX() {
	jgxoper("jgxServlet?method=add", 1);
}

/**
 * 修改后台账户
 * @return
 */
function modifyJGX() {
	jgxoper("jgxServlet?method=modify", 2);
}
//added by yjs at 2016-07-02 end