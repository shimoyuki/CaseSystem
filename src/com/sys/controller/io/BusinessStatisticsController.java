package com.sys.controller.io;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.CaseStatistics;
import com.sys.entity.SuspectStatistics;
import com.sys.entity.User;
import com.sys.service.io.ArchivesManagementService;
import com.sys.service.io.BusinessStatisticsService;

import net.sf.json.JSONObject;

/**
 * 业务统计 郑羲贤
 * @author zhengxixian
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/businessStatistics")
public class BusinessStatisticsController {
	@Autowired
	@Qualifier("businessStatisticsService")
	private BusinessStatisticsService businessStatisticsService;
	
	@Autowired
	@Qualifier("archivesManagementService")
	private ArchivesManagementService archivesManagementService;
	
	
	/**
	 * 折线图--获取案件的类型以及对应的数量
	 * @param req
	 * @param res
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value="/getCaseAndNum",method=RequestMethod.POST)
	public String  getCaseAndNum(HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException {
		User user = (User) req.getSession().getAttribute("user");
		int  id = user.getPoliceID();
		List<CaseStatistics> caseStatisticsList = businessStatisticsService.getCaseAndNum(id);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		for (CaseStatistics csl : caseStatisticsList) {
			jsonMap.put(csl.getItemCaption(), csl.getCaseTypeNum());
		}
		return JSONObject.fromObject(jsonMap).toString();//json数组
		
	}
	/**
	 * 柱状图--获取历史嫌疑人--入区原因以及对应的数量
	 * @param req
	 * @param res
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value="/getSuspectAndNum",method=RequestMethod.POST)
	public String  getSuspectAndNum(HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException {
		User user = (User) req.getSession().getAttribute("user");
		int  id = user.getPoliceID();
		String code = archivesManagementService.getCodeByPoliceID(id);
		List<SuspectStatistics> suspectStatisticsList = businessStatisticsService.getSuspectAndNum(code);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		for (SuspectStatistics ssl : suspectStatisticsList) {
			jsonMap.put(ssl.getItemCaption(), ssl.getCauseCodeNum());
		}
		return JSONObject.fromObject(jsonMap).toString();//json数组
		
	}
	
	
	
}
