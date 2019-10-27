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

import com.sys.entity.Idreader;
import com.sys.service.em.Idreaderservice;

/**
 * 二代身份证读卡器管理
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/idreader")
public class IdreaderController {
	@Autowired
	@Qualifier("idreaderservice")
	private Idreaderservice idreaderservice;
	@ResponseBody
	@RequestMapping(value="/addIdreader",method=RequestMethod.POST)
	public String  addIdreader(HttpServletRequest req,HttpServletResponse res,Idreader idreader) throws UnsupportedEncodingException {
		idreaderservice.addIdreader(idreader);
		return null;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/updateIdreader",method=RequestMethod.POST)
	public String  updateIdreader(HttpServletRequest req,HttpServletResponse res,Idreader idreader) throws UnsupportedEncodingException {
		idreaderservice.updateIdreader(idreader);
		return null;
	}
	@ResponseBody
	@RequestMapping(value="/deleteIdreader",method=RequestMethod.POST)
	public String  deleteIdreader(HttpServletRequest req,HttpServletResponse res,Idreader idreader) throws UnsupportedEncodingException {
		idreaderservice.deleteIdreader(idreader);
		return null;
	}
	
}
