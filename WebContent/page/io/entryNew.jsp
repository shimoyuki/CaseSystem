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
<title>入区登记</title>
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
<!-- 读卡器 -->
<!-- <script src="js/idCardReader/jquery-1.4.2.min.js"></script> -->
<script type="text/javascript"
	src="js/idCardReader/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="js/idCardReader/baseISSObject.js"></script>

<script type="text/javascript" src="js/idCardReader/baseISSObject.js"></script>
<script type="text/javascript" src="js/idCardReader/baseISSOnline.js"></script>
<script type="text/javascript" src="js/idCardReader/common.js"></script>
<!-- 拍照 -->
<script type="text/javascript" src="js/entryCamera.js"></script>
<style type="text/css">
.borderstyle{
	        -webkit-background-size: cover; 
           -moz-background-size: cover; 
             -o-background-size: cover; 
                background-size: cover; 
}
</style>
<meta http-equiv="Content-Type" content="application/msword">
</head>
<body>

	<div class="right-nr" style="position: relative;">
		<div class="rqdl">
			<h3 style="float: left;">入区信息登记</h3>
			<div class="sfxzxl">
				<p>
					<b>入区身份：</b><select name="personType"
								id="personType"
								style="width: 100px; height: 20px; font-size: 13px; border: 1px solid teal">
							</select>
				</p>
			</div>
			<div style="clear: left;"></div>
			<table style="margin-top: 20px;">
				<tr style="background: white;">

					<td>手环：<span class="bule"><input name="recognition" id="recognition"
							style="width: 100px; border: none;"></span></td>
					<td>入区原因：<span class="bule">抓捕<a href=""><img
								src="images/xsj.jpg"></a></span></td>
					<td>入区时间：<span>2017-05-20 11:20:36</span></td>
				</tr>
				<tr>
					<td style="color: #434343;">档案编号：<span style="color: #0361ad;">20170520A</span></td>
					<td></td>
					<td style="color: #434343;">入区备注：<span style="color: #0361ad;">315特大杀人案</span></td>
				</tr>
			</table>
		</div>
		<div class="sfdl">
			<h3>身份信息登记</h3>
			<div class="sfdl-l">
				<p style="float: left;">
					证件类型：<span class="bule">身份证<a href=""><img
							src="images/xsj.jpg"></a></span>
				</p>
				<a href="javascript:;"
					style="display: block; width: 120px; height: 30px; text-align: center; line-height: 30px; color: white; background: #267DD2; float: left; border-radius: 5px;">二代身份证</a>
				<div style="clear: left;"></div>
				<div class="tpwz1" style="position: relative;">
					<p style="margin-top: 5px;">
						<b>姓名：</b> <input type="text" style="margin-left: -50px;" />
					</p>
					<p style="width: 100%; height: 0; clear: left;"></p>
					<p style="float: left; width: 50%; margin-top: -10px;">
						<b>性别：</b> <input type="text" />
					</p>
					<p style="float: left; width: 50%; margin-top: -10px;">
						<b>民族：</b> <input type="text" />
					</p>
					<p style="clear: left; width: 90%; margin-top: -10px;">
						<b>出生日期：</b> <input type="text"
							style="margin-left: -15px; width: 40%;" />
					</p>
					<p style="width: 90%; margin-top: -5px;">
						<b>住址：</b><input type="text"
							style="margin-left: -40px; width: 80%;" />
					</p>
					<p style="width: 90%; margin-top: 0px;">
						<b>身份证号：</b> <input type="text"
							style="margin-left: -15px; width: 70%;" />
					</p>
					<div class="sfzz"
						style="width: 102px; height: 126px; background: #EEEEEE; position: absolute; top: 5px; right: 10px;">
						<img src="images/sfzz.jpg" width="100%" />
					</div>
				</div>
				<div class="tpwz2">
					<img id="left" src="images/pic-1.jpg"  width="100%" height="100%">
				</div>
				<div class="tpwz2">
					<img id="front" src="images/pic-2.jpg"  width="100%" height="100%">
				</div>
				<div class="tpwz2">
					<img id="right" src="images/pic-3.jpg"  width="100%" height="100%">
				</div>
				<!-- 此div是将图片的值转换保存为字符串便于向后台传值，隐藏不显示 -->
				<div style="display: none;">
					<input id="f" name="frontalView"> <input id="r"
						name="rightView"> <input id="l" name="leftView">
				</div>
				<div class="tpwz2" style="box-shadow: none;">
					<a class="tcy" onclick="init(this)"><img src="images/sxt.jpg"></a>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="lxfs">
				<table>
					<tr style="background: white;">
						<td>语种类型：<span class="bule"> <select>
									<option>汉语</option>
							</select>
						</span>
						</td>
						<td>联系方式：<span class="wbule"> <input type="text"
								style="width: 110px; height: 20px; line-height: 20px; color: #267DD2;" />
						</span></td>
						<td>现住址：<span class="wbule"> <input type="text"
								style="width: 220px; height: 20px; line-height: 20px; color: #267DD2;" />
						</span></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="qrqz">
			<h3>签字确认</h3>
			<div class="tjqm">添加签名</div>
			<div class="qrqzn" style="width: 70%;">
				<ul>
					<li>业务干警:<input type="text" />
					</li>
					<li>警员编号：<input type="text" /></li>
				</ul>
				<ul>
					<li>业务干警：<input type="text" /></li>
					<li>警员编号：<input type="text" /></li>
				</ul>
				<ul>
					<li>业务干警：<input type="text" /></li>
					<li>警员编号：<input type="text" /></li>
				</ul>
			</div>
			<div class="fgx"></div>
			<div class="qrqzn-1">
				<ul>
					<li>值班干警：<input type="text" /></li>
					<li>警员编号：<input type="text" /></li>
				</ul>
			</div>

		</div>
		<a href="" class="baocun">保存</a>
		<div class="tcc">
			<div class="tcc-tt">
				<a href="javascript:;" class="tcc-close"
					style="width: 60px; height: 30px; color: white; background: #2fa8dd; line-height: 30px; float: right; text-align: center; font-size: 20px;"><b>X</b></a>
			</div>
			<div class="tcclist-con">
				<div class="tcclist">
					<div class="tcclist-pic">
						<!-- <img src="images/pic-1.jpg" /> -->
						<canvas id="leftcanvas" width="154px" height="150px"
							class="borderstyle"></canvas>
					</div>
					<div class="tcclist-p2">
						<img src="images/sxt2.jpg" />
					</div>
					<a id="leftPhoto" onclick="photo(id)" class="tcclist-btn">点击拍照</a>
				</div>
				<div class="tcclist">
					<div class="tcclist-pic">
						<!-- <img src="images/pic-2.jpg" /> -->
						<canvas id="frontcanvas" width="154px" height="150px"
							class="borderstyle"></canvas>
					</div>
					<div class="tcclist-p2">
						<img src="images/sxt2.jpg" />
					</div>
					<a id="frontPhoto" onclick="photo(id)" class="tcclist-btn">点击拍照</a>
				</div>
				<div class="tcclist">
					<div class="tcclist-pic">
						<!-- <img src="images/pic-3.jpg" /> -->
						<canvas id="rightcanvas" width="154px" height="150px"
							class="borderstyle"></canvas>
					</div>
					<div class="tcclist-p2">
						<img src="images/sxt2.jpg" />
					</div>
					<a id="rightPhoto" onclick="photo(id)" class="tcclist-btn">点击拍照</a>
				</div>
				<div class="tcclist tcclist1">
					<video id="navy_video" width="155px" height="260px" autoplay class="borderstyle"></video>
				</div>
			</div>
			<div class="tcclist2">
				<a href="" class="baocunbtn">保存</a>
			</div>
		</div>
		<!-------------------------------------借用办案区---------------------------------------------------->
		<div class="jybaq">
			<div class="jybaq-1">
				<b>交城县公安局天宁派出所办案中心借用管理</b>
			</div>
			<div class="jybaq-2">
				<img src="images/jybaq.jpg" />
			</div>
			<div class="jybaq-3">
				<div class="jybaq-3-1">
					<img src="images/renwu-tx.jpg" />
				</div>
				<div class="jybaq-3-2">
					<ul>
						<li>
							<p>警员编号:</p> <input type="text" value="警员编号即为登录账号" />
						</li>
						<li>
							<p>输入密码:</p> <input type="text" />
						</li>
						<li>
							<p>确认密码:</p> <input type="text" />
						</li>
						<li>
							<p>姓名:</p> <input type="text" />
						</li>

						<li>
							<p>性别:</p> <select>
								<option>男</option>
								<option>女</option>
						</select>
							<p>出生日期:</p> <select>
								<option>1978-02-25</option>
								<option>1985-12-30</option>
						</select>
						</li>
						<li>
							<p>工作单位:</p> <input type="text" />
						</li>
						<li>
							<p>部门:</p> <select>
								<option>部门选择</option>
								<option>接待部</option>
						</select>
							<p>职位:</p> <select>
								<option>职务选择</option>
								<option>所长</option>
						</select>
						</li>
					</ul>
				</div>
			</div>
			<div style="clear: left;"></div>
			<div class="jybaq-4">
				<a href="javascript:;">保存</a>
			</div>
		</div>
	</div>
