<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-第一考站情况</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/station1/js/station1-info.js"></script>

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
            	<h3 class="monitor_title">第一考站-考站情况</h3>
                <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <tr>
                    <th width="50%">候考区<span id="not-entry-num"></span>人</th>
                    <th width="50%">考区<span id="entried-num"></span>人</th>
                  </tr>
                  <tr>
                    <td align="center" id="not-entry-info-n"></td>
                    <td align="center" id="entried-info-n"></td>
                  </tr>
                </table>  
            </div>
            <textarea id="templete-m" style="display:none;">
		    	{#foreach $T as record}
		    		<a class="kzjk">
		    			<span style="font-size: 22px;">{$T.record.serialNumber}号</span>
					    <span style="font-size: 14px;">（题:{$T.record.topic}）</span>
		    		</a>
		    	{#/for}
		    </textarea>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>