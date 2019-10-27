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

import com.sys.entity.AccessCard;
import com.sys.service.em.AccessCardService;

/**
 * 门禁卡管理
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/accessCard")
public class AccessCardController {
	@Autowired
	@Qualifier("accessCardService")
	private AccessCardService accessCardService;
	
	@ResponseBody
	@RequestMapping(value="/addAccessCard",method=RequestMethod.POST)
	public String  addAccessCard(HttpServletRequest req,HttpServletResponse res,AccessCard accessCard) throws UnsupportedEncodingException {
		accessCardService.addAccessCard(accessCard);
		return null;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/updateAccessCard",method=RequestMethod.POST)
	public String  updateAccessCard(HttpServletRequest req,HttpServletResponse res,AccessCard accessCard) throws UnsupportedEncodingException {
		accessCardService.updateAccessCard(accessCard);
		return null;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteAccessCard",method=RequestMethod.POST)
	public String  deleteAccessCard(HttpServletRequest req,HttpServletResponse res,AccessCard accessCard) throws UnsupportedEncodingException {
		accessCardService.deleteAccessCard(accessCard);
		return null;
		
	}
}
