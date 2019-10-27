<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>


<%@ page import="java.text.*"%> 
<% 
String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/mycss.css" />
<script type="text/javascript"
	src="jquery-easyui/js/jquery-1.11.2.min.js"></script>
</head>
<body>
	<form id="InforConllection_form" name="ff"
		enctype="multipart/form-data" method="post">
		<div>
				档案编号：<input id="recordNumber" name="recordNumber" >
		<div>
		<img id="frontalView" name="frontalView" src=""  width="150px"  height="150px" value=""/> 
		 <img id="rightView" name="rightView" src=""  width="150px"  height="150px" value=""/> 
		 <img id="leftView" name="leftView" src=""  width="150px"  height="150px" value=""/> 
		</div>
				<p>RFID：<input name="recognition" id="recognition"> 入区原因：<input name="causeCode"  id="causeCode" ></p>
				<p>人员姓名：<input name="name"  id="name" > 民族：<input name="nation"  id="nation"" >出生日期：<input name="birthday"  id="birthday"></p>
				<p>证件类型：<input name="papersType"  id="papersType" > 证件编号：<input name="IDNumber"  id="IDNumber" ></p>
				<p>证件地址：<input name="adress"  id="adress" > 居住地址：<input name="currentAddr"  id="currentAddr"  ></p>
		</div>
		
		信息采集<br /><br /> 
		是否采集：
		<label><input name="isinforCollecte" type="radio" value="1" />是 </label> 
		<label><input name="isinforCollecte" type="radio" value="2" />否 </label>
		<br /><br /> 
		采集项目：
		<label><input name="acquisitionProject" type="checkbox" value="1" />指/掌纹</label> 
		<label><input name="acquisitionProject" type="checkbox" value="2" />血样</label> 
		<label><input name="acquisitionProject" type="checkbox" value="3" />笔记</label> 
		<label><input name="acquisitionProject" type="checkbox" value="4" />身高</label>
		<label><input name="acquisitionProject" type="checkbox" value="5" />特征</label> 
		<label><input name="acquisitionProject" type="checkbox" value="6" />体重</label> 
		<label><input name="acquisitionProject" type="checkbox" value="7" />口音</label> 
		<label><input name="acquisitionProject" type="checkbox" value="8" />免冠照</label>
		<label><input name="acquisitionProject" type="checkbox" value="9" onclick="if(this.checked) {txtNo.disabled=false}else{txtNo.disabled=true}">其他</label>
                                       
		<input type="text" name="txtNo" size="20" value="" disabled>
		<br /><br /> 
		信息入库：
		<label><input name="isinforEnter" type="radio" value="1" />是 </label> 
		<label><input name="isinforEnter" type="radio" value="2" />否 </label>
		<br /><br /> 
		检查对比：
		<label><input name="isInspeCtcontrast" type="radio" value="1" />是 </label> 
		<label><input name="isInspeCtcontrast" type="radio" value="2" />否 </label>
		<br /><br />
		开始时间：
		<input id="startTime" name="startTime" type="text" value="20170512">
		<br /><br />
		结束时间：
		<input id="endTime" name="endTime" type="text" value="20170512">
		
		<br /><br />
		附件上传：
		<img id="mm" src=""  width="150px"  height="150px">
		<input id="ff" name="img" style="display:none">
		<input id="files" type="file" onchange="selectImage(this)" multiple="multiple">  

		<div>
			<input type="button" value="保存提交" onclick="saveInforCollection();">
		</div>
		
		</form>
	<script type="text/javascript">
	
	var image = '';
	 function selectImage(file){
	 if(!file.files || !file.files[0]){
		return;
	}
	 var reader = new FileReader();
	 reader.onload = function(evt){
		 $("#ff").attr("value",evt.target.result);
	 document.getElementById('mm').src = evt.target.result;
	 image = evt.target.result;
	}
	reader.readAsDataURL(file.files[0]);
	}

		$(function(){
			
			$.ajax({
				type:'POST',
				url:'infoHeader/searchBaseInfo?recognition='+3,
				success: function(data){
					var i=data;
					$("#recordNumber").val(i[0].recordNumber);
					$("#recognition").val(i[0].recognition);
					$("#causeCode").val(i[0].causeCode);
					$("#name").val(i[0].name);
					$("#nation").val(i[0].nation);
					$("#birthday").val(i[0].birthday);
					$("#papersType").val(i[0].papersType);
					$("#IDNumber").val(i[0].IDNumber);
					$("#adress").val(i[0].adress);
					$("#currentAddr").val(i[0].currentAddr);
					 document.getElementById('frontalView').src =i[0].frontalView; 
					 document.getElementById('rightView').src =i[0].rightView; 
					 document.getElementById('leftView').src =i[0].leftView; 
					 $("#record").val(i[0].recordNumber);
				}
			});

		});
	function saveInforCollection() {
		//alert(111);
		$.ajax({
			type : "POST",
			url : 'inforCollection/saveInforCollection',
			data: $('#InforConllection_form').serialize(),
			success : function(data) {
				
			}
		});
	}
	
	
	</script>

</body>
</html>


