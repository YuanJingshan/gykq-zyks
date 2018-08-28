<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int id = Integer.parseInt(request.getParameter("id"));
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="../css-js-lib.jsp"></jsp:include>
<script type="text/javascript" src="bpage/page/station2/js/verify-score.js"></script>

</head>

<body>
	<!-- top -->
	<jsp:include page="../top.jsp"></jsp:include>
	
    <!-- left-menu -->
    <jsp:include page="../left.jsp"></jsp:include>
    
    <div class="body_right">
    	<div class="body_right_1">
            <div class="occupying_left"></div>
            	
            <div class="occupying_right_1">
            	<h3 class="monitor_title">审核出站-评分表</h3>
            	<div class="clear"></div>
            	<input id="doctor-id" type="text" value="<%=id%>" style="display: none;">
            	<form id="station1-score-n" method="post"></form>
            	<textarea id="templete-m" style="display:none;">
            	{#foreach $T as record}
            	<div style="width:33%; float: left;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c">
	                  <tr>
	                    <th width="20%">题号</th>
	                    <th width="30%">总分值</th>
	                    <th width="20%">小题号</th>
	                    <th width="30%">得分</th>
	                  </tr>
	                  
	                  <tr>
	                  	<td rowspan="8" align="center">一</td>
	                    <td rowspan="8" align="center" id="count-1" class="score-count">{$T.record.count_1}</td>
	                    <td align="center">1</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-1" name="tipic-1-1" readonly="readonly" value="{$T.record.topic_1_1}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >2</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-2" name="tipic-1-2" readonly="readonly" value="{$T.record.topic_1_2}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">3</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-3" name="tipic-1-3" readonly="readonly" value="{$T.record.topic_1_3}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">4</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-4" name="tipic-1-4" readonly="readonly" value="{$T.record.topic_1_4}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >5</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-5" name="tipic-1-5" readonly="readonly" value="{$T.record.topic_1_5}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">6</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-6" name="tipic-1-6" readonly="readonly" value="{$T.record.topic_1_6}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">7</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-7" name="tipic-1-7" readonly="readonly" value="{$T.record.topic_1_7}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">8</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-1-8" name="tipic-1-8" readonly="readonly" value="{$T.record.topic_1_8}"/></td>
	                  </tr>
	                  
	                  <tr>
	                  	<td rowspan="8" align="center">四</td>
	                    <td rowspan="8" align="center" id="count-4" class="score-count">{$T.record.count_4}</td>
	                    <td align="center">1</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-1" name="tipic-4-1" readonly="readonly" value="{$T.record.topic_4_1}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >2</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-2" name="tipic-4-2" readonly="readonly" value="{$T.record.topic_4_2}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">3</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-3" name="tipic-4-3" readonly="readonly" value="{$T.record.topic_4_3}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">4</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-4" name="tipic-4-4" readonly="readonly" value="{$T.record.topic_4_4}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >5</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-5" name="tipic-4-5" readonly="readonly" value="{$T.record.topic_4_5}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">6</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-6" name="tipic-4-6" readonly="readonly" value="{$T.record.topic_4_6}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">7</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-7" name="tipic-4-7" readonly="readonly" value="{$T.record.topic_4_7}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">8</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-4-8" name="tipic-4-8" readonly="readonly" value="{$T.record.topic_4_8}"/></td>
	                  </tr>
	                  
	                </table>
                </div>
                <div style="width:33%; float:left; margin-left: -2%;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c2">
	                  <tr>
	                    <th width="20%">题号</th>
	                    <th width="30%">总分值</th>
	                    <th width="20%">小题号</th>
	                    <th width="30%">得分</th>
	                  </tr>
	                  
	                  <tr>
	                  	<td rowspan="8" align="center">二</td>
	                    <td rowspan="8" align="center" id="count-2" class="score-count">{$T.record.count_2}</td>
	                    <td align="center">1</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-1" name="tipic-2-1" readonly="readonly" value="{$T.record.topic_2_1}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >2</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-2" name="tipic-2-2" readonly="readonly" value="{$T.record.topic_2_2}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">3</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-3" name="tipic-2-3" readonly="readonly" value="{$T.record.topic_2_3}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">4</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-4" name="tipic-2-4" readonly="readonly" value="{$T.record.topic_2_4}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >5</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-5" name="tipic-2-5" readonly="readonly" value="{$T.record.topic_2_5}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">6</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-6" name="tipic-2-6" readonly="readonly" value="{$T.record.topic_2_6}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">7</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-7" name="tipic-2-7" readonly="readonly" value="{$T.record.topic_2_7}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">8</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-2-8" name="tipic-2-8" readonly="readonly" value="{$T.record.topic_2_8}"/></td>
	                  </tr>
	                  <tr>
	                  	<td rowspan="8" align="center">五</td>
	                    <td rowspan="8" align="center" id="count-5" class="score-count">{$T.record.count_5}</td>
	                    <td align="center">1</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-1" name="tipic-5-1" readonly="readonly" value="{$T.record.topic_5_1}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >2</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-2" name="tipic-5-2" readonly="readonly" value="{$T.record.topic_5_2}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">3</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-3" name="tipic-5-3" readonly="readonly" value="{$T.record.topic_5_3}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">4</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-4" name="tipic-5-4" readonly="readonly" value="{$T.record.topic_5_4}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >5</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-5" name="tipic-5-5" readonly="readonly" value="{$T.record.topic_5_5}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">6</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-6" name="tipic-5-6" readonly="readonly" value="{$T.record.topic_5_6}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">7</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-7" name="tipic-5-7" readonly="readonly" value="{$T.record.topic_5_7}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">8</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-5-8" name="tipic-5-8" readonly="readonly" value="{$T.record.topic_5_8}"/></td>
	                  </tr>
	                </table>
                </div>
                <div style="width:33%; float:left; margin-left: -2%;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c2">
	                  <tr>
	                    <th width="20%">题号</th>
	                    <th width="30%">总分值</th>
	                    <th width="20%">小题号</th>
	                    <th width="30%">得分</th>
	                  </tr>
	                  
	                  <tr>
	                  	<td rowspan="8" align="center">三</td>
	                    <td rowspan="8" align="center" id="count-3" class="score-count">{$T.record.count_3}</td>
	                    <td align="center">1</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-1" name="tipic-3-1" readonly="readonly" value="{$T.record.topic_3_1}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >2</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-2" name="tipic-3-2" readonly="readonly" value="{$T.record.topic_3_2}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">3</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-3" name="tipic-3-3" readonly="readonly" value="{$T.record.topic_3_3}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">4</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-4" name="tipic-3-4" readonly="readonly" value="{$T.record.topic_3_4}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >5</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-5" name="tipic-3-5" readonly="readonly" value="{$T.record.topic_3_5}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">6</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-6" name="tipic-3-6" readonly="readonly" value="{$T.record.topic_3_6}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">7</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-7" name="tipic-3-7" readonly="readonly" value="{$T.record.topic_3_7}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">8</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-3-8" name="tipic-3-8" readonly="readonly" value="{$T.record.topic_3_8}"/></td>
	                  </tr>
	                  
	                 <tr>
	                  	<td rowspan="8" align="center">六</td>
	                    <td rowspan="8" align="center" id="count-6" class="score-count">{$T.record.count_6}</td>
	                    <td align="center">1</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-1" name="tipic-6-1" readonly="readonly" value="{$T.record.topic_6_1}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >2</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-2" name="tipic-6-2" readonly="readonly" value="{$T.record.topic_6_2}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">3</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-3" name="tipic-6-3" readonly="readonly" value="{$T.record.topic_6_3}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">4</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-4" name="tipic-6-4" readonly="readonly" value="{$T.record.topic_6_4}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center" >5</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-5" name="tipic-6-5" readonly="readonly" value="{$T.record.topic_6_5}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">6</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-6" name="tipic-6-6" readonly="readonly" value="{$T.record.topic_6_6}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">7</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-7" name="tipic-6-7" readonly="readonly" value="{$T.record.topic_6_7}"/></td>
	                  </tr>
	                  <tr>
	                  	<td align="center">8</td>
	                    <td><input type="text" class="ty_k_1" id="tipic-6-8" name="tipic-6-8" readonly="readonly" value="{$T.record.topic_6_8}"/></td>
	                  </tr>
	                </table>
                </div>
                <div class="clear"></div>
                <div style="width:97.6%; margin-left: -0.3%;">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c1">
                	  <tr>
	                  	<td width="49.8%" align="right"><span style="padding-right:13%">总分</span></td>
	                  	<td width="50.2%" align="center" id="count">{$T.record.score}</td>
	                  </tr>
                	</table>
                </div>
            	<div style="width:260px; margin-left:auto; margin-right:auto;" class="ty_bg_c_10">
                    <a class="reset" href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/verify.jsp?id={$T.record.id}','_self');">取　消</a>
                    <a class="submit" href="javascript:void(0);" onclick="verify();">确　认</a>
                </div>
	            {#/for}
            	</textarea>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>