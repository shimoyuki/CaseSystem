<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>智慧警务</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css" />
  </head>
  <body style="background:#fff;">
    <div class="bg-nav-02">
      <div class="nr-useful">
        <img src="${pageContext.request.contextPath}/images/gh-ico.png" />
        <div class="name-top">
          <img src="${pageContext.request.contextPath}/images/wlwkz-img.png" /> 
        </div>
        <div class="contro-nav">
          <div class="touxiang"></div>
          <a href="" class="close-btn"></a>
        </div>
      </div>
      <div class="heng"></div>
    </div>
    <ul class="contro-wlw">
      <li>
        <a href="" id="201">
          <div class="qbnr">
            <div class="icon-area"><img src="${pageContext.request.contextPath}/images/icon-12.png" /></div>
            <p>系统设置</p>
          </div>
        </a>
      </li>
      <li>
         <a href="" id="202">
          <div class="qbnr">
            <div class="icon-area"><img src="${pageContext.request.contextPath}/images/icon-13.png" /></div>
            <p>设备管理</p>
          </div>
        </a>
      </li>
      <li>
         <a href="" id="203">
          <div class="qbnr" ">
            <div class="icon-area"><img src="${pageContext.request.contextPath}/images/icon-14.png" /></div>
            <p>策略管理</p>
          </div>
        </a>
      </li>
      <li>
          <a href="" id="204">
          <div class="qbnr">
            <div class="icon-area"><img src="${pageContext.request.contextPath}/images/icon-15.png" /></div>
            <p>统计报表</p>
          </div>
        </a>
      </li>
      <li>
         <a href="" id="205">
          <div class="qbnr">
            <div class="icon-area"><img src="${pageContext.request.contextPath}/images/icon-16.png" /></div>
            <p>其他</p>
          </div>
        </a>
      </li>
    </ul>
  </body>
 <script type="text/javascript">
	/* $("div[name='top-privilete']").css("background-color", "rgba(11,5,52,0.7)"); */
	var user = "<%=session.getAttribute("user")%>";
	var menuSet = "<%=session.getAttribute("disabledMenu")%>";//不可用的权限
	var menuArray = menuSet.substring(1, menuSet.length-1).split(",");//获取权限数组
	for (var i = 0; i <  menuArray.length; i++) {
		if(document.getElementById(menuArray[i].trim())){
			document.getElementById(menuArray[i].trim()).style.background = "rgba(238,238,238,0.9)";
			var a = document.getElementById(menuArray[i].trim());
			a.href="javascript:;"; 
			a.style.cursor="default";
		}
	}
</script>
</html>