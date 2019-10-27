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
<title>档案管理</title>
<link rel="stylesheet" href="css/style.css" />
<link href="bootstrap/plus/datatime/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<!-- bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="bootstrap/plus/table/bootstrap-table.min.css">
<!-- jq -->
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
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


<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />

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


	<div class="right-nr">
		<div class="dqqxyr">
			<h3>在区嫌疑人</h3>
			<div class="xyr-nav" id="currentSuspects">
				<!-- 
				<div class="dqqnr">
					<p class="dqqtext1">羁押时长：7小时36分</p>
					<div class="lolonr">
						<ul class="lolonr-l">
							<img src="images/jy-pic.jpg" alt="">
						</ul>
						<ul class="lolonr-r">
							<li>王小燕</li>
							<li>女</li>
							<li>42岁</li>
						</ul>
					</div>
				</div> -->

			</div>
		</div>
		<div class="xyrlb">
			<h3>嫌疑人列表</h3>
		</div>
		<form id="search_form" name="search_form" method="post">
			<div class="search">
				<input type="" name="" placeholder="只能输入嫌疑人姓名或者证件号"> <a
					class="search-btn1"><img src="images/search.png"></a>
			</div>
		</form>
		<form id="search-erj_form" name="search-erj_form" method="post">
			<div class="search-erj">
				<div class="yilanbiao">
					<span>入区原因：</span> <select name="causeCode" id="causeCode"
						style="width: 150px; height: 30px; font-size: 20px; border: 1px solid teal"></select>
					<span>离区原因：</span> <select name="tempOutCause" id="tempOutCause"
						style="width: 150px; height: 30px; font-size: 20px; border: 1px solid teal"></select>
					<span>入区时间：</span> <input name="entryTime" id="entryTime"
						style="width: 150px; height: 30px; font-size: 20px; border: 1px solid teal"
						class="easyui-datebox">
				</div>
				<a id="searchCondition" class="search-btn2">查找</a>
			</div>
		</form>
	</div>
	<div class="xyrlb">
		<table id="archivesTab"></table>
	</div>

</body>

<script type="text/javascript">
				$('#searchCondition').click(function(){
					console.log(1111);
					var causeCode=$('#causeCode').combobox('getValue');
					var tempOutCause=$('#tempOutCause').combobox('getValue');
					var entryTime=$('#entryTime').combobox('getValue');
					console.log(causeCode+":"+tempOutCause+":"+entryTime);
					var opt = {
					        url: "archivesManagement/getCurrentSuspectsList",
					        silent: true,
					        query:{
					        	causeCode:causeCode,
					        	tempOutCause:tempOutCause,
					        	entryTime:entryTime
					            
					        }
					    };
					$('#archivesTab').bootstrapTable('refresh', opt)
				       
				});
	
	
	
				/* 打开页面就加载当前办案区的嫌疑人 */
				 $(document).ready(function(){
					 /* 入区原因 */
					 $("#causeCode").combobox({  
					        url : 'infoHeader/getListByCodeName?codeName=causeCode',
					        valueField:'code',   
					        textField:'name'  
					   	});
					 /* 离区事由 */
					 $("#tempOutCause").combobox({  
					        url : 'infoHeader/getListByCodeName?codeName=leaveCause',
					        valueField:'code',   
					        textField:'name'  
					   	});
					 var currentime = new Date().toLocaleString();//当前时间
					 console.log(currentime);
					 $.ajax({
						    type: "POST",
						    url: "archivesManagement/getCurrentSuspects",
						    dataType:'json',
						    success: function (data) {
						    	$("#checkHouRoom").empty();//先清空div
						    	for(var i=0;i<data.length;i++){
						    		
						    		var date1 = new Date(currentime);
						    		var date2 = new Date(data[i].entryTime);
						    		
						    		var s1 = date1.getTime(),s2 = date2.getTime();
						    		var total = (s1 - s2)/1000;
						    		var day = parseInt(total / (24*60*60));//计算整数天数
						    		var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
						    		var hour = parseInt(afterDay/(60*60));//计算整数小时数
						    		var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
						    		var min = parseInt(afterHour/60);//计算整数分
						    		var afterMin = total - day*24*60*60 - hour*60*60 - min*60;//取得算出分后剩余的秒数
						    		
									var div='<div class="dqqnr">'
										+'<p class="dqqtext1">羁押时长：'+hour+'小时'+min+'分</p>'
										+'<div class="lolonr">'
											+'<ul class="lolonr-l">'
												+'<img src="'+data[i].frontalView+'" width="50"  height="50">'
											+'</ul>'
											+'<ul class="lolonr-r">'
												+'<li>'+data[i].name+'</li>'
												+'<li>'+data[i].sex+'</li>'
												+'<li>'+data[i].nation+'</li>'
											+'</ul>'
										+'</div>'
									+'</div>'
									$("#currentSuspects").append(div);
								} 
						    	
						    }
						  });
						//bootstrap表格插件
						$('#archivesTab').bootstrapTable({
					        method: 'post',
					        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
					        url: 'archivesManagement/getCurrentSuspectsList',//要请求数据的文件路径
					        striped: true, //是否显示行间隔色
					        dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
					        pageNumber: 1, //初始化加载第一页，默认第一页
					        pagination:true,//是否分页
							queryParamsType:'',                               
					    	queryParams:queryParams,//请求服务器时所传的参数
					       	sidePagination:'server',//指定服务器端分页
					        pageSize:2,//单页记录数
					        pageList:[2,5,10,15],//分页步进值
					        showRefresh:false,//刷新按钮
					        showColumns:false,
					        columns:[{  
		                        field: 'Number',//可不加  
		                        title: '序号',//标题  可不加  
		                        formatter: function (value, row, index) {  
		                            return index+1;  
		                        }  
		                    	},
								 {
		                    		field: 'operate',
		                    		title: '嫌疑人姓名',
	                    			align: 'center',
	                			    formatter:function(value,row,index){
	                				    var element = 
	                				    "<a id='"+row.recordNumber +"' onclick='RecordDetail(id)'>"+row.name+"</a> "
	                				    return element;  
	                				} 
								 },
								 {field: 'IDNumber',title: '证件号'},
								 {field: 'caseName',title: '案件名称' },
								 {field: 'entryCasue',title: '入区事由' },
								 {field: 'outCasue',title: '出区原因' },
								 {field: 'busPolice',title: '业务干警' },
								 
					        ],
					        locale:'zh-CN'//中文支持,
					    })
					    function queryParams(params){
					        return{
					        	//每页多少条数据
					            pageSize: params.pageSize,
					            //请求第几页
					            pageNumber:params.pageNumber,
					        } 
					    }
				}); 
				 function RecordDetail(id){
					 window.open("archivesManagement/showRecordReport?recordNumber="+id);      
				}
</script>
</html>