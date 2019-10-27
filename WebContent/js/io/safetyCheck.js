function ScarDetail(coorDinate, scarDescribe, recordNumber) {
	ScarDetail.coorDinate = coorDinate;//伤痕位置
	ScarDetail.scarDescribe = scarDescribe;//伤痕描述
	ScarDetail.recordNumber = recordNumber;//档案号
	ScarDetail.img = img;//伤痕附件
}
var ScarDetail = new Object();

var myArray = new Array();
function copyText(id) {
	var obj = window.document.getElementById(id);
	ScarDetail.coorDinate = obj.innerHTML;

	var bg = obj.style.backgroundColor;
	if (bg == '') {
		var tableID = obj.parentNode.parentNode.parentNode.id;//根据tdID获取tableID
		GetInfoFromTable();
//		var tableObj = document.getElementById(tableID);
//		for (var i = 0; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
//			for (var j = 0; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
//				tableObj.rows[i].cells[j].style.backgroundColor = '';   //获取Table中单元格的背景颜色
//			}
//		}
		obj.style.backgroundColor = '#f00'
		document.getElementById('sh').value = obj.innerHTML+"号伤情描述:";
	} else {
		obj.style.backgroundColor = ''
		document.getElementById('sh').value = "";
	}
}

function SaveScarTreatment() {
	console.log(111);
	ScarDetail.scarDescribe = document.getElementById('sh').value;
	ScarDetail.img = document.getElementById('img').value;
	ScarDetail.recordNumber = 12345;//这个是档案号
	myArray.push(ScarDetail);
	$.ajax({
		type : "POST",
		url : 'safetyCheck/saveScarTreatment',
		data:ScarDetail,
		success : function(data) {
			document.getElementById('sh').value = "";
			GetInfoFromTable();
		}
	});
}
//获取单元格哪些的颜色是红色，便于保存后去掉颜色。
function GetInfoFromTable() {
	var tableObj = document.getElementById('table1');
	for (var i = 0; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
		for (var j = 0; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
			tableObj.rows[i].cells[j].style.backgroundColor = '';   //获取Table中单元格的背景颜色
		}
	}
	var tableObj = document.getElementById('table2');
	for (var i = 0; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
		for (var j = 0; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
			tableObj.rows[i].cells[j].style.backgroundColor = '';   //获取Table中单元格的背景颜色
		}
	}
	var tableObj = document.getElementById('table3');
	for (var i = 0; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
		for (var j = 0; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
			tableObj.rows[i].cells[j].style.backgroundColor = '';   //获取Table中单元格的背景颜色
		}
	}
}


$(function(){
	$('#tt').datagrid({
		url:'safetyCheck/getGoodsList',
		toolbar:'#tb',
		pagination:false,
		rownumbers:false,//行号
		striped:false,//奇偶行颜色区分
		fitColumns:false,//列自适应
		iconCls:'icon-save',
		singleSelect:true,
	});
	$('#newGoods_form').form({
		url:'safetyCheck/saveHisBelongings',
//		onSubmit:function(){
//			if($(this).form('validate')){
//				$.messager.progress({
//					title:'稍等',
//					msg:'正在操作中...',
//					text: '操作中'
//				});
//				return true;
//			}else{
//				return false;
//			}
//		},
		success:function(data){
			$.messager.progress('close');
			if(data==true||data=='true'){
				$.messager.alert('消息','操作成功','info',function(){
					$('#newGoods').dialog('close');
					$('#newGoods_form').form('clear');
					$('#tt').datagrid('reload');
				});
			}else{
				$.messager.alert('消息','操作失败','error');
			}
		}		
	});
	
	$('#safetyCheck_form').form({
		url:'safetyCheck/saveSafetyCheckInfo',
		success:function(data){
			
		}
	});
});

function addGoods(){
	$('#newGoods').dialog('open');
	return true;
}


var image = '';
function selectImage(file){
if(!file.files || !file.files[0]){
	return;
}
var reader = new FileReader();
reader.onload = function(evt){
	 $("#img").attr("value",evt.target.result);
document.getElementById('mm').src = evt.target.result;
image = evt.target.result;
}
reader.readAsDataURL(file.files[0]);
}

