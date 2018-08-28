<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="body_left">
    <div id="menu">
    	<input id="menu-id" style="display: none;" value="<%=request.getParameter("menuId")%>">
    	<div class="tit" title="首页">
            <a href="bpage/page/index.jsp" title="首页">首页</a>
        </div>
        
        <div class="tit" id="menu1" title="管理员信息">
            <a href="#nojs" title="管理员信息" target="" class="on" id="menu1_a" tabindex="1">系统管理</a>
        </div>
        <div class="list" id="menu1_child" title="管理员信息功能区">
            <ul>
               	<c:choose>
               		<c:when test="${sessionScope.user.authority == 1}">
               			<li id="m1_1">
							 <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/user/user-list.jsp?menuId=menu1','_self');">管理员信息列表</a>
		                </li>
		                <li id="m1_2">
							<a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/user/user-add.jsp?menuId=menu1','_self');">添加管理员</a>
		                </li>
		                <li id="m1_3">
		                    <a href="javascript:void(0);" onclick="openPage('${pageContext.request.contextPath}/view/management/params/params.jsp?menuId=menu1','_self');">系统配置</a>
		                </li>
               		</c:when>
               		<c:when test="${sessionScope.user.authority == 10}">
               			<li id="m1_1">
		                    <a href="javascript:void(0);" onclick="sysInit();">系统初始化</a>
		                </li>
		                <li id="m1_2">
		                	<a href="javascript:void(0);" onclick="openPage('${pageContext.request.contextPath}/view/management/params/params.jsp?menuId=menu1','_self');">系统配置</a>
		                </li>
               		</c:when>
               		<c:otherwise>
               			<li id="m1_1">
               				<a href="userServlet?method=modifyJmp&userId=${sessionScope.user.id}">修改信息</a>
               			</li>
               		</c:otherwise>
               	</c:choose>
            </ul>
        </div> 
        
        <c:choose>
        	<c:when test="${sessionScope.user.authority == 2}">
        		<div class="tit" id="menu2" title="考生入口检录">
		            <a href="#nojs" title="考生入口检录" target="" class="on" id="menu2_a" tabindex="2">考生入口检录</a>
		        </div>
		        <div class="list" id="menu2_child" title="考生入口检录功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/inspect-entry.jsp?menuId=menu2','_self');">入口检录</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 3}">
        		<div class="tit" id="menu2" title="第一考站">
		           <a href="#nojs" title="第一考站" target="" class="on" id="menu2_a" tabindex="2">第一考站</a>
		       </div>
		       <div class="list" id="menu2_child" title="第一考站功能区">
		           <ul>
		               <li id="m2_1">
		                   <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station1/station-entry-1.jsp?menuId=menu2','_self');">分号进入考场</a>
		               </li>
		           </ul>
		       </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 4}">
        		<div class="tit" id="menu2" title="第一考站">
		           <a href="#nojs" title="第一考站" target="" class="on" id="menu2_a" tabindex="2">第一考站</a>
		       </div>
		       <div class="list" id="menu2_child" title="第一考站功能区">
		           <ul>
		               <li id="m2_1">
		                   <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station1/station-score-1.jsp?menuId=menu2','_self');">登分</a>
		               </li>
		           </ul>
		       </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 17}">
        		<div class="tit" id="menu2" title="第一考站">
		           <a href="#nojs" title="第一考站" target="" class="on" id="menu2_a" tabindex="2">第一考站</a>
		       </div>
		       <div class="list" id="menu2_child" title="第一考站功能区">
		           <ul>
		               <li id="m2_1">
		                   <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station1/verify.jsp?menuId=menu2','_self');">审核</a>
		               </li>
		           </ul>
		       </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 5}">
        		<div class="tit" id="menu2" title="第二考站">
		            <a href="#nojs" title="第二考站" target="" class="on" id="menu2_a" tabindex="2">第二考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第二考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/station-entry-2.jsp?menuId=menu2','_self');">分号进入考场</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 6}">
        		<div class="tit" id="menu2" title="第二考站">
		            <a href="#nojs" title="第二考站" target="" class="on" id="menu4_a" tabindex="2">第二考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第二考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/station-score-2.jsp?menuId=menu2','_self');">登分</a>
		                </li>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 18}">
        		<div class="tit" id="menu2" title="第二考站">
		            <a href="#nojs" title="第二考站" target="" class="on" id="menu4_a" tabindex="2">第二考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第二考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/verify.jsp?menuId=menu2','_self');">审核</a>
		                </li>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 7}">
        		<div class="tit" id="menu2" title="第三考站">
		            <a href="#nojs" title="第三考站" target="" class="on" id="menu2_a" tabindex="2">第三考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第三考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/station-entry-3.jsp?menuId=menu2','_self');">分号进入考场</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 8}">
        		<div class="tit" id="menu2" title="第三考站">
		            <a href="#nojs" title="第三考站" target="" class="on" id="menu2_a" tabindex="2">第三考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第三考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/station-score-3.jsp?menuId=menu2','_self');">登分</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 19}">
        		<div class="tit" id="menu2" title="第三考站">
		            <a href="#nojs" title="第三考站" target="" class="on" id="menu2_a" tabindex="2">第三考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第三考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/verify.jsp?menuId=menu2','_self');">审核</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 11}">
        		<div class="tit" id="menu2" title="第四考站">
		            <a href="#nojs" title="第三考站" target="" class="on" id="menu2_a" tabindex="2">第四考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第四考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/inspect.jsp?menuId=menu2&station=4','_self');">分号进入考场</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 12}">
        		<div class="tit" id="menu2" title="第四考站">
		            <a href="#nojs" title="第四考站" target="" class="on" id="menu2_a" tabindex="2">第四考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第四考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/points-entry.jsp?menuId=menu2&station=4','_self');">登分</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 20}">
        		<div class="tit" id="menu2" title="第四考站">
		            <a href="#nojs" title="第四考站" target="" class="on" id="menu2_a" tabindex="2">第四考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第四考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/verify.jsp?menuId=menu2&station=4','_self');">审核</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 13}">
        		<div class="tit" id="menu2" title="第五考站">
		            <a href="#nojs" title="第五考站" target="" class="on" id="menu2_a" tabindex="2">第五考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第五考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/inspect.jsp?menuId=menu2&station=5','_self');">分号进入考场</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 14}">
        		<div class="tit" id="menu2" title="第五考站">
		            <a href="#nojs" title="第五考站" target="" class="on" id="menu2_a" tabindex="2">第五考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第五考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/points-entry.jsp?menuId=menu2&station=5','_self');">登分</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 21}">
        		<div class="tit" id="menu2" title="第五考站">
		            <a href="#nojs" title="第五考站" target="" class="on" id="menu2_a" tabindex="2">第五考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第五考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/verify.jsp?menuId=menu2&station=5','_self');">审核</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 15}">
        		<div class="tit" id="menu2" title="第六考站">
		            <a href="#nojs" title="第六考站" target="" class="on" id="menu2_a" tabindex="2">第六考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第六考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/inspect.jsp?menuId=menu2&station=6','_self');">分号进入考场</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 16}">
        		<div class="tit" id="menu2" title="第六考站">
		            <a href="#nojs" title="第六考站" target="" class="on" id="menu2_a" tabindex="2">第六考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第六考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/points-entry.jsp?menuId=menu2&station=6','_self');">登分</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 22}">
        		<div class="tit" id="menu2" title="第六考站">
		            <a href="#nojs" title="第六考站" target="" class="on" id="menu2_a" tabindex="2">第六考站</a>
		        </div>
		        <div class="list" id="menu2_child" title="第六考站功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/verify.jsp?menuId=menu2&station=6','_self');">审核</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 9}">
        		<div class="tit" id="menu2" title="出口复核">
		            <a href="#nojs" title="出口复核" target="" class="on" id="menu2_a" tabindex="2">出口复核</a>
		        </div>
		        <div class="list" id="menu2_child" title="出口复核功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/exit-verify.jsp?menuId=menu2','_self');">出口复核</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 1}">
        		 <div class="tit" id="menu2" title="考场监控检录">
		            <a href="#nojs" title="考场监控检录" target="" class="on" id="menu2_a" tabindex="2">考场监控</a>
		        </div>
		        <div class="list" id="menu2_child" title="考场监控功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/exam-monitor.jsp?menuId=menu2','_self');">考场监控</a>
		                </li>
		            </ul>
		        </div>
		        
		        <div class="tit" id="menu3" title="第一考站">
		            <a href="#nojs" title="第一考站" target="" class="on" id="menu3_a" tabindex="3">第一考站</a>
		        </div>
		        <div class="list" id="menu3_child" title="第一考站功能区">
		            <ul>
		            	<li id="m3_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station1/station-monitor-1.jsp?menuId=menu3','_self');">考站监控</a>
		                </li>
		                <li id="m3_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station1/score-list-1.jsp?menuId=menu3','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
		        
		        <div class="tit" id="menu4" title="第二考站">
		            <a href="#nojs" title="第二考站" target="" class="on" id="menu4_a" tabindex="4">第二考站</a>
		        </div>
		        <div class="list" id="menu4_child" title="第二考站功能区">
		            <ul>
		            	<li id="m4_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/station-monitor-2.jsp?menuId=menu4','_self');">考站监控</a>
		                </li>
		                <li id="m4_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/score-list-2.jsp?menuId=menu4','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
		        
		        <div class="tit" id="menu5" title="第三考站">
		            <a href="#nojs" title="第三考站" target="" class="on" id="menu5_a" tabindex="5">第三考站</a>
		        </div>
		        <div class="list" id="menu5_child" title="第三考站功能区">
		            <ul>
		            	<li id="m5_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/station-monitor-3.jsp?menuId=menu5','_self');">考站监控</a>
		                </li>
		                <li id="m5_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/score-list-3.jsp?menuId=menu5','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
		        <div class="tit" id="menu7" title="第四考站">
		            <a href="#nojs" title="第四考站" target="" class="on" id="menu7_a" tabindex="7">第四考站</a>
		        </div>
		        <div class="list" id="menu7_child" title="第四考站功能区">
		            <ul>
		            	<li id="m7_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/monitor.jsp?menuId=menu7&station=4','_self');">考站监控</a>
		                </li>
		                <li id="m7_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/score-list.jsp?menuId=menu7&station=4','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
		        <div class="tit" id="menu8" title="第五考站">
		            <a href="#nojs" title="第五考站" target="" class="on" id="menu8_a" tabindex="8">第五考站</a>
		        </div>
		        <div class="list" id="menu8_child" title="第五考站功能区">
		            <ul>
		            	<li id="m8_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/monitor.jsp?menuId=menu8&station=5','_self');">考站监控</a>
		                </li>
		                <li id="m8_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/score-list.jsp?menuId=menu8&station=5','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
		        <div class="tit" id="menu9" title="第六考站">
		            <a href="#nojs" title="第六考站" target="" class="on" id="menu9_a" tabindex="9">第六考站</a>
		        </div>
		        <div class="list" id="menu9_child" title="第六考站功能区">
		            <ul>
		            	<li id="m9_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/monitor.jsp?menuId=menu8&station=6','_self');">考站监控</a>
		                </li>
		                <li id="m9_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/view/management/station/score-list.jsp?menuId=menu8&station=6','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
        		
        		<div class="tit" id="menu6" title="查询统计">
		            <a href="#nojs" title="查询统计" target="" class="on" id="menu_a" tabindex="6">查询统计</a>
		        </div>
		        <div class="list" id="menu6_child" title="查询统计功能区">
		            <ul>
		                <li id="m6_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/doctor/doctor-list.jsp?menuId=menu6','_self');">考生信息</a>
		                </li>
		                <li id="m6_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/score-count.jsp?menuId=menu6','_self');">总成绩统计</a>
		                </li>
		                <li id="m6_3">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/doctor/doctor-not-exam.jsp?menuId=menu6','_self');">未考考生统计</a>
		                </li>
		                <li id="m6_4">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/doctor/doctor-error-exam.jsp?menuId=menu6','_self');">异常考生统计</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        	<c:when test="${sessionScope.user.authority == 10}">
        		 <div class="tit" id="menu2" title="考场监控检录">
		            <a href="#nojs" title="考场监控检录" target="" class="on" id="menu2_a" tabindex="2">考场监控</a>
		        </div>
		        <div class="list" id="menu2_child" title="考场监控功能区">
		            <ul>
		                <li id="m2_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/exam-monitor.jsp?menuId=menu2','_self');">考场监控</a>
		                </li>
		            </ul>
		        </div>
		        
		        <div class="tit" id="menu3" title="第一考站">
		            <a href="#nojs" title="第一考站" target="" class="on" id="menu3_a" tabindex="3">第一考站</a>
		        </div>
		        <div class="list" id="menu3_child" title="第一考站功能区">
		            <ul>
		            	<li id="m3_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station1/station-monitor-1.jsp?menuId=menu3','_self');">考站监控</a>
		                </li>
		                <li id="m3_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station1/score-list-1.jsp?menuId=menu3','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
		        
		        <div class="tit" id="menu4" title="第二考站">
		            <a href="#nojs" title="第二考站" target="" class="on" id="menu4_a" tabindex="4">第二考站</a>
		        </div>
		        <div class="list" id="menu4_child" title="第二考站功能区">
		            <ul>
		            	<li id="m4_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/station-monitor-2.jsp?menuId=menu4','_self');">考站监控</a>
		                </li>
		                <li id="m4_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station2/score-list-2.jsp?menuId=menu4','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
		        
		        <div class="tit" id="menu5" title="第三考站">
		            <a href="#nojs" title="第三考站" target="" class="on" id="menu5_a" tabindex="5">第三考站</a>
		        </div>
		        <div class="list" id="menu5_child" title="第三考站功能区">
		            <ul>
		            	<li id="m5_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/station-monitor-3.jsp?menuId=menu5','_self');">考站监控</a>
		                </li>
		                <li id="m5_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/station3/score-list-3.jsp?menuId=menu5','_self');">考站成绩</a>
		                </li>
		            </ul>
		        </div>
        		
        		<div class="tit" id="menu6" title="查询统计">
		            <a href="#nojs" title="查询统计" target="" class="on" id="menu_a" tabindex="6">查询统计</a>
		        </div>
		        <div class="list" id="menu6_child" title="查询统计功能区">
		            <ul>
		                <li id="m6_1">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/doctor/doctor-list.jsp?menuId=menu6','_self');">考生信息</a>
		                </li>
		                <li id="m6_2">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/other/score-count.jsp?menuId=menu6','_self');">总成绩统计</a>
		                </li>
		                <li id="m6_3">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/doctor/doctor-not-exam.jsp?menuId=menu6','_self');">未考考生统计</a>
		                </li>
		                <li id="m6_4">
		                    <a href="javascript:void(0);" onclick="openPage('/doctorexam/bpage/page/doctor/doctor-error-exam.jsp?menuId=menu6','_self');">异常考生统计</a>
		                </li>
		            </ul>
		        </div>
        	</c:when>
        	
        </c:choose>
    </div>
</div>