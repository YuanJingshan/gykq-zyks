<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-入口检录情况</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>

<script type="text/javascript">
$(function(){
	// 检录-所有
	$("#templete-all-n").setTemplateElement("templete-m");
	// 检录-等候
	$("#templete-not-n").setTemplateElement("templete-m");
	// 检录-已进入考站
	$("#templete-entried-n").setTemplateElement("templete-m");
	// 检录站的考生信息
	getInspectInfo();
});

/**
 * 查询检录站的考生信息
 */
function getInspectInfo(){
	$.ajax({
		type: "post",
		dataType: "json",
		url: "inspectServlet?method=getInspectAll",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("getInspectInfo('" + cardNum + "')", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			displayInspectInfo(data);
		}
	});
}

/**
 * 显示考生-检录信息
 */
function displayInspectInfo(data) {
	$("#all").text(data.all.count);
	$("#not-entry").text(data.notEntry.count);
	$("#entried").text(data.entried.count);
	$("#templete-all-n").processTemplate(data.all.info);
	$("#templete-not-n").processTemplate(data.notEntry.info);
	$("#templete-entried-n").processTemplate(data.entried.info);
}
</script>

</head>

<body>
	<!-- top -->
	<jsp:include page="../top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../left.jsp"></jsp:include>
    
    <div class="body_right">
    	<div class="body_right_1">
            <div class="occupying_left"></div>
            	
            <div class="occupying_right_1">
            	<h3 class="monitor_title">入口检录-检录情况</h3>
                <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <tr>
                    <th width="33%">已检录<span id="all"></span>人</th>
                    <th width="33%">等候区<span id="not-entry"></span>人</th>
                    <th width="33%">已进站<span id="entried"></span>人</th>
                  </tr>
                  <tr>
                    <td align="center" id="templete-all-n">
                    </td>
                    <td align="center" id="templete-not-n">
                    </td>
                    <td align="center" id="templete-entried-n">
                    </td>
                  </tr>
                </table>  
            </div>
            <textarea id="templete-m" style="display:none;">
		    	{#foreach $T as record}
		    		<a class="kzjk">
		    			<span style="font-size: 22px;">{$T.record.serialNumber}/{$T.record.name}</span> 
					    <span style="font-size: 14px;">题:{$T.record.topic1}/{$T.record.topic2}/{$T.record.topic3}/{$T.record.topic4}/{$T.record.topic5}/{$T.record.topic6}</span>
					</a>
		    	{#/for}
		    </textarea>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>