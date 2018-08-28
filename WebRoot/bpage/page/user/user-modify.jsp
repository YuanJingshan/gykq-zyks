<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
              	</div>
                <div class="clear"></div>
            </div>
            
            <div class="occupying_left"></div>
            
            <div class="occupying_right">
            	<input id="session-authority" type="text" value="${sessionScope.user.authority}" style="display: none;">
            	<form id="user-form" method="post">
	            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c">
	            	  <tr style="display: none;">
	            	  	<td><input id="userId" name="userId" value="${user.id}"></td>
	            	  </tr>
	                  <tr>
	                    <th width="10%">账户名</th>
	                    <td width="26%" align="left"><input id=name name="name" type="text" class="ty_k" placeholder="请输入账户名" value="${user.userName}"/></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入账户名</span></td>
	                    <th width="10%">密码</th>
	                    <td width="26%" align="left"><input id="password" name="password"  type="password" class="ty_k" placeholder="请输入密码" value="${user.password}"/></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入密码</span></td>
	                  </tr>
	                  <tr>
	                    <th width="10%">管理权限</th>
	                    <td width="26%" align="left">
	                      <c:choose>
	                      	<c:when test="${sessionScope.user.authority == 1}">
							  <select id="authority" name="authority" class="ty_xl">
								<c:choose>
									<c:when test="${user.authority == 1}">
			                            <option value="1" selected="selected">超级管理员</option>
									</c:when>
									<c:when test="${user.authority == 2}">
										<option value="10">管理员</option>
			                            <option value="2" selected="selected">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 3}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3" selected="selected">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 4}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4" selected="selected">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 5}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5" selected="selected">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 6}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6" selected="selected">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 7}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7" selected="selected">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 8}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8" selected="selected">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 9}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9" selected="selected">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 10}">
										<option value="10" selected="selected">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 11}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11" selected="selected">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 12}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12" selected="selected">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 13}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13" selected="selected">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 14}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14"  selected="selected">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 15}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15" selected="selected">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 16}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16" selected="selected">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 17}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17" selected="selected">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 18}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18" selected="selected">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 10}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19" selected="selected">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 20}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20" selected="selected">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 21}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21" selected="selected">第五站审核员</option>
			                            <option value="22">第六站审核员</option>
									</c:when>
									<c:when test="${user.authority == 22}">
										<option value="10">管理员</option>
			                            <option value="2">入口检录员</option>
			                            <option value="3">第一站分号员</option>
			                            <option value="4">第一站登分员</option>
			                            <option value="5">第二站分号员</option>
			                            <option value="6">第二站登分员</option>
			                            <option value="7">第三站分号员</option>
			                            <option value="8">第三站登分员</option>
			                            <option value="9">出口审核员</option>
			                            <option value="11">第四站分号员</option>
			                            <option value="12">第四站登分员</option>
			                            <option value="13">第五站分号员</option>
			                            <option value="14">第五站登分员</option>
			                            <option value="15">第六站分号员</option>
			                            <option value="16">第六站登分员</option>
			                            <option value="17">第一站审核员</option>
			                            <option value="18">第二站审核员</option>
			                            <option value="19">第三站审核员</option>
			                            <option value="20">第四站审核员</option>
			                            <option value="21">第五站审核员</option>
			                            <option value="22" selected="selected">第六站审核员</option>
									</c:when>
								</c:choose>
	                          </select>
	                        </c:when>
	                        <c:otherwise>
	                          <select id="authority" name="authority" class="ty_xl">
	                          <c:choose>
	                        	<c:when test="${user.authority == 2}">
	                        		<option value="2" selected="selected">入口检录员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 3}">
	                        		<option value="3" selected="selected">第一站分号员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 4}">
	                        		<option value="4" selected="selected">第一站登分员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 5}">
	                        		<option value="5" selected="selected">第二站分号员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 6}">
	                        		<option value="6" selected="selected">第二站登分员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 7}">
	                        		<option value="7" selected="selected">第三站分号员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 8}">
	                        		<option value="8" selected="selected">第三站登分员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 9}">
	                        		<option value="9" selected="selected">出口审核员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 10}">
	                        		<option value="9" selected="selected">管理员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 11}">
	                        		<option value="9" selected="selected">第四站分号员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 12}">
	                        		<option value="9" selected="selected">第四站登分员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 13}">
	                        		<option value="9" selected="selected">第五站分号员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 14}">
	                        		<option value="9" selected="selected">第五站登分员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 15}">
	                        		<option value="9" selected="selected">第六站分号员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 16}">
	                        		<option value="9" selected="selected">第六站登分员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 17}">
	                        		<option value="9" selected="selected">第一站审核员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 18}">
	                        		<option value="9" selected="selected">第二站审核员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 19}">
	                        		<option value="9" selected="selected">第三站审核员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 20}">
	                        		<option value="9" selected="selected">第四站审核员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 21}">
	                        		<option value="9" selected="selected">第五站审核员</option>
	                        	</c:when>
	                        	<c:when test="${user.authority == 22}">
	                        		<option value="9" selected="selected">第六站审核员</option>
	                        	</c:when>
	                       	  </c:choose>
	                       	  </select>
	                        </c:otherwise>
	                      </c:choose>
	                    	
	                    </td>
	                    <td width="14%" align="center"><span style="color:#F00">请选择您的管理权限</span></td>
	                    <th width="10%">真实姓名</th>
	                    <td width="26%" align="left"><input id="realName" name="realName" type="text" class="ty_k" placeholder="请输入您的真实姓名" value="${user.realName}" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入您的真实姓名</span></td>
	                  </tr>
	                  <tr>
	                    <th width="10%">手机号码</th>
	                    <td width="26%" align="left"><input id="tel" name="tel" type="text" class="ty_k" placeholder="请输入您的手机号码" value="${user.tel}" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入您的手机号码</span></td>
	                    <th width="10%">联系地址</th>
	                    <td width="26%" align="left"><input id="address" name="address" type="text" class="ty_k" placeholder="请输入您的联系地址" value="${user.address}" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入您的联系地址</span></td>
	                  </tr>
	                  <tr>
	                    <td colspan="6" align="center">
	                    	<div style="width:260px; margin-left:auto; margin-right:auto;">
	                            <a href="javascript:void(0);" onclick="resetForm('user-form');" class="reset">重　置</a>
	                            <a href="javascript:void(0);" onclick="modifyUser();" class="submit">提　交</a>
	                        </div>
	                    </td>
	                  </tr>
	                </table>
                </form>
          	</div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>