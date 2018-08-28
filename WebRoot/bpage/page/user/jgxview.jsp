<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-后台管理系统</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/user/js/jgxtable.js"></script>

</head>

<body>
	<!-- top -->
	<jsp:include page="../top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../left.jsp"></jsp:include>
    
	<!--右侧主体-->  
    <div class="body_right">
    	<div class="body_right_1">
    	  <div class="body_right_top">
           	  <p class="body_right_top_left"><a href="bpage/page/index.jsp">首页</a>&nbsp;>&nbsp;<a href="javascript:void(0);">管理员信息</a>&nbsp;>&nbsp;<a href="javascript:void(0);">各站及格线</a></p>
                <div class="body_right_top_right">
                	<a id="refresh" href="javascript:void(0);" class="account">刷新</a>
                    <a id="add" href="bpage/page/user/jgxadd.jsp" class="account">添加</a>
                    <a id="delete" href="javascript:void(0);" class="account">删除</a>
              	</div>
                <div class="clear"></div>
            </div>
            <div class="occupying_left"></div>
            <div class="occupying_right_1">
            	<table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                  <thead>
	                  <tr>
	                    <th width="6%"><input class="checkAll" type="checkbox">&nbsp;全选</th>
	                    <th width="8%">序号</th>
	                    <th width="20%">第一考站及格分数线</th>
	                    <th width="20%">第二考站及格分数线</th>
	                    <th width="20%">第三考站及格分数线</th>
	                    <th width="11%">添加时间</th>
	                    <th width="10%">操作</th>
	                  </tr>
                  </thead>
                  <tbody id="tmplete-n"></tbody>
                  <tr>
                    <td colspan="10" align="center">
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
		  	 		<td align="center"><input class="checkItem" type="checkbox" value="{$T.record.userId}"/></td>
		  	 		<td align="center">{$T.record$index + 1}</td>
		  	 		<td align="center">{$T.record.station1jgx}</td>
		  	 		<td align="center">{$T.record.station2jgx}</td>
		  	 		<td align="center">{$T.record.station3jgx}</td>
		  	 		<td align="center">{$T.record.insertDt}</td>
		  	 		<td align="center">
		  	 			<a href="javascript:void(0);" onclick="openPage('/doctorexam/jgxServlet?method=modifyJmp&id={$T.record.id}','_self');">修改</a>|
		  	 			<a href="javascript:void(0);" onclick="deleteById({$T.record.id});">删除</a>
		  	 		</td>
		  	 	</tr>
		  	 	{#/for}
		    </textarea>
		    
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>