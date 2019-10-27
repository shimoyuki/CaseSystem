package com.sys.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sys.entity.PoliceMan;
import com.sys.entity.User;
import com.sys.service.IUserService;



@Scope("prototype")
@Controller
@RequestMapping("/user")
public class UserController {
  
	@Autowired
	@Qualifier("userService")
	private IUserService userService;




	@RequestMapping(value="/checkUser",method=RequestMethod.POST)
	public String  checkUser(User user,HttpSession httpSession){
		try {
			if(userService.checkUser(user,httpSession)){
				return "redirect:/user/main";
			}else{
				return "redirect:/user/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/user/login";
		}
	} 


	@RequestMapping(value="/main")
	public String main(HttpSession httpSession,Model model){
		if(httpSession.getAttribute("user")!=null){
			model.addAttribute("user",httpSession.getAttribute("user"));
			model.addAttribute("menu", httpSession.getAttribute("menu"));
			User user=(User) httpSession.getAttribute("user");
			PoliceMan policeMan=userService.getPoliceInfor(user.getId());
			model.addAttribute("policeMan",policeMan);
			return "GLXTSY";
		}else{
			return "login";
		}		
	} 

	@RequestMapping(value="/login")
	public String login(){
		return "login";
	} 
	/**
	 * 一级跳转
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/firstRedirection")
	public String firstRedirection(HttpServletRequest req,Model model){
		String page=req.getParameter("page");//跳转页面
		model.addAttribute("user",req.getSession().getAttribute("user"));
		model.addAttribute("menu",req.getSession().getAttribute("menu"));
		User user=(User) req.getSession().getAttribute("user");
		PoliceMan policeMan=userService.getPoliceInfor(user.getId());
		model.addAttribute("policeMan",policeMan);
		return page;
	} 
	/**
	 * 二级跳转
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/secondRedirection")
	public String secondRedirection(HttpServletRequest req,Model model){
		String page=req.getParameter("page");//跳转页面
		model.addAttribute("user",req.getSession().getAttribute("user"));
		model.addAttribute("menu",req.getSession().getAttribute("menu"));
		User user=(User) req.getSession().getAttribute("user");
		PoliceMan policeMan=userService.getPoliceInfor(user.getId());
		model.addAttribute("policeMan",policeMan);
		return page;
	} 
	@RequestMapping(value="/directAccess")
	public String directAccess(HttpServletRequest req,Model model){
		HttpSession ss=req.getSession();
		ss.setAttribute("user", new User());
		//model.addAttribute("user",new User());
		return "io/noLogin/houAskedRoom";
	} 
}