function newGoods_cancel()
{
	$(".panel-tool-close").click();
	$('#newGoods_form').form('clear');
}


/*//随身物品登记：
function createTable() {

	//创建表 
	var setTable = document.createElement("table");
	//设置表的属性
	setTable.setAttribute('border', '1');
	setTable.setAttribute('id','tableid');
	setTable.setAttribute('cellpadding','0');
	setTable.setAttribute('cellspacing','0');
	setTable.setAttribute('width','800px');
	
	var tbody = document.createElement("tbody");
	//创建行
	var tr = document.createElement("tr");

	//创建单元格
	var td1 = document.createElement("td");
	//设置单元格的内容
	var cellContent1 = document.createTextNode("编号");
	
	var td2 = document.createElement("td");
	var cellContent2 = document.createTextNode("物品名称以及特征 ");
	
	var td3 = document.createElement("td");
	var cellContent3 = document.createTextNode("编号");
	
	var td4 = document.createElement("td");
	var cellContent4 = document.createTextNode("数量");
	
	var td5 = document.createElement("td");
	var cellContent5 = document.createTextNode("单位");
	
	var td6 = document.createElement("td");
	var cellContent6 = document.createTextNode("保管措施");
	
	var td7 = document.createElement("td");
	var cellContent7 = document.createTextNode("保管柜号");
	
	var td8 = document.createElement("td");
	var cellContent8 = document.createTextNode("物品属性");
	
	var td9 = document.createElement("td");
	var cellContent9 = document.createTextNode("操作");
	
	
	td1.appendChild(cellContent1);
	tr.appendChild(td1);
	tbody.appendChild(tr);

	td2.appendChild(cellContent2);
	tr.appendChild(td2);
	tbody.appendChild(tr);

	td3.appendChild(cellContent3);
	tr.appendChild(td3);
	tbody.appendChild(tr);

	td4.appendChild(cellContent4);
	tr.appendChild(td4);
	tbody.appendChild(tr);

	td5.appendChild(cellContent5);
	tr.appendChild(td5);
	tbody.appendChild(tr);

	td6.appendChild(cellContent6);
	tr.appendChild(td6);
	tbody.appendChild(tr);
	
	td7.appendChild(cellContent7);
	tr.appendChild(td7);
	tbody.appendChild(tr);
	
	td8.appendChild(cellContent8);
	tr.appendChild(td8);
	tbody.appendChild(tr);
	
	td9.appendChild(cellContent9);
	tr.appendChild(td9);
	tbody.appendChild(tr);

	
	setTable.appendChild(tbody);

	//创建新增按钮
	var button = document.createElement("input");
	button.type="button";
	button.value="新增";
	button.id="addBtn";
	button.onclick=function(){
		trdadd();
	}
	document.getElementById("tableDiv").appendChild(button);
	document.getElementById("tableDiv").appendChild(setTable);

	//初始化全局变量table
	table = document.getElementById("tableid");
	
	*//****************
	  form表单
	****************//*

	//创建form表单
	var form = document.createElement("form");
	form.setAttribute("id", "formid");

	//创建table
	var createFormTable = document.createElement("table");
	createFormTable.setAttribute("id", "aaid");

	var form_table_tbody = document.createElement("tbody");
	
	var form_table_tr1 = document.createElement("tr");
	var form_table_tr2 = document.createElement("tr");

	//单元格
	var form_table_td1 = document.createElement("td");
	form_table_td1.setAttribute("colspan", "6");
	
	var form_table_td2 = document.createElement("td");
	form_table_td2.setAttribute("colspan", "6");
	
	var form_table_td5 = document.createElement("td");
	form_table_td2.setAttribute("colspan", "6");
	var form_table_td6 = document.createElement("td");
	form_table_td2.setAttribute("colspan", "6");
	var form_table_td7 = document.createElement("td");
	form_table_td2.setAttribute("colspan", "6");

	//单元格内容
	var form_table_td1_text = document.createTextNode("物品名称以及特征：");
	var form_table_td2_text = document.createTextNode("编号：");
	
	
	var form_table_td5_text = document.createTextNode("数量：");
	var form_table_td6_text = document.createTextNode("单位：");
	var form_table_td7_text = document.createTextNode("保管措施：");

	//创建标题文本框
    var text1 = document.createElement("input");
    text1.type="text";
    text1.id="aid";
    text1.size="30";
    
    var text5 = document.createElement("input");
    text5.type="text";
    text5.id="xid";
    text5.size="30";
    var text6 = document.createElement("input");
    text6.type="text";
    text6.id="yid";
    text6.size="30";
    var text7 = document.createElement("input");
    text7.type="text";
    text7.id="zid";
    text7.size="30";

    //创建摘要文本框
    var text2 = document.createElement("input");
    text2.type="text";
    text2.id="bid";
    text2.size="30";

    form_table_td1.appendChild(form_table_td1_text);
    form_table_td1.appendChild(text1);
    form_table_tr1.appendChild(form_table_td1);
    form_table_tbody.appendChild(form_table_tr1);

    form_table_td2.appendChild(form_table_td2_text);
    form_table_td2.appendChild(text2);
    form_table_tr1.appendChild(form_table_td2);
    form_table_tbody.appendChild(form_table_tr1);


    //单元格
	var form_table_td3 = document.createElement("td");
	form_table_td3.setAttribute("colspan", "6");
	
	var form_table_td4 = document.createElement("td");
	form_table_td4.setAttribute("colspan", "6");

	//单元格内容
	var form_table_td3_text = document.createTextNode("保管柜号：");
	var form_table_td4_text = document.createTextNode("物品属性：");

	//创建作者文本框
    var text3 = document.createElement("input");
    text3.type="text";
    text3.id="cid";
    text3.size="30";

    //创建下拉框
    var select = document.createElement("select");
    select.id="eid";
    select.name="myname";

    //创建下拉框option
    var option1 = document.createElement("option");
    option1.value="1";

    var option2 = document.createElement("option");
    option1.value="2";

    var option3 = document.createElement("option");
    option1.value="3";

    //下拉框显示的值
    var value1 = document.createTextNode("随身财物");
    var value2 = document.createTextNode("涉案物品");
    var value3 = document.createTextNode("违禁物品");


    //save按钮
    var buttonSave = document.createElement("input");
    buttonSave.type="button";
    buttonSave.value="保存";
    buttonSave.id="saveBtn";
    buttonSave.onclick=function(){
		baocun();
	}
	
    //reset按钮
	var buttonReset = document.createElement("input");
	buttonReset.type="reset";
	buttonReset.value="重置";
	buttonReset.id="resetBtn";
	buttonReset.onclick=function(){
		chongzhi();
	}
	
	
    option1.appendChild(value1);
    option2.appendChild(value2);
    option3.appendChild(value3);
    select.appendChild(option1);
    select.appendChild(option2);
    select.appendChild(option3);

    form_table_td3.appendChild(form_table_td3_text);
    form_table_td3.appendChild(text3);
    form_table_tr2.appendChild(form_table_td3);
    form_table_tbody.appendChild(form_table_tr2);

    form_table_td4.appendChild(form_table_td4_text);
    form_table_td4.appendChild(select);
    form_table_tr2.appendChild(form_table_td4);
    form_table_tbody.appendChild(form_table_tr2);

    createFormTable.appendChild(form_table_tbody);
    form.appendChild(createFormTable);
    form.appendChild(buttonSave);
    form.appendChild(buttonReset);
    document.getElementById("fid").appendChild(form);
}

// 新增
function trdadd() {
	flag = false;
	document.getElementById("fid").style.display = "block"; //控制显示
	chongzhi();
	document.getElementById("aid").disabled = false; //重新启用
	
}

//保存
function baocun() {
	if (flag == false) {

		add(flag);
		document.getElementById("fid").style.display = "none";
	} else {

		add(flag);
		document.getElementById("fid").style.display = "none";

	}
}

//重置
function chongzhi() {
	document.getElementById("formid").reset();
}

//删除      
function deleteRow(input) {
	var s = input.parentNode.parentNode.rowIndex;
	document.getElementById("tableid").deleteRow(s);
	var num = document.getElementById("tableid").rows.length;
	for ( var i = 1; i < num; i += 1) {
		table.rows[i].cells[0].innerHTML = i; //把每行的每一列设为i

	}
	alert("删除成功！！");
}

//全局变量
var table = null;
var flag = false;
var getselectrow;
function getNum() {
	var haoRow = table.rows[0];
	return haoRow.cells.length;
}

//添加方法

function add(flag) {
	if (!flag) {
		// var num=getNum();
		var row = table.insertRow(-1); //为-1时往下加（升序），为0时往上加（id降序）
		var add1 = row.insertCell(0);
		var add2 = row.insertCell(1);
		var add3 = row.insertCell(2);
		var add4 = row.insertCell(3);
		var add5 = row.insertCell(4);
		var add6 = row.insertCell(5);
		
		var add7 = row.insertCell(6);
		var add8 = row.insertCell(7);
		var add9 = row.insertCell(8);

		add1.innerHTML = document.getElementById("tableid").rows.length - 1;//不加-1时id从二开始；原因：标题占一个
		add2.innerHTML = document.getElementById("aid").value;
		add3.innerHTML = document.getElementById("bid").value;
		add4.innerHTML = document.getElementById("cid").value;
		var tall = document.getElementById("eid");
		var index = tall.selectedIndex;// 当前坐标
		var option = tall.options[index];
		add5.innerHTML = option.text;
		add6.innerHTML = "<input type='button' value='修改' onclick='updateRow(this)'> <input type='button' value='删除' onclick='deleteRow(this)'>";
		//alert(num);
		alert("添加成功！！");

	} else {

		var row2 = table.rows[getselectrow];//选中当前行
		//把修改后的值设置到对应的文本框中
		row2.cells[1].innerHTML = document.getElementById("aid").value;
		row2.cells[2].innerHTML = document.getElementById("bid").value;
		row2.cells[3].innerHTML = document.getElementById("cid").value;
		var pall = document.getElementById("eid");
		var index = pall.selectedIndex; //当前坐标
		var option = pall.options[index];
		row2.cells[4].innerHTML = option.text;

		alert("修改成功！！");
	}
}

//修改
function updateRow(input) {
	flag = true
	document.getElementById("aid").disabled = true; //不能启用
	document.getElementById("fid").style.display = "block";

	var i = input.parentNode.parentNode.rowIndex;

	getselectrow = i;
	//得到选中行的内容放到文本框
	document.getElementById("aid").value = table.rows[i].cells[1].innerHTML;
	document.getElementById("bid").value = table.rows[i].cells[2].innerHTML;
	document.getElementById("cid").value = table.rows[i].cells[3].innerHTML;

	var select = document.getElementById("eid");
	var index = select.selectedIndex;// 当前坐标
	var option = select.options[index];
	option.text = table.rows[i].cells[4].innerHTML;

}
*/
/*
		function autocreate(){
	    //创建table表格
	    var table=document.createElement("table");
	    table.setAttribute("border","1");
	    table.setAttribute("background","jquery-easyui/images/22.jpg");
	    //获取行数值
	    //var line=document.getElementById("line").value;
	    var line=5;
	    //获取列数值
	    //var list=document.getElementById("list").value;
	    var list=10;
	    for(var i=0;i<=line;i++){
	        //alert(line);
	        //创建tr
	        var tr=document.createElement("tr");
	        tr.setAttribute("height","0.1px");
	        for(var j=0;j<=list;j++){
	            //alert(list);
	            //创建td
	            var td=document.createElement("td");
	            td.setAttribute("width","0.1px");
	            td.setAttribute("onclick","copyText(id)");
	            td.setAttribute("id","td"+i+j);
	            td.setAttribute("name","name"+i+j);
	            td.innerHTML=i+""+j;
	            tr.appendChild(td);
	            }
	            table.appendChild(tr);
	        }
	        document.getElementById("d1").appendChild(table);
	    }
 */