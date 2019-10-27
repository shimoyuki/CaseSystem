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
<title>信息采集登记</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui/js/themes/icon.css" />

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jquery-easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>


</head>
<body>
		<div class="content">
			<div class="rrtt">
				<img src="images/rrtt.jpg">
			</div>
			<div class="rsaqjc">
				<div class="xxcj-tit"></div>
				<div class="rsaq-nr">
					<h3><i class="biaoti"></i><span>人员基本信息</span></h3>
					<div class="infor-nav">
						<div class="infor-left">
							<table>
								<tr>
									<td><img id="frontalView" src="images/infor-pic1.jpg" alt=""></td>
									<td class="zhengjz"><img id="IDPicture" src="images/zhz.jpg" alt=""><span>证件照</span></td>
								</tr>
								<tr>
									<td><img id="leftView"src="images/infor-pic2.jpg" alt=""></td>
									<td><img id="rightView" src="images/infor-pic3.jpg" alt=""></td>
								</tr>
							</table>
						</div>
						<div class="infor-right">
							<table class="biaoge">
								<tr>
									<th>档案编号：</th>
									<td colspan="3"><input id="recordNumber" name="recordNumber" style="width:180px;height:18px; border:none; background-color: #d4e8f0;"readonly="readonly" ></td>
								</tr>
								<tr>
									<th>入区时间：</th>
									<td colspan="3"><input id="entryTime"name="entryTime" style="width: 180px;height:18px; border:none; background-color: #d4e8f0;"readonly="readonly"></td>
								</tr>
								<tr>
									<th>入区身份：</th>
									<td><input id="personType"name="personType" style="width: 120px;height:18px; border:none; background-color: #d4e8f0;" readonly="readonly"></td>
									<th>入区原因：</th>
									<td><input id="causeCode"name="causeCode" style="width: 120px;height:18px; border:none; background-color: #d4e8f0;"readonly="readonly"></td>
								</tr>
							</table>
							<table class="information">
								<tr>
									<th>姓名：</th>
									<td colspan="5"><input type="text"  name="name" id="name"  style="width: 120px;height:18px; border:none; " readonly="readonly" /><span>（手环编号：<input id="recognition"name="recognition" style="width: 80px;border:none;" readonly="readonly">）</span></td>
								</tr>
								<tr>
									<th>性别：</th>
									<td><input type="text"  name="sex" id="sex"  style="width: 80px;height:18px; border:none; " readonly="readonly" /></td>
									<th>民族：</th>
									<td><input type="text"  name="nation" id="nation"  style="width: 120px;height:18px; border:none; " readonly="readonly" /></td>
								</tr>
								<tr>
									<th>出生日期：</th>
									<td colspan="5"><input type="text" name="birthday"  id="birthday" style="width: 120px;height:18px; border:none; " readonly="readonly" /></td>
								</tr>
								<tr>
									<th>证件号码：</th>
									<td colspan="5"><input type="text" name="IDCode"  id="IDCode" style="width: 120px;height:18px; border:none; " readonly="readonly" /></td>
								</tr>
								<tr>
									<th>证件住址：</th>
									<td colspan="5"><input type="text" name="address"  id="address" style="width: 120px;height:18px; border:none; " readonly="readonly" /></td>
								</tr>
								<tr>
									<th>现住址：</th>
									<td colspan="5"><input type="text" name="currentAddr"  id="currentAddr" style="width: 120px;height:18px; border:none; " readonly="readonly" /></td>
								</tr>
								<tr>
									<th>联系方式：</th>
									<td colspan="5"><input type="text" name="telephone"  id="telephone" style="width: 120px;height:18px; border:none; " readonly="readonly" /></td>
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
					<h3><i class="biaoti"></i><span>人身信息采集</span></h3>
				</div>
				<form id="informCollect" method="post" class="form-horizontal" >
				<!-- 用于传值参数档案号 -->
				<input id="recordNumberForm" name="recordNumber" style="display:none">
				<div class="xxcj-bj" id="totalProject" >
	            	<p>完成图标对应的采集项目后，点击对应图标添加<img src="images/ok.png" alt="">完成状态标记</p>
	            	<div class="cjxm">
						<table>
							<tr>
								<td colspan="2"><a onclick="acquisition(id)" id="photo"><input name="photo"  style="display: none;"value="0"><img src="images/cj-pic1.jpg" alt=""><img class="ok" src="images/ok.png" alt=""><img class="ok1" src="images/ok.png" alt=""><img class="ok2" src="images/ok.png" alt=""><img class="ok3" src="images/ok.png" alt=""></a></td>
								<td><a onclick="acquisition(id)" id="height"><input name="height"  style="display: none;"value="0"><img src="images/cj-pic2.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
								<td><a onclick="acquisition(id)" id="weight"><input name="weight"  style="display: none;"value="0"><img src="images/cj-pic3.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
							</tr>
							<tr>
								<td><a onclick="acquisition(id)" id="fingerprint"><input name="fingerprint"  style="display: none;"value="0"><img src="images/cj-pic4.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
								<td><a onclick="acquisition(id)" id="blood"><input name="blood"  style="display: none;"value="0"><img src="images/cj-pic5.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
								<td><a onclick="acquisition(id)" id="bodyFeature"><input name="bodyFeature"  style="display: none;"value="0"><img src="images/cj-pic6.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
								<td><a onclick="acquisition(id)" id="handwriting"><input name="handwriting"  style="display: none;"value="0"><img src="images/cj-pic7.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
							</tr>
							<tr>
								<td><a onclick="acquisition(id)" id="accent"><input name="accent"  style="display: none;"value="0"><img src="images/cj-pic8.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
								<td><a onclick="acquisition(id)" id="DNA"><input name="DNA"  style="display: none;"value="0"><img src="images/cj-pic9.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
								<td><a onclick="acquisition(id)" id="phoneSIS"><input name="phoneSIS"  style="display: none;"value="0"><img src="images/cj-pic10.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
								<td><a onclick="skipOtherProject()" id="otherClick"><img src="images/cj-pic11.jpg" alt=""><img class="ok" src="images/ok.png" alt=""></a></td>
							</tr>
						</table>
	            	</div>
	            	<div class="anniu">
							<table>
								<tr>
									 <td><a href="">重填</a></td>
									<td><a onclick='submitForm()'  >确定</a></td>
									<!-- <td><a href="">确定</a></td> -->
								</tr>	
							</table>
						</div>
				</div>
				
				
				<div class="xxcj-bj" id="otherObj"  style="display:none;">
	            	<div class="cjqtx">
						<h3>其他采集项<a><img src="images/chachah.jpg"></a></h3>
						<textarea name="otherProject" id="otherProject"></textarea>
						<div class="btn-klkl">
							<a onclick="savaOtherProject()">保存</a>
							<a onclick="closeOtherProject()">关闭</a>
						</div>
					</div>
	            	<!-- <div class="anniu">
							<table>
								<tr>
									<td><a href="">重填</a></td>
									<td><a href="">确定</a></td>
								</tr>	
							</table>
						</div> -->
				</div>
				
