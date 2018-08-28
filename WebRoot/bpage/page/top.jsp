<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="top">
	<div class="top_logo">医师资格实践技能考试计算机控制系统(贵阳考点)</div>
    <p class="top_right">
        <span>欢迎登陆：${sessionScope.user.userName}</span>
        <span>权限：
        	<c:choose>
        		<c:when test="${sessionScope.user.authority == 1}">超级管理员</c:when>
        		<c:when test="${sessionScope.user.authority == 2}">入口检录员</c:when>
        		<c:when test="${sessionScope.user.authority == 3}">第一考站分号员</c:when>
        		<c:when test="${sessionScope.user.authority == 4}">第一考站登分员</c:when>
        		<c:when test="${sessionScope.user.authority == 5}">第二考站分号员</c:when>
        		<c:when test="${sessionScope.user.authority == 6}">第二考站登分员</c:when>
        		<c:when test="${sessionScope.user.authority == 7}">第三考站分号员</c:when>
        		<c:when test="${sessionScope.user.authority == 8}">第三考站登分员</c:when>
        		<c:when test="${sessionScope.user.authority == 9}">出口审核员</c:when>
        		<c:when test="${sessionScope.user.authority == 11}">第四考站分号员</c:when>
        		<c:when test="${sessionScope.user.authority == 12}">第四考站登分员</c:when>
        		<c:when test="${sessionScope.user.authority == 13}">第五考站分号员</c:when>
        		<c:when test="${sessionScope.user.authority == 14}">第五考站登分员</c:when>
        		<c:when test="${sessionScope.user.authority == 15}">第六考站分号员</c:when>
        		<c:when test="${sessionScope.user.authority == 16}">第六考站登分员</c:when>
        		<c:when test="${sessionScope.user.authority == 17}">第一考站审核员</c:when>
        		<c:when test="${sessionScope.user.authority == 18}">第二考站审核员</c:when>
        		<c:when test="${sessionScope.user.authority == 19}">第三考站审核员</c:when>
        		<c:when test="${sessionScope.user.authority == 20}">第四考站审核员</c:when>
        		<c:when test="${sessionScope.user.authority == 21}">第五考站审核员</c:when>
        		<c:when test="${sessionScope.user.authority == 22}">第六考站审核员</c:when>
        		<c:when test="${sessionScope.user.authority == 10}">管理员</c:when>
        	</c:choose>
        </span>
        <span><a href="${pageContext.request.contextPath}/userServlet?method=logout">退出</a></span>
    </p>
    <div class="clear"></div>
</div>