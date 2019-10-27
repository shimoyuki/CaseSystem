<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>案件管理系统</title>
<!-- <link rel="stylesheet" href="css/main.css" type="text/css"></link>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="jquery-easyui/js/html5shiv.js"></script>
<script type="text/javascript" src="jquery-easyui/js/respond.min.js"></script> -->

</head>
<body>

 
 <div id="newDepartment" class=" easyui-dialog"
		style="top: 40px; padding: 5px; width: 700px; height: 400px;"
		title="添加部门" iconCls="icon-remove" closed="true" modal="true">

		<form id="newDepartment_form" name="ff" enctype="multipart/form-data"
			method="post" action="waitAsk/leaveWaitAsk" >

			<table style="width: 100%; font-size: 12px; font-weight: normal">
				
				<tr>
					<td class="td1">档案号:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="recordNumber" 
						style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td class="td1">房间编号:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="roomCode" style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td class="td1">所属派出所:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="policeStation" style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td class="td1">离开时间:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="ltime" style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td style="text-align: right" colspan=2><input type="button"
						onclick="newDepartment_cancel()" class="subbtn" value="取消"> <input
						type="submit" class="subbtn" value="提交"></td>
				</tr>

			</table>
		</form>
	</div>

	<!-- <script type="text/javascript"
		src="jquery-easyui/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="jquery-easyui/js/jquery.validate.js"></script>
	<script type="text/javascript" src="jquery-easyui/js/form.js"></script>
	<script type="text/javascript" charset="utf-8">
		 MyValidator.init();
	</script> -->
	
	<script type="text/javascript">
        
       /*  function copyText(id){
        	//alert(111);
        	var obj=window.document.getElementById(id);
        	var bg=obj.style.backgroundColor;
        	if(bg=='') {obj.style.backgroundColor='#f00'
        	}else {obj.style.backgroundColor=''}
        } */
</script>
</body>
</html>

 
 
 
 
 
 

 
 
 