<!-- 				<div class="xxcj-bj" id="photo"  style="display:none;">
	            	<div class="cjqtx">
						<h3>免冠照采集<a id="btnclose"><img src="images/chachah.jpg"></a></h3>
						<div class="chaopian">
							<table>
							<tr>
								<td><img src="images/youc.jpg" name="leftPicture" alt=""><span>左侧面</span></td>
								<td><img src="images/zhenm.jpg" name="frontalPicture" alt=""><span>正面</span></td>
								<td><img src="images/zouc.jpg" name="rightPicture" alt=""><span>右侧面</span></td>
							</tr>
							<tr>
								<td><a onclick="photograph(id)" id="l"><img src="images/jingtou.jpg" alt=""></a></td>
								<td><a onclick="photograph(id)" id="f"><img src="images/jingtou.jpg" alt=""></a></td>
								<td><a onclick="photograph(id)" id="r"><img src="images/jingtou.jpg" alt=""></a></td>
							</tr>
							 <tr>
								<td><a onclick="saveAllpicture()">保存</a></td>
								<td><a onclick="closeAllpicture()">关闭</a></td>
								
							</tr> 
							</table>
						</div>
					</div>
					
					<div class="anniu">
							<table>
								<tr>
								<td><a onclick="saveAllpicture()">保存</a></td>
								<td><a onclick="closeAllpicture()">关闭</a></td>
								</tr>	
							</table>
					</div> 
					
	            	<div class="anniu">
							<table>
								<tr>
									<td><a href="">重填</a></td>
									<td><a onclick="saveAllpicture()">确定</a></td>
								</tr>	
							</table>
						</div>
				</div> -->
				</form>
			</div>	
				
				
		</div>	
		
	</body>
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
			     
                 $.ajax({
                     cache: false,
                      type: 'POST',
                      url:'inforCollection/showPoliceSigned',
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
	}); 

	function skipOtherProject(){//点击其他采集项
		$("#totalProject").css("display", "none");
		$("#photo").css("display", "none");
		$("#otherObj").css("display", "block");
	}
	function savaOtherProject(){//保存其他采集项
		$("#totalProject").css("display", "block");
		$("#photo").css("display", "none");
		$("#otherObj").css("display", "none");
		if($("#otherProject").val()!==""){
			$("#otherClick").attr('class','zzok')
		}else{
			$("#otherClick").removeClass($("#otherClick")[0].className);
		}
	}
	function closeOtherProject(){//关闭其他采集项
		/* $("input[name='"+id+"']").val("1") */
		$("#totalProject").css("display", "block");
		$("#photo").css("display", "none");
		$("#otherObj").css("display", "none");
		if($("#otherProject").val()!==""){
			$("#otherClick").attr('class','zzok');
		}else{
			$("#otherClick").removeClass($("#otherClick")[0].className);
		}
	}
	function acquisition(id){//点击采集项目切换是否采集(除免冠照，其他)
		if($("#"+id)[0].className!=""){//“OK”样式切换，
			$("#"+id).removeClass($("#"+id)[0].className);
		}else{
			$("#"+id).attr('class','zzok')
		}
		var name=$("input[name='"+id+"']").val();  
		name==1?$("input[name='"+id+"']").val("0"):$("input[name='"+id+"']").val("1");//三目运算，给对应input赋值。
	}

	function submitForm(){//提交信息采集表单
		$("#informCollect").form('submit',{
			 url:'inforCollection/saveInforCollection',
			 success: function(data) {  
			    	$(':input','#informCollect').not(':button, :submit, :reset, :hidden').val('') 
			    	.removeAttr('checked') .removeAttr('selected');//清空弹窗form表单 
			    	$.messager.alert("提示", "保存成功！","info");
			    	
			 }  
		});
	}
	function sumbit_sure(){  
		var gnl=confirm("确定要提交?");  
		if (gnl==true){  
			return true;  
		}else{  
			return false;  
		}  
	}  
</script>
</html>