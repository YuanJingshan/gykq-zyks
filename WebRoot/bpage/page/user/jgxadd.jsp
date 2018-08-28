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
           	  <p class="body_right_top_left"><a href="bpage/page/index.jsp">首页</a>&nbsp;>&nbsp;<a href="javascript:void(0);">各站及格分数线</a>&nbsp;>&nbsp;<a>添加</a></p>
                <div class="body_right_top_right">
                	<a id="refresh" href="javascript:void(0);" class="account">刷新</a>
                    <a id="add" href="bpage/page/user/user-add.jsp" class="account">添加</a>
              	</div>
                <div class="clear"></div>
            </div>
            
            <div class="occupying_left"></div>
            
            <div class="occupying_right">
            	<form id="jgx-form" method="post">
	            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c">
	                  <tr>
	                    <th width="10%">第一考站及格分数线</th>
	                    <td width="26%" align="left"><input id="station1jgx" name="station1jgx" type="text" class="ty_k_1" placeholder="请输入及格分数线" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
	                  </tr>
	                  <tr>
	                    <th width="10%">第一考站及格分数线</th>
	                    <td width="26%" align="left"><input id="station2jgx" name="station2jgx" type="text" class="ty_k_1" placeholder="请输入及格分数线" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
	                  </tr>
	                  <tr>
	                    <th width="10%">第一考站及格分数线</th>
	                    <td width="26%" align="left"><input id="station3jgx" name="station3jgx" type="text" class="ty_k_1" placeholder="请输入及格分数线" /></td>
	                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
	                  </tr>
	                  <tr>
	                    <td colspan="6" align="center">
	                    	<div style="width:260px; margin-left:auto; margin-right:auto;">
	                            <a href="jacascript:void(0);" onclick="resetForm('jgx-form');" class="reset">重　置</a>
	                            <a href="javascript:void(0);" onclick="addJGX();" class="submit">提　交</a>
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