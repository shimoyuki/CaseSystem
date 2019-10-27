<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=basePath%>>
<title>案件报告</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script> 
<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
    
<meta http-equiv="Content-Type" content="application/msword">
</head>
<body>
		<div class="ajgl-nav">
			<div class="aj-banner">
				<p><strong>报告时间：</strong><span id="reportTime"></span><strong>案件编号：</strong>${caseReport.code}</p>
			</div>
			<h3>案件名称：${caseReport.name}</h3>
			<div class="jbxx">
				<table>
					<tr>
						<td colspan="3">案件卷宗号：<span>${caseReport.caseNo}</span></td>
					</tr>
					<tr>
						<td colspan="3">保管位置：<span>${caseReport.storageLoc}</span></td>
					</tr>
					<tr>
						<td>案发时间：<span>${caseReport.startTime}</span></td>
						<td>结案时间：<span>${caseReport.finishTime}</span></td>
						<td>案件状态：<span>${caseReport.caseState}</span></td>
					</tr>
					<tr>
						<td colspan="3">案件类型：<span>${caseReport.caseType}</span></td>
					</tr>
				</table>
			</div>
			<div class="aj-title">案件描述</div>
			<textarea class="ajms">${caseReport.caseDescribe}</textarea>
			<div class="aj-title">相关人员</div>
			<div class="aboutpeople">
				<div class="about-img">
					<img src="images/ms-icon-01.png" />
					<p class="ms-title"><span class="leibie">侦办人员</span><span class="shumu">（<strong>${caseReport.cpNum}</strong>）</span></p>
				</div>
				<div class="about-details">
					<div class="police-name" style="border-bottom:1px solid #00a0e9;">
						<div class="zuzhang">
							组长
						</div>
						<div class="zuyuan">
							<span>${caseReport.leaderID}</span>
						</div>
					</div>
					<div class="police-name">
						<div class="zuzhang">
							组员
						</div>
						<div class="zuyuan">
							<c:forEach  items="${caseReport.casePoliceman}" var="cp" varStatus="name">
									<span>${cp.name}</span>
		                    </c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="aboutpeople">
				<div class="about-img">
					<img src="images/ms-icon-01.png" />
					<p class="ms-title"><span class="leibie">嫌疑人</span><span class="shumu">（<strong>${caseReport.ccNum}</strong>）</span></p>
				</div>
				<div class="about-details">
					<div class="police-name">
						<div class="all-nav">
							<c:forEach  items="${caseReport.caseCriminal}" var="cc" varStatus="name">
									<span>${cc.name}<em>（${cc.sex}，${cc.nation}）</em></span>
		                    </c:forEach>
							<!-- <span>王小儿<em>（男，32，汉族）</em></span> -->
						</div>
					</div>
				</div>
			</div>
			<div class="aboutpeople">
				<div class="about-img">
					<img src="images/ms-icon-01.png" />
					<p class="ms-title"><span class="leibie">证人</span><span class="shumu">（<strong>${caseReport.cwNum}</strong>）</span></p>
				</div>
				<div class="about-details">
					<div class="police-name">
						<div class="all-nav">
							<c:forEach  items="${caseReport.caseWitness}" var="cw" varStatus="name">
									<span>${cw.name}<em>（${cw.sex}，${cw.nation}）</em></span>
		                    </c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="aboutpeople">
				<div class="about-img">
					<img src="images/ms-icon-01.png" />
					<p class="ms-title"><span class="leibie">被害人</span><span class="shumu">（<strong>${caseReport.cwNum}</strong>）</span></p>
				</div>
				<div class="about-details">
					<div class="police-name">
						<div class="all-nav">
							<c:forEach  items="${caseReport.caseVictim}" var="cv" varStatus="name">
									<span>${cv.name}<em>（${cv.sex}，${cv.nation}）</em></span>
		                    </c:forEach>
							<!-- <span>王小儿<em>（男，32，汉族）</em></span> -->
						</div>
					</div>
				</div>
			</div>
			<ul class="ajbtn-nav">
				<li><a href="" class="aj-btn">打印</a></li>
				<li><a onclick="exportPDF()" class="aj-btn">导出</a></li>
				<li><a onclick="closePage()" class="aj-btn">关闭</a></li>
			</ul>
		</div>
	</body>

<script type="text/javascript">
	function closePage(){//关闭当前页面
		window.history.back(); //页面后退
	}
	function exportPDF(){ //导出pdf
		
	}
	//得到当前日期
	formatterDate = function(date) {
		var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
		var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
		+ (date.getMonth() + 1);
		return date.getFullYear() + '-' + month + '-' + day;
	};
	 $(document).ready(function(){
			$("#reportTime").html(formatterDate(new Date())); //入区时间
	 });
</script>
</html>