<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/mycss.css" />
<script type="text/javascript"
	src="jquery-easyui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>
<!-- <script type="text/javascript"
	src="jquery-easyui/js/jquery.min.js"></script> -->
<script type="text/javascript"
	src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='js/sjcx/hplymxb.js'></script>


</head>

<body>

	
	<form id="register" name="register"  enctype="multipart/form-data"  method="post">
	<div>
		档案编号：<input type="text" id="recordNumber" name="recordNumber" >
		
	</div>
	
		<input type="submit" value='确认提交' class="subbtn"/>

	</form>
	
	
	<script type="text/javascript">
	$(function(){
		
         document.getElementById('recordNumber').value ="12345";
		$('#register').form({
			url:'infoHeader/searchBaseInfo',
			success:function(data){
				alert("成功：");
			}		
		});

	});
	var clearSelection = function () { 
		if(document.selection && document.selection.empty) { 
			document.selection.empty(); 
		} else if(window.getSelection) {
			var sel = window.getSelection(); sel.removeAllRanges();
		} 
	}
	$(element).bind('dblclick',function(event){
		clearSelection(); 
	});
	</script>
</body>


</html>
