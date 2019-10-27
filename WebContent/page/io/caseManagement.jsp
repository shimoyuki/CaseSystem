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
<title>案件管理</title>
<link rel="stylesheet" href="css/style.css" />
<link
	href="bootstrap/plus/datatime/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<!-- bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="bootstrap/plus/table/bootstrap-table.min.css">
<!-- jq -->
 <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script> 
<!-- <script type="text/javascript"
	src="jquery-easyui/js/jquery-1.11.2.min.js"></script> -->
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<!-- 日期插件 -->
<script type="text/javascript"
	src="bootstrap/plus/datatime/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="bootstrap/plus/datatime/bootstrap-datetimepicker.zh-CN.js"></script>

<!-- 分页插件 -->

<script type="text/javascript"
	src="bootstrap/plus/table/bootstrap-table.min.js"></script>
<script type="text/javascript"
	src="bootstrap/plus/table/bootstrap-table-locale-all.min.js"></script>
	
	
<link rel="stylesheet" type="text/css" href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui/js/themes/icon.css" />

<script type="text/javascript" src="jquery-easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
<!-- easyui -->
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />
<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<!---弹出框-->
	<form id="addCase" method="post" class="form-horizontal" >
	<div class="popbox" id="boxes" style="display: none;">
		<div class="cszPopbox" id="box-inner" style="height: 500px; overflow-y: auto;">
			<input type="number"  name="caseID" id="ID" style="display:none"/>
			<p class="poc-text">
				案件添加 <span id="btnclose"><img src="images/close.png"></span>
			</p>
			<div class="add-anjian">
				<table>
					<tr>
						<td colspan="2">案件名称：<input class="xiank1" name="name" id="name"></td>
					</tr>
					<tr>
						<td>案件编号：<input class="xiank2"  name="code" id="code"></td>
						<td>案件卷宗号：<input class="xiank2" name="caseNo" id="caseNo"></td>
					</tr>
					<tr>
						<td>保管位置：<input class="xiank2"  name="storageLoc" id="storageLoc"></td>
					</tr>
					<tr>
						<td>案发时间：<input name="startTime" id="startTime" style="width:100px;" class="easyui-datebox">
						<td>案件类型：<select name="caseType" id="caseTypeAddCase"  style="width:100px;height:20px;font-size:13px;border:1px solid teal">
    </select></td>
					</tr>
					<tr>
						<td>结案时间：<input name="finishTime" id="finishTime" style="width:100px;" class="easyui-datebox">
						<td>案件状态：<select name="caseState" id="caseStateAddCase" style="width:142px;height:20px;font-size:13px;" ></select></td>
					</tr>
					<tr>
						<td colspan="2">案件描述： <span class="zhushi">（针对案件做一个简要的概述）</span>
							<br>
						<textarea name="caseDescribe" id="caseDescribe"></textarea></td>
					</tr>
					<tr>
						<td>嫌疑人：<select name="cIDCode" id="cIDCode" style="width:500px;height:25px;font-size:13px;" ></select></td>
					</tr>
					<tr>
						<td>证人：<select name="wIDCode" id="wIDCode" style="width:500px;height:25px;font-size:13px;" ></select></td>
					</tr>
					<tr>
						<td>被害人：<select name="vIDCode" id="vIDCode" style="width:500px;height:25px;font-size:13px;" ></select></td>
					</tr>
					<tr>
						<td>组长：<select name="leaderID" id="leaderID" style="width:142;height:25px;font-size:13px;" ></select></td>
					</tr>
					<tr>
						<td>组员：<select name="policeID" id="policeID" style="width:500px;height:25px;font-size:13px;" ></select></td>
					</tr>
				</table>
			</div>
			
			<div class="btn-add">
				<a onclick="saveCase()">确定添加</a>
			</div>
		</div>
	</div>
	</form>
	<!---弹出框end-->

	<div class="right-nr">
		<div class="search">
			<input type="" name="" placeholder="请输入您要搜索的内容"> <a href=""
				class="search-btn1"><img src="images/search.png"></a>
		</div>
		<div class="search-erj">
			<table>
				<tr>
