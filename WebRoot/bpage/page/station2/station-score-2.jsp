<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/station2/js/station-score-2.js"></script>

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
                <div class="column_left_2">
                    <h3 class="monitor_title">第二考站-登分</h3>
                    <p class="monitor_f">
                    	<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/station2-info.jsp','_blank');">候考区<span id="not-entry-num">0</span>人&nbsp;&nbsp;</a>
                    	<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/station2-info.jsp','_blank');">考区<span id="entried-num">0</span>人&nbsp;&nbsp;</a>
                    </p>
                    <div class="clear"></div>
                    <div class="monitor_list">
                       <ul id="entried-info-n"></ul>
                       <textarea id="entried-info-m" style="display:none;">
					    	{#foreach $T as record}
					    	<li id="{$T.record.id}">
					    		<a href="javascript:void(0);" onclick = "openPage('/doctorexam/bpage/page/station2/add-score-2.jsp?id={$T.record.id}&topic={$T.record.serialNumber}','_self');">
					    			<span style="font-size: 22px;">{$T.record.serialNumber}号</span>
					    			<span style="font-size: 14px;">（题:{$T.record.topic}）</span>
					    		</a>
					    	</li>
					    	{#/for}
					    </textarea>
                    </div>
                </div>
			    
                <div class="column_right_x">
                	<h3 class="column_right_title">已登分<span id="exit-num">0</span>人</h3>
                	<div>
                	  <ul id="exit-info-n" class="column_right_list">
                      </ul>
                    </div>
                    <textarea id="exit-info-m" style="display:none;">
			    	{#foreach $T as record}
                    <li><a>{$T.record.serialNumber}号</a></li>
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