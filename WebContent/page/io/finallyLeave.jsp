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
<title>最终离区</title>
<link rel="stylesheet" href="css/style.css" />



<!-- bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/plus/table/bootstrap-table.min.css">
<!-- jq -->
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<!-- 分页插件 -->

<script type="text/javascript" src="bootstrap/plus/table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="bootstrap/plus/table/bootstrap-table-locale-all.min.js"></script>


</head>
<body>

	<div class="right-nr">
		<div class="hdjlb">
			<h3>活动记录表</h3>
			<table class="table table-striped table-bordered table-hover"
				id="activitylLog"></table>
		</div>
		<div class="hdjlb">
			<h3>随身物品</h3>
			<table class="table table-striped table-bordered table-hover"
				id="goodsRegister"></table>
			<table class="hdjlb-tb1">
				<tr>
					<td>领取人签字： <input></td>
					<td>领取人身份证号码： <span>142333558877889968</span></td>
					<td>领取时间： <span>2017-05-20 11:25:36</span></td>
				</tr>
			</table>
		</div>
		<div class="qrqz2">
			<h3>签字确认</h3>
			<table>
				<tr>
					<td>管理员签字：<span>王麻子</span></td>
					<td>时间：<span>2017-05-20 12:00:00</span></td>
				</tr>
			</table>
		</div>
		<div class="btn-ls">
			<a href="">确定</a>
		</div>
	</div>

	<script type="text/javascript">
			
			$('#activitylLog').bootstrapTable({
		        method: 'post',
		        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
		        url:"../index.php/admin/index/userManagement",//要请求数据的文件路径
		        striped: true, //是否显示行间隔色
		       // toolbar: '#toolbar',//指定工具栏
		        dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
		        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
		        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
		        pageNumber: 1, //初始化加载第一页，默认第一页
		        pagination:true,//是否分页
		        queryParamsType:'limit',//查询参数组织方式
		       // queryParams:queryParams,//请求服务器时所传的参数
		        sidePagination:'server',//指定服务器端分页
		        pageSize:10,//单页记录数
		        pageList:[5,10,20,30],//分页步进值
		        showRefresh:false,//刷新按钮
		        showColumns:false,
/* 		        toolbarAlign:'right',//工具栏对齐方式
		        buttonsAlign:'right',//按钮对齐方式 */
		        columns:[
		           /*  {
		                title:'全选',
		                field:'select',
		                //复选框
		                checkbox:true,
		                width:25,
		                align:'center',
		                valign:'middle'
		            }, */
		            {
		                title:'ID',
		                field:'序号',
		               // visible:false
		            },
		            {
		                title:'活动项目',
		                field:'LoginName',
		            },
		            {
		                title:'房间',
		                field:'Name',
		               // sortable:true
		            },
		            {
		                title:'进入时间',
		                field:'Tel',
		            },
		            {
		                title:'离开时间',
		                field:'Email'
		            },
		            {
		                title:'内容记录',
		                field:'CreateTime',
		            },
		            {
		                title:'音视频编码',
		                field:'CreateTime',
		            },
		            {
		                title:'备注',
		                field:'CreateTime',
		                editable : true,
		            },
		           /*  {
		                title:'状态',
		                field:'Attribute',
		                align:'center',
		                //列数据格式化
		                formatter:operateFormatter
		            } */
		        ],
		        locale:'zh-CN',//中文支持,
		        responseHandler:function(res){
		            //在ajax获取到数据，渲染表格之前，修改数据源
		            return res;
		        }
		    })
			 
			 $('#goodsRegister').bootstrapTable({
			        method: 'post',
			        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
			        url:"../index.php/admin/index/userManagement",//要请求数据的文件路径
			        striped: true, //是否显示行间隔色
			        dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
			        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
			        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
			        pageNumber: 1, //初始化加载第一页，默认第一页
			        pagination:true,//是否分页
			        queryParamsType:'limit',//查询参数组织方式
			       // queryParams:queryParams,//请求服务器时所传的参数
			        sidePagination:'server',//指定服务器端分页
			        pageSize:10,//单页记录数
			        pageList:[5,10,20,30],//分页步进值
			        showRefresh:false,//刷新按钮
			        showColumns:false,
			        columns:[
			           /*  {
			                title:'全选',
			                field:'select',
			                //复选框
			                checkbox:true,
			                width:25,
			                align:'center',
			                valign:'middle'
			            }, */
			            {
			                title:'ID',
			                field:'序号',
			               // visible:false
			            },
			            {
			                title:'财物分类',
			                field:'LoginName',
			            },
			            {
			                title:'数量',
			                field:'Name',
			               // sortable:true
			            },
			            {
			                title:'查看详情',
			                field:'Tel',
			            },
			            {
			                title:'返还状态',
			                field:'Email'
			            },
			           /*  {
			                title:'状态',
			                field:'Attribute',
			                align:'center',
			                //列数据格式化
			                formatter:operateFormatter
			            } */
			        ],
			        locale:'zh-CN',//中文支持,
			        responseHandler:function(res){
			            //在ajax获取到数据，渲染表格之前，修改数据源
			            return res;
			        }
			    })
		</script>
</body>
</html>