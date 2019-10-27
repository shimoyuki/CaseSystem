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
<title>账号设置</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/default/easyui.css" />
<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>
</head>
<body>
	<div class="right-nr">
		<div class="right-navxj">
			<div class="bianji-top">
				<a id="clickUpdate" class="btn-bj"><img src="images/icon-bj.png" /></a>
				<div class="line-top-bj"></div>
			</div>
			<form id="zhsz-nav_form" name="zhsz-nav_form" method="post">
				<div class="zhsz-nav">
					<div class="zhsz-details">
						<p>
							<span class="zhsz-tm">账号：</span><span class="zhsz-nr" id="name">警032300</span>
						</p>
						<p>
							<span class="zhsz-tm">权限角色：</span><span class="zhsz-nr" id="roles">值班干警</span>
						</p>
						<p>
							<span class="zhsz-tm">旧密码：</span><input name="oldPass" id="oldPass"  type="password"
								class="inp-zhsz" />
						</p>
						<p>
							<span class="zhsz-tm">新密码：</span><input name="newPass"  id="newPass"  type="password"
								class="inp-zhsz" />
						</p>
						<p>
							<span class="zhsz-tm">确认新密码：</span><input name="confirmPass" id="confirmPass"  type="password"
								class="inp-zhsz" />
						</p>
					</div>
					<a id="saveUpdate" onclick="modifyPass()" class="btn-baocun" style="display: none;">保存</a>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$("#clickUpdate").click(function() {
			$("#saveUpdate").css("display", "block");
		});
/* 		$("#saveUpdate").click(function() {
			$('#zhsz-nav_form').form('submit', {
				url : 'safetyCheck/saveHisBelongings',
				success : function(data) {
					$(':input','#newGoods_form').not(':button, :submit, :reset, :hidden').val('') 
			    	.removeAttr('checked') .removeAttr('selected');//清空弹窗form表单 
					if (data == true || data == 'true') {
						$("#boxes").css("display", "none");
						$('#goodstt').bootstrapTable("refresh", {
							url : "safetyCheck/getGoodsList"
						});
					}
				}
			});
		}); */
		 $(document).ready(function(){
			 $.ajax({
				    type: "POST",
				    url: "personInfor/showUserAndRoles",
				    dataType:'json' ,
				    success: function (msg) {
					    $("#name").html(msg.name);
					    var length=msg.role.length;
					    var roles =new Array();
					    for(var i=0;i<length;i++){
					    	roles.push(msg.role[i].name);
					    	roles.push("  ");
					    }
					   
					    $("#roles").html(roles);
				    	
				    },
				    
				    error: function (error) {
				      easyuiAlert(error);
				    }
				  });
		}); 
		 function modifyPass(){
			 var oldPass=$('#oldPass').val();
			 var newPass=$('#newPass').val();
			 var confirmPass=$('#confirmPass').val();
			 if(oldPass==null||oldPass.trim()==""||newPass==null
					 ||newPass.trim()==""||confirmPass==null||confirmPass.trim()==""){
				 $.messager.alert("提示", "密码不能为空！","info");
				 return;
			 }
			 $.ajax({
				    type: "POST",
				    /* url: "personInfor/modifyPass", */
				    url:'http://www.baidu.com',
				    //data:{"oldPass":oldPass,"newPass":newPass,"confirmPass":confirmPass},
				    dataType:"text",
				    success: function (msg) {
				    	$.messager.alert("提示", msg,"info");
				    	$('#oldPass').val("");
				    	$('#newPass').val("");
				    	$('#confirmPass').val("");
				    },
				    
				    error: function (error) {
				    	$.messager.alert("错误","未知错误!","error");
				    }
			});
		 }
	</script>

</body>
</html>