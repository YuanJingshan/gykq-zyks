<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-出口审核</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/other/js/exit-info.js"></script>

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
                <div class="column_left_2_x">
                	<h3 class="monitor_title">出口审核-审核情况</h3>
                	<p class="monitor_f">
                		<a>已审核<span id="exit-verify-num">0</span>人&nbsp;&nbsp;</a>
                	</p>
                    <div class="clear"></div>
                    <div class="monitor_list">
                        <ul id="exit-verify-info-n"></ul>
                        <textarea id="exit-verify-info-m" style="display:none;">
					    	{#foreach $T as record}
					    	<li id="{$T.record.id}">
					    		<a>{$T.record.serialNumber}</a>
					    	</li>
					    	{#/for}
					    </textarea>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>