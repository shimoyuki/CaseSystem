<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
<base href=<%=basePath%>>
<meta charset="utf-8" />
<title>智慧警务</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>  
<script type="text/javascript">
	function initTree(t) {
		var tree = document.getElementById(t);//生成树
		tree.style.display = "none";//设置样式为隐藏形式，不显示
		var lis = tree.getElementsByTagName("li");
		for (var i = 0; i < lis.length; i++) { //取出主要的导航栏
			lis[i].id = "li" + i;
			var uls = lis[i].getElementsByTagName("ul"); //子导航栏
			if (uls.length != 0) {
				uls[0].id = "ul" + i;
				uls[0].style.display = "none";
				var as = lis[i].getElementsByTagName("a"); //子导航栏的内容
				as[0].id = "a" + i;
				as[0].className = "folder";
				//as[0].href = "#this";
				as[0].tget = uls[0];
				as[0].onclick = function() {
					openTag(this, this.tget);
				}
			}
		}
		tree.style.display = "block";
	}
	function openTag(a, t) {
		if (t.style.display == "block") { //点击一些展开，再点击一下折叠
			t.style.display = "none";
			a.className = "folder";
		} else {
			t.style.display = "block";
			a.className = "";
		}
	}
	window.onload = function() {
		initTree("globalNav");
	}
</script>
</head>
<body>
	<div class="content">
		<div class="bt-ban">
			<div class="nr-jl">
				<div class="biaoz">
					<img src="images/nrtitlr.png" hei>
				</div>
			</div>
		</div>
		<div class="tips-t">
			<p>
				<img src="images/xiaoxi.png">欢迎您，${policeMan.name}警官！当前时间为：<span id="clock"></span>
			</p>

		</div>
		<div class="nr-warp">
			<div class="left-nr">
				<div class="touxiang-top">
					<div class="touxiang">
						<img src="${policeMan.picture}"  width="100%"  height="100%" >
						<!-- <div class="zhuantai">
							<p>
								<a href="">在线<img src="images/xlt.png"></a>
							</p>
						</div> -->
					</div>
					<div class="xinxi">
						<p>${policeMan.name}</p>
						<p>警编:${policeMan.code}</p>
					</div>
				</div>
				<div class="left-nav">

					<ul id="globalNav">
						<li class="nav-big">
							<h3>
								<a href="javascript:;"><img class="nav-pic"
									src="images/shezhi.png">系统设置 <img class="nav-jt"
									src="images/jiantou.png" alt=""></a>
							</h3>
							<ul class="nav-small">
								<li><a href="javascript:void(page/personalSetting/personalInfo.jsp);"
									onclick="addPage(this);return false;" id="101001">个人中心</a></li>
								<li><a href="javascript:void(page/personalSetting/accountSetting.jsp);"
									onclick="addPage(this);return false;" id="101002">账号设置</a></li>
								<li><a href="javascript:void(page/personalSetting/personalLog.jsp);"
									onclick="addPage(this);return false;" id="101003">个人日志</a></li>
							</ul>
						</li>

						<li class="nav-big">
							<h3>
								<a href="javascript:;"><img class="nav-pic"
									src="images/yewu.png">业务管理<img class="nav-jt"
									src="images/jiantou.png" alt=""></a>
							</h3>
							<ul class="nav-small" id="lanrenzhijia">
								<li><a href="javascript:void(page/io/caseManagement.jsp);"
									onclick="addPage(this);return false;" id="101004">案件管理</a></li>
								<li><a
									href="javascript:void(page/io/archivesManagement.jsp);"
									onclick="addPage(this);return false;" id="101005">档案管理</a></li>
								<li><a
									href="javascript:void(page/io/businessStatistics.jsp);"
									onclick="addPage(this);return false;" id="101006">业务统计</a></li>
								<li><a href="javascript:void(page/io/entryNew.jsp);"
									onclick="addPage(this);return false;" id="101007">入区登记</a></li>
								<li><a href="javascript:void(page/io/leave.jsp);"
									onclick="addPage(this);return false;" id="101010">出区登记</a></li>
								<li><a href="javascript:void(page/io/statusReport.jsp);"
									onclick="addPage(this);return false;" id="101008">状态报告</a></li>
								<li><a href="javascript:void(page/camera.jsp);"
									onclick="addPage(this);return false;" id="101009">信息统计</a></li>
							</ul>
						</li>
					</ul>
				</div>

				<div class="banquan">
					<dl>
						<dd>
							<img src="images/qylogo.png" alt="">
						</dd>
						<dt>
							<p>
								山西瑞泽恒达<br>© copyright 2017
							</p>
						</dt>
					</dl>
				</div>
			</div>
			<div class="right-nr" id="myManu"></div>
		</div>
	</div>
</body>
</html>


<script type="text/javascript">
	//权限设置
	var menuSet = "<%=session.getAttribute("disabledMenu")%>";//不可用的权限
	var menuArray = menuSet.substring(1, menuSet.length-1).split(",");//获取权限数组
	for (var i = 0; i <  menuArray.length; i++) {
		if(document.getElementById(menuArray[i].trim())){
			document.getElementById(menuArray[i].trim()).parentNode.style.display = "none";
			
		}
	}
	$(document).ready(function() {
		//这是给div的一个初始页面
		$("#myManu").load('page/io/entryNew.jsp');
	});
	//得到当前日期
	function sup(n){ return (n<10) ? '0'+n : n; }
	formatterDate = function(date) {
		var myDate=new Date();
		var date = myDate.getFullYear() + "-" + sup(myDate.getMonth()) + "-" + sup(myDate.getDate());
		var time = sup(myDate.getHours()) + ":" + sup(myDate.getMinutes()) + ":" + sup(myDate.getSeconds());
		return (date + " " + time);
	};
	setInterval("clock.innerText=formatterDate(new Date())",1000);//动态显示当前时间,24小时制
	function addPage(data) {
		/* alert(data); */
		data = data.toString().trim();
		var index = data.indexOf("(");
		var page = data.substring(index + 1, data.length - 2);
		//document.getElementById("mainFrame").src=page;
		$("#myManu").load(page);
	}

</script>