<!-- 					<td><div class="xlka">
							入区原因： <select name="causeCode" id="causeCode"  style="width:100px;height:20px;font-size:13px;border:1px solid teal">
    </select>
						</div></td> -->
					<td><div class="xlka">
							案件状态：<select name="caseState" id="caseState"  style="width:100px;height:20px;font-size:13px;border:1px solid teal">
    </select>
						</div></td>
					<td><div class="xlka">
							案件类型：<select name="caseType" id="caseType"  style="width:100px;height:20px;font-size:13px;border:1px solid teal">
    </select>
						</div></td>
					<td><div class="xlka">
							涉案人数：<input name="number" id="number" >
						</div></td>
				</tr>
			</table>
			<a id="findCasebyCondition" class="search-btn2">查找</a>
		</div>
		<div class="ajylb">
			<div class="titi">
				<h3>天宁派出所案件一览表</h3>
				<a class="tianj" id="buttonclick"><span><img src="images/tianjia.png">添加</span></a> 
				<a class="xiug" onclick="updateCase()"><span><img src="images/xiugai.png">修改</span></a> 
				<a class="sanc" onclick="deleteCase()"><span><img src="images/sanchu.png">删除</span></a>
			</div>
			<table id="caseTable"></table>
		</div>
	</div>


	<script type="text/javascript">

		
		 $(document).ready(function(){
			$("#entryTime").val(new Date().toLocaleString()); //入区时间
			
			 $("#causeCode").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=causeCode',
		        valueField:'code',   
		        textField:'name'  
		   	});
			$("#leaveCause").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=leaveCause',
		        valueField:'code',   
		        textField:'name'  
		   	});
			$("#caseType").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=caseType',
		        valueField:'code',   
		        textField:'name',  
		   	});
		   	
		   	$("#caseTypeAddCase").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=caseType',
		        valueField:'code',   
		        textField:'name'
		   	});
		   	$("#caseState").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=caseState',
		        valueField:'code',   
		        textField:'name',  
		   	});
			$("#caseStateAddCase").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=caseState',
		        valueField:'code',   
		        textField:'name',  
		   	});
		   	$("#cIDCode").combobox({  
		        url : 'lawcase/getEntryPerson?policeStation=1',
		        valueField:'code',   
		        textField:'name',  
		        multiple:true,  
               //	editable:false, 
		   	});
		   	$("#wIDCode").combobox({  
		        url : 'lawcase/getEntryPerson?policeStation=1',
		        valueField:'code',   
		        textField:'name',  
		        multiple:true,  
               	editable:false,   
		   	});
		   	$("#vIDCode").combobox({  
		        url : 'lawcase/getEntryPerson?policeStation=1',
		        valueField:'code',   
		        textField:'name',  
		        multiple:true,  
               	editable:false,   
		   	});
		   	$("#policeID").combobox({  
		        url : 'lawcase/getpoliceman?policeStation=1',
		        valueField:'code',   
		        textField:'name',  
		        multiple:true,  
               	editable:false,   
		   	});
		   	$("#leaderID").combobox({  
		        url : 'lawcase/getpoliceman?policeStation=1',
		        valueField:'code',   
		        textField:'name'  
		   	});
		   	
		});
		//显示案件添加弹窗
		$("#buttonclick").click(function(){
			document.getElementById("boxes").style.display = "block";
			document.getElementById("box-inner").style.top = "70px";
		});
		//隐藏案件添加弹窗
		$("#btnclose").click(function(){
			$(':input','#addCase').not(':button, :submit, :reset, :hidden').val('') 
	    	.removeAttr('checked') .removeAttr('selected');//清空弹窗form表单 
			document.getElementById("boxes").style.display = "none";
		});
		var caseState="";
		var caseType="";
		$("#findCasebyCondition").click(function(){ //根据筛选条件查找案件
			caseState=$('#caseState').combobox('getValue');
			caseType=$('#caseType').combobox('getValue');
			$('#caseTable').bootstrapTable('refresh', {url: 'lawcase/getCasebycondition'});//重新加载table.
		});
			  
		function saveCase(){//保存添加案件
			$('#addCase').form('submit',{
				 url:'lawcase/saveAndModifyCase',
				 success: function(data) {  
				    	$(':input','#addCase').not(':button, :submit, :reset, :hidden').val('') 
				    	.removeAttr('checked') .removeAttr('selected');//清空弹窗form表单 
				    	document.getElementById("boxes").style.display = "none";//关闭弹窗
				    	$('#caseTable').bootstrapTable('refresh', {url: 'lawcase/getCasebycondition'});//重新加载table.
				 }  
			});
		}
		$('#caseTable').bootstrapTable({
			method : 'post',
			contentType : "application/x-www-form-urlencoded",//必须要有！！！！
			url : 'lawcase/getCasebycondition',//要请求数据的文件路径
			striped : true, //是否显示行间隔色
			//toolbar : '#toolbar',//指定工具栏
			dataField : "res",//bootstrap table 可以前端分页也可以后端分页，这里
			//我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
			//rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
			pageNumber : 1, //初始化加载第一页，默认第一页
			pagination : true,//是否分页
			queryParamsType : '',//查询参数组织方式
			queryParams:queryParams,//请求服务器时所传的参数
			sidePagination : 'server',//指定服务器端分页
			pageSize : 10,//单页记录数
			pageList : [ 5, 10, 20, 30 ],//分页步进值
			showRefresh : false,//刷新按钮
			showColumns : false,
			//toolbarAlign : 'left',//工具栏对齐方式
			//buttonsAlign : 'right',//按钮对齐方式
			columns : [ {
				title : '全选',
				field : 'select',
				//复选框
				checkbox : true,
				width : 25,
				align : 'center',
				valign : 'middle'
			}, {
				title : '序号',
				field : 'SerialNumber',
				formatter: function (value, row, index) {
			        return index+1;
			    }
			}, {
			    field: 'operate',
			    title: '案件名',
			    align: 'center',
			    formatter:function(value,row,index){
				    var element = 
				    "<a id='"+row.ID +"' onclick='showDetail(id)'>"+row.name+"</a> "
				    return element;  
				} 
			},{
				title : '嫌疑人',
				field : 'caseCriminal',
			// sortable:true
			}, {
				title : '证人/被害人',
				field : 'caseWitness',
			}, {
				title : '案发时间',
				field : 'startTime'
			}, {
				title : '案件类型',
				field : 'caseType',
			}, {
				title : '案件状态',
				field : 'caseState',
			}, {
				title : '案件责任人',
				field : 'leaderID',
				editable : true,
			}, {
				title : '小组成员',
				field : 'casePoliceman',
				editable : true,
			},
			
			],
			locale : 'zh-CN',//中文支持
			responseHandler : function(res) {
				//在ajax获取到数据，渲染表格之前，修改数据源
				return res;
			}
		});

		 function queryParams(params){
	        return{
	        	//每页多少条数据
	            pageSize: params.pageSize,
	            //请求第几页
	            pageNumber:params.pageNumber,
	          	caseState:caseState,
	            caseType:caseType,  
	            number:$("#number").val()
	        } 
	    } 
		 function remarks(value, row, index) {
			    if (value.length > 20) {
			        return "<div style=\"font-family:'微软雅黑'\" title='" + value + "'><a>详情</a></div>";
			    } else {
			        return "<div style=\"font-family:'微软雅黑'\">" + value + "</div>";
			    }
			}
		function deleteCase(){ //删除案件
			var rows= $('#caseTable').bootstrapTable('getSelections');

			if(rows.length>0){
				var idArray=new Array();
			     for(var i=0;i<rows.length;i++){
			    	 idArray.push(rows[i].ID);
			     }
				$.ajax({  
				    type: "POST",  
				    url:'lawcase/deleteCase',  
				    data:{"idList":idArray},  
				    traditional: true,//传数组进后台需要设置该属性
				    error: function(request) {  
				        alert("Connection error");  
				    },  
				    success: function(data) {  
				    	$('#caseTable').bootstrapTable('refresh', {url: 'lawcase/getCasebycondition'});//重新加载table.
				    }  
				 });
			}else{
				$.messager.alert("提示", "请至少选择一行！","info");
			}
		}
		function updateCase(){//修改案件
			var rows= $('#caseTable').bootstrapTable('getSelections');
			if(rows.length==1){
			     var id=rows[0].ID;
				$.ajax({  
				    type: "POST",  
				    url:'lawcase/findCaseDetails',  
				    data:{"id":id},  
				    dataType:'json',
				    error: function(request) {  
				    	$.messager.alert("错误", "系统错误请重新操作！","error");
				    },  
				    success: function(data) { 
				    	$('#ID').val(data.ID);
				    	$('#name').val(data.name);
				    	$('#code').val(data.code);
				    	$('#caseNo').val(data.caseNo);
				    	$('#storageLoc').val(data.storageLoc);
				    	$('#startTime').datebox('setValue', data.startTime);
				    	$('#finishTime').datebox('setValue', data.finishTime);
				    	$('#caseDescribe').val(data.caseDescribe);
				    	$('#caseTypeAddCase').combobox('setValue', data.caseType);
				    	$('#caseStateAddCase').combobox('setValue', data.caseState);
				    	$('#leaderID').combobox('setValue', data.leaderID);
				    	$('#cIDCode').combobox('setValues',data.caseCriminal.substring(1,data.caseCriminal.length-1).replace(" ", "").split(","));
				    	$('#vIDCode').combobox('setValues',data.caseVictim.substring(1,data.caseVictim.length-1).replace(" ", "").split(","));
				    	$('#wIDCode').combobox('setValues',data.caseWitness.substring(1,data.caseWitness.length-1).replace(" ", "").split(","));
				    	$('#policeID').combobox('setValues',data.casePoliceman.substring(1,data.casePoliceman.length-1).replace(" ", "").split(","));
				    	document.getElementById("boxes").style.display = "block";
				    	//$('#caseTable').bootstrapTable('refresh', {url: 'lawcase/getCasebycondition'});//重新加载table.
				    }  
				 });
			}else{
				$.messager.alert("提示", "请选择你要修改的一行！","info");
			}
		}

		function showDetail(id){
			location.href="lawcase/showCaseReport?id="+id;
		}
	</script>
</body>
</html>