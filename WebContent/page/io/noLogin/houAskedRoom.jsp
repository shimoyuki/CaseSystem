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
<title>信息采集登记</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui/js/themes/icon.css" />

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jquery-easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>


</head>
	<body>
		<div class="content">
			<div class="bt-ban">
				<div class="nr-jl">
					<div class="biaoz">
						<img src="images/nrtitlr.png">
					</div>
					<a class="guanbi" href=""><img src="images/close.png"></a>
				</div>
			</div>
		<!-- 	<div class="tips-t">
				<p><img src="images/xiaoxi.png">欢迎您，王翠花警官！今天是2017年6月13日  （农历五月二十） 星期三  13:07</p>
			</div> -->
			<div class="hws1">
				<div class="hws1-l">
					<div class="hwsbz">
						<img src="images/hwsicon.jpg">
						侯问室1
						
					</div>
					<div class="renshu">
						<p>当<br>前<br>等<br>审<br>人<br>员<br><span id="personNumber">0</span><br>人</p>
						<a onclick="checkHouRoom()">查询</a>
					</div>
				</div>
				<div class="hws1-r" id="checkHouRoom">
					<!-- <div class="hwsnr">
						<dl>
							<dd><img src="images/hwsren_06.jpg"></dd>
							<dt>
								<p>姓名： 李瑞姬</p>
								<p>编号： ZN001</p>
							</dt>
							<div style="clear:both;"></div>
						</dl>
					</div> -->
				</div>
				<div style="clear:both;"></div>
			</div>
		
	</body>


<script type="text/javascript">
	function checkHouRoom(){
		$.ajax({
			type:'POST',
			url:'waitAsk/searchWaitPerson',
			data:{roomCode:"5",policeStation:"1"},
			dataType :"json",
			success: function(data){
				$("#checkHouRoom").empty();//先清空div
				var personNumber=data.length;
				$("#personNumber").html(personNumber);
				for(var i=0;i<data.length;i++){
					var div='<div class="hwsnr"><dl>'
					+'<dd><img src="'+data[i].IDPicture+'"  width="100%"  height="100%"></dd>'
					+'<dt><p>姓名：'+data[i].name+'</p>'
					+'<p>'+data[i].recordNumber+'</dt>'
					+'<div style="clear:both;"></div></dl></div>'
					$("#checkHouRoom").append(div);
				}
			}
		});
	}

</script>
</html>