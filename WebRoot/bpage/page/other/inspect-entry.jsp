<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-入口检录</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/other/js/entry-inspect.js"></script>

</head>

<body>
	<p>
		<object classid="clsid:46E4B248-8A41-45C5-B896-738ED44C1587" id="SynCardOcx1" codeBase="SynCardOcx.CAB#version=1,0,0,1" width="0" height="0" ></object>
	</p>
	
	<!-- top -->
	<jsp:include page="../top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../left.jsp"></jsp:include>
    
    <div class="body_right">
    	<div class="body_right_1">
            <div class="occupying_left"></div>
            <div class="occupying_right_1">
                <div class="column_left_2">
                	<h3 class="monitor_title">入口检录</h3>
                	<p class="monitor_f">
                		<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/inspect-info.jsp','_blank');">检录<span id="inspect-num">0</span>人&nbsp;&nbsp;</a>
                		<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/inspect-info.jsp','_blank');">等候<span id="not-entry-num">0</span>人&nbsp;&nbsp;</a>
                		<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/inspect-info.jsp','_blank');">进站<span id="entried-num">0</span>人&nbsp;&nbsp;</a>
                		<a href="javascript:void(0);" onclick = "document.getElementById('lianxi').style.display='block';">手动录入&nbsp;&nbsp;</a>
                	</p>
                    <div class="clear"></div>
                    <div class="monitor_list">
                        <ul id="inspect-info-n"></ul>
                        <textarea id="inspect-info-m" style="display:none;">
					    	{#foreach $T as record}
					    	<li id="{$T.record.id}">
					    		<a class="inspect" href="javascript:void(0);" onclick = "entryStation1({$T.record.id})">
					    			<span style="font-size: 22px;">{$T.record.serialNumber}/{$T.record.name}</span> 
					    			<span style="font-size: 14px;">题:{$T.record.topic1}/{$T.record.topic2}/{$T.record.topic3}/{$T.record.topic4}/{$T.record.topic5}/{$T.record.topic6}</span>
					    		</a>
					    	</li>
					    	{#/for}
					    </textarea>
					    
						<div class="clear"></div>
                        <div id="lianxi" class="white_content1">
                            <div class="white_content1_title">
                            	<h3>输入证件编号</h3>
                                 <p class="white_content1_2">
                                    <a href ="javascript:void(0);" onclick = "document.getElementById('lianxi').style.display='none';">X</a>
                                 </p>
                                 <div class="clear"></div>   	
                            </div>
                            <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                              <tr>
                                <th width="30%" align="center">证件编号</th>
                                <td width="70%">
                                	<input id="card-num" class="ty_xl" />
                        		</td>
                              </tr>
                              <tr>
                                <td colspan="2" align="center">
                                    <div style="width:260px; margin-left:auto; margin-right:auto;">
                                        <a href ="javascript:void(0)" onclick = "document.getElementById('lianxi').style.display='none';" class="reset">关　闭</a>
                                        <a  href ="javascript:void(0)" onclick = "queryDoctorInfoByHand();" class="submit">确　定</a>
                                    </div>
                                </td>
                              </tr>
                            </table>
                        </div>
                        
                        <div class="clear"></div>
                        <div id="doctor-info" class="white_content1">
                            <div class="white_content1_title">
                            	 <h3>考生信息</h3>
                                 <p class="white_content1_2">
                                    <a href ="javascript:void(0)" onclick = "document.getElementById('doctor-info').style.display='none';">X</a>
                                 </p>
                                 <div class="clear"></div>   	
                            </div>
                            <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                              <tbody id="doctor-tmplete-n"></tbody>
                            </table>
                            <textarea id="doctor-tmplete-m" style="display:none;">
						    	{#foreach $T as record}
						    	<tr>
				                	<th width="30%">姓名：</th>
				                    <td width="20%">{$T.record.name}</td>
				                    <th width="30%">性别：</th>
				                    <td width="20%">{$T.record.sex}</td>
				                </tr>
				                <tr>
				                    <th width="30%">报名编号：</th>
				                    <td colspan="3" width="70%">{$T.record.ksh}</td>
				                </tr>
				                <tr>
				                    <th width="30%">证件编号：</th>
				                    <td colspan="3" width="70%">{$T.record.card}</td>
				                </tr>
				                {#if $T.record.examType == 120}
				                <tr>
				                    <th width="30%">报考类别：</th>
				                    <td colspan="3" width="70%">执业医师</td>
				                </tr>
				                {#elseif $T.record.examType == 220}
				                <tr>
				                    <th width="30%">报考类别：</th>
				                    <td colspan="3" width="70%">执业助理医师</td>
				                </tr>
				                {#/if}
				                <tr>
	                                <td colspan="4" align="center">
	                                    <div style="width:260px; margin-left:auto; margin-right:auto;">
	                                        <a href ="javascript:void(0);" onclick = "document.getElementById('doctor-info').style.display='none';" class="reset">关　闭</a>
	                                        <a  href ="javascript:void(0);" onclick = "inspectConfirm({$T.record.doctorId});" class="submit">确　定</a>
	                                    </div>
	                                </td>
                              	</tr>
						  	 	{#/for}
						    </textarea>
                       </div>
                    </div>
                </div>
                
                <div class="column_right_x">
                	<h3 class="column_right_title">请下列考生进入考站</h3>
                	<div class="demo" style="overflow:hidden;width:100%; height:500px; margin-top:10px; margin-bottom:10px;">
                	  <ul id="tmplete-n" class="column_right_list">
                      </ul>
                    </div> 
                    <textarea id="tmplete-m" style="display:none;">
			    	{#foreach $T as record}
                    <li><a href="javascript:void(0);" onclick="cancalEntryingStation1Doctor({$T.record.id});">{$T.record.serialNumber}号/{$T.record.name}</a></li>
			  	 	{#/for}
			    </textarea>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    
    <div class="clear"></div>
</body>
</html>