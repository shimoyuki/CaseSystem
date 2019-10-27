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
<title>个人中心</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/default/easyui.css" />
<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>
</head>
	<body>
		<form id="policeInfor" method="post" class="form-horizontal" >
		<div class="right-nr">
			<div class="right-navxj">
				<div class="bianji-top">
					<a id="clickUpdate" class="btn-bj"><img src="images/icon-bj.png" /></a>
					<div class="line-top-bj"></div>
				</div>
				<div class="personal-nav">
					<div class="personal-img-nav">
						<div class="renwu-img"><img src="images/renwu-tx.jpg" id="img"  width="100%"  height="100%"/></div>
						<a onclick="F_Open_dialog()" class="btn-ghzp">更改照片<input type="file" id="uploadFiles" style="display:none" onchange="selectImage(this)"></a>
						<input  id="picture" name="picture" style="display:none;">
					</div>
					<div class="personal-inp-nav">
						<p class="srxx-geren"><span class="shuru-tm">姓名：</span><input id="name"  name="name" class="geren-srbig"  readonly="readonly"/></p>
						<p class="srxx-geren"><span class="shuru-tm">警员编号：</span><input id="code" name="code"class="geren-srbig" readonly="readonly" /></p>
						<p class="srxx-geren"><span class="shuru-tm">性别：</span><input id="sex" name="sex"class="geren-srsmall"  readonly="readonly"/><span class="shuru-tm">民族：</span><input id="nation" name="nation" class="geren-srsmall" readonly="readonly" /><span class="shuru-tm">籍贯：</span><input id="nativePlace" name="nativePlace" class="geren-srsmall" readonly="readonly" /></p>
						<p class="srxx-geren"><span class="shuru-tm">身份证号：</span><input id="idcode" name="idcode" class="geren-srbig" readonly="readonly" /></p>
						<p class="srxx-geren"><span class="shuru-tm">电话：</span><input id="phone" name="phone" class="geren-srbig"  /></p>
						<p class="srxx-geren"><span class="shuru-tm">现住址：</span><input id="currentAddr" name="currentAddr" class="geren-srbig"  /></p>
						<p class="srxx-geren"><span class="shuru-tm">工作单位：</span><input id="text" name="text" class="geren-srbig"  /></p>
						<p class="srxx-geren"><span class="shuru-tm">工作部门：</span><input id="department" name="department" class="geren-srbig"  /><span class="shuru-tm">职务：</span><input id="duty" name="duty" class="geren-srsmall"  /></p>
						<p class="srxx-geren"><span class="shuru-tm">编制情况：</span><input id="formation" name="formation" class="geren-srbig"  /></p>
						<p class="srxx-geren"><span class="shuru-tm">办公位置： </span><input id="location" name="location"  class="geren-srbig"  /></p>
						<a id="saveUpdate" onclick="modify()" class="btn-baocun" style="display: none;">保存</a>
					</div>
				</div>
			</div>
		</div>	
		</form>	
	</body>
<script type="text/javascript">
	
	$("#clickUpdate").click(function() {
			$("#saveUpdate").css("display", "block");
	});


	function F_Open_dialog(data){
		 document.getElementById("uploadFiles").click(); 
	}
	function selectImage(file){
		 if(!file.files || !file.files[0]){
			return;
		}
		var reader = new FileReader();
		 reader.onload = function(evt){
			 document.getElementById("img").src = evt.target.result;
			 $("#picture").val(evt.target.result);
		}
		reader.readAsDataURL(file.files[0]);
	}
	 $(document).ready(function(){
		 $.ajax({
			    type: "POST",
			    url: "personInfor/showPoliceInfor",
			    dataType:'json' ,
			    success: function (msg) {
			     $("#name").val(msg.name);
			     $("#sex").val(msg.sex);
			     $("#nation").val(msg.nation);
			     $("#birthday").val(msg.birthday);
			     $("#idcode").val(msg.idcode);
			     $("#code").val(msg.code);
			     $("#img").attr('src',msg.picture);
			     $("#picture").val(msg.picture);
			     $("#nativePlace").val(msg.nativePlace);
			     $("#currentAddr").val(msg.currentAddr);
			     $("#showPoliceInfor").val(msg.showPoliceInfor);
			     $("#duty").val(msg.duty);
			     $("#department").val(msg.department);
			     $("#formation").val(msg.formation);
			     $("#location").val(msg.location);
			     $("#phone").val(msg.phone);
			     $("#recordNumberForm").val(msg.recordNumber);
			    },
			    error: function (error) {
			      easyuiAlert(error);
			    }
			  });
	}); 
	function modify(){//保存添加案件
			$('#policeInfor').form('submit',{
				 url:'personInfor/modifPersonInfor',
				 success: function(data) {  
					 $.messager.alert("提示", "修改成功！","info");
				 },
				 error: function(request) {  
				    $.messager.alert("错误", "修改失败！","error");
				 },  
			});
	}

</script>
</html>