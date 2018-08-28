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

<body>
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>    
    <div class="body_right">
    	<div class="body_right_1">
            <div class="occupying_left"></div>
            
            <div class="occupying_right">
            	<div class="clear"></div>
                <div id="lianxi" class="white_content1">
                    <div class="white_content1_title">
                    	<h3>输入密码</h3>
                         <p class="white_content1_2">
                            <a href ="javascript:void(0);" onclick = "document.getElementById('lianxi').style.display='none';">X</a>
                         </p>
                         <div class="clear"></div>   	
                    </div>
                    <table border="0" align="center" cellpadding="0" cellspacing="0" class="ty_bg_c">
                      <tr>
                        <th width="30%" align="center">密　码</th>
                        <td width="70%">
                        	<input id="init-secret" type="password" class="ty_xl" />
                		</td>
                      </tr>
                      <tr>
                        <td colspan="2" align="center">
                            <div style="width:260px; margin-left:auto; margin-right:auto;">
                                <a href ="javascript:void(0)" onclick = "document.getElementById('lianxi').style.display='none';" class="reset">关　闭</a>
                                <a  href ="javascript:void(0)" onclick = "sysInitComfirm();" class="submit">确　定</a>
                            </div>
                        </td>
                      </tr>
                    </table>
                </div>
            	
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kj" align="center">
                    <tr>
                        <td class="z1">软件授权信息</td>
                    </tr>
                    <tr>
                        <td class="haha">
                        本软件由 <span class="hehe">智业软件股份有限公司</span>提供技术支持，以下是程序的详细信息。
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="50%"  class="haha">程序版本：V1.0.0 Build 20150612</td>
                                    <td width="50%"  class="haha">程序声明：<span class="hehe">请勿更改相关作者信息，如发现将追究法律责任。</span></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="50%"  class="haha">所用语言：Java+Js+Jsp</td>
                                    <td width="50%"  class="haha">数据库：Mysql5.5.24</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td class="haha">使用提示：1.出于安全考虑，请管理员务必保管好自己的密码，并且经常更换密码。
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tab">
                                    3.如果您还有其他疑问，请联系智业软件股份有限公司，将免费为您提供技术支持
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td  class="haha">特别声明：本软件受法律保护，如未经授权擅自复制、修改、转载、散播本软件（或其中任何部分），将受到法律的严厉制裁，并将在法律
                        </td>
                    </tr>
                    <tr>
                        <td class="tab">许可的最大限度内受到起诉。如果您发现以上侵权行为，请立即该诉我们，并提供相关证据，一经核实，必有重谢！
                        </td>
                    </tr>
                </table>  
                        
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="kj_1" align="center">
                    <tr>
                        <td class="z2">服务器信息</td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="50%"  class="haha">服务器名称：<font color="blue">本地局域网服务器</font></td>
                                    <td width="50%"  class="haha">服务器IP：<font color="blue">115.168.1.4</font></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="50%"  class="haha">返回服务器处理请求的端口：<font color="blue">8080</font></td>
                                    <td width="50%"  class="haha">协议的名称和版本：<font color="blue">http</font></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="50%"  class="haha">服务器操作系统：Windows 2008 sever</td>
                                    <td width="50%"  class="haha">WEB服务器的名称和版本：<font color="blue">apache-tomcat-7.0.59</font></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="50%"  class="haha">本文件的物理路径：<font color="blue">doctorexam/bpage/page/index.jsp </font> </td>				
                                    <td width="50%"  class="haha">服务器时间：2015-04-22-16-36-55</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="50%"  class="haha">脚本解释引擎： </td>
                                        <td width="50%"  class="haha">脚本超市时间：<font color="blue">10</font> 秒</td>
                                    </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="50%"  class="haha">数据库访问（ADO 数据对象）:暂无</td>
                                        <td width="50%"  class="haha">JRO.JetEngine：暂无</td>
                                    </tr>
                            </table>
                        </td>	
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="50%"  class="haha">FSO文件读写:暂无</td>
                                        <td width="50%"  class="haha">无组件上传(ADO 数据流)：暂无</td>
                                    </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="50%"  class="haha">Jmail发送邮件:不支持</td>
                                        <td width="50%"  class="haha">CDONTS发送邮件：不支持</td>
                                    </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>