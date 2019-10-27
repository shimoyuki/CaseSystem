<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=basePath%>>

<title>临时离区</title>
<link rel="stylesheet" href="css/style.css" />
<!-- bootstrap -->
<link rel="stylesheet"
	href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="bootstrap/plus/table/bootstrap-table.min.css">
	<!-- jq -->
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />
<script type="text/javascript"
	src="bootstrap/js/bootstrap.min.js"></script>

<!-- 分页插件 -->

<script type="text/javascript"
	src="bootstrap/plus/table/bootstrap-table.min.js"></script>
<script type="text/javascript"
	src="bootstrap/plus/table/bootstrap-table-locale-all.min.js"></script>
<script type="text/javascript"
	src="bootstrap/plus/table/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>

<meta http-equiv="Content-Type" content="application/msword">
</head>
<body>

		<div class="right-nr">

					<div class="lqzt">
						
					</div>
					<div class="lscqxx">
						<h3>临时出区人员概要信息</h3>
						<div class="lscqxx-l">
							<ul>
								<li><div class="tpwz5">
								<div class="rwxx02">
									<table class="sf-infor02">
										<tr>
											<td class="t-l">姓名</td>
											<td><input type="text" class="inp-name"  name="name" id="name" readonly="readonly" /></td>
										</tr>
										<tr>
											<td class="t-l">姓别</td>
											<td>
												<input type="text" class="inp-sex" name="sex" id="sex" readonly="readonly" />
												<span>民 族</span>
												<input type="text" class="inp-sex" name="nation" id="nation" readonly="readonly" />
											</td>
										</tr>
										<tr>
											<td class="t-l">出生</td>
											<td>
												<input type="text" class="inp-date01"  name="birthday"  id="birthday" readonly="readonly" />
											</td>
										</tr>
										<tr>
											<td class="t-l">住址</td>
											<td>
												<input type="text" class="inp-address" name="address" id="address" readonly="readonly" />
											</td>
										</tr>
									</table>
									<div class="sfz-tx02">
										<img src="images/tx-img-02.jpg" id="IDPicture" />
									</div>
								</div>
								<div class="sfz-num02">
									<span>公民身份号码</span>
									<input type="text" class="inp-num" name="IDCode"  id="IDCode" readonly="readonly" />
								</div>
							</div></li>
								<li><img src="images/pic-1.jpg" id="leftView" name="leftView"  width="100%"  height="100%"></li>
								<li><img src="images/pic-1.jpg" id="frontalView" name="frontalView"  width="100%"  height="100%"></li>
								<li><img src="images/pic-1.jpg" id="rightView" name="rightView"  width="100%"  height="100%"></li>
							</ul>
						</div>
						<div class="lscqxx-r">
							<table>
								<tr>
									<td colspan="2">档案编号： <span><input id="recordNumber" name="recordNumber" style="width: 120px; border:none;"readonly="readonly" ></span>
									入区时间：<span><input id="entryTime"name="entryTime" style="width: 100px;border:none;"readonly="readonly"></span></td>
									
								</tr>
								<tr>
									<td colspan="2">入区身份：<span><input id="personType"name="personType" style="width: 80px;border:none;" readonly="readonly"></span>
									手环：<span><input id="recognition"name="recognition" style="width: 80px;border:none;" readonly="readonly"></span>
									入区原因：<span><input id="causeCode"name="causeCode" style="width: 80px;border:none;"readonly="readonly"></span></td>
								</tr>
								<tr>
									<td colspan="2">联系方式：<span><input id="telephone"name="telephone" style="width: 150px;border:none;"readonly="readonly"></span>
									现住址：<span><input id="currentAddr"name="currentAddr" style="width: 150px;border:none;"readonly="readonly"></span></td>
									
								</tr>
							</table>
						</div>
					</div>
				<form id="temoutForm" method="post" class="form-horizontal" action="tempOut/saveTempOut"  onsubmit="return sumbit_sure()" enctype="multipart/form-data">
					<!-- 用于传值参数档案号 -->
					<input id="recordNumberForm" name="recordNumber" style="display:none">
					<div class="lssy">
						<h3>临时出区事由填写:</h3>
						<p class="ls-text">离区事由：<select name="tempOutCause" id="tempOutCause" style="width:100px;height:20px;font-size:13px;border:1px solid teal">
    </select><span>离区时间： <i><input id="tempOutTime"name="tempOutTime" style="width: 100px;"></i>    *离区原因备注信息：</span></p>
						<textarea name="detail"></textarea>
						<div class="mjjy" id="tempoutPolice">
							<ul>
								<li>办案民警：<input id="tempoutPolice" name="tempoutPolice" style="width: 120px;height:25px;"></li>
								<li>警员编号：<input id="code" name="code" style="width: 120px;height:25px;"></li>
							</ul>
						</div>
					
					</div>
					<div class="btn-ls02">
							<a  onclick="addOrder()">增加</a>
							<a onclick="deleteOrder()">删除</a>
							<a onclick="saveTemout()" style="margin:0;">保存</a>
					</div>
				</form>
					<div class="lszkb">
						<h3>临时出区情况表</h3>
							<table  id="mytab"></table>
					</div>
					
				</div>
