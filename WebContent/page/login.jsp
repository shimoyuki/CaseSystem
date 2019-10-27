<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智慧警务</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/css.css" />
</head>
<body onkeydown="on_return()">
	<form action="user/checkUser" method="post" id="form" name="form">
		<div class="bg-nav">
			<div class="nr-useful">
				<div class="dl-banner">
					<img src="images/dl-banner.png" />
				</div>
			</div>
			<div class="dlk-nav">
				<div class="tfirst">
					<input name="name" placeholder="请输入用户名 ..." type="text">
					<div class="icon-name">
						<img src="images/icon-yhm.png" />
					</div>
				</div>
				<div class="tfirst">
					<input name="pass" placeholder="请输入密码 ..." type="password">
					<div class="icon-name">
						<img src="images/icon-mima.png" />
					</div>
				</div>
				<!-- <a class="btn-login" onclick="javascript:$('#form').submit()">登&nbsp;&nbsp;&nbsp;录</a> -->
				<a class="btn-login"  id="sub" onClick='check()'>登&nbsp;&nbsp;&nbsp;录</a>
			</div>
			<div class="cjl-kb"></div>
		</div>
	</form>
</body>
<script type="text/javascript">

function check() {
    var formname=document.form;
   if (formname.name.value == "") {
    alert("请输入用户名！");
    formname.name.focus();
    return false;
  }
  if (formname.pass.value == "") {
    alert("请输入密码！");
    formname.pass.focus();
    return false;
  }
  formname.submit();
}
//回车时，默认是登陆
function on_return(){
if(window.event.keyCode == 13){
 if (document.all('sub')!=null){
  document.all('sub').click();
  }
}
}
</script>
</html>