</body>


<script type="text/javascript">
	function F_Open_dialog(data) {
		document.getElementById(data.id + "View").click();
	}
	function selectImage(file) {
		if (!file.files || !file.files[0]) {
			return;
		}
		var reader = new FileReader();
		reader.onload = function(evt) {
			document.getElementById(file.id.replace("View", "")).src = evt.target.result;
			$("#" + file.id.substring(0, 1)).attr("value", evt.target.result);
		}
		reader.readAsDataURL(file.files[0]);
	}
	function addOrder() {
		var ul = "<ul><li>业务干警：<input  name='entryPolice'style='width: 120px;height:25px;'></li>"
				+ "<li>警员编号：<input  name='code'style='width: 120px;height:25px;'></li></ul>";
		$("#entryPolice").append(ul);
	}
	function deleteOrder() {//删除业务干警签名输入框
		var Child = document.getElementById('entryPolice').lastChild;
		document.getElementById('entryPolice').removeChild(Child);
	}
	//得到当前日期 24小时制
	function sup(n) {
		return (n < 10) ? '0' + n : n;
	}
	formatterDate = function(date) {
		var myDate = new Date();
		var date = myDate.getFullYear() + "-" + sup(myDate.getMonth()) + "-"
				+ sup(myDate.getDate());
		var time = sup(myDate.getHours()) + ":" + sup(myDate.getMinutes())
				+ ":" + sup(myDate.getSeconds());
		return (date + " " + time);
	};
	$(document).ready(function() {
		$("#entryTime").val(formatterDate(new Date())); //入区时间

		$("#causeCode").combobox({
			url : 'infoHeader/getListByCodeName?codeName=causeCode',
			valueField : 'code',
			textField : 'name'
		});
		$("#personType").combobox({
			url : 'infoHeader/getListByCodeName?codeName=personType',
			valueField : 'code',
			textField : 'name'
		});
		$("#papersType").combobox({
			url : 'infoHeader/getListByCodeName?codeName=papersType',
			valueField : 'code',
			textField : 'name'
		});
		$("#language").combobox({
			url : 'infoHeader/getListByCodeName?codeName=language',
			valueField : 'code',
			textField : 'name',
			value : "1"
		});
	});
	$("#personType").combobox({//根据入区身份选中自动生成档案号
		onChange : function(n, o) {
			var personType = $('#personType').combobox('getValue');
			$.ajax({
				type : "POST",
				url : 'entry/createRecordNumber',
				data : {
					"personType" : personType
				},
				success : function(data) {
					$('#recordNumber').val(data);
				}
			});
		}

	});
	function saveEntry() {//入区登记
		$('#loginForm').form(
				'submit',
				{
					url : 'entry/saveEntry',
					success : function(data) {
						$(':input', '#loginForm').not(
								':button, :submit, :reset, :hidden').val('')
								.removeAttr('checked').removeAttr('selected');//清空弹窗form表单 
						$.messager.alert("提示", "保存成功！", "info");

					}
				});
	}
	function sumbit_sure() {
		var gnl = confirm("确定要提交?");
		if (gnl == true) {
			return true;
		} else {
			return false;
		}
	}
	$(function() {
		$(".tcy").click(function() {
			$(".tcc").show();
		});
		$(".tcc-close").click(function() {
			$(".tcc").hide();
		});
		$("tr:even").addClass("even");
		$("tr:odd").addClass("odd");
		$(".rqbg-fl").find("a").click(function() {
			var index = $(this).index();
			$(".flcontent").eq(index).show().siblings(".flcontent").hide();
		})
	});
</script>
</html>