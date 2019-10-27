package com.sys.controller.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import sun.misc.BASE64Decoder;

/**
 * 调用摄像头拍照后保存图片
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("camera")
public class CameraController{	
	private PrintWriter out;
	@ResponseBody
	@RequestMapping(value="/savePhoto",method=RequestMethod.POST)
	public void savePhoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			out=response.getWriter();
//			前台获得图片信息
			String imageData = request.getParameter("imageData"); 
			BASE64Decoder base64=new BASE64Decoder(); 
			
			//64位解码  
			byte[] buffer=base64.decodeBuffer(imageData);

			//写进文件  
			String filPath="D://images/"+new Date().getTime()+""+new Random().nextInt(100000)+".jpg";
			FileOutputStream fos=new FileOutputStream(filPath);  
			System.out.println("图片路径："+filPath);
			fos.write(buffer);  
			fos.flush();  
			fos.close();  
			fos=null;  
			out.print(1);
		} catch (Exception e) {
			e.printStackTrace();
			out.print(0);
		}
		out.flush();
		out.close();
	}

}
