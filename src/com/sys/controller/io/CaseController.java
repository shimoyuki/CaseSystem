package com.sys.controller.io;

import java.io.IOException;
import java.util.ArrayList;
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

import com.sys.entity.Case;
import com.sys.entity.CaseCriminal;
import com.sys.entity.CasePoliceman;
import com.sys.entity.CaseVictim;
import com.sys.entity.CaseWitness;
import com.sys.entity.Infoheader;
import com.sys.entity.PoliceMan;
import com.sys.entity.PoliceStation;
import com.sys.entity.User;
import com.sys.service.io.CaseService;
import com.sys.util.Tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Scope("prototype")
@Controller
@RequestMapping("/lawcase")
public class CaseController {
	@Autowired
	@Qualifier("caseService")
	private CaseService caseService;
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/getEntryPerson",method=RequestMethod.POST)
	public String getEntryPerson(HttpServletRequest res,HttpServletResponse req){
		String policeStation=res.getParameter("policeStation");//字段名
		List<Infoheader> infoHeader=caseService.getEntryPerson(policeStation);
		JSONArray json = new JSONArray();
		for(Infoheader e:infoHeader){
			 JSONObject jo = new JSONObject();
			jo.put("name", e.getName()+"|"+e.getIDCode());
			jo.put("code", e.getIDCode());
			json.add(jo);
		}
		return json.toString();
	}
	@Transactional
	@ResponseBody
	@RequestMapping(value="/getpoliceman",method=RequestMethod.POST)
	public String getpoliceman(HttpServletRequest res,HttpServletResponse req){
		String policeStation=res.getParameter("policeStation");//字段名
		List<PoliceMan> police=caseService.getpoliceman(policeStation);
		JSONArray json = new JSONArray();
		for(PoliceMan e:police){
			 JSONObject jo = new JSONObject();
			jo.put("name", e.getName()+"|"+e.getID());
			jo.put("code", e.getID());
			json.add(jo);
		}
		
		return json.toString();
	}
	/**
	 * 保存和修改 案件
	 * @param req
	 * @param Case
	 * @param caseCriminal
	 * @param caseWitness
	 * @param caseVictim
	 * @param casePoliceman
	 * @return
	 */
	@Transactional
	@ResponseBody
	@RequestMapping(value="/saveAndModifyCase",method=RequestMethod.POST)
	public String saveAndModifyCase(HttpServletRequest req,Case Case,CaseCriminal caseCriminal,CaseWitness
			caseWitness,CaseVictim caseVictim,CasePoliceman casePoliceman,@RequestParam("caseID") String caseD){
		System.out.println("caseDasdassd:"+caseD);
		PoliceStation policeStation=(PoliceStation) req.getSession().getAttribute("policeStation");
		String station=policeStation.getPoliceStation();
		Case.setPoliceStation(station);
		if(caseD==null&&caseD.trim().equals("")){//caseD等于空表明为新增.
			caseService.saveCase(Case);
			int caseID=Case.getID();
			//嫌疑人
			String[] cc=caseCriminal.getcIDCode().split(",");
			List<CaseCriminal> caseCriminalList=new ArrayList<CaseCriminal>();
			for(int i=0;i<cc.length;i++){
				CaseCriminal c=new CaseCriminal();
				c.setCaseID(caseID);
				c.setcIDCode(cc[i]);
				caseCriminalList.add(c);
			}
			caseService.saveCaseCriminal(caseCriminalList);
			//证人
			String[] cw=caseWitness.getwIDCode().split(",");//嫌疑人
			List<CaseWitness> caseWitnessList=new ArrayList<CaseWitness>();
			for(int i=0;i<cw.length;i++){
				CaseWitness c=new CaseWitness();
				c.setCaseID(caseID);
				c.setwIDCode(cw[i]);
				caseWitnessList.add(c);
			}
			caseService.saveCaseWitness(caseWitnessList);
			//被害人
			String[] cv=caseVictim.getvIDCode().split(",");//嫌疑人
			List<CaseVictim> caseVictimList=new ArrayList<CaseVictim>();
			for(int i=0;i<cv.length;i++){
				CaseVictim c=new CaseVictim();
				c.setCaseID(caseID);
				c.setvIDCode(cv[i]);
				caseVictimList.add(c);
			}
			caseService.saveCaseVictim(caseVictimList);
			//办案组员
			String[] cp=casePoliceman.getPoliceID().split(",");//嫌疑人
			List<CasePoliceman> casePolicemanList=new ArrayList<CasePoliceman>();
			for(int i=0;i<cp.length;i++){
				CasePoliceman c=new CasePoliceman();
				c.setCaseID(caseID);
				c.setPoliceID(cp[i]);
				casePolicemanList.add(c);
			}
			caseService.saveCasePoliceman(casePolicemanList);
		}else{//caseD有值表示修改案件
			int caseId=Integer.parseInt(caseD);
			Case.setID(caseId);
			caseService.modifyCase(Case);//先修改Case表，对应嫌疑人，证人，被害人，办案组员表采用先删除再增加方式
			//嫌疑人
			String[] cc=caseCriminal.getcIDCode().split(",");
			List<CaseCriminal> caseCriminalList=new ArrayList<CaseCriminal>();
			for(int i=0;i<cc.length;i++){
				CaseCriminal c=new CaseCriminal();
				c.setCaseID(caseId);
				c.setcIDCode(cc[i]);
				caseCriminalList.add(c);
			}
			caseService.saveCaseCriminal(caseCriminalList);
			//证人
			String[] cw=caseWitness.getwIDCode().split(",");//嫌疑人
			List<CaseWitness> caseWitnessList=new ArrayList<CaseWitness>();
			for(int i=0;i<cw.length;i++){
				CaseWitness c=new CaseWitness();
				c.setCaseID(caseId);
				c.setwIDCode(cw[i]);
				caseWitnessList.add(c);
			}
			caseService.saveCaseWitness(caseWitnessList);
			//被害人
			String[] cv=caseVictim.getvIDCode().split(",");//嫌疑人
			List<CaseVictim> caseVictimList=new ArrayList<CaseVictim>();
			for(int i=0;i<cv.length;i++){
				CaseVictim c=new CaseVictim();
				c.setCaseID(caseId);
				c.setvIDCode(cv[i]);
				caseVictimList.add(c);
			}
			caseService.saveCaseVictim(caseVictimList);
			//办案组员
			String[] cp=casePoliceman.getPoliceID().split(",");//嫌疑人
			List<CasePoliceman> casePolicemanList=new ArrayList<CasePoliceman>();
			for(int i=0;i<cp.length;i++){
				CasePoliceman c=new CasePoliceman();
				c.setCaseID(caseId);
				c.setPoliceID(cp[i]);
				casePolicemanList.add(c);
			}
			caseService.saveCasePoliceman(casePolicemanList);
		}

		return null;
	}
	/**
	 * 查找筛选案件
	 * @param req
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/getCasebycondition",method=RequestMethod.POST)
	public String getCasebycondition(HttpServletRequest req,@RequestParam("pageSize") int pageSize,@RequestParam("pageNumber") int pageNumber) throws IOException{
		int intPage = pageNumber == 0 ? 1:pageNumber; 
		int intSize = pageSize == 0 ? 10:pageSize;;
		Map<String,Object> caseFilter=new HashMap<String,Object>();
		String caseState=req.getParameter("caseState");
		String caseType=req.getParameter("caseType");
		String number=req.getParameter("number");
		PoliceStation ps=(PoliceStation) req.getSession().getAttribute("policeStation");
		String policeStation=ps.getPoliceStation();
		User user=(User) req.getSession().getAttribute("user");
		String policeID=""+user.getPoliceID();
		caseFilter.put("caseState", caseState);
		caseFilter.put("caseType", caseType);
		caseFilter.put("number", number);
		caseFilter.put("policeStation", policeStation);
		caseFilter.put("policeID", policeID);
		System.out.println("查询条件："+caseFilter);
		List<Case> caseList=caseService.findCaseBycondition(caseFilter,intPage,intSize);
		int total=caseService.getCaseNumberBycondition(caseFilter);
		List< Map<String, Object>> mapList=new ArrayList< Map<String, Object>>();
		for(Case c:caseList){//将查出的实体类集合转换成map集合再传给前台
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("name",c.getName());
			 map.put("startTime", c.getStartTime());
			 map.put("leaderID", c.getLeaderID());
			 map.put("ID",c.getID());
			 map.put("caseState", c.getCaseState());
			 map.put("caseType", c.getCaseType());
			 //将CaseCriminal集合的属性之一name放入map
			 List<CaseCriminal> cclist=c.getCaseCriminal();
			 List<String> ccname=new ArrayList<>(10);
			 for(CaseCriminal cc:cclist){
				 ccname.add(cc.getName());
			 }
			 map.put("caseCriminal", ccname.toString());
			 //将CaseVictim集合的属性之一name放入map
			 List<CaseVictim> cvlist=c.getCaseVictim();
			 List<String> cvname=new ArrayList<>(10);
			 for(CaseVictim cv:cvlist){
				 cvname.add(cv.getName());
			 }
			 map.put("caseVictim", cvname.toString());
			 //将CaseWitness集合的属性之一name放入map
			 List<CaseWitness> cwlist=c.getCaseWitness();
			 List<String> cwname=new ArrayList<>(10);
			 for(CaseWitness cw:cwlist){
				 cwname.add(cw.getName());
			 }
			 map.put("caseWitness", cwname.toString());
			 //将CaseWitness集合的属性之一name放入map
			 List<CasePoliceman> cplist=c.getCasePoliceman();
			 List<String> cpname=new ArrayList<>(10);
			 for(CasePoliceman cp:cplist){
				 cpname.add(cp.getName());
			 }
			 map.put("casePoliceman", cpname.toString());
			 
			 mapList.add(map);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("res", mapList);//对应前台bootstrap的 dataField: "res"
		jsonMap.put("total",total);
		JsonConfig jsonConfig=Tools.getJsonConfig();
		jsonConfig.setExcludes(new String[]{}); 
		JSONObject jsonObject= JSONObject.fromObject(jsonMap,jsonConfig);
		return jsonObject.toString();
	}
	/**
	 * 删除案件
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/deleteCase",method=RequestMethod.POST)
	public String deleteCase(HttpServletRequest req) throws IOException{
		String[] ids = req.getParameterValues("idList");//获得前台传过来的数组
		System.out.println("idList:"+ids[0]);
		caseService.deleteCaseByid(ids);
		return null;
		
	}
	/**
	 * 根据ID查找案件详情
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/findCaseDetails",method=RequestMethod.POST)
	public String findCaseDetails(HttpServletRequest req) throws IOException{
		String id = req.getParameter("id");//获得前台传过来的数组
		Case c=caseService.findCaseByID(Integer.parseInt(id));
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("name",c.getName());
		 map.put("startTime", c.getStartTime());
		 map.put("leaderID", c.getLeaderID());
		 map.put("ID",c.getID());
		 map.put("code", c.getCode());
		 map.put("caseNo", c.getCaseNo());
		 map.put("storageLoc", c.getStorageLoc());
		 map.put("finishTime", c.getFinishTime());
		 map.put("caseType", c.getCaseType());
		 map.put("caseState", c.getCaseState());
		 map.put("caseDescribe", c.getCaseDescribe());
		 map.put("policeStation", c.getPoliceStation());
		 //将CaseCriminal集合的属性之一name放入map
		 List<CaseCriminal> cclist=c.getCaseCriminal();
		 List<String> ccname=new ArrayList<>(10);
		 for(CaseCriminal cc:cclist){
			 ccname.add(cc.getcIDCode());
		 }
		 map.put("caseCriminal", ccname.toString().replaceAll(" ", ""));
		 //将CaseVictim集合的属性之一name放入map
		 List<CaseVictim> cvlist=c.getCaseVictim();
		 List<String> cvname=new ArrayList<>(10);
		 for(CaseVictim cv:cvlist){
			 cvname.add(cv.getvIDCode());
		 }
		 map.put("caseVictim", cvname.toString().replaceAll(" ", ""));
		 //将CaseWitness集合的属性之一name放入map
		 List<CaseWitness> cwlist=c.getCaseWitness();
		 List<String> cwname=new ArrayList<>(10);
		 for(CaseWitness cw:cwlist){
			 cwname.add(cw.getwIDCode());
		 }
		 map.put("caseWitness", cwname.toString().replaceAll(" ", ""));
		 //将CasePoliceman集合的属性之一name放入map
		 List<CasePoliceman> cplist=c.getCasePoliceman();
		 List<String> cpname=new ArrayList<>(10);
		 for(CasePoliceman cp:cplist){
			 cpname.add(cp.getPoliceID());
		 }
		 map.put("casePoliceman", cpname.toString().replaceAll(" ", ""));
		return JSONObject.fromObject(map).toString();
	}
	/**
	 * 根据ID展现案件报告
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/showCaseReport")
	public String showCaseReport(HttpServletRequest req,Model model) throws IOException{
		String id = req.getParameter("id");//获得前台传过来的数组
		Case c=caseService.findCaseByID(Integer.parseInt(id));
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("name",c.getName());
		 map.put("startTime", c.getStartTime());
		 map.put("leaderID", c.getLeaderID());
		 map.put("ID",c.getID());
		 map.put("code", c.getCode());
		 map.put("caseNo", c.getCaseNo());
		 map.put("storageLoc", c.getStorageLoc());
		 map.put("finishTime", c.getFinishTime());
		 map.put("caseType", c.getCaseType());
		 map.put("caseState", c.getCaseState());
		 map.put("caseDescribe", c.getCaseDescribe());
		 map.put("policeStation", c.getPoliceStation());
		 //将CaseCriminal集合放入map
		 List<CaseCriminal> cclist=c.getCaseCriminal();
		 map.put("caseCriminal", cclist);
		 map.put("ccNum", cclist.size());
		 //将CaseVictim集合放入map
		 List<CaseVictim> cvlist=c.getCaseVictim();
		 map.put("caseVictim", cvlist);
		 map.put("cvNum", cvlist.size());
		 //将CaseWitness集合放入map
		 List<CaseWitness> cwlist=c.getCaseWitness();
		 map.put("caseWitness", cwlist);
		 map.put("cwNum", cwlist.size());
		 //将CasePoliceman集合放入map
		 List<CasePoliceman> cplist=c.getCasePoliceman();
		 map.put("casePoliceman", cplist);
		 map.put("cpNum", cplist.size()+1);
		 
		 model.addAttribute("caseReport",map);
		return "io/caseReport";
	}
}
