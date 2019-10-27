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
<META http-equiv="X-UA-Compatible" content="IE=8"></META>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/css/default.css" />
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
<script type="text/javascript" src='js/main.js'></script>

</head>

<body>

	
	<form id="register" name="register"  enctype="multipart/form-data"  method="post">
	
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
		临时离开：  	<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="addOrder()">新增</a> 
		<table id="out">
			<tr >
				<td name="number">
					序号
				</td>
				<td name="tempOutTime">
					离开时间
				</td>
				<td name="tempOutCause">
					离开原因
				</td>
				<td name="returnTime">
					返回时间
				</td>
				<td name="principal">
					办案人员签字
				</td>
			</tr>
			
		</table>
	</div>
	最终离开办案区：
	<div>
		离开时间：<input name="tempOutTime">离开原因：<input name="leaveCause">
		<p>随身物品返还情况：</p>
		<p><input type="radio" name="goodsDispose" value="2">全部归还<input type="radio" name="goodsDispose" value="1">部分归还<input type="radio" name="goodsDispose" value="0">未归还</p>
		<p>领取人签名：<input name="goodsReceiptor">身份证号：<input name="receiptorID">领取时间：<input name="receiptorTime"></p>
		
		<p>管理员签名：<input name="leaveAdmin">领取时间：<input name="adminTime"></p>
	</div>
	
	
		<input type="submit" value='确认提交' class="subbtn"/>

	</form>
		
		<div id="newOrder" class=" easyui-dialog"
		style="top: 40px; padding: 5px; width: 300px; height: 450px;"
		 closed="true" modal="true">
		 <form id="aaa" name="aaa"  method="post">
		 	<input id="record" name="recordNumber" style="display:none;">
			离开时间：<input name="tempOutTime">
			返回时间：<input name="returnTime">
			离开事由：<input name="tempOutCause">
			负责人签字：<input name="principal">
			
			<input type="submit" value='保存' class="subbtn"/>
		</form>
	</div>
	
	
	<script type="text/javascript">
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
	function addOrder(){
		$('#newOrder').dialog('open');
		return true;
	};
	//提交临时出区表单
	var serial=1;
	$('#aaa').form({
		
			url:'tempOut/SaveTempOut',
			
			success:function(data){
				var f=$("#aaa").serializeArray();
				var hang='<tr><td  name="number">'+serial+'</td>'
				+'<td  name="tempOutTime">'+f[1].value.toString()+'</td>'
				+'<td  name="tempOutCause">'+f[2].value.toString()+'</td>'
				+'<td id="returnTime" name="returnTime">'+f[3].value.toString()+'</td>'
				+'<td id="principal" name="principal">'+f[4].value.toString()+'</td></tr>';
				alert("hang:"+hang);
				$("#out").append(hang);
				serial++;
				$(':input','#newOrder').not(':button,:submit,:reset,:hidden').val('').removeAttr('checked') .removeAttr('checked')
				
				$('#newOrder').dialog('close');
			}	
	});
	//提交最终离区表单
	$('#register').form({
		url:'finallyLeave/SaveInforCollection',
		success:function(data){
			alert("提交成功！");
		}	
	});
	</script>
</body>


</html>
