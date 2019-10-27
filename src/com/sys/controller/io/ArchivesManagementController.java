package com.sys.controller.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.java_cup.internal.runtime.Symbol;
import com.sys.entity.Case;
import com.sys.entity.CaseCriminal;
import com.sys.entity.CasePoliceman;
import com.sys.entity.CaseVictim;
import com.sys.entity.CaseWitness;
import com.sys.entity.CurrentSuspectsList;
import com.sys.entity.Infoheader;
import com.sys.entity.User;
import com.sys.service.io.ArchivesManagementService;
import com.sys.util.Tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 档案管理 
 * @author zhengxixian
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/archivesManagement")
public class ArchivesManagementController {
	
	
	@Autowired
	@Qualifier("archivesManagementService")
	private ArchivesManagementService archivesManagementService;
	
	
	/**
	 * 获取当前在区的嫌疑人。郑羲贤
	 * @param req
	 * @param res
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value="/getCurrentSuspects",method=RequestMethod.POST)
	public String  getCurrentSuspects(HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String curentTime = df.format(new Date());
		System.out.println(curentTime);// new Date()为获取当前系统时间
		List<Infoheader> infoheader=archivesManagementService.getCurrentSuspects(curentTime);
		return JSONArray.fromObject(infoheader).toString();//json数组
		
	}
	/**
	 * 获取当前嫌疑人的列表，，，还有案件的名字等信息。。。。郑羲贤
	 * @param req
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Transactional
	@ResponseBody
	@RequestMapping(value="/getCurrentSuspectsList",method=RequestMethod.POST)
	public String  getCurrentSuspectsList(HttpServletRequest req,@RequestParam("pageSize") int pageSize,@RequestParam("pageNumber") int pageNumber) throws UnsupportedEncodingException {
		User user = (User) req.getSession().getAttribute("user");
		int  id = user.getPoliceID();
		String code = archivesManagementService.getCodeByPoliceID(id);
		String causeCode=req.getParameter("causeCode");
		String tempOutCause=req.getParameter("tempOutCause");
		String entryTime=req.getParameter("entryTime");
		System.out.println(code+":"+causeCode+":"+tempOutCause+":"+entryTime);
		Map<String,Object> recordFilter = new HashMap<String,Object>();
		recordFilter.put("causeCode", causeCode);
		recordFilter.put("tempOutCause", tempOutCause);
		recordFilter.put("entryTime", entryTime);
		recordFilter.put("code", code);
		System.out.println("pageSize:"+pageSize+" pageNumber:"+pageNumber);
		int intPage = pageNumber == 0 ? 1:pageNumber; 
		int number = pageSize == 0 ? 10:pageSize;
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<CurrentSuspectsList> goodsList=archivesManagementService.getCurrentSuspectsList(recordFilter,intPage,number);
		int total=archivesManagementService.getCurrentSuspectsTotal(recordFilter);
		jsonMap.put("res", goodsList);//对应前台bootstrap的 dataField: "res"
		jsonMap.put("total",total);
		JsonConfig jsonConfig=Tools.getJsonConfig();
		jsonConfig.setExcludes(new String[]{}); 
		JSONObject jsonObject= JSONObject.fromObject(jsonMap,jsonConfig);
		return jsonObject.toString();
		
	}
	/**
	 * 档案报告显示
	 * @param req
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/showRecordReport")
	public String showRecordReport(HttpServletRequest req,Model model) throws IOException{
		String recordNumber= req.getParameter("recordNumber");//获得前台传过来的数组
		System.out.println("档案号："+recordNumber);
		model=archivesManagementService.showReport(recordNumber, model);
		return "io/recordReport";
	}
}
