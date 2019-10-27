package com.sys.controller.io;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sys.entity.PoliceStation;
import com.sys.service.io.StatusResportService;

import net.sf.json.JSONObject;

@Scope("prototype")
@Controller
@RequestMapping("/statusReport")
public class StatusReportController {
	@Autowired
	@Qualifier("statusResportService")
	private StatusResportService statusResportService;
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/showStatusResport",method=RequestMethod.POST)
	public String  showStatusResport(HttpServletRequest req) throws IOException{
		PoliceStation ps=(PoliceStation)req.getSession().getAttribute("policeStation");
		String identification=ps.getIdentification();
		String policeStation=ps.getPoliceStation();
		Map<String,Object> map=statusResportService.getStatisticsNumber(policeStation, identification);
		return JSONObject.fromObject(map).toString();
		
	}
	
	
}
