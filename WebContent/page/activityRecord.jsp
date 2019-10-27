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

	
	<form id="register" name="register"  enctype="multipart/form-data"  method="post" onsubmit="return savenn()">
	<div>
		档案编号：<input type="text" id="recordNumber" name="recordNumber" >
		<table id="gg" style="width: 900px; height: 400px">
			<thead>
				<tr>
					<th field="tempOutTime" width="100" editor="text">离开时间</th>
					<th field="tempOutCause" width="100" editor="text">离开原因</th>
					<th field="principal" width="100" editor="text">负责人签字</th>
					<th field="returnTime" width="100" editor="text">返回时间</th>
				</tr>
			</thead>
		</table>
		<div id="ob">
			<div>
				<a id="addNumber" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addNumber()">增行</a> 
				<a id="cancelNumber" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="cancelNumber()">删行</a>
			</div>
						
		</div> 
		
	</div>
	<input type="submit" value='确认提交' class="subbtn" />

	</form>
	
	
	<script type="text/javascript">
		$(function(){
			
			$('#gg').datagrid({
				title:'嫌疑活动记录登记',
				toolbar:'#tb',
				pagination:false,
				rownumbers:true,//行号
				striped:false,//奇偶行颜色区分
				fitColumns:false,//列自适应
				singleSelect:true,
				onClickCell: function(index,field,value){ 
					if (endEditing()){
						$('#gg').datagrid('selectRow', index)
								.datagrid('editCell', {index:index,field:field});
						editIndex = index;
					}
			    } 
			}); 
			var params = location.href.substring(location.href.lastIndexOf('?')+1).split('&');
			
			var filenumber=params[0].split('=');
			
	         document.getElementById('filenumber').value =filenumber[1];
		});
		//到货数量明细增行
		function addNumber(){
			var rows = $('#gg').datagrid('getRows');
			var row;
			for (var i = 0; i < rows.length; i++) {
				row=rows[i];
			}
			var index=$('#gg').datagrid('appendRow', {tempOutTime:'',tempOutCause:'',principal:'',returnTime:''}).datagrid('getRows').length-1;

		}
		//到货数量明细删行
		function cancelNumber() {
			
	        editIndex = $('#gg').datagrid('getRows').length-1 ;
	        $('#gg').datagrid('deleteRow', editIndex);
	        editIndex = undefined;
	    }
		function savenn(){
			$.ajax({
		         type: "POST",
		         url: 'tempOut/SaveTempOut?dataJson='+JSON.stringify($('#gg').datagrid("getRows")),
		         data: $("#register").serialize(),
		         success: function (data) {
		        	 $('#tt').datagrid('loadData',{total:0,rows:[]}); 
		        	 $.messager.alert("消息", "保存成功","info");
		         }
		     });
		}
		
		
		//编辑单元格后的值并保存
		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
			});
			
			var editIndex = undefined;
			function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#gg').datagrid('validateRow', editIndex)){
				$('#gg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
			}
			function onClickCell(index, field){
			if (endEditing()){
				$('#gg').datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
			}
			
	</script>
</body>


</html>
