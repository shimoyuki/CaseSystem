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
<title>bootstrap-table</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/bootstrap-table.min.css" rel="stylesheet"> 
<script type="text/javascript"
	src="/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript"
	src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-table.min.js"></script>
<script src="/js/bootstrap-table-zh-CN.js"></script>
<meta http-equiv="Content-Type" content="application/msword">
</head>

<body>
				<div class="panel panel-default">
		    <div class="panel-heading">
		        查询条件
		    </div>
		    <div class="panel-body form-group" style="margin-bottom:0px;">
		        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">姓名：</label>
		        <div class="col-sm-2">
		            <input type="text" class="form-control" name="Name" id="search_name"/>
		        </div>
		        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">手机号：</label>
		        <div class="col-sm-2">
		            <input type="text" class="form-control" name="Name" id="search_tel"/>
		        </div>
		        <div class="col-sm-1 col-sm-offset-4">
		            <button class="btn btn-primary" id="search_btn">查询</button>
		        </div>
		     </div>
		</div>
		<table id="mytab" class="table table-hover"></table>
		<div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
		     <button id="btn_edit" type="button" class="btn btn-default" style="display: none; border-radius: 0">
		         <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>修改
		     </button>
		      <button id="btn_delete" type="button" class="btn btn-default" style="display: none;">
		          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
		      </button>
		      <button id="btn_add" type="button" class="btn btn-default">
		          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		      </button>
		 </div>
	</body>
	<script type="text/javascript">
	
	//根据窗口调整表格高度
    $(window).resize(function() {
        $('#mytab').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
//生成用户数据
    $('#mytab').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        /* url:"../index.php/admin/index/userManagement",//要请求数据的文件路径 */
        height:tableHeight(),//高度调整
        toolbar: '#toolbar',//指定工具栏
        striped: true, //是否显示行间隔色
        dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination:true,//是否分页
        queryParamsType:'limit',//查询参数组织方式
        queryParams:queryParams,//请求服务器时所传的参数
        sidePagination:'server',//指定服务器端分页
        pageSize:10,//单页记录数
        pageList:[5,10,20,30],//分页步进值
        showRefresh:true,//刷新按钮
        showColumns:true,
        clickToSelect: true,//是否启用点击选中行
        toolbarAlign:'right',//工具栏对齐方式
       buttonsAlign:'right',//按钮对齐方式
      toolbar:'#toolbar',//指定工作栏
        columns:[
            {
                title:'全选',
                field:'select',
                //复选框
                checkbox:true,
                width:25,
                align:'center',
                valign:'middle'
            },
            {
                title:'ID',
                field:'ID',
                visible:false
            },
            {
                title:'登录名',
                field:'LoginName',
                sortable:true
            },
            {
                title:'姓名',
                field:'Name',
                sortable:true
            },
            {
                title:'手机号',
                field:'Tel',
            },
            {
                title:'邮箱',
                field:'Email'
            },
            {
                title:'注册日期',
                field:'CreateTime',
                sortable:true
            },
            {
                title:'状态',
                field:'Attribute',
                align:'center',
                //列数据格式化
                formatter:operateFormatter
            }
        ],
        locale:'zh-CN',//中文支持,
        responseHandler:function(res){
            //在ajax获取到数据，渲染表格之前，修改数据源
            return res;
        }
    })
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

    //请求服务数据时所传参数
    function queryParams(params){
        return{
            //每页多少条数据
            pageSize: params.limit,
            //请求第几页
            pageIndex:params.pageNumber,
            Name:$('#search_name').val(),
            Tel:$('#search_tel').val()
        }
    }
     //查询按钮事件
    $('#search_btn').click(function(){
        $('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
    })
	
	</script>
</html>