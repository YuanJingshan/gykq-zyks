<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int station=Integer.parseInt(request.getParameter("station"));
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="../../../bpage/page/css-js-lib.jsp"></jsp:include>
</head>

<body>
	<!-- top -->
	<jsp:include page="../../../bpage/page/top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../../../bpage/page/left.jsp"></jsp:include>
    
       <div class="body_right">
    	<div class="body_right_1">
            <div class="occupying_left"></div>
            	
            <div class="occupying_right_1">
                <div class="column_left_2">
                    <h3 class="monitor_title">审核出站</h3>
                    <p class="monitor_f">
                    	<a href="javascript:void(0);">考区<span id="score_num">0</span>人&nbsp;&nbsp;</a>
                    </p>
                    <div class="clear"></div>
                    <div class="monitor_list">
                       <ul id="score_info_n"></ul>
                       <textarea id="score_info_m" style="display:none;">
					    	{#foreach $T as record}
					    	<li id="{$T.record.doctorId}">
					    		<a href="javascript:void(0);" onclick = "openPage('/doctorexam/view/management/station/verify-score.jsp?station=<%=station%>&id={$T.record.id}','_self');">
					    			<span style="font-size: 22px;">{$T.record.serialNumber}号</span>
					    			<span style="font-size: 14px;">（题:{$T.record.topic}）</span>
					    		</a>
					    	</li>
					    	{#/for}
					    </textarea>
                        <div class="clear"></div>
                    </div>
                </div>
			    
                <div class="column_right_x">
                	<h3 class="column_right_title">已审核出站<span id="verify_num">0</span>人</h3>
                	<div>
                	  <ul id="verify_info_n" class="column_right_list">
                      </ul>
                    </div>
                    <textarea id="verify_info_m" style="display:none;">
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
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/management/station/doctoreaxm.station.verify.js"></script>
    <script type="text/javascript">
	    $(function(){
			$.doctoreaxm.station.verify.init(<%=station%>);
		});
    </script>
</body>
</html>