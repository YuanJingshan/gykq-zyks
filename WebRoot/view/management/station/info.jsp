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
            	<h3 class="monitor_title">第<%=station%>考站-考站情况</h3>
                <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <tr>
                    <th width="50%">候考区<span id="wait_num"></span>人</th>
                    <th width="50%">考区<span id="entried-num"></span>人</th>
                  </tr>
                  <tr>
                    <td align="center" id="wait_info_n"></td>
                    <td align="center" id="exam_info_n"></td>
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
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/management/station/doctoreaxm.station.info.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$.doctoreaxm.station.info.init(<%=station%>);
    	});
    </script>
</body>
</html>