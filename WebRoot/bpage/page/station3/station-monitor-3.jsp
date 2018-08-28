<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-第三考站</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/station3/js/station-monitor-3.js"></script>

</head>

<body>
	<p>
		<object classid="clsid:46E4B248-8A41-45C5-B896-738ED44C1587" id="SynCardOcx1" codeBase="SynCardOcx.CAB#version=1,0,0,1" width="0" height="0" ></object>
	</p>
	
	<!-- top -->
	<jsp:include page="../top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../left.jsp"></jsp:include>
    
       <div class="body_right">
    	<div class="body_right_1">
            <div class="occupying_left"></div>
            	
            <div class="occupying_right_1">
                <div class="column_left_2">
                    <h3 class="monitor_title">第三考站-考站监控</h3>
                    <p class="monitor_f">
                    	<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/station3-info.jsp','_blank');">候考区<span id="not-entry-num">0</span>人&nbsp;&nbsp;</a>
                    	<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/station3-info.jsp','_blank');">考区<span id="entried-num">0</span>人&nbsp;&nbsp;</a>
                    </p>
                    <div class="clear"></div>
                    <div class="monitor_list">
                       <ul id="not-entry-info-n"></ul>
                       <textarea id="not-entry-info-m" style="display:none;">
					    	{#foreach $T as record}
					    	<li id="{$T.record.id}">
					    		<a href="javascript:void(0);">
					    			<span style="font-size: 22px;">{$T.record.serialNumber}号</span>
					    			<span style="font-size: 14px;">（题:{$T.record.topic}）</span>
					    		</a>
					    	</li>
					    	{#/for}
					    </textarea>
                    </div>
                </div>
			    
                <div class="column_right_x">
                	<h3 class="column_right_title">考区考生信息</h3>
                	<div class="demo" style="overflow:hidden;width:100%; height:500px; margin-top:10px; margin-bottom:10px;">
                	  <ul id="entried-info-n" class="column_right_list">
                      </ul>
                    </div>
                    <textarea id="entried-info-m" style="display:none;">
			    	{#foreach $T as record}
                    	<li><a href="javascript:void(0);">{$T.record.serialNumber}号</a></li>
			  	 	{#/for}
			  	 	</textarea>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>