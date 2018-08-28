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
<script type="text/javascript" src="bpage/page/user/js/user-list.js"></script>

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
           	  <p class="body_right_top_left"><a href="bpage/page/index.jsp">首页</a>&nbsp;>&nbsp;<a href="javascript:void(0);">管理员信息</a>&nbsp;>&nbsp;<a href="bpage/page/user/user-list.jsp">管理员列表</a></p>
                <div class="body_right_top_right">
                	<a id="refresh" href="javascript:void(0);" class="account">刷新</a>
                    <a id="add" href="bpage/page/user/user-add.jsp" class="account">添加</a>
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
	                    <th width="11%">用户名</th>
	                    <th width="8%">姓名</th>
	                    <th width="14%">手机号码</th>
	                    <th width="17%">联系地址</th>
	                    <th width="15%">权限</th>
	                    <th width="11%">新增时间</th>
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
		  	 		<td align="center">{$T.record.userName}</td>
		  	 		<td align="center">{$T.record.realName}</td>
		  	 		<td align="center">{$T.record.tel}</td>
		  	 		<td align="center">{$T.record.address}</td>
		  	 		{#if $T.record.authority == 1}
		  	 			<td align="center">超级管理员</td>
		  	 		{#elseif $T.record.authority == 2}
		  	 			<td align="center">入口检录员</td>
		  	 		{#elseif $T.record.authority == 3}
		  	 			<td align="center">第一站分号员</td>
		  	 		{#elseif $T.record.authority == 4}
		  	 			<td align="center">第一站登分员</td>
		  	 		{#elseif $T.record.authority == 5}
		  	 			<td align="center">第二站分号员</td>
		  	 		{#elseif $T.record.authority == 6}
		  	 			<td align="center">第二站登分员</td>
		  	 		{#elseif $T.record.authority == 7}
		  	 			<td align="center">第三站分号员</td>
		  	 		{#elseif $T.record.authority == 8}
		  	 			<td align="center">第三站登分员</td>
		  	 		{#elseif $T.record.authority == 9}
		  	 			<td align="center">出口审核员</td>
		  	 		{#elseif $T.record.authority == 11}
		  	 			<td align="center">第四站分号员</td>
		  	 		{#elseif $T.record.authority == 12}
		  	 			<td align="center">第四站登分员</td>
		  	 		{#elseif $T.record.authority == 13}
		  	 			<td align="center">第五站分号员</td>
		  	 		{#elseif $T.record.authority == 14}
		  	 			<td align="center">第五站登分员</td>
		  	 		{#elseif $T.record.authority == 15}
		  	 			<td align="center">第六站分号员</td>
		  	 		{#elseif $T.record.authority == 16}
		  	 			<td align="center">第六站登分员</td>
		  	 		{#elseif $T.record.authority == 17}
		  	 			<td align="center">第一站审核员</td>
		  	 		{#elseif $T.record.authority == 18}
		  	 			<td align="center">第二站审核员</td>
		  	 		{#elseif $T.record.authority == 19}
		  	 			<td align="center">第三站审核员</td>
		  	 		{#elseif $T.record.authority == 20}
		  	 			<td align="center">第四站审核员</td>
		  	 		{#elseif $T.record.authority == 21}
		  	 			<td align="center">第五站审核员</td>
		  	 		{#elseif $T.record.authority == 22}
		  	 			<td align="center">第六站审核员</td>
		  	 		{#/if}
		  	 		<td align="center">{$T.record.insertDt}</td>
		  	 		<td align="center">
		  	 			<a href="javascript:void(0);" onclick="openPage('/doctorexam/userServlet?method=modifyJmp&userId={$T.record.userId}','_self');">修改</a>|
		  	 			<a href="javascript:void(0);" onclick="deleteById({$T.record.userId});">删除</a>
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