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
            	<form id="user-form" method="post">
	            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c">
	                  <tr>
	                    <th width="10%">用户名</th>
	                    <td width="26%" align="left"><input id=name name="name" type="text" class="ty_k" placeholder="请输入用户名" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入用户名</span></td>
	                    <th width="10%">密码</th>
	                    <td width="26%" align="left"><input id="password" name="password"  type="password" class="ty_k" placeholder="请输入密码" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入密码</span></td>
	                  </tr>
	                  <tr>
	                    <th width="10%">管理权限</th>
	                    <td width="26%" align="left">
							<select id="authority" name="authority" class="ty_xl">
								<option value="1">超级管理员</option>
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
	                            <option value="22">第六站审核员</option>
	                        </select>
	                    </td>
	                    <td width="14%" align="center"><span style="color:#F00">请选择您的管理权限</span></td>
	                    <th width="10%">真实姓名</th>
	                    <td width="26%" align="left"><input id="realName" name="realName" type="text" class="ty_k" placeholder="请输入您的真实姓名" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入您的真实姓名</span></td>
	                  </tr>
	                  <tr>
	                    <th width="10%">手机号码</th>
	                    <td width="26%" align="left"><input id="tel" name="tel" type="text" class="ty_k" placeholder="请输入手机号码" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入您的手机号码</span></td>
	                    <th width="10%">联系地址</th>
	                    <td width="26%" align="left"><input id="address" name="address" type="text" class="ty_k" placeholder="请输入联系地址" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入您的联系地址</span></td>
	                  </tr>
	                  <tr>
	                    <td colspan="6" align="center">
	                    	<div style="width:260px; margin-left:auto; margin-right:auto;">
	                            <a href="jacascript:void(0);" onclick="resetForm('user-form');" class="reset">重　置</a>
	                            <a href="javascript:void(0);" onclick="addUser();" class="submit">提　交</a>
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