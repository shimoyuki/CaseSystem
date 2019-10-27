<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智慧警务</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/css.css" />
</head>
<body>
  <div class="bg-nav">
    <div class="nr-useful">
      <img src="images/gh-ico.png" />
      <div class="name-top">
        <img src="images/name-img.png" />
      </div>
      <div class="contro-nav">
        <div class="touxiang" style="border-radius:50%; overflow:hidden;">
        <img src="${policeMan.picture}"  width="100%"  height="100%">
        </div>
        <a href="" class="close-btn"></a>
      </div>
    </div>
    <div class="heng"></div>
    <div class="quanxian-nav">
      <div class="nr-l">
         <a href="user/firstRedirection?page=WLWKZXTSY" id="2" >
          <div id="物联网控制系统" name="top-privilete" class="l-top">
            <div class="icon-area">
              <img src="images/icon-01.png" />
            </div>
            <p>物联网控制系统</p>
          </div>
        </a>
        <a href="user/firstRedirection?page=businessHomePage" id="1" >
          <div id="标准化警务业务系统" name="top-privilete" class="l-dl">
            <div class="icon-area">
              <img src="images/icon-02.png" />
            </div>
            <p>标准化警务业务系统</p>
          </div>
        </a>
       <a href="" id="3"> 
          <div id="时钟服务器" name="top-privilete" class="l-dr">
            <div class="icon-area">
              <img src="images/icon-03.png" />
            </div>
            <p>时钟服务器</p>
          </div>
        </a>
      </div>
      <div class="nr-c">
        <a href="" id="4">
          <div id="门禁服务器" name="top-privilete" class="c-top-l">
            <div class="icon-area">
              <img src="images/icon-04.png" />
            </div>
            <p>门禁服务器</p>
          </div>
        </a>
        <a href="" id="6">
          <div id="触摸服务器" name="top-privilete" class="c-top-l">
            <div class="icon-area">
              <img src="images/icon-05.png" />
            </div>
            <p>触摸服务器</p>
          </div>
        </a>
        <a href="" id="5">
          <div id="车道闸" name="top-privilete" class="c-top-l">
            <div class="icon-area">
              <img src="images/icon-06.png" />
            </div>
            <p>车道闸</p>
          </div>
        </a>
        <a href="" id="7">
          <div id="储物柜" name="top-privilete" class="c-top-l">
            <div class="icon-area">
              <img src="images/icon-07.png" />
            </div>
            <p>储物柜</p>
          </div>
        </a>
      </div>
      <a href="" id="8">
        <div id="其他业务系统" name="top-privilete" class="nr-r">
          <p>其他业务系统</p>
        </div>
      </a>
    </div>
    <div class="cjl-kb"></div>
  </div>
</body>
<script type="text/javascript">
	$("div[name='top-privilete']").css("background-color", "rgba(11,5,52,0.7)");
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