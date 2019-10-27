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
<title>临时离区</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="application/msword">
</head>
<body>
	<div class="lqzt">
		<p>
			离区状态： <select id="leaveState" name="leaveState" onchange="budgetTypeSelect(this.value)">
				<option value="1">暂时离区</option>
				<option value="2">最终离区</option>
			</select>
		</p>
	</div>
	<div class="right-nr" id="tempLeave">
		
	</div>
</body>
<script type="text/javascript">

 $(document).ready(function(){
	    //这是给div的一个初始页面
	$("#tempLeave").load('page/io/temporaryLeave.jsp');
}); 

function budgetTypeSelect(value){
	if(value==2){
		 $("#tempLeave").load('page/io/finallyLeave.jsp'); 
	};
	if(value==1){
		 $("#tempLeave").load('page/io/temporaryLeave.jsp');
	};
}
</script>
</html>

