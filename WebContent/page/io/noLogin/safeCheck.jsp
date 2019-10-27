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
<title>人身安全检查登记</title>
<link rel="stylesheet" href="css/style.css" />

<!-- bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="bootstrap/plus/table/bootstrap-table.min.css"> -->

<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui/js/themes/icon.css" />

<!-- jq -->
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<!-- 分页插件 -->
<script type="text/javascript"
	src="bootstrap/plus/table/bootstrap-table.min.js"></script>
<script type="text/javascript"
	src="bootstrap/plus/table/bootstrap-table-locale-all.min.js"></script>

<script type="text/javascript"
	src="jquery-easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
</script>
<!-- <style type="text/css">
	.clearfix {width: 430px;}
	.bootstrap-table {width: 430px;}
</style> -->
</head>
<body>


	<!---随身物品添加弹出框-->
	<form id="newGoods_form" name="ff" method="post">
		<div class="popbox" id="boxes" style="display: none;">

			<div class="cszPopbox2" id="box-inner">
				<h3>
					添加物品 <a onclick="closeAdd()"><img src="images/close.png"></a>
				</h3>

				<div class="add-wp">
					<ul>
						<li>物品名称及特征：<input type="text" id="goodsName"
							name="goodsName" style="width: 445px;"></li>
						<li>物品分类：<select id="goodsType" name="goodsType"
							style="width: 200px; height: 30px; font-size: 13px;"></select>
						</li>
						<li>数量单位：<input type="text" id="quantityUnits"
							name="quantityUnits"></li>
						<li>保管措施：<select id="custody" name="custody"
							style="width: 200px; height: 30px; font-size: 13px;"></select></li>

						<li>保管位置：<input type="text" id="cabinetsNumber"
							name="cabinetsNumber"></li>
					</ul>
				</div>

				<div class="btn-add">
					<a onclick="sureAdd()">确定添加</a>
				</div>
				<input id="recordNumberForm1" name="recordNumber"
					style="display: none">
			</div>

			<!--遮罩层-->
		</div>
	</form>
	<!---弹出框end-->

	<div class="content">
		<div class="rrtt">
			<img src="images/rrtt.jpg">
		</div>
		<div class="rsaqjc">
			<div class="rsaq-tit"></div>

			<!-- 人员基本信息，此信息是刷卡自动显示的。 -->

			<div class="rsaq-nr">
				<h3>
					<i class="biaoti"></i><span>人员基本信息</span>
				</h3>
				<div class="infor-nav">
					<div class="infor-left">
						<table>
							<tr>
								<td><img id="frontalView" src="images/infor-pic1.jpg"
									alt=""></td>
								<td class="zhengjz"><img id="IDPicture"
									src="images/zhz.jpg" alt=""><span>证件照</span></td>
							</tr>
							<tr>
								<td><img id="leftView" src="images/infor-pic2.jpg" alt=""></td>
								<td><img id="rightView" src="images/infor-pic3.jpg" alt=""></td>
							</tr>
						</table>
					</div>
					<div class="infor-right">
						<table class="biaoge">
							<tr>
								<th>档案编号：</th>
								<td colspan="3"><input id="recordNumber"
									name="recordNumber"
									style="width: 190px; height: 18px; border: none; background-color: #d4e8f0;"
									readonly="readonly"></td>
							</tr>
							<tr>
								<th>入区时间：</th>
								<td colspan="3"><input id="entryTime" name="entryTime"
									style="width: 190px; height: 18px; border: none; background-color: #d4e8f0;"
									readonly="readonly"></td>
							</tr>
							<tr>
								<th>入区身份：</th>
								<td><input id="personType" name="personType"
									style="width: 120px; height: 18px; border: none; background-color: #d4e8f0;"
									readonly="readonly"></td>
								<th>入区原因：</th>
								<td><input id="causeCode" name="causeCode"
									style="width: 120px; height: 18px; border: none; background-color: #d4e8f0;"
									readonly="readonly"></td>
							</tr>
						</table>
						<table class="information">
							<tr>
								<th>姓名：</th>
								<td colspan="5"><input type="text" name="name" id="name"
									style="width: 120px; height: 18px; border: none;"
									readonly="readonly" /><span>（手环编号：<input
										id="recognition" name="recognition"
										style="width: 80px; border: none;" readonly="readonly">）
								</span></td>
							</tr>
							<tr>
								<th>性别：</th>
								<td><input type="text" name="sex" id="sex"
									style="width: 80px; height: 18px; border: none;"
									readonly="readonly" /></td>
								<th>民族：</th>
								<td><input type="text" name="nation" id="nation"
									style="width: 120px; height: 18px; border: none;"
									readonly="readonly" /></td>
							</tr>
							<tr>
								<th>出生日期：</th>
								<td colspan="5"><input type="text" name="birthday"
									id="birthday" style="width: 120px; height: 18px; border: none;"
									readonly="readonly" /></td>
							</tr>
							<tr>
								<th>证件号码：</th>
								<td colspan="5"><input type="text" name="IDCode"
									id="IDCode" style="width: 120px; height: 18px; border: none;"
									readonly="readonly" /></td>
							</tr>
							<tr>
								<th>证件住址：</th>
								<td colspan="5"><input type="text" name="address"
									id="address" style="width: 120px; height: 18px; border: none;"
									readonly="readonly" /></td>
							</tr>
							<tr>
								<th>现住址：</th>
								<td colspan="5"><input type="text" name="currentAddr"
									id="currentAddr"
									style="width: 120px; height: 18px; border: none;"
									readonly="readonly" /></td>
							</tr>
							<tr>
								<th>联系方式：</th>
								<td colspan="5"><input type="text" name="telephone"
									id="telephone"
									style="width: 120px; height: 18px; border: none;"
									readonly="readonly" /></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="zbgj">
					<table>
						<tr id="policeSigned">
							<!-- <td>业务干警：<input type="text"></td>
							<td>值班干警：<input type="text"></td> -->
						</tr>
					</table>
				</div>
				<h3>
					<i class="biaoti"></i><span>人身安全检查</span>
				</h3>
				<h3 style="margin-top: 30px;">
					<i class="biaoti"></i><img class="rsaq-tit-pic"
						src="images/rsaq.jpg" alt="">
				</h3>
			</div>

			<!-- 随身物品检查 -->
			<form id="goodsCheck_form" name="goodsCheck_form" method="post">
				<div class="tihuannr" id="goodsCheck" style="display: none;">
					<div class="wuping">
						<div class="bianhao">
							<div class="bianhao-01">
								手环编号：<input type="text" name="recognition1" id="recognition1"
									style="width: 120px; height: 18px; border: none; background-color: #2fa8dd;"
									readonly="readonly" />
							</div>
							<div class="bianhao-02">
								对应保管柜号：<input type="text" name="cabinetsNumber"
									id="cabinetsNumber"
									style="width: 120px; height: 18px; border: none; background-color: #2fa8dd;"
									readonly="readonly" />
							</div>
						</div>
						<table class="wjw-tb" id="goodstt"></table>
						<div class="add-wupin">
							<a class="btn-addwp" onclick="addGoods()">+添加物品</a> <a
								class="btn-addwp" onclick="deleteGoods()">-删除物品</a>
						</div>
						<div class="shryqz">
							<p>
								涉案人员签字：<input type="text" id="goodsParty" name="goodsParty">
							</p>
						</div>
						<div class="mjjy" id="checkGoodsPolice">
							<div class="btn-ls02">
								<a onclick="addGoodsOrder()">增加业务干警签名</a> <a
									onclick="deleteGoodsOrder()">删除业务干警签名</a>
							</div>
							<ul>
								<li>业务干警：<input id="goodsPolice" name="goodsPolice"
									style="width: 120px; height: 25px;"></li>
								<li>警员编号：<input type="text" name="code" id="code"
									style="width: 120px; height: 25px;"></li>
								<!-- <li>值班干警：<input id="dutyPolice" name="dutyPolice" style="width: 120px; height: 25px;"></li>
							<li>警员编号：<input type="text" name="dutyCode" id="dutyCode" style="width: 120px; height: 25px;"></li> -->
							</ul>
						</div>
						<div class="mjjy" id="checkGoodsPolice2">
							<div class="btn-ls02">
								<a onclick="addGoodsOrder2()">增加值班干警签名</a> <a
									onclick="deleteGoodsOrder2()">删除值班干警签名</a>
							</div>
							<ul>
								<li>值班干警：<input id="dutyPolice" name="dutyPolice"
									style="width: 120px; height: 25px;"></li>
								<li>警员编号：<input type="text" name="dutyCode" id="dutyCode"
									style="width: 120px; height: 25px;"></li>
							</ul>
						</div>
						<!-- <div class="btn-ls02">
						<a onclick="addGoodsOrder()">增加业务干警签名</a> <a onclick="deleteGoodsOrder()">删除业务干警签名</a> 
						<a onclick="addGoodsOrder2()">增加值班干警签名</a> <a onclick="deleteGoodsOrder2()">删除值班干警签名</a> 
					</div> -->
					</div>
					<div class="anniu">
						<table>
							<tr>
								<!-- <td><a href="">重填</a></td> -->
								<td><a id="lastSave" onclick="">确定保存</a></td>
							</tr>
						</table>
					</div>
					<input id="recordNumberForm2" name="recordNumber"
						style="display: none">
				</div>
			</form>
			<!-- 伤情检查 -->
			<form id="injurySignature_form" name="injurySignature_form"
				method="post">
				<div class="tihuannr" id="injuryCheck" style="display: none;">
					<div class="sqjdq">
						<!-- 左侧轮廓图 -->
						<div class="tupian">
							<h3>伤情定位区</h3>
							<img src="images/lunku1.png" alt="" id="lunku1"> <img
								style="display: none;" src="images/lunku2.png" alt=""
								id="lunku2">
							<div class="xuanzhong0">

								<table id="table1">
									<tr>
										<td><a onclick="copyText(id)" id="A1"><span>A1</span></a></td>
										<td><a onclick="copyText(id)" id="B1"><span>B1</span></a></td>
										<td><a onclick="copyText(id)" id="C1"><span>C1</span></a></td>
									</tr>
									<tr>
										<td><a onclick="copyText(id)" id="A2"><span>A2</span></a></td>
										<td><a onclick="copyText(id)" id="B2"><span>B2</span></a></td>
										<td><a onclick="copyText(id)" id="C2"><span>C2</span></a></td>
									</tr>
									<tr>
										<td><a onclick="copyText(id)" id="A3"><span>A3</span></a></td>
										<td><a onclick="copyText(id)" id="B3"><span>B3</span></a></td>
										<td><a onclick="copyText(id)" id="C3"><span>C3</span></a></td>
									</tr>
									<tr>
										<td><a onclick="copyText(id)" id="A4"><span>A4</span></a></td>
										<td><a onclick="copyText(id)" id="B4"><span>B4</span></a></td>
										<td><a onclick="copyText(id)" id="C4"><span>C4</span></a></td>
									</tr>
									<tr>
										<td><a onclick="copyText(id)" id="A5"><span>A5</span></a></td>
										<td><a onclick="copyText(id)" id="B5"><span>B5</span></a></td>
										<td><a onclick="copyText(id)" id="C5"><span>C5</span></a></td>
									</tr>
								</table>
							</div>
						</div>
						<!-- 右侧伤情详情表 -->
						<div class="shuoming">
							<h3>伤情说明区</h3>
							<table id="tt"></table>

						</div>
						<div class="zbgj1">

							<div class="shryqz">
								<p>
									被检查人/监护人签字：<input type="text" name="scarParty" id="scarParty">
								</p>
							</div>
							<div class="mjjy" id="injuryPolice">
								<ul>
									<li>民警签字：<input type="text" name="scarPolice"
										id="scarPolice" style="width: 120px; height: 25px;"></li>
									<li>警员编号：<input type="text" name="code" id="code"
										style="width: 120px; height: 25px;"></li>
								</ul>
							</div>
							<div class="btn-ls02">
								<a onclick="addOrder()">增加签名</a> <a onclick="deleteOrder()">删除签名</a>
							</div>
						</div>
					</div>
					<div class="anniu">
						<table>
							<tr>
								<!-- <td><a href="">重填</a></td> -->
								<td><a onclick="injuryNext()">下一步</a></td>
							</tr>
						</table>
					</div>
					<input id="recordNumberForm" name="recordNumber"
						style="display: none">
				</div>
			</form>
			<!-- 添加伤情详情 -->
			<form id="scardetail_form" name="scardetail_form" method="post">
				<div class="cjqtx" id="addInjuryInfo" style="display: none;">

					<h3>
						伤情录入表<a onclick="btnclose()"><img src="images/chachah.jpg"></a>
					</h3>
					<table class="tjsq">
						<tr>
							<th>伤情区域：</th>
							<td><input id="scarArea" name="scarArea" type="text"
								style="width: 50px; height: 18px; border: none;"
								readonly="readonly" /></td>
							<th>伤情照片：</th>
							<td><input id="numImg" name="numImg" type="text"
								style="width: 50px; height: 18px; border: none;"
								readonly="readonly" /></td>
						</tr>
						<tr id="aaaa">
							<th>伤情部位：</th>
							<td><select name="scarPart" id=""
								style="width: 80px; height: 20px; font-size: 13px; border: 1px solid teal">
									<option value="头部">头部</option>
									<option value="小腿">小腿</option>
							</select></td>

							<th>伤情类型：</th>
							<td><select name="scarType" id=""
								style="width: 80px; height: 20px; font-size: 13px; border: 1px solid teal">
									<option value="刀伤">刀伤</option>
									<option value="枪伤">枪伤</option>
							</select></td>

							<td><input type="file" id="1View" style="display: none"
								onchange="selectImage(this)"> <img id="1"
								src="images/tjzp.jpg" name="scarFigure"
								onclick="F_Open_dialog(this)" width="50px" height="50px">
								<input id="V" name="scarFigure" style="display: none"></td>

						</tr>
						<tr>
							<th>伤情描述：</th>
							<td></td>
						</tr>
					</table>
					<textarea name="scarDescribe" class="yanse"></textarea>

					<div class="btn-klkl2">
						<a onclick="saveAndBack()">保存</a>
					</div>
					<input id="recordNumberForm3" name="recordNumber"
						style="display: none">
					<div style="display: none;">
						<!-- 此div是将图片的值转换保存为字符串便于向后台传值，隐藏不显示 -->
						<!-- <input  id=num name="scarFigure"> -->
					</div>

				</div>
			</form>
			<!-- 自诉情况 -->
			<div class="tihuannr" id="privateProsecution">
				<form id="safetyCheck_form" name="safetyCheck_form" method="post">
					<div class="sfyj">
						<ul>
							<li>是否饮酒：</li>
							<li>
								<table>
									<tr>
										<td>是</td>
										<td><a id="addIS" onclick="addIS()"><input
												name="IsDrink" style="display: none" type="radio" value="1" /></a></td>
										<td><a id="zhuangtai" class="zhuangtai"
											onclick="addzhuangtai()">未选</a></td>
										<td><a id="addNO" onclick="addNO()"><input
												name="IsDrink" style="display: none" type="radio" value="0" /></a></td>
										<td>否</td>
									</tr>
								</table>
							</li>
						</ul>
						<ul>
							<li>是否患有传染性疾病：</li>
							<li>
								<table>
									<tr>
										<td>是</td>
										<td><a id="addIS2" onclick="addIS2()"><input
												name="IsContage" style="display: none" type="radio"
												value="1" /></a></td>
										<td><a id="zhuangtai2" class="zhuangtai"
											onclick="addzhuangtai2()">未选</a></td>
										<td><a id="addNO2" onclick="addNO2()"><input
												name="IsContage" style="display: none" type="radio"
												value="0" /></a></td>
										<td>否</td>
									</tr>
								</table>
							</li>
						</ul>
						<ul>
							<li>自述症状：</li>
							<li><span>（请在下表格内添加自述症状内容）</span></li>
						</ul>
						<textarea class="wby" name="readmeSymptom" id="readmeSymptom"></textarea>
					</div>
					<input id="recordNumberForm4" name="recordNumber"
						style="display: none">
				</form>
				<div class="anniu">
					<table>
						<tr>
							<!-- <td><a href="">重填</a></td> -->
							<td><a onclick="privateNext()">保存，下一步</a></td>
						</tr>
					</table>
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">