</body>
<script type="text/javascript">

	 $(document).ready(function(){
		 $("#tempOutCause").combobox({  
		        url : 'infoHeader/getListByCodeName?codeName=tempOutCause',
		        valueField:'code',   
		        textField:'name'  
		   	});
		 $.ajax({
			    type: "POST",
			    url: "infoHeader/searchBaseInfo",
			    data: {"recognition":"8087"},
			    success: function (msg) {
			    	
			     $("#name").val(msg.name);
			     $("#sex").val(msg.sex);
			     $("#nation").val(msg.nation);
			     $("#birthday").val(msg.birthday);
			     $("#address").val(msg.address);
			     $("#IDCode").val(msg.IDCode);
			     $("#leftView").attr('src',msg.leftView);
			     $("#frontalView").attr('src',msg.frontalView);
			     $("#rightView").attr('src',msg.rightView);
			     $("#IDPicture").attr('src',msg.IDPicture);
			     $("#recordNumber").val(msg.recordNumber);
			     $("#entryTime").val(msg.entryTime);
			     $("#personType").val(msg.personType);
			     $("#recognition").val(msg.recognition);
			     $("#causeCode").val(msg.causeCode);
			     $("#telephone").val(msg.telephone);
			     $("#currentAddr").val(msg.currentAddr);
			     $("#recordNumberForm").val(msg.recordNumber);
			     $('#mytab').bootstrapTable('refresh', {url: 'tempOut/getTempOutbyRemb'});
			    },
			    error: function (error) {
			      easyuiAlert(error);
			    }
			  });
	}); 

	function addOrder(){//增加业务干警签名输入框
		var ul="<ul><li>业务干警：<input  name='tempoutPolice' style='width: 120px;height:25px;'></li>"
		+"<li>警员编号：<input name='code'style='width: 120px;height:25px;'></li></ul>";
		$("#tempoutPolice").append(ul);
	}
	function deleteOrder(){//删除业务干警签名输入框
		var Child =document.getElementById('tempoutPolice').lastChild;
		document.getElementById('tempoutPolice').removeChild(Child);
	}
	function saveTemout(){//保存临时出区
		 $.ajax({  
			    type: "POST",  
			    url:'tempOut/saveTempOut',  
			    data:$('#temoutForm').serialize(),  
			    error: function(request) {  
			        alert("Connection error");  
			    },  
			    success: function(data) {  
			    	$(':input','#temoutForm').not(':button, :submit, :reset, :hidden').val('') 
			    	.removeAttr('checked') .removeAttr('selected');//清空form表单 
		 			$('#mytab').bootstrapTable('refresh', {url: 'tempOut/getTempOutbyRemb'});//重新加载table.
			    }  
		 });
	}
	//bootstrap表格插件
	$('#mytab').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        //url: 'tempOut/getTempOutbyRemb',//要请求数据的文件路径
        striped: true, //是否显示行间隔色
        dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination:true,//是否分页
        //queryParamsType:'limit',//查询参数组织方式
        //【查询设置】
						/* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			                              设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
		queryParamsType:'',                               
    	queryParams:queryParams,//请求服务器时所传的参数
       	sidePagination:'server',//指定服务器端分页
        pageSize:2,//单页记录数
        pageList:[2,5,10,15],//分页步进值
        showRefresh:false,//刷新按钮
        showColumns:false,
        columns:[
        	{field: 'tempOutTime',title: '离区时间'},  
			 {field: 'tempOutCause',title: '离区事由'},
			 {field: 'returnTime',title: '返回时间'},
			 {field: 'detail',title: '办案民警' }
        ],
        locale:'zh-CN'//中文支持,
       /*  responseHandler:function(rows){
            //在ajax获取到数据，渲染表格之前，修改数据源
            return rows;
        } */
    })
	    //请求服务数据时所传参数
    function queryParams(params){
        return{
        	//每页多少条数据
            pageSize: params.pageSize,
            //请求第几页
            pageNumber:params.pageNumber,
            recordNumber:$("#recordNumberForm").val()
         
        } 
    }
    //三个参数，value代表该列的值
    function operateFormatter(value,row,index){
        if(value==2){
            return '<i class="fa fa-lock" style="color:red"></i>'
        }else if(value==1){
            return '<i class="fa fa-unlock" style="color:green"></i>'
        }else{
            return '数据错误'
        }
    }
	
</script>
</html>
