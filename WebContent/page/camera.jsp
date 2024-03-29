<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href=<%=basePath%>>
<meta charset="UTF-8">
<title>调用摄像头</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/camera.js"></script>
<style type="text/css">
#camera_errbox {
	width: 320px;
	height: auto;
	border: 1px solid #333333;
	padding: 10px;
	color: #fff;
	text-align: left;
	margin: 20px auto;
	font-size: 14px;
}

#camera_errbox b {
	padding-bottom: 15px;
}

.borderstyle{
	-webkit-box-shadow:0 0 5px 3px rgba(255,0,0,.6),0 0 5px 6px rgba(0,182,0,.6),0 0 5px 10px rgba(255,255,0,.6);
	-moz-box-shadow:0 0 5px 3px rgba(255,0,0,.6),0 0 5px 6px rgba(0,182,0,.6),0 0 5px 10px rgba(255,255,0,.6);
	-ms-box-shadow:0 0 5px 3px rgba(255,0,0,.6),0 0 5px 6px rgba(0,182,0,.6),0 0 5px 10px rgba(255,255,0,.6);
	-o-box-shadow:0 0 5px 3px rgba(255,0,0,.6),0 0 5px 6px rgba(0,182,0,.6),0 0 5px 10px rgba(255,255,0,.6);
	box-shadow:0 0 5px 3px rgba(255,0,0,.6),0 0 5px 6px rgba(0,182,0,.6),0 0 5px 10px rgba(255,255,0,.6);
}

#navy_video{
	float:left;
}

#canvas{
	float:left;
	margin-left:20px;
}

</style>
</head>
<body onLoad="init(this)" oncontextmenu="return false" onselectstart="return false">
	<center>
		<video id="navy_video" width="320px" height="240px" autoplay class="borderstyle"></video>
		<input id="snap" type="button" value="拍照"/>
		<button onclick="convertCanvasToImage()">保存</button>
		<div id="camera_errbox">
			<b>请点击“允许”按钮，授权网页访问您的摄像头！</b>
			<div>若您并未看到任何授权提示，则表示您的浏览器不支持Media Capture或您的机器没有连接摄像头设备。</div>
		</div>
		<canvas id="canvas" width="160px" height="120px" class="borderstyle"></canvas>
	</center>
</body>
</html>
