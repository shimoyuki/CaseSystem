<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>案件管理系统</title>
<!-- <link rel="stylesheet" href="css/main.css" type="text/css"></link>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="jquery-easyui/js/html5shiv.js"></script>
<script type="text/javascript" src="jquery-easyui/js/respond.min.js"></script> -->
<style type="text/css">
	/* table {
  border-collapse: collapse;
  border: 1px solid #000;
  color:#D7E9F9;
  margin:10px 0px;
  }
td{
  border: 1px dotted #03476F;
  padding: .4em;
  color: #363636;
  }
table td:hover {
  background:red;
  border: 1px solid #03476F;
  } */
</style>
</head>
<body>
				<!-- <form id="loginForm" method="post" action="braceletMange/saveBracelet" 
					class="form-horizontal" role="form">
					<div class="form-group">
						<label for="name" class="col-sm-4 control-label">用户名:
							</h2>
						</label>
						<div class="col-sm-6">
							<input type="text" id="name" name="name"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-4 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码:
							</h2>
						</label>
						<div class="col-sm-6">
							<input type="password" id="pass" name="pass"
								class="form-control">
						</div>
					</div>
					<div class="form-group" id="c1">
						<div class="col-sm-offset-4 col-sm-10">
							<button type="submit" class="btn btn-success ">登录</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-success ">重置</button>
						</div>
					</div>
				</form> -->

 
 
 <!-- <table  border="1" width="100%" height="100%" align="center" valign="middle" cellpadding="0" cellspacing="0" style="background:url(jquery-easyui/images/1.jpg) no-repeat;
 filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='jquery-easyui/images/1.jpg',sizingMethod='scale'); background-size:100% 100%; " id="tableTime" class="tableTime">
	<tr>
		<td onclick="copyText(id)" id="td1">1</td>
		<td onclick="copyText(id)" id="td2">2</td>
		<td onclick="copyText(id)" id="td3">3</td>
	</tr>
	<tr>
		<td onclick="copyText(id)" id="td4">4</td>
		<td onclick="copyText(id)" id="td5">5</td>
		<td onclick="copyText(id)" id="td6">6</td>
	</tr>
	<tr>
		<td onclick="copyText(id)" id="td7">7</td>
		<td onclick="copyText(id)" id="td8">8</td>
		<td onclick="copyText(id)" id="td9">9</td>
	</tr>
</table> -->
 
 <div id="newDepartment" class=" easyui-dialog"
		style="top: 40px; padding: 5px; width: 700px; height: 400px;"
		title="添加部门" iconCls="icon-remove" closed="true" modal="true">

		<form id="newDepartment_form" name="ff" enctype="multipart/form-data"
			method="post" action="braceletMange/saveBracelet" >

			<table style="width: 100%; font-size: 12px; font-weight: normal">
				
				<tr>
					<td class="td1">手环编号:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="code" 
						style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td class="td1">绑定设备状态:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="state" style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td class="td1">所属派出所:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="policeStation" style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td class="td1">备注:</td>
					<td style="width: 70%"><input class="easyui-textbox"
						type="text" name="detail" style="width: 100px; height: 30px;"></td>
				</tr>
				<tr>
					<td style="text-align: right" colspan=2><input type="button"
						onclick="newDepartment_cancel()" class="subbtn" value="取消"> <input
						type="submit" class="subbtn" value="提交"></td>
				</tr>

			</table>
		</form>
	</div>

	<!-- <script type="text/javascript"
		src="jquery-easyui/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="jquery-easyui/js/jquery.validate.js"></script>
	<script type="text/javascript" src="jquery-easyui/js/form.js"></script>
	<script type="text/javascript" charset="utf-8">
		 MyValidator.init();
	</script> -->
	
	<script type="text/javascript">
        
       /*  function copyText(id){
        	//alert(111);
        	var obj=window.document.getElementById(id);
        	var bg=obj.style.backgroundColor;
        	if(bg=='') {obj.style.backgroundColor='#f00'
        	}else {obj.style.backgroundColor=''}
        } */
</script>
</body>
</html>

 
 
 
 
 
 
