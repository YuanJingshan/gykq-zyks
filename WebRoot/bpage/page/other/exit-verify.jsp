<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-出口审核</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/other/js/exit-verify.js"></script>

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
            	<div class="export-title">
				  <h3 class="monitor_title">出口审核</h3>
                  <p class="monitor_f">
                  	<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/exit-info.jsp','_blank');">已审核<span id="exit-verify-num">0</span>人&nbsp;&nbsp;</a>
                  	<a href="javascript:void(0);" onclick="document.getElementById('lianxi').style.display='block';">手动输入&nbsp;&nbsp;</a>
                  </p>
                  <div class="clear"></div>
                </div>
                
                <div class="clear"></div>
                <div id="lianxi" class="white_content1">
                    <div class="white_content1_title">
                    	<h3>输入证件编号</h3>
                         <p class="white_content1_2">
                            <a href ="javascript:void(0)" onclick = "document.getElementById('lianxi').style.display='none';">X</a>
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
                                <a  href ="javascript:void(0)" onclick = "queryExitVerifyDoctorInfoByHand();" class="submit">确　定</a>
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
		                <th width="30%">序号：</th>
		                <td colspan="3" width="70%">{$T.record.topic}</td>
		            </tr>
		            <tr>
		            	<td colspan="4" align="center">
		                	<div style="width:260px; margin-left:auto; margin-right:auto;">
		                    	<a href ="javascript:void(0)" onclick = "document.getElementById('doctor-info').style.display='none';" class="reset">关　闭</a>
		                        <a  href ="javascript:void(0)" onclick = "exitVerifyInspectConfirm({$T.record.doctorId});" class="submit">确　定</a>
		                    </div>
		                </td>
		            </tr>
			 		{#/for}
				  	</textarea>
               </div>
                
               <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                 <tbody>
                  <tr>
                    <th width="10%">考生姓名：</th>
                    <td class="ksxi"><span id="name"></span></td>
                  </tr>
                  <tr>
                    <th width="10%">报名编号：</th>
                    <td class="ksxi"><span id="ksh"></span></td>
                  </tr>
                  <tr>
                    <th width="10%">证件编号：</th>
                    <td class="ksxi"><span id="card"></span></td>
                  </tr>
                  <tr>
	                <th width="10%">序号：</th>
	                <td class="ksxi"><span id="serialNumber"></span></td>
	              </tr>
                  <tr>
	                <th width="10%">第一站：</th>
	                <td class="ksxi"><span class="ksxi_1" id="station1_r"></span></td>
	              </tr>
	              <tr>
	                <th width="10%">第二站：</th>
	                <td class="ksxi"><span class="ksxi_1" id="station2_r"></span></td>
	              </tr>
	              <tr>
	                <th width="10%">第三站：</th>
	                <td class="ksxi"><span class="ksxi_1" id="station3_r"></span></td>
	              </tr>
	              <tr>
	                <th width="10%">第四站：</th>
	                <td class="ksxi"><span class="ksxi_1" id="station4_r"></span></td>
	              </tr>
	              <tr>
	                <th width="10%">第五站：</th>
	                <td class="ksxi"><span class="ksxi_1" id="station5_r"></span></td>
	              </tr>
	              <tr>
	                <th width="10%">第六站：</th>
	                <td class="ksxi"><span class="ksxi_1" id="station6_r"></span></td>
	              </tr>
	              <tr>
	                <th width="10%">考试结果：</th>
	                <td class="ksxi"><span class="ksxi_1" id="exam_result"></span></td>
	              </tr>	
                 </tbody>
               </table>  
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>