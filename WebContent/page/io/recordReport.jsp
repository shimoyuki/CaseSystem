<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 时间格式化 -->
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
<title>档案报告</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div class="content">


		<div class="right-nr-rqbg">
			<div class="rqbg-tt">
				<div class="rqbg-tt-lt">
					<img src="images/rqbg-tt.jpg" />
				</div>
				<div class="rqbg-tt-rt">
					<p>
						<b>报告时间：</b><jsp:useBean id="now" class="java.util.Date" scope="page"/><fmt:formatDate value="${now}" pattern="yyyy年MM月dd日" />
					</p>
					<p>
						<b>档案编号：</b>${entry.recordNumber}
					</p>
				</div>
			</div>
			<div class="rqbg-fl">
				<a href="javascript:;" style="margin-left: 20%;">入区登记</a> <a
					href="javascript:;">人身安全检查</a> <a href="javascript:;">信息采集</a> <a
					href="javascript:;">入区活动记录</a> <a href="javascript:;">出区登记</a>
			</div>
			<!----------------------------------------------入区登记开始-------------------------------------------------------------------->
			<div class="flcontent" style="display: block;">
				<div class="flcontent-at">
					<div class="at-tt">
						<b>人员信息</b>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>姓名：</b>
						</div>
						<div class="at-tt-list-2">${entry.name}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>性别：</b>
						</div>
						<div class="at-tt-list-2">${entry.sex}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>民族：</b>
						</div>
						<div class="at-tt-list-2">${entry.nation}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>语言类型：</b>
						</div>
						<div class="at-tt-list-2">${entry.language}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>出生日期：</b>
						</div>
						<div class="at-tt-list-2">${entry.birthday}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>住址：</b>
						</div>
						<div class="at-tt-list-2">${entry.address}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>证件类型：</b>
						</div>
						<div class="at-tt-list-2">${entry.papersType}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>证件号码：</b>
						</div>
						<div class="at-tt-list-2">${entry.IDCode}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>联系方式：</b>
						</div>
						<div class="at-tt-list-2">${entry.telephone}</div>
					</div>
					<div class="at-tt-list">
						<div class="at-tt-list-1">
							<b>现住址：</b>
						</div>
						<div class="at-tt-list-2">${entry.currentAddr}</div>
					</div>

				</div>
				<!--左侧信息结束   开始右侧-->
				<div class="flcontent-rt">
					<div class="rt-tp">
						<div class="tp-1">
							<b>身份证照</b> <b>左侧照</b> <b>正面照</b> <b>右侧照</b>
						</div>
						<div style="width: 100%; height: 1px; background: #267DD2;"></div>
						<div class="tp-2">
							<div class="tp-2-list">
								<img src="${entry.IDPicture}" />
							</div>
							<div class="tp-2-list">
								<img src="${entry.leftView}" />
							</div>
							<div class="tp-2-list">
								<img src="${entry.frontalView}" />
							</div>
							<div class="tp-2-list">
								<img src="${entry.rightView}" />
							</div>
						</div>
					</div>
					<div class="rt-bt">
						<div class="rt-bt1">
							<div class="at-tt">
								<b>入区信息</b>
							</div>
							<div class="at-tt-list">
								<div class="at-tt-list-1">
									<b>入区时间：</b>
								</div>
								<div class="at-tt-list-2">${entry.entryTime}</div>
							</div>
							<div class="at-tt-list">
								<div class="at-tt-list-1">
									<b>入区身份：</b>
								</div>
								<div class="at-tt-list-2">${entry.personType}</div>
							</div>
							<div class="at-tt-list">
								<div class="at-tt-list-1">
									<b>入区手环：</b>
								</div>
								<div class="at-tt-list-2">${entry.recognition}</div>
							</div>
							<div class="at-tt-list">
								<div class="at-tt-list-1">
									<b>入区原因：</b>
								</div>
								<div class="at-tt-list-2">${entry.causeCode}</div>
							</div>
							<div class="at-tt-list">
								<div class="at-tt-list-1">
									<b>入区备注：</b>
								</div>
								<div class="at-tt-list-2">XXX伤害案件</div>
							</div>
						</div>
						<div class="rt-bt1 rt-bt2">
							<div class="at-tt">
								<b>签字确认</b>
							</div>
							<b
								style="width: 90%; height: 30px; margin-left: 10%; line-height: 30px; color: #267DD2; font-size: 16px;">业务干警：</b>
							<c:forEach items="${entryPolice}" var="e" varStatus="status">
								<div class="at-tt-list">
									<div class="at-tt-list-1"
										style="width: 80%; text-align: left; margin-left: 25px;">
										<b>警员姓名：</b>${e.entryPolice}
									</div>
									<div class="at-tt-list-1"
										style="width: 80%; text-align: left; margin-left: 25px;">
										<b>警员编号：</b>${e.code}
									</div>
								</div>
							</c:forEach>
							<b
								style="width: 90%; height: 30px; margin-left: 10%; line-height: 30px; float: left; color: #267DD2; font-size: 16px;">值班干警：</b>
							<div class="at-tt-list">
								<div class="at-tt-list-1"
									style="width: 80%; text-align: left; margin-left: 25px;">
									<b>警员姓名：</b>${entryDutyPolice.dutyPolice}
								</div>
								<div class="at-tt-list-1"
									style="width: 80%; text-align: left; margin-left: 25px;">
									<b>警员编号：</b>${entryDutyPolice.code}
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!----------------------------------------------入区登记结束   --人身安全检查开始-------------------------------------------------------------------->
			<div class="flcontent" style="display: none;">
				<div class="aqjc-1">
					<div class="aqjc-1-1">自述症状</div>
					<div class="aqjc-1-2"
						style="width: 1px; height: 60px; background: #267DD2; float: left; margin-left: 0.7%;"></div>
					<div class="aqjc-1-3">
						<p>
							<b>是否饮酒：</b>${personscrutiny.isDrink}
						</p>
						<p>
							<b>是否患有传染性疾病：</b>${personscrutiny.isContage}
						</p>
					</div>
					<div class="aqjc-1-4">${personscrutiny.readmeSymptom}</div>
				</div>
				<div style="clear: left;"></div>
				<div class="aqjc-2">
					<div class="aqjc-1-1">伤情检查</div>
					<div class="aqjc-2-2"
						style="width: 1px; height: 350px; background: #267DD2; float: left; margin-left: 0.7%;"></div>
					<div class="aqjc-2-big">
						<div class="aqjc-2-3">
							<div class="aqjc-2-3-1">
								<b>伤情图示区</b>
							</div>
							<div class="aqjc-2-3-2">
								<img src="images/rtt.jpg"></img>
							</div>
						</div>
						<div class="aqjc-2-4">
							<div class="aqjc-2-3-1">
								<b>伤情图示区</b>
							</div>
							<div class="aqjc-2-4-2">
								<div class="aqjc-2-4-2-tt">
									<p class="p1">序号</p>
									<p class="p2">伤情说明</p>
									<p class="p3">伤情描述</p>
									<p class="p1">附件照片</p>
								</div>
								<c:forEach items="${scarDetail}" var="e" varStatus="status">
									<div class="aqjc-2-4-2-ct">
										<p class="p1">${status.index + 1}</p>
										<p class="p2">${e.scarExplain}</p>
										<p class="p3">${e.scarDescribe}</p>
										<p class="p1 p4">${e.numImg}</p>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="aqjc-2-big-2">
							<c:forEach items="${scarPolice}" var="e" varStatus="status">
								<p>
									<b>伤情检查民警签字：</b>${e.scarPolice}（警号${e.code}）
								</p>
							</c:forEach>

							<p>
								<b>被检查人/监护人：</b>${scarParty.scarParty}
							</p>
						</div>
					</div>

				</div>
				<div style="clear: left;"></div>
				<div class="aqjc-3">
					<div class="aqjc-1-1">随身财物</div>
					<div class="aqjc-2-2"
						style="width: 1px; height: 350px; background: #267DD2; float: left; margin-left: 0.7%;"></div>
					<div class="aqjc-3-3">
						<div class="aqjc-3-3-1">
							<p>
								<b>手环编号：TN12</b>
							</p>
							<p>
								<b>对应保管柜号：06号</b>
							</p>
						</div>
						<table
							style="width: 100%; text-align: center; border: 0; margin-top: 5px;">
							<tr style="background: #267DD2; color: white;">
								<td>序号</td>
								<td>物品名称</td>
								<!-- <td>物品特征</td> -->
								<td>数量单位</td>
								<td>物品分类</td>
								<td>保管措施</td>
								<td>保管位置</td>
								<!-- <td>保管时间</td> -->
							</tr>
							<c:forEach items="${goods}" var="e" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${e.goodsName}</td>
									<!-- <td>Iphone6 plus</td> -->
									<td>${e.quantityUnits}</td>
									<td>${e.goodsType}</td>
									<td>${e.custody}</td>
									<td>${e.cabinetsNumber}</td>
									<!-- <td>2017-07-20 18:59</td> -->
								</tr>
							</c:forEach>
						</table>
						<div class="aqjc-3-3-2">
							<p>
								<b>涉案人员签字：</b>${goodsParty.goodsParty}
							</p>
							<p style="float: left;">
								<c:forEach items="${goodsPolice}" var="e" varStatus="status">
									<b>办案民警签字：</b>${e.goodsPolice}（警号：${e.code}）
								</c:forEach>
							</p>
							<p style="float: left;">
								<b>值班民警签字：</b>${goodsDutyPolice.dutyPolice}（警号：${goodsDutyPolice.dutyCode}）
							</p>

						</div>
					</div>
				</div>
			</div>
			<!---------------------------------------------人身安全检查结束   信息采集开始---------------------------------------------------------------------------->
			<div class="flcontent" style="display: none;">
				<div class="xxcj">
					<div class="xxcj-1">
						<p class="p1">信息采集表</p>
						<p class="p2">
							<b>采集时间：</b>2017-07-20 17:15<b> 至 </b>20:21<b>结束</b>
						</p>
						<p class="p3">
							<b>信息采集完整度：</b>90.9%
						</p>
					</div>
					<table style="width: 100%; text-align: center; margin-top: 5px;">
						<tr style="background: #267DD2; color: white;">
							<td>序号</td>
							<td>采集项目</td>
							<td>采集内容</td>
							<td>采集时间</td>
						</tr>
						<tr>
							<td>1</td>
							<td>免冠照</td>
							<td>${inforCollection.photo}</td>
							<td></td>
						</tr>
						<tr>
							<td>2</td>
							<td>身高</td>
							<td>${inforCollection.height}</td>
							<td></td>
						</tr>
						<tr>
							<td>3</td>
							<td>体重</td>
							<td>${inforCollection.weight}</td>
							<td></td>
						</tr>
						<tr>
							<td>4</td>
							<td>指纹</td>
							<td>${inforCollection.fingerprint}</td>
							<td></td>
						</tr>
						<tr>
							<td>5</td>
							<td>血样</td>
							<td>${inforCollection.blood}</td>
							<td></td>
						</tr>
						<tr>
							<td>6</td>
							<td>身体特征</td>
							<td>${inforCollection.bodyFeature}</td>
							<td></td>
						</tr>
						<tr>
							<td>7</td>
							<td>口音</td>
							<td>${inforCollection.accent}</td>
							<td></td>
						</tr>
						<tr>
							<td>8</td>
							<td>DNA</td>
							<td>${inforCollection.DNA}</td>
							<td></td>
						</tr>
						<tr>
							<td>9</td>
							<td>手机SIS</td>
							<td>${inforCollection.phoneSIS}</td>
							<td></td>
						</tr>
						<tr>
							<td>10</td>
							<td>其他采集项</td>
							<td>${inforCollection.otherProject}</td>
							<td></td>
						</tr>

					</table>
				</div>
			</div>
			<!--------------------------------------------信息采集结束    活动记录开始---------------------------------------------------------------->
			<div class="flcontent" style="display: none;">
				<div class="hdjl">
					<div class="hdjl-1">
						<p>
							<b>嫌疑人(王蓝)活动记录表</b>
						</p>
						<!-- <p>
							<b>羁押时长： 6小时 46分 58秒</b>
						</p> -->
					</div>
					<table style="width: 100%; text-align: center;">
						<tr style="background: #267DD2; color: white;">
							<td>序号</td>
							<td>活动项目</td>
							<td>房间</td>
							<td>开始时间</td>
							<td>结束时间</td>
							<td>内容记录</td>
							<td>备注</td>
						</tr>
						<c:forEach items="${activityrecord}" var="e" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${e.events}</td>
								<td>${e.roomCode}</td>
								<td>${e.enterTime}</td>
								<td>${e.leaveTime}</td>
								<td>${e.activity}</td>
								<td>${e.detail}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<!----------------------------------活动记录结束  出去登记开始--------------------------------------------------->
			<div class="flcontent" style="display: none;">
				<div class="cqdj">
					<div class="cqdj-1">
						<img src="images/sj.png" width="30px" height="30px"
							style="float: left;" />
						<p style="float: left;">临时离区记录</p>
					</div>
					<table style="width: 100%; text-align: center; margin-top: 10px;">
						<tr style="background: #267DD2; color: white;">
							<td>序号</td>
							<!-- <td>姓名</td>
							<td>手环ID</td> -->
							<td>离开时间</td>
							<td>返回时间</td>
							<td>离开事由</td>
							<td>经办民警</td>
						</tr>
						<c:forEach items="${tempOut}" var="e" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${e.tempOutTime}</td>
								<td>${e.returnTime}</td>
								<td>${e.tempOutCause}</td>
								<td>
									<c:forEach items="${e.tempoutPolicemen}" var="tp" varStatus="status">
										${tp.tempoutPolice}  
									</c:forEach>
								</td>
							</tr>
						</c:forEach>
						<!-- <tr>
							<td colspan="7" style="color: red;"><b
								style="color: #267DD2;">临时出区办案负责人签字：</b>王正义</td>
						</tr> -->

					</table>
					<div class="cqdj-1" style="margin-top: 20px;">
						<img src="images/sj.png" width="30px" height="30px"
							style="float: left;" />
						<p style="float: left;">临时离区记录</p>
					</div>
					<div class="cqdj-2">
						<p>
							<b>离开时间：</b>${finalLeave.leaveTime}
						</p>
						<p style="color: red;">
							<b>羁押时长：</b>${detentionTime}
						</p>
						<p>
							<b>离区原因：</b>${finalLeave.leaveCause}
						</p>
					</div>
					<div class="cqdj-3">
						<p>
							<b>随身物品返还情况表：</b>${finalLeave.goodsDispose}
						</p>
						<p>
							<b>手环编号：</b>${entry.recognition}
						</p>
						<p>
							<b>对应保管柜号：</b>06号
						</p>
					</div>
					<table style="width: 100%; text-align: center; margin-top: 10px;">
						<tr style="background: #267DD2; color: white;">
							<td>序号</td>
							<td>物品名称</td>
							<!-- <td>物品特征</td> -->
							<td>数量单位</td>
							<td>物品分类</td>
							<!-- <td>离开保管措施</td> -->
							<td>返还情况</td>
							<td>返还时间</td>
						</tr>
						<!-- <tr>
							<td>1</td>
							<td>钱包</td>
							<td>范思哲真皮</td>
							<td>1个</td>
							<td>随身财物</td>
							<td>出区返还</td>
							<td>已返还</td>
							<td>2017-07-20 20:26:58</td>
						</tr> -->
						<c:forEach items="${returnGoods}" var="e" varStatus="status">
							<tr>
									<td>${status.index + 1}</td>
									<td>${e.goodsName}</td>
									<!-- <td>Iphone6 plus</td> -->
									<td>${e.quantityUnits}</td>
									<td>${e.goodsType}</td>
									<td>${e.handling}</td>
									<td>${e.handlingTime}</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="2"><b style="color: #267DD2;">领取人签字：</b>${finalLeave.goodsDispose}</td>
							<td colspan="3"><b style="color: #267DD2;">领取人身份证号：</b>${finalLeave.receiptorID}
							</td>
							<td colspan="3"><b style="color: #267DD2;">领取时间：</b>
								${finalLeave.receiptorTime}
							</td>
						</tr>

					</table>
					<div class="cqdj-4">
						<!-- <p class="p1">
							<b>办案民警签字：</b>王强(123456)&nbsp;&nbsp;&nbsp;&nbsp;张三(235681)
						</p> -->
						<p class="p2">
							<b>管理员签字：</b>${finalLeave.leaveAdmin}<!-- （564874） -->
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
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