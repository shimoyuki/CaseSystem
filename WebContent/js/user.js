$(function(){


	$('#tt').datagrid({
		url:'user/getUserList',
		toolbar:'#tb',
		pagination:true,
		rownumbers:false,//行号
		striped:false,//奇偶行颜色区分
		title:'用户列表',
		fitColumns:false,//列自适应
		iconCls:'icon-save',
		singleSelect:true,
		queryParams:{"sortName":"","sortOrder":""},
		remoteSort:true,//允许服务器端排序
		/*	这个也可以不写
		 * onSortColumn:function (sort,order){
			alert("onSortColumn!");
			//排序方法
			var queryParams = $('#tt').datagrid('options').queryParams;
			queryParams.sortName = sort;
			queryParams.sortOrder = order;
			$('#tt').datagrid('reload');
		},*/
		pagePosition:'bottom',//分页栏位置 both 上下 bottom、top
		pageList:[2,5,10,15]
	});


	$('#newUser_form').form({
		url:'user/saveUser',
		onSubmit:function(){
			if($(this).form('validate')){
				$.messager.progress({
					title:'稍等',
					msg:'正在操作中...',
					text: '操作中'
				});
				return true;
			}else{
				return false;
			}
		},
		success:function(data){
			$.messager.progress('close');
			if(data==true||data=='true'){
				$.messager.alert('消息','操作成功','info',function(){
					$('#newUser').dialog('close');
					$('#newUser_form').form('clear');
					$('#tt').datagrid('reload');
				});
			}else{
				$.messager.alert('消息','操作失败','error');
			}
		}		
	});




	$('#editUser_form').form({
		url:'user/updateUser',
		onSubmit:function(){
			if($(this).form('validate')){
				$.messager.progress({
					title:'稍等',
					msg:'正在操作中...',
					text: '操作中'
				});
				return true;
			}else{
				return false;
			}
		},
		success:function(data){
			$.messager.progress('close');
			if(data==true||data=='true'){
				$.messager.alert('消息','操作成功','info',function(){
					$('#editUser').dialog('close');
					$('#editUser_form').form('clear');
					$('#tt').datagrid('reload');
				});
			}else{
				$.messager.alert('消息','操作失败','error');
			}
		}		
	});

});

function addUser(){
	$('#newUser').dialog('open');
	return true;
}


function editUser(){
	var row = $('#tt').datagrid('getSelected');
	if (row){
		document.getElementById("editUserID").value=row.id;
		$("#editUserPass").textbox('setValue',row.pass);
		$("#editUserName").textbox('setValue',row.name);
		$('#editUser').dialog('open');
	} else{
		$.messager.alert("操作提示", "请选择要修改的用户","error");
	}

	return true;
}
function deleteUser(){
	var row = $('#tt').datagrid('getSelected');
	if (row){
		$.messager.confirm('操作提示', '是否要删除数据?', function (r) {
			if (r) {
				$.post('user/deleteUser', { 'id': row.id }, function (data) {
					if(data==true||data=='true'){
						$('#tt').datagrid('reload');  
						$.messager.alert("操作提示", "操作成功","info");
					} else {
						$.messager.show({   // show error message 
							title: 'info',
							msg: '删除失败'
						});
					}
				});
			} 
		});

	} else{
		$.messager.alert("操作提示", "请选择要修改的用户","error");
	}

	return true;
}



function newUser_cancel()
{
	$(".panel-tool-close").click();
	$('#newUser_form').form('clear');
}



function editUser_cancel()
{
	$(".panel-tool-close").click();
	$('#editUser_form').form('clear');
}

function initCharge( value){
	if(value=='0'||value==0){
		return '否';
	}else{
		return '是';
	}
}
