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

</head>
	<body>
		 <img id="image"src=""/>
			<br/>
			 <input type="file"onchange="selectImage(this);"/>
			<br/>
		 <input type="button"onclick="uploadImage();"value="提交"/>
		 
		 <img name="pic" src="<%=basePath+"entry/getIdentityCardByID?IDCode=123456789012345678"%>"/>
		 
		 <input type="button"onclick="uploadImage();"value="获得图片"/>
		<script>
				 var image = '';
				 function selectImage(file){
				 if(!file.files || !file.files[0]){
					return;
				}
				 var reader = new FileReader();
				 reader.onload = function(evt){
				 document.getElementById('image').src = evt.target.result;
				 image = evt.target.result;
				}
				reader.readAsDataURL(file.files[0]);
				}
				 function uploadImage(){
					
					$.ajax({
					
						/* type:'POST', */
						
						/*  url: 'entry/saveEntryDatebase', */
						 url: 'entry/getIdentityCardByID?IDCode=123456789012345679',
						
						 /* data: {image: image},
						
						 async: false,
						
						 dataType: 'json', */
						
						 success: function(data){
						
						if(data.success){
						
						alert('上传成功');
						
						}else{
						
						alert('上传失败');
						
						}
						
						},
						
						 error: function(err){
						
						alert('网络故障');
						
						}
					
					});
					
				}
		</script>
		
	</body>
</html>
