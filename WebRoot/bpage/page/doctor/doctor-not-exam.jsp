<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>执业医师实践技能考试系统-未考考生信息</title>
<link href="bpage/style/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery-jtemplates.js"></script>
<script type="text/javascript" src="bpage/js/navbar.js"></script>
<script type="text/javascript" src="bpage/js/menu.js"></script>
<script type="text/javascript" src="bpage/js/paging.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="bpage/js/bpage.js"></script>
<script type="text/javascript" src="bpage/page/doctor/js/doctor-not-exam.js"></script>

</head>

<body>
	<!-- top -->
	<jsp:include page="../top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../left.jsp"></jsp:include>
    
    <!-- right-nei -->
    <div class="body_right">
    	<div class="body_right_1">
    		<div class="body_right_top">
           	  <p class="body_right_top_left"><a href="javascript:void(0);">查询统计</a>&nbsp;>&nbsp;<a href="javascript:void(0);"><strong>未考考生统计</strong></a></p>
              <div class="clear"></div>
            </div>
            
            <div class="occupying_left"></div>
            	
            <div class="occupying_right_1">
				<table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <tr>
                    <th width="13%" align="right">查询条件</th>
                    <th width="30%">
                    	<select id="query-condition" class="ty_k_1">
                    		<option value="0">--选择查询条件--</option>
                    		<option value="name">考生姓名</option>
                    		<option value="card">证件编号</option>
                    		<option value="ksh">报名编号</option>
                    	</select>
                    </th>
                    <th width="13%" align="right">查询内容</th>
                    <th width="30%"><input id="query-nei" type="text" class="ty_k_1" placeholder="请输入查询内容" /></th>
                    <th width="4%">&nbsp;</th>
                    <th width="10%"><a onclick="queryDoctorNotExamInfo();" class="submit">查询</a></th>
                  </tr>
                </table>
                
                <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <thead>
	                  <tr>
	                    <th width="8%">序号</th>
	                    <th width="11%">报名编号</th>
	                    <th width="10%">姓名</th>
	                    <th width="8%">性别</th>
	                    <th width="10%">名族</th>
	                    <th width="11%">出生日期</th>
	                    <th width="12%">证件编号</th>
	                    <th width="11%">类别</th>
	                  </tr>
                  </thead>
                  <tbody id="tmplete-n"></tbody>
                  <tr>
                    <td colspan="8" align="center">
                        <a id="firstPage"><img src="bpage/images/PageHome.gif" width="15" height="14" /></a>
                        <a id="prev"><img src="bpage/images/PageUp.gif" width="15" height="14" /></a>
                        <span class="current-page"></span> / <span class="page-count"></span>
                        <a id="next"><img src="bpage/images/PageDown.gif" width="15" height="14" /></a>
                        <a id="lastPage"><img src="bpage/images/PageEnd.gif" width="15" height="14" /></a>
                    </td>
                  </tr>
                </table>  
            </div>
            <textarea id="tmplete-m" style="display:none;">
		    	{#foreach $T as record}
		  	 	<tr>
		  	 		<td align="center">{$T.record$index + 1}</td>
		  	 		<td align="center">{$T.record.ksh}</td>
		  	 		<td align="center">{$T.record.name}</td>
		  	 		<td align="center">{$T.record.sex}</td>
		  	 		<td align="center">{$T.record.nation}</td>
		  	 		<td align="center">{$T.record.birthday}</td>
		  	 		<td align="center">{$T.record.card}</td>
		  	 		{#if $T.record.examType == 120}
		  	 			<td align="center">执业医师</td>
		  	 		{#elseif $T.record.examType == 220}
		  	 			<td align="center">执业助理医师</td>
		  	 		{#/if}
		  	 	</tr>
		  	 	{#/for}
		    </textarea>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>