package com.sys.controller.em;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.Locker;
import com.sys.service.em.LockerService;

/**
 * 储物柜设备管理
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/locker")
public class LockerController {
	@Autowired
	@Qualifier("lockerService")
	private LockerService lockerService;
	
	@ResponseBody
	@RequestMapping(value="/addLocker",method=RequestMethod.POST)
	public String  addLocker(HttpServletRequest req,HttpServletResponse res,Locker locker) throws UnsupportedEncodingException {
		lockerService.addLocker(locker);
		return null;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/updateLocker",method=RequestMethod.POST)
	public String  updateLocker(HttpServletRequest req,HttpServletResponse res,Locker locker) throws UnsupportedEncodingException {
		lockerService.updateLocker(locker);
		return null;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteLocker",method=RequestMethod.POST)
	public String  deleteLocker(HttpServletRequest req,HttpServletResponse res,Locker locker) throws UnsupportedEncodingException {
		lockerService.deleteLocker(locker);
		return null;
		
	}
}