$(document).ready(function(){
		$.ajax({
	    type: "POST",
	    url: "infoHeader/searchBaseInfo",
	    data: {"recognition":"8087"},
	    async: false,
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
	     $("#recordNumberForm1").val(msg.recordNumber);
	     $("#recordNumberForm2").val(msg.recordNumber);
	     $("#recordNumberForm3").val(msg.recordNumber);
	     $("#recordNumberForm4").val(msg.recordNumber);
	     $("#recognition1").val(msg.recognition);//给随身物品上面的手环编号赋值
	     //根据男女显示不同轮廓图
	     if(msg.sex=='女'){
	 		$("#lunku2").css("display", "block");
	 		$("#lunku1").css("display", "none");
	 	}else{
	 		$("#lunku1").css("display", "block");
	 		$("#lunku2").css("display", "none");
	 	}
	     
         $.ajax({
             cache: false,
              type: 'POST',
              url:'safetyCheck/showPoliceSigned',
               async: false,
               data:{"recordNumber":(msg.recordNumber)},
               dataType: 'json',
               success: function (data) {
            	   var police=data.police
            	   var pList=new Array();
            	   for (var i=0;i<police.length;i++){
          				var row=police[i].entryPolice;
            		   pList.push(row);
            	   }
            	   var policerow='<td>业务干警:'+pList+'</td>';
            	   var dutypolice=data.dutyPolice;
            	   var policedutyrow='<td>值班干警:'+dutypolice.dutyPolice+'</td>';
            	   $("#policeSigned").append(policerow);
            	   $("#policeSigned").append(policedutyrow);
               }
               
          });
	     
    },
    error: function (error) {
      easyuiAlert(error);
    }
  });
		$("#goodsType").combobox({  
	        url : 'infoHeader/getListByCodeName?codeName=goodsType',
	        valueField:'code',   
	        textField:'name'  
	   	});
		$("#custody").combobox({  
	        url : 'infoHeader/getListByCodeName?codeName=custody',
	        valueField:'code',   
	        textField:'name'  
	   	});
		
		
}); 

	/* 是否饮酒： */
	function addIS() {
		$('#addIS').addClass("zhuangtai");
		$('#zhuangtai').removeClass("zhuangtai");
		$('#addNO').removeClass("zhuangtai");
		$("input[type=radio][name=IsDrink][value=0]").removeAttr( "checked");//移除否的默认选中
		$("input[type=radio][name=IsDrink][value=1]").attr("checked", 'checked');//设置是默认选中
		var val1 = $('input:radio[name="IsDrink"]:checked').val();//获得默认选中值
		console.log(val1);
	}
	function addNO() {
		$('#addNO').addClass("zhuangtai");
		$('#zhuangtai').removeClass("zhuangtai");
		$('#addIS').removeClass("zhuangtai");
		$("input[type=radio][name=IsDrink][value=1]").removeAttr( "checked");//移除是的默认选中
		$("input[type=radio][name=IsDrink][value=0]").attr("checked", 'checked')//设置否的默认选中
		var val2 = $('input:radio[name="IsDrink"]:checked').val();//获得默认选中值
		console.log(val2);
	}
	function addzhuangtai() {
		$('#zhuangtai').addClass("zhuangtai");
		$('#addNO').removeClass("zhuangtai");
		$('#addIS').removeClass("zhuangtai");
	}
	/* 是否患有传染性疾病 */
	function addIS2() {
		$('#addIS2').addClass("zhuangtai");
		$('#zhuangtai2').removeClass("zhuangtai");
		$('#addNO2').removeClass("zhuangtai");
		$("input[type=radio][name=IsContage][value=0]").removeAttr( "checked");//移除否的默认选中
		$("input[type=radio][name=IsContage][value=1]").attr("checked", 'checked');//设置是默认选中
		var val1 = $('input:radio[name="IsContage"]:checked').val();//获得默认选中值
		console.log(val1);
	}
	function addNO2() {
		$('#addNO2').addClass("zhuangtai");
		$('#zhuangtai2').removeClass("zhuangtai");
		$('#addIS2').removeClass("zhuangtai");
		$("input[type=radio][name=IsContage][value=1]").removeAttr( "checked");//移除是的默认选中
		$("input[type=radio][name=IsContage][value=0]").attr("checked", 'checked')//设置否的默认选中
		var val2 = $('input:radio[name="IsContage"]:checked').val();//获得默认选中值
		console.log(val2);
	}
	function addzhuangtai2() {
		$('#zhuangtai2').addClass("zhuangtai");
		$('#addNO2').removeClass("zhuangtai");
		$('#addIS2').removeClass("zhuangtai");
	}
	/* 自诉详情的下一步 */
	function privateNext() {
		$('#safetyCheck_form').form('submit',{
			url:'safetyCheck/saveSafetyCheckInfo',
			success:function(data){
				if(data==true||data=='true'){ 
					$("#privateProsecution").css("display", "none");
					$("#injuryCheck").css("display", "block");
					$("#goodsCheck").css("display", "none");
					$('#tt').bootstrapTable(  
				              "refresh",  
				              {  
				                  url:"safetyCheck/getScarExplain"  
				              }  
				      );
		 		}
			}
		}); 
	}
	/* 伤情检查的下一步 */
	function injuryNext() {
		$.ajax({  
		    type: "POST",  
		    url:'safetyCheck/saveInjurySignature',
		    data:$('#injurySignature_form').serialize(),
		    success: function(data) {  
		    	if(data==true||data=='true'){  
					$("#privateProsecution").css("display", "none");
					$("#injuryCheck").css("display", "none");
					$("#goodsCheck").css("display", "block");
					$('#goodstt').bootstrapTable(  
				              "refresh",  
				              {  
				                  url:"safetyCheck/getGoodsList"  
				              }  
				      );
					
	 			}
		    }  
	 }); 
		
		
	}

	/* 点击伤情区域，打开伤情添加页面 */
	function copyText(id) {
		$("#injuryCheck").css("display", "none");
		$("#addInjuryInfo").css("display", "block");
		var obj = window.document.getElementById(id);
		document.getElementById("scarArea").value = obj.innerHTML.substr(6, 2);//绑定伤情区域
		document.getElementById("numImg").value = 0;//第一次上传照片数量为零。
		console.log(obj.innerHTML.substr(6, 2));
		console.log(document.getElementById("scarArea").value);
	}
	/* 保存伤情返回轮廓图页面 */
	function saveAndBack() {
		$('#scardetail_form').form('submit',{
			url:'safetyCheck/saveScarTreatment',
			success:function(data){
				$(':input','#scardetail_form').not(':button, :submit, :reset, :hidden').val('') 
		    	.removeAttr('checked') .removeAttr('selected');//清空弹窗form表单 
				if(data==true||data=='true'){ 
					$("#injuryCheck").css("display", "block");
					$("#addInjuryInfo").css("display", "none");
					$('#tt').bootstrapTable(  
				              "refresh",  
				              {  
				                  url:"safetyCheck/getScarExplain"  
				              }  
				      );  
				}
			}
		});
		
	}
	/* 关闭伤情添加页面 */
	function btnclose() {
		$("#injuryCheck").css("display", "block");
		$("#addInjuryInfo").css("display", "none");
	}
	/* 上传伤情图片 */
	/* 
	<td>
		<input type="file" id="1View" name="scarFigure" style="display: none" onchange="selectImage(this)"> 
		<img id="1" src="images/tjzp.jpg" onclick="F_Open_dialog(this)" width="50px" height="50px">
	</td> */
	var num=null;
	function F_Open_dialog(data){
		console.log("data::"+data);
		document.getElementById(data.id+"View").click(); 
		num = parseInt(data.id) + 1;
		console.log("num:"+num);
		if(data.src == "<%=basePath%>images/tjzp.jpg") {
				var td = " <td><input type='file' id='"
						+ num
						+ "View' style='display:none' onchange='selectImage(this)'>"
						+ "<img id='"
						+ num
						+ "' src='images/tjzp.jpg' name='scarFigure'  onclick='F_Open_dialog(this)'  width='50px'  height='50px'></td>"
						+ "<input  id='V' name='scarFigure' style='display: none'>";
				$("#aaaa").append(td);
			}
		}
		function selectImage(file) {
			console.log("file::" + file);
			if (!file.files || !file.files[0]) {
				return;
			}
			var reader = new FileReader();
			reader.onload = function(evt) {
				document.getElementById(file.id.replace("View", "")).src = evt.target.result;
				$("#" + file.id.substring(1, 2)).attr("value",
						evt.target.result);
			}
			reader.readAsDataURL(file.files[0]);
			document.getElementById("numImg").value = file.id.replace("View",
					"");//显示上传了的照片数量
		}
		//打开增加物品的页面
		function addGoods() {
			$("#boxes").css("display", "block");
		}
		//删除物品
		function deleteGoods() {
			var row = $("#goodstt").bootstrapTable('getSelections');
			if (row.length <= 0) {
				alert("请选择要删除都得物品！")
			} else {
				var b = JSON.stringify(row);
				var url = "safetyCheck/deleteHisBelongings";
				$.ajax({
					dataType : "json",
					traditional : true,//这使json格式的字符不会被转码
					data : {
						"datalist" : b
					},
					type : "post",
					url : url,
					success : function(data) {
						$('#goodstt').bootstrapTable("refresh", {
							url : "safetyCheck/getGoodsList"
						});
					},
					error : function(data) {
						alert(data.responseText);
					}
				});
			}

		}
		function closeAdd() {
			$("#boxes").css("display", "none");
		}
		function sureAdd() {
			$('#newGoods_form').form(
					'submit',
					{
						url : 'safetyCheck/saveHisBelongings',
						success : function(data) {
							$(':input', '#newGoods_form').not(
									':button, :submit, :reset, :hidden')
									.val('').removeAttr('checked').removeAttr(
											'selected');//清空弹窗form表单 
							if (data == true || data == 'true') {
								$("#boxes").css("display", "none");
								$('#goodstt').bootstrapTable("refresh", {
									url : "safetyCheck/getGoodsList"
								});
							}
						}
					});

		}

		function addOrder() {//增加业务干警签名输入框
			var ul = '<ul><li>民警签字：<input type="text" name="scarPolice" id="scarPolice" style="width: 120px; height: 25px;"></li>'
					+ '<li>警员编号：<input type="text" name="code" id="code" style="width: 120px; height: 25px;"></li></ul>';
			$("#injuryPolice").append(ul);
		}
		function deleteOrder() {//删除业务干警签名输入框
			var Child = document.getElementById('injuryPolice').lastChild;
			document.getElementById('injuryPolice').removeChild(Child);
		}

		function addGoodsOrder() {//增加业务干警签名输入框
			var ul = '<ul>'
					+ '<li>业务干警：<input id="goodsPolice" name="goodsPolice" style="width: 120px; height: 25px;"></li>'
					+ '<li>警员编号：<input type="text" name="code" id="code" style="width: 120px; height: 25px;"></li>'
					+ '</ul>';
			$("#checkGoodsPolice").append(ul);
		}
		function deleteGoodsOrder() {//删除业务干警签名输入框
			var Child = document.getElementById('checkGoodsPolice').lastChild;
			document.getElementById('checkGoodsPolice').removeChild(Child);
		}

		function addGoodsOrder2() {//增加业务干警签名输入框
			var ul = '<ul>'
					+ '<li>值班干警：<input id="dutyPolice" name="dutyPolice" style="width: 120px; height: 25px;"></li>'
					+ '<li>警员编号：<input type="text" name="dutyCode" id="dutyCode" style="width: 120px; height: 25px;"></li>'
					+ '</ul>';
			$("#checkGoodsPolice2").append(ul);
		}
		function deleteGoodsOrder2() {//删除业务干警签名输入框
			var Child = document.getElementById('checkGoodsPolice2').lastChild;
			document.getElementById('checkGoodsPolice2').removeChild(Child);
		}

		$("#lastSave").click(function() {
			$.ajax({
				dataType : "json",
				traditional : true,//这使json格式的字符不会被转码
				type : "post",
				url : 'safetyCheck/saveGoodsSignature',
				data : $('#goodsCheck_form').serialize(),
				success : function(data) {
					//保存成功后返回指定页面，比如屏保
				},
				error : function(data) {
					alert(data.responseText);
				}
			});

		});

		//bootstrap表格插件
		/* 伤痕详情列表信息 */
		$('#tt').bootstrapTable({
			method : 'post',
			contentType : "application/x-www-form-urlencoded",//必须要有！！！！
			url : 'safetyCheck/getScarExplain',//要请求数据的文件路径
			striped : true, //是否显示行间隔色
			dataField : "res",//bootstrap table 可以前端分页也可以后端分页，这里
			//我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
			//rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
			pageNumber : 1, //初始化加载第一页，默认第一页
			pagination : true,//是否分页
			queryParamsType : '',
			queryParams : queryParams,//请求服务器时所传的参数
			sidePagination : 'server',//指定服务器端分页
			pageSize : 5,//单页记录数
			pageList : [ 2, 5, 10, 15 ],//分页步进值
			showRefresh : false,//刷新按钮
			showColumns : false,
			columns : [ {
				title : '序号',
				field : 'SerialNumber',
				width : 25,
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'scarExplain',
				title : '伤情说明',
				width : '100px'
			}, {
				field : 'numImg',
				title : '附件照片',
				width : '50px'
			} ],
			locale : 'zh-CN'//中文支持,
		})
		//请求服务数据时所传参数
		function queryParams(params) {
			return {
				//每页多少条数据
				pageSize : params.pageSize,
				//请求第几页
				pageNumber : params.pageNumber,
				recordNumber : $('#recordNumber').val(),
			}
		}

		/* 随身物品列表信息 */
		$('#goodstt').bootstrapTable({
			method : 'post',
			contentType : "application/x-www-form-urlencoded",//必须要有！！！！
			url : 'safetyCheck/getGoodsList',//要请求数据的文件路径
			striped : true, //是否显示行间隔色
			dataField : "res",//bootstrap table 可以前端分页也可以后端分页，这里
			pageNumber : 1, //初始化加载第一页，默认第一页
			pagination : true,//是否分页
			queryParamsType : '',
			queryParams : queryParams,//请求服务器时所传的参数
			sidePagination : 'server',//指定服务器端分页
			pageSize : 5,//单页记录数
			pageList : [ 2, 5, 10, 15 ],//分页步进值
			showRefresh : false,//刷新按钮
			showColumns : false,
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
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'goodsType',
				title : '物品分类'
			}, {
				field : 'goodsName',
				title : '物品名称及特征'
			}, {
				field : 'quantityUnits',
				title : '数量单位'
			}, {
				field : 'custody',
				title : '保管措施'
			}, {
				field : 'cabinetsNumber',
				title : '保管柜号'
			}, ],
			locale : 'zh-CN'//中文支持,
		})
		//请求服务数据时所传参数
		function queryParams(params) {
			return {
				//每页多少条数据
				pageSize : params.pageSize,
				//请求第几页
				pageNumber : params.pageNumber,
				recordNumber : $('#recordNumber').val(),
			}
		}
	</script>


</body>
</html>


