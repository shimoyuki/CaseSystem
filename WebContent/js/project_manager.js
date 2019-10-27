$(function(){


	$('#tt').datagrid({
		url:'project/getProjectList',
		toolbar:'#tb',
		pagination:true,
		title:'项目列表',
		iconCls:'icon-save',
		singleSelect:true,
		pageList:[2,5,10,15]
	});




});


function scanFiles(){

	$.messager.confirm('操作提示', '是否要扫描并更新数据?', function (r) {
		if (r) {
			$.post('project/updateProjectList', {  }, function (data) {
				if(data==true||data=='true'){
					$('#tt').datagrid('reload');  
					$.messager.alert("操作提示", "操作成功","info");
				} else {
					$.messager.show({   // show error message 
						title: 'info',
						msg: '更新失败'
					});
				}
			});
		} 
	});


	return true;
}