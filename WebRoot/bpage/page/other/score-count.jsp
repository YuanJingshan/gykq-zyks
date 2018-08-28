<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-考试成绩</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/other/js/score-count.js"></script>

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
           	  <p class="body_right_top_left"><a href="javascript:void(0);">查询统计</a>&nbsp;>&nbsp;<a href="javascript:void(0);"><strong>总成绩统计</strong></a></p>
              <div class="clear"></div>
            </div>
            
            <div class="occupying_left"></div>
            <div class="occupying_right_1">
				<table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <tr>
                    <th width="8%" align="right">查询条件</th>
                    <th width="25%">
                    	<select id="query-condition" class="ty_k_1">
                    		<option value="0">--选择查询条件--</option>
                    		<option value="name">考生姓名</option>
                    		<option value="card">证件编号</option>
                    		<option value="ksh">报名编号</option>
                    		<option value="topic">序号</option>
                    		<option value="data">出站时间</option>
                    		<option value="score">分数段</option>
                    		<option value="type">报考类别</option>
                    	</select>
                    </th>
                    <th width="13%" align="right">查询内容</th>
                    <th width="30%">
                    	<input id="query-nei" type="text" class="ty_k_1" placeholder="请输入查询内容" />
                    	<div id="date-d" style="display: none;">
	                    	<input id="start-dt" type="text" class="ty_k_4" value="开始时间" onfocus="this.value='';" >&nbsp;&nbsp;-
	                    	<input id="end-dt" type="text" class="ty_k_4" value="结束时间" onfocus="this.value='';" >
                    	</div>
                    	<div id="score-d" style="display: none;">
	                    	<input id="start-fs" type="text" class="ty_k_4" value="最小分数 xx.xxx" onfocus="this.value='';" onblur="if (value=='') {value = '最小分数 xx.xxx';}">&nbsp;&nbsp;-
	                    	<input id="end-fs" type="text" class="ty_k_4" value="最大分数 xx.xxx" onfocus="this.value='';" onblur="if (value=='') {value = '最大分数 xx.xxx';}">
                    	</div>
                    	<select id="exam-type" class="ty_k_1" style="display: none;">
                    		<option value="120">执业医师</option>
                    		<option value="220">执业助理医师</option>
                    	</select>
                    </th>
                    <th width="4%">&nbsp;</th>
                    <th width="10%"><a href="javascript:void(0);" onclick="queryExamScore();" class="submit">查询</a></th>
                    <c:if test="${sessionScope.user.authority == 1}">
                    	<th width="10%"><a href="javascript:void(0);" onclick="exportExcelExam();" class="submit">excel导出</a></th>
                    </c:if>
                    <c:if test="${sessionScope.user.authority == 10}">
                    	<th width="10%"><a href="javascript:void(0);" onclick="exportExcelExam();" class="submit">excel导出</a></th>
                    </c:if>
                  </tr>
                </table>
                
                <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <thead>
	                  <tr>
	                    <th width="4%">序号</th>
	                    <th width="10%">报名编号</th>
	                    <th width="5%">姓名</th>
	                    <th width="5%">性别</th>
	                    <th width="5%">名族</th>
	                    <th width="10%">出生日期</th>
	                    <th width="13%">证件编号</th>
	                    <th width="8%">报考类别</th>
	                    <th width="4%">序号</th>
	                    <th width="4%">一站成绩</th>
	                    <th width="4%">二站成绩</th>
	                    <th width="4%">三站成绩</th>
	                    <th width="4%">总成绩</th>
	                    <th width="10%">检录时间</th>
	                    <th width="10%">出口时间</th>
	                  </tr>
                  </thead>
                  <tbody id="tmplete-n"></tbody>
                  <tr>
                    <td colspan="15" align="center">
                    	<span>共<span class="count-record"></span>条记录，及格率<span class="others-record"></span>%</span>
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
		  	 		<td align="center">{$T.record.serialNumber}</td>
		  	 		<td align="center">{$T.record.score_1}</td>
		  	 		<td align="center">{$T.record.score_2}</td>
		  	 		<td align="center">{$T.record.score_3}</td>
		  	 		<td align="center">{$T.record.score_count}</td>
		  	 		<td align="center">{$T.record.entryDt}</td>
		  	 		<td align="center">{$T.record.insertDt}</td>
		  	 	</tr>
		  	 	{#/for}
		    </textarea>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>