<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
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
    
	<!--右侧主体-->  
    <div class="body_right">
    	<div class="body_right_1">
        	<div class="body_right_top">
           	  	<p class="body_right_top_left"><a href="${pageContext.request.contextPath}/view/index.jsp">首页</a>&nbsp;>&nbsp;<a href="javascript:void(0);">系统管理</a>&nbsp;>&nbsp;<span style="color: blue;">系统配置</span></p>
                <div class="body_right_top_right">
                	<a id="refresh" href="javascript:void(0);" class="account">刷新</a>
              	</div>
                <div class="clear"></div>
            </div>
            
            <div class="occupying_left"></div>
            
            <div class="occupying_right">
            	<div style="margin: 1%;">
            		<label><strong>系统初始化</strong></label>
            		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c">
	                  <tr>
	                    <td colspan="6" align="left">
	                    	<div>
	                    	<p style="margin: 10px;">
	                    		<a href="javascript:void(0);" id="initBtn" class="button" style="float: left;">系统初始化</a>
	                    		　<strong>说明：</strong>点击系统初始化，将初始化系统，序号从001开始计数，删除各考站历史数据。</p>
	                    	</div>
	                    	
	                    </td>
	                  </tr>
	                </table>
            	</div>
            	
            	<div class="clear"></div>
            	
            	<div style="margin: 1%;">
            		<label><strong>考试参数配置</strong></label>
            		<form id="jgx-form" method="post">
		            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c">
		            	  <tr style="display: none;">
		            	  	<td><input id="id" name="id"></td>
		            	  </tr>
		            	  <tr>
		                    <th width="10%">序号数量</th>
		                    <td width="76%" colspan="4" align="left"><input id="serialNumber" name="serialNumber" type="text" class="ty_k_1" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请配置序号数量</span></td>
		                  </tr>
		                  <tr>
		                    <th width="10%">一站及格线</th>
		                    <td width="26%" align="left"><input id="station1jgx" name="station1jgx" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
		                    <th width="10%">题组数量</th>
		                    <td width="26%" align="left"><input id="topic1" name="topic1" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入题组数量</span></td>
		                  </tr>
		                  <tr>
		                  	<th width="10%">二站及格线</th>
		                    <td width="26%" align="left"><input id="station2jgx" name="station2jgx" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
		                    <th width="10%">题组数量</th>
		                    <td width="26%" align="left"><input id="topic2" name="topic2" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入题组数量</span></td>
		                  </tr>
		                  <tr>
		                  	<th width="10%">三站及格线</th>
		                    <td width="26%" align="left"><input id="station3jgx" name="station3jgx" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
		                    <th width="10%">题组数量</th>
		                    <td width="26%" align="left"><input id="topic3" name="topic3" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入题组数量</span></td>
		                  </tr>
		                  <tr>
		                  	<th width="10%">四站及格线</th>
		                    <td width="26%" align="left"><input id="station4jgx" name="station4jgx" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
		                    <th width="10%">题组数量</th>
		                    <td width="26%" align="left"><input id="topic4" name="topic4" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入题组数量</span></td>
		                  </tr>
		                  <tr>
		                  	<th width="10%">五站及格线</th>
		                    <td width="26%" align="left"><input id="station5jgx" name="station5jgx" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
		                    <th width="10%">题组数量</th>
		                    <td width="26%" align="left"><input id="topic5" name="topic5" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入题组数量</span></td>
		                  </tr>
		                  <tr>
		                  	<th width="10%">六站及格线</th>
		                    <td width="26%" align="left"><input id="station6jgx" name="station6jgx" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入及格分数线</span></td>
		                    <th width="10%">题组数量</th>
		                    <td width="26%" align="left"><input id="topic6" name="topic6" type="text" class="ty_k" /></td>
		                    <td width="14%" align="center"><span style="color:#F00">请输入题组数量</span></td>
		                  </tr>
		                  <tr>
		                    <td colspan="6" align="center">
		                    	<div style="width:260px; margin-left:auto; margin-right:auto;">
		                            <a href="jacascript:void(0);" id="resetBtn" class="reset">重　置</a>
		                            <a href="javascript:void(0);" id="submitBtn" class="submit">提　交</a>
		                        </div>
		                    </td>
		                  </tr>
		                </table>
	                </form>
            	</div>
          	</div>
            <div class="clear"></div>
            
            <div class="layui-form-item" id="init-dialog" style="display: none; margin-top: 25px;">
			    <label class="layui-form-label" style="text-align:center;">输入密码</label>
			    <div class="layui-input-inline">
			      <input type="password" name="password" id="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
			    </div>
			</div>
        </div>
    </div>
    <div class="clear"></div>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/management/params/doctoreaxm.params.context.js"></script>
</body>
</html>