package com.sys.controller.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sys.dao.IUserDao;
import com.sys.entity.User;




@Aspect  
public class AOPController {  

	@Autowired
	@Qualifier("userDao")
	private  IUserDao userDao;



	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Pointcut("execution(* com.sys.service.Impl.*.*(..))")  
	public void foundService(){
	}  

	@Pointcut("execution(* com.sys.controller.*.*(..))")  
	public void foundController(){
	}  

	@Before(value="foundService()")  
	public void foundServiceBefore(){  
		System.out.println("切到了service层");
	}  
	@Before(value="foundController()")  
	public void foundControllerBefore(){  
		System.out.println("切到了controller层");
	}  

	@AfterReturning(pointcut="foundService() && args(..)",returning="returnValue")  
	public void foundServiceAfter(JoinPoint joinPoint,Object returnValue){
		//(joinPoint.getArgs()[0])获得第一个参数的值
		String fuctionName=joinPoint.getSignature().getName();
		System.out.println("fuctionName:"+fuctionName);
		//观测checkuser函数的发生
		if(fuctionName.equals("checkUser")){
			User newuser=(User)(joinPoint.getArgs()[0]);
			System.out.println(newuser);
		}


	}

}  
