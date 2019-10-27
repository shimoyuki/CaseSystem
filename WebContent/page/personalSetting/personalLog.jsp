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
<title>个人日志</title>
<link rel="stylesheet" href="css/style.css" />
</head>
	<body>
		<div class="right-nr">
			<div class="right-navxj">
				<!-- <div class="bianji-top">
					<a href="" class="btn-bj"><img src="images/icon-bj.png" /></a>
					<div class="line-top-bj"></div>
				</div> -->
				<div class="personal-dairy">
					<div class="dairy-title">
						<span class="xingming">王翠花</span><span class="jinghao">警号032300</span>
					</div>
					<div class="dairy-search">
						<div class="sousuo">
							<input type="text" class="inp-search" placeholder="搜索" /><a href="" class="btn-sousuo"><img src="images/icon-search.png" /></a>
						</div>
						<span class="gaoji">高级</span>
						<select class="xiala-more">
							<option>选择次级维度</option>
						</select>
						<select class="xiala-more">
							<option>更多勾选项</option>
						</select>
					</div>
					<table class="dairy-tb">
							<tr>
								<th>日期</th>
								<th>时间</th>
								<th>类别</th>
								<th>内容</th>
								<th>备注</th>
							</tr>
							<tr>
								<td>2017-07-20</td>
								<td>11：25：36</td>
								<td>打开页面</td>
								<td>min.html</td>
								<td></td>
							</tr>
							<tr>
								<td>2017-07-20</td>
								<td>11：25：36</td>
								<td>打开页面</td>
								<td>min.html</td>
								<td></td>
							</tr>
						</table>
					<div class="dairy-page">
						<span>共50条,每页显示</span>
						<select class="xiala-page">
							<option>10</option>
						</select>
						<a href="" class="btn-fy"><</a>
						<ul class="num-page">
							<li><a href="" class="on">1</a></li>
							<li><a href="" class="">2</a></li>
							<li><a href="" class="">3</a></li>
							<li><a href="" class="">4</a></li>
							<li><a href="" class="">5</a></li>
							<li><a href="" class="">...</a></li>
						</ul>
						<a href="" class="btn-fy">></a>
						<span>第</span>
						<input type="text" class="inp-page" />
						<span>页</span>
					</div>
				</div>
			</div>
		</div>
				
	</body>
</html>