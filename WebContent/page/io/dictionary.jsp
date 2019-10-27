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
<script type="text/javascript"
	src="jquery-easyui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
<meta http-equiv="Content-Type" content="application/msword">
</head>
	<body>
		<form id="loginForm" method="post" class="form-horizontal" action="entry/saveEntry"  enctype="multipart/form-data">
		
			
			人员类型：<select name="personType" id="personType"  style="width:150px;height:20px;font-size:13px;border:1px solid teal" >
					</select>
			入区原因：<select name="causeCode" id="causeCode"  style="width:150px;height:20px;font-size:13px;border:1px solid teal" >
					</select>
			所有字典表字段：<select name="codeName" id="codeName"  style="width:150px;height:20px;font-size:13px;border:1px solid teal" onchange="gradeChange()">
					</select>
			<table id="caption">
			
				<tr>
					<th>代码列表</th><td  style="display:none;"></td>
				<tr>
			</table>		
		<div>
			<input id="id"  name="id" style="display:none" value="0">
			名称：<input id="itemCaption"  name="itemCaption">
			代码：<input id="itemCode"  name="itemCode">
		
		</div>
		<div>
			<input type="button" onclick="addDc()" value="新增">
			<input type="button" onclick="deleteDc()" value="删除">
			<!-- <input type="button" onclick="saveDc()" value="保存"> -->
			 <input type="submit"value="保存"/>
		</div>
		
		 
		<%--  <img name="pic" src="<%=basePath+"entry/getIdentityCardByID?IDCode=123456789012345678"%>"/>
		 
		 <input type="button"onclick="uploadImage();"value="获得图片"/> --%>
		 </form>
		<script>
				
		window.onload = function () { 
			
			$("#personType").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=personType',
		        valueField:'code',  //对应编码
		        textField:'name'  //对应值
		   	});
			$("#causeCode").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=causeCode',
		        valueField:'code',   
		        textField:'name'  
		   	});
			$("#codeName").combobox({  
		        url : 'infoHeader/getAllField',
		        valueField:'codeName',   
		        textField:'caption'  
		   	});
		}
		$("#codeName").combobox({
			onChange: function (n,o) {
				var codeName=$('#codeName').combobox('getValue');
				$.ajax({
					type:'post',
					url : 'infoHeader/getListByCodeName?codeName='+codeName,
					success:function(data){
						//先清空table，再增加行
						var tab = document.getElementById('caption');
						var rowNum=tab.rows.length;
						for(var i=1;i< rowNum;i++){
							tab.deleteRow(i);
							 rowNum=rowNum-1;
					         i=i-1;
						}
						for(var i=0;i<data.length;i++){
							var row='<tr id="'+data[i].id+'"  onclick=clickaction(id)><td>'+data[i].name+'</td><td  style="display:none;">'+data[i].code+'</td><td  style="display:none;">'+data[i].id+'</td><tr>';
							$("#caption").append(row);
						}
					}		
				});
			}	
		});
		function clickaction(id){
			var itemCaption=$("#"+id+"").children().eq(0).html();
			var itemCode=$("#"+id+"").children().eq(1).html();
			var id=$("#"+id+"").children().eq(2).html();
			$("#itemCaption").val(itemCaption);
			$("#itemCode").val(itemCode);
			$("#id").val(id);
		}
		function addDc(){
			$("#itemCaption").val("");
			$("#itemCode").val("");
			$("#id").val(0);
		}
		$('#loginForm').form({  //保存按钮
			url:'infoHeader/saveOrUpdateField',
			
			success:function(data){
				
				//先清空table，再增加行
				var tab = document.getElementById('caption');
				var rowNum=tab.rows.length;
				for(var i=1;i< rowNum;i++){
					tab.deleteRow(i);
					 rowNum=rowNum-1;
			         i=i-1;
				}
				data=eval('(' + data + ')');
				for(var i=0;i<data.length;i++){
					var row='<tr id="'+data[i].id+'"onclick=clickaction(id)><td>'+data[i].name+'</td><td  style="display:none;">'+data[i].code+'</td><td  style="display:none;">'+data[i].id+'</td><tr>';
					$("#caption").append(row);
				}
			}
			
		});
		function deleteDc(){
			
			var id=$("#id").val();
			var codeName=$('#codeName').combobox('getValue');
			$.ajax({
				type:'post',
				url : 'infoHeader/deleteField?id='+id+'&codeName='+codeName,
				success:function(data){
					//先清空table，再增加行
					var tab = document.getElementById('caption');
					var rowNum=tab.rows.length;
					for(var i=1;i< rowNum;i++){
						tab.deleteRow(i);
						 rowNum=rowNum-1;
				         i=i-1;
					}
					for(var i=0;i<data.length;i++){
						var row='<tr id="'+data[i].id+'"  onclick=clickaction(id)><td>'+data[i].name+'</td><td  style="display:none;">'+data[i].code+'</td><td  style="display:none;">'+data[i].id+'</td><tr>';
						$("#caption").append(row);
					}
				}		
			});
		}
		</script>
		
	</body>
</html>
