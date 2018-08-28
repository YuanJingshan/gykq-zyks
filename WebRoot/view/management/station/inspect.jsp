<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int station=Integer.parseInt(request.getParameter("station"));
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="../../../bpage/page/css-js-lib.jsp"></jsp:include>
</head>

<body>
	<p>
		<object classid="clsid:46E4B248-8A41-45C5-B896-738ED44C1587" id="SynCardOcx1" codeBase="SynCardOcx.CAB#version=1,0,0,1" width="0" height="0" ></object>
	</p>
	
	<!-- top -->
	<jsp:include page="../../../bpage/page/top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../../../bpage/page/left.jsp"></jsp:include>
    
       <div class="body_right">
    	<div class="body_right_1">
            <div class="occupying_left"></div>
            	
            <div class="occupying_right_1">
                <div class="column_left_2">
                    <h3 class="monitor_title">第<%=station%>考站-分号进入考场</h3>
                    <p class="monitor_f">
                    	<a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/info.jsp?station=<%=station%>','_blank');">候考区<span id="wait_num">0</span>人&nbsp;&nbsp;</a>
                    	<a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/info.jsp?station=<%=station%>','_blank');">考区<span id="exam_num">0</span>人&nbsp;&nbsp;</a>
                    	<a href="javascript:void(0);" id="handBtn">手动录入&nbsp;&nbsp;</a>
                    </p>
                    <div class="clear"></div>
                    <div class="monitor_list">
                       <ul id="wait_info_n"></ul>
                       <textarea id="wait_info_m" style="display:none;">
					    	{#foreach $T as record}
					    	<li id="{$T.record.id}">
					    		<a href="javascript:void(0);" onclick = "$.doctoreaxm.station.inspect.entryExam({$T.record.id});">
					    			<span style="font-size: 22px;">{$T.record.serialNumber}号</span>
					    			<span style="font-size: 14px;">（题:{$T.record.topic}）</span>
					    		</a>
					    	</li>
					    	{#/for}
					    </textarea>
                        <div class="clear"></div>
                    </div>
                </div>
			    
                <div class="column_right_x">
                	<h3 class="column_right_title">请下列考生进入考场考试</h3>
                	<div class="demo" style="overflow:hidden;width:100%; height:500px; margin-top:10px; margin-bottom:10px;">
                	  <ul id="exam_info_n" class="column_right_list">
                      </ul>
                    </div>
                    <textarea id="exam_info_m" style="display:none;">
			    	{#foreach $T as record}
                    	<li><a href="javascript:void(0);" onclick="$.doctoreaxm.station.inspect.cancalExam({$T.record.id});">{$T.record.serialNumber}号</a></li>
			  	 	{#/for}
			  	 	</textarea>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
        
    <div class="layui-form-item" id="hand-dialog" style="display: none; margin-top: 25px;">
	    <label class="layui-form-label" style="text-align:center;">证件编号</label>
	    <div class="layui-input-inline" style="margin-right: 20px;">
	      <input type="text" name="card-num" id="card-num" placeholder="请输入证件编号" autocomplete="off" class="layui-input">
	    </div>
	</div>
	
	<div id="doctor-dialog" style="display: none; margin-top: 25px;">
		<form class="layui-form">
		  <div class="layui-form-item">
		  	<div class="layui-inline">
			    <label class="layui-form-label">姓名</label>
			    <div class="layui-input-block">
			      <input type="text" name="name" id="name" autocomplete="off" class="layui-input" disabled="disabled">
			    </div>
		    </div>
		    <div class="layui-inline">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block">
			      <input type="text" name="sex" id="sex" autocomplete="off" class="layui-input" disabled="disabled">
			    </div>
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		  	<div class="layui-inline">
			    <label class="layui-form-label">考生序号</label>
			    <div class="layui-input-block">
			      <input type="text" name="serialNumber" id="serialNumber" autocomplete="off" class="layui-input" disabled="disabled">
			    </div>
		    </div>
		    <div class="layui-inline">
			    <label class="layui-form-label">题组号</label>
			    <div class="layui-input-block">
			      <input type="text" name="topic" id="topic" autocomplete="off" class="layui-input" disabled="disabled">
			    </div>
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">报名编号</label>
		    <div class="layui-input-block" style="margin-right: 50px;">
		      <input type="text" name="ksh" id="ksh" autocomplete="off" class="layui-input" disabled="disabled">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">证件编号</label>
		    <div class="layui-input-block"  style="margin-right: 50px;">
		      <input type="text" name="card" id="card" autocomplete="off" class="layui-input" disabled="disabled">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">报考类别</label>
		    <div class="layui-input-block"  style="margin-right: 50px;">
		      <input type="text" name="examType" id="examType" autocomplete="off" class="layui-input" disabled="disabled">
		    </div>
		  </div>
		</form>
	</div>
	
    <div class="clear"></div>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/management/station/doctoreaxm.station.inspect.js"></script>
    <script type="text/javascript">
	    $(function(){
			$.doctoreaxm.station.inspect.init(<%=station%>);
		});
    </script>
</body>
</html>