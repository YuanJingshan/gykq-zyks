<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int id = Integer.parseInt(request.getParameter("id"));
String topic = request.getParameter("topic");
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>医师资格实践技能考试计算机控制系统(贵阳考点)-登分出站</title>
<jsp:include page="../css-js-lib.jsp"></jsp:include>

<script type="text/javascript">
/**
 * 分数确认提交
 */
function station1scoreConfirm() {
	var dataStr = "&id=" + <%=id%>;
	$(".score-count").each(function(){
		dataStr = dataStr + "&" + this.id + "=" + $(this).text();
	});
	dataStr = dataStr + "&count=" + $("#count").text();
	dataStr = $("#station1-score").serialize() + dataStr;
	$.ajax({
		type: "post",
		dataType: "json",
		url: "stationScoreServlet?method=addStation1Score",
		data: dataStr,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			ajaxErrorMsg("scoreConfirm", XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data){
			if (data.result == 1) {
				$.common.layer.msg("操作成功！",  {icon: 1, time: 2000}, function() {
					openPage("/doctorexam/bpage/page/station1/station-score-1.jsp","_self");
				});
			} else {
				toastr.error("录入分数失败！");
			}
		}
	});
}
</script>

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
            	<h3 class="monitor_title">登分出站-<span style="color:#f00;">(<%=topic%>号)</span>评分表</h3>
            	<div class="clear"></div>
            	<form id="station1-score" method="post">
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
		                    <td rowspan="8" align="center" id="count-1" class="score-count">0</td>
		                    <td align="center">1</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-1" name="tipic-1-1" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >2</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-2" name="tipic-1-2" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">3</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-3" name="tipic-1-3" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">4</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-4" name="tipic-1-4" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >5</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-5" name="tipic-1-5" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">6</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-6" name="tipic-1-6" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">7</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-7" name="tipic-1-7" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">8</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-1-8" name="tipic-1-8" onblur="calcurateScore(1,this);" value="0"/></td>
		                  </tr>
		                  
		                  <tr>
		                  	<td rowspan="8" align="center">四</td>
		                    <td rowspan="8" align="center" id="count-4" class="score-count">0</td>
		                    <td align="center">1</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-1" name="tipic-4-1" onblur="calcurateScore(4,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >2</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-2" name="tipic-4-2" onblur="calcurateScore(4,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">3</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-3" name="tipic-4-3" onblur="calcurateScore(4,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">4</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-4" name="tipic-4-4" onblur="calcurateScore(4,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >5</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-5" name="tipic-4-5" onblur="calcurateScore(4,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">6</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-6" name="tipic-4-6" onblur="calcurateScore(4,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">7</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-7" name="tipic-4-7" onblur="calcurateScore(4,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">8</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-4-8" name="tipic-4-8" onblur="calcurateScore(4,this);" value="0"/></td>
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
		                    <td rowspan="8" align="center" id="count-2" class="score-count">0</td>
		                    <td align="center">1</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-1" name="tipic-2-1" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >2</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-2" name="tipic-2-2" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">3</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-3" name="tipic-2-3" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">4</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-4" name="tipic-2-4" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >5</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-5" name="tipic-2-5" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">6</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-6" name="tipic-2-6" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">7</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-7" name="tipic-2-7" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">8</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-2-8" name="tipic-2-8" onblur="calcurateScore(2,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td rowspan="8" align="center">五</td>
		                    <td rowspan="8" align="center" id="count-5" class="score-count">0</td>
		                    <td align="center">1</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-1" name="tipic-5-1" onblur="calcurateScore(5,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >2</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-2" name="tipic-5-2" onblur="calcurateScore(5,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">3</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-3" name="tipic-5-3" onblur="calcurateScore(5,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">4</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-4" name="tipic-5-4" onblur="calcurateScore(5,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >5</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-5" name="tipic-5-5" onblur="calcurateScore(5,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">6</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-6" name="tipic-5-6" onblur="calcurateScore(5,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">7</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-7" name="tipic-5-7" onblur="calcurateScore(5,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">8</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-5-8" name="tipic-5-8" onblur="calcurateScore(5,this);" value="0"/></td>
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
		                    <td rowspan="8" align="center" id="count-3" class="score-count">0</td>
		                    <td align="center">1</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-1" name="tipic-3-1" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >2</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-2" name="tipic-3-2" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">3</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-3" name="tipic-3-3" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">4</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-4" name="tipic-3-4" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >5</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-5" name="tipic-3-5" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">6</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-6" name="tipic-3-6" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">7</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-7" name="tipic-3-7" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">8</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-3-8" name="tipic-3-8" onblur="calcurateScore(3,this);" value="0"/></td>
		                  </tr>
		                  
		                 <tr>
		                  	<td rowspan="8" align="center">六</td>
		                    <td rowspan="8" align="center" id="count-6" class="score-count">0</td>
		                    <td align="center">1</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-1" name="tipic-6-1" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >2</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-2" name="tipic-6-2" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">3</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-3" name="tipic-6-3" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">4</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-4" name="tipic-6-4" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center" >5</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-5" name="tipic-6-5" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">6</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-6" name="tipic-6-6" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">7</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-7" name="tipic-6-7" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                  <tr>
		                  	<td align="center">8</td>
		                    <td><input type="text" class="ty_k_1" id="tipic-6-8" name="tipic-6-8" onblur="calcurateScore(6,this);" value="0"/></td>
		                  </tr>
		                </table>
	                </div>
	                <div class="clear"></div>
	                <div style="width:97.6%; margin-left: -0.3%;">
	                	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ty_bg_c1">
	                	  <tr>
		                  	<td width="49.8%" align="right"><span style="padding-right:13%">总分</span></td>
		                  	<td width="50.2%" align="center" id="count">0</td>
		                  </tr>
	                	</table>
	                </div>
	            	<div style="width:260px; margin-left:auto; margin-right:auto;" class="ty_bg_c_10">
	                    <a class="reset" href="javascript:void(0);" onclick="resetScore('station1-score');">重　置</a>
	                    <a class="submit" href="javascript:void(0);" onclick="station1scoreConfirm();">提　交</a>
	                </div>
                </form>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>