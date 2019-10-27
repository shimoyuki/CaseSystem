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
<title>业务干警业务统计</title>
<link rel="stylesheet" href="css/style.css" />
<!-- <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script> -->
<script type="text/javascript" src="highcharts/js/highcharts.js"></script>
<script type="text/javascript" src="highcharts/js/dark-unica.js"></script>
</head>
<body>
	<div class="right-nr">
		<div class="fenbu">
			<table>
				<tr>
					<td>
						<div class="lsxyr">
							<!-- <h3>
								历史嫌疑人<span id="totalSuspect"></span>人
							</h3> -->
							<div id="container" style="width: 295px; height: 210px"></div>
						</div>
					</td>
					<td>
						<div class="lsxyr">
							<h3>
								案件合计<span>136</span>起
							</h3>
							<div id="container1" style="width: 295px; height: 210px"></div>
						</div>
					</td>
					<td>
						<div class="lsxyr">
							<h3>个人业务规范性统计</h3>
							<div id="container2" style="width: 295px; height: 210px"></div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="rslx">
			<div class="rslx-tj" id="container3"></div>
		</div>
	</div>

	<!-- <div id="container" style="min-width: 400px; height: 400px"></div> -->
	<script type="text/javascript">
	//历史嫌疑人柱状图
	$(function () {
		var itemCaption = new Array();
		var causeCodeNum = new Array();
		 $.ajax({
			    type: "POST",
			    url: "businessStatistics/getSuspectAndNum",
			    dataType:'json',
			    async: false,
			    success: function (data) {
			    		for(var key in data) { 
			    		    console.log("属性：" + key + ",值："+ data[key]); 
			    		    itemCaption.push(key);
			    		    causeCodeNum.push(data[key]);
			    		    //console.log("itemCaption：" + itemCaption + ",caseTypeNum："+ caseTypeNum); 
			    		}
			    }
		 });
		 //求嫌疑人的和。
		 var x=0;
		    for(var i=0;i<causeCodeNum.length;i++){
		        x +=causeCodeNum[i];
		    };
	   // $('#totalSuspect').html(x);
	    $('#container').highcharts({
	    	 title: {
	             text: '历史嫌疑人'+x+'人',
	             x: -20 //center
	         },
	    	chart: {
	            backgroundColor: '#FFFFFF',
	            type: 'line',
	            style: {
	                fontFamily: 'serif',
	                fontSize:"30px"
	            }
	        },
	        credits: {
	            enabled: false
	        },
	        xAxis: {
	        	 title: {
		                text: '嫌疑人类型'
		            },
	             categories: itemCaption
	        },
	        yAxis: {
	            title: {
	                text: '嫌疑人数量'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        series: [{
	        	name: '数量',
	            data:causeCodeNum
	        }]
	    });
	});

		//折线图
		$(function () {
			console.log("进来了么？？");
			var currentYear = new Date().getFullYear();//当前年份
			var itemCaption = new Array();
			var caseTypeNum = new Array();
			 $.ajax({
				    type: "POST",
				    url: "businessStatistics/getCaseAndNum",
				    dataType:'json',
				    async: false,
				    success: function (data) {
				    		for(var key in data) { 
				    		    console.log("属性：" + key + ",值："+ data[key]); 
				    		    itemCaption.push(key);
				    		    caseTypeNum.push(data[key]);
				    		    //console.log("itemCaption：" + itemCaption + ",caseTypeNum："+ caseTypeNum); 
				    		}
				    }
			 });
			// console.log("itemCaption：" + itemCaption + ",caseTypeNum："+ caseTypeNum); 
		    $('#container3').highcharts({
		    	 title: {
		             text: currentYear+'年度办案数量统计',
		             x: -20 //center
		         },
		    	chart: {
		            backgroundColor: '#FFFFFF',
		            type: 'line',
		            style: {
		                fontFamily: 'serif',
		                fontSize:"30px"
		            }
		        },
		        credits: {
		            enabled: false
		        },
		        xAxis: {
		        	 title: {
			                text: '案件类型'
			            },
		             categories: itemCaption
		        },
		        yAxis: {
		            title: {
		                text: '案件数量'
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        series: [{
		        	name: '数量',
		            data:caseTypeNum
		        }]
		    });
		});
	</script>
</body>
</html>