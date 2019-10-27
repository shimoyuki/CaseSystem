function init(t) {
	accessLocalWebCam("navy_video");
}

window.URL = window.URL || window.webkitURL || window.msURL || window.oURL;
navigator.getUserMedia = navigator.getUserMedia|| navigator.webkitGetUserMedia || navigator.mozGetUserMedia|| navigator.msGetUserMedia;

function isChromiumVersionLower() {
	var ua = navigator.userAgent;
	var testChromium = ua
	.match(/AppleWebKit\/.* Chrome\/([\d.]+).* Safari\//);
	return (testChromium && (parseInt(testChromium[1].split('.')[0]) < 19));
}

function successsCallback(stream) {
	//document.getElementById('camera_errbox').style.display = 'none';
	document.getElementById('navy_video').src = (window.URL && window.URL.createObjectURL) ? window.URL.createObjectURL(stream): stream;
	/*onppp();*/
}

function errorCallback(err) {
	
}

function accessLocalWebCam(id) {
	try {
		navigator.getUserMedia({
			video : true
		}, successsCallback, errorCallback);
	} catch (err) {
		
		navigator.getUserMedia('video', successsCallback, errorCallback);
	}
}


window.addEventListener("DOMContentLoaded", function() {
	var canvas = document.getElementById("leftcanvas"),
	context = canvas.getContext("2d"), video = document.getElementById("navy_video"), videoObj = {
		"video" : true
	}, errBack = function(error) {
		console.log("相机调用失败...", error.code);
	};

	if (navigator.getUserMedia) {
		navigator.getUserMedia(videoObj, function(stream) {
			video.src = stream;
			video.play();
		}, errBack);
	} else if (navigator.webkitGetUserMedia) {
		navigator.webkitGetUserMedia(videoObj, function(stream) {
			video.src = window.webkitURL.createObjectURL(stream);
			video.play();
		}, errBack);
	} else if(navigator.mozGetUserMedia) { 
        navigator.mozGetUserMedia(videoObj, function(stream){  
            video.src = window.URL.createObjectURL(stream);  
            video.play();  
        }, errBack);  
    }  
	
	document.getElementById("leftPhoto").addEventListener("click", function() {
		alert("拍照");
		context.drawImage(video, 0, 0,$("#leftcanvas").width(), $("#leftcanvas").height());
	});

}, false);


function photo(id){
	var canvas = document.getElementById(id.replace('Photo','canvas')),
/*	var canvas = document.getElementById("leftcanvas"),
*/	context = canvas.getContext("2d"), video = document.getElementById("navy_video"), videoObj = {
		"video" : true
	}, errBack = function(error) {
		console.log("相机调用失败...", error.code);
	};

	if (navigator.getUserMedia) {
		navigator.getUserMedia(videoObj, function(stream) {
			video.src = stream;
			video.play();
		}, errBack);
	} else if (navigator.webkitGetUserMedia) {
		navigator.webkitGetUserMedia(videoObj, function(stream) {
			video.src = window.webkitURL.createObjectURL(stream);
			video.play();
		}, errBack);
	} else if(navigator.mozGetUserMedia) { 
        navigator.mozGetUserMedia(videoObj, function(stream){  
            video.src = window.URL.createObjectURL(stream);  
            video.play();  
        }, errBack);  
    }  
	//给对应id的 canvas标签赋值
	context.drawImage(video, 0, 0,$("#"+id.replace('Photo','canvas')+"").width(), $("#"+id.replace('Photo','canvas')+"").height());
	//给对应id的img标签赋值
	 document.getElementById(id.replace('Photo','')).src =document.getElementById(id.replace('Photo','canvas')).toDataURL("image/jpeg"); 
	 //给对应id的input标签赋值，用于向后台传值
	 $("#"+id.substring(0,1)).attr("value",document.getElementById(id.replace('Photo','canvas')).toDataURL("image/jpeg"));
	//重新加载video
	accessLocalWebCam("navy_video");
}



function convertCanvasToImage() {
	var pic = document.getElementById("canvas").toDataURL("image/png");
	pic = pic.replace(/^data:image\/(png|jpg);base64,/, "")

	$.ajaxFileUpload({
		url:'camera/savePhoto',
		//fileElementId:'canvas',
		data:{imageData:pic},
		dataType:'json',
		success:function(data,status){
			data=parseInt( $.trim(data));
			if(data==1){
				alert("图片上传成功...");
			}else{
				alert("图片上传失败...");
			}
		},
		error:function(data,status,e){
			alert("图片上传失败...");
		}
	});
}