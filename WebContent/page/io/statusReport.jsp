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
<meta charset="utf-8" />
<title>值班室状态报告</title>
<link rel="stylesheet" href="css/style.css" />
<!-- <script type="text/javascript" src="js/jquery-1.4.min.js"></script> -->
</head>
<body>
	<div class="right-nr">
		<div class="zzzt">
			<table>
				<tr>
					<td>
						<div class="zzztnr">
							<p id="NECN"></p>
							<p>今日入区嫌疑人</p>
						</div>
					</td>
					<td>
						<div class="zzztnr">
							<p id="NLCN"></p>
							<p>今日出区嫌疑人</p>
						</div>
					</td>
					<td>
						<div class="zzztnr">
							<p id="district"></p>
							<p>在区嫌疑人</p>
						</div>
					</td>
					<td>
						<div class="zzztnr">
							<p id="ECT"></p>
							<p>历史入区嫌疑人</p>
						</div>
					</td>
					<td>
						<div class="zzztnr">
							<p id="ENCT"></p>
							<p>历史入区非嫌疑人</p>
						</div>
					</td>
					<td>
						<div class="zzztnr">
							<p id="caseTotal"></p>
							<p>历史案件</p>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="bbpmt">
			<h3>办案区平面图</h3>
			<table>
				<tr>
					<th>办案区门</th>
					<td>值班室</td>
					<td id="safetyCheck">人身安全检查</td>
					<td id="inforCollection">信息采集室</td>
					<td class="ts"><img src="images/shuo.jpg" alt="">侯问室1<span><strong  id="interrogate1">6</strong>人</span></td>
					<td class="ts"><img src="images/shuo.jpg" alt="">侯问室2<span><strong  id="interrogate2">6</strong>人</span></td>
					<td id="inquiry">询问室</td>
					<td id="interrogate">讯问室</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
		$(document).ready(function(){
			 $.ajax({
				    type: "POST",
				    url: "statusReport/showStatusResport",
				    dataType: "json",
				    success: function (msg) {
					     $("#NECN").html(msg.NECN);
					     $("#NLCN").html(msg.NLCN);
					     $("#ECT").html(msg.ECT);
					     $("#ENCT").html(msg.ENCT);
					     $("#caseTotal").html(msg.caseTotal);
					     $("#district").html(msg.district);
					   if(msg.safetyCheck!='null'&& msg.safetyCheck && typeof (msg.safetyCheck) != "undefined"){
					     	$("#safetyCheck").append("<br><br><span>"+msg.safetyCheck.name+"</span><br><br><span>"+msg.safetyCheck.sex+"</span><br><br><span>"+msg.safetyCheck.nation+"</span>");
					   }
					    if(msg.inforCollection!='null'&& msg.inforCollection && typeof (msg.inforCollection) != "undefined"){
					    	 $("#inforCollection").append("<br><br><span>"+msg.inforCollection.name+"</span><br><br><span>"+msg.inforCollection.sex+"</span><br><br><span>"+msg.inforCollection.nation+"</span>");
					    }
					    if(msg.inquiry!='null'&& msg.inquiry && typeof (msg.inquiry) != "undefined"){
					     	$("#inquiry").append("<br><br><span>"+msg.inquiry.name+"</span><br><br><span>"+msg.inquiry.sex+"</span><br><br><span>"+msg.inquiry.nation+"</span>");
					   }
					    if(msg.interrogate!='null'&& msg.interrogate && typeof (msg.interrogate) != "undefined"){
					    	 $("#interrogate").append("<br><br><span>"+msg.interrogate.name+"</span><br><br><span>"+msg.interrogate.sex+"</span><br><br><span>"+msg.interrogate.nation+"</span>");
					   }	
					    if(msg.interrogate1!='null'&& msg.interrogate1 && typeof (msg.interrogate1) != "undefined"){
					    	  $("#interrogate1").html(msg.interrogate1);
					    }
					    if(msg.interrogate2!='null'&& msg.interrogate2 && typeof (msg.interrogate2) != "undefined"){
					    	 $("#interrogate2").html(msg.interrogate2);
					    }
					   	
				    },
				    error: function (error) {
				      easyuiAlert(error);
				    }
				  });
		}); 



</script>
</html>