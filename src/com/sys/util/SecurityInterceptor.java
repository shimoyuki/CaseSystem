package com.sys.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sys.entity.User;
/**
 * 未登录拦截
 * @author 佘开 伟
 *
 */
public class SecurityInterceptor implements HandlerInterceptor {

	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HttpSession session = request.getSession(true);
        //用户信息
        User user = (User)session.getAttribute("user");
        String returnUrl = request.getRequestURI();
        //用户信息失效
        if(user == null){
        	
        	if(returnUrl.equals("/CaseSystem/user/checkUser")||returnUrl.equals("/CaseSystem/user/login")){
        		 return true;
        	}
        	if(returnUrl.equals("/CaseSystem/user/directAccess")){//直接登录的界面，信息采集，人身安全检查，侯问室
        		return true;
        	}
            //request.getRequestDispatcher("/login.html").forward(request, response);
        	response.sendRedirect(request.getContextPath()+"/user/login");
            return false;
            //测试
            
        }
        return true;
	}

}
