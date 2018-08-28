<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-考试监控</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/other/js/exam-monitor.js"></script>
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
            	<div class="kcjk" style="margin-left:2%;">
            		<p>检录区</p>
            		<p class="kcjk-num">检录<span id="inspect-num">0</span>人/等候<span id="not-entry-num">0</span>人</p>
            		<ul id="inspect-info-n"></ul>
            	</div>
            	<div class="kcjk">
            		<p>第一考站</p>
						<p class="kcjk-num">候考<span id="not-entry-num-1">0</span>/考试<span id="entried-num-1">0</span>人</p>
            		<ul id="station1-info"></ul>
            	</div>
            	<div class="kcjk">
            		<p>第二考站</p>
            		<p class="kcjk-num">候考<span id="not-entry-num-2">0</span>/考试<span id="entried-num-2">0</span>人</p>
            		<ul id="station2-info"></ul>
            	</div>
            	<div class="kcjk">
            		<p>第三考站</p>
					<p class="kcjk-num">候考<span id="not-entry-num-3">0</span>/考试<span id="entried-num-3">0</span>人</p>
            		<ul id="station3-info"></ul>
            	</div>
            	<div class="kcjk">
            		<p>第四考站</p>
					<p class="kcjk-num">候考<span id="wait-num-4">0</span>/考试<span id="exam-num-4">0</span>人</p>
            		<ul id="station4-info"></ul>
            	</div>
            	<div class="kcjk">
            		<p>第五考站</p>
					<p class="kcjk-num">候考<span id="wait-num-5">0</span>/考试<span id="exam-num-5">0</span>人</p>
            		<ul id="station5-info"></ul>
            	</div>
            	<div class="kcjk">
            		<p>第六考站</p>
					<p class="kcjk-num">候考<span id="wait-num-6">0</span>/考试<span id="exam-num-6">0</span>人</p>
            		<ul id="station6-info"></ul>
            	</div>
            	<div class="kcjk">
            		<p>出站审核</p>
            		<p class="kcjk-num">已出站<span id="exit-verify-num">0</span>人</p>
            		<ul id="exit-verify-info-n"></ul>
            	</div>
            	
            	<textarea id="templete-m" style="display:none;">
		    	{#foreach $T as record}
				{#if $T.record.flag == 0} 
		    		<a class="kzjk">{$T.record.serialNumber}号/等候-题:{$T.record.topic}</a>
		    	{#elseif $T.record.flag == 1}
		    		<a class="kzjk">{$T.record.serialNumber}号/考试-题:{$T.record.topic}</a>
		    	{#if}
		    	{#/for}
		    	</textarea>
		    	
		    	<textarea id="templete-a-m" style="display:none;">
		    	{#foreach $T as record}
		    	{#if $T.record.flag == 0} 
		    		<a class="inspent">
		    			<span></span>{$T.record.serialNumber}号/等候</span>
		    			<span>题:{$T.record.topic1}/{$T.record.topic2}/{$T.record.topic3}</span>
		    		</a>
		    	{#elseif $T.record.flag == 1}
		    		<a class="inspent">
		    			<span></span>{$T.record.serialNumber}号/等候</span>
		    			<span>题:{$T.record.topic1}/{$T.record.topic2}/{$T.record.topic3}</span>
		    		</a>
		    	{#if}
		    	{#/for}
		    	</textarea>
		    	
		    	<textarea id="templete-e-m" style="display:none;">
		    	{#foreach $T as record}
		    		<a class="kzjk">{$T.record.serialNumber}号</a>
		    	{#/for}
		    	</textarea>
		    	
            	<div class="clear"></div>
            	
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>