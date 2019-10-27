<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
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
<meta http-equiv="Content-Type" content="application/msword">
</head>
	<body>
		<form id="loginForm" method="post" class="form-horizontal" action="entry/saveEntry"  enctype="multipart/form-data">
		
		 <!-- onsubmit="return uploadImage();" -->
		 <img id="frontalView" name="frontalView" src=""  width="150px"  height="150px" value=""/> 
		 <input type="file" id="frontal" onchange="selectImage(this)">
		 <img id="rightView" name="rightView" src=""  width="150px"  height="150px" value=""/> 
		 <input type="file" id="right" onchange="selectImage(this)">
		 <img id="leftView" name="leftView" src=""  width="150px"  height="150px" value=""/> 
		 <input type="file" id="left" onchange="selectImage(this)">
		  <div  style="display:none;">  <!-- 此div是将图片的值转换保存为字符串便于向后台传值，隐藏不显示 -->
		  	<input  id="f"name="frontalView">
		  	<input   id="r"name="rightView">
		  	<input  id="l" name="leftView">
		  </div>
			<div>
				<p>身份类型：<input name="personType"> 人员编号：<input name="staffNo"></p>
				<p>RFID：<input name="recognition"> 入区时间：<input name="entryTime">入区原因：<input name="causeCode"></p>
				<p>人员姓名：<input name="name"> 民族：<input name="nation">出生日期：<input name="birthday"></p>
				<p>证件类型：<input name="papersType"> 证件编号：<input name="IDNumber">联系方式：<input name="telephone"></p>
				<p>证件地址：<input name="adress"> 居住地址：<input name="currentAddr"></p>
				<p>备注<input name="detail"> ：<p>
				<p>办案区民警签字：<input name="entryPolice"> 管理员签字：<input name="entryAdmin"></p>
			</div>
		 <input type="submit"value="提交"/>
		 
		<%--  <img name="pic" src="<%=basePath+"entry/getIdentityCardByID?IDCode=123456789012345678"%>"/>
		 
		 <input type="button"onclick="uploadImage();"value="获得图片"/> --%>
		 </form>
		<script>
				
				function selectImage(file){
					 if(!file.files || !file.files[0]){
						return;
					}
				 	var reader = new FileReader();
					 reader.onload = function(evt){
						 document.getElementById(file.id+'View').src = evt.target.result;
						 if(file.id=='frontal'){
							 $("#f").attr("value",evt.target.result);
							 
						 }
						 if(file.id=='right'){
							 $("#r").attr("value",evt.target.result);
							
						 }
						 if(file.id=='left'){
							 $("#l").attr("value",evt.target.result);
							
						 }
					}
					reader.readAsDataURL(file.files[0]);
				}
				
  				/*  function uploadImage(){
					$.ajax({
					
						 type:'POST', 
						
						 url: 'entry/saveEntry',
						
						 data:{frontalImage:frontalImage,rightImage:rightImage,leftImage:leftImage,data:$("#loginForm").serializeArray()},
						
						
						 dataType: 'json', 
						
						 success: function(data){
						
							alert("成功:"+data);
						
						},
						
						 error: function(err){
						
							alert('网络故障:'+err);
						
						}
					
					});
					
				} 
				
		function setImagePreviews(avalue) {
			        //获取选择图片的对象
			        var docObj = document.getElementById("doc");
			        //后期显示图片区域的对象
			        var dd = document.getElementById("dd");
			        dd.innerHTML = "";
			        //得到所有的图片文件
			        var fileList = docObj.files;
			        //循环遍历
			        for (var i = 0; i < fileList.length; i++) {    
			            //动态添加html元素        
			            dd.innerHTML += " <img  width='150px'  height='150px' id='img" + i + "'  />";
			            //获取图片imgi的对象
			            var imgObjPreview = document.getElementById("img"+i); 
			            
			            if (docObj.files && docObj.files[i]) {
			                //火狐下，直接设img属性
			                imgObjPreview.style.display = 'block';
			                imgObjPreview.style.width = '200px';
			                imgObjPreview.style.height = '180px';
			                //imgObjPreview.src = docObj.files[0].getAsDataURL();
			                //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要以下方式
			                imgObjPreview.src = window.URL.createObjectURL(docObj.files[i]);   //获取上传图片文件的物理路径
			            }
			            else {
			                //IE下，使用滤镜
			                docObj.select();
			                var imgSrc = document.selection.createRange().text;
			                //alert(imgSrc)
			                var localImagId = document.getElementById("img" + i);
			               //必须设置初始大小
			                localImagId.style.width = "200px";
			                localImagId.style.height = "180px";
			                //图片异常的捕捉，防止用户修改后缀来伪造图片
			                try {
			                    localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			                    localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			                }
			                catch (e) {
			                    alert("您上传的图片格式不正确，请重新选择!");
			                    return false;
			                }
			                imgObjPreview.style.display = 'none';
			                document.selection.empty();
			            }
			        }  
			        return true;
			    }  */

			    /* chrome.tabs.query({
			        "active": true,//fetch active tabs
			        "currentWindow": true,//fetch tabs in current window
			        "status": "complete",//fetch completely loaded windows
			        "windowType": "normal"//fetch normal windows
			    }, function (tabs) {
			        for (tab in tabs) {
			            console.log(tabs[tab].favIconUrl);// Use this URL as needed
			        }
			    }); */
		</script>
		
	</body>
</html>
