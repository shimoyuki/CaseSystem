package com.sys.controller.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.CheckGoods;
import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.Goodsinspect_dutypolice;
import com.sys.entity.Goodsinspect_party;
import com.sys.entity.Goodsinspect_police;
import com.sys.entity.PersonScrutiny;
import com.sys.entity.ScarDetail;
import com.sys.entity.ScarImg;
import com.sys.entity.ScarInspectParty;
import com.sys.entity.ScarInspectPolice;
import com.sys.entity.TempoutPolicemen;
import com.sys.service.io.SafetyCheckService;
import com.sys.util.Tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import sun.misc.BASE64Decoder;

/**
 * 人身安全检查
 * @author zhengxixian
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/safetyCheck")
public class SafetyCheckController {

	@Autowired
	@Qualifier("safetyCheckservice")
	private SafetyCheckService safetyCheckservice;

	/**
	 * 保存人身安全检查的自诉情况  郑羲贤
	 * @param personScrutiny
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/saveSafetyCheckInfo",method=RequestMethod.POST)
	public void saveSafetyCheckInfo(PersonScrutiny personScrutiny,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
//			personScrutiny.setRecordNumber("12345");
			safetyCheckservice.saveSafetyCheckInfo(personScrutiny);	
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}

	} 

	/**
	 * 页面显示伤情的说明区的数据。
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value="/getScarExplain",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String getScarExplain(HttpServletRequest req,@RequestParam("pageSize") int pageSize,@RequestParam("pageNumber") int pageNumber) {
		String recordNumber=req.getParameter("recordNumber");
		System.out.println("pageSize:"+pageSize+" pageNumber:"+pageNumber);
		int intPage = pageNumber == 0 ? 1:pageNumber; 
		int number = pageSize == 0 ? 10:pageSize;
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<ScarDetail> scarExplainList=safetyCheckservice.getScarExplainList(recordNumber,intPage,number);
		int total=safetyCheckservice.getScarExplainTotal(recordNumber);
		jsonMap.put("res", scarExplainList);//对应前台bootstrap的 dataField: "res"
		jsonMap.put("total",total);
		JsonConfig jsonConfig=Tools.getJsonConfig();
		jsonConfig.setExcludes(new String[]{}); 
		JSONObject jsonObject= JSONObject.fromObject(jsonMap,jsonConfig);
		return jsonObject.toString();
		//return jsonMap;

	}




	/**
	 * 获取物品登记列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getGoodsList",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String getGoodsList(HttpServletRequest req,@RequestParam("pageSize") int pageSize,@RequestParam("pageNumber") int pageNumber) {
		String recordNumber=req.getParameter("recordNumber");
		System.out.println("pageSize:"+pageSize+" pageNumber:"+pageNumber);
		int intPage = pageNumber == 0 ? 1:pageNumber; 
		int number = pageSize == 0 ? 10:pageSize;
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<CheckGoods> goodsList=safetyCheckservice.getGoodsList(recordNumber,intPage,number);
		int total=safetyCheckservice.getGoodsTotal(recordNumber);
		jsonMap.put("res", goodsList);//对应前台bootstrap的 dataField: "res"
		jsonMap.put("total",total);
		JsonConfig jsonConfig=Tools.getJsonConfig();
		jsonConfig.setExcludes(new String[]{}); 
		JSONObject jsonObject= JSONObject.fromObject(jsonMap,jsonConfig);
		return jsonObject.toString();
		//return jsonMap;

	}

	/**
	 * 保存涉案人员随身物品检查登记
	 * @param checkGoods
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/saveHisBelongings",method=RequestMethod.POST)
	public void saveHisBelongings(CheckGoods checkGoods, HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			safetyCheckservice.saveHisBelongings(checkGoods);
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");
		}
	} 
	/**
	 * 批量删除物品 郑羲贤
	 * @param list
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/deleteHisBelongings",method=RequestMethod.POST)
	public void deleteHisBelongings(@RequestParam("datalist")String list,HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			String datalist = request.getParameter("datalist");
			System.out.println("list:"+datalist);
			JSONArray array = JSONArray.fromObject(datalist);
			List<CheckGoods> idList = new ArrayList<CheckGoods>();
			for (int i = 0; i < array.size(); i++) {
				CheckGoods cg = new CheckGoods();
				@SuppressWarnings("rawtypes")
				Map jsonObject = array.getJSONObject(i); 
				int id = Integer.parseInt(""+jsonObject.get("id"));
				cg.setId(id);
				idList.add(cg);
			}
			safetyCheckservice.deleteHisBelongings(idList);
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");
		}
	} 


	/**
	 * 伤痕检查-业务干警签名  被检查/监护人签名 保存 郑羲贤
	 * @param scarInspectPolice
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/saveInjurySignature",method=RequestMethod.POST)
	public void saveInjurySignature(ScarInspectPolice scarInspectPolice, ScarInspectParty scarInspectParty, HttpServletResponse res,HttpServletRequest req) throws IOException{
		PrintWriter pw=res.getWriter();
		try {
			String recordNumber = scarInspectPolice.getRecordNumber();
			System.out.println(recordNumber);
			String[] nameList=scarInspectPolice.getScarPolice().split(",");
			String[] codeList=scarInspectPolice.getCode().split(",");
			List<ScarInspectPolice> tpList=new ArrayList<ScarInspectPolice>();
			for(int i=0;i<nameList.length;i++){
				ScarInspectPolice sp=new ScarInspectPolice();
				sp.setCode(codeList[i]);
				sp.setScarPolice(nameList[i]);
				sp.setRecordNumber(recordNumber);
				tpList.add(sp);
			}
			safetyCheckservice.savePolicemenSignature(tpList);//业务干警签名
			safetyCheckservice.saveReviewedSignature(scarInspectParty);//被检查、监护人签名
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");
		}
	} 
	/**
	 * 随身物品检查--签名保存 郑羲贤
	 * @param goodsinspect_party
	 * @param goodsinspect_police
	 * @param goodsinspect_dutypolice
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/saveGoodsSignature",method=RequestMethod.POST)
	public void saveGoodsSignature(Goodsinspect_party goodsinspect_party, Goodsinspect_police goodsinspect_police,
			Goodsinspect_dutypolice goodsinspect_dutypolice,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			
			String recordNumber = goodsinspect_party.getRecordNumber();
			System.out.println(recordNumber);
			String[] nameList=goodsinspect_police.getGoodsPolice().split(",");
			String[] codeList=goodsinspect_police.getCode().split(",");
			List<Goodsinspect_police> gpList=new ArrayList<Goodsinspect_police>();
			for(int i=0;i<nameList.length;i++){
				Goodsinspect_police gp=new Goodsinspect_police();
				gp.setCode(codeList[i]);
				gp.setGoodsPolice(nameList[i]);
				gp.setRecordNumber(recordNumber);
				gpList.add(gp);
			}
			
			String[] dutynameList=goodsinspect_dutypolice.getDutyPolice().split(",");
			String[] dutycodeList=goodsinspect_dutypolice.getDutyCode().split(",");
			List<Goodsinspect_dutypolice> gdpList=new ArrayList<Goodsinspect_dutypolice>();
			for(int i=0;i<dutynameList.length;i++){
				Goodsinspect_dutypolice gdp=new Goodsinspect_dutypolice();
				gdp.setDutyCode(dutycodeList[i]);
				gdp.setDutyPolice(dutynameList[i]);
				gdp.setRecordNumber(recordNumber);
				gdpList.add(gdp);
			}

			safetyCheckservice.saveGoodsinspect_police(gpList);//保存业务干警签字
			safetyCheckservice.saveGoodsinspect_dutypolice(gdpList);//保存值班干警签字
			safetyCheckservice.saveGoodsinspect_party(goodsinspect_party);//保存被检查人签字
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");
		}
	} 


	/**
	 * 标记伤痕之后保存伤痕 zxx
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/saveScarTreatment",method=RequestMethod.POST)
	public void saveScarTreatment(HttpServletRequest request,HttpServletResponse response,ScarDetail scarDetail,ScarImg scarImg) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			System.out.println(scarImg.getScarFigure());
			String scarExplain = scarDetail.getScarArea()+":"+scarDetail.getScarPart()+scarDetail.getScarType();
			scarDetail.setScarExplain(scarExplain);
			safetyCheckservice.saveScarTreatment(scarDetail);
			int id = scarDetail.getId();
			System.out.println("I1111111DDDD:"+id);

			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}
	} 
	@ResponseBody
	@RequestMapping(value="/showPoliceSigned",method=RequestMethod.POST)
	public String  showPoliceSigned(HttpServletRequest req) throws IOException{
		String recordNumber=req.getParameter("recordNumber");
		List<EntryPolicemen>  epList=safetyCheckservice.getEntryPolice(recordNumber);
		EntryDutypolice edp=safetyCheckservice.getEntryDutyPolice(recordNumber);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("police", epList);//对应前台bootstrap的 dataField: "res"
		jsonMap.put("dutyPolice",edp);
		JsonConfig jsonConfig=Tools.getJsonConfig();
		jsonConfig.setExcludes(new String[]{}); 
		JSONObject jsonObject= JSONObject.fromObject(jsonMap,jsonConfig);
		return  jsonObject.toString();
		
	}

}