<%--  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>案件管理系统</title>
<style>
*{margin:0;padding:0;}
	.fa{width:740px;margin:0 auto;}
	.top{margin:20px 0;}
	.top input{width:25px;height:25px;border:1px solid #fff;border-radius:4px;background:#ddd;}
	.top .i1{background:#000000;}
	.top .i2{background:#FF0000;}
	.top .i3{background:#80FF00;}
	.top .i4{background:#00FFFF;}
	.top .i5{background:#808080;}
	.top .i6{background:#FF8000;}
	.top .i7{background:#408080;}
	.top .i8{background:#8000FF;}
	.top .i9{background:#CCCC00;}
	#canvas{background:#eee;cursor:default;}
	.font input{font-size:14px;}
	.top .grea{background:#aaa;}
	</style>
</head>
<body>
	<div class="fa">
    <div class="top">
        <div id="color">
            请选择画笔颜色：
            <input class="i1" type="button" value="" />
            <input class="i2" type="button" value="" />
            <input class="i3" type="button" value="" />
            <input class="i4" type="button" value="" />
            <input class="i5" type="button" value="" />
            <input class="i6" type="button" value="" />
            <input class="i7" type="button" value="" />
            <input class="i8" type="button" value="" />
            <input class="i9" type="button" value="" />
        </div>
        <div class="font" id="font">
            请选择画笔的宽度：
            <input type="button" value="细" />
            <input type="button" value="中" class="grea"/>
            <input type="button" value="粗" />
        </div>
        <div>
            <span id="error">如果有错误，请使用橡皮擦：</span>
            <input id="eraser" style="width:60px;font-size:14px;"type="button" value="橡皮擦" />
        </div>
		<input id="clear" type="button" value="清除画布" style="width:80px;"/>
		<input id="revocation" type="button" value="撤销" style="width:80px;"/>
		<input id="imgurl" type="button" value="导出图片路径" style="width:80px;"/>
    </div>
    <canvas id="canvas" width="740" height="420" style="background-image: url(jquery-easyui/images/1.jpg);">您的浏览器不支持 canvas 标签</canvas>
    <div id="div1"></div>
</div>
<div id="html">

</div>
<script>
(function(){
    var paint={
        init:function()
        {
            this.load();
            
        },
        load:function()
        {   
            this.x=[];//记录鼠标移动是的X坐标
            this.y=[];//记录鼠标移动是的Y坐标
            this.clickDrag=[];
            this.lock=false;//鼠标移动前，判断鼠标是否按下
            this.isEraser=false;
            //this.Timer=null;//橡皮擦启动计时器
            //this.radius=5;
            this.storageColor="#000000";
            this.eraserRadius=15;//擦除半径值
            this.color=["#000000","#FF0000","#80FF00","#00FFFF","#808080","#FF8000","#408080","#8000FF","#CCCC00"];//画笔颜色值
            this.fontWeight=[2,5,8];
            this.$=function(id){return typeof id=="string"?document.getElementById(id):id;};
            this.canvas=this.$("canvas");
            if (this.canvas.getContext) {
            } else {
                alert("您的浏览器不支持 canvas 标签");
                return;
            }
            this.cxt=this.canvas.getContext('2d');
            this.cxt.lineJoin = "round";//context.lineJoin - 指定两条线段的连接方式
            this.cxt.lineWidth = 5;//线条的宽度
            this.iptClear=this.$("clear");
            this.revocation=this.$("revocation");
            this.imgurl=this.$("imgurl");//图片路径按钮
            this.w=this.canvas.width;//取画布的宽
            this.h=this.canvas.height;//取画布的高 
            this.touch =("createTouch" in document);//判定是否为手持设备
            this.StartEvent = this.touch ? "touchstart" : "mousedown";//支持触摸式使用相应的事件替代
	        this.MoveEvent = this.touch ? "touchmove" : "mousemove";
	        this.EndEvent = this.touch ? "touchend" : "mouseup";
	        this.bind();
        },
        bind:function()
        {
            var t=this;
            /*清除画布*/
            this.iptClear.onclick=function()
            {
                t.clear();
            };
            /*鼠标按下事件，记录鼠标位置，并绘制，解锁lock，打开mousemove事件*/
            this.canvas['on'+t.StartEvent]=function(e)
            {   
                var touch=t.touch ? e.touches[0] : e; 
                var _x=touch.clientX - touch.target.offsetLeft;//鼠标在画布上的x坐标，以画布左上角为起点
                var _y=touch.clientY - touch.target.offsetTop;//鼠标在画布上的y坐标，以画布左上角为起点             
                if(t.isEraser)
                {
                /*
                    t.cxt.globalCompositeOperation = "destination-out";
                    t.cxt.beginPath();
                    t.cxt.arc(_x, _y,t.eraserRadius, 0, Math.PI * 2);
                    t.cxt.strokeStyle = "rgba(250,250,250,0)";
                    t.cxt.fill();
                    t.cxt.globalCompositeOperation = "source-over";
                    */
                    t.resetEraser(_x,_y,touch);
                }else
                {
                    t.movePoint(_x,_y);//记录鼠标位置
                    t.drawPoint();//绘制路线
                }
                t.lock=true;
            };
            /*鼠标移动事件*/
            this.canvas['on'+t.MoveEvent]=function(e)
            {
                var touch=t.touch ? e.touches[0] : e;
                if(t.lock)//t.lock为true则执行
                {
                    var _x=touch.clientX - touch.target.offsetLeft;//鼠标在画布上的x坐标，以画布左上角为起点
                    var _y=touch.clientY - touch.target.offsetTop;//鼠标在画布上的y坐标，以画布左上角为起点
                    if(t.isEraser)
                    {
                        //if(t.Timer)clearInterval(t.Timer);
                        //t.Timer=setInterval(function(){
                            t.resetEraser(_x,_y,touch);
                        //},10);
                    }
                    else
                    {
                        t.movePoint(_x,_y,true);//记录鼠标位置
                        t.drawPoint();//绘制路线
                    }
                }
            };
            this.canvas['on'+t.EndEvent]=function(e)
            {
                /*重置数据*/
                t.lock=false;
                t.x=[];
                t.y=[];
                t.clickDrag=[];
                clearInterval(t.Timer);
                t.Timer=null;
                
            };
            this.revocation.onclick=function()
            {
                t.redraw();
            };
            this.changeColor();
            this.imgurl.onclick=function()
            {
                t.getUrl();
            };
            /*橡皮擦*/
            this.$("eraser").onclick=function(e)
	        {
	            t.isEraser=true;
                t.$("error").style.color="red";
                t.$("error").innerHTML="您已使用橡皮擦！";
	        };
        },
        movePoint:function(x,y,dragging)
        {   
            /*将鼠标坐标添加到各自对应的数组里*/
            this.x.push(x);
            this.y.push(y);
            this.clickDrag.push(y);
        },
        drawPoint:function(x,y,radius)
        {
            for(var i=0; i < this.x.length; i++)//循环数组
            {   
                this.cxt.beginPath();//context.beginPath() , 准备绘制一条路径
                
                if(this.clickDrag[i] && i){//当是拖动而且i!=0时，从上一个点开始画线。
                    this.cxt.moveTo(this.x[i-1], this.y[i-1]);//context.moveTo(x, y) , 新开一个路径，并指定路径的起点
                }else{
                    this.cxt.moveTo(this.x[i]-1, this.y[i]);
                }
                this.cxt.lineTo(this.x[i], this.y[i]);//context.lineTo(x, y) , 将当前点与指定的点用一条笔直的路径连接起来
                this.cxt.closePath();//context.closePath() , 如果当前路径是打开的则关闭它
                this.cxt.stroke();//context.stroke() , 绘制当前路径
            }
        },
        clear:function()
        {
            this.cxt.clearRect(0, 0, this.w, this.h);//清除画布，左上角为起点
        },
        redraw:function()
        {  
            /*撤销*/
            this.cxt.restore();  
            
        },  
        preventDefault:function(e){
            /*阻止默认*/
            var touch=this.touch ? e.touches[0] : e;
		    if(this.touch)touch.preventDefault();
		    else window.event.returnValue = false;
	    },
	    changeColor:function()
	    {
	        /*为按钮添加事件*/
	        var t=this,iptNum=this.$("color").getElementsByTagName("input"),fontIptNum=this.$("font").getElementsByTagName("input");
	        for(var i=0,l=iptNum.length;i<l;i++)
	        {
	            iptNum[i].index=i;
	            iptNum[i].onclick=function()
	            {
	                t.cxt.save();
	                t.cxt.strokeStyle = t.color[this.index];
	                t.storageColor=t.color[this.index];
	                t.$("error").style.color="#000";
	                t.$("error").innerHTML="如果有错误，请使用橡皮擦：";
	                t.cxt.strokeStyle = t.storageColor;
	                t.isEraser=false;
	            }
	        }
	        for(var i=0,l=fontIptNum.length;i<l;i++)
	        {
	            t.cxt.save();
	            fontIptNum[i].index=i;
	            fontIptNum[i].onclick=function()
	            {
	                t.changeBackground(this.index);
	                t.cxt.lineWidth = t.fontWeight[this.index];
	                t.$("error").style.color="#000";
	                t.$("error").innerHTML="如果有错误，请使用橡皮擦：";
	                t.isEraser=false;
	                t.cxt.strokeStyle = t.storageColor;
	            }
	        }
	    },
	    changeBackground:function(num)
	    {
	        /*添加画笔粗细的提示背景颜色切换，灰色为当前*/
	        var fontIptNum=this.$("font").getElementsByTagName("input");
	        for(var j=0,m=fontIptNum.length;j<m;j++)
            {
                fontIptNum[j].className="";
                if(j==num) fontIptNum[j].className="grea";
            }
	    },
	    getUrl:function()
	    {
           this.$("html").innerHTML=this.canvas.toDataURL();
        },
        resetEraser:function(_x,_y,touch)
	    {   
	        
	        /*使用橡皮擦-提醒*/
	        var t=this;
            //this.cxt.lineWidth = 30;
            /*source-over 默认,相交部分由后绘制图形的填充(颜色,渐变,纹理)覆盖,全部浏览器通过*/
            t.cxt.globalCompositeOperation = "destination-out";
            t.cxt.beginPath();
            t.cxt.arc(_x, _y, t.eraserRadius, 0, Math.PI * 2);
            t.cxt.strokeStyle = "rgba(250,250,250,0)";
            t.cxt.fill();
            t.cxt.globalCompositeOperation = "source-over"
	    }
    };
    paint.init();
})();
</script>
</body>

</body>
</html> --%>
 
 
 