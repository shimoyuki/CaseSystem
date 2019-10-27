package com.sys.controller.io;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.FinallyLeave;
import com.sys.service.io.FinallyLeaveService;

/**
 * 最终离开办案区
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/finallyLeave")
public class FinallyLeaveController {
	@Autowired
	@Qualifier("finallyLeaveService")
	private FinallyLeaveService finallyLeaveService;
	
	@ResponseBody
	@RequestMapping(value="/SaveInforCollection",method=RequestMethod.POST)
	public String  SaveInforCollection(HttpServletRequest req,FinallyLeave finallyLeave){
		System.out.println("finallyLeave:"+finallyLeave);
		finallyLeaveService.saveFinallyLeave(finallyLeave);
		return null;
		
	}
}
