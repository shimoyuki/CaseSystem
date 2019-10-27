package com.sys.controller.userSet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.PoliceMan;
import com.sys.entity.User;
import com.sys.service.userSet.PersonInforService;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

@Scope("prototype")
@Controller
@RequestMapping("/personInfor")
public class PersonInforController {
	@Autowired
	@Qualifier("personInforService")
	private PersonInforService personInforService;
	//展示个人中心设置警员详细信息
	@ResponseBody
	@RequestMapping(value="/showPoliceInfor",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  showPoliceInfor(HttpServletRequest req) throws IOException{
		
		User user=(User)req.getSession().getAttribute("user");
		int ID=user.getPoliceID();
		PoliceMan police=personInforService.getpoliceInfor(String.valueOf(ID));
		return JSONObject.fromObject(police).toString();
	}
	//修改警员信息
	@ResponseBody
	@RequestMapping(value="/modifPersonInfor",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  modifPersonInfor(HttpServletRequest req, PoliceMan police) throws IOException{
		User user=(User)req.getSession().getAttribute("user");
		int ID=user.getPoliceID();
		police.setID(ID);
		String header ="data:image/jpeg;base64,"; 
		BASE64Decoder decoder = new BASE64Decoder();  
		try{
			if(police.getPicture()!=null&&!police.getPicture().trim().equals("")){
				String pitcture = police.getPicture().substring(header.length()); 
				byte[] pitcturedecodedBytes = decoder.decodeBuffer(pitcture);
				String pitcturePath ="D://images/"+ID+"police.jpg";//正面图片名:档案号+front
				FileOutputStream out = new FileOutputStream(pitcturePath);  
				out.write(pitcturedecodedBytes);  
				out.close();  
				police.setPicture(pitcturePath);//数据库保存图片存储路径
				personInforService.modifyPoliceInfor(police);
			}

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//获得用户登录名及拥有的角色
	@ResponseBody
	@RequestMapping(value="/showUserAndRoles",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  showUserAndRoles(HttpServletRequest req) throws IOException{
		
		User user=(User)req.getSession().getAttribute("user");
		int ID=user.getPoliceID();
		user=personInforService.getUserAndRole(ID);
		System.out.println("user:"+user);
		return JSONObject.fromObject(user).toString();
	}
	//获得用户登录名及拥有的角色
	
	@RequestMapping(value="/modifyPass",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public void  modifyPass(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setHeader("Content-Type", "text/xml; charset=utf-8");   
		PrintWriter pw=res.getWriter();
		User user=(User)req.getSession().getAttribute("user");
		int ID=user.getPoliceID();
		String oldPass=req.getParameter("oldPass");
		String newPass=req.getParameter("newPass");
		String confirmPass=req.getParameter("confirmPass");
		System.out.println("oldPass:"+oldPass+",newPass:"+newPass+",confirmPass:"+confirmPass);
		if(personInforService.confirmUserPass(String.valueOf(ID), oldPass)){//判断原始密码是否正确
			if(newPass==null||confirmPass==null||!confirmPass.equals(newPass)){//判断两次密码是否输入一致
				pw.write("确认密码不一致，请重新输入！");
				return ;
			}else{
				if(personInforService.modifyUserPass(String.valueOf(ID), newPass)){//判断数据库更新是否成功
					pw.write("密码修改成功！");
					return;
				}else{
					pw.write("未知错误，密码修改失败！");
					return;
				}
			}
			
		}
		pw.write("原密码错误，请重新输入！");
		return ;
	}
}
