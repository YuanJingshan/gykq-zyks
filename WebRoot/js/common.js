// JavaScript Document
/*
 * 文件名：common.js
 * 功能：后台js
 * 作者：YuanjJingshan
 * 时间：2014-05-06
 */

/******************************通用begin**********************************/
/**
 * 根据条件跳转到指定页面
 * @param url
 * @return
 */
function openPage(url,param) {
	window.open(url,param);
}

/**
 * 刷新当前页面
 * @return
 */
function refresh(){
	location.reload();
}

/**
 * 表单重置
 * @return
 */
function resetForm(formId) {
	$('#' + formId)[0].reset();
}

/**
 * ajax异步上传文件
 * @return
 */
function ajaxFileUpload(url,picUrl) {
    $.ajaxFileUpload ({
        url: url,
        secureuri: false,
        fileElementId: 'file-upload',
        dataType: 'json',
        success: function (data, status) { //从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量
    		$("#picfile").attr("src", picUrl + data.file);
    		if (data.file.length > 0) {
    			alert("上传成功！");
    		} else {
    			alert("请选择上传文件！");
    		}
        },
        error: function (data, status, e) { //服务器响应失败处理函数
            alert("上传失败！");
        }
    });
}

/**
 * 模版加载数据
 * @param url
 * @param data
 * @return
 */
function setTempleteData(templete, url, data) {
	data = typeof data == 'undefined' ? '' : data;
	$("#"+templete).setTemplateElement("tmplete-m");
	$.ajax({
		type: "post", 
		dataType: "json", 
		url: url,
		data: data,
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
			 console.log(XMLHttpRequest.readyState + " " + textStatus + " " + errorThrown);
		},
		success: function(data){
			$("#"+templete).processTemplate(data);
		}
	});
}

/**
 * ajax提交错误消息函数
 * @param funcname
 * @param XMLHttpRequest
 * @param textStatus
 * @param errorThrown
 * @return
 */
function ajaxErrorMsg(funcname, XMLHttpRequest, textStatus, errorThrown) {
	if (console) {
		console.log(funcname + "-提交出错。 " + XMLHttpRequest.readyState + " " + textStatus + " " + errorThrown);
	} else {
		alert(funcname + "-提交出错。 " + XMLHttpRequest.readyState + " " + textStatus + " " + errorThrown);
	}
}


/**
 * kindediter初始化
 * @param tagId
 * @return
 */
function kindEditerInit(tagId) {
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="' + tagId +'"]', {
			cssPath : '../../../kindeditor-4.1.7/plugins/code/prettify.css',
			uploadJson : 'kindeditor-4.1.7/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor-4.1.7/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {},
			afterBlur: function(){ this.sync(); }
		});
	});
}
/******************************通用end*************************************/