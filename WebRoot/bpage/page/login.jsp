<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)</title>
<jsp:include page="css-js-lib.jsp"></jsp:include>

</head>

<body style="background-color:#1979CA;">
	<div class="login">
    	<div class="login_logo"><img src="bpage/images/logo.png" /></div>
        
        <div class="login_content">
        	<form id="login-form" method="post">
            	<div class="login_content_1">
                	<input id="name" name="name" type="text" value="请输入您的登录名" onFocus="if (value =='请输入您的登录名'){value =''}" onBlur="if (value ==''){value='请输入您的登录名'}" />
                </div>
                <div class="login_content_2">
                	<input id="password" name="password" type="password" value="......" onFocus="if (value =='......'){value =''}" onBlur="if (value ==''){value='......'}" />
                </div>
                <div class="login_content_3">
                	<a href="#" id="loginBtn">登　　录</a>
                </div>
                <p class="login_content_4">忘记了您的密码？<br /><span>别担心，点击 <a href="tencent://Message/?Uin=2762705263&websiteName=www.lanrentuku.com=&Menu=yes">这里</a> 找回您的密码。</span></p>
            </form>
        </div>
        
        <p class="login_copyright">2015 © 智业软件股份有限公司. Admin Dashboard. </p>
    </div>	
    
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/management/user/doctoreaxm.user.login.js"></script>
</body>
</html